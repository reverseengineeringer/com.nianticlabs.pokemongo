package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class TokenData
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  final int mVersionCode;
  private final Long zzRA;
  private final boolean zzRB;
  private final boolean zzRC;
  private final List<String> zzRD;
  private final String zzRz;
  
  TokenData(int paramInt, String paramString, Long paramLong, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList)
  {
    mVersionCode = paramInt;
    zzRz = zzx.zzcr(paramString);
    zzRA = paramLong;
    zzRB = paramBoolean1;
    zzRC = paramBoolean2;
    zzRD = paramList;
  }
  
  public static TokenData zza(Bundle paramBundle, String paramString)
  {
    paramBundle.setClassLoader(TokenData.class.getClassLoader());
    paramBundle = paramBundle.getBundle(paramString);
    if (paramBundle == null) {
      return null;
    }
    paramBundle.setClassLoader(TokenData.class.getClassLoader());
    return (TokenData)paramBundle.getParcelable("TokenData");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof TokenData)) {}
    do
    {
      return false;
      paramObject = (TokenData)paramObject;
    } while ((!TextUtils.equals(zzRz, zzRz)) || (!zzw.equal(zzRA, zzRA)) || (zzRB != zzRB) || (zzRC != zzRC) || (!zzw.equal(zzRD, zzRD)));
    return true;
  }
  
  public String getToken()
  {
    return zzRz;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzRz, zzRA, Boolean.valueOf(zzRB), Boolean.valueOf(zzRC), zzRD });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public Long zzlA()
  {
    return zzRA;
  }
  
  public boolean zzlB()
  {
    return zzRB;
  }
  
  public boolean zzlC()
  {
    return zzRC;
  }
  
  public List<String> zzlD()
  {
    return zzRD;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.TokenData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */