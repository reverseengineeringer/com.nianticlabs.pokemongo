package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzfk.zza;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzja.zza;
import com.google.android.gms.internal.zzjb;
import java.util.Collections;

@zzgr
public class zzd
  extends zzfk.zza
  implements zzo
{
  static final int zzBh = Color.argb(0, 0, 0, 0);
  private final Activity mActivity;
  RelativeLayout zzAn;
  AdOverlayInfoParcel zzBi;
  zzc zzBj;
  zzm zzBk;
  boolean zzBl = false;
  FrameLayout zzBm;
  WebChromeClient.CustomViewCallback zzBn;
  boolean zzBo = false;
  boolean zzBp = false;
  boolean zzBq = false;
  int zzBr = 0;
  private boolean zzBs;
  private boolean zzBt = false;
  private boolean zzBu = true;
  zziz zzoM;
  
  public zzd(Activity paramActivity)
  {
    mActivity = paramActivity;
  }
  
  public void close()
  {
    zzBr = 2;
    mActivity.finish();
  }
  
  public void onBackPressed()
  {
    zzBr = 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    zzBo = bool;
    try
    {
      zzBi = AdOverlayInfoParcel.zzb(mActivity.getIntent());
      if (zzBi != null) {
        break label71;
      }
      throw new zza("Could not get info for ad overlay.");
    }
    catch (zza paramBundle)
    {
      zzb.zzaH(paramBundle.getMessage());
      zzBr = 3;
      mActivity.finish();
    }
    return;
    label71:
    if (zzBi.zzqj.zzJw > 7500000) {
      zzBr = 3;
    }
    if (mActivity.getIntent() != null) {
      zzBu = mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
    }
    if (zzBi.zzBM != null)
    {
      zzBp = zzBi.zzBM.zzpt;
      label142:
      if ((((Boolean)zzby.zzvz.get()).booleanValue()) && (zzBp) && (zzBi.zzBM.zzpv != null)) {
        new zzd(null).zzgz();
      }
      if (paramBundle == null)
      {
        if ((zzBi.zzBC != null) && (zzBu)) {
          zzBi.zzBC.zzaW();
        }
        if ((zzBi.zzBJ != 1) && (zzBi.zzBB != null)) {
          zzBi.zzBB.onAdClicked();
        }
      }
      zzAn = new zzb(mActivity, zzBi.zzBL);
      switch (zzBi.zzBJ)
      {
      }
    }
    for (;;)
    {
      throw new zza("Could not determine ad overlay type.");
      zzBp = false;
      break label142;
      zzv(false);
      return;
      zzBj = new zzc(zzBi.zzBD);
      zzv(false);
      return;
      zzv(true);
      return;
      if (zzBo)
      {
        zzBr = 3;
        mActivity.finish();
        return;
      }
      if (zzp.zzbs().zza(mActivity, zzBi.zzBA, zzBi.zzBI)) {
        break;
      }
      zzBr = 3;
      mActivity.finish();
      return;
    }
  }
  
  public void onDestroy()
  {
    if (zzoM != null) {
      zzAn.removeView(zzoM.getView());
    }
    zzeH();
  }
  
  public void onPause()
  {
    zzeD();
    if ((zzoM != null) && ((!mActivity.isFinishing()) || (zzBj == null))) {
      zzp.zzbx().zza(zzoM.getWebView());
    }
    zzeH();
  }
  
  public void onRestart() {}
  
  public void onResume()
  {
    if ((zzBi != null) && (zzBi.zzBJ == 4))
    {
      if (!zzBo) {
        break label73;
      }
      zzBr = 3;
      mActivity.finish();
    }
    while ((zzoM != null) && (!zzoM.isDestroyed()))
    {
      zzp.zzbx().zzb(zzoM.getWebView());
      return;
      label73:
      zzBo = true;
    }
    zzb.zzaH("The webview does not exit. Ignoring action.");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", zzBo);
  }
  
  public void onStart() {}
  
  public void onStop()
  {
    zzeH();
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    mActivity.setRequestedOrientation(paramInt);
  }
  
  public void zza(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    zzBm = new FrameLayout(mActivity);
    zzBm.setBackgroundColor(-16777216);
    zzBm.addView(paramView, -1, -1);
    mActivity.setContentView(zzBm);
    zzaE();
    zzBn = paramCustomViewCallback;
    zzBl = true;
  }
  
  public void zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (zzBk != null) {
      zzBk.zza(paramBoolean1, paramBoolean2);
    }
  }
  
  public void zzaE()
  {
    zzBs = true;
  }
  
  public void zzeD()
  {
    if ((zzBi != null) && (zzBl)) {
      setRequestedOrientation(zzBi.orientation);
    }
    if (zzBm != null)
    {
      mActivity.setContentView(zzAn);
      zzaE();
      zzBm.removeAllViews();
      zzBm = null;
    }
    if (zzBn != null)
    {
      zzBn.onCustomViewHidden();
      zzBn = null;
    }
    zzBl = false;
  }
  
  public void zzeE()
  {
    zzBr = 1;
    mActivity.finish();
  }
  
  public boolean zzeF()
  {
    zzBr = 0;
    boolean bool1;
    if (zzoM == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = zzoM.zzhk();
      bool1 = bool2;
    } while (bool2);
    zzoM.zzb("onbackblocked", Collections.emptyMap());
    return bool2;
  }
  
  public void zzeG()
  {
    zzAn.removeView(zzBk);
    zzu(true);
  }
  
  protected void zzeH()
  {
    if ((!mActivity.isFinishing()) || (zzBt)) {}
    do
    {
      return;
      zzBt = true;
      if (zzoM != null)
      {
        zzv(zzBr);
        zzAn.removeView(zzoM.getView());
        if (zzBj != null)
        {
          zzoM.setContext(zzBj.context);
          zzoM.zzC(false);
          zzBj.zzBx.addView(zzoM.getView(), zzBj.index, zzBj.zzBw);
          zzBj = null;
        }
        zzoM = null;
      }
    } while ((zzBi == null) || (zzBi.zzBC == null));
    zzBi.zzBC.zzaV();
  }
  
  public void zzeI()
  {
    if (zzBq)
    {
      zzBq = false;
      zzeJ();
    }
  }
  
  protected void zzeJ()
  {
    zzoM.zzeJ();
  }
  
  public void zzu(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 50;
      zzBk = new zzm(mActivity, i, this);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      if (!paramBoolean) {
        break label88;
      }
    }
    label88:
    for (int i = 11;; i = 9)
    {
      localLayoutParams.addRule(i);
      zzBk.zza(paramBoolean, zzBi.zzBG);
      zzAn.addView(zzBk, localLayoutParams);
      return;
      i = 32;
      break;
    }
  }
  
  protected void zzv(int paramInt)
  {
    zzoM.zzv(paramInt);
  }
  
  protected void zzv(boolean paramBoolean)
    throws zzd.zza
  {
    if (!zzBs) {
      mActivity.requestWindowFeature(1);
    }
    Object localObject = mActivity.getWindow();
    if (localObject == null) {
      throw new zza("Invalid activity, no window available.");
    }
    if ((!zzBp) || ((zzBi.zzBM != null) && (zzBi.zzBM.zzpu))) {
      ((Window)localObject).setFlags(1024, 1024);
    }
    boolean bool2 = zzBi.zzBD.zzhe().zzbY();
    zzBq = false;
    boolean bool1;
    if (bool2)
    {
      if (zzBi.orientation != zzp.zzbx().zzgG()) {
        break label527;
      }
      if (mActivity.getResources().getConfiguration().orientation == 1)
      {
        bool1 = true;
        zzBq = bool1;
      }
    }
    else
    {
      label147:
      zzb.zzaF("Delay onShow to next orientation change: " + zzBq);
      setRequestedOrientation(zzBi.orientation);
      if (zzp.zzbx().zza((Window)localObject)) {
        zzb.zzaF("Hardware acceleration on the AdActivity window enabled.");
      }
      if (zzBp) {
        break label575;
      }
      zzAn.setBackgroundColor(-16777216);
      label218:
      mActivity.setContentView(zzAn);
      zzaE();
      if (!paramBoolean) {
        break label642;
      }
      zzoM = zzp.zzbw().zza(mActivity, zzBi.zzBD.zzaN(), true, bool2, null, zzBi.zzqj);
      zzoM.zzhe().zzb(null, null, zzBi.zzBE, zzBi.zzBI, true, zzBi.zzBK, null, zzBi.zzBD.zzhe().zzhq(), null);
      zzoM.zzhe().zza(new zzja.zza()
      {
        public void zza(zziz paramAnonymouszziz, boolean paramAnonymousBoolean)
        {
          paramAnonymouszziz.zzeJ();
        }
      });
      if (zzBi.url == null) {
        break label588;
      }
      zzoM.loadUrl(zzBi.url);
      label372:
      if (zzBi.zzBD != null) {
        zzBi.zzBD.zzc(this);
      }
    }
    for (;;)
    {
      zzoM.zzb(this);
      localObject = zzoM.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeView(zzoM.getView());
      }
      if (zzBp) {
        zzoM.setBackgroundColor(zzBh);
      }
      zzAn.addView(zzoM.getView(), -1, -1);
      if ((!paramBoolean) && (!zzBq)) {
        zzeJ();
      }
      zzu(bool2);
      if (zzoM.zzhf()) {
        zza(bool2, true);
      }
      return;
      bool1 = false;
      break;
      label527:
      if (zzBi.orientation != zzp.zzbx().zzgH()) {
        break label147;
      }
      if (mActivity.getResources().getConfiguration().orientation == 2) {}
      for (bool1 = true;; bool1 = false)
      {
        zzBq = bool1;
        break;
      }
      label575:
      zzAn.setBackgroundColor(zzBh);
      break label218;
      label588:
      if (zzBi.zzBH != null)
      {
        zzoM.loadDataWithBaseURL(zzBi.zzBF, zzBi.zzBH, "text/html", "UTF-8", null);
        break label372;
      }
      throw new zza("No URL or HTML to display in ad overlay.");
      label642:
      zzoM = zzBi.zzBD;
      zzoM.setContext(mActivity);
    }
  }
  
  @zzgr
  private static final class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
  }
  
  @zzgr
  static final class zzb
    extends RelativeLayout
  {
    zzif zzqQ;
    
    public zzb(Context paramContext, String paramString)
    {
      super();
      zzqQ = new zzif(paramContext, paramString);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      zzqQ.zze(paramMotionEvent);
      return false;
    }
  }
  
  @zzgr
  public static class zzc
  {
    public final Context context;
    public final int index;
    public final ViewGroup.LayoutParams zzBw;
    public final ViewGroup zzBx;
    
    public zzc(zziz paramzziz)
      throws zzd.zza
    {
      zzBw = paramzziz.getLayoutParams();
      ViewParent localViewParent = paramzziz.getParent();
      context = paramzziz.zzha();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
      {
        zzBx = ((ViewGroup)localViewParent);
        index = zzBx.indexOfChild(paramzziz.getView());
        zzBx.removeView(paramzziz.getView());
        paramzziz.zzC(true);
        return;
      }
      throw new zzd.zza("Could not get the parent of the WebView for an overlay.");
    }
  }
  
  @zzgr
  private class zzd
    extends zzhz
  {
    private zzd() {}
    
    public void onStop() {}
    
    public void zzbn()
    {
      final Object localObject = zzp.zzbv().zzg(zzd.zza(zzd.this), zzBi.zzBM.zzpv);
      if (localObject != null)
      {
        localObject = zzp.zzbx().zza(zzd.zza(zzd.this), (Bitmap)localObject, zzBi.zzBM.zzpw, zzBi.zzBM.zzpx);
        zzid.zzIE.post(new Runnable()
        {
          public void run()
          {
            zzd.zza(zzd.this).getWindow().setBackgroundDrawable(localObject);
          }
        });
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */