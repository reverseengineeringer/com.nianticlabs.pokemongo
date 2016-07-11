package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<FacebookSignInConfig>
{
  static void zza(FacebookSignInConfig paramFacebookSignInConfig, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramFacebookSignInConfig.zzlR(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, 3, paramFacebookSignInConfig.zzlS(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public FacebookSignInConfig zzP(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    Intent localIntent = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localIntent = (Intent)zza.zza(paramParcel, k, Intent.CREATOR);
        continue;
        localArrayList = zza.zzD(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new FacebookSignInConfig(i, localIntent, localArrayList);
  }
  
  public FacebookSignInConfig[] zzaG(int paramInt)
  {
    return new FacebookSignInConfig[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */