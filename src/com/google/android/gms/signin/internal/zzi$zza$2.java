package com.google.android.gms.signin.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;

class zzi$zza$2
  implements Runnable
{
  zzi$zza$2(zzi.zza paramzza, String paramString1, String paramString2, zzf paramzzf) {}
  
  public void run()
  {
    try
    {
      boolean bool = zzi.zza.zza(zzaVq).onUploadServerAuthCode(zzaVo, zzaVr);
      zzaVp.zzaq(bool);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.zzi.zza.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */