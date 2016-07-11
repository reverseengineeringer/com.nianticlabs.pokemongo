package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzii;

@zzgr
public class zzd$zzb
  extends zzd
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private Context mContext;
  private final zzc.zza zzEi;
  protected zze zzEj;
  private boolean zzEk;
  private final Object zzpd = new Object();
  private AdRequestInfoParcel zzzz;
  
  public zzd$zzb(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzc.zza paramzza)
  {
    super(paramAdRequestInfoParcel, paramzza);
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

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzd.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */