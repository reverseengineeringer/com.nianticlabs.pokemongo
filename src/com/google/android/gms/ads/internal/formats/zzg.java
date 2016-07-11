package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzeq;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zziz;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public class zzg
  extends zzh
{
  private Object zzpd = new Object();
  private zzeq zzwD;
  private zzer zzwE;
  private final zzn zzwF;
  private zzh zzwG;
  private boolean zzwH = false;
  
  private zzg(Context paramContext, zzn paramzzn, zzan paramzzan)
  {
    super(paramContext, paramzzn, null, paramzzan, null, null, null);
    zzwF = paramzzn;
  }
  
  public zzg(Context paramContext, zzn paramzzn, zzan paramzzan, zzeq paramzzeq)
  {
    this(paramContext, paramzzn, paramzzan);
    zzwD = paramzzeq;
  }
  
  public zzg(Context paramContext, zzn paramzzn, zzan paramzzan, zzer paramzzer)
  {
    this(paramContext, paramzzn, paramzzan);
    zzwE = paramzzer;
  }
  
  public void recordImpression()
  {
    zzx.zzci("recordImpression must be called on the main UI thread.");
    for (;;)
    {
      synchronized (zzpd)
      {
        zzl(true);
        if (zzwG != null)
        {
          zzwG.recordImpression();
          zzwF.recordImpression();
          return;
        }
        try
        {
          if ((zzwD != null) && (!zzwD.getOverrideClickHandling())) {
            zzwD.recordImpression();
          }
        }
        catch (RemoteException localRemoteException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call recordImpression", localRemoteException);
        }
      }
      if ((zzwE != null) && (!zzwE.getOverrideClickHandling())) {
        zzwE.recordImpression();
      }
    }
  }
  
  public zzb zza(View.OnClickListener paramOnClickListener)
  {
    return null;
  }
  
  public void zza(View paramView, Map<String, WeakReference<View>> paramMap, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    zzx.zzci("performClick must be called on the main UI thread.");
    synchronized (zzpd)
    {
      if (zzwG != null) {
        zzwG.zza(paramView, paramMap, paramJSONObject1, paramJSONObject2);
      }
      for (;;)
      {
        zzwF.onAdClicked();
        return;
        try
        {
          if ((zzwD != null) && (!zzwD.getOverrideClickHandling())) {
            zzwD.zzc(zze.zzy(paramView));
          }
          if ((zzwE == null) || (zzwE.getOverrideClickHandling())) {
            continue;
          }
          zzwD.zzc(zze.zzy(paramView));
        }
        catch (RemoteException paramView)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call performClick", paramView);
        }
      }
    }
  }
  
  public void zzb(zzh paramzzh)
  {
    synchronized (zzpd)
    {
      zzwG = paramzzh;
      return;
    }
  }
  
  public boolean zzdB()
  {
    synchronized (zzpd)
    {
      boolean bool = zzwH;
      return bool;
    }
  }
  
  public zziz zzdC()
  {
    return null;
  }
  
  public void zzh(View paramView)
  {
    synchronized (zzpd)
    {
      zzwH = true;
      try
      {
        if (zzwD != null) {
          zzwD.zzd(zze.zzy(paramView));
        }
        for (;;)
        {
          zzwH = false;
          return;
          if (zzwE != null) {
            zzwE.zzd(zze.zzy(paramView));
          }
        }
      }
      catch (RemoteException paramView)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call prepareAd", paramView);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */