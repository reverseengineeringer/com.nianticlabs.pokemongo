package com.upsight.android.analytics.internal.dispatcher.schema;

import com.upsight.android.analytics.provider.UpsightDataProvider;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Schema
{
  private final Set<String> mAttributes;
  private final Map<String, UpsightDataProvider> mDataProviders;
  private final String mName;
  
  private Schema(String paramString, Set<String> paramSet, Map<String, UpsightDataProvider> paramMap)
  {
    mName = paramString;
    mAttributes = paramSet;
    mDataProviders = paramMap;
  }
  
  static Schema from(String paramString, Schema paramSchema, Set<String> paramSet)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(paramSet);
    localHashSet.addAll(mAttributes);
    return new Schema(paramString, localHashSet, mDataProviders);
  }
  
  public Set<String> availableKeys()
  {
    return mAttributes;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public Object getValueFor(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (mAttributes.contains(paramString))
    {
      UpsightDataProvider localUpsightDataProvider = (UpsightDataProvider)mDataProviders.get(paramString);
      localObject1 = localObject2;
      if (localUpsightDataProvider != null) {
        localObject1 = localUpsightDataProvider.get(paramString);
      }
    }
    return localObject1;
  }
  
  public static class Default
    extends Schema
  {
    static final Set<String> DEFAULT_REQUEST_ATTRIBUTES = new HashSet() {};
    
    Default(Map<String, UpsightDataProvider> paramMap)
    {
      super(DEFAULT_REQUEST_ATTRIBUTES, paramMap, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.schema.Schema
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */