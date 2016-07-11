package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public final class zzj$zzg
  extends zzj<T>.zza
{
  public final IBinder zzafO;
  
  public zzj$zzg(zzj paramzzj, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(paramzzj, paramInt, paramBundle);
    zzafO = paramIBinder;
  }
  
  protected void zzh(ConnectionResult paramConnectionResult)
  {
    if (zzj.zze(zzafK) != null) {
      zzj.zze(zzafK).onConnectionFailed(paramConnectionResult);
    }
    zzafK.onConnectionFailed(paramConnectionResult);
  }
  
  protected boolean zzpf()
  {
    do
    {
      try
      {
        String str = zzafO.getInterfaceDescriptor();
        if (!zzafK.zzfL().equals(str))
        {
          Log.e("GmsClient", "service descriptor mismatch: " + zzafK.zzfL() + " vs. " + str);
          return false;
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("GmsClient", "service probably died");
        return false;
      }
      localObject = zzafK.zzW(zzafO);
    } while ((localObject == null) || (!zzj.zza(zzafK, 2, 3, (IInterface)localObject)));
    Object localObject = zzafK.zzmS();
    if (zzj.zzb(zzafK) != null) {
      zzj.zzb(zzafK).onConnected((Bundle)localObject);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */