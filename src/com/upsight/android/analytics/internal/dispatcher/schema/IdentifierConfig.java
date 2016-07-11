package com.upsight.android.analytics.internal.dispatcher.schema;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IdentifierConfig
{
  private Map<String, String> mIdentifierFilters;
  private Map<String, Set<String>> mIdentifiers;
  
  private IdentifierConfig(Builder paramBuilder)
  {
    mIdentifiers = identifiers;
    mIdentifierFilters = identifierFilters;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (IdentifierConfig)paramObject;
      if (mIdentifierFilters != null)
      {
        if (mIdentifierFilters.equals(mIdentifierFilters)) {}
      }
      else {
        while (mIdentifierFilters != null) {
          return false;
        }
      }
      if (mIdentifiers == null) {
        break;
      }
    } while (mIdentifiers.equals(mIdentifiers));
    for (;;)
    {
      return false;
      if (mIdentifiers == null) {
        break;
      }
    }
  }
  
  public Map<String, String> getIdentifierFilters()
  {
    return Collections.unmodifiableMap(mIdentifierFilters);
  }
  
  public Map<String, Set<String>> getIdentifiers()
  {
    return Collections.unmodifiableMap(mIdentifiers);
  }
  
  public int hashCode()
  {
    int j = 0;
    if (mIdentifiers != null) {}
    for (int i = mIdentifiers.hashCode();; i = 0)
    {
      if (mIdentifierFilters != null) {
        j = mIdentifierFilters.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public static class Builder
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
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.schema.IdentifierConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */