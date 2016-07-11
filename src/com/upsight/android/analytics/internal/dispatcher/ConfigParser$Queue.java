package com.upsight.android.analytics.internal.dispatcher;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfigParser$Queue
{
  @JsonProperty("count_network_fail_retries")
  public boolean countNetworkFail;
  @JsonProperty("host")
  public String host;
  @JsonProperty("max_age")
  public int maxAge;
  @JsonProperty("max_size")
  public int maxSize;
  @JsonProperty("name")
  public String name;
  @JsonProperty("protocol")
  public String protocol;
  @JsonProperty("max_retry_count")
  public int retryCount;
  @JsonProperty("retry_interval")
  public int retryInterval;
  @JsonProperty("url_fmt")
  public String urlFormat;
  
  public String formatEndpointAddress()
  {
    return urlFormat.replace("{protocol}", protocol).replace("{host}", host);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.ConfigParser.Queue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */