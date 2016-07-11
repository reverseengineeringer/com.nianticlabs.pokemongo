package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialPickerConfig
  implements SafeParcelable
{
  public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zzb();
  private final boolean mShowCancelButton;
  final int mVersionCode;
  private final boolean zzSn;
  
  CredentialPickerConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    mVersionCode = paramInt;
    zzSn = paramBoolean1;
    mShowCancelButton = paramBoolean2;
  }
  
  private CredentialPickerConfig(Builder paramBuilder)
  {
    this(1, Builder.zza(paramBuilder), Builder.zzb(paramBuilder));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean shouldShowAddAccountButton()
  {
    return zzSn;
  }
  
  public boolean shouldShowCancelButton()
  {
    return mShowCancelButton;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private boolean mShowCancelButton = true;
    private boolean zzSn = false;
    
    public CredentialPickerConfig build()
    {
      return new CredentialPickerConfig(this, null);
    }
    
    public Builder setShowAddAccountButton(boolean paramBoolean)
    {
      zzSn = paramBoolean;
      return this;
    }
    
    public Builder setShowCancelButton(boolean paramBoolean)
    {
      mShowCancelButton = paramBoolean;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.CredentialPickerConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */