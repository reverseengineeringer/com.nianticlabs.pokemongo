package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public final class Auth$AuthCredentialsOptions
  implements Api.ApiOptions.Optional
{
  private final String zzRY;
  private final PasswordSpecification zzRZ;
  
  public Bundle zzly()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("consumer_package", zzRY);
    localBundle.putParcelable("password_specification", zzRZ);
    return localBundle;
  }
  
  public static class Builder
  {
    private PasswordSpecification zzRZ = PasswordSpecification.zzSt;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.Auth.AuthCredentialsOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */