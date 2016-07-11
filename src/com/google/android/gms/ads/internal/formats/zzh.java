package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzja.zza;
import com.google.android.gms.internal.zzjb;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzh
{
  private final Context mContext;
  private zziz zzoM;
  private final VersionInfoParcel zzpb;
  private final Object zzpd = new Object();
  private final zzn zzwF;
  private final JSONObject zzwI;
  private final zzbb zzwJ;
  private final zza zzwK;
  private final zzan zzwL;
  private boolean zzwM;
  private String zzwN;
  
  public zzh(Context paramContext, zzn paramzzn, zzbb paramzzbb, zzan paramzzan, JSONObject paramJSONObject, zza paramzza, VersionInfoParcel paramVersionInfoParcel)
  {
    mContext = paramContext;
    zzwF = paramzzn;
    zzwJ = paramzzbb;
    zzwL = paramzzan;
    zzwI = paramJSONObject;
    zzwK = paramzza;
    zzpb = paramVersionInfoParcel;
  }
  
  public Context getContext()
  {
    return mContext;
  }
  
  public void recordImpression()
  {
    zzx.zzci("recordImpression must be called on the main UI thread.");
    zzl(true);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ad", zzwI);
      zzwJ.zza("google.afma.nativeAds.handleImpressionPing", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to create impression JSON.", localJSONException);
    }
  }
  
  public zzb zza(View.OnClickListener paramOnClickListener)
  {
    Object localObject = zzwK.zzdz();
    if (localObject == null) {
      return null;
    }
    localObject = new zzb(mContext, (zza)localObject);
    ((zzb)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    ((zzb)localObject).zzdu().setOnClickListener(paramOnClickListener);
    ((zzb)localObject).zzdu().setContentDescription("Ad attribution icon");
    return (zzb)localObject;
  }
  
  public void zza(View paramView, Map<String, WeakReference<View>> paramMap, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    zzx.zzci("performClick must be called on the main UI thread.");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (paramView.equals((View)((WeakReference)localEntry.getValue()).get())) {
        zza((String)localEntry.getKey(), paramJSONObject1, paramJSONObject2);
      }
    }
  }
  
  public void zza(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    zzx.zzci("performClick must be called on the main UI thread.");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("asset", paramString);
      localJSONObject.put("template", zzwK.zzdy());
      paramString = new JSONObject();
      paramString.put("ad", zzwI);
      paramString.put("click", localJSONObject);
      if (zzwF.zzr(zzwK.getCustomTemplateId()) != null) {}
      for (boolean bool = true;; bool = false)
      {
        paramString.put("has_custom_click_handler", bool);
        if (paramJSONObject1 != null) {
          paramString.put("view_rectangles", paramJSONObject1);
        }
        if (paramJSONObject2 != null) {
          paramString.put("click_point", paramJSONObject2);
        }
        zzwJ.zza("google.afma.nativeAds.handleClickGmsg", paramString);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to create click JSON.", paramString);
    }
  }
  
  public void zzb(MotionEvent paramMotionEvent)
  {
    zzwL.zza(paramMotionEvent);
  }
  
  public zziz zzdC()
  {
    zzoM = zzdD();
    zzoM.getView().setVisibility(8);
    zzwJ.zza("/loadHtml", new zzdk()
    {
      public void zza(zziz paramAnonymouszziz, final Map<String, String> paramAnonymousMap)
      {
        zzh.zze(zzh.this).zzhe().zza(new zzja.zza()
        {
          public void zza(zziz paramAnonymous2zziz, boolean paramAnonymous2Boolean)
          {
            zzh.zza(zzh.this, (String)paramAnonymousMap.get("id"));
            paramAnonymous2zziz = new JSONObject();
            try
            {
              paramAnonymous2zziz.put("messageType", "htmlLoaded");
              paramAnonymous2zziz.put("id", zzh.zzc(zzh.this));
              zzh.zzd(zzh.this).zzb("sendMessageToNativeJs", paramAnonymous2zziz);
              return;
            }
            catch (JSONException paramAnonymous2zziz)
            {
              com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to dispatch sendMessageToNativeJsevent", paramAnonymous2zziz);
            }
          }
        });
        paramAnonymouszziz = (String)paramAnonymousMap.get("overlayHtml");
        paramAnonymousMap = (String)paramAnonymousMap.get("baseUrl");
        if (TextUtils.isEmpty(paramAnonymousMap))
        {
          zzh.zze(zzh.this).loadData(paramAnonymouszziz, "text/html", "UTF-8");
          return;
        }
        zzh.zze(zzh.this).loadDataWithBaseURL(paramAnonymousMap, paramAnonymouszziz, "text/html", "UTF-8", null);
      }
    });
    zzwJ.zza("/showOverlay", new zzdk()
    {
      public void zza(zziz paramAnonymouszziz, Map<String, String> paramAnonymousMap)
      {
        zzh.zze(zzh.this).getView().setVisibility(0);
      }
    });
    zzwJ.zza("/hideOverlay", new zzdk()
    {
      public void zza(zziz paramAnonymouszziz, Map<String, String> paramAnonymousMap)
      {
        zzh.zze(zzh.this).getView().setVisibility(8);
      }
    });
    zzoM.zzhe().zza("/hideOverlay", new zzdk()
    {
      public void zza(zziz paramAnonymouszziz, Map<String, String> paramAnonymousMap)
      {
        zzh.zze(zzh.this).getView().setVisibility(8);
      }
    });
    zzoM.zzhe().zza("/sendMessageToSdk", new zzdk()
    {
      public void zza(zziz paramAnonymouszziz, Map<String, String> paramAnonymousMap)
      {
        paramAnonymouszziz = new JSONObject();
        try
        {
          Iterator localIterator = paramAnonymousMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            paramAnonymouszziz.put(str, paramAnonymousMap.get(str));
          }
          paramAnonymouszziz.put("id", zzh.zzc(zzh.this));
        }
        catch (JSONException paramAnonymouszziz)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzb("Unable to dispatch sendMessageToNativeJs event", paramAnonymouszziz);
          return;
        }
        zzh.zzd(zzh.this).zzb("sendMessageToNativeJs", paramAnonymouszziz);
      }
    });
    return zzoM;
  }
  
  zziz zzdD()
  {
    return zzp.zzbw().zza(mContext, AdSizeParcel.zzs(mContext), false, false, zzwL, zzpb);
  }
  
  public void zzh(View paramView) {}
  
  public void zzi(View paramView)
  {
    synchronized (zzpd)
    {
      if (zzwM) {
        return;
      }
      if (!paramView.isShown()) {
        return;
      }
    }
    if (!paramView.getGlobalVisibleRect(new Rect(), null)) {
      return;
    }
    recordImpression();
  }
  
  protected void zzl(boolean paramBoolean)
  {
    zzwM = paramBoolean;
  }
  
  public static abstract interface zza
  {
    public abstract String getCustomTemplateId();
    
    public abstract void zza(zzh paramzzh);
    
    public abstract String zzdy();
    
    public abstract zza zzdz();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */