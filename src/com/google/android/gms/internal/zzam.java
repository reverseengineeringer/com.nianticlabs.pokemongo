package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzam
  extends zzal
{
  private static AdvertisingIdClient zznq = null;
  private static CountDownLatch zznr = new CountDownLatch(1);
  private static volatile boolean zzns;
  private boolean zznt;
  
  protected zzam(Context paramContext, zzap paramzzap, zzaq paramzzaq, boolean paramBoolean)
  {
    super(paramContext, paramzzap, paramzzaq);
    zznt = paramBoolean;
  }
  
  public static zzam zza(String paramString, Context paramContext, boolean paramBoolean)
  {
    zzah localzzah = new zzah();
    zza(paramString, paramContext, localzzah);
    if (paramBoolean) {}
    try
    {
      if (zznq == null) {
        new Thread(new zzb(paramContext)).start();
      }
      return new zzam(paramContext, localzzah, new zzas(239), paramBoolean);
    }
    finally {}
  }
  
  zza zzY()
    throws IOException
  {
    try
    {
      if (!zznr.await(2L, TimeUnit.SECONDS))
      {
        zza localzza1 = new zza(null, false);
        return localzza1;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      return new zza(null, false);
    }
    try
    {
      if (zznq == null)
      {
        zza localzza2 = new zza(null, false);
        return localzza2;
      }
    }
    finally {}
    AdvertisingIdClient.Info localInfo = zznq.getInfo();
    return new zza(zzk(localInfo.getId()), localInfo.isLimitAdTrackingEnabled());
  }
  
  protected void zzc(Context paramContext)
  {
    super.zzc(paramContext);
    try
    {
      if ((zzns) || (!zznt))
      {
        zza(24, zze(paramContext));
        return;
      }
      paramContext = zzY();
      str = paramContext.getId();
      if (str == null) {
        return;
      }
      if (!paramContext.isLimitAdTrackingEnabled()) {
        break label81;
      }
      l = 1L;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        String str;
        return;
        long l = 0L;
      }
    }
    catch (zzal.zza paramContext) {}
    zza(28, l);
    zza(26, 5L);
    zza(24, str);
    return;
    label81:
  }
  
  class zza
  {
    private String zznu;
    private boolean zznv;
    
    public zza(String paramString, boolean paramBoolean)
    {
      zznu = paramString;
      zznv = paramBoolean;
    }
    
    public String getId()
    {
      return zznu;
    }
    
    public boolean isLimitAdTrackingEnabled()
    {
      return zznv;
    }
  }
  
  private static final class zzb
    implements Runnable
  {
    private Context zznx;
    
    public zzb(Context paramContext)
    {
      zznx = paramContext.getApplicationContext();
      if (zznx == null) {
        zznx = paramContext;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: ldc 8
      //   2: monitorenter
      //   3: invokestatic 36	com/google/android/gms/internal/zzam:zzZ	()Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;
      //   6: ifnonnull +24 -> 30
      //   9: new 38	com/google/android/gms/ads/identifier/AdvertisingIdClient
      //   12: dup
      //   13: aload_0
      //   14: getfield 24	com/google/android/gms/internal/zzam$zzb:zznx	Landroid/content/Context;
      //   17: invokespecial 40	com/google/android/gms/ads/identifier/AdvertisingIdClient:<init>	(Landroid/content/Context;)V
      //   20: astore_1
      //   21: aload_1
      //   22: invokevirtual 43	com/google/android/gms/ads/identifier/AdvertisingIdClient:start	()V
      //   25: aload_1
      //   26: invokestatic 47	com/google/android/gms/internal/zzam:zza	(Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;)Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;
      //   29: pop
      //   30: invokestatic 51	com/google/android/gms/internal/zzam:zzaa	()Ljava/util/concurrent/CountDownLatch;
      //   33: invokevirtual 56	java/util/concurrent/CountDownLatch:countDown	()V
      //   36: ldc 8
      //   38: monitorexit
      //   39: return
      //   40: astore_1
      //   41: iconst_1
      //   42: invokestatic 59	com/google/android/gms/internal/zzam:zza	(Z)Z
      //   45: pop
      //   46: invokestatic 51	com/google/android/gms/internal/zzam:zzaa	()Ljava/util/concurrent/CountDownLatch;
      //   49: invokevirtual 56	java/util/concurrent/CountDownLatch:countDown	()V
      //   52: goto -16 -> 36
      //   55: astore_1
      //   56: ldc 8
      //   58: monitorexit
      //   59: aload_1
      //   60: athrow
      //   61: astore_1
      //   62: invokestatic 51	com/google/android/gms/internal/zzam:zzaa	()Ljava/util/concurrent/CountDownLatch;
      //   65: invokevirtual 56	java/util/concurrent/CountDownLatch:countDown	()V
      //   68: goto -32 -> 36
      //   71: astore_1
      //   72: invokestatic 51	com/google/android/gms/internal/zzam:zzaa	()Ljava/util/concurrent/CountDownLatch;
      //   75: invokevirtual 56	java/util/concurrent/CountDownLatch:countDown	()V
      //   78: goto -42 -> 36
      //   81: astore_1
      //   82: invokestatic 51	com/google/android/gms/internal/zzam:zzaa	()Ljava/util/concurrent/CountDownLatch;
      //   85: invokevirtual 56	java/util/concurrent/CountDownLatch:countDown	()V
      //   88: aload_1
      //   89: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	90	0	this	zzb
      //   20	6	1	localAdvertisingIdClient	AdvertisingIdClient
      //   40	1	1	localGooglePlayServicesNotAvailableException	com.google.android.gms.common.GooglePlayServicesNotAvailableException
      //   55	5	1	localObject1	Object
      //   61	1	1	localIOException	IOException
      //   71	1	1	localGooglePlayServicesRepairableException	com.google.android.gms.common.GooglePlayServicesRepairableException
      //   81	8	1	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   3	30	40	com/google/android/gms/common/GooglePlayServicesNotAvailableException
      //   30	36	55	finally
      //   36	39	55	finally
      //   46	52	55	finally
      //   56	59	55	finally
      //   62	68	55	finally
      //   72	78	55	finally
      //   82	90	55	finally
      //   3	30	61	java/io/IOException
      //   3	30	71	com/google/android/gms/common/GooglePlayServicesRepairableException
      //   3	30	81	finally
      //   41	46	81	finally
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzam
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */