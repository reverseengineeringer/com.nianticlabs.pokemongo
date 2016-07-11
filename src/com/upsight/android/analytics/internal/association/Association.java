package com.upsight.android.analytics.internal.association;

import android.text.TextUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.persistence.annotation.UpsightStorableIdentifier;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.association")
public class Association
{
  @UpsightStorableIdentifier
  String id;
  @JsonProperty("timestamp_ms")
  long timestampMs;
  @JsonProperty("upsight_data")
  ObjectNode upsightData;
  @JsonProperty("upsight_data_filter")
  UpsightDataFilter upsightDataFilter;
  @JsonProperty("with")
  String with;
  
  Association() {}
  
  private Association(String paramString, UpsightDataFilter paramUpsightDataFilter, ObjectNode paramObjectNode, long paramLong)
  {
    with = paramString;
    upsightDataFilter = paramUpsightDataFilter;
    upsightData = paramObjectNode;
    timestampMs = paramLong;
  }
  
  public static Association from(String paramString, ObjectNode paramObjectNode1, ObjectNode paramObjectNode2, ObjectMapper paramObjectMapper, Clock paramClock)
    throws IllegalArgumentException, JsonProcessingException
  {
    if ((TextUtils.isEmpty(paramString)) || (paramObjectNode1 == null) || (paramObjectNode2 == null)) {
      throw new IllegalArgumentException("Illegal arguments");
    }
    return new Association(paramString, (UpsightDataFilter)paramObjectMapper.treeToValue(paramObjectNode1, UpsightDataFilter.class), paramObjectNode2, paramClock.currentTimeMillis());
  }
  
  public String getId()
  {
    return id;
  }
  
  public long getTimestampMs()
  {
    return timestampMs;
  }
  
  public ObjectNode getUpsightData()
  {
    return upsightData;
  }
  
  public UpsightDataFilter getUpsightDataFilter()
  {
    return upsightDataFilter;
  }
  
  public String getWith()
  {
    return with;
  }
  
  public static class UpsightDataFilter
  {
    @JsonProperty("match_key")
    String matchKey;
    @JsonProperty("match_values")
    ArrayNode matchValues;
    
    public String getMatchKey()
    {
      return matchKey;
    }
    
    public ArrayNode getMatchValues()
    {
      return matchValues;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.association.Association
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */