package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;

class zzkm$1
  extends zzkl
{
  zzkm$1(zzkm paramzzkm, GoogleApiClient paramGoogleApiClient, ProxyRequest paramProxyRequest)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(Context paramContext, zzkk paramzzkk)
    throws RemoteException
  {
    paramzzkk.zza(new zzkh()
    {
      public void zza(ProxyResponse paramAnonymousProxyResponse)
      {
        zzb(new zzkn(paramAnonymousProxyResponse));
      }
    }, zzSQ);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkm.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */