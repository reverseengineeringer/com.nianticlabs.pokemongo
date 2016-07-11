package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

class zzc$1
  extends zzd<CredentialRequestResult>
{
  zzc$1(zzc paramzzc, GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(Context paramContext, zzh paramzzh)
    throws RemoteException
  {
    paramzzh.zza(new zza()
    {
      public void zza(Status paramAnonymousStatus, Credential paramAnonymousCredential)
      {
        zzb(new zzb(paramAnonymousStatus, paramAnonymousCredential));
      }
      
      public void zzg(Status paramAnonymousStatus)
      {
        zzb(zzb.zzh(paramAnonymousStatus));
      }
    }, zzSE);
  }
  
  protected CredentialRequestResult zzi(Status paramStatus)
  {
    return zzb.zzh(paramStatus);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.zzc.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */