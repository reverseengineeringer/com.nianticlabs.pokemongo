package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzp;

@zzgr
public class zzia
  extends Handler
{
  public zzia(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      super.handleMessage(paramMessage);
      return;
    }
    catch (Exception paramMessage)
    {
      zzp.zzby().zzc(paramMessage, false);
      throw paramMessage;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzia
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */