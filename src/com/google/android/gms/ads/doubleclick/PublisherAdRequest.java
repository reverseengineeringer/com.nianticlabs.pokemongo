package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.client.zzy.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzx;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class PublisherAdRequest
{
  public static final String DEVICE_ID_EMULATOR = zzy.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  public static final int GENDER_FEMALE = 2;
  public static final int GENDER_MALE = 1;
  public static final int GENDER_UNKNOWN = 0;
  private final zzy zznO;
  
  private PublisherAdRequest(Builder paramBuilder)
  {
    zznO = new zzy(Builder.zza(paramBuilder));
  }
  
  public static void updateCorrelator() {}
  
  public Date getBirthday()
  {
    return zznO.getBirthday();
  }
  
  public String getContentUrl()
  {
    return zznO.getContentUrl();
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return zznO.getCustomEventExtrasBundle(paramClass);
  }
  
  public Bundle getCustomTargeting()
  {
    return zznO.getCustomTargeting();
  }
  
  public int getGender()
  {
    return zznO.getGender();
  }
  
  public Set<String> getKeywords()
  {
    return zznO.getKeywords();
  }
  
  public Location getLocation()
  {
    return zznO.getLocation();
  }
  
  public boolean getManualImpressionsEnabled()
  {
    return zznO.getManualImpressionsEnabled();
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
  
  public String getPublisherProvidedId()
  {
    return zznO.getPublisherProvidedId();
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return zznO.isTestDevice(paramContext);
  }
  
  public zzy zzaF()
  {
    return zznO;
  }
  
  public static final class Builder
  {
    private final zzy.zza zznP = new zzy.zza();
    
    public Builder addCategoryExclusion(String paramString)
    {
      zznP.zzL(paramString);
      return this;
    }
    
    public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      zznP.zzb(paramClass, paramBundle);
      return this;
    }
    
    public Builder addCustomTargeting(String paramString1, String paramString2)
    {
      zznP.zzb(paramString1, paramString2);
      return this;
    }
    
    public Builder addCustomTargeting(String paramString, List<String> paramList)
    {
      if (paramList != null) {
        zznP.zzb(paramString, zzv.zzcq(",").zza(paramList));
      }
      return this;
    }
    
    public Builder addKeyword(String paramString)
    {
      zznP.zzF(paramString);
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
    
    public PublisherAdRequest build()
    {
      return new PublisherAdRequest(this, null);
    }
    
    public Builder setBirthday(Date paramDate)
    {
      zznP.zza(paramDate);
      return this;
    }
    
    public Builder setContentUrl(String paramString)
    {
      zzx.zzb(paramString, "Content URL must be non-null.");
      zzx.zzh(paramString, "Content URL must be non-empty.");
      if (paramString.length() <= 512) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Content URL must not exceed %d in length.  Provided length was %d.", new Object[] { Integer.valueOf(512), Integer.valueOf(paramString.length()) });
        zznP.zzI(paramString);
        return this;
      }
    }
    
    public Builder setGender(int paramInt)
    {
      zznP.zzm(paramInt);
      return this;
    }
    
    public Builder setLocation(Location paramLocation)
    {
      zznP.zzb(paramLocation);
      return this;
    }
    
    @Deprecated
    public Builder setManualImpressionsEnabled(boolean paramBoolean)
    {
      zznP.setManualImpressionsEnabled(paramBoolean);
      return this;
    }
    
    public Builder setPublisherProvidedId(String paramString)
    {
      zznP.zzJ(paramString);
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
 * Qualified Name:     com.google.android.gms.ads.doubleclick.PublisherAdRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */