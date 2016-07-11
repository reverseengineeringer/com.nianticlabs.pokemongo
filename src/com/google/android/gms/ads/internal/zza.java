package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.zzf;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzs.zza;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zza.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzbh;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzca;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzgg.zza;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import java.util.HashSet;

@zzgr
public abstract class zza
  extends zzs.zza
  implements com.google.android.gms.ads.internal.client.zza, com.google.android.gms.ads.internal.overlay.zzn, zza.zza, zzdg, zzgg.zza, zzhw
{
  protected zzcg zzoo;
  protected zzce zzop;
  protected zzce zzoq;
  boolean zzor = false;
  protected final zzo zzos;
  protected final zzq zzot;
  protected transient AdRequestParcel zzou;
  protected final zzay zzov;
  protected final zzd zzow;
  
  zza(zzq paramzzq, zzo paramzzo, zzd paramzzd)
  {
    zzot = paramzzq;
    if (paramzzo != null) {}
    for (;;)
    {
      zzos = paramzzo;
      zzow = paramzzd;
      zzp.zzbv().zzI(zzot.context);
      zzp.zzby().zzb(zzot.context, zzot.zzqj);
      zzov = zzp.zzby().zzgt();
      return;
      paramzzo = new zzo(this);
    }
  }
  
  private AdRequestParcel zza(AdRequestParcel paramAdRequestParcel)
  {
    AdRequestParcel localAdRequestParcel = paramAdRequestParcel;
    if (GooglePlayServicesUtil.zzag(zzot.context))
    {
      localAdRequestParcel = paramAdRequestParcel;
      if (zzsJ != null) {
        localAdRequestParcel = new zzf(paramAdRequestParcel).zza(null).zzcA();
      }
    }
    return localAdRequestParcel;
  }
  
  private boolean zzaR()
  {
    zzb.zzaG("Ad leaving application.");
    if (zzot.zzqs == null) {
      return false;
    }
    try
    {
      zzot.zzqs.onAdLeftApplication();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdLeftApplication().", localRemoteException);
    }
    return false;
  }
  
  public void destroy()
  {
    zzx.zzci("destroy must be called on the main UI thread.");
    zzos.cancel();
    zzov.zzf(zzot.zzqo);
    zzot.destroy();
  }
  
  public boolean isLoading()
  {
    return zzor;
  }
  
  public boolean isReady()
  {
    zzx.zzci("isLoaded must be called on the main UI thread.");
    return (zzot.zzql == null) && (zzot.zzqm == null) && (zzot.zzqo != null);
  }
  
  public void onAdClicked()
  {
    if (zzot.zzqo == null) {
      zzb.zzaH("Ad state was null when trying to ping click URLs.");
    }
    do
    {
      return;
      zzb.zzaF("Pinging click URLs.");
      zzot.zzqq.zzgg();
      if (zzot.zzqo.zzyY != null) {
        zzp.zzbv().zza(zzot.context, zzot.zzqj.zzJu, zzot.zzqo.zzyY);
      }
    } while (zzot.zzqr == null);
    try
    {
      zzot.zzqr.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not notify onAdClicked event.", localRemoteException);
    }
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    if (zzot.zzqt != null) {}
    try
    {
      zzot.zzqt.onAppEvent(paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      zzb.zzd("Could not call the AppEventListener.", paramString1);
    }
  }
  
  public void pause()
  {
    zzx.zzci("pause must be called on the main UI thread.");
  }
  
  protected void recordImpression()
  {
    zzc(zzot.zzqo);
  }
  
  public void resume()
  {
    zzx.zzci("resume must be called on the main UI thread.");
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
  }
  
  public void stopLoading()
  {
    zzx.zzci("stopLoading must be called on the main UI thread.");
    zzor = false;
    zzot.zzf(true);
  }
  
  Bundle zza(zzbk paramzzbk)
  {
    if (paramzzbk == null) {}
    for (;;)
    {
      return null;
      if (paramzzbk.zzcx()) {
        paramzzbk.wakeup();
      }
      Object localObject = paramzzbk.zzcv();
      if (localObject != null)
      {
        paramzzbk = ((zzbh)localObject).zzcm();
        zzb.zzaF("In AdManger: loadAd, " + ((zzbh)localObject).toString());
      }
      while (paramzzbk != null)
      {
        localObject = new Bundle(1);
        ((Bundle)localObject).putString("fingerprint", paramzzbk);
        ((Bundle)localObject).putInt("v", 1);
        return (Bundle)localObject;
        paramzzbk = null;
      }
    }
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
  {
    zzx.zzci("setAdSize must be called on the main UI thread.");
    zzot.zzqn = paramAdSizeParcel;
    if ((zzot.zzqo != null) && (zzot.zzqo.zzBD != null) && (zzot.zzqH == 0)) {
      zzot.zzqo.zzBD.zza(paramAdSizeParcel);
    }
    if (zzot.zzqk == null) {
      return;
    }
    if (zzot.zzqk.getChildCount() > 1) {
      zzot.zzqk.removeView(zzot.zzqk.getNextView());
    }
    zzot.zzqk.setMinimumWidth(widthPixels);
    zzot.zzqk.setMinimumHeight(heightPixels);
    zzot.zzqk.requestLayout();
  }
  
  public void zza(com.google.android.gms.ads.internal.client.zzn paramzzn)
  {
    zzx.zzci("setAdListener must be called on the main UI thread.");
    zzot.zzqr = paramzzn;
  }
  
  public void zza(com.google.android.gms.ads.internal.client.zzo paramzzo)
  {
    zzx.zzci("setAdListener must be called on the main UI thread.");
    zzot.zzqs = paramzzo;
  }
  
  public void zza(zzu paramzzu)
  {
    zzx.zzci("setAppEventListener must be called on the main UI thread.");
    zzot.zzqt = paramzzu;
  }
  
  public void zza(zzv paramzzv)
  {
    zzx.zzci("setCorrelationIdProvider must be called on the main UI thread");
    zzot.zzqu = paramzzv;
  }
  
  public void zza(zzck paramzzck)
  {
    throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
  }
  
  public void zza(zzfs paramzzfs)
  {
    throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
  }
  
  public void zza(zzfw paramzzfw, String paramString)
  {
    throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
  }
  
  public void zza(zzhs.zza paramzza)
  {
    if ((zzHD.zzEO != -1L) && (!TextUtils.isEmpty(zzHD.zzEY)))
    {
      long l = zzo(zzHD.zzEY);
      if (l != -1L)
      {
        zzce localzzce = zzoo.zzb(l + zzHD.zzEO);
        zzoo.zza(localzzce, new String[] { "stc" });
      }
    }
    zzoo.zzT(zzHD.zzEY);
    zzoo.zza(zzop, new String[] { "arf" });
    zzoq = zzoo.zzdn();
    zzoo.zze("gqi", zzHD.zzEZ);
    zzot.zzql = null;
    zzot.zzqp = paramzza;
    zza(paramzza, zzoo);
  }
  
  protected abstract void zza(zzhs.zza paramzza, zzcg paramzzcg);
  
  public void zza(HashSet<zzht> paramHashSet)
  {
    zzot.zza(paramHashSet);
  }
  
  protected abstract boolean zza(AdRequestParcel paramAdRequestParcel, zzcg paramzzcg);
  
  boolean zza(zzhs paramzzhs)
  {
    return false;
  }
  
  protected abstract boolean zza(zzhs paramzzhs1, zzhs paramzzhs2);
  
  void zzaL()
  {
    zzoo = new zzcg(((Boolean)zzby.zzuQ.get()).booleanValue(), "load_ad", zzot.zzqn.zzte);
    zzop = new zzce(-1L, null, null);
    zzoq = new zzce(-1L, null, null);
  }
  
  public com.google.android.gms.dynamic.zzd zzaM()
  {
    zzx.zzci("getAdFrame must be called on the main UI thread.");
    return zze.zzy(zzot.zzqk);
  }
  
  public AdSizeParcel zzaN()
  {
    zzx.zzci("getAdSize must be called on the main UI thread.");
    if (zzot.zzqn == null) {
      return null;
    }
    return new ThinAdSizeParcel(zzot.zzqn);
  }
  
  public void zzaO()
  {
    zzaR();
  }
  
  public void zzaP()
  {
    zzx.zzci("recordManualImpression must be called on the main UI thread.");
    if (zzot.zzqo == null) {
      zzb.zzaH("Ad state was null when trying to ping manual tracking URLs.");
    }
    do
    {
      return;
      zzb.zzaF("Pinging manual tracking URLs.");
    } while (zzot.zzqo.zzEM == null);
    zzp.zzbv().zza(zzot.context, zzot.zzqj.zzJu, zzot.zzqo.zzEM);
  }
  
  protected boolean zzaQ()
  {
    zzb.v("Ad closing.");
    if (zzot.zzqs == null) {
      return false;
    }
    try
    {
      zzot.zzqs.onAdClosed();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdClosed().", localRemoteException);
    }
    return false;
  }
  
  protected boolean zzaS()
  {
    zzb.zzaG("Ad opening.");
    if (zzot.zzqs == null) {
      return false;
    }
    try
    {
      zzot.zzqs.onAdOpened();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdOpened().", localRemoteException);
    }
    return false;
  }
  
  protected boolean zzaT()
  {
    zzb.zzaG("Ad finished loading.");
    zzor = false;
    if (zzot.zzqs == null) {
      return false;
    }
    try
    {
      zzot.zzqs.onAdLoaded();
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdLoaded().", localRemoteException);
    }
    return false;
  }
  
  protected void zzb(View paramView)
  {
    zzot.zzqk.addView(paramView, zzp.zzbx().zzgJ());
  }
  
  public void zzb(zzhs paramzzhs)
  {
    zzoo.zza(zzoq, new String[] { "awr" });
    zzot.zzqm = null;
    if ((errorCode != -2) && (errorCode != 3)) {
      zzp.zzby().zzb(zzot.zzbJ());
    }
    if (errorCode == -1) {
      zzor = false;
    }
    do
    {
      return;
      if (zza(paramzzhs)) {
        zzb.zzaF("Ad refresh scheduled.");
      }
      if (errorCode != -2)
      {
        zze(errorCode);
        return;
      }
      if (zzot.zzqF == null) {
        zzot.zzqF = new zzhx(zzot.zzqh);
      }
      zzov.zze(zzot.zzqo);
    } while (!zza(zzot.zzqo, paramzzhs));
    zzot.zzqo = paramzzhs;
    zzot.zzbS();
    zzcg localzzcg = zzoo;
    if (zzot.zzqo.zzbY())
    {
      paramzzhs = "1";
      label204:
      localzzcg.zze("is_mraid", paramzzhs);
      localzzcg = zzoo;
      if (!zzot.zzqo.zzEK) {
        break label379;
      }
      paramzzhs = "1";
      label234:
      localzzcg.zze("is_mediation", paramzzhs);
      if ((zzot.zzqo.zzBD != null) && (zzot.zzqo.zzBD.zzhe() != null))
      {
        localzzcg = zzoo;
        if (!zzot.zzqo.zzBD.zzhe().zzhr()) {
          break label386;
        }
      }
    }
    label379:
    label386:
    for (paramzzhs = "1";; paramzzhs = "0")
    {
      localzzcg.zze("is_video", paramzzhs);
      zzoo.zza(zzop, new String[] { "ttc" });
      if (zzp.zzby().zzgo() != null) {
        zzp.zzby().zzgo().zza(zzoo);
      }
      if (!zzot.zzbN()) {
        break;
      }
      zzaT();
      return;
      paramzzhs = "0";
      break label204;
      paramzzhs = "0";
      break label234;
    }
  }
  
  public boolean zzb(AdRequestParcel paramAdRequestParcel)
  {
    zzx.zzci("loadAd must be called on the main UI thread.");
    paramAdRequestParcel = zza(paramAdRequestParcel);
    if (zzor)
    {
      if (zzou != null) {
        zzb.zzaH("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
      }
      zzou = paramAdRequestParcel;
      return false;
    }
    zzb.zzaG("Starting ad request.");
    zzor = true;
    zzaL();
    zzop = zzoo.zzdn();
    if (!zzsE) {
      zzb.zzaG("Use AdRequest.Builder.addTestDevice(\"" + zzl.zzcF().zzQ(zzot.context) + "\") to get test ads on this device.");
    }
    return zza(paramAdRequestParcel, zzoo);
  }
  
  protected void zzc(zzhs paramzzhs)
  {
    if (paramzzhs == null) {
      zzb.zzaH("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      zzb.zzaF("Pinging Impression URLs.");
      zzot.zzqq.zzgf();
    } while (zzyZ == null);
    zzp.zzbv().zza(zzot.context, zzot.zzqj.zzJu, zzyZ);
  }
  
  protected boolean zzc(AdRequestParcel paramAdRequestParcel)
  {
    paramAdRequestParcel = zzot.zzqk.getParent();
    return ((paramAdRequestParcel instanceof View)) && (((View)paramAdRequestParcel).isShown()) && (zzp.zzbv().zzgB());
  }
  
  public void zzd(AdRequestParcel paramAdRequestParcel)
  {
    if (zzc(paramAdRequestParcel))
    {
      zzb(paramAdRequestParcel);
      return;
    }
    zzb.zzaG("Ad is not visible. Not refreshing ad.");
    zzos.zzg(paramAdRequestParcel);
  }
  
  protected boolean zze(int paramInt)
  {
    zzb.zzaH("Failed to load ad: " + paramInt);
    zzor = false;
    if (zzot.zzqs == null) {
      return false;
    }
    try
    {
      zzot.zzqs.onAdFailedToLoad(paramInt);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call AdListener.onAdFailedToLoad().", localRemoteException);
    }
    return false;
  }
  
  long zzo(String paramString)
  {
    int k = paramString.indexOf("ufe");
    int j = paramString.indexOf(',', k);
    int i = j;
    if (j == -1) {
      i = paramString.length();
    }
    try
    {
      long l = Long.parseLong(paramString.substring(k + 4, i));
      return l;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      zzb.zzaH("Invalid index for Url fetch time in CSI latency info.");
      return -1L;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        zzb.zzaH("Cannot find valid format of Url fetch time in CSI latency info.");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */