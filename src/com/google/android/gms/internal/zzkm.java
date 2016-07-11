package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;

public class zzkm
  implements ProxyApi
{
  public PendingResult<ProxyApi.ProxyResult> performProxyRequest(GoogleApiClient paramGoogleApiClient, final ProxyRequest paramProxyRequest)
  {
    zzx.zzw(paramGoogleApiClient);
    zzx.zzw(paramProxyRequest);
    paramGoogleApiClient.zzb(new zzkl(paramGoogleApiClient)
    {
      protected void zza(Context paramAnonymousContext, zzkk paramAnonymouszzkk)
        throws RemoteException
      {
        paramAnonymouszzkk.zza(new zzkh()
        {
          public void zza(ProxyResponse paramAnonymous2ProxyResponse)
          {
            zzb(new zzkn(paramAnonymous2ProxyResponse));
          }
        }, paramProxyRequest);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */