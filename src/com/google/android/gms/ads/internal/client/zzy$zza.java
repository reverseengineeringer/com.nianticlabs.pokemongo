package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public final class zzy$zza
{
  private Date zzaT;
  private Location zzaX;
  private boolean zzoN = false;
  private int zzsR = -1;
  private int zzsU = -1;
  private String zzsV;
  private String zzsX;
  private final Bundle zzsZ = new Bundle();
  private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zztA = new HashMap();
  private final HashSet<String> zztB = new HashSet();
  private final HashSet<String> zztC = new HashSet();
  private String zztb;
  private final Bundle zztu = new Bundle();
  private final HashSet<String> zztz = new HashSet();
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    zzoN = paramBoolean;
  }
  
  public void zzF(String paramString)
  {
    zztz.add(paramString);
  }
  
  public void zzG(String paramString)
  {
    zztB.add(paramString);
  }
  
  public void zzH(String paramString)
  {
    zztB.remove(paramString);
  }
  
  public void zzI(String paramString)
  {
    zzsX = paramString;
  }
  
  public void zzJ(String paramString)
  {
    zzsV = paramString;
  }
  
  public void zzK(String paramString)
  {
    zztb = paramString;
  }
  
  public void zzL(String paramString)
  {
    zztC.add(paramString);
  }
  
  @Deprecated
  public void zza(NetworkExtras paramNetworkExtras)
  {
    if ((paramNetworkExtras instanceof AdMobExtras))
    {
      zza(AdMobAdapter.class, ((AdMobExtras)paramNetworkExtras).getExtras());
      return;
    }
    zztA.put(paramNetworkExtras.getClass(), paramNetworkExtras);
  }
  
  public void zza(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
  {
    zztu.putBundle(paramClass.getName(), paramBundle);
  }
  
  public void zza(Date paramDate)
  {
    zzaT = paramDate;
  }
  
  public void zzb(Location paramLocation)
  {
    zzaX = paramLocation;
  }
  
  public void zzb(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
  {
    if (zztu.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
      zztu.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
    }
    zztu.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(paramClass.getName(), paramBundle);
  }
  
  public void zzb(String paramString1, String paramString2)
  {
    zzsZ.putString(paramString1, paramString2);
  }
  
  public void zzj(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      zzsU = i;
      return;
    }
  }
  
  public void zzm(int paramInt)
  {
    zzsR = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzy.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */