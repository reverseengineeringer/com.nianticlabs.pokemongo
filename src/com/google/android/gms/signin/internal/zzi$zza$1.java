package com.google.android.gms.signin.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class zzi$zza$1
  implements Runnable
{
  zzi$zza$1(zzi.zza paramzza, List paramList, String paramString, zzf paramzzf) {}
  
  public void run()
  {
    try
    {
      Object localObject = zzi.zza.zza(zzaVq);
      Set localSet = Collections.unmodifiableSet(new HashSet(zzaVn));
      localObject = ((GoogleApiClient.ServerAuthCodeCallbacks)localObject).onCheckServerAuthorization(zzaVo, localSet);
      localObject = new CheckServerAuthResult(((GoogleApiClient.ServerAuthCodeCallbacks.CheckResult)localObject).zznD(), ((GoogleApiClient.ServerAuthCodeCallbacks.CheckResult)localObject).zznE());
      zzaVp.zza((CheckServerAuthResult)localObject);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.zzi.zza.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */