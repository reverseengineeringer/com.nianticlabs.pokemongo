package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceImpl
  implements SafeParcelable, Place
{
  public static final zzl CREATOR = new zzl();
  private final String mName;
  final int mVersionCode;
  private final LatLng zzaFS;
  private final List<Integer> zzaFT;
  private final String zzaFU;
  private final Uri zzaFV;
  private Locale zzaHc;
  private final Bundle zzaHi;
  @Deprecated
  private final PlaceLocalization zzaHj;
  private final float zzaHk;
  private final LatLngBounds zzaHl;
  private final String zzaHm;
  private final boolean zzaHn;
  private final float zzaHo;
  private final int zzaHp;
  private final long zzaHq;
  private final List<Integer> zzaHr;
  private final String zzaHs;
  private final List<String> zzaHt;
  final boolean zzaHu;
  private final Map<Integer, String> zzaHv;
  private final TimeZone zzaHw;
  private zzp zzaHx;
  private final String zzapU;
  private final String zzwN;
  
  PlaceImpl(int paramInt1, String paramString1, List<Integer> paramList1, List<Integer> paramList2, Bundle paramBundle, String paramString2, String paramString3, String paramString4, String paramString5, List<String> paramList, LatLng paramLatLng, float paramFloat1, LatLngBounds paramLatLngBounds, String paramString6, Uri paramUri, boolean paramBoolean1, float paramFloat2, int paramInt2, long paramLong, boolean paramBoolean2, PlaceLocalization paramPlaceLocalization)
  {
    mVersionCode = paramInt1;
    zzwN = paramString1;
    zzaFT = Collections.unmodifiableList(paramList1);
    zzaHr = paramList2;
    if (paramBundle != null)
    {
      zzaHi = paramBundle;
      mName = paramString2;
      zzapU = paramString3;
      zzaFU = paramString4;
      zzaHs = paramString5;
      if (paramList == null) {
        break label182;
      }
      label68:
      zzaHt = paramList;
      zzaFS = paramLatLng;
      zzaHk = paramFloat1;
      zzaHl = paramLatLngBounds;
      if (paramString6 == null) {
        break label190;
      }
    }
    for (;;)
    {
      zzaHm = paramString6;
      zzaFV = paramUri;
      zzaHn = paramBoolean1;
      zzaHo = paramFloat2;
      zzaHp = paramInt2;
      zzaHq = paramLong;
      zzaHv = Collections.unmodifiableMap(new HashMap());
      zzaHw = null;
      zzaHc = null;
      zzaHu = paramBoolean2;
      zzaHj = paramPlaceLocalization;
      return;
      paramBundle = new Bundle();
      break;
      label182:
      paramList = Collections.emptyList();
      break label68;
      label190:
      paramString6 = "UTC";
    }
  }
  
  private void zzdz(String paramString)
  {
    if ((zzaHu) && (zzaHx != null)) {
      zzaHx.zzE(zzwN, paramString);
    }
  }
  
  public int describeContents()
  {
    zzl localzzl = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceImpl)) {
        return false;
      }
      paramObject = (PlaceImpl)paramObject;
    } while ((zzwN.equals(zzwN)) && (zzw.equal(zzaHc, zzaHc)) && (zzaHq == zzaHq));
    return false;
  }
  
  public String getAddress()
  {
    zzdz("getAddress");
    return zzapU;
  }
  
  public String getId()
  {
    zzdz("getId");
    return zzwN;
  }
  
  public LatLng getLatLng()
  {
    zzdz("getLatLng");
    return zzaFS;
  }
  
  public Locale getLocale()
  {
    zzdz("getLocale");
    return zzaHc;
  }
  
  public String getName()
  {
    zzdz("getName");
    return mName;
  }
  
  public String getPhoneNumber()
  {
    zzdz("getPhoneNumber");
    return zzaFU;
  }
  
  public List<Integer> getPlaceTypes()
  {
    zzdz("getPlaceTypes");
    return zzaFT;
  }
  
  public int getPriceLevel()
  {
    zzdz("getPriceLevel");
    return zzaHp;
  }
  
  public float getRating()
  {
    zzdz("getRating");
    return zzaHo;
  }
  
  public LatLngBounds getViewport()
  {
    zzdz("getViewport");
    return zzaHl;
  }
  
  public Uri getWebsiteUri()
  {
    zzdz("getWebsiteUri");
    return zzaFV;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzwN, zzaHc, Long.valueOf(zzaHq) });
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public void setLocale(Locale paramLocale)
  {
    zzaHc = paramLocale;
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("id", zzwN).zzg("placeTypes", zzaFT).zzg("locale", zzaHc).zzg("name", mName).zzg("address", zzapU).zzg("phoneNumber", zzaFU).zzg("latlng", zzaFS).zzg("viewport", zzaHl).zzg("websiteUri", zzaFV).zzg("isPermanentlyClosed", Boolean.valueOf(zzaHn)).zzg("priceLevel", Integer.valueOf(zzaHp)).zzg("timestampSecs", Long.valueOf(zzaHq)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl localzzl = CREATOR;
    zzl.zza(this, paramParcel, paramInt);
  }
  
  public void zza(zzp paramzzp)
  {
    zzaHx = paramzzp;
  }
  
  public List<Integer> zzxd()
  {
    zzdz("getTypesDeprecated");
    return zzaHr;
  }
  
  public float zzxe()
  {
    zzdz("getLevelNumber");
    return zzaHk;
  }
  
  public String zzxf()
  {
    zzdz("getRegularOpenHours");
    return zzaHs;
  }
  
  public List<String> zzxg()
  {
    zzdz("getAttributions");
    return zzaHt;
  }
  
  public boolean zzxh()
  {
    zzdz("isPermanentlyClosed");
    return zzaHn;
  }
  
  public long zzxi()
  {
    return zzaHq;
  }
  
  public Bundle zzxj()
  {
    return zzaHi;
  }
  
  public String zzxk()
  {
    return zzaHm;
  }
  
  @Deprecated
  public PlaceLocalization zzxl()
  {
    zzdz("getLocalization");
    return zzaHj;
  }
  
  public Place zzxm()
  {
    return this;
  }
  
  public static class zza
  {
    private String mName;
    private int mVersionCode = 0;
    private LatLng zzaFS;
    private String zzaFU;
    private Uri zzaFV;
    private float zzaHk;
    private LatLngBounds zzaHl;
    private String zzaHm;
    private boolean zzaHn;
    private float zzaHo;
    private int zzaHp;
    private long zzaHq;
    private String zzaHs;
    private List<String> zzaHt;
    private boolean zzaHu;
    private Bundle zzaHy;
    private List<Integer> zzaHz;
    private String zzapU;
    private String zzwN;
    
    public zza zza(LatLng paramLatLng)
    {
      zzaFS = paramLatLng;
      return this;
    }
    
    public zza zza(LatLngBounds paramLatLngBounds)
    {
      zzaHl = paramLatLngBounds;
      return this;
    }
    
    public zza zzai(boolean paramBoolean)
    {
      zzaHn = paramBoolean;
      return this;
    }
    
    public zza zzaj(boolean paramBoolean)
    {
      zzaHu = paramBoolean;
      return this;
    }
    
    public zza zzdA(String paramString)
    {
      zzwN = paramString;
      return this;
    }
    
    public zza zzdB(String paramString)
    {
      mName = paramString;
      return this;
    }
    
    public zza zzdC(String paramString)
    {
      zzapU = paramString;
      return this;
    }
    
    public zza zzdD(String paramString)
    {
      zzaFU = paramString;
      return this;
    }
    
    public zza zzf(float paramFloat)
    {
      zzaHk = paramFloat;
      return this;
    }
    
    public zza zzg(float paramFloat)
    {
      zzaHo = paramFloat;
      return this;
    }
    
    public zza zzhs(int paramInt)
    {
      zzaHp = paramInt;
      return this;
    }
    
    public zza zzl(Uri paramUri)
    {
      zzaFV = paramUri;
      return this;
    }
    
    public zza zzt(List<Integer> paramList)
    {
      zzaHz = paramList;
      return this;
    }
    
    public zza zzu(List<String> paramList)
    {
      zzaHt = paramList;
      return this;
    }
    
    public PlaceImpl zzxn()
    {
      return new PlaceImpl(mVersionCode, zzwN, zzaHz, Collections.emptyList(), zzaHy, mName, zzapU, zzaFU, zzaHs, zzaHt, zzaFS, zzaHk, zzaHl, zzaHm, zzaFV, zzaHn, zzaHo, zzaHp, zzaHq, zzaHu, PlaceLocalization.zza(mName, zzapU, zzaFU, zzaHs, zzaHt));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.PlaceImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */