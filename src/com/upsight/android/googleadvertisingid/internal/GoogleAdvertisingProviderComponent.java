package com.upsight.android.googleadvertisingid.internal;

import com.upsight.android.googleadvertisingid.UpsightGoogleAdvertisingProviderComponent;
import dagger.Component;
import javax.inject.Singleton;

@Component(modules={GoogleAdvertisingProviderModule.class})
@Singleton
public abstract interface GoogleAdvertisingProviderComponent
  extends UpsightGoogleAdvertisingProviderComponent
{}

/* Location:
 * Qualified Name:     com.upsight.android.googleadvertisingid.internal.GoogleAdvertisingProviderComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */