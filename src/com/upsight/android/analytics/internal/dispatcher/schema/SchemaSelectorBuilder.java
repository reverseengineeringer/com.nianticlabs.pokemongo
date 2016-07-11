package com.upsight.android.analytics.internal.dispatcher.schema;

import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.dispatcher.util.ByFilterSelector;
import com.upsight.android.analytics.internal.dispatcher.util.ByNameSelector;
import com.upsight.android.analytics.internal.dispatcher.util.Selector;
import com.upsight.android.analytics.provider.UpsightDataProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SchemaSelectorBuilder
{
  private final Map<String, UpsightDataProvider> mDataProviders = new ConcurrentHashMap();
  private final Schema mDefaultSchema;
  
  SchemaSelectorBuilder(UpsightContext paramUpsightContext)
  {
    registerDefaultDataProviders(paramUpsightContext);
    mDefaultSchema = new Schema.Default(mDataProviders);
  }
  
  private void registerDefaultDataProviders(UpsightContext paramUpsightContext)
  {
    registerDataProvider(new AppBlockProvider(paramUpsightContext));
    registerDataProvider(new DeviceBlockProvider(paramUpsightContext));
    registerDataProvider(new AndroidIDBlockProvider(paramUpsightContext));
    registerDataProvider(new ScreenBlockProvider(paramUpsightContext));
    registerDataProvider(new SdkBlockProvider(paramUpsightContext));
    registerDataProvider(new SidProvider(paramUpsightContext));
    registerDataProvider(new LocationBlockProvider(paramUpsightContext));
  }
  
  public Selector<Schema> buildSelectorByName(IdentifierConfig paramIdentifierConfig)
  {
    Object localObject = paramIdentifierConfig.getIdentifiers();
    HashMap localHashMap = new HashMap(((Map)localObject).size());
    localObject = ((Map)localObject).keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      Set localSet = (Set)paramIdentifierConfig.getIdentifiers().get(str);
      if (localSet != null) {
        localHashMap.put(str, Schema.from(str, mDefaultSchema, localSet));
      }
    }
    return new ByNameSelector(localHashMap);
  }
  
  public Selector<Schema> buildSelectorByType(IdentifierConfig paramIdentifierConfig)
  {
    HashMap localHashMap = new HashMap(paramIdentifierConfig.getIdentifiers().size());
    Iterator localIterator = paramIdentifierConfig.getIdentifierFilters().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      Set localSet = (Set)paramIdentifierConfig.getIdentifiers().get(localObject);
      if (localSet != null) {
        localHashMap.put(str, Schema.from((String)localObject, mDefaultSchema, localSet));
      }
    }
    return new ByFilterSelector(localHashMap, mDefaultSchema);
  }
  
  public void registerDataProvider(UpsightDataProvider paramUpsightDataProvider)
  {
    Iterator localIterator = paramUpsightDataProvider.availableKeys().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (UpsightDataProvider)mDataProviders.put(localObject, paramUpsightDataProvider);
      if (localObject != null) {
        throw new IllegalStateException(String.format("Both %s and %s provide values for key.", new Object[] { paramUpsightDataProvider.getClass().getName(), localObject.getClass().getName() }));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.schema.SchemaSelectorBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */