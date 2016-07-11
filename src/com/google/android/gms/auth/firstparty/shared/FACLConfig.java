package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class FACLConfig
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  final int version;
  boolean zzTA;
  boolean zzTB;
  boolean zzTC;
  boolean zzTx;
  String zzTy;
  boolean zzTz;
  
  FACLConfig(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    version = paramInt;
    zzTx = paramBoolean1;
    zzTy = paramString;
    zzTz = paramBoolean2;
    zzTA = paramBoolean3;
    zzTB = paramBoolean4;
    zzTC = paramBoolean5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof FACLConfig))
    {
      paramObject = (FACLConfig)paramObject;
      bool1 = bool2;
      if (zzTx == zzTx)
      {
        bool1 = bool2;
        if (TextUtils.equals(zzTy, zzTy))
        {
          bool1 = bool2;
          if (zzTz == zzTz)
          {
            bool1 = bool2;
            if (zzTA == zzTA)
            {
              bool1 = bool2;
              if (zzTB == zzTB)
              {
                bool1 = bool2;
                if (zzTC == zzTC) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Boolean.valueOf(zzTx), zzTy, Boolean.valueOf(zzTz), Boolean.valueOf(zzTA), Boolean.valueOf(zzTB), Boolean.valueOf(zzTC) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.FACLConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */