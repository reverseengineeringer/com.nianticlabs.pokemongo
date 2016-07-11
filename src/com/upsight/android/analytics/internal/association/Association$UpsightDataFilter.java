package com.upsight.android.analytics.internal.association;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class Association$UpsightDataFilter
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.association.Association.UpsightDataFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */