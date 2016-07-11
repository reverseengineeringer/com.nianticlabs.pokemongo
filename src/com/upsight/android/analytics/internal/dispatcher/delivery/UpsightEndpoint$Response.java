package com.upsight.android.analytics.internal.dispatcher.delivery;

public class UpsightEndpoint$Response
{
  public final String body;
  public final int statusCode;
  
  public UpsightEndpoint$Response(int paramInt, String paramString)
  {
    statusCode = paramInt;
    body = paramString;
  }
  
  public boolean isOk()
  {
    return statusCode == 200;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.UpsightEndpoint.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */