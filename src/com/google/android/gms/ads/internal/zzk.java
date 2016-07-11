package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import android.view.Window;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjb;

@zzgr
public class zzk
  extends zzc
  implements zzdo
{
  protected transient boolean zzpk = false;
  private boolean zzpl;
  private float zzpm;
  private String zzpn = "background" + hashCode() + "." + "png";
  
  public zzk(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzem, paramVersionInfoParcel, paramzzd);
  }
  
  private void zzb(Bundle paramBundle)
  {
    zzp.zzbv().zzb(zzot.context, zzot.zzqj.zzJu, "gmob-apps", paramBundle, false);
  }
  
  private void zzbm()
  {
    new zza(zzpn).zzgz();
    if (zzot.zzbN())
    {
      zzot.zzbK();
      zzot.zzqo = null;
      zzot.zzpt = false;
      zzpk = false;
    }
  }
  
  public void showInterstitial()
  {
    zzx.zzci("showInterstitial must be called on the main UI thread.");
    if (zzot.zzqo == null)
    {
      zzb.zzaH("The interstitial has not loaded.");
      return;
    }
    if (((Boolean)zzby.zzvo.get()).booleanValue()) {
      if (zzot.context.getApplicationContext() == null) {
        break label211;
      }
    }
    label211:
    for (String str = zzot.context.getApplicationContext().getPackageName();; localObject = zzot.context.getPackageName())
    {
      Bundle localBundle;
      if (!zzpk)
      {
        zzb.zzaH("It is not recommended to show an interstitial before onAdLoaded completes.");
        localBundle = new Bundle();
        localBundle.putString("appid", str);
        localBundle.putString("action", "show_interstitial_before_load_finish");
        zzb(localBundle);
      }
      if (!zzp.zzbv().zzN(zzot.context))
      {
        zzb.zzaH("It is not recommended to show an interstitial when app is not in foreground.");
        localBundle = new Bundle();
        localBundle.putString("appid", str);
        localBundle.putString("action", "show_interstitial_app_not_in_foreground");
        zzb(localBundle);
      }
      if (zzot.zzbO()) {
        break;
      }
      if (!zzot.zzqo.zzEK) {
        break label225;
      }
      try
      {
        zzot.zzqo.zzzv.showInterstitial();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        zzb.zzd("Could not show interstitial.", localRemoteException);
        zzbm();
        return;
      }
    }
    label225:
    if (zzot.zzqo.zzBD == null)
    {
      zzb.zzaH("The interstitial failed to load.");
      return;
    }
    if (zzot.zzqo.zzBD.zzhi())
    {
      zzb.zzaH("The interstitial is already showing.");
      return;
    }
    zzot.zzqo.zzBD.zzC(true);
    if (zzot.zzqo.zzHw != null) {
      zzov.zza(zzot.zzqn, zzot.zzqo);
    }
    if (zzot.zzpt) {}
    for (Object localObject = zzp.zzbv().zzO(zzot.context); (((Boolean)zzby.zzvz.get()).booleanValue()) && (localObject != null); localObject = null)
    {
      new zzb((Bitmap)localObject, zzpn).zzgz();
      return;
    }
    localObject = new InterstitialAdParameterParcel(zzot.zzpt, zzbl(), null, false, 0.0F);
    int j = zzot.zzqo.zzBD.getRequestedOrientation();
    int i = j;
    if (j == -1) {
      i = zzot.zzqo.orientation;
    }
    localObject = new AdOverlayInfoParcel(this, this, this, zzot.zzqo.zzBD, i, zzot.zzqj, zzot.zzqo.zzEP, (InterstitialAdParameterParcel)localObject);
    zzp.zzbt().zza(zzot.context, (AdOverlayInfoParcel)localObject);
  }
  
  protected zziz zza(zzhs.zza paramzza, zze paramzze)
  {
    zziz localzziz = zzp.zzbw().zza(zzot.context, zzot.zzqn, false, false, zzot.zzqi, zzot.zzqj, zzoo, zzow);
    localzziz.zzhe().zzb(this, null, this, this, ((Boolean)zzby.zzvc.get()).booleanValue(), this, this, paramzze, null);
    localzziz.zzaJ(zzHC.zzEC);
    return localzziz;
  }
  
  public void zza(boolean paramBoolean, float paramFloat)
  {
    zzpl = paramBoolean;
    zzpm = paramFloat;
  }
  
  public boolean zza(AdRequestParcel paramAdRequestParcel, zzcg paramzzcg)
  {
    if (zzot.zzqo != null)
    {
      zzb.zzaH("An interstitial is already loading. Aborting.");
      return false;
    }
    return super.zza(paramAdRequestParcel, paramzzcg);
  }
  
  protected boolean zza(AdRequestParcel paramAdRequestParcel, zzhs paramzzhs, boolean paramBoolean)
  {
    if ((zzot.zzbN()) && (zzBD != null)) {
      zzp.zzbx().zza(zzBD.getWebView());
    }
    return zzos.zzbp();
  }
  
  public boolean zza(zzhs paramzzhs1, zzhs paramzzhs2)
  {
    if (!super.zza(paramzzhs1, paramzzhs2)) {
      return false;
    }
    if ((!zzot.zzbN()) && (zzot.zzqG != null) && (zzHw != null)) {
      zzov.zza(zzot.zzqn, paramzzhs2, zzot.zzqG);
    }
    return true;
  }
  
  protected boolean zzaQ()
  {
    zzbm();
    return super.zzaQ();
  }
  
  protected boolean zzaT()
  {
    if (super.zzaT())
    {
      zzpk = true;
      return true;
    }
    return false;
  }
  
  public void zzaW()
  {
    recordImpression();
    super.zzaW();
  }
  
  protected boolean zzbl()
  {
    if (!(zzot.context instanceof Activity)) {}
    Window localWindow;
    do
    {
      return false;
      localWindow = ((Activity)zzot.context).getWindow();
    } while ((localWindow == null) || (localWindow.getDecorView() == null));
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    localWindow.getDecorView().getGlobalVisibleRect(localRect1, null);
    localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect2);
    if ((bottom != 0) && (bottom != 0) && (top == top)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void zzd(boolean paramBoolean)
  {
    zzot.zzpt = paramBoolean;
  }
  
  @zzgr
  private class zza
    extends zzhz
  {
    private final String zzpo;
    
    public zza(String paramString)
    {
      zzpo = paramString;
    }
    
    public void onStop() {}
    
    public void zzbn()
    {
      zzp.zzbv().zzh(zzot.context, zzpo);
    }
  }
  
  @zzgr
  private class zzb
    extends zzhz
  {
    private final String zzpo;
    private final Bitmap zzpq;
    
    public zzb(Bitmap paramBitmap, String paramString)
    {
      zzpq = paramBitmap;
      zzpo = paramString;
    }
    
    public void onStop() {}
    
    public void zzbn()
    {
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if (zzot.zzpt)
      {
        bool1 = zzp.zzbv().zza(zzot.context, zzpq, zzpo);
        bool2 = zzot.zzpt;
        bool3 = zzbl();
        if (!bool1) {
          break label221;
        }
      }
      label221:
      for (final Object localObject = zzpo;; localObject = null)
      {
        localObject = new InterstitialAdParameterParcel(bool2, bool3, (String)localObject, zzk.zza(zzk.this), zzk.zzb(zzk.this));
        int j = zzot.zzqo.zzBD.getRequestedOrientation();
        int i = j;
        if (j == -1) {
          i = zzot.zzqo.orientation;
        }
        localObject = new AdOverlayInfoParcel(zzk.this, zzk.this, zzk.this, zzot.zzqo.zzBD, i, zzot.zzqj, zzot.zzqo.zzEP, (InterstitialAdParameterParcel)localObject);
        zzid.zzIE.post(new Runnable()
        {
          public void run()
          {
            zzp.zzbt().zza(zzot.context, localObject);
          }
        });
        return;
        bool1 = false;
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */