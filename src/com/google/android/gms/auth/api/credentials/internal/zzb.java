package com.google.android.gms.auth.api.credentials.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

public final class zzb
  implements CredentialRequestResult
{
  private final Status zzSC;
  private final Credential zzSD;
  
  public zzb(Status paramStatus, Credential paramCredential)
  {
    zzSC = paramStatus;
    zzSD = paramCredential;
  }
  
  public static zzb zzh(Status paramStatus)
  {
    return new zzb(paramStatus, null);
  }
  
  public Credential getCredential()
  {
    return zzSD;
  }
  
  public Status getStatus()
  {
    return zzSC;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */