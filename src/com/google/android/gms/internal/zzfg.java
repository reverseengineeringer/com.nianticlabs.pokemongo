package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzgr
public class zzfg
  extends zzfh
  implements zzdk
{
  private final Context mContext;
  private final zzbq zzAA;
  DisplayMetrics zzAB;
  private float zzAC;
  int zzAD = -1;
  int zzAE = -1;
  private int zzAF;
  int zzAG = -1;
  int zzAH = -1;
  int zzAI = -1;
  int zzAJ = -1;
  private final zziz zzoM;
  private final WindowManager zzri;
  
  public zzfg(zziz paramzziz, Context paramContext, zzbq paramzzbq)
  {
    super(paramzziz);
    zzoM = paramzziz;
    mContext = paramContext;
    zzAA = paramzzbq;
    zzri = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  private void zzei()
  {
    zzAB = new DisplayMetrics();
    Display localDisplay = zzri.getDefaultDisplay();
    localDisplay.getMetrics(zzAB);
    zzAC = zzAB.density;
    zzAF = localDisplay.getRotation();
  }
  
  private void zzen()
  {
    int[] arrayOfInt = new int[2];
    zzoM.getLocationOnScreen(arrayOfInt);
    zze(zzl.zzcF().zzc(mContext, arrayOfInt[0]), zzl.zzcF().zzc(mContext, arrayOfInt[1]));
  }
  
  private zzff zzeq()
  {
    return new zzff.zza().zzp(zzAA.zzcW()).zzo(zzAA.zzcX()).zzq(zzAA.zzdb()).zzr(zzAA.zzcY()).zzs(zzAA.zzcZ()).zzeh();
  }
  
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    zzel();
  }
  
  public void zze(int paramInt1, int paramInt2)
  {
    if ((mContext instanceof Activity)) {}
    for (int i = zzp.zzbv().zzj((Activity)mContext)[0];; i = 0)
    {
      zzc(paramInt1, paramInt2 - i, zzAI, zzAJ);
      zzoM.zzhe().zzd(paramInt1, paramInt2);
      return;
    }
  }
  
  void zzej()
  {
    zzAD = zzl.zzcF().zzb(zzAB, zzAB.widthPixels);
    zzAE = zzl.zzcF().zzb(zzAB, zzAB.heightPixels);
    Object localObject = zzoM.zzgZ();
    if ((localObject == null) || (((Activity)localObject).getWindow() == null))
    {
      zzAG = zzAD;
      zzAH = zzAE;
      return;
    }
    localObject = zzp.zzbv().zzg((Activity)localObject);
    zzAG = zzl.zzcF().zzb(zzAB, localObject[0]);
    zzAH = zzl.zzcF().zzb(zzAB, localObject[1]);
  }
  
  void zzek()
  {
    if (zzoM.zzaN().zztf)
    {
      zzAI = zzAD;
      zzAJ = zzAE;
      return;
    }
    zzoM.measure(0, 0);
    zzAI = zzl.zzcF().zzc(mContext, zzoM.getMeasuredWidth());
    zzAJ = zzl.zzcF().zzc(mContext, zzoM.getMeasuredHeight());
  }
  
  public void zzel()
  {
    zzei();
    zzej();
    zzek();
    zzeo();
    zzep();
    zzen();
    zzem();
  }
  
  void zzem()
  {
    if (zzb.zzN(2)) {
      zzb.zzaG("Dispatching Ready Event.");
    }
    zzal(zzoM.zzhh().zzJu);
  }
  
  void zzeo()
  {
    zza(zzAD, zzAE, zzAG, zzAH, zzAC, zzAF);
  }
  
  void zzep()
  {
    zzff localzzff = zzeq();
    zzoM.zzb("onDeviceFeaturesReceived", localzzff.toJson());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */