package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.upsight.android.analytics.dispatcher.EndpointResponse;
import java.util.Collection;

public class ResponseParser$Response
{
  public final String error;
  public final Collection<EndpointResponse> responses;
  
  public ResponseParser$Response(Collection<EndpointResponse> paramCollection, String paramString)
  {
    responses = paramCollection;
    error = paramString;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.ResponseParser.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */