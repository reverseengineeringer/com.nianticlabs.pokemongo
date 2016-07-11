package com.google.android.gms.ads.search;

import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzy.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;

public final class SearchAdRequest$Builder
{
  private int zzKS;
  private int zzKT;
  private int zzKU;
  private int zzKV;
  private int zzKW;
  private int zzKX = 0;
  private int zzKY;
  private String zzKZ;
  private int zzLa;
  private String zzLb;
  private int zzLc;
  private int zzLd;
  private String zzLe;
  private final zzy.zza zznP = new zzy.zza();
  private int zzwg;
  
  public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
  {
    zznP.zzb(paramClass, paramBundle);
    return this;
  }
  
  public Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
  {
    zznP.zza(paramNetworkExtras);
    return this;
  }
  
  public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
  {
    zznP.zza(paramClass, paramBundle);
    return this;
  }
  
  public Builder addTestDevice(String paramString)
  {
    zznP.zzG(paramString);
    return this;
  }
  
  public SearchAdRequest build()
  {
    return new SearchAdRequest(this, null);
  }
  
  public Builder setAnchorTextColor(int paramInt)
  {
    zzKS = paramInt;
    return this;
  }
  
  public Builder setBackgroundColor(int paramInt)
  {
    zzwg = paramInt;
    zzKT = Color.argb(0, 0, 0, 0);
    zzKU = Color.argb(0, 0, 0, 0);
    return this;
  }
  
  public Builder setBackgroundGradient(int paramInt1, int paramInt2)
  {
    zzwg = Color.argb(0, 0, 0, 0);
    zzKT = paramInt2;
    zzKU = paramInt1;
    return this;
  }
  
  public Builder setBorderColor(int paramInt)
  {
    zzKV = paramInt;
    return this;
  }
  
  public Builder setBorderThickness(int paramInt)
  {
    zzKW = paramInt;
    return this;
  }
  
  public Builder setBorderType(int paramInt)
  {
    zzKX = paramInt;
    return this;
  }
  
  public Builder setCallButtonColor(int paramInt)
  {
    zzKY = paramInt;
    return this;
  }
  
  public Builder setCustomChannels(String paramString)
  {
    zzKZ = paramString;
    return this;
  }
  
  public Builder setDescriptionTextColor(int paramInt)
  {
    zzLa = paramInt;
    return this;
  }
  
  public Builder setFontFace(String paramString)
  {
    zzLb = paramString;
    return this;
  }
  
  public Builder setHeaderTextColor(int paramInt)
  {
    zzLc = paramInt;
    return this;
  }
  
  public Builder setHeaderTextSize(int paramInt)
  {
    zzLd = paramInt;
    return this;
  }
  
  public Builder setLocation(Location paramLocation)
  {
    zznP.zzb(paramLocation);
    return this;
  }
  
  public Builder setQuery(String paramString)
  {
    zzLe = paramString;
    return this;
  }
  
  public Builder setRequestAgent(String paramString)
  {
    zznP.zzK(paramString);
    return this;
  }
  
  public Builder tagForChildDirectedTreatment(boolean paramBoolean)
  {
    zznP.zzj(paramBoolean);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.search.SearchAdRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */