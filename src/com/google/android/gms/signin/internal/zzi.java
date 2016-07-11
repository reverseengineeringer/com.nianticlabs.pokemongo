package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzj.zzf;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqx;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class zzi
  extends zzj<zzf>
  implements zzqw
{
  private final boolean zzaVl;
  private final ExecutorService zzaVm;
  private final zzqx zzaaT;
  private final com.google.android.gms.common.internal.zzf zzabI;
  private Integer zzafj;
  
  public zzi(Context paramContext, Looper paramLooper, boolean paramBoolean, com.google.android.gms.common.internal.zzf paramzzf, zzqx paramzzqx, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, ExecutorService paramExecutorService)
  {
    super(paramContext, paramLooper, 44, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzaVl = paramBoolean;
    zzabI = paramzzf;
    zzaaT = paramzzqx;
    zzafj = paramzzf.zzoR();
    zzaVm = paramExecutorService;
  }
  
  public static Bundle zza(zzqx paramzzqx, Integer paramInteger, ExecutorService paramExecutorService)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", paramzzqx.zzCf());
    localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", paramzzqx.zzlY());
    localBundle.putString("com.google.android.gms.signin.internal.serverClientId", paramzzqx.zzmb());
    if (paramzzqx.zzCg() != null) {
      localBundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new zza(paramzzqx, paramExecutorService).asBinder()));
    }
    if (paramInteger != null) {
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", paramInteger.intValue());
    }
    localBundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", paramzzqx.zzCh());
    localBundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", paramzzqx.zzma());
    return localBundle;
  }
  
  public void connect()
  {
    zza(new zzj.zzf(this));
  }
  
  public void zzCe()
  {
    try
    {
      ((zzf)zzpc()).zzjq(zzafj.intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
    }
  }
  
  public void zza(zzp paramzzp, Set<Scope> paramSet, zze paramzze)
  {
    zzx.zzb(paramzze, "Expecting a valid ISignInCallbacks");
    try
    {
      ((zzf)zzpc()).zza(new AuthAccountRequest(paramzzp, paramSet), paramzze);
      return;
    }
    catch (RemoteException paramzzp)
    {
      Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
      try
      {
        paramzze.zza(new ConnectionResult(8, null), new AuthAccountResult());
        return;
      }
      catch (RemoteException paramSet)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.", paramzzp);
      }
    }
  }
  
  public void zza(zzp paramzzp, boolean paramBoolean)
  {
    try
    {
      ((zzf)zzpc()).zza(paramzzp, zzafj.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException paramzzp)
    {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
    }
  }
  
  public void zza(zzt paramzzt)
  {
    zzx.zzb(paramzzt, "Expecting a valid IResolveAccountCallbacks");
    try
    {
      Account localAccount = zzabI.zzoI();
      ((zzf)zzpc()).zza(new ResolveAccountRequest(localAccount, zzafj.intValue()), paramzzt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
      try
      {
        paramzzt.zzb(new ResolveAccountResponse(8));
        return;
      }
      catch (RemoteException paramzzt)
      {
        Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.", localRemoteException);
      }
    }
  }
  
  protected zzf zzdO(IBinder paramIBinder)
  {
    return zzf.zza.zzdN(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  public boolean zzlN()
  {
    return zzaVl;
  }
  
  protected Bundle zzly()
  {
    Bundle localBundle = zza(zzaaT, zzabI.zzoR(), zzaVm);
    String str = zzabI.zzoN();
    if (!getContext().getPackageName().equals(str)) {
      localBundle.putString("com.google.android.gms.signin.internal.realClientPackageName", zzabI.zzoN());
    }
    return localBundle;
  }
  
  private static class zza
    extends zzd.zza
  {
    private final ExecutorService zzaVm;
    private final zzqx zzaaT;
    
    public zza(zzqx paramzzqx, ExecutorService paramExecutorService)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */