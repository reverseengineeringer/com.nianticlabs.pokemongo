package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

class zzkn
  implements ProxyApi.ProxyResult
{
  private Status zzSC;
  private ProxyResponse zzST;
  
  public zzkn(ProxyResponse paramProxyResponse)
  {
    zzST = paramProxyResponse;
    zzSC = Status.zzabb;
  }
  
  public zzkn(Status paramStatus)
  {
    zzSC = paramStatus;
  }
  
  public ProxyResponse getResponse()
  {
    return zzST;
  }
  
  public Status getStatus()
  {
    return zzSC;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */