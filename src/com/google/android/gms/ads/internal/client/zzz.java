package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgb;
import java.util.concurrent.atomic.AtomicBoolean;

public class zzz
{
  private final zzh zznL;
  private boolean zzoN;
  private String zzpa;
  private zza zzsy;
  private AdListener zzsz;
  private final zzel zztD = new zzel();
  private final AtomicBoolean zztE;
  private zzs zztF;
  private String zztG;
  private ViewGroup zztH;
  private InAppPurchaseListener zztI;
  private PlayStorePurchaseListener zztJ;
  private OnCustomRenderedAdLoadedListener zztK;
  private AppEventListener zztj;
  private AdSize[] zztk;
  
  public zzz(ViewGroup paramViewGroup)
  {
    this(paramViewGroup, null, false, zzh.zzcB());
  }
  
  public zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, zzh.zzcB());
  }
  
  zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, zzh paramzzh)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, paramzzh, null);
  }
  
  zzz(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, zzh paramzzh, zzs paramzzs)
  {
    zztH = paramViewGroup;
    zznL = paramzzh;
    zztF = paramzzs;
    zztE = new AtomicBoolean(false);
    if (paramAttributeSet != null) {
      paramzzh = paramViewGroup.getContext();
    }
    try
    {
      paramAttributeSet = new zzk(paramzzh, paramAttributeSet);
      zztk = paramAttributeSet.zzi(paramBoolean);
      zzpa = paramAttributeSet.getAdUnitId();
      if (paramViewGroup.isInEditMode()) {
        zzl.zzcF().zza(paramViewGroup, new AdSizeParcel(paramzzh, zztk[0]), "Ads by Google");
      }
      return;
    }
    catch (IllegalArgumentException paramAttributeSet)
    {
      zzl.zzcF().zza(paramViewGroup, new AdSizeParcel(paramzzh, AdSize.BANNER), paramAttributeSet.getMessage(), paramAttributeSet.getMessage());
    }
  }
  
  private void zzcS()
  {
    try
    {
      zzd localzzd = zztF.zzaM();
      if (localzzd == null) {
        return;
      }
      zztH.addView((View)com.google.android.gms.dynamic.zze.zzp(localzzd));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get an ad frame.", localRemoteException);
    }
  }
  
  public void destroy()
  {
    try
    {
      if (zztF != null) {
        zztF.destroy();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to destroy AdView.", localRemoteException);
    }
  }
  
  public AdListener getAdListener()
  {
    return zzsz;
  }
  
  public AdSize getAdSize()
  {
    try
    {
      if (zztF != null)
      {
        Object localObject = zztF.zzaN();
        if (localObject != null)
        {
          localObject = ((AdSizeParcel)localObject).zzcD();
          return (AdSize)localObject;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the current AdSize.", localRemoteException);
      if (zztk != null) {
        return zztk[0];
      }
    }
    return null;
  }
  
  public AdSize[] getAdSizes()
  {
    return zztk;
  }
  
  public String getAdUnitId()
  {
    return zzpa;
  }
  
  public AppEventListener getAppEventListener()
  {
    return zztj;
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return zztI;
  }
  
  public String getMediationAdapterClassName()
  {
    try
    {
      if (zztF != null)
      {
        String str = zztF.getMediationAdapterClassName();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the mediation adapter class name.", localRemoteException);
    }
    return null;
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return zztK;
  }
  
  public boolean isLoading()
  {
    try
    {
      if (zztF != null)
      {
        boolean bool = zztF.isLoading();
        return bool;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to check if ad is loading.", localRemoteException);
    }
    return false;
  }
  
  public void pause()
  {
    try
    {
      if (zztF != null) {
        zztF.pause();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call pause.", localRemoteException);
    }
  }
  
  public void recordManualImpression()
  {
    if (zztE.getAndSet(true)) {}
    for (;;)
    {
      return;
      try
      {
        if (zztF != null)
        {
          zztF.zzaP();
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to record impression.", localRemoteException);
      }
    }
  }
  
  public void resume()
  {
    try
    {
      if (zztF != null) {
        zztF.resume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call resume.", localRemoteException);
    }
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    try
    {
      zzsz = paramAdListener;
      zzs localzzs;
      if (zztF != null)
      {
        localzzs = zztF;
        if (paramAdListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAdListener = new zzc(paramAdListener);; paramAdListener = null)
      {
        localzzs.zza(paramAdListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAdListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdListener.", paramAdListener);
    }
  }
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if (zztk != null) {
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    }
    zza(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    if (zzpa != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }
    zzpa = paramString;
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      zztj = paramAppEventListener;
      zzs localzzs;
      if (zztF != null)
      {
        localzzs = zztF;
        if (paramAppEventListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAppEventListener = new zzj(paramAppEventListener);; paramAppEventListener = null)
      {
        localzzs.zza(paramAppEventListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAppEventListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AppEventListener.", paramAppEventListener);
    }
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    if (zztJ != null) {
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    }
    try
    {
      zztI = paramInAppPurchaseListener;
      zzs localzzs;
      if (zztF != null)
      {
        localzzs = zztF;
        if (paramInAppPurchaseListener == null) {
          break label56;
        }
      }
      label56:
      for (paramInAppPurchaseListener = new zzfx(paramInAppPurchaseListener);; paramInAppPurchaseListener = null)
      {
        localzzs.zza(paramInAppPurchaseListener);
        return;
      }
      return;
    }
    catch (RemoteException paramInAppPurchaseListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the InAppPurchaseListener.", paramInAppPurchaseListener);
    }
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    zzoN = paramBoolean;
    try
    {
      if (zztF != null) {
        zztF.setManualImpressionsEnabled(zzoN);
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set manual impressions.", localRemoteException);
    }
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    zztK = paramOnCustomRenderedAdLoadedListener;
    try
    {
      zzs localzzs;
      if (zztF != null)
      {
        localzzs = zztF;
        if (paramOnCustomRenderedAdLoadedListener == null) {
          break label38;
        }
      }
      label38:
      for (paramOnCustomRenderedAdLoadedListener = new zzcl(paramOnCustomRenderedAdLoadedListener);; paramOnCustomRenderedAdLoadedListener = null)
      {
        localzzs.zza(paramOnCustomRenderedAdLoadedListener);
        return;
      }
      return;
    }
    catch (RemoteException paramOnCustomRenderedAdLoadedListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the onCustomRenderedAdLoadedListener.", paramOnCustomRenderedAdLoadedListener);
    }
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    if (zztI != null) {
      throw new IllegalStateException("InAppPurchaseListener has already been set.");
    }
    try
    {
      zztJ = paramPlayStorePurchaseListener;
      zztG = paramString;
      zzs localzzs;
      if (zztF != null)
      {
        localzzs = zztF;
        if (paramPlayStorePurchaseListener == null) {
          break label62;
        }
      }
      label62:
      for (paramPlayStorePurchaseListener = new zzgb(paramPlayStorePurchaseListener);; paramPlayStorePurchaseListener = null)
      {
        localzzs.zza(paramPlayStorePurchaseListener, paramString);
        return;
      }
      return;
    }
    catch (RemoteException paramPlayStorePurchaseListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the play store purchase parameter.", paramPlayStorePurchaseListener);
    }
  }
  
  public void zza(zza paramzza)
  {
    try
    {
      zzsy = paramzza;
      zzs localzzs;
      if (zztF != null)
      {
        localzzs = zztF;
        if (paramzza == null) {
          break label38;
        }
      }
      label38:
      for (paramzza = new zzb(paramzza);; paramzza = null)
      {
        localzzs.zza(paramzza);
        return;
      }
      return;
    }
    catch (RemoteException paramzza)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdClickListener.", paramzza);
    }
  }
  
  public void zza(zzy paramzzy)
  {
    try
    {
      if (zztF == null) {
        zzcT();
      }
      if (zztF.zzb(zznL.zza(zztH.getContext(), paramzzy))) {
        zztD.zze(paramzzy.zzcO());
      }
      return;
    }
    catch (RemoteException paramzzy)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to load ad.", paramzzy);
    }
  }
  
  public void zza(AdSize... paramVarArgs)
  {
    zztk = paramVarArgs;
    try
    {
      if (zztF != null) {
        zztF.zza(new AdSizeParcel(zztH.getContext(), zztk));
      }
      zztH.requestLayout();
      return;
    }
    catch (RemoteException paramVarArgs)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the ad size.", paramVarArgs);
      }
    }
  }
  
  void zzcT()
    throws RemoteException
  {
    if (((zztk == null) || (zzpa == null)) && (zztF == null)) {
      throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
    }
    zztF = zzcU();
    if (zzsz != null) {
      zztF.zza(new zzc(zzsz));
    }
    if (zzsy != null) {
      zztF.zza(new zzb(zzsy));
    }
    if (zztj != null) {
      zztF.zza(new zzj(zztj));
    }
    if (zztI != null) {
      zztF.zza(new zzfx(zztI));
    }
    if (zztJ != null) {
      zztF.zza(new zzgb(zztJ), zztG);
    }
    if (zztK != null) {
      zztF.zza(new zzcl(zztK));
    }
    zztF.zza(zzl.zzcH());
    zztF.setManualImpressionsEnabled(zzoN);
    zzcS();
  }
  
  protected zzs zzcU()
    throws RemoteException
  {
    Context localContext = zztH.getContext();
    return zzl.zzcG().zza(localContext, new AdSizeParcel(localContext, zztk), zzpa, zztD);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */