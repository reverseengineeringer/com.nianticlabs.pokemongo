package com.google.android.gms.location.places.personalized.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<TestDataImpl>
{
  static void zza(TestDataImpl paramTestDataImpl, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramTestDataImpl.zzxv(), false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public TestDataImpl zzfe(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        str = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new TestDataImpl(i, str);
  }
  
  public TestDataImpl[] zzhC(int paramInt)
  {
    return new TestDataImpl[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.internal.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */