package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzgt;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzii;
import com.google.android.gms.internal.zzmn;

@zzgr
public abstract class zzd
  extends zzhz
  implements zzc.zza
{
  private AdResponseParcel zzDf;
  private final zzc.zza zzEi;
  private final Object zzpd = new Object();
  private final AdRequestInfoParcel zzzz;
  
  public zzd(AdRequestInfoParcel paramAdRequestInfoParcel, zzc.zza paramzza)
  {
    zzzz = paramAdRequestInfoParcel;
    zzEi = paramzza;
  }
  
  public final void onStop()
  {
    zzfH();
  }
  
  boolean zza(zzj paramzzj, AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    try
    {
      paramzzj.zza(paramAdRequestInfoParcel, new zzg(this));
      return true;
    }
    catch (RemoteException paramzzj)
    {
      zzb.zzd("Could not fetch ad response from ad request service.", paramzzj);
      zzp.zzby().zzc(paramzzj, true);
      zzEi.zzb(new AdResponseParcel(0));
      return false;
    }
    catch (NullPointerException paramzzj)
    {
      for (;;)
      {
        zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", paramzzj);
        zzp.zzby().zzc(paramzzj, true);
      }
    }
    catch (SecurityException paramzzj)
    {
      for (;;)
      {
        zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", paramzzj);
        zzp.zzby().zzc(paramzzj, true);
      }
    }
    catch (Throwable paramzzj)
    {
      for (;;)
      {
        zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", paramzzj);
        zzp.zzby().zzc(paramzzj, true);
      }
    }
  }
  
  public void zzb(AdResponseParcel paramAdResponseParcel)
  {
    synchronized (zzpd)
    {
      zzDf = paramAdResponseParcel;
      zzpd.notify();
      return;
    }
  }
  
  /* Error */
  public void zzbn()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 99	com/google/android/gms/ads/internal/request/zzd:zzfI	()Lcom/google/android/gms/ads/internal/request/zzj;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +27 -> 33
    //   9: new 81	com/google/android/gms/ads/internal/request/AdResponseParcel
    //   12: dup
    //   13: iconst_0
    //   14: invokespecial 84	com/google/android/gms/ads/internal/request/AdResponseParcel:<init>	(I)V
    //   17: astore_1
    //   18: aload_0
    //   19: getfield 35	com/google/android/gms/ads/internal/request/zzd:zzEi	Lcom/google/android/gms/ads/internal/request/zzc$zza;
    //   22: aload_1
    //   23: invokeinterface 87 2 0
    //   28: aload_0
    //   29: invokevirtual 40	com/google/android/gms/ads/internal/request/zzd:zzfH	()V
    //   32: return
    //   33: aload_0
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 33	com/google/android/gms/ads/internal/request/zzd:zzzz	Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;
    //   39: invokevirtual 101	com/google/android/gms/ads/internal/request/zzd:zza	(Lcom/google/android/gms/ads/internal/request/zzj;Lcom/google/android/gms/ads/internal/request/AdRequestInfoParcel;)Z
    //   42: ifeq -14 -> 28
    //   45: aload_0
    //   46: invokestatic 105	com/google/android/gms/ads/internal/zzp:zzbz	()Lcom/google/android/gms/internal/zzmn;
    //   49: invokeinterface 111 1 0
    //   54: invokevirtual 115	com/google/android/gms/ads/internal/request/zzd:zzi	(J)V
    //   57: goto -29 -> 28
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 40	com/google/android/gms/ads/internal/request/zzd:zzfH	()V
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	zzd
    //   4	31	1	localObject1	Object
    //   60	6	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	5	60	finally
    //   9	28	60	finally
    //   33	57	60	finally
  }
  
  protected boolean zzf(long paramLong)
  {
    paramLong = 60000L - (zzp.zzbz().elapsedRealtime() - paramLong);
    if (paramLong <= 0L) {
      return false;
    }
    try
    {
      zzpd.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException) {}
    return false;
  }
  
  public abstract void zzfH();
  
  public abstract zzj zzfI();
  
  protected void zzi(long paramLong)
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (zzDf != null)
        {
          zzEi.zzb(zzDf);
          return;
        }
        if (zzf(paramLong)) {
          continue;
        }
        if (zzDf != null)
        {
          zzEi.zzb(zzDf);
          return;
        }
      }
      zzEi.zzb(new AdResponseParcel(0));
    }
  }
  
  @zzgr
  public static final class zza
    extends zzd
  {
    private final Context mContext;
    
    public zza(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzc.zza paramzza)
    {
      super(paramzza);
      mContext = paramContext;
    }
    
    public void zzfH() {}
    
    public zzj zzfI()
    {
      zzbr localzzbr = new zzbr((String)zzby.zzul.get());
      return zzgt.zza(mContext, localzzbr, zzgs.zzfQ());
    }
  }
  
  @zzgr
  public static class zzb
    extends zzd
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
  {
    private Context mContext;
    private final zzc.zza zzEi;
    protected zze zzEj;
    private boolean zzEk;
    private final Object zzpd = new Object();
    private AdRequestInfoParcel zzzz;
    
    public zzb(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzc.zza paramzza)
    {
      super(paramzza);
      mContext = paramContext;
      zzzz = paramAdRequestInfoParcel;
      zzEi = paramzza;
      if (((Boolean)zzby.zzuK.get()).booleanValue()) {
        zzEk = true;
      }
      for (paramzza = zzp.zzbG().zzgM();; paramzza = paramContext.getMainLooper())
      {
        zzEj = new zze(paramContext, paramzza, this, this, zzqj.zzJw);
        connect();
        return;
      }
    }
    
    protected void connect()
    {
      zzEj.zzoZ();
    }
    
    public void onConnected(Bundle paramBundle)
    {
      zzgz();
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      zzb.zzaF("Cannot connect to remote service, fallback to local instance.");
      zzfJ().zzgz();
      paramConnectionResult = new Bundle();
      paramConnectionResult.putString("action", "gms_connection_failed_fallback_to_local");
      zzp.zzbv().zzb(mContext, zzzz.zzqj.zzJu, "gmob-apps", paramConnectionResult, true);
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      zzb.zzaF("Disconnected from remote ad request service.");
    }
    
    public void zzfH()
    {
      synchronized (zzpd)
      {
        if ((zzEj.isConnected()) || (zzEj.isConnecting())) {
          zzEj.disconnect();
        }
        Binder.flushPendingCommands();
        if (zzEk)
        {
          zzp.zzbG().zzgN();
          zzEk = false;
        }
        return;
      }
    }
    
    /* Error */
    public zzj zzfI()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 34	com/google/android/gms/ads/internal/request/zzd$zzb:zzpd	Ljava/lang/Object;
      //   4: astore_1
      //   5: aload_1
      //   6: monitorenter
      //   7: aload_0
      //   8: getfield 91	com/google/android/gms/ads/internal/request/zzd$zzb:zzEj	Lcom/google/android/gms/ads/internal/request/zze;
      //   11: invokevirtual 183	com/google/android/gms/ads/internal/request/zze:zzfM	()Lcom/google/android/gms/ads/internal/request/zzj;
      //   14: astore_2
      //   15: aload_1
      //   16: monitorexit
      //   17: aload_2
      //   18: areturn
      //   19: aload_1
      //   20: monitorexit
      //   21: aconst_null
      //   22: areturn
      //   23: astore_2
      //   24: aload_1
      //   25: monitorexit
      //   26: aload_2
      //   27: athrow
      //   28: astore_2
      //   29: goto -10 -> 19
      //   32: astore_2
      //   33: goto -14 -> 19
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	36	0	this	zzb
      //   14	4	2	localzzj	zzj
      //   23	4	2	localObject2	Object
      //   28	1	2	localDeadObjectException	android.os.DeadObjectException
      //   32	1	2	localIllegalStateException	IllegalStateException
      // Exception table:
      //   from	to	target	type
      //   7	15	23	finally
      //   15	17	23	finally
      //   19	21	23	finally
      //   24	26	23	finally
      //   7	15	28	android/os/DeadObjectException
      //   7	15	32	java/lang/IllegalStateException
    }
    
    zzhz zzfJ()
    {
      return new zzd.zza(mContext, zzzz, zzEi);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */