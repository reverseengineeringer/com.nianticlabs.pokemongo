package com.upsight.android.googleadvertisingid.internal;

public final class DaggerGoogleAdvertisingProviderComponent$Builder
{
  private GoogleAdvertisingProviderModule googleAdvertisingProviderModule;
  
  public GoogleAdvertisingProviderComponent build()
  {
    if (googleAdvertisingProviderModule == null) {
      throw new IllegalStateException("googleAdvertisingProviderModule must be set");
    }
    return new DaggerGoogleAdvertisingProviderComponent(this, null);
  }
  
  public Builder googleAdvertisingProviderModule(GoogleAdvertisingProviderModule paramGoogleAdvertisingProviderModule)
  {
    if (paramGoogleAdvertisingProviderModule == null) {
      throw new NullPointerException("googleAdvertisingProviderModule");
    }
    googleAdvertisingProviderModule = paramGoogleAdvertisingProviderModule;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googleadvertisingid.internal.DaggerGoogleAdvertisingProviderComponent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */