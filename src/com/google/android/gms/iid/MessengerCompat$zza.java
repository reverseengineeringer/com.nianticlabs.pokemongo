package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;

final class MessengerCompat$zza
  extends zzb.zza
{
  Handler handler;
  
  MessengerCompat$zza(MessengerCompat paramMessengerCompat, Handler paramHandler)
  {
    handler = paramHandler;
  }
  
  public void send(Message paramMessage)
    throws RemoteException
  {
    arg2 = Binder.getCallingUid();
    handler.dispatchMessage(paramMessage);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.iid.MessengerCompat.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */