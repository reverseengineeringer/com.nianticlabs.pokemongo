package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.zza;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzlc<R extends Result>
  extends PendingResult<R>
{
  private boolean zzL;
  private volatile R zzaaX;
  private final Object zzabh = new Object();
  protected final zza<R> zzabi;
  private final ArrayList<PendingResult.zza> zzabj = new ArrayList();
  private ResultCallback<? super R> zzabk;
  private volatile boolean zzabl;
  private boolean zzabm;
  private zzq zzabn;
  private Integer zzabo;
  private volatile zzlq<R> zzabp;
  private final CountDownLatch zzoS = new CountDownLatch(1);
  
  @Deprecated
  protected zzlc(Looper paramLooper)
  {
    zzabi = new zza(paramLooper);
  }
  
  protected zzlc(GoogleApiClient paramGoogleApiClient)
  {
    if (paramGoogleApiClient != null) {}
    for (paramGoogleApiClient = paramGoogleApiClient.getLooper();; paramGoogleApiClient = Looper.getMainLooper())
    {
      zzabi = new zza(paramGoogleApiClient);
      return;
    }
  }
  
  private R get()
  {
    boolean bool = true;
    synchronized (zzabh)
    {
      if (!zzabl)
      {
        zzx.zza(bool, "Result has already been consumed.");
        zzx.zza(isReady(), "Result is not ready.");
        Result localResult = zzaaX;
        zzaaX = null;
        zzabk = null;
        zzabl = true;
        zznL();
        return localResult;
      }
      bool = false;
    }
  }
  
  private void zzc(R paramR)
  {
    zzaaX = paramR;
    zzabn = null;
    zzoS.countDown();
    paramR = zzaaX.getStatus();
    if (zzabk != null)
    {
      zzabi.zznM();
      if (!zzL) {
        zzabi.zza(zzabk, get());
      }
    }
    Iterator localIterator = zzabj.iterator();
    while (localIterator.hasNext()) {
      ((PendingResult.zza)localIterator.next()).zzt(paramR);
    }
    zzabj.clear();
  }
  
  public static void zzd(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {}
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("BasePendingResult", "Unable to release " + paramResult, localRuntimeException);
    }
  }
  
  public final R await()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      zzx.zza(bool1, "await must not be called on the UI thread");
      if (!zzabl)
      {
        bool1 = true;
        label28:
        zzx.zza(bool1, "Result has already been consumed");
        if (zzabp != null) {
          break label80;
        }
        bool1 = bool2;
        zzx.zza(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        zzoS.await();
        zzx.zza(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
        break label28;
        label80:
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          zzw(Status.zzabc);
        }
      }
    }
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramLong <= 0L) || (Looper.myLooper() != Looper.getMainLooper())) {
      bool1 = true;
    }
    for (;;)
    {
      zzx.zza(bool1, "await must not be called on the UI thread when time is greater than zero.");
      if (!zzabl)
      {
        bool1 = true;
        label38:
        zzx.zza(bool1, "Result has already been consumed.");
        if (zzabp != null) {
          break label108;
        }
        bool1 = bool2;
        zzx.zza(bool1, "Cannot await if then() has been called.");
      }
      try
      {
        if (!zzoS.await(paramLong, paramTimeUnit)) {
          zzw(Status.zzabe);
        }
        zzx.zza(isReady(), "Result is not ready.");
        return get();
        bool1 = false;
        continue;
        bool1 = false;
        break label38;
        label108:
        bool1 = false;
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;)
        {
          zzw(Status.zzabc);
        }
      }
    }
  }
  
  public void cancel()
  {
    synchronized (zzabh)
    {
      if ((zzL) || (zzabl)) {
        return;
      }
      zzq localzzq = zzabn;
      if (localzzq == null) {}
    }
    try
    {
      zzabn.cancel();
      zzd(zzaaX);
      zzabk = null;
      zzL = true;
      zzc(zzb(Status.zzabf));
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public boolean isCanceled()
  {
    synchronized (zzabh)
    {
      boolean bool = zzL;
      return bool;
    }
  }
  
  public final boolean isReady()
  {
    return zzoS.getCount() == 0L;
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!zzabl)
    {
      bool1 = true;
      zzx.zza(bool1, "Result has already been consumed.");
    }
    for (;;)
    {
      synchronized (zzabh)
      {
        if (zzabp != null) {
          break label94;
        }
        bool1 = bool2;
        zzx.zza(bool1, "Cannot set callbacks if then() has been called.");
        if (isCanceled()) {
          return;
        }
        if (isReady())
        {
          zzabi.zza(paramResultCallback, get());
          return;
        }
      }
      zzabk = paramResultCallback;
      continue;
      bool1 = false;
      break;
      label94:
      bool1 = false;
    }
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!zzabl)
    {
      bool1 = true;
      zzx.zza(bool1, "Result has already been consumed.");
    }
    for (;;)
    {
      synchronized (zzabh)
      {
        if (zzabp != null) {
          break label115;
        }
        bool1 = bool2;
        zzx.zza(bool1, "Cannot set callbacks if then() has been called.");
        if (isCanceled()) {
          return;
        }
        if (isReady())
        {
          zzabi.zza(paramResultCallback, get());
          return;
        }
      }
      zzabk = paramResultCallback;
      zzabi.zza(this, paramTimeUnit.toMillis(paramLong));
      continue;
      bool1 = false;
      break;
      label115:
      bool1 = false;
    }
  }
  
  public final void zza(PendingResult.zza paramzza)
  {
    boolean bool2 = true;
    if (!zzabl)
    {
      bool1 = true;
      zzx.zza(bool1, "Result has already been consumed.");
      if (paramzza == null) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "Callback cannot be null.");
      synchronized (zzabh)
      {
        if (isReady())
        {
          paramzza.zzt(zzaaX.getStatus());
          return;
        }
        zzabj.add(paramzza);
      }
      bool1 = false;
      break;
    }
  }
  
  protected final void zza(zzq paramzzq)
  {
    synchronized (zzabh)
    {
      zzabn = paramzzq;
      return;
    }
  }
  
  protected abstract R zzb(Status paramStatus);
  
  public final void zzb(R paramR)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (zzabh)
      {
        if ((zzabm) || (zzL))
        {
          zzd(paramR);
          return;
        }
        if (!isReady())
        {
          bool1 = true;
          zzx.zza(bool1, "Results have already been set");
          if (zzabl) {
            break label84;
          }
          bool1 = bool2;
          zzx.zza(bool1, "Result has already been consumed");
          zzc(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label84:
      bool1 = false;
    }
  }
  
  public Integer zznF()
  {
    return zzabo;
  }
  
  protected void zznL() {}
  
  public final void zzw(Status paramStatus)
  {
    synchronized (zzabh)
    {
      if (!isReady())
      {
        zzb(zzb(paramStatus));
        zzabm = true;
      }
      return;
    }
  }
  
  public static class zza<R extends Result>
    extends Handler
  {
    public zza()
    {
      this(Looper.getMainLooper());
    }
    
    public zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      default: 
        Log.wtf("BasePendingResult", "Don't know how to handle message: " + what, new Exception());
        return;
      case 1: 
        paramMessage = (Pair)obj;
        zzb((ResultCallback)first, (Result)second);
        return;
      }
      ((zzlc)obj).zzw(Status.zzabe);
    }
    
    public void zza(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }
    
    public void zza(zzlc<R> paramzzlc, long paramLong)
    {
      sendMessageDelayed(obtainMessage(2, paramzzlc), paramLong);
    }
    
    protected void zzb(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      try
      {
        paramResultCallback.onResult(paramR);
        return;
      }
      catch (RuntimeException paramResultCallback)
      {
        zzlc.zzd(paramR);
        throw paramResultCallback;
      }
    }
    
    public void zznM()
    {
      removeMessages(2);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */