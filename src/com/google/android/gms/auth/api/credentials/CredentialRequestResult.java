package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.Result;

public abstract interface CredentialRequestResult
  extends Result
{
  public abstract Credential getCredential();
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialRequestResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */