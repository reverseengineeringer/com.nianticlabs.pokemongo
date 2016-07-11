package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.identity.intents.UserAddressRequest;

public class zzoy
  extends zzj<zzpa>
{
  private Activity mActivity;
  private final int mTheme;
  private final String zzRs;
  private zza zzaDj;
  
  public zzoy(Activity paramActivity, Looper paramLooper, zzf paramzzf, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramActivity, paramLooper, 12, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zzRs = paramzzf.getAccountName();
    mActivity = paramActivity;
    mTheme = paramInt;
  }
  
  public void disconnect()
  {
    super.disconnect();
    if (zzaDj != null)
    {
      zza.zza(zzaDj, null);
      zzaDj = null;
    }
  }
  
  public void zza(UserAddressRequest paramUserAddressRequest, int paramInt)
  {
    zzwk();
    zzaDj = new zza(paramInt, mActivity);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
      if (!TextUtils.isEmpty(zzRs)) {
        localBundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(zzRs, "com.google"));
      }
      localBundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", mTheme);
      zzwj().zza(zzaDj, paramUserAddressRequest, localBundle);
      return;
    }
    catch (RemoteException paramUserAddressRequest)
    {
      Log.e("AddressClientImpl", "Exception requesting user address", paramUserAddressRequest);
      paramUserAddressRequest = new Bundle();
      paramUserAddressRequest.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
      zzaDj.zzh(1, paramUserAddressRequest);
    }
  }
  
  protected zzpa zzbS(IBinder paramIBinder)
  {
    return zzpa.zza.zzbU(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.identity.service.BIND";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.identity.intents.internal.IAddressService";
  }
  
  public boolean zzpe()
  {
    return true;
  }
  
  protected zzpa zzwj()
    throws DeadObjectException
  {
    return (zzpa)super.zzpc();
  }
  
  protected void zzwk()
  {
    super.zzpb();
  }
  
  public static final class zza
    extends zzoz.zza
  {
    private Activity mActivity;
    private final int zzaaY;
    
    public zza(int paramInt, Activity paramActivity)
    {
      zzaaY = paramInt;
      mActivity = paramActivity;
    }
    
    private void setActivity(Activity paramActivity)
    {
      mActivity = paramActivity;
    }
    
    public void zzh(int paramInt, Bundle paramBundle)
    {
      Object localObject;
      if (paramInt == 1)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtras(paramBundle);
        paramBundle = mActivity.createPendingResult(zzaaY, (Intent)localObject, 1073741824);
        if (paramBundle != null) {}
      }
      for (;;)
      {
        return;
        try
        {
          paramBundle.send(1);
          return;
        }
        catch (PendingIntent.CanceledException paramBundle)
        {
          Log.w("AddressClientImpl", "Exception settng pending result", paramBundle);
          return;
        }
        localObject = null;
        if (paramBundle != null) {
          localObject = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
        }
        paramBundle = new ConnectionResult(paramInt, (PendingIntent)localObject);
        if (paramBundle.hasResolution()) {
          try
          {
            paramBundle.startResolutionForResult(mActivity, zzaaY);
            return;
          }
          catch (IntentSender.SendIntentException paramBundle)
          {
            Log.w("AddressClientImpl", "Exception starting pending intent", paramBundle);
            return;
          }
        }
        try
        {
          paramBundle = mActivity.createPendingResult(zzaaY, new Intent(), 1073741824);
          if (paramBundle != null)
          {
            paramBundle.send(1);
            return;
          }
        }
        catch (PendingIntent.CanceledException paramBundle)
        {
          Log.w("AddressClientImpl", "Exception setting pending result", paramBundle);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzoy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */