package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzgr;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzgr
public final class zzy
{
  public static final String DEVICE_ID_EMULATOR = zzl.zzcF().zzaE("emulator");
  private final Date zzaT;
  private final Set<String> zzaV;
  private final Location zzaX;
  private final boolean zzoN;
  private final int zzsR;
  private final int zzsU;
  private final String zzsV;
  private final String zzsX;
  private final Bundle zzsZ;
  private final String zztb;
  private final Bundle zztu;
  private final Map<Class<? extends NetworkExtras>, NetworkExtras> zztv;
  private final SearchAdRequest zztw;
  private final Set<String> zztx;
  private final Set<String> zzty;
  
  public zzy(zza paramzza)
  {
    this(paramzza, null);
  }
  
  public zzy(zza paramzza, SearchAdRequest paramSearchAdRequest)
  {
    zzaT = zza.zza(paramzza);
    zzsX = zza.zzb(paramzza);
    zzsR = zza.zzc(paramzza);
    zzaV = Collections.unmodifiableSet(zza.zzd(paramzza));
    zzaX = zza.zze(paramzza);
    zzoN = zza.zzf(paramzza);
    zztu = zza.zzg(paramzza);
    zztv = Collections.unmodifiableMap(zza.zzh(paramzza));
    zzsV = zza.zzi(paramzza);
    zztb = zza.zzj(paramzza);
    zztw = paramSearchAdRequest;
    zzsU = zza.zzk(paramzza);
    zztx = Collections.unmodifiableSet(zza.zzl(paramzza));
    zzsZ = zza.zzm(paramzza);
    zzty = Collections.unmodifiableSet(zza.zzn(paramzza));
  }
  
  public static void updateCorrelator()
  {
    zzl.zzcH().zzcL();
  }
  
  public Date getBirthday()
  {
    return zzaT;
  }
  
  public String getContentUrl()
  {
    return zzsX;
  }
  
  public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass)
  {
    Bundle localBundle = zztu.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
    if (localBundle != null) {
      return localBundle.getBundle(paramClass.getClass().getName());
    }
    return null;
  }
  
  public Bundle getCustomTargeting()
  {
    return zzsZ;
  }
  
  public int getGender()
  {
    return zzsR;
  }
  
  public Set<String> getKeywords()
  {
    return zzaV;
  }
  
  public Location getLocation()
  {
    return zzaX;
  }
  
  public boolean getManualImpressionsEnabled()
  {
    return zzoN;
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return (NetworkExtras)zztv.get(paramClass);
  }
  
  public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass)
  {
    return zztu.getBundle(paramClass.getName());
  }
  
  public String getPublisherProvidedId()
  {
    return zzsV;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return zztx.contains(zzl.zzcF().zzQ(paramContext));
  }
  
  public String zzcM()
  {
    return zztb;
  }
  
  public SearchAdRequest zzcN()
  {
    return zztw;
  }
  
  public Map<Class<? extends NetworkExtras>, NetworkExtras> zzcO()
  {
    return zztv;
  }
  
  public Bundle zzcP()
  {
    return zztu;
  }
  
  public int zzcQ()
  {
    return zzsU;
  }
  
  public Set<String> zzcR()
  {
    return zzty;
  }
  
  public static final class zza
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */