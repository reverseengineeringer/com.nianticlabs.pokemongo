package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;

@zzgr
public class zzhu
  implements zzib.zzb
{
  private Context mContext;
  private boolean zzGg = true;
  private boolean zzGh = true;
  private final String zzHP;
  private final zzhv zzHQ;
  private BigInteger zzHR = BigInteger.ONE;
  private final HashSet<zzht> zzHS = new HashSet();
  private final HashMap<String, zzhx> zzHT = new HashMap();
  private boolean zzHU = false;
  private int zzHV = 0;
  private zzca zzHW = null;
  private zzbk zzHX = null;
  private final LinkedList<Thread> zzHY = new LinkedList();
  private Boolean zzHZ = null;
  private String zzIa;
  private boolean zzIb = false;
  private boolean zzIc = false;
  private zzay zzov;
  private boolean zzpA = false;
  private VersionInfoParcel zzpb;
  private final Object zzpd = new Object();
  private zzbj zzsa = null;
  private zzbi zzsb = null;
  private final zzgq zzsc = null;
  
  public zzhu(zzid paramzzid)
  {
    zzHP = paramzzid.zzgD();
    zzHQ = new zzhv(zzHP);
  }
  
  public String getSessionId()
  {
    return zzHP;
  }
  
  public void zzA(boolean paramBoolean)
  {
    synchronized (zzpd)
    {
      zzGh = paramBoolean;
      return;
    }
  }
  
  public void zzB(boolean paramBoolean)
  {
    synchronized (zzpd)
    {
      zzIb = paramBoolean;
      return;
    }
  }
  
  public zzbk zzE(Context paramContext)
  {
    if ((!((Boolean)zzby.zzuT.get()).booleanValue()) || (!zzmx.zzqx()) || (zzgl())) {
      return null;
    }
    synchronized (zzpd)
    {
      if (zzsa == null)
      {
        if (!(paramContext instanceof Activity)) {
          return null;
        }
        zzsa = new zzbj((Application)paramContext.getApplicationContext(), (Activity)paramContext);
      }
      if (zzsb == null) {
        zzsb = new zzbi();
      }
      if (zzHX == null) {
        zzHX = new zzbk(zzsa, zzsb, new zzgq(mContext, zzpb, null, null));
      }
      zzHX.zzct();
      paramContext = zzHX;
      return paramContext;
    }
  }
  
  public Bundle zza(Context paramContext, zzhw paramzzhw, String paramString)
  {
    Bundle localBundle;
    synchronized (zzpd)
    {
      localBundle = new Bundle();
      localBundle.putBundle("app", zzHQ.zze(paramContext, paramString));
      paramContext = new Bundle();
      paramString = zzHT.keySet().iterator();
      if (paramString.hasNext())
      {
        String str = (String)paramString.next();
        paramContext.putBundle(str, ((zzhx)zzHT.get(str)).toBundle());
      }
    }
    localBundle.putBundle("slots", paramContext);
    paramContext = new ArrayList();
    paramString = zzHS.iterator();
    while (paramString.hasNext()) {
      paramContext.add(((zzht)paramString.next()).toBundle());
    }
    localBundle.putParcelableArrayList("ads", paramContext);
    paramzzhw.zza(zzHS);
    zzHS.clear();
    return localBundle;
  }
  
  public Future zza(Context paramContext, boolean paramBoolean)
  {
    synchronized (zzpd)
    {
      if (paramBoolean != zzGg)
      {
        zzGg = paramBoolean;
        paramContext = zzib.zza(paramContext, paramBoolean);
        return paramContext;
      }
      return null;
    }
  }
  
  public void zza(zzht paramzzht)
  {
    synchronized (zzpd)
    {
      zzHS.add(paramzzht);
      return;
    }
  }
  
  public void zza(String paramString, zzhx paramzzhx)
  {
    synchronized (zzpd)
    {
      zzHT.put(paramString, paramzzhx);
      return;
    }
  }
  
  public void zza(Thread paramThread)
  {
    zzgq.zza(mContext, paramThread, zzpb);
  }
  
  public void zzb(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    synchronized (zzpd)
    {
      if (!zzpA)
      {
        mContext = paramContext.getApplicationContext();
        zzpb = paramVersionInfoParcel;
        zzib.zza(paramContext, this);
        zzib.zzb(paramContext, this);
        zza(Thread.currentThread());
        zzIa = zzp.zzbv().zzf(paramContext, zzJu);
        if ((zzmx.zzqE()) && (!NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted())) {
          zzIc = true;
        }
        zzov = new zzay(paramContext.getApplicationContext(), zzpb, new zzdz(paramContext.getApplicationContext(), zzpb, (String)zzby.zzul.get()));
        zzgw();
        zzp.zzbF().zzx(mContext);
        zzpA = true;
      }
      return;
    }
  }
  
  public void zzb(Boolean paramBoolean)
  {
    synchronized (zzpd)
    {
      zzHZ = paramBoolean;
      return;
    }
  }
  
  public void zzb(HashSet<zzht> paramHashSet)
  {
    synchronized (zzpd)
    {
      zzHS.addAll(paramHashSet);
      return;
    }
  }
  
  public void zzc(Throwable paramThrowable, boolean paramBoolean)
  {
    new zzgq(mContext, zzpb, null, null).zza(paramThrowable, paramBoolean);
  }
  
  public String zzd(int paramInt, String paramString)
  {
    if (zzpb.zzJx) {}
    for (Resources localResources = mContext.getResources(); localResources == null; localResources = GooglePlayServicesUtil.getRemoteResource(mContext)) {
      return paramString;
    }
    return localResources.getString(paramInt);
  }
  
  public void zzd(Bundle paramBundle)
  {
    synchronized (zzpd)
    {
      if (paramBundle.containsKey("use_https")) {}
      for (boolean bool = paramBundle.getBoolean("use_https");; bool = zzGg)
      {
        zzGg = bool;
        if (!paramBundle.containsKey("webview_cache_version")) {
          break;
        }
        i = paramBundle.getInt("webview_cache_version");
        zzHV = i;
        return;
      }
      int i = zzHV;
    }
  }
  
  public boolean zzgl()
  {
    synchronized (zzpd)
    {
      boolean bool = zzGh;
      return bool;
    }
  }
  
  public String zzgm()
  {
    synchronized (zzpd)
    {
      String str = zzHR.toString();
      zzHR = zzHR.add(BigInteger.ONE);
      return str;
    }
  }
  
  public zzhv zzgn()
  {
    synchronized (zzpd)
    {
      zzhv localzzhv = zzHQ;
      return localzzhv;
    }
  }
  
  public zzca zzgo()
  {
    synchronized (zzpd)
    {
      zzca localzzca = zzHW;
      return localzzca;
    }
  }
  
  public boolean zzgp()
  {
    synchronized (zzpd)
    {
      boolean bool = zzHU;
      zzHU = true;
      return bool;
    }
  }
  
  public boolean zzgq()
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (!zzGg)
        {
          if (!zzIc) {
            break label38;
          }
          break label33;
          return bool;
        }
      }
      label33:
      boolean bool = true;
      continue;
      label38:
      bool = false;
    }
  }
  
  public String zzgr()
  {
    synchronized (zzpd)
    {
      String str = zzIa;
      return str;
    }
  }
  
  public Boolean zzgs()
  {
    synchronized (zzpd)
    {
      Boolean localBoolean = zzHZ;
      return localBoolean;
    }
  }
  
  public zzay zzgt()
  {
    return zzov;
  }
  
  public boolean zzgu()
  {
    synchronized (zzpd)
    {
      if (zzHV < ((Integer)zzby.zzvh.get()).intValue())
      {
        zzHV = ((Integer)zzby.zzvh.get()).intValue();
        zzib.zza(mContext, zzHV);
        return true;
      }
      return false;
    }
  }
  
  public boolean zzgv()
  {
    synchronized (zzpd)
    {
      boolean bool = zzIb;
      return bool;
    }
  }
  
  void zzgw()
  {
    zzbz localzzbz = new zzbz(mContext, zzpb.zzJu);
    try
    {
      zzHW = zzp.zzbA().zza(localzzbz);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zzb.zzd("Cannot initialize CSI reporter.", localIllegalArgumentException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */