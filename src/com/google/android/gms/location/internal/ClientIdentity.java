package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class ClientIdentity
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  private final int mVersionCode;
  public final String packageName;
  public final int uid;
  
  ClientIdentity(int paramInt1, int paramInt2, String paramString)
  {
    mVersionCode = paramInt1;
    uid = paramInt2;
    packageName = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof ClientIdentity))) {
        return false;
      }
      paramObject = (ClientIdentity)paramObject;
    } while ((uid == uid) && (zzw.equal(packageName, packageName)));
    return false;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    return uid;
  }
  
  public String toString()
  {
    return String.format("%d:%s", new Object[] { Integer.valueOf(uid), packageName });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.ClientIdentity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */