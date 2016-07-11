package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class zzlc$zza<R extends Result>
  extends Handler
{
  public zzlc$zza()
  {
    this(Looper.getMainLooper());
  }
  
  public zzlc$zza(Looper paramLooper)
  {
    super(paramLooper);
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

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlc.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */