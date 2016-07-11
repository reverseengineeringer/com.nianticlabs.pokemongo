package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzaz;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzja.zzb;
import java.util.List;

@zzgr
public class zzf
  extends zzc
{
  private boolean zzoN;
  
  public zzf(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzem, paramVersionInfoParcel, paramzzd);
  }
  
  private AdSizeParcel zzb(zzhs.zza paramzza)
  {
    if (zzHD.zzti) {
      return zzot.zzqn;
    }
    paramzza = zzHD.zzEN;
    if (paramzza != null)
    {
      paramzza = paramzza.split("[xX]");
      paramzza[0] = paramzza[0].trim();
      paramzza[1] = paramzza[1].trim();
    }
    for (paramzza = new AdSize(Integer.parseInt(paramzza[0]), Integer.parseInt(paramzza[1]));; paramzza = zzot.zzqn.zzcD()) {
      return new AdSizeParcel(zzot.context, paramzza);
    }
  }
  
  private boolean zzb(zzhs paramzzhs1, zzhs paramzzhs2)
  {
    if (zzEK) {}
    for (;;)
    {
      try
      {
        paramzzhs2 = zzzv.getView();
        if (paramzzhs2 == null)
        {
          zzb.zzaH("View in mediation adapter is null.");
          return false;
        }
        paramzzhs2 = (View)com.google.android.gms.dynamic.zze.zzp(paramzzhs2);
        View localView = zzot.zzqk.getNextView();
        if (localView != null)
        {
          if ((localView instanceof zziz)) {
            ((zziz)localView).destroy();
          }
          zzot.zzqk.removeView(localView);
        }
        if (zzHy == null) {
          continue;
        }
      }
      catch (RemoteException paramzzhs1)
      {
        try
        {
          zzb(paramzzhs2);
          if (zzot.zzqk.getChildCount() > 1) {
            zzot.zzqk.showNext();
          }
          if (paramzzhs1 != null)
          {
            paramzzhs1 = zzot.zzqk.getNextView();
            if (!(paramzzhs1 instanceof zziz)) {
              break label281;
            }
            ((zziz)paramzzhs1).zza(zzot.context, zzot.zzqn, zzoo);
            zzot.zzbM();
          }
          zzot.zzqk.setVisibility(0);
          return true;
        }
        catch (Throwable paramzzhs1)
        {
          zzb.zzd("Could not add mediation view to view hierarchy.", paramzzhs1);
          return false;
        }
        paramzzhs1 = paramzzhs1;
        zzb.zzd("Could not get View from mediation adapter.", paramzzhs1);
        return false;
      }
      if (zzBD != null)
      {
        zzBD.zza(zzHy);
        zzot.zzqk.removeAllViews();
        zzot.zzqk.setMinimumWidth(zzHy.widthPixels);
        zzot.zzqk.setMinimumHeight(zzHy.heightPixels);
        zzb(zzBD.getView());
        continue;
        label281:
        if (paramzzhs1 != null) {
          zzot.zzqk.removeView(paramzzhs1);
        }
      }
    }
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    zzx.zzci("setManualImpressionsEnabled must be called from the main thread.");
    zzoN = paramBoolean;
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
  }
  
  protected zziz zza(zzhs.zza paramzza, zze paramzze)
  {
    if (zzot.zzqn.zzti) {
      zzot.zzqn = zzb(paramzza);
    }
    return super.zza(paramzza, paramzze);
  }
  
  public boolean zza(zzhs paramzzhs1, final zzhs paramzzhs2)
  {
    if (!super.zza(paramzzhs1, paramzzhs2)) {
      return false;
    }
    if ((zzot.zzbN()) && (!zzb(paramzzhs1, paramzzhs2)))
    {
      zze(0);
      return false;
    }
    zza(paramzzhs2, false);
    if (zzot.zzbN()) {
      if (zzBD != null)
      {
        if (zzHw != null) {
          zzov.zza(zzot.zzqn, paramzzhs2);
        }
        if (!paramzzhs2.zzbY()) {
          break label115;
        }
        zzov.zza(zzot.zzqn, paramzzhs2).zza(zzBD);
      }
    }
    for (;;)
    {
      return true;
      label115:
      zzBD.zzhe().zza(new zzja.zzb()
      {
        public void zzbf()
        {
          zzov.zza(zzot.zzqn, paramzzhs2).zza(paramzzhs2zzBD);
        }
      });
      continue;
      if ((zzot.zzqG != null) && (zzHw != null)) {
        zzov.zza(zzot.zzqn, paramzzhs2, zzot.zzqG);
      }
    }
  }
  
  protected boolean zzaU()
  {
    boolean bool = true;
    if (!zzp.zzbv().zza(zzot.context.getPackageManager(), zzot.context.getPackageName(), "android.permission.INTERNET"))
    {
      zzl.zzcF().zza(zzot.zzqk, zzot.zzqn, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      bool = false;
    }
    if (!zzp.zzbv().zzH(zzot.context))
    {
      zzl.zzcF().zza(zzot.zzqk, zzot.zzqn, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      bool = false;
    }
    if ((!bool) && (zzot.zzqk != null)) {
      zzot.zzqk.setVisibility(0);
    }
    return bool;
  }
  
  public boolean zzb(AdRequestParcel paramAdRequestParcel)
  {
    return super.zzb(zze(paramAdRequestParcel));
  }
  
  AdRequestParcel zze(AdRequestParcel paramAdRequestParcel)
  {
    if (zzsG == zzoN) {
      return paramAdRequestParcel;
    }
    int i = versionCode;
    long l = zzsB;
    Bundle localBundle = extras;
    int j = zzsC;
    List localList = zzsD;
    boolean bool2 = zzsE;
    int k = zzsF;
    if ((zzsG) || (zzoN)) {}
    for (boolean bool1 = true;; bool1 = false) {
      return new AdRequestParcel(i, l, localBundle, j, localList, bool2, k, bool1, zzsH, zzsI, zzsJ, zzsK, zzsL, zzsM, zzsN, zzsO, zzsP);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */