package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzgr
public class zzht
{
  private boolean zzGb = false;
  private final LinkedList<zza> zzHE;
  private final String zzHF;
  private final String zzHG;
  private long zzHH = -1L;
  private long zzHI = -1L;
  private long zzHJ = -1L;
  private long zzHK = 0L;
  private long zzHL = -1L;
  private long zzHM = -1L;
  private final zzhu zzpV;
  private final Object zzpd = new Object();
  
  public zzht(zzhu paramzzhu, String paramString1, String paramString2)
  {
    zzpV = paramzzhu;
    zzHF = paramString1;
    zzHG = paramString2;
    zzHE = new LinkedList();
  }
  
  public zzht(String paramString1, String paramString2)
  {
    this(zzp.zzby(), paramString1, paramString2);
  }
  
  public Bundle toBundle()
  {
    ArrayList localArrayList;
    synchronized (zzpd)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("seq_num", zzHF);
      localBundle1.putString("slotid", zzHG);
      localBundle1.putBoolean("ismediation", zzGb);
      localBundle1.putLong("treq", zzHL);
      localBundle1.putLong("tresponse", zzHM);
      localBundle1.putLong("timp", zzHI);
      localBundle1.putLong("tload", zzHJ);
      localBundle1.putLong("pcc", zzHK);
      localBundle1.putLong("tfetch", zzHH);
      localArrayList = new ArrayList();
      Iterator localIterator = zzHE.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add(((zza)localIterator.next()).toBundle());
      }
    }
    localBundle2.putParcelableArrayList("tclick", localArrayList);
    return localBundle2;
  }
  
  public void zzgf()
  {
    synchronized (zzpd)
    {
      if ((zzHM != -1L) && (zzHI == -1L))
      {
        zzHI = SystemClock.elapsedRealtime();
        zzpV.zza(this);
      }
      zzpV.zzgn().zzgf();
      return;
    }
  }
  
  public void zzgg()
  {
    synchronized (zzpd)
    {
      if (zzHM != -1L)
      {
        zza localzza = new zza();
        localzza.zzgk();
        zzHE.add(localzza);
        zzHK += 1L;
        zzpV.zzgn().zzgg();
        zzpV.zza(this);
      }
      return;
    }
  }
  
  public void zzgh()
  {
    synchronized (zzpd)
    {
      if ((zzHM != -1L) && (!zzHE.isEmpty()))
      {
        zza localzza = (zza)zzHE.getLast();
        if (localzza.zzgi() == -1L)
        {
          localzza.zzgj();
          zzpV.zza(this);
        }
      }
      return;
    }
  }
  
  public void zzi(AdRequestParcel paramAdRequestParcel)
  {
    synchronized (zzpd)
    {
      zzHL = SystemClock.elapsedRealtime();
      zzpV.zzgn().zzb(paramAdRequestParcel, zzHL);
      return;
    }
  }
  
  public void zzl(long paramLong)
  {
    synchronized (zzpd)
    {
      zzHM = paramLong;
      if (zzHM != -1L) {
        zzpV.zza(this);
      }
      return;
    }
  }
  
  public void zzm(long paramLong)
  {
    synchronized (zzpd)
    {
      if (zzHM != -1L)
      {
        zzHH = paramLong;
        zzpV.zza(this);
      }
      return;
    }
  }
  
  public void zzy(boolean paramBoolean)
  {
    synchronized (zzpd)
    {
      if (zzHM != -1L)
      {
        zzHJ = SystemClock.elapsedRealtime();
        if (!paramBoolean)
        {
          zzHI = zzHJ;
          zzpV.zza(this);
        }
      }
      return;
    }
  }
  
  public void zzz(boolean paramBoolean)
  {
    synchronized (zzpd)
    {
      if (zzHM != -1L)
      {
        zzGb = paramBoolean;
        zzpV.zza(this);
      }
      return;
    }
  }
  
  @zzgr
  private static final class zza
  {
    private long zzHN = -1L;
    private long zzHO = -1L;
    
    public Bundle toBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("topen", zzHN);
      localBundle.putLong("tclose", zzHO);
      return localBundle;
    }
    
    public long zzgi()
    {
      return zzHO;
    }
    
    public void zzgj()
    {
      zzHO = SystemClock.elapsedRealtime();
    }
    
    public void zzgk()
    {
      zzHN = SystemClock.elapsedRealtime();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzht
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */