package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzco.zza;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziu;
import com.google.android.gms.internal.zziz;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class zzj
  extends zzco.zza
  implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private final FrameLayout zznZ;
  private final Object zzpd = new Object();
  private final FrameLayout zzwU;
  private final Map<String, WeakReference<View>> zzwV = new HashMap();
  private zzb zzwW;
  boolean zzwX = false;
  int zzwY;
  int zzwZ;
  private zzh zzwx;
  
  public zzj(FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    zzwU = paramFrameLayout1;
    zznZ = paramFrameLayout2;
    zziu.zza(zzwU, this);
    zziu.zza(zzwU, this);
    zzwU.setOnTouchListener(this);
  }
  
  int getMeasuredHeight()
  {
    return zzwU.getMeasuredHeight();
  }
  
  int getMeasuredWidth()
  {
    return zzwU.getMeasuredWidth();
  }
  
  public void onClick(View paramView)
  {
    JSONObject localJSONObject1;
    synchronized (zzpd)
    {
      if (zzwx == null) {
        return;
      }
      localJSONObject1 = new JSONObject();
      localObject2 = zzwV.entrySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          View localView = (View)((WeakReference)localEntry.getValue()).get();
          Point localPoint = zzj(localView);
          JSONObject localJSONObject2 = new JSONObject();
          try
          {
            localJSONObject2.put("width", zzp(localView.getWidth()));
            localJSONObject2.put("height", zzp(localView.getHeight()));
            localJSONObject2.put("x", zzp(x));
            localJSONObject2.put("y", zzp(y));
            localJSONObject1.put((String)localEntry.getKey(), localJSONObject2);
          }
          catch (JSONException localJSONException2)
          {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to get view rectangle for view " + (String)localEntry.getKey());
          }
        }
      }
    }
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("x", zzp(zzwY));
      ((JSONObject)localObject2).put("y", zzp(zzwZ));
      if ((zzwW != null) && (zzwW.zzdu().equals(paramView)))
      {
        zzwx.zza("1007", localJSONObject1, (JSONObject)localObject2);
        return;
      }
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to get click location");
        continue;
        zzwx.zza(paramView, zzwV, localJSONObject1, (JSONObject)localObject2);
      }
    }
  }
  
  public void onGlobalLayout()
  {
    synchronized (zzpd)
    {
      if (zzwX)
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if ((i != 0) && (j != 0))
        {
          zznZ.setLayoutParams(new FrameLayout.LayoutParams(i, j));
          zzwX = false;
        }
      }
      if (zzwx != null) {
        zzwx.zzi(zzwU);
      }
      return;
    }
  }
  
  public void onScrollChanged()
  {
    synchronized (zzpd)
    {
      if (zzwx != null) {
        zzwx.zzi(zzwU);
      }
      return;
    }
  }
  
  public boolean onTouch(View arg1, MotionEvent paramMotionEvent)
  {
    synchronized (zzpd)
    {
      if (zzwx == null) {
        return false;
      }
      Point localPoint = zzc(paramMotionEvent);
      zzwY = x;
      zzwZ = y;
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
      paramMotionEvent.setLocation(x, y);
      zzwx.zzb(paramMotionEvent);
      paramMotionEvent.recycle();
      return false;
    }
  }
  
  public zzd zzW(String paramString)
  {
    synchronized (zzpd)
    {
      paramString = (WeakReference)zzwV.get(paramString);
      if (paramString == null)
      {
        paramString = null;
        paramString = zze.zzy(paramString);
        return paramString;
      }
      paramString = (View)paramString.get();
    }
  }
  
  public void zza(String paramString, zzd paramzzd)
  {
    View localView = (View)zze.zzp(paramzzd);
    paramzzd = zzpd;
    if (localView == null) {}
    for (;;)
    {
      try
      {
        zzwV.remove(paramString);
        return;
      }
      finally {}
      zzwV.put(paramString, new WeakReference(localView));
      localView.setOnTouchListener(this);
      localView.setOnClickListener(this);
    }
  }
  
  public void zzb(final zzd paramzzd)
  {
    synchronized (zzpd)
    {
      zzwX = true;
      paramzzd = (zzh)zze.zzp(paramzzd);
      if (((zzwx instanceof zzg)) && (((zzg)zzwx).zzdB())) {
        ((zzg)zzwx).zzb(paramzzd);
      }
      do
      {
        zznZ.removeAllViews();
        zzwW = zzf(paramzzd);
        if (zzwW != null)
        {
          zzwV.put("1007", new WeakReference(zzwW.zzdu()));
          zznZ.addView(zzwW);
        }
        zzid.zzIE.post(new Runnable()
        {
          public void run()
          {
            zziz localzziz = paramzzd.zzdC();
            if (localzziz != null) {
              zzj.zza(zzj.this).addView(localzziz.getView());
            }
          }
        });
        paramzzd.zzh(zzwU);
        return;
        zzwx = paramzzd;
      } while (!(zzwx instanceof zzg));
      ((zzg)zzwx).zzb(null);
    }
  }
  
  Point zzc(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    zzwU.getLocationOnScreen(arrayOfInt);
    float f1 = paramMotionEvent.getRawX();
    float f2 = arrayOfInt[0];
    float f3 = paramMotionEvent.getRawY();
    float f4 = arrayOfInt[1];
    return new Point((int)(f1 - f2), (int)(f3 - f4));
  }
  
  zzb zzf(zzh paramzzh)
  {
    return paramzzh.zza(this);
  }
  
  Point zzj(View paramView)
  {
    if ((zzwW != null) && (zzwW.zzdu().equals(paramView)))
    {
      localPoint1 = new Point();
      zzwU.getGlobalVisibleRect(new Rect(), localPoint1);
      Point localPoint2 = new Point();
      paramView.getGlobalVisibleRect(new Rect(), localPoint2);
      return new Point(x - x, y - y);
    }
    Point localPoint1 = new Point();
    paramView.getGlobalVisibleRect(new Rect(), localPoint1);
    return localPoint1;
  }
  
  int zzp(int paramInt)
  {
    return zzl.zzcF().zzc(zzwx.getContext(), paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */