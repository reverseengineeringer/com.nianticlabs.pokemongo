package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@zzgr
public class zzay
  implements zzba
{
  private final VersionInfoParcel zzpb;
  private final Object zzpd = new Object();
  private final WeakHashMap<zzhs, zzaz> zzqX = new WeakHashMap();
  private final ArrayList<zzaz> zzqY = new ArrayList();
  private final Context zzqZ;
  private final zzdz zzra;
  
  public zzay(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzdz paramzzdz)
  {
    zzqZ = paramContext.getApplicationContext();
    zzpb = paramVersionInfoParcel;
    zzra = paramzzdz;
  }
  
  public zzaz zza(AdSizeParcel paramAdSizeParcel, zzhs paramzzhs)
  {
    return zza(paramAdSizeParcel, paramzzhs, zzBD.getView());
  }
  
  public zzaz zza(AdSizeParcel paramAdSizeParcel, zzhs paramzzhs, View paramView)
  {
    synchronized (zzpd)
    {
      if (zzd(paramzzhs))
      {
        paramAdSizeParcel = (zzaz)zzqX.get(paramzzhs);
        return paramAdSizeParcel;
      }
      paramAdSizeParcel = new zzaz(paramAdSizeParcel, paramzzhs, zzpb, paramView, zzra);
      paramAdSizeParcel.zza(this);
      zzqX.put(paramzzhs, paramAdSizeParcel);
      zzqY.add(paramAdSizeParcel);
      return paramAdSizeParcel;
    }
  }
  
  public void zza(zzaz paramzzaz)
  {
    synchronized (zzpd)
    {
      if (!paramzzaz.zzcd())
      {
        zzqY.remove(paramzzaz);
        Iterator localIterator = zzqX.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (((Map.Entry)localIterator.next()).getValue() == paramzzaz) {
            localIterator.remove();
          }
        }
      }
    }
  }
  
  public boolean zzd(zzhs paramzzhs)
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        paramzzhs = (zzaz)zzqX.get(paramzzhs);
        if ((paramzzhs != null) && (paramzzhs.zzcd()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void zze(zzhs paramzzhs)
  {
    synchronized (zzpd)
    {
      paramzzhs = (zzaz)zzqX.get(paramzzhs);
      if (paramzzhs != null) {
        paramzzhs.zzcb();
      }
      return;
    }
  }
  
  public void zzf(zzhs paramzzhs)
  {
    synchronized (zzpd)
    {
      paramzzhs = (zzaz)zzqX.get(paramzzhs);
      if (paramzzhs != null) {
        paramzzhs.stop();
      }
      return;
    }
  }
  
  public void zzg(zzhs paramzzhs)
  {
    synchronized (zzpd)
    {
      paramzzhs = (zzaz)zzqX.get(paramzzhs);
      if (paramzzhs != null) {
        paramzzhs.pause();
      }
      return;
    }
  }
  
  public void zzh(zzhs paramzzhs)
  {
    synchronized (zzpd)
    {
      paramzzhs = (zzaz)zzqX.get(paramzzhs);
      if (paramzzhs != null) {
        paramzzhs.resume();
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */