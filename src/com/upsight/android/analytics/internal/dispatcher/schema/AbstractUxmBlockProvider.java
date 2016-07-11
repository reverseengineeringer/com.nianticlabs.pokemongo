package com.upsight.android.analytics.internal.dispatcher.schema;

import com.upsight.android.analytics.provider.UpsightDataProvider;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractUxmBlockProvider
  extends UpsightDataProvider
{
  public static final String BUNDLE_HASH = "bundle.hash";
  public static final String BUNDLE_ID = "bundle.id";
  public static final String BUNDLE_SCHEMA_HASH = "bundle.schema_hash";
  
  public Set<String> availableKeys()
  {
    return new HashSet(Arrays.asList(new String[] { "bundle.schema_hash", "bundle.id", "bundle.hash" }));
  }
  
  public abstract String getBundleHash();
  
  public abstract String getBundleId();
  
  public abstract String getBundleSchemaHash();
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.schema.AbstractUxmBlockProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */