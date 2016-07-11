package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zze
  implements Parcelable.Creator<GoogleSignInConfig>
{
  static void zza(GoogleSignInConfig paramGoogleSignInConfig, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc(paramParcel, 2, paramGoogleSignInConfig.zzlS(), false);
    zzb.zza(paramParcel, 3, paramGoogleSignInConfig.getAccount(), paramInt, false);
    zzb.zza(paramParcel, 4, paramGoogleSignInConfig.zzlY());
    zzb.zza(paramParcel, 5, paramGoogleSignInConfig.zzlZ());
    zzb.zza(paramParcel, 6, paramGoogleSignInConfig.zzma());
    zzb.zza(paramParcel, 7, paramGoogleSignInConfig.zzmb(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public GoogleSignInConfig zzR(Parcel paramParcel)
  {
    String str = null;
    boolean bool1 = false;
    int j = zza.zzap(paramParcel);
    boolean bool2 = false;
    boolean bool3 = false;
    Account localAccount = null;
    ArrayList localArrayList = null;
    int i = 0;
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
        localArrayList = zza.zzc(paramParcel, k, Scope.CREATOR);
        break;
      case 3: 
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
        break;
      case 4: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 5: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 6: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 7: 
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GoogleSignInConfig(i, localArrayList, localAccount, bool3, bool2, bool1, str);
  }
  
  public GoogleSignInConfig[] zzaI(int paramInt)
  {
    return new GoogleSignInConfig[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */