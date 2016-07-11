package com.google.android.gms.ads.internal;

import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbw;
import com.google.android.gms.internal.zzbx;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgz;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzii;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;

@zzgr
public class zzp
{
  private static zzp zzpN;
  private static final Object zzpy = new Object();
  private final com.google.android.gms.ads.internal.request.zza zzpO = new com.google.android.gms.ads.internal.request.zza();
  private final com.google.android.gms.ads.internal.overlay.zza zzpP = new com.google.android.gms.ads.internal.overlay.zza();
  private final zze zzpQ = new zze();
  private final zzgg zzpR = new zzgg();
  private final zzid zzpS = new zzid();
  private final zzjb zzpT = new zzjb();
  private final zzie zzpU = zzie.zzM(Build.VERSION.SDK_INT);
  private final zzhu zzpV = new zzhu(zzpS);
  private final zzmn zzpW = new zzmp();
  private final zzcb zzpX = new zzcb();
  private final zzgz zzpY = new zzgz();
  private final zzbw zzpZ = new zzbw();
  private final zzbv zzqa = new zzbv();
  private final zzbx zzqb = new zzbx();
  private final zzi zzqc = new zzi();
  private final zzii zzqd = new zzii();
  private final zzej zzqe = new zzej();
  private final zzdu zzqf = new zzdu();
  
  static
  {
    zza(new zzp());
  }
  
  protected static void zza(zzp paramzzp)
  {
    synchronized (zzpy)
    {
      zzpN = paramzzp;
      return;
    }
  }
  
  public static zzcb zzbA()
  {
    return zzbqzzpX;
  }
  
  public static zzgz zzbB()
  {
    return zzbqzzpY;
  }
  
  public static zzbw zzbC()
  {
    return zzbqzzpZ;
  }
  
  public static zzbv zzbD()
  {
    return zzbqzzqa;
  }
  
  public static zzbx zzbE()
  {
    return zzbqzzqb;
  }
  
  public static zzi zzbF()
  {
    return zzbqzzqc;
  }
  
  public static zzii zzbG()
  {
    return zzbqzzqd;
  }
  
  public static zzej zzbH()
  {
    return zzbqzzqe;
  }
  
  public static zzdu zzbI()
  {
    return zzbqzzqf;
  }
  
  private static zzp zzbq()
  {
    synchronized (zzpy)
    {
      zzp localzzp = zzpN;
      return localzzp;
    }
  }
  
  public static com.google.android.gms.ads.internal.request.zza zzbr()
  {
    return zzbqzzpO;
  }
  
  public static com.google.android.gms.ads.internal.overlay.zza zzbs()
  {
    return zzbqzzpP;
  }
  
  public static zze zzbt()
  {
    return zzbqzzpQ;
  }
  
  public static zzgg zzbu()
  {
    return zzbqzzpR;
  }
  
  public static zzid zzbv()
  {
    return zzbqzzpS;
  }
  
  public static zzjb zzbw()
  {
    return zzbqzzpT;
  }
  
  public static zzie zzbx()
  {
    return zzbqzzpU;
  }
  
  public static zzhu zzby()
  {
    return zzbqzzpV;
  }
  
  public static zzmn zzbz()
  {
    return zzbqzzpW;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */