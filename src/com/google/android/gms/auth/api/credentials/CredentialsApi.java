package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface CredentialsApi
{
  public static final int ACTIVITY_RESULT_ADD_ACCOUNT = 1000;
  
  public abstract PendingResult<Status> delete(GoogleApiClient paramGoogleApiClient, Credential paramCredential);
  
  public abstract PendingResult<Status> disableAutoSignIn(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<CredentialRequestResult> request(GoogleApiClient paramGoogleApiClient, CredentialRequest paramCredentialRequest);
  
  public abstract PendingResult<Status> save(GoogleApiClient paramGoogleApiClient, Credential paramCredential);
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialsApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */