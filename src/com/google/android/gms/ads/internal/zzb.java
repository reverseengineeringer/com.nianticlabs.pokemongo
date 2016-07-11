package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzdm;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzfp;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzmi;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@zzgr
public abstract class zzb
  extends zza
  implements com.google.android.gms.ads.internal.overlay.zzg, zzj, zzdm, zzef
{
  private final Messenger mMessenger;
  protected final zzem zzox;
  protected transient boolean zzoy;
  
  public zzb(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    this(new zzq(paramContext, paramAdSizeParcel, paramString, paramVersionInfoParcel), paramzzem, null, paramzzd);
  }
  
  zzb(zzq paramzzq, zzem paramzzem, zzo paramzzo, zzd paramzzd)
  {
    super(paramzzq, paramzzo, paramzzd);
    zzox = paramzzem;
    mMessenger = new Messenger(new zzfp(zzot.context));
    zzoy = false;
  }
  
  private AdRequestInfoParcel.zza zza(AdRequestParcel paramAdRequestParcel, Bundle paramBundle)
  {
    ApplicationInfo localApplicationInfo = zzot.context.getApplicationInfo();
    DisplayMetrics localDisplayMetrics;
    String str1;
    Object localObject;
    String str2;
    long l1;
    Bundle localBundle;
    ArrayList localArrayList;
    PackageInfo localPackageInfo2;
    try
    {
      PackageInfo localPackageInfo1 = zzot.context.getPackageManager().getPackageInfo(packageName, 0);
      localDisplayMetrics = zzot.context.getResources().getDisplayMetrics();
      str1 = null;
      localObject = str1;
      if (zzot.zzqk != null)
      {
        localObject = str1;
        if (zzot.zzqk.getParent() != null)
        {
          localObject = new int[2];
          zzot.zzqk.getLocationOnScreen((int[])localObject);
          int k = localObject[0];
          int m = localObject[1];
          int n = zzot.zzqk.getWidth();
          int i1 = zzot.zzqk.getHeight();
          int j = 0;
          i = j;
          if (zzot.zzqk.isShown())
          {
            i = j;
            if (k + n > 0)
            {
              i = j;
              if (m + i1 > 0)
              {
                i = j;
                if (k <= widthPixels)
                {
                  i = j;
                  if (m <= heightPixels) {
                    i = 1;
                  }
                }
              }
            }
          }
          localObject = new Bundle(5);
          ((Bundle)localObject).putInt("x", k);
          ((Bundle)localObject).putInt("y", m);
          ((Bundle)localObject).putInt("width", n);
          ((Bundle)localObject).putInt("height", i1);
          ((Bundle)localObject).putInt("visible", i);
        }
      }
      str1 = zzp.zzby().zzgm();
      zzot.zzqq = new zzht(str1, zzot.zzqh);
      zzot.zzqq.zzi(paramAdRequestParcel);
      str2 = zzp.zzbv().zza(zzot.context, zzot.zzqk, zzot.zzqn);
      l2 = 0L;
      l1 = l2;
      if (zzot.zzqu == null) {}
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        l1 = zzot.zzqu.getValue();
        String str3 = UUID.randomUUID().toString();
        localBundle = zzp.zzby().zza(zzot.context, this, str1);
        localArrayList = new ArrayList();
        int i = 0;
        while (i < zzot.zzqA.size())
        {
          localArrayList.add(zzot.zzqA.keyAt(i));
          i += 1;
          continue;
          localNameNotFoundException = localNameNotFoundException;
          localPackageInfo2 = null;
        }
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          long l2;
          com.google.android.gms.ads.internal.util.client.zzb.zzaH("Cannot get correlation id, default to 0.");
          l1 = l2;
        }
      }
    }
    boolean bool1;
    if (zzot.zzqv != null)
    {
      bool1 = true;
      if ((zzot.zzqw == null) || (!zzp.zzby().zzgv())) {
        break label622;
      }
    }
    label622:
    for (boolean bool2 = true;; bool2 = false)
    {
      return new AdRequestInfoParcel.zza((Bundle)localObject, paramAdRequestParcel, zzot.zzqn, zzot.zzqh, localApplicationInfo, localPackageInfo2, str1, zzp.zzby().getSessionId(), zzot.zzqj, localBundle, zzot.zzqD, localArrayList, paramBundle, zzp.zzby().zzgq(), mMessenger, widthPixels, heightPixels, density, str2, l1, localRemoteException, zzby.zzdf(), zzot.zzqg, zzot.zzqB, new CapabilityParcel(bool1, bool2), zzot.zzbR());
      bool1 = false;
      break;
    }
  }
  
  public String getMediationAdapterClassName()
  {
    if (zzot.zzqo == null) {
      return null;
    }
    return zzot.zzqo.zzzw;
  }
  
  public void onAdClicked()
  {
    if (zzot.zzqo == null)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping click URLs.");
      return;
    }
    if ((zzot.zzqo.zzHx != null) && (zzot.zzqo.zzHx.zzyY != null)) {
      zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, zzot.zzqo, zzot.zzqh, false, zzot.zzqo.zzHx.zzyY);
    }
    if ((zzot.zzqo.zzzu != null) && (zzot.zzqo.zzzu.zzyR != null)) {
      zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, zzot.zzqo, zzot.zzqh, false, zzot.zzqo.zzzu.zzyR);
    }
    super.onAdClicked();
  }
  
  public void pause()
  {
    zzx.zzci("pause must be called on the main UI thread.");
    if ((zzot.zzqo != null) && (zzot.zzqo.zzBD != null) && (zzot.zzbN())) {
      zzp.zzbx().zza(zzot.zzqo.zzBD.getWebView());
    }
    if ((zzot.zzqo != null) && (zzot.zzqo.zzzv != null)) {}
    try
    {
      zzot.zzqo.zzzv.pause();
      zzov.zzg(zzot.zzqo);
      zzos.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not pause mediation adapter.");
      }
    }
  }
  
  public void resume()
  {
    zzx.zzci("resume must be called on the main UI thread.");
    if ((zzot.zzqo != null) && (zzot.zzqo.zzBD != null) && (zzot.zzbN())) {
      zzp.zzbx().zzb(zzot.zzqo.zzBD.getWebView());
    }
    if ((zzot.zzqo != null) && (zzot.zzqo.zzzv != null)) {}
    try
    {
      zzot.zzqo.zzzv.resume();
      zzos.resume();
      zzov.zzh(zzot.zzqo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not resume mediation adapter.");
      }
    }
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("showInterstitial is not supported for current ad type");
  }
  
  public void zza(zzfs paramzzfs)
  {
    zzx.zzci("setInAppPurchaseListener must be called on the main UI thread.");
    zzot.zzqv = paramzzfs;
  }
  
  public void zza(zzfw paramzzfw, String paramString)
  {
    zzx.zzci("setPlayStorePurchaseParams must be called on the main UI thread.");
    zzot.zzqE = new zzk(paramString);
    zzot.zzqw = paramzzfw;
    if ((!zzp.zzby().zzgp()) && (paramzzfw != null)) {
      new zzc(zzot.context, zzot.zzqw, zzot.zzqE).zzgz();
    }
  }
  
  protected void zza(zzhs paramzzhs, boolean paramBoolean)
  {
    if (paramzzhs == null) {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Ad state was null when trying to ping impression URLs.");
    }
    do
    {
      return;
      super.zzc(paramzzhs);
      if ((zzHx != null) && (zzHx.zzyZ != null)) {
        zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, paramzzhs, zzot.zzqh, paramBoolean, zzHx.zzyZ);
      }
    } while ((zzzu == null) || (zzzu.zzyS == null));
    zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, paramzzhs, zzot.zzqh, paramBoolean, zzzu.zzyS);
  }
  
  public void zza(String paramString, ArrayList<String> paramArrayList)
  {
    paramArrayList = new com.google.android.gms.ads.internal.purchase.zzd(paramString, paramArrayList, zzot.context, zzot.zzqj.zzJu);
    if (zzot.zzqv == null)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("InAppPurchaseListener is not set. Try to launch default purchase flow.");
      if (!zzl.zzcF().zzR(zzot.context))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Google Play Service unavailable, cannot launch default purchase flow.");
        return;
      }
      if (zzot.zzqw == null)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("PlayStorePurchaseListener is not set.");
        return;
      }
      if (zzot.zzqE == null)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("PlayStorePurchaseVerifier is not initialized.");
        return;
      }
      if (zzot.zzqI)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("An in-app purchase request is already in progress, abort");
        return;
      }
      zzot.zzqI = true;
      try
      {
        if (!zzot.zzqw.isValidPurchase(paramString))
        {
          zzot.zzqI = false;
          return;
        }
      }
      catch (RemoteException paramString)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not start In-App purchase.");
        zzot.zzqI = false;
        return;
      }
      zzp.zzbF().zza(zzot.context, zzot.zzqj.zzJx, new GInAppPurchaseManagerInfoParcel(zzot.context, zzot.zzqE, paramArrayList, this));
      return;
    }
    try
    {
      zzot.zzqv.zza(paramArrayList);
      return;
    }
    catch (RemoteException paramString)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not start In-App purchase.");
    }
  }
  
  public void zza(String paramString, boolean paramBoolean, int paramInt, final Intent paramIntent, zzf paramzzf)
  {
    try
    {
      if (zzot.zzqw != null) {
        zzot.zzqw.zza(new com.google.android.gms.ads.internal.purchase.zzg(zzot.context, paramString, paramBoolean, paramInt, paramIntent, paramzzf));
      }
      zzid.zzIE.postDelayed(new Runnable()
      {
        public void run()
        {
          int i = zzp.zzbF().zzd(paramIntent);
          zzp.zzbF();
          if ((i == 0) && (zzot.zzqo != null) && (zzot.zzqo.zzBD != null) && (zzot.zzqo.zzBD.zzhc() != null)) {
            zzot.zzqo.zzBD.zzhc().close();
          }
          zzot.zzqI = false;
        }
      }, 500L);
      return;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to invoke PlayStorePurchaseListener.");
      }
    }
  }
  
  public boolean zza(AdRequestParcel paramAdRequestParcel, zzcg paramzzcg)
  {
    if (!zzaU()) {
      return false;
    }
    Bundle localBundle = zza(zzp.zzby().zzE(zzot.context));
    zzos.cancel();
    zzot.zzqH = 0;
    paramAdRequestParcel = zza(paramAdRequestParcel, localBundle);
    paramzzcg.zze("seq_num", zzEq);
    paramzzcg.zze("request_id", zzEC);
    paramzzcg.zze("session_id", zzEr);
    if (zzEo != null) {
      paramzzcg.zze("app_version", String.valueOf(zzEo.versionCode));
    }
    zzot.zzql = zzp.zzbr().zza(zzot.context, paramAdRequestParcel, zzot.zzqi, this);
    return true;
  }
  
  protected boolean zza(AdRequestParcel paramAdRequestParcel, zzhs paramzzhs, boolean paramBoolean)
  {
    if ((!paramBoolean) && (zzot.zzbN()))
    {
      if (zzzc <= 0L) {
        break label43;
      }
      zzos.zza(paramAdRequestParcel, zzzc);
    }
    for (;;)
    {
      return zzos.zzbp();
      label43:
      if ((zzHx != null) && (zzHx.zzzc > 0L)) {
        zzos.zza(paramAdRequestParcel, zzHx.zzzc);
      } else if ((!zzEK) && (errorCode == 2)) {
        zzos.zzg(paramAdRequestParcel);
      }
    }
  }
  
  boolean zza(zzhs paramzzhs)
  {
    boolean bool = false;
    Object localObject;
    if (zzou != null)
    {
      localObject = zzou;
      zzou = null;
    }
    for (;;)
    {
      return zza((AdRequestParcel)localObject, paramzzhs, bool);
      AdRequestParcel localAdRequestParcel = zzEn;
      localObject = localAdRequestParcel;
      if (extras != null)
      {
        bool = extras.getBoolean("_noRefresh", false);
        localObject = localAdRequestParcel;
      }
    }
  }
  
  protected boolean zza(zzhs paramzzhs1, zzhs paramzzhs2)
  {
    int i = 0;
    if ((paramzzhs1 != null) && (zzzx != null)) {
      zzzx.zza(null);
    }
    if (zzzx != null) {
      zzzx.zza(this);
    }
    int j;
    if (zzHx != null)
    {
      j = zzHx.zzzf;
      i = zzHx.zzzg;
    }
    for (;;)
    {
      zzot.zzqF.zzf(j, i);
      return true;
      j = 0;
    }
  }
  
  protected boolean zzaU()
  {
    boolean bool = true;
    if ((!zzp.zzbv().zza(zzot.context.getPackageManager(), zzot.context.getPackageName(), "android.permission.INTERNET")) || (!zzp.zzbv().zzH(zzot.context))) {
      bool = false;
    }
    return bool;
  }
  
  public void zzaV()
  {
    zzov.zze(zzot.zzqo);
    zzoy = false;
    zzaQ();
    zzot.zzqq.zzgh();
  }
  
  public void zzaW()
  {
    zzoy = true;
    zzaS();
  }
  
  public void zzaX()
  {
    onAdClicked();
  }
  
  public void zzaY()
  {
    zzaV();
  }
  
  public void zzaZ()
  {
    zzaO();
  }
  
  public void zzb(zzhs paramzzhs)
  {
    super.zzb(paramzzhs);
    if ((errorCode == 3) && (zzHx != null) && (zzHx.zzza != null))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaF("Pinging no fill URLs.");
      zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, paramzzhs, zzot.zzqh, false, zzHx.zzza);
    }
  }
  
  public void zzba()
  {
    zzaW();
  }
  
  public void zzbb()
  {
    if (zzot.zzqo != null) {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Mediation adapter " + zzot.zzqo.zzzw + " refreshed, but mediation adapters should never refresh.");
    }
    zza(zzot.zzqo, true);
    zzaT();
  }
  
  protected boolean zzc(AdRequestParcel paramAdRequestParcel)
  {
    return (super.zzc(paramAdRequestParcel)) && (!zzoy);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */