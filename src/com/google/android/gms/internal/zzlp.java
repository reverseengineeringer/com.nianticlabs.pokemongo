package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class zzlp
  extends Fragment
  implements DialogInterface.OnCancelListener
{
  private static final GoogleApiAvailability zzacJ = ;
  private boolean mStarted;
  private boolean zzacK;
  private int zzacL = -1;
  private ConnectionResult zzacM;
  private final Handler zzacN = new Handler(Looper.getMainLooper());
  private zzll zzacO;
  private final SparseArray<zza> zzacP = new SparseArray();
  
  public static zzlp zza(FragmentActivity paramFragmentActivity)
  {
    zzx.zzci("Must be called from main thread of process");
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    try
    {
      zzlp localzzlp = (zzlp)paramFragmentActivity.findFragmentByTag("GmsSupportLifecycleFragment");
      if (localzzlp != null)
      {
        paramFragmentActivity = localzzlp;
        if (!localzzlp.isRemoving()) {}
      }
      else
      {
        paramFragmentActivity = null;
      }
      return paramFragmentActivity;
    }
    catch (ClassCastException paramFragmentActivity)
    {
      throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", paramFragmentActivity);
    }
  }
  
  private void zza(int paramInt, ConnectionResult paramConnectionResult)
  {
    Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
    Object localObject = (zza)zzacP.get(paramInt);
    if (localObject != null)
    {
      zzbp(paramInt);
      localObject = zzacS;
      if (localObject != null) {
        ((GoogleApiClient.OnConnectionFailedListener)localObject).onConnectionFailed(paramConnectionResult);
      }
    }
    zzok();
  }
  
  public static zzlp zzb(FragmentActivity paramFragmentActivity)
  {
    zzlp localzzlp = zza(paramFragmentActivity);
    FragmentManager localFragmentManager = paramFragmentActivity.getSupportFragmentManager();
    paramFragmentActivity = localzzlp;
    if (localzzlp == null)
    {
      paramFragmentActivity = new zzlp();
      localFragmentManager.beginTransaction().add(paramFragmentActivity, "GmsSupportLifecycleFragment").commitAllowingStateLoss();
      localFragmentManager.executePendingTransactions();
    }
    return paramFragmentActivity;
  }
  
  private void zzok()
  {
    zzacK = false;
    zzacL = -1;
    zzacM = null;
    if (zzacO != null)
    {
      zzacO.unregister();
      zzacO = null;
    }
    int i = 0;
    while (i < zzacP.size())
    {
      zzacP.valueAt(i)).zzacR.connect();
      i += 1;
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    int i = 0;
    while (i < zzacP.size())
    {
      ((zza)zzacP.valueAt(i)).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      i += 1;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramInt1 = 0;
      do
      {
        for (;;)
        {
          if (paramInt1 == 0) {
            break label87;
          }
          zzok();
          return;
          if (zzacJ.isGooglePlayServicesAvailable(getActivity()) != 0) {
            break;
          }
          paramInt1 = i;
        }
        paramInt1 = i;
      } while (paramInt2 == -1);
      if (paramInt2 == 0) {
        zzacM = new ConnectionResult(13, null);
      }
    }
    label87:
    zza(zzacL, zzacM);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    zza(zzacL, new ConnectionResult(13, null));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      zzacK = paramBundle.getBoolean("resolving_error", false);
      zzacL = paramBundle.getInt("failed_client_id", -1);
      if (zzacL >= 0) {
        zzacM = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", zzacK);
    if (zzacL >= 0)
    {
      paramBundle.putInt("failed_client_id", zzacL);
      paramBundle.putInt("failed_status", zzacM.getErrorCode());
      paramBundle.putParcelable("failed_resolution", zzacM.getResolution());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    mStarted = true;
    if (!zzacK)
    {
      int i = 0;
      while (i < zzacP.size())
      {
        zzacP.valueAt(i)).zzacR.connect();
        i += 1;
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    mStarted = false;
    int i = 0;
    while (i < zzacP.size())
    {
      zzacP.valueAt(i)).zzacR.disconnect();
      i += 1;
    }
  }
  
  public void zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzx.zzb(paramGoogleApiClient, "GoogleApiClient instance cannot be null");
    if (zzacP.indexOfKey(paramInt) < 0) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Already managing a GoogleApiClient with id " + paramInt);
      paramOnConnectionFailedListener = new zza(paramInt, paramGoogleApiClient, paramOnConnectionFailedListener);
      zzacP.put(paramInt, paramOnConnectionFailedListener);
      if ((mStarted) && (!zzacK)) {
        paramGoogleApiClient.connect();
      }
      return;
    }
  }
  
  public void zzbp(int paramInt)
  {
    zza localzza = (zza)zzacP.get(paramInt);
    zzacP.remove(paramInt);
    if (localzza != null) {
      localzza.zzom();
    }
  }
  
  private class zza
    implements GoogleApiClient.OnConnectionFailedListener
  {
    public final int zzacQ;
    public final GoogleApiClient zzacR;
    public final GoogleApiClient.OnConnectionFailedListener zzacS;
    
    public zza(int paramInt, GoogleApiClient paramGoogleApiClient, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      zzacQ = paramInt;
      zzacR = paramGoogleApiClient;
      zzacS = paramOnConnectionFailedListener;
      paramGoogleApiClient.registerConnectionFailedListener(this);
    }
    
    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      paramPrintWriter.append(paramString).append("GoogleApiClient #").print(zzacQ);
      paramPrintWriter.println(":");
      zzacR.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      zzlp.zzd(zzlp.this).post(new zzlp.zzb(zzlp.this, zzacQ, paramConnectionResult));
    }
    
    public void zzom()
    {
      zzacR.unregisterConnectionFailedListener(this);
      zzacR.disconnect();
    }
  }
  
  private class zzb
    implements Runnable
  {
    private final int zzacU;
    private final ConnectionResult zzacV;
    
    public zzb(int paramInt, ConnectionResult paramConnectionResult)
    {
      zzacU = paramInt;
      zzacV = paramConnectionResult;
    }
    
    public void run()
    {
      if ((!zzlp.zza(zzlp.this)) || (zzlp.zzb(zzlp.this))) {
        return;
      }
      zzlp.zza(zzlp.this, true);
      zzlp.zza(zzlp.this, zzacU);
      zzlp.zza(zzlp.this, zzacV);
      if (zzacV.hasResolution()) {
        try
        {
          int i = getActivity().getSupportFragmentManager().getFragments().indexOf(zzlp.this);
          zzacV.startResolutionForResult(getActivity(), (i + 1 << 16) + 1);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          zzlp.zzc(zzlp.this);
          return;
        }
      }
      if (zzlp.zzol().isUserResolvableError(zzacV.getErrorCode()))
      {
        GooglePlayServicesUtil.showErrorDialogFragment(zzacV.getErrorCode(), getActivity(), zzlp.this, 2, zzlp.this);
        return;
      }
      if (zzacV.getErrorCode() == 18)
      {
        final Dialog localDialog = zzlp.zzol().zza(getActivity(), zzlp.this);
        zzlp.zza(zzlp.this, zzll.zza(getActivity().getApplicationContext(), new zzll()
        {
          protected void zzoi()
          {
            zzlp.zzc(zzlp.this);
            localDialog.dismiss();
          }
        }));
        return;
      }
      zzlp.zza(zzlp.this, zzacU, zzacV);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */