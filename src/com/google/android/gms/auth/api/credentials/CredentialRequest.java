package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class CredentialRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzc();
  final int mVersionCode;
  private final boolean zzSo;
  private final String[] zzSp;
  private final CredentialPickerConfig zzSq;
  private final CredentialPickerConfig zzSr;
  
  CredentialRequest(int paramInt, boolean paramBoolean, String[] paramArrayOfString, CredentialPickerConfig paramCredentialPickerConfig1, CredentialPickerConfig paramCredentialPickerConfig2)
  {
    mVersionCode = paramInt;
    zzSo = paramBoolean;
    zzSp = ((String[])zzx.zzw(paramArrayOfString));
    paramArrayOfString = paramCredentialPickerConfig1;
    if (paramCredentialPickerConfig1 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    zzSq = paramArrayOfString;
    paramArrayOfString = paramCredentialPickerConfig2;
    if (paramCredentialPickerConfig2 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    zzSr = paramArrayOfString;
  }
  
  private CredentialRequest(Builder paramBuilder)
  {
    this(2, Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String[] getAccountTypes()
  {
    return zzSp;
  }
  
  public CredentialPickerConfig getCredentialHintPickerConfig()
  {
    return zzSr;
  }
  
  public CredentialPickerConfig getCredentialPickerConfig()
  {
    return zzSq;
  }
  
  public boolean getSupportsPasswordLogin()
  {
    return zzSo;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */