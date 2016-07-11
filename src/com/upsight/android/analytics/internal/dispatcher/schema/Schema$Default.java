package com.upsight.android.analytics.internal.dispatcher.schema;

import com.upsight.android.analytics.provider.UpsightDataProvider;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Schema$Default
  extends Schema
{
  static final Set<String> DEFAULT_REQUEST_ATTRIBUTES = new HashSet() {};
  
  Schema$Default(Map<String, UpsightDataProvider> paramMap)
  {
    super(null, DEFAULT_REQUEST_ATTRIBUTES, paramMap, null);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.schema.Schema.Default
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */