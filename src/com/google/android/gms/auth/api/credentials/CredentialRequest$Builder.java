package com.google.android.gms.auth.api.credentials;

public final class CredentialRequest$Builder
{
  private boolean zzSo;
  private String[] zzSp;
  private CredentialPickerConfig zzSq;
  private CredentialPickerConfig zzSr;
  
  public CredentialRequest build()
  {
    if (zzSp == null) {
      zzSp = new String[0];
    }
    if ((!zzSo) && (zzSp.length == 0)) {
      throw new IllegalStateException("At least one authentication method must be specified");
    }
    return new CredentialRequest(this, null);
  }
  
  public Builder setAccountTypes(String... paramVarArgs)
  {
    zzSp = paramVarArgs;
    return this;
  }
  
  public Builder setCredentialHintPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
  {
    zzSr = paramCredentialPickerConfig;
    return this;
  }
  
  public Builder setCredentialPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
  {
    zzSq = paramCredentialPickerConfig;
    return this;
  }
  
  public Builder setSupportsPasswordLogin(boolean paramBoolean)
  {
    zzSo = paramBoolean;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */