package com.upsight.android.googlepushservices.internal;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class GooglePushServices_Factory
  implements Factory<GooglePushServices>
{
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!GooglePushServices_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GooglePushServices_Factory(Provider<UpsightContext> paramProvider)
  {
    assert (paramProvider != null);
    upsightProvider = paramProvider;
  }
  
  public static Factory<GooglePushServices> create(Provider<UpsightContext> paramProvider)
  {
    return new GooglePushServices_Factory(paramProvider);
  }
  
  public GooglePushServices get()
  {
    return new GooglePushServices((UpsightContext)upsightProvider.get());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.GooglePushServices_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */