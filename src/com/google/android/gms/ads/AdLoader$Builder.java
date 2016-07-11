package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzd;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdd;
import com.google.android.gms.internal.zzde;
import com.google.android.gms.internal.zzel;

public class AdLoader$Builder
{
  private final Context mContext;
  private final zzq zznN;
  
  AdLoader$Builder(Context paramContext, zzq paramzzq)
  {
    mContext = paramContext;
    zznN = paramzzq;
  }
  
  public AdLoader$Builder(Context paramContext, String paramString)
  {
    this(paramContext, zzd.zza(paramContext, paramString, new zzel()));
  }
  
  public AdLoader build()
  {
    try
    {
      AdLoader localAdLoader = new AdLoader(mContext, zznN.zzbk());
      return localAdLoader;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzb("Failed to build AdLoader.", localRemoteException);
    }
    return null;
  }
  
  public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener paramOnAppInstallAdLoadedListener)
  {
    try
    {
      zznN.zza(new zzdb(paramOnAppInstallAdLoadedListener));
      return this;
    }
    catch (RemoteException paramOnAppInstallAdLoadedListener)
    {
      zzb.zzd("Failed to add app install ad listener", paramOnAppInstallAdLoadedListener);
    }
    return this;
  }
  
  public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener paramOnContentAdLoadedListener)
  {
    try
    {
      zznN.zza(new zzdc(paramOnContentAdLoadedListener));
      return this;
    }
    catch (RemoteException paramOnContentAdLoadedListener)
    {
      zzb.zzd("Failed to add content ad listener", paramOnContentAdLoadedListener);
    }
    return this;
  }
  
  public Builder forCustomTemplateAd(String paramString, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener paramOnCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener paramOnCustomClickListener)
  {
    try
    {
      zzq localzzq = zznN;
      zzde localzzde = new zzde(paramOnCustomTemplateAdLoadedListener);
      if (paramOnCustomClickListener == null) {}
      for (paramOnCustomTemplateAdLoadedListener = null;; paramOnCustomTemplateAdLoadedListener = new zzdd(paramOnCustomClickListener))
      {
        localzzq.zza(paramString, localzzde, paramOnCustomTemplateAdLoadedListener);
        return this;
      }
      return this;
    }
    catch (RemoteException paramString)
    {
      zzb.zzd("Failed to add custom template ad listener", paramString);
    }
  }
  
  public Builder withAdListener(AdListener paramAdListener)
  {
    try
    {
      zznN.zzb(new zzc(paramAdListener));
      return this;
    }
    catch (RemoteException paramAdListener)
    {
      zzb.zzd("Failed to set AdListener.", paramAdListener);
    }
    return this;
  }
  
  public Builder withNativeAdOptions(NativeAdOptions paramNativeAdOptions)
  {
    try
    {
      zznN.zza(new NativeAdOptionsParcel(paramNativeAdOptions));
      return this;
    }
    catch (RemoteException paramNativeAdOptions)
    {
      zzb.zzd("Failed to specify native ad options", paramNativeAdOptions);
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.AdLoader.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */