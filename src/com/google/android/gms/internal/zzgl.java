package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzn;
import java.util.concurrent.Future;

@zzgr
public class zzgl
  extends zzhz
{
  private final zzgm zzDB;
  private Future<zzhs> zzDC;
  private final zzgg.zza zzDd;
  private final zzhs.zza zzDe;
  private final AdResponseParcel zzDf;
  private final Object zzpd = new Object();
  
  public zzgl(Context paramContext, zzn paramzzn, zzbc paramzzbc, zzhs.zza paramzza, zzan paramzzan, zzgg.zza paramzza1)
  {
    this(paramzza, paramzza1, new zzgm(paramContext, paramzzn, paramzzbc, new zzih(paramContext), paramzzan, paramzza));
  }
  
  zzgl(zzhs.zza paramzza, zzgg.zza paramzza1, zzgm paramzzgm)
  {
    zzDe = paramzza;
    zzDf = zzHD;
    zzDd = paramzza1;
    zzDB = paramzzgm;
  }
  
  private zzhs zzB(int paramInt)
  {
    return new zzhs(zzDe.zzHC.zzEn, null, null, paramInt, null, null, zzDf.orientation, zzDf.zzzc, zzDe.zzHC.zzEq, false, null, null, null, null, null, zzDf.zzEL, zzDe.zzqn, zzDf.zzEJ, zzDe.zzHz, zzDf.zzEO, zzDf.zzEP, zzDe.zzHw, null);
  }
  
  public void onStop()
  {
    synchronized (zzpd)
    {
      if (zzDC != null) {
        zzDC.cancel(true);
      }
      return;
    }
  }
  
  /* Error */
  public void zzbn()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/google/android/gms/internal/zzgl:zzpd	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 57	com/google/android/gms/internal/zzgl:zzDB	Lcom/google/android/gms/internal/zzgm;
    //   12: invokestatic 136	com/google/android/gms/internal/zzic:zza	(Ljava/util/concurrent/Callable;)Lcom/google/android/gms/internal/zziq;
    //   15: putfield 116	com/google/android/gms/internal/zzgl:zzDC	Ljava/util/concurrent/Future;
    //   18: aload_2
    //   19: monitorexit
    //   20: aload_0
    //   21: getfield 116	com/google/android/gms/internal/zzgl:zzDC	Ljava/util/concurrent/Future;
    //   24: ldc2_w 137
    //   27: getstatic 144	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   30: invokeinterface 148 4 0
    //   35: checkcast 61	com/google/android/gms/internal/zzhs
    //   38: astore_2
    //   39: bipush -2
    //   41: istore_1
    //   42: aload_2
    //   43: ifnull +73 -> 116
    //   46: getstatic 154	com/google/android/gms/internal/zzid:zzIE	Landroid/os/Handler;
    //   49: new 6	com/google/android/gms/internal/zzgl$1
    //   52: dup
    //   53: aload_0
    //   54: aload_2
    //   55: invokespecial 157	com/google/android/gms/internal/zzgl$1:<init>	(Lcom/google/android/gms/internal/zzgl;Lcom/google/android/gms/internal/zzhs;)V
    //   58: invokevirtual 163	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   61: pop
    //   62: return
    //   63: astore_3
    //   64: aload_2
    //   65: monitorexit
    //   66: aload_3
    //   67: athrow
    //   68: astore_2
    //   69: ldc -91
    //   71: invokestatic 171	com/google/android/gms/ads/internal/util/client/zzb:zzaH	(Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield 116	com/google/android/gms/internal/zzgl:zzDC	Ljava/util/concurrent/Future;
    //   78: iconst_1
    //   79: invokeinterface 122 2 0
    //   84: pop
    //   85: iconst_2
    //   86: istore_1
    //   87: aconst_null
    //   88: astore_2
    //   89: goto -47 -> 42
    //   92: astore_2
    //   93: iconst_0
    //   94: istore_1
    //   95: aconst_null
    //   96: astore_2
    //   97: goto -55 -> 42
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_2
    //   103: iconst_m1
    //   104: istore_1
    //   105: goto -63 -> 42
    //   108: astore_2
    //   109: aconst_null
    //   110: astore_2
    //   111: iconst_m1
    //   112: istore_1
    //   113: goto -71 -> 42
    //   116: aload_0
    //   117: iload_1
    //   118: invokespecial 173	com/google/android/gms/internal/zzgl:zzB	(I)Lcom/google/android/gms/internal/zzhs;
    //   121: astore_2
    //   122: goto -76 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	zzgl
    //   41	77	1	i	int
    //   68	1	2	localTimeoutException	java.util.concurrent.TimeoutException
    //   88	1	2	localObject2	Object
    //   92	1	2	localExecutionException	java.util.concurrent.ExecutionException
    //   96	1	2	localObject3	Object
    //   100	1	2	localInterruptedException	InterruptedException
    //   102	1	2	localObject4	Object
    //   108	1	2	localCancellationException	java.util.concurrent.CancellationException
    //   110	12	2	localzzhs	zzhs
    //   63	4	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	63	finally
    //   64	66	63	finally
    //   0	7	68	java/util/concurrent/TimeoutException
    //   20	39	68	java/util/concurrent/TimeoutException
    //   66	68	68	java/util/concurrent/TimeoutException
    //   0	7	92	java/util/concurrent/ExecutionException
    //   20	39	92	java/util/concurrent/ExecutionException
    //   66	68	92	java/util/concurrent/ExecutionException
    //   0	7	100	java/lang/InterruptedException
    //   20	39	100	java/lang/InterruptedException
    //   66	68	100	java/lang/InterruptedException
    //   0	7	108	java/util/concurrent/CancellationException
    //   20	39	108	java/util/concurrent/CancellationException
    //   66	68	108	java/util/concurrent/CancellationException
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */