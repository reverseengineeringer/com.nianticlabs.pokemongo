package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.client.zzy.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;

public final class SearchAdRequest
{
  public static final int BORDER_TYPE_DASHED = 1;
  public static final int BORDER_TYPE_DOTTED = 2;
  public static final int BORDER_TYPE_NONE = 0;
  public static final int BORDER_TYPE_SOLID = 3;
  public static final int CALL_BUTTON_COLOR_DARK = 2;
  public static final int CALL_BUTTON_COLOR_LIGHT = 0;
  public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
  public static final String DEVICE_ID_EMULATOR = zzy.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  private final int zzKS;
  private final int zzKT;
  private final int zzKU;
  private final int zzKV;
  private final int zzKW;
  private final int zzKX;
  private final int zzKY;
  private final String zzKZ;
  private final int zzLa;
  private final String zzLb;
  private final int zzLc;
  private final int zzLd;
  private final String zzLe;
  private final zzy zznO;
  private final int zzwg;
  
  private SearchAdRequest(Builder paramBuilder)
  {
    zzKS = Builder.zza(paramBuilder);
    zzwg = Builder.zzb(paramBuilder);
    zzKT = Builder.zzc(paramBuilder);
    zzKU = Builder.zzd(paramBuilder);
    zzKV = Builder.zze(paramBuilder);
    zzKW = Builder.zzf(paramBuilder);
    zzKX = Builder.zzg(paramBuilder);
    zzKY = Builder.zzh(paramBuilder);
    zzKZ = Builder.zzi(paramBuilder);
    zzLa = Builder.zzj(paramBuilder);
    zzLb = Builder.zzk(paramBuilder);
    zzLc = Builder.zzl(paramBuilder);
    zzLd = Builder.zzm(paramBuilder);
    zzLe = Builder.zzn(paramBuilder);
    zznO = new zzy(Builder.zzo(paramBuilder), this);
  }
  
  public int getAnchorTextColor()
  {
    return zzKS;
  }
  
  public int getBackgroundColor()
  {
    return zzwg;
  }
  
  public int getBackgroundGradientBottom()
  {
    return zzKT;
  }
  
  public int getBackgroundGradientTop()
  {
    return zzKU;
  }
  
  public int getBorderColor()
  {
    return zzKV;
  }
  
  public int getBorderThickness()
  {
    return zzKW;
  }
  
  public int getBorderType()
  {
    return zzKX;
  }
  
  public int getCallButtonColor()
  {
    return zzKY;
  }
  
  public String getCustomChannels()
  {
    return zzKZ;
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return zznO.getCustomEventExtrasBundle(paramClass);
  }
  
  public int getDescriptionTextColor()
  {
    return zzLa;
  }
  
  public String getFontFace()
  {
    return zzLb;
  }
  
  public int getHeaderTextColor()
  {
    return zzLc;
  }
  
  public int getHeaderTextSize()
  {
    return zzLd;
  }
  
  public Location getLocation()
  {
    return zznO.getLocation();
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return zznO.getNetworkExtras(paramClass);
  }
  
  public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> paramClass)
  {
    return zznO.getNetworkExtrasBundle(paramClass);
  }
  
  public String getQuery()
  {
    return zzLe;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return zznO.isTestDevice(paramContext);
  }
  
  zzy zzaF()
  {
    return zznO;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.search.SearchAdRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */