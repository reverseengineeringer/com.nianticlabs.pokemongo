package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<GoogleSignInAccount>
{
  static void zza(GoogleSignInAccount paramGoogleSignInAccount, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, paramGoogleSignInAccount.getId(), false);
    zzb.zza(paramParcel, 3, paramGoogleSignInAccount.getIdToken(), false);
    zzb.zza(paramParcel, 4, paramGoogleSignInAccount.getEmail(), false);
    zzb.zza(paramParcel, 5, paramGoogleSignInAccount.getDisplayName(), false);
    zzb.zza(paramParcel, 6, paramGoogleSignInAccount.zzlT(), paramInt, false);
    zzb.zza(paramParcel, 7, paramGoogleSignInAccount.zzlU(), false);
    zzb.zza(paramParcel, 8, paramGoogleSignInAccount.zzlV());
    zzb.zzI(paramParcel, i);
  }
  
  public GoogleSignInAccount zzQ(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    long l = 0L;
    Uri localUri = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
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
        str5 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str4 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        localUri = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
        break;
      case 7: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 8: 
        l = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GoogleSignInAccount(i, str5, str4, str3, str2, localUri, str1, l);
  }
  
  public GoogleSignInAccount[] zzaH(int paramInt)
  {
    return new GoogleSignInAccount[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */