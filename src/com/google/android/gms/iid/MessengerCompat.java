package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public class MessengerCompat
  implements Parcelable
{
  public static final Parcelable.Creator<MessengerCompat> CREATOR = new Parcelable.Creator()
  {
    public MessengerCompat zzey(Parcel paramAnonymousParcel)
    {
      paramAnonymousParcel = paramAnonymousParcel.readStrongBinder();
      if (paramAnonymousParcel != null) {
        return new MessengerCompat(paramAnonymousParcel);
      }
      return null;
    }
    
    public MessengerCompat[] zzgJ(int paramAnonymousInt)
    {
      return new MessengerCompat[paramAnonymousInt];
    }
  };
  Messenger zzaDK;
  zzb zzaDL;
  
  public MessengerCompat(Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      zzaDK = new Messenger(paramHandler);
      return;
    }
    zzaDL = new zza(paramHandler);
  }
  
  public MessengerCompat(IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      zzaDK = new Messenger(paramIBinder);
      return;
    }
    zzaDL = zzb.zza.zzbV(paramIBinder);
  }
  
  public static int zzc(Message paramMessage)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return zzd(paramMessage);
    }
    return arg2;
  }
  
  private static int zzd(Message paramMessage)
  {
    return sendingUid;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      boolean bool = getBinder().equals(((MessengerCompat)paramObject).getBinder());
      return bool;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public IBinder getBinder()
  {
    if (zzaDK != null) {
      return zzaDK.getBinder();
    }
    return zzaDL.asBinder();
  }
  
  public int hashCode()
  {
    return getBinder().hashCode();
  }
  
  public void send(Message paramMessage)
    throws RemoteException
  {
    if (zzaDK != null)
    {
      zzaDK.send(paramMessage);
      return;
    }
    zzaDL.send(paramMessage);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (zzaDK != null)
    {
      paramParcel.writeStrongBinder(zzaDK.getBinder());
      return;
    }
    paramParcel.writeStrongBinder(zzaDL.asBinder());
  }
  
  private final class zza
    extends zzb.zza
  {
    Handler handler;
    
    zza(Handler paramHandler)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.iid.MessengerCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */