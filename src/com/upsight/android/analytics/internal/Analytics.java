package com.upsight.android.analytics.internal;

import android.content.Intent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import com.upsight.android.UpsightException;
import com.upsight.android.analytics.UpsightAnalyticsApi;
import com.upsight.android.analytics.UpsightGooglePlayHelper;
import com.upsight.android.analytics.event.UpsightAnalyticsEvent;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.internal.association.AssociationManager;
import com.upsight.android.analytics.internal.dispatcher.schema.SchemaSelectorBuilder;
import com.upsight.android.analytics.internal.session.Session;
import com.upsight.android.analytics.internal.session.SessionManager;
import com.upsight.android.analytics.provider.UpsightDataProvider;
import com.upsight.android.analytics.provider.UpsightLocationTracker;
import com.upsight.android.analytics.provider.UpsightLocationTracker.Data;
import com.upsight.android.analytics.provider.UpsightOptOutStatus;
import com.upsight.android.analytics.provider.UpsightUserAttributes;
import com.upsight.android.analytics.provider.UpsightUserAttributes.Entry;
import com.upsight.android.internal.util.PreferencesHelper;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class Analytics
  implements UpsightAnalyticsApi
{
  private static final String LOG_TAG = Analytics.class.getSimpleName();
  private static final String SEQUENCE_ID_FIELD_NAME = "seq_id";
  private static final String USER_ATTRIBUTES_FIELD_NAME = "user_attributes";
  private final AssociationManager mAssociationManager;
  private final UpsightDataStore mDataStore;
  private final Set<UpsightUserAttributes.Entry> mDefaultUserAttributes;
  private final UpsightGooglePlayHelper mGooglePlayHelper;
  private final UpsightLocationTracker mLocationTracker;
  private final UpsightLogger mLogger;
  private final ObjectMapper mObjectMapper;
  private final UpsightOptOutStatus mOptOutStatus;
  private final SchemaSelectorBuilder mSchemaSelector;
  private final SessionManager mSessionManager;
  private final UpsightContext mUpsight;
  private final UpsightUserAttributes mUserAttributes;
  
  @Inject
  public Analytics(UpsightContext paramUpsightContext, SessionManager paramSessionManager, SchemaSelectorBuilder paramSchemaSelectorBuilder, AssociationManager paramAssociationManager, UpsightOptOutStatus paramUpsightOptOutStatus, UpsightLocationTracker paramUpsightLocationTracker, UpsightUserAttributes paramUpsightUserAttributes, UpsightGooglePlayHelper paramUpsightGooglePlayHelper)
  {
    mUpsight = paramUpsightContext;
    mDataStore = paramUpsightContext.getDataStore();
    mSessionManager = paramSessionManager;
    mObjectMapper = paramUpsightContext.getCoreComponent().objectMapper();
    mLogger = paramUpsightContext.getLogger();
    mSchemaSelector = paramSchemaSelectorBuilder;
    mAssociationManager = paramAssociationManager;
    mOptOutStatus = paramUpsightOptOutStatus;
    mLocationTracker = paramUpsightLocationTracker;
    mUserAttributes = paramUpsightUserAttributes;
    mDefaultUserAttributes = mUserAttributes.getDefault();
    mGooglePlayHelper = paramUpsightGooglePlayHelper;
  }
  
  private void appendAssociationData(String paramString, ObjectNode paramObjectNode)
  {
    mAssociationManager.associate(paramString, paramObjectNode);
  }
  
  private JsonNode getAllAsJsonNode(Set<UpsightUserAttributes.Entry> paramSet)
  {
    ObjectNode localObjectNode = JsonNodeFactory.instance.objectNode();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      UpsightUserAttributes.Entry localEntry = (UpsightUserAttributes.Entry)paramSet.next();
      if (String.class.equals(localEntry.getType())) {
        localObjectNode.put(localEntry.getKey(), PreferencesHelper.getString(mUpsight, "com.upsight.user_attribute." + localEntry.getKey(), (String)localEntry.getDefaultValue()));
      } else if (Integer.class.equals(localEntry.getType())) {
        localObjectNode.put(localEntry.getKey(), PreferencesHelper.getInt(mUpsight, "com.upsight.user_attribute." + localEntry.getKey(), ((Integer)localEntry.getDefaultValue()).intValue()));
      } else if (Boolean.class.equals(localEntry.getType())) {
        localObjectNode.put(localEntry.getKey(), PreferencesHelper.getBoolean(mUpsight, "com.upsight.user_attribute." + localEntry.getKey(), ((Boolean)localEntry.getDefaultValue()).booleanValue()));
      } else if (Float.class.equals(localEntry.getType())) {
        localObjectNode.put(localEntry.getKey(), PreferencesHelper.getFloat(mUpsight, "com.upsight.user_attribute." + localEntry.getKey(), ((Float)localEntry.getDefaultValue()).floatValue()));
      }
    }
    return localObjectNode;
  }
  
  private ObjectNode toJsonNode(UpsightAnalyticsEvent paramUpsightAnalyticsEvent)
    throws JsonProcessingException
  {
    paramUpsightAnalyticsEvent = (ObjectNode)mObjectMapper.valueToTree(paramUpsightAnalyticsEvent);
    paramUpsightAnalyticsEvent.put("seq_id", EventSequenceId.getAndIncrement(mUpsight));
    paramUpsightAnalyticsEvent.put("user_attributes", getAllAsJsonNode(mDefaultUserAttributes));
    return paramUpsightAnalyticsEvent;
  }
  
  public Boolean getBooleanUserAttribute(String paramString)
  {
    return mUserAttributes.getBoolean(paramString);
  }
  
  public Set<UpsightUserAttributes.Entry> getDefaultUserAttributes()
  {
    return mUserAttributes.getDefault();
  }
  
  public Float getFloatUserAttribute(String paramString)
  {
    return mUserAttributes.getFloat(paramString);
  }
  
  public Integer getIntUserAttribute(String paramString)
  {
    return mUserAttributes.getInt(paramString);
  }
  
  public boolean getOptOutStatus()
  {
    return mOptOutStatus.get();
  }
  
  public String getStringUserAttribute(String paramString)
  {
    return mUserAttributes.getString(paramString);
  }
  
  public void purgeLocation()
  {
    mLocationTracker.purge();
  }
  
  public void putUserAttribute(String paramString, Boolean paramBoolean)
  {
    mUserAttributes.put(paramString, paramBoolean);
  }
  
  public void putUserAttribute(String paramString, Float paramFloat)
  {
    mUserAttributes.put(paramString, paramFloat);
  }
  
  public void putUserAttribute(String paramString, Integer paramInteger)
  {
    mUserAttributes.put(paramString, paramInteger);
  }
  
  public void putUserAttribute(String paramString1, String paramString2)
  {
    mUserAttributes.put(paramString1, paramString2);
  }
  
  public void record(UpsightAnalyticsEvent paramUpsightAnalyticsEvent)
  {
    try
    {
      Object localObject2 = mSessionManager.getCurrentSession();
      long l1 = ((Session)localObject2).getTimeStamp();
      Object localObject1 = ((Session)localObject2).getMessageID();
      Integer localInteger = ((Session)localObject2).getCampaignID();
      int i = ((Session)localObject2).getSessionNumber();
      long l2 = ((Session)localObject2).getPreviousTos();
      localObject2 = toJsonNode(paramUpsightAnalyticsEvent);
      appendAssociationData(paramUpsightAnalyticsEvent.getType(), (ObjectNode)localObject2);
      localObject1 = DataStoreRecord.create(DataStoreRecord.Action.Created, l1, (Integer)localObject1, localInteger, i, l2, ((ObjectNode)localObject2).toString(), paramUpsightAnalyticsEvent.getType());
      if ((paramUpsightAnalyticsEvent instanceof DynamicIdentifiers)) {
        ((DataStoreRecord)localObject1).setIdentifiers(((DynamicIdentifiers)paramUpsightAnalyticsEvent).getIdentifiersName());
      }
      mDataStore.store(localObject1);
      return;
    }
    catch (JsonProcessingException paramUpsightAnalyticsEvent)
    {
      mLogger.e(LOG_TAG, paramUpsightAnalyticsEvent, "Failed to record event.", new Object[0]);
    }
  }
  
  public void registerDataProvider(UpsightDataProvider paramUpsightDataProvider)
  {
    mSchemaSelector.registerDataProvider(paramUpsightDataProvider);
  }
  
  public void setOptOutStatus(boolean paramBoolean)
  {
    mOptOutStatus.set(paramBoolean);
  }
  
  public void trackLocation(UpsightLocationTracker.Data paramData)
  {
    mLocationTracker.track(paramData);
  }
  
  public void trackPurchase(int paramInt, String paramString1, double paramDouble1, double paramDouble2, String paramString2, Intent paramIntent, UpsightPublisherData paramUpsightPublisherData)
    throws UpsightException
  {
    mGooglePlayHelper.trackPurchase(paramInt, paramString1, paramDouble1, paramDouble2, paramString2, paramIntent, paramUpsightPublisherData);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.Analytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */