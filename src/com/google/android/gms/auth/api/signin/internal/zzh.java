package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.EmailSignInConfig;
import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<SignInConfiguration>
{
  static void zza(SignInConfiguration paramSignInConfiguration, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, paramSignInConfiguration.zzme(), false);
    zzb.zza(paramParcel, 3, paramSignInConfiguration.zzmb(), false);
    zzb.zza(paramParcel, 4, paramSignInConfiguration.zzmf(), paramInt, false);
    zzb.zza(paramParcel, 5, paramSignInConfiguration.zzmg(), paramInt, false);
    zzb.zza(paramParcel, 6, paramSignInConfiguration.zzmh(), paramInt, false);
    zzb.zza(paramParcel, 7, paramSignInConfiguration.zzmi(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public SignInConfiguration zzS(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    FacebookSignInConfig localFacebookSignInConfig = null;
    GoogleSignInConfig localGoogleSignInConfig = null;
    EmailSignInConfig localEmailSignInConfig = null;
    String str2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        localEmailSignInConfig = (EmailSignInConfig)zza.zza(paramParcel, k, EmailSignInConfig.CREATOR);
        break;
      case 5: 
        localGoogleSignInConfig = (GoogleSignInConfig)zza.zza(paramParcel, k, GoogleSignInConfig.CREATOR);
        break;
      case 6: 
        localFacebookSignInConfig = (FacebookSignInConfig)zza.zza(paramParcel, k, FacebookSignInConfig.CREATOR);
        break;
      case 7: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SignInConfiguration(i, str3, str2, localEmailSignInConfig, localGoogleSignInConfig, localFacebookSignInConfig, str1);
  }
  
  public SignInConfiguration[] zzaJ(int paramInt)
  {
    return new SignInConfiguration[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */