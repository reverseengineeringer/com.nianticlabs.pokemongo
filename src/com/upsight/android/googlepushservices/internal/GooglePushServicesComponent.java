package com.upsight.android.googlepushservices.internal;

import com.upsight.android.googlepushservices.UpsightGooglePushServicesComponent;
import dagger.Component;
import javax.inject.Singleton;

@Component(modules={GooglePushServicesModule.class})
@Singleton
public abstract interface GooglePushServicesComponent
  extends UpsightGooglePushServicesComponent
{}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.GooglePushServicesComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */