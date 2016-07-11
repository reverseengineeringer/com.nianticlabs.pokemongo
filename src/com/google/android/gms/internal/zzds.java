package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@zzgr
public final class zzds
  implements zzdk
{
  private final Map<zziz, Integer> zzxX = new WeakHashMap();
  
  private static int zza(Context paramContext, Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      i = zzl.zzcF().zzb(paramContext, Integer.parseInt(paramMap));
      return i;
    }
    catch (NumberFormatException paramContext)
    {
      zzb.zzaH("Could not parse " + paramString + " in a video GMSG: " + paramMap);
    }
    return paramInt;
  }
  
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    Object localObject2 = (String)paramMap.get("action");
    if (localObject2 == null) {
      zzb.zzaH("Action missing from video GMSG.");
    }
    int i;
    int j;
    for (;;)
    {
      return;
      if (zzb.zzN(3))
      {
        localObject1 = new JSONObject(paramMap);
        ((JSONObject)localObject1).remove("google.afma.Notify_dt");
        zzb.zzaF("Video GMSG: " + (String)localObject2 + " " + ((JSONObject)localObject1).toString());
      }
      if ("background".equals(localObject2))
      {
        paramMap = (String)paramMap.get("color");
        if (TextUtils.isEmpty(paramMap))
        {
          zzb.zzaH("Color parameter missing from color video GMSG.");
          return;
        }
        try
        {
          i = Color.parseColor(paramMap);
          paramMap = paramzziz.zzhl();
          if (paramMap != null)
          {
            paramMap = paramMap.zzgX();
            if (paramMap != null)
            {
              paramMap.setBackgroundColor(i);
              return;
            }
          }
        }
        catch (IllegalArgumentException paramzziz)
        {
          zzb.zzaH("Invalid color parameter in video GMSG.");
          return;
        }
        zzxX.put(paramzziz, Integer.valueOf(i));
        return;
      }
      localObject1 = paramzziz.zzhl();
      if (localObject1 == null)
      {
        zzb.zzaH("Could not get underlay container for a video GMSG.");
        return;
      }
      boolean bool1 = "new".equals(localObject2);
      boolean bool2 = "position".equals(localObject2);
      if ((bool1) || (bool2))
      {
        localObject2 = paramzziz.getContext();
        j = zza((Context)localObject2, paramMap, "x", 0);
        int k = zza((Context)localObject2, paramMap, "y", 0);
        int m = zza((Context)localObject2, paramMap, "w", -1);
        int n = zza((Context)localObject2, paramMap, "h", -1);
        try
        {
          i = Integer.parseInt((String)paramMap.get("player"));
          if ((bool1) && (((zziy)localObject1).zzgX() == null))
          {
            ((zziy)localObject1).zza(j, k, m, n, i);
            if (!zzxX.containsKey(paramzziz)) {
              continue;
            }
            i = ((Integer)zzxX.get(paramzziz)).intValue();
            paramzziz = ((zziy)localObject1).zzgX();
            paramzziz.setBackgroundColor(i);
            paramzziz.zzeW();
          }
        }
        catch (NumberFormatException paramMap)
        {
          for (;;)
          {
            i = 0;
          }
          ((zziy)localObject1).zze(j, k, m, n);
          return;
        }
      }
    }
    Object localObject1 = ((zziy)localObject1).zzgX();
    if (localObject1 == null)
    {
      zzk.zzd(paramzziz);
      return;
    }
    if ("click".equals(localObject2))
    {
      paramzziz = paramzziz.getContext();
      i = zza(paramzziz, paramMap, "x", 0);
      j = zza(paramzziz, paramMap, "y", 0);
      long l = SystemClock.uptimeMillis();
      paramzziz = MotionEvent.obtain(l, l, 0, i, j, 0);
      ((zzk)localObject1).zzd(paramzziz);
      paramzziz.recycle();
      return;
    }
    if ("currentTime".equals(localObject2))
    {
      paramzziz = (String)paramMap.get("time");
      if (paramzziz == null)
      {
        zzb.zzaH("Time parameter missing from currentTime video GMSG.");
        return;
      }
      try
      {
        ((zzk)localObject1).seekTo((int)(Float.parseFloat(paramzziz) * 1000.0F));
        return;
      }
      catch (NumberFormatException paramMap)
      {
        zzb.zzaH("Could not parse time parameter from currentTime video GMSG: " + paramzziz);
        return;
      }
    }
    if ("hide".equals(localObject2))
    {
      ((zzk)localObject1).setVisibility(4);
      return;
    }
    if ("load".equals(localObject2))
    {
      ((zzk)localObject1).zzeV();
      return;
    }
    if ("mimetype".equals(localObject2))
    {
      ((zzk)localObject1).setMimeType((String)paramMap.get("mimetype"));
      return;
    }
    if ("muted".equals(localObject2))
    {
      if (Boolean.parseBoolean((String)paramMap.get("muted")))
      {
        ((zzk)localObject1).zzex();
        return;
      }
      ((zzk)localObject1).zzey();
      return;
    }
    if ("pause".equals(localObject2))
    {
      ((zzk)localObject1).pause();
      return;
    }
    if ("play".equals(localObject2))
    {
      ((zzk)localObject1).play();
      return;
    }
    if ("show".equals(localObject2))
    {
      ((zzk)localObject1).setVisibility(0);
      return;
    }
    if ("src".equals(localObject2))
    {
      ((zzk)localObject1).zzan((String)paramMap.get("src"));
      return;
    }
    if ("volume".equals(localObject2))
    {
      paramzziz = (String)paramMap.get("volume");
      if (paramzziz == null)
      {
        zzb.zzaH("Level parameter missing from volume video GMSG.");
        return;
      }
      try
      {
        ((zzk)localObject1).zza(Float.parseFloat(paramzziz));
        return;
      }
      catch (NumberFormatException paramMap)
      {
        zzb.zzaH("Could not parse volume parameter from volume video GMSG: " + paramzziz);
        return;
      }
    }
    if ("watermark".equals(localObject2))
    {
      ((zzk)localObject1).zzeW();
      return;
    }
    zzb.zzaH("Unknown video action: " + (String)localObject2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzds
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */