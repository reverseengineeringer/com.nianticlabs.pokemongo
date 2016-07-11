package com.upsight.android.internal;

import com.upsight.android.UpsightCoreComponent;
import dagger.Component;
import javax.inject.Singleton;

@Component(modules={CoreModule.class})
@Singleton
public abstract interface CoreComponent
  extends UpsightCoreComponent
{}

/* Location:
 * Qualified Name:     com.upsight.android.internal.CoreComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */