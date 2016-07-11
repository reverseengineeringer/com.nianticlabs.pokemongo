package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;

public class zzl
  implements Parcelable.Creator<PlaceImpl>
{
  static void zza(PlaceImpl paramPlaceImpl, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramPlaceImpl.getId(), false);
    zzb.zza(paramParcel, 2, paramPlaceImpl.zzxj(), false);
    zzb.zza(paramParcel, 3, paramPlaceImpl.zzxl(), paramInt, false);
    zzb.zza(paramParcel, 4, paramPlaceImpl.getLatLng(), paramInt, false);
    zzb.zza(paramParcel, 5, paramPlaceImpl.zzxe());
    zzb.zza(paramParcel, 6, paramPlaceImpl.getViewport(), paramInt, false);
    zzb.zza(paramParcel, 7, paramPlaceImpl.zzxk(), false);
    zzb.zza(paramParcel, 8, paramPlaceImpl.getWebsiteUri(), paramInt, false);
    zzb.zza(paramParcel, 9, paramPlaceImpl.zzxh());
    zzb.zza(paramParcel, 10, paramPlaceImpl.getRating());
    zzb.zzc(paramParcel, 11, paramPlaceImpl.getPriceLevel());
    zzb.zza(paramParcel, 12, paramPlaceImpl.zzxi());
    zzb.zza(paramParcel, 13, paramPlaceImpl.zzxd(), false);
    zzb.zza(paramParcel, 14, paramPlaceImpl.getAddress(), false);
    zzb.zza(paramParcel, 15, paramPlaceImpl.getPhoneNumber(), false);
    zzb.zzb(paramParcel, 17, paramPlaceImpl.zzxg(), false);
    zzb.zza(paramParcel, 16, paramPlaceImpl.zzxf(), false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 19, paramPlaceImpl.getName(), false);
    zzb.zza(paramParcel, 18, zzaHu);
    zzb.zza(paramParcel, 20, paramPlaceImpl.getPlaceTypes(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public PlaceImpl zzeV(Parcel paramParcel)
  {
    int k = zza.zzap(paramParcel);
    int j = 0;
    String str6 = null;
    ArrayList localArrayList3 = null;
    ArrayList localArrayList2 = null;
    Bundle localBundle = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    ArrayList localArrayList1 = null;
    LatLng localLatLng = null;
    float f2 = 0.0F;
    LatLngBounds localLatLngBounds = null;
    String str1 = null;
    Uri localUri = null;
    boolean bool2 = false;
    float f1 = 0.0F;
    int i = 0;
    long l = 0L;
    boolean bool1 = false;
    PlaceLocalization localPlaceLocalization = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        str6 = zza.zzp(paramParcel, m);
        break;
      case 2: 
        localBundle = zza.zzr(paramParcel, m);
        break;
      case 3: 
        localPlaceLocalization = (PlaceLocalization)zza.zza(paramParcel, m, PlaceLocalization.CREATOR);
        break;
      case 4: 
        localLatLng = (LatLng)zza.zza(paramParcel, m, LatLng.CREATOR);
        break;
      case 5: 
        f2 = zza.zzl(paramParcel, m);
        break;
      case 6: 
        localLatLngBounds = (LatLngBounds)zza.zza(paramParcel, m, LatLngBounds.CREATOR);
        break;
      case 7: 
        str1 = zza.zzp(paramParcel, m);
        break;
      case 8: 
        localUri = (Uri)zza.zza(paramParcel, m, Uri.CREATOR);
        break;
      case 9: 
        bool2 = zza.zzc(paramParcel, m);
        break;
      case 10: 
        f1 = zza.zzl(paramParcel, m);
        break;
      case 11: 
        i = zza.zzg(paramParcel, m);
        break;
      case 12: 
        l = zza.zzi(paramParcel, m);
        break;
      case 13: 
        localArrayList2 = zza.zzC(paramParcel, m);
        break;
      case 14: 
        str4 = zza.zzp(paramParcel, m);
        break;
      case 15: 
        str3 = zza.zzp(paramParcel, m);
        break;
      case 17: 
        localArrayList1 = zza.zzD(paramParcel, m);
        break;
      case 16: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 19: 
        str5 = zza.zzp(paramParcel, m);
        break;
      case 18: 
        bool1 = zza.zzc(paramParcel, m);
        break;
      case 20: 
        localArrayList3 = zza.zzC(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new PlaceImpl(j, str6, localArrayList3, localArrayList2, localBundle, str5, str4, str3, str2, localArrayList1, localLatLng, f2, localLatLngBounds, str1, localUri, bool2, f1, i, l, bool1, localPlaceLocalization);
  }
  
  public PlaceImpl[] zzht(int paramInt)
  {
    return new PlaceImpl[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */