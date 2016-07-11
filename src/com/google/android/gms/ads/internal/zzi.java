package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzp.zza;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzmi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zzgr
public class zzi
  extends zzp.zza
{
  private final Context mContext;
  private final zzo zzoT;
  private final zzcw zzoU;
  private final zzcx zzoV;
  private final zzmi<String, zzcz> zzoW;
  private final zzmi<String, zzcy> zzoX;
  private final NativeAdOptionsParcel zzoY;
  private final List<String> zzoZ;
  private final zzem zzox;
  private final String zzpa;
  private final VersionInfoParcel zzpb;
  private WeakReference<zzn> zzpc;
  private Object zzpd = new Object();
  
  zzi(Context paramContext, String paramString, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel, zzo paramzzo, zzcw paramzzcw, zzcx paramzzcx, zzmi<String, zzcz> paramzzmi, zzmi<String, zzcy> paramzzmi1, NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    mContext = paramContext;
    zzpa = paramString;
    zzox = paramzzem;
    zzpb = paramVersionInfoParcel;
    zzoT = paramzzo;
    zzoV = paramzzcx;
    zzoU = paramzzcw;
    zzoW = paramzzmi;
    zzoX = paramzzmi1;
    zzoY = paramNativeAdOptionsParcel;
    zzoZ = zzbi();
  }
  
  private List<String> zzbi()
  {
    ArrayList localArrayList = new ArrayList();
    if (zzoV != null) {
      localArrayList.add("1");
    }
    if (zzoU != null) {
      localArrayList.add("2");
    }
    if (zzoW.size() > 0) {
      localArrayList.add("3");
    }
    return localArrayList;
  }
  
  public String getMediationAdapterClassName()
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (zzpc != null)
        {
          Object localObject1 = (zzn)zzpc.get();
          if (localObject1 != null)
          {
            localObject1 = ((zzn)localObject1).getMediationAdapterClassName();
            return (String)localObject1;
          }
        }
        else
        {
          return null;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public boolean isLoading()
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (zzpc != null)
        {
          zzn localzzn = (zzn)zzpc.get();
          if (localzzn != null)
          {
            bool = localzzn.isLoading();
            return bool;
          }
        }
        else
        {
          return false;
        }
      }
      boolean bool = false;
    }
  }
  
  protected void runOnUiThread(Runnable paramRunnable)
  {
    zzid.zzIE.post(paramRunnable);
  }
  
  protected zzn zzbj()
  {
    return new zzn(mContext, AdSizeParcel.zzs(mContext), zzpa, zzox, zzpb);
  }
  
  public void zzf(final AdRequestParcel paramAdRequestParcel)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        synchronized (zzi.zza(zzi.this))
        {
          zzn localzzn = zzbj();
          zzi.zza(zzi.this, new WeakReference(localzzn));
          localzzn.zzb(zzi.zzb(zzi.this));
          localzzn.zzb(zzi.zzc(zzi.this));
          localzzn.zza(zzi.zzd(zzi.this));
          localzzn.zza(zzi.zze(zzi.this));
          localzzn.zzb(zzi.zzf(zzi.this));
          localzzn.zza(zzi.zzg(zzi.this));
          localzzn.zzb(zzi.zzh(zzi.this));
          localzzn.zzb(paramAdRequestParcel);
          return;
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */