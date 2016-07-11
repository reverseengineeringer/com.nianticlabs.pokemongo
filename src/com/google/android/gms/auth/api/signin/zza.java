package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<EmailSignInConfig>
{
  static void zza(EmailSignInConfig paramEmailSignInConfig, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, paramEmailSignInConfig.zzlO(), paramInt, false);
    zzb.zza(paramParcel, 3, paramEmailSignInConfig.zzlQ(), false);
    zzb.zza(paramParcel, 4, paramEmailSignInConfig.zzlP(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public EmailSignInConfig zzO(Parcel paramParcel)
  {
    Uri localUri = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(paramParcel);
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(paramParcel);
      Object localObject3;
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, Uri.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        localUri = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, Uri.CREATOR);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new EmailSignInConfig(i, (Uri)localObject1, (String)localObject2, localUri);
  }
  
  public EmailSignInConfig[] zzaF(int paramInt)
  {
    return new EmailSignInConfig[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */