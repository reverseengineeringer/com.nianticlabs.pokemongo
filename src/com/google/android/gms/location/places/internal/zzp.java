package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class zzp
{
  private static final String TAG = zzp.class.getSimpleName();
  private static final long zzaHF = TimeUnit.SECONDS.toMillis(1L);
  private static zzp zzaHG;
  private final Context mContext;
  private final Handler mHandler;
  private final Runnable zzaHH = new zza(null);
  private ArrayList<String> zzaHI = null;
  private ArrayList<String> zzaHJ = null;
  private final Object zzpd = new Object();
  
  private zzp(Context paramContext)
  {
    this((Context)zzx.zzw(paramContext), new Handler(Looper.getMainLooper()));
  }
  
  zzp(Context paramContext, Handler paramHandler)
  {
    mContext = paramContext;
    mHandler = paramHandler;
  }
  
  /* Error */
  public static zzp zzaF(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 58	com/google/android/gms/common/internal/zzx:zzw	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: pop
    //   8: getstatic 100	android/os/Build$VERSION:SDK_INT	I
    //   11: istore_1
    //   12: iload_1
    //   13: bipush 14
    //   15: if_icmpge +10 -> 25
    //   18: aconst_null
    //   19: astore_0
    //   20: ldc 2
    //   22: monitorexit
    //   23: aload_0
    //   24: areturn
    //   25: getstatic 102	com/google/android/gms/location/places/internal/zzp:zzaHG	Lcom/google/android/gms/location/places/internal/zzp;
    //   28: ifnonnull +17 -> 45
    //   31: new 2	com/google/android/gms/location/places/internal/zzp
    //   34: dup
    //   35: aload_0
    //   36: invokevirtual 106	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   39: invokespecial 108	com/google/android/gms/location/places/internal/zzp:<init>	(Landroid/content/Context;)V
    //   42: putstatic 102	com/google/android/gms/location/places/internal/zzp:zzaHG	Lcom/google/android/gms/location/places/internal/zzp;
    //   45: getstatic 102	com/google/android/gms/location/places/internal/zzp:zzaHG	Lcom/google/android/gms/location/places/internal/zzp;
    //   48: astore_0
    //   49: goto -29 -> 20
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramContext	Context
    //   11	5	1	i	int
    // Exception table:
    //   from	to	target	type
    //   3	12	52	finally
    //   25	45	52	finally
    //   45	49	52	finally
  }
  
  public void zzE(String paramString1, String paramString2)
  {
    synchronized (zzpd)
    {
      if (zzaHI == null)
      {
        zzaHI = new ArrayList();
        zzaHJ = new ArrayList();
        mHandler.postDelayed(zzaHH, zzaHF);
      }
      zzaHI.add(paramString1);
      zzaHJ.add(paramString2);
      if (zzaHI.size() >= 10000)
      {
        if (Log.isLoggable(TAG, 5)) {
          Log.w(TAG, "Event buffer full, flushing");
        }
        zzaHH.run();
        mHandler.removeCallbacks(zzaHH);
        return;
      }
      return;
    }
  }
  
  private class zza
    implements Runnable
  {
    private zza() {}
    
    public void run()
    {
      synchronized (zzp.zzb(zzp.this))
      {
        Intent localIntent = new Intent("com.google.android.location.places.METHOD_CALL");
        localIntent.setPackage("com.google.android.gms");
        localIntent.putStringArrayListExtra("PLACE_IDS", zzp.zzc(zzp.this));
        localIntent.putStringArrayListExtra("METHOD_NAMES", zzp.zzd(zzp.this));
        localIntent.putExtra("PACKAGE_NAME", zzp.zze(zzp.this).getPackageName());
        localIntent.putExtra("CLIENT_VERSION", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        zzp.zze(zzp.this).sendBroadcast(localIntent);
        zzp.zza(zzp.this, null);
        zzp.zzb(zzp.this, null);
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */