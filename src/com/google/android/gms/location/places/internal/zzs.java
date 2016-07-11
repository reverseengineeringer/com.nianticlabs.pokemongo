package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class zzs
  extends zzu
  implements Place
{
  private final String zzaGt;
  private boolean zzaHu;
  private final zzp zzaHx;
  
  public zzs(DataHolder paramDataHolder, int paramInt, Context paramContext)
  {
    super(paramDataHolder, paramInt);
    if (paramContext != null) {}
    for (paramDataHolder = zzp.zzaF(paramContext);; paramDataHolder = null)
    {
      zzaHx = paramDataHolder;
      zzaHu = zzh("place_is_logging_enabled", false);
      zzaGt = zzF("place_id", "");
      return;
    }
  }
  
  private void zzdz(String paramString)
  {
    if ((zzaHu) && (zzaHx != null)) {
      zzaHx.zzE(zzaGt, paramString);
    }
  }
  
  public CharSequence getAddress()
  {
    zzdz("getAddress");
    return zzF("place_address", "");
  }
  
  public String getId()
  {
    zzdz("getId");
    return zzaGt;
  }
  
  public LatLng getLatLng()
  {
    zzdz("getLatLng");
    return (LatLng)zza("place_lat_lng", LatLng.CREATOR);
  }
  
  public Locale getLocale()
  {
    zzdz("getLocale");
    String str = zzF("place_locale", "");
    if (!TextUtils.isEmpty(str)) {
      return new Locale(str);
    }
    return Locale.getDefault();
  }
  
  public CharSequence getName()
  {
    zzdz("getName");
    return zzF("place_name", "");
  }
  
  public CharSequence getPhoneNumber()
  {
    zzdz("getPhoneNumber");
    return zzF("place_phone_number", "");
  }
  
  public List<Integer> getPlaceTypes()
  {
    zzdz("getPlaceTypes");
    return zza("place_types", Collections.emptyList());
  }
  
  public int getPriceLevel()
  {
    zzdz("getPriceLevel");
    return zzz("place_price_level", -1);
  }
  
  public float getRating()
  {
    zzdz("getRating");
    return zzb("place_rating", -1.0F);
  }
  
  public LatLngBounds getViewport()
  {
    zzdz("getViewport");
    return (LatLngBounds)zza("place_viewport", LatLngBounds.CREATOR);
  }
  
  public Uri getWebsiteUri()
  {
    zzdz("getWebsiteUri");
    String str = zzF("place_website_uri", null);
    if (str == null) {
      return null;
    }
    return Uri.parse(str);
  }
  
  public float zzxe()
  {
    zzdz("getLevelNumber");
    return zzb("place_level_number", 0.0F);
  }
  
  public boolean zzxh()
  {
    zzdz("isPermanentlyClosed");
    return zzh("place_is_permanently_closed", false);
  }
  
  public Place zzxm()
  {
    Object localObject = new PlaceImpl.zza().zzaj(zzaHu);
    zzaHu = false;
    localObject = ((PlaceImpl.zza)localObject).zzdC(getAddress().toString()).zzu(zzb("place_attributions", Collections.emptyList())).zzdA(getId()).zzai(zzxh()).zza(getLatLng()).zzf(zzxe()).zzdB(getName().toString()).zzdD(getPhoneNumber().toString()).zzhs(getPriceLevel()).zzg(getRating()).zzt(getPlaceTypes()).zza(getViewport()).zzl(getWebsiteUri()).zzxn();
    ((PlaceImpl)localObject).setLocale(getLocale());
    ((PlaceImpl)localObject).zza(zzaHx);
    return (Place)localObject;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */