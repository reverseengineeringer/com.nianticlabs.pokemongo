package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzaz
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private boolean zzpJ = false;
  private final Object zzpd = new Object();
  private zzik zzqM;
  private final Context zzqZ;
  private final WeakReference<zzhs> zzrb;
  private WeakReference<ViewTreeObserver> zzrc;
  private final WeakReference<View> zzrd;
  private final zzax zzre;
  private final zzdz zzrf;
  private final zzdz.zzd zzrg;
  private boolean zzrh;
  private final WindowManager zzri;
  private final PowerManager zzrj;
  private final KeyguardManager zzrk;
  private zzba zzrl;
  private boolean zzrm;
  private boolean zzrn = false;
  private boolean zzro;
  private boolean zzrp;
  private BroadcastReceiver zzrq;
  private final HashSet<zzaw> zzrr = new HashSet();
  private final zzdk zzrs = new zzdk()
  {
    public void zza(zziz paramAnonymouszziz, Map<String, String> paramAnonymousMap)
    {
      if (!zzb(paramAnonymousMap)) {
        return;
      }
      zza(paramAnonymouszziz.getView(), paramAnonymousMap);
    }
  };
  private final zzdk zzrt = new zzdk()
  {
    public void zza(zziz paramAnonymouszziz, Map<String, String> paramAnonymousMap)
    {
      if (!zzb(paramAnonymousMap)) {
        return;
      }
      zzb.zzaF("Received request to untrack: " + zzaz.zzb(zzaz.this).zzbX());
      destroy();
    }
  };
  private final zzdk zzru = new zzdk()
  {
    public void zza(zziz paramAnonymouszziz, Map<String, String> paramAnonymousMap)
    {
      if (!zzb(paramAnonymousMap)) {}
      while (!paramAnonymousMap.containsKey("isVisible")) {
        return;
      }
      if (("1".equals(paramAnonymousMap.get("isVisible"))) || ("true".equals(paramAnonymousMap.get("isVisible")))) {}
      for (boolean bool = true;; bool = false)
      {
        zzg(Boolean.valueOf(bool).booleanValue());
        return;
      }
    }
  };
  
  public zzaz(final AdSizeParcel paramAdSizeParcel, zzhs paramzzhs, VersionInfoParcel paramVersionInfoParcel, View paramView, zzdz paramzzdz)
  {
    zzrf = paramzzdz;
    zzrb = new WeakReference(paramzzhs);
    zzrd = new WeakReference(paramView);
    zzrc = new WeakReference(null);
    zzro = true;
    zzqM = new zzik(200L);
    zzre = new zzax(UUID.randomUUID().toString(), paramVersionInfoParcel, zzte, zzHw, paramzzhs.zzbY());
    zzrg = zzrf.zzdO();
    zzri = ((WindowManager)paramView.getContext().getSystemService("window"));
    zzrj = ((PowerManager)paramView.getContext().getApplicationContext().getSystemService("power"));
    zzrk = ((KeyguardManager)paramView.getContext().getSystemService("keyguard"));
    zzqZ = paramView.getContext().getApplicationContext();
    try
    {
      paramAdSizeParcel = zzd(paramView);
      zzrg.zza(new zzis.zzc()new zzis.zza
      {
        public void zzb(zzbe paramAnonymouszzbe)
        {
          zza(paramAdSizeParcel);
        }
      }, new zzis.zza()
      {
        public void run() {}
      });
      zzrg.zza(new zzis.zzc()new zzis.zza
      {
        public void zzb(zzbe paramAnonymouszzbe)
        {
          zzaz.zzb(zzaz.this, true);
          zza(paramAnonymouszzbe);
          zzbZ();
          zzh(false);
        }
      }, new zzis.zza()
      {
        public void run()
        {
          destroy();
        }
      });
      zzb.zzaF("Tracking ad unit: " + zzre.zzbX());
      return;
    }
    catch (RuntimeException paramAdSizeParcel)
    {
      for (;;)
      {
        zzb.zzb("Failure while processing active view data.", paramAdSizeParcel);
      }
    }
    catch (JSONException paramAdSizeParcel)
    {
      for (;;) {}
    }
  }
  
  protected void destroy()
  {
    synchronized (zzpd)
    {
      zzcf();
      zzca();
      zzro = false;
      zzcc();
      zzrg.release();
      return;
    }
  }
  
  boolean isScreenOn()
  {
    return zzrj.isScreenOn();
  }
  
  public void onGlobalLayout()
  {
    zzh(false);
  }
  
  public void onScrollChanged()
  {
    zzh(true);
  }
  
  public void pause()
  {
    synchronized (zzpd)
    {
      zzpJ = true;
      zzh(false);
      return;
    }
  }
  
  public void resume()
  {
    synchronized (zzpd)
    {
      zzpJ = false;
      zzh(false);
      return;
    }
  }
  
  public void stop()
  {
    synchronized (zzpd)
    {
      zzrn = true;
      zzh(false);
      return;
    }
  }
  
  protected int zza(int paramInt, DisplayMetrics paramDisplayMetrics)
  {
    float f = density;
    return (int)(paramInt / f);
  }
  
  protected void zza(View paramView, Map<String, String> paramMap)
  {
    zzh(false);
  }
  
  public void zza(zzaw paramzzaw)
  {
    zzrr.add(paramzzaw);
  }
  
  public void zza(zzba paramzzba)
  {
    synchronized (zzpd)
    {
      zzrl = paramzzba;
      return;
    }
  }
  
  protected void zza(zzbe paramzzbe)
  {
    paramzzbe.zza("/updateActiveView", zzrs);
    paramzzbe.zza("/untrackActiveViewUnit", zzrt);
    paramzzbe.zza("/visibilityChanged", zzru);
  }
  
  protected void zza(JSONObject paramJSONObject)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      final JSONObject localJSONObject = new JSONObject();
      localJSONArray.put(paramJSONObject);
      localJSONObject.put("units", localJSONArray);
      zzrg.zza(new zzis.zzc()new zzis.zzb
      {
        public void zzb(zzbe paramAnonymouszzbe)
        {
          paramAnonymouszzbe.zza("AFMA_updateActiveView", localJSONObject);
        }
      }, new zzis.zzb());
      return;
    }
    catch (Throwable paramJSONObject)
    {
      zzb.zzb("Skipping active view message.", paramJSONObject);
    }
  }
  
  protected boolean zzb(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return false;
    }
    paramMap = (String)paramMap.get("hashCode");
    if ((!TextUtils.isEmpty(paramMap)) && (paramMap.equals(zzre.zzbX()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void zzbZ()
  {
    synchronized (zzpd)
    {
      if (zzrq != null) {
        return;
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      zzrq = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          zzh(false);
        }
      };
      zzqZ.registerReceiver(zzrq, localIntentFilter);
      return;
    }
  }
  
  protected void zzca()
  {
    synchronized (zzpd)
    {
      if (zzrq != null)
      {
        zzqZ.unregisterReceiver(zzrq);
        zzrq = null;
      }
      return;
    }
  }
  
  public void zzcb()
  {
    synchronized (zzpd)
    {
      if (zzro) {
        zzrp = true;
      }
    }
    try
    {
      zza(zzch());
      zzb.zzaF("Untracking ad unit: " + zzre.zzbX());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        zzb.zzb("JSON failure while processing active view data.", localJSONException);
      }
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        zzb.zzb("Failure while processing active view data.", localRuntimeException);
      }
    }
  }
  
  protected void zzcc()
  {
    if (zzrl != null) {
      zzrl.zza(this);
    }
  }
  
  public boolean zzcd()
  {
    synchronized (zzpd)
    {
      boolean bool = zzro;
      return bool;
    }
  }
  
  protected void zzce()
  {
    Object localObject = (View)zzrd.get();
    if (localObject == null) {}
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localViewTreeObserver = (ViewTreeObserver)zzrc.get();
      localObject = ((View)localObject).getViewTreeObserver();
    } while (localObject == localViewTreeObserver);
    zzcf();
    if ((!zzrm) || ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())))
    {
      zzrm = true;
      ((ViewTreeObserver)localObject).addOnScrollChangedListener(this);
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(this);
    }
    zzrc = new WeakReference(localObject);
  }
  
  protected void zzcf()
  {
    ViewTreeObserver localViewTreeObserver = (ViewTreeObserver)zzrc.get();
    if ((localViewTreeObserver == null) || (!localViewTreeObserver.isAlive())) {
      return;
    }
    localViewTreeObserver.removeOnScrollChangedListener(this);
    localViewTreeObserver.removeGlobalOnLayoutListener(this);
  }
  
  protected JSONObject zzcg()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("afmaVersion", zzre.zzbV()).put("activeViewJSON", zzre.zzbW()).put("timestamp", zzp.zzbz().elapsedRealtime()).put("adFormat", zzre.zzbU()).put("hashCode", zzre.zzbX()).put("isMraid", zzre.zzbY());
    return localJSONObject;
  }
  
  protected JSONObject zzch()
    throws JSONException
  {
    JSONObject localJSONObject = zzcg();
    localJSONObject.put("doneReasonCode", "u");
    return localJSONObject;
  }
  
  protected JSONObject zzd(View paramView)
    throws JSONException
  {
    boolean bool1 = zzp.zzbx().isAttachedToWindow(paramView);
    Object localObject2 = new int[2];
    Object localObject1 = new int[2];
    try
    {
      paramView.getLocationOnScreen((int[])localObject2);
      paramView.getLocationInWindow((int[])localObject1);
      localObject1 = paramView.getContext().getResources().getDisplayMetrics();
      Rect localRect1 = new Rect();
      left = localObject2[0];
      top = localObject2[1];
      right = (left + paramView.getWidth());
      bottom = (top + paramView.getHeight());
      localObject2 = new Rect();
      right = zzri.getDefaultDisplay().getWidth();
      bottom = zzri.getDefaultDisplay().getHeight();
      Rect localRect2 = new Rect();
      boolean bool2 = paramView.getGlobalVisibleRect(localRect2, null);
      Rect localRect3 = new Rect();
      boolean bool3 = paramView.getLocalVisibleRect(localRect3);
      Rect localRect4 = new Rect();
      paramView.getHitRect(localRect4);
      JSONObject localJSONObject = zzcg();
      localJSONObject.put("windowVisibility", paramView.getWindowVisibility()).put("isStopped", zzrn).put("isPaused", zzpJ).put("isScreenOn", isScreenOn()).put("isAttachedToWindow", bool1).put("viewBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("adBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("globalVisibleBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("globalVisibleBoxVisible", bool2).put("localVisibleBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("localVisibleBoxVisible", bool3).put("hitBox", new JSONObject().put("top", zza(top, (DisplayMetrics)localObject1)).put("bottom", zza(bottom, (DisplayMetrics)localObject1)).put("left", zza(left, (DisplayMetrics)localObject1)).put("right", zza(right, (DisplayMetrics)localObject1))).put("screenDensity", density).put("isVisible", zze(paramView));
      return localJSONObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        zzb.zzb("Failure getting view location.", localException);
      }
    }
  }
  
  protected boolean zze(View paramView)
  {
    return (paramView.getVisibility() == 0) && (paramView.isShown()) && (isScreenOn()) && ((!zzrk.inKeyguardRestrictedInputMode()) || (zzp.zzbv().zzgB()));
  }
  
  protected void zzg(boolean paramBoolean)
  {
    Iterator localIterator = zzrr.iterator();
    while (localIterator.hasNext()) {
      ((zzaw)localIterator.next()).zza(this, paramBoolean);
    }
  }
  
  protected void zzh(boolean paramBoolean)
  {
    synchronized (zzpd)
    {
      if ((!zzrh) || (!zzro)) {
        return;
      }
      if ((paramBoolean) && (!zzqM.tryAcquire())) {
        return;
      }
    }
    zzhs localzzhs = (zzhs)zzrb.get();
    View localView = (View)zzrd.get();
    if (localView != null) {
      if (localzzhs == null) {
        break label139;
      }
    }
    for (;;)
    {
      int i;
      if (i != 0)
      {
        zzcb();
        return;
        i = 0;
        continue;
      }
      try
      {
        zza(zzd(localView));
        for (;;)
        {
          zzce();
          zzcc();
          return;
          zzb.zza("Active view update failed.", localzzhs);
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;) {}
        i = 1;
      }
      catch (JSONException localJSONException)
      {
        label139:
        for (;;) {}
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */