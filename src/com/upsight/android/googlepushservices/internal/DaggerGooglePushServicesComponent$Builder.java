package com.upsight.android.googlepushservices.internal;

public final class DaggerGooglePushServicesComponent$Builder
{
  private GoogleCloudMessagingModule googleCloudMessagingModule;
  private GooglePushServicesModule googlePushServicesModule;
  private PushModule pushModule;
  
  public GooglePushServicesComponent build()
  {
    if (googlePushServicesModule == null) {
      googlePushServicesModule = new GooglePushServicesModule();
    }
    if (pushModule == null) {
      throw new IllegalStateException("pushModule must be set");
    }
    if (googleCloudMessagingModule == null) {
      googleCloudMessagingModule = new GoogleCloudMessagingModule();
    }
    return new DaggerGooglePushServicesComponent(this, null);
  }
  
  public Builder googleCloudMessagingModule(GoogleCloudMessagingModule paramGoogleCloudMessagingModule)
  {
    if (paramGoogleCloudMessagingModule == null) {
      throw new NullPointerException("googleCloudMessagingModule");
    }
    googleCloudMessagingModule = paramGoogleCloudMessagingModule;
    return this;
  }
  
  public Builder googlePushServicesModule(GooglePushServicesModule paramGooglePushServicesModule)
  {
    if (paramGooglePushServicesModule == null) {
      throw new NullPointerException("googlePushServicesModule");
    }
    googlePushServicesModule = paramGooglePushServicesModule;
    return this;
  }
  
  public Builder pushModule(PushModule paramPushModule)
  {
    if (paramPushModule == null) {
      throw new NullPointerException("pushModule");
    }
    pushModule = paramPushModule;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.DaggerGooglePushServicesComponent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */