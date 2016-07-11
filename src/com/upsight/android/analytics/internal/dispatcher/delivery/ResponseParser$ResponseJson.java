package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ResponseParser$ResponseJson
{
  @JsonProperty("error")
  public String error;
  @JsonProperty("response")
  public List<ResponseParser.ResponseElementJson> response;
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.ResponseParser.ResponseJson
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */