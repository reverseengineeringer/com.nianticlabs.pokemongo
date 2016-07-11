package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ResponseParser_Factory
  implements Factory<ResponseParser>
{
  private final Provider<ObjectMapper> mapperProvider;
  
  static
  {
    if (!ResponseParser_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ResponseParser_Factory(Provider<ObjectMapper> paramProvider)
  {
    assert (paramProvider != null);
    mapperProvider = paramProvider;
  }
  
  public static Factory<ResponseParser> create(Provider<ObjectMapper> paramProvider)
  {
    return new ResponseParser_Factory(paramProvider);
  }
  
  public ResponseParser get()
  {
    return new ResponseParser((ObjectMapper)mapperProvider.get());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.ResponseParser_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */