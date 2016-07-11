package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzx;

public final class zzlm<L>
{
  private volatile L mListener;
  private final zzlm<L>.zza zzacG;
  
  public zzlm(Looper paramLooper, L paramL)
  {
    zzacG = new zza(paramLooper);
    mListener = zzx.zzb(paramL, "Listener must not be null");
  }
  
  public void clear()
  {
    mListener = null;
  }
  
  public void zza(zzb<? super L> paramzzb)
  {
    zzx.zzb(paramzzb, "Notifier must not be null");
    paramzzb = zzacG.obtainMessage(1, paramzzb);
    zzacG.sendMessage(paramzzb);
  }
  
  void zzb(zzb<? super L> paramzzb)
  {
    Object localObject = mListener;
    if (localObject == null)
    {
      paramzzb.zznN();
      return;
    }
    try
    {
      paramzzb.zzq(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramzzb.zznN();
      throw localRuntimeException;
    }
  }
  
  private final class zza
    extends Handler
  {
    public zza(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      if (what == 1) {}
      for (;;)
      {
        zzx.zzaa(bool);
        zzb((zzlm.zzb)obj);
        return;
        bool = false;
      }
    }
  }
  
  public static abstract interface zzb<L>
  {
    public abstract void zznN();
    
    public abstract void zzq(L paramL);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */