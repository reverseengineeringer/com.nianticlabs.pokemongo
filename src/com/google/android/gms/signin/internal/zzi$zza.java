package com.google.android.gms.signin.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzqx;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

class zzi$zza
  extends zzd.zza
{
  private final ExecutorService zzaVm;
  private final zzqx zzaaT;
  
  public zzi$zza(zzqx paramzzqx, ExecutorService paramExecutorService)
  {
    zzaaT = paramzzqx;
    zzaVm = paramExecutorService;
  }
  
  private GoogleApiClient.ServerAuthCodeCallbacks zzCg()
    throws RemoteException
  {
    return zzaaT.zzCg();
  }
  
  public void zza(final String paramString1, final String paramString2, final zzf paramzzf)
    throws RemoteException
  {
    zzaVm.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          boolean bool = zzi.zza.zza(zzi.zza.this).onUploadServerAuthCode(paramString1, paramString2);
          paramzzf.zzaq(bool);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", localRemoteException);
        }
      }
    });
  }
  
  public void zza(final String paramString, final List<Scope> paramList, final zzf paramzzf)
    throws RemoteException
  {
    zzaVm.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          Object localObject = zzi.zza.zza(zzi.zza.this);
          Set localSet = Collections.unmodifiableSet(new HashSet(paramList));
          localObject = ((GoogleApiClient.ServerAuthCodeCallbacks)localObject).onCheckServerAuthorization(paramString, localSet);
          localObject = new CheckServerAuthResult(((GoogleApiClient.ServerAuthCodeCallbacks.CheckResult)localObject).zznD(), ((GoogleApiClient.ServerAuthCodeCallbacks.CheckResult)localObject).zznE());
          paramzzf.zza((CheckServerAuthResult)localObject);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", localRemoteException);
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.zzi.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */