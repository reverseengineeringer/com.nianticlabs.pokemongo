package com.upsight.android.analytics.internal.dispatcher.schema;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IdentifierConfig$Builder
{
  private Map<String, String> identifierFilters = new HashMap();
  private Map<String, Set<String>> identifiers = new HashMap();
  
  public Builder addIdentifierFilter(String paramString1, String paramString2)
  {
    if (identifierFilters.containsKey(paramString1)) {
      throw new IllegalArgumentException("Identifier filter " + paramString1 + " already exists");
    }
    identifierFilters.put(paramString1, paramString2);
    return this;
  }
  
  public Builder addIdentifiers(String paramString, Set<String> paramSet)
  {
    if (identifiers.containsKey(paramString)) {
      throw new IllegalArgumentException("Identifiers name " + paramString + " already exists");
    }
    identifiers.put(paramString, paramSet);
    return this;
  }
  
  public IdentifierConfig build()
  {
    return new IdentifierConfig(this, null);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.schema.IdentifierConfig.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */