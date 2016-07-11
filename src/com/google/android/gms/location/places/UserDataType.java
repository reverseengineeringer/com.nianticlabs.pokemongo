package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class UserDataType
  implements SafeParcelable
{
  public static final zzm CREATOR = new zzm();
  public static final UserDataType zzaGI = zzy("test_type", 1);
  public static final UserDataType zzaGJ = zzy("labeled_place", 6);
  public static final UserDataType zzaGK = zzy("here_content", 7);
  public static final Set<UserDataType> zzaGL = Collections.unmodifiableSet(new HashSet(Arrays.asList(new UserDataType[] { zzaGI, zzaGJ, zzaGK })));
  final int mVersionCode;
  final String zzGq;
  final int zzaGM;
  
  UserDataType(int paramInt1, String paramString, int paramInt2)
  {
    zzx.zzcr(paramString);
    mVersionCode = paramInt1;
    zzGq = paramString;
    zzaGM = paramInt2;
  }
  
  private static UserDataType zzy(String paramString, int paramInt)
  {
    return new UserDataType(0, paramString, paramInt);
  }
  
  public int describeContents()
  {
    zzm localzzm = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof UserDataType)) {
        return false;
      }
      paramObject = (UserDataType)paramObject;
    } while ((zzGq.equals(zzGq)) && (zzaGM == zzaGM));
    return false;
  }
  
  public int hashCode()
  {
    return zzGq.hashCode();
  }
  
  public String toString()
  {
    return zzGq;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm localzzm = CREATOR;
    zzm.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.UserDataType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */