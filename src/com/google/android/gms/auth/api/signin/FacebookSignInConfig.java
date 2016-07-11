package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;

public class FacebookSignInConfig
  implements SafeParcelable
{
  public static final Parcelable.Creator<FacebookSignInConfig> CREATOR = new zzb();
  private Intent mIntent;
  final int versionCode;
  private final ArrayList<String> zzSX;
  
  public FacebookSignInConfig()
  {
    this(1, null, new ArrayList());
  }
  
  FacebookSignInConfig(int paramInt, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    versionCode = paramInt;
    mIntent = paramIntent;
    zzSX = paramArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramObject = (FacebookSignInConfig)paramObject;
        if (zzSX.size() == ((FacebookSignInConfig)paramObject).zzlS().size())
        {
          boolean bool = zzSX.containsAll(((FacebookSignInConfig)paramObject).zzlS());
          if (bool) {
            return true;
          }
        }
      }
      catch (ClassCastException paramObject) {}
    }
    return false;
  }
  
  public int hashCode()
  {
    Collections.sort(zzSX);
    return zzSX.hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public Intent zzlR()
  {
    return mIntent;
  }
  
  public ArrayList<String> zzlS()
  {
    return new ArrayList(zzSX);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.FacebookSignInConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */