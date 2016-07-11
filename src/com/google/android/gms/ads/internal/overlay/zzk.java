package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zziz;
import java.util.HashMap;

@zzgr
public class zzk
  extends FrameLayout
  implements zzh
{
  private final FrameLayout zzBN;
  private final zzq zzBO;
  private zzi zzBP;
  private boolean zzBQ;
  private boolean zzBR;
  private TextView zzBS;
  private long zzBT;
  private long zzBU;
  private String zzBV;
  private final zziz zzoM;
  private String zzxZ;
  
  public zzk(Context paramContext, zziz paramzziz, int paramInt, zzcg paramzzcg, zzce paramzzce)
  {
    super(paramContext);
    zzoM = paramzziz;
    zzBN = new FrameLayout(paramContext);
    addView(zzBN, new FrameLayout.LayoutParams(-1, -1));
    zzb.zzs(paramzziz.zzhb());
    zzBP = zzhbzzoH.zza(paramContext, paramzziz, paramInt, paramzzcg, paramzzce);
    if (zzBP != null) {
      zzBN.addView(zzBP, new FrameLayout.LayoutParams(-1, -1, 17));
    }
    zzBS = new TextView(paramContext);
    zzBS.setBackgroundColor(-16777216);
    zzeY();
    zzBO = new zzq(this);
    zzBO.zzfg();
    if (zzBP != null) {
      zzBP.zza(this);
    }
    if (zzBP == null) {
      zzh("AdVideoUnderlay Error", "Allocating player failed.");
    }
  }
  
  private void zza(String paramString, String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", paramString);
    int j = paramVarArgs.length;
    int i = 0;
    paramString = null;
    if (i < j)
    {
      String str = paramVarArgs[i];
      if (paramString == null) {}
      for (paramString = str;; paramString = null)
      {
        i += 1;
        break;
        localHashMap.put(paramString, str);
      }
    }
    zzoM.zzb("onVideoEvent", localHashMap);
  }
  
  public static void zzd(zziz paramzziz)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "no_video_view");
    paramzziz.zzb("onVideoEvent", localHashMap);
  }
  
  private void zzeY()
  {
    if (!zzfa())
    {
      zzBN.addView(zzBS, new FrameLayout.LayoutParams(-1, -1));
      zzBN.bringChildToFront(zzBS);
    }
  }
  
  private void zzeZ()
  {
    if (zzfa()) {
      zzBN.removeView(zzBS);
    }
  }
  
  private boolean zzfa()
  {
    return zzBS.getParent() != null;
  }
  
  private void zzfb()
  {
    if (zzoM.zzgZ() == null) {
      break label12;
    }
    label12:
    while (zzBQ) {
      return;
    }
    if ((zzoM.zzgZ().getWindow().getAttributes().flags & 0x80) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      zzBR = bool;
      if (zzBR) {
        break;
      }
      zzoM.zzgZ().getWindow().addFlags(128);
      zzBQ = true;
      return;
    }
  }
  
  private void zzfc()
  {
    if (zzoM.zzgZ() == null) {}
    while ((!zzBQ) || (zzBR)) {
      return;
    }
    zzoM.zzgZ().getWindow().clearFlags(128);
    zzBQ = false;
  }
  
  public void destroy()
  {
    zzBO.cancel();
    if (zzBP != null) {
      zzBP.stop();
    }
    zzfc();
  }
  
  public void onPaused()
  {
    zza("pause", new String[0]);
    zzfc();
  }
  
  public void pause()
  {
    if (zzBP == null) {
      return;
    }
    zzBP.pause();
  }
  
  public void play()
  {
    if (zzBP == null) {
      return;
    }
    zzBP.play();
  }
  
  public void seekTo(int paramInt)
  {
    if (zzBP == null) {
      return;
    }
    zzBP.seekTo(paramInt);
  }
  
  public void setMimeType(String paramString)
  {
    zzBV = paramString;
  }
  
  public void zza(float paramFloat)
  {
    if (zzBP == null) {
      return;
    }
    zzBP.zza(paramFloat);
  }
  
  public void zzan(String paramString)
  {
    zzxZ = paramString;
  }
  
  public void zzd(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 == 0) || (paramInt4 == 0)) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt3 + 2, paramInt4 + 2);
    localLayoutParams.setMargins(paramInt1 - 1, paramInt2 - 1, 0, 0);
    zzBN.setLayoutParams(localLayoutParams);
    requestLayout();
  }
  
  public void zzd(MotionEvent paramMotionEvent)
  {
    if (zzBP == null) {
      return;
    }
    zzBP.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void zzeQ() {}
  
  public void zzeR()
  {
    if (zzBP == null) {}
    while (zzBU != 0L) {
      return;
    }
    zza("canplaythrough", new String[] { "duration", String.valueOf(zzBP.getDuration() / 1000.0F), "videoWidth", String.valueOf(zzBP.getVideoWidth()), "videoHeight", String.valueOf(zzBP.getVideoHeight()) });
  }
  
  public void zzeS()
  {
    zzfb();
  }
  
  public void zzeT()
  {
    zza("ended", new String[0]);
    zzfc();
  }
  
  public void zzeU()
  {
    zzeY();
    zzBU = zzBT;
  }
  
  public void zzeV()
  {
    if (zzBP == null) {
      return;
    }
    if (!TextUtils.isEmpty(zzxZ))
    {
      zzBP.setMimeType(zzBV);
      zzBP.setVideoPath(zzxZ);
      return;
    }
    zza("no_src", new String[0]);
  }
  
  public void zzeW()
  {
    if (zzBP == null) {
      return;
    }
    TextView localTextView = new TextView(zzBP.getContext());
    localTextView.setText("AdMob - " + zzBP.zzer());
    localTextView.setTextColor(-65536);
    localTextView.setBackgroundColor(65280);
    zzBN.addView(localTextView, new FrameLayout.LayoutParams(-2, -2, 17));
    zzBN.bringChildToFront(localTextView);
  }
  
  void zzeX()
  {
    if (zzBP == null) {}
    long l;
    do
    {
      return;
      l = zzBP.getCurrentPosition();
    } while ((zzBT == l) || (l <= 0L));
    zzeZ();
    zza("timeupdate", new String[] { "time", String.valueOf((float)l / 1000.0F) });
    zzBT = l;
  }
  
  public void zzex()
  {
    if (zzBP == null) {
      return;
    }
    zzBP.zzex();
  }
  
  public void zzey()
  {
    if (zzBP == null) {
      return;
    }
    zzBP.zzey();
  }
  
  public void zzh(String paramString1, String paramString2)
  {
    zza("error", new String[] { "what", paramString1, "extra", paramString2 });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */