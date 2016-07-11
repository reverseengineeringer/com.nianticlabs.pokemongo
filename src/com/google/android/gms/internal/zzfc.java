package com.google.android.gms.internal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzgr
public class zzfc
  extends zzfh
{
  static final Set<String> zzAb = new HashSet(Arrays.asList(new String[] { "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center" }));
  private String zzAc = "top-right";
  private boolean zzAd = true;
  private int zzAe = 0;
  private int zzAf = 0;
  private int zzAg = 0;
  private int zzAh = 0;
  private final Activity zzAi;
  private ImageView zzAj;
  private LinearLayout zzAk;
  private zzfi zzAl;
  private PopupWindow zzAm;
  private RelativeLayout zzAn;
  private ViewGroup zzAo;
  private int zznQ = -1;
  private int zznR = -1;
  private final zziz zzoM;
  private final Object zzpd = new Object();
  private AdSizeParcel zzzm;
  
  public zzfc(zziz paramzziz, zzfi paramzzfi)
  {
    super(paramzziz, "resize");
    zzoM = paramzziz;
    zzAi = paramzziz.zzgZ();
    zzAl = paramzzfi;
  }
  
  private int[] zzee()
  {
    if (!zzeg()) {
      return null;
    }
    if (zzAd) {
      return new int[] { zzAe + zzAg, zzAf + zzAh };
    }
    int[] arrayOfInt1 = zzp.zzbv().zzh(zzAi);
    int[] arrayOfInt2 = zzp.zzbv().zzj(zzAi);
    int m = arrayOfInt1[0];
    int j = zzAe + zzAg;
    int k = zzAf + zzAh;
    int i;
    if (j < 0)
    {
      i = 0;
      if (k >= arrayOfInt2[0]) {
        break label149;
      }
      j = arrayOfInt2[0];
    }
    for (;;)
    {
      return new int[] { i, j };
      i = j;
      if (zznQ + j <= m) {
        break;
      }
      i = m - zznQ;
      break;
      label149:
      j = k;
      if (zznR + k > arrayOfInt2[1]) {
        j = arrayOfInt2[1] - zznR;
      }
    }
  }
  
  private void zzf(Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("width"))) {
      zznQ = zzp.zzbv().zzaA((String)paramMap.get("width"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("height"))) {
      zznR = zzp.zzbv().zzaA((String)paramMap.get("height"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetX"))) {
      zzAg = zzp.zzbv().zzaA((String)paramMap.get("offsetX"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("offsetY"))) {
      zzAh = zzp.zzbv().zzaA((String)paramMap.get("offsetY"));
    }
    if (!TextUtils.isEmpty((CharSequence)paramMap.get("allowOffscreen"))) {
      zzAd = Boolean.parseBoolean((String)paramMap.get("allowOffscreen"));
    }
    paramMap = (String)paramMap.get("customClosePosition");
    if (!TextUtils.isEmpty(paramMap)) {
      zzAc = paramMap;
    }
  }
  
  public void zza(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    synchronized (zzpd)
    {
      zzAe = paramInt1;
      zzAf = paramInt2;
      if ((zzAm != null) && (paramBoolean))
      {
        int[] arrayOfInt = zzee();
        if (arrayOfInt != null)
        {
          zzAm.update(zzl.zzcF().zzb(zzAi, arrayOfInt[0]), zzl.zzcF().zzb(zzAi, arrayOfInt[1]), zzAm.getWidth(), zzAm.getHeight());
          zzc(arrayOfInt[0], arrayOfInt[1]);
        }
      }
      else
      {
        return;
      }
      zzn(true);
    }
  }
  
  void zzb(int paramInt1, int paramInt2)
  {
    if (zzAl != null) {
      zzAl.zza(paramInt1, paramInt2, zznQ, zznR);
    }
  }
  
  void zzc(int paramInt1, int paramInt2)
  {
    zzb(paramInt1, paramInt2 - zzp.zzbv().zzj(zzAi)[0], zznQ, zznR);
  }
  
  public void zzd(int paramInt1, int paramInt2)
  {
    zzAe = paramInt1;
    zzAf = paramInt2;
  }
  
  boolean zzed()
  {
    return (zznQ > -1) && (zznR > -1);
  }
  
  public boolean zzef()
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (zzAm != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  boolean zzeg()
  {
    Object localObject = zzp.zzbv().zzh(zzAi);
    int[] arrayOfInt = zzp.zzbv().zzj(zzAi);
    int k = localObject[0];
    int i = localObject[1];
    if ((zznQ < 50) || (zznQ > k))
    {
      zzb.zzaH("Width is too small or too large.");
      return false;
    }
    if ((zznR < 50) || (zznR > i))
    {
      zzb.zzaH("Height is too small or too large.");
      return false;
    }
    if ((zznR == i) && (zznQ == k))
    {
      zzb.zzaH("Cannot resize to a full-screen ad.");
      return false;
    }
    label184:
    int j;
    if (zzAd)
    {
      localObject = zzAc;
      i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          j = zzAe + zzAg + zznQ - 50;
          i = zzAf + zzAh;
        }
        break;
      }
    }
    while ((j >= 0) && (j + 50 <= k) && (i >= arrayOfInt[0]) && (i + 50 <= arrayOfInt[1]))
    {
      return true;
      if (!((String)localObject).equals("top-left")) {
        break label184;
      }
      i = 0;
      break label184;
      if (!((String)localObject).equals("top-center")) {
        break label184;
      }
      i = 1;
      break label184;
      if (!((String)localObject).equals("center")) {
        break label184;
      }
      i = 2;
      break label184;
      if (!((String)localObject).equals("bottom-left")) {
        break label184;
      }
      i = 3;
      break label184;
      if (!((String)localObject).equals("bottom-center")) {
        break label184;
      }
      i = 4;
      break label184;
      if (!((String)localObject).equals("bottom-right")) {
        break label184;
      }
      i = 5;
      break label184;
      i = zzAe;
      j = zzAg + i;
      i = zzAf + zzAh;
      continue;
      j = zzAe + zzAg + zznQ / 2 - 25;
      i = zzAf + zzAh;
      continue;
      j = zzAe + zzAg + zznQ / 2 - 25;
      i = zzAf + zzAh + zznR / 2 - 25;
      continue;
      i = zzAe;
      j = zzAg + i;
      i = zzAf + zzAh + zznR - 50;
      continue;
      j = zzAe + zzAg + zznQ / 2 - 25;
      i = zzAf + zzAh + zznR - 50;
      continue;
      j = zzAe + zzAg + zznQ - 50;
      i = zzAf + zzAh + zznR - 50;
    }
  }
  
  public void zzg(Map<String, String> paramMap)
  {
    synchronized (zzpd)
    {
      if (zzAi == null)
      {
        zzak("Not an activity context. Cannot resize.");
        return;
      }
      if (zzoM.zzaN() == null)
      {
        zzak("Webview is not yet available, size is not set.");
        return;
      }
    }
    if (zzoM.zzaN().zztf)
    {
      zzak("Is interstitial. Cannot resize an interstitial.");
      return;
    }
    if (zzoM.zzhi())
    {
      zzak("Cannot resize an expanded banner.");
      return;
    }
    zzf(paramMap);
    if (!zzed())
    {
      zzak("Invalid width and height options. Cannot resize.");
      return;
    }
    paramMap = zzAi.getWindow();
    if ((paramMap == null) || (paramMap.getDecorView() == null))
    {
      zzak("Activity context is not ready, cannot get window or decor view.");
      return;
    }
    int[] arrayOfInt = zzee();
    if (arrayOfInt == null)
    {
      zzak("Resize location out of screen or close button is not visible.");
      return;
    }
    int i = zzl.zzcF().zzb(zzAi, zznQ);
    int j = zzl.zzcF().zzb(zzAi, zznR);
    Object localObject2 = zzoM.getView().getParent();
    if ((localObject2 != null) && ((localObject2 instanceof ViewGroup)))
    {
      ((ViewGroup)localObject2).removeView(zzoM.getView());
      if (zzAm == null)
      {
        zzAo = ((ViewGroup)localObject2);
        localObject2 = zzp.zzbv().zzk(zzoM.getView());
        zzAj = new ImageView(zzAi);
        zzAj.setImageBitmap((Bitmap)localObject2);
        zzzm = zzoM.zzaN();
        zzAo.addView(zzAj);
        zzAn = new RelativeLayout(zzAi);
        zzAn.setBackgroundColor(0);
        zzAn.setLayoutParams(new ViewGroup.LayoutParams(i, j));
        zzAm = zzp.zzbv().zza(zzAn, i, j, false);
        zzAm.setOutsideTouchable(true);
        zzAm.setTouchable(true);
        localObject2 = zzAm;
        if (zzAd) {
          break label1071;
        }
      }
    }
    label1023:
    label1027:
    label1029:
    label1071:
    for (boolean bool = true;; bool = false)
    {
      ((PopupWindow)localObject2).setClippingEnabled(bool);
      zzAn.addView(zzoM.getView(), -1, -1);
      zzAk = new LinearLayout(zzAi);
      localObject2 = new RelativeLayout.LayoutParams(zzl.zzcF().zzb(zzAi, 50), zzl.zzcF().zzb(zzAi, 50));
      String str = zzAc;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        for (;;)
        {
          zzAk.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              zzn(true);
            }
          });
          zzAk.setContentDescription("Close button");
          zzAn.addView(zzAk, (ViewGroup.LayoutParams)localObject2);
          try
          {
            zzAm.showAtLocation(paramMap.getDecorView(), 0, zzl.zzcF().zzb(zzAi, arrayOfInt[0]), zzl.zzcF().zzb(zzAi, arrayOfInt[1]));
            zzb(arrayOfInt[0], arrayOfInt[1]);
            zzoM.zza(new AdSizeParcel(zzAi, new AdSize(zznQ, zznR)));
            zzc(arrayOfInt[0], arrayOfInt[1]);
            zzam("resized");
            return;
          }
          catch (RuntimeException paramMap)
          {
            zzak("Cannot show popup window: " + paramMap.getMessage());
            zzAn.removeView(zzoM.getView());
            if (zzAo == null) {
              break label1023;
            }
            zzAo.removeView(zzAj);
            zzAo.addView(zzoM.getView());
            zzoM.zza(zzzm);
            return;
          }
          zzAm.dismiss();
          break;
          zzak("Webview is detached, probably in the middle of a resize or expand.");
          return;
          if (!str.equals("top-left")) {
            break label1027;
          }
          i = 0;
          break label1029;
          if (!str.equals("top-center")) {
            break label1027;
          }
          i = 1;
          break label1029;
          if (!str.equals("center")) {
            break label1027;
          }
          i = 2;
          break label1029;
          if (!str.equals("bottom-left")) {
            break label1027;
          }
          i = 3;
          break label1029;
          if (!str.equals("bottom-center")) {
            break label1027;
          }
          i = 4;
          break label1029;
          if (!str.equals("bottom-right")) {
            break label1027;
          }
          i = 5;
          break label1029;
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(13);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          continue;
          ((RelativeLayout.LayoutParams)localObject2).addRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        }
        i = -1;
        switch (i)
        {
        }
      }
    }
  }
  
  public void zzn(boolean paramBoolean)
  {
    synchronized (zzpd)
    {
      if (zzAm != null)
      {
        zzAm.dismiss();
        zzAn.removeView(zzoM.getView());
        if (zzAo != null)
        {
          zzAo.removeView(zzAj);
          zzAo.addView(zzoM.getView());
          zzoM.zza(zzzm);
        }
        if (paramBoolean)
        {
          zzam("default");
          if (zzAl != null) {
            zzAl.zzbc();
          }
        }
        zzAm = null;
        zzAn = null;
        zzAo = null;
        zzAk = null;
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */