package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddPlaceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddPlaceRequest> CREATOR = new zzb();
  private final String mName;
  final int mVersionCode;
  private final LatLng zzaFS;
  private final List<Integer> zzaFT;
  private final String zzaFU;
  private final Uri zzaFV;
  private final String zzapU;
  
  AddPlaceRequest(int paramInt, String paramString1, LatLng paramLatLng, String paramString2, List<Integer> paramList, String paramString3, Uri paramUri)
  {
    mVersionCode = paramInt;
    mName = zzx.zzcr(paramString1);
    zzaFS = ((LatLng)zzx.zzw(paramLatLng));
    zzapU = zzx.zzcr(paramString2);
    zzaFT = new ArrayList((Collection)zzx.zzw(paramList));
    if (!zzaFT.isEmpty()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzx.zzb(bool1, "At least one place type should be provided.");
      if (TextUtils.isEmpty(paramString3))
      {
        bool1 = bool2;
        if (paramUri == null) {}
      }
      else
      {
        bool1 = true;
      }
      zzx.zzb(bool1, "One of phone number or URI should be provided.");
      zzaFU = paramString3;
      zzaFV = paramUri;
      return;
    }
  }
  
  public AddPlaceRequest(String paramString1, LatLng paramLatLng, String paramString2, List<Integer> paramList, Uri paramUri)
  {
    this(paramString1, paramLatLng, paramString2, paramList, null, (Uri)zzx.zzw(paramUri));
  }
  
  public AddPlaceRequest(String paramString1, LatLng paramLatLng, String paramString2, List<Integer> paramList, String paramString3)
  {
    this(paramString1, paramLatLng, paramString2, paramList, zzx.zzcr(paramString3), null);
  }
  
  public AddPlaceRequest(String paramString1, LatLng paramLatLng, String paramString2, List<Integer> paramList, String paramString3, Uri paramUri)
  {
    this(0, paramString1, paramLatLng, paramString2, paramList, paramString3, paramUri);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return zzapU;
  }
  
  public LatLng getLatLng()
  {
    return zzaFS;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public String getPhoneNumber()
  {
    return zzaFU;
  }
  
  public List<Integer> getPlaceTypes()
  {
    return zzaFT;
  }
  
  public Uri getWebsiteUri()
  {
    return zzaFV;
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("name", mName).zzg("latLng", zzaFS).zzg("address", zzapU).zzg("placeTypes", zzaFT).zzg("phoneNumer", zzaFU).zzg("websiteUri", zzaFV).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.AddPlaceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */