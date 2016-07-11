package com.upsight.android.analytics;

import android.content.Intent;
import com.upsight.android.UpsightException;
import com.upsight.android.analytics.event.UpsightAnalyticsEvent;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.provider.UpsightDataProvider;
import com.upsight.android.analytics.provider.UpsightLocationTracker.Data;
import com.upsight.android.analytics.provider.UpsightUserAttributes.Entry;
import java.util.Set;

public abstract interface UpsightAnalyticsApi
{
  public abstract Boolean getBooleanUserAttribute(String paramString);
  
  public abstract Set<UpsightUserAttributes.Entry> getDefaultUserAttributes();
  
  public abstract Float getFloatUserAttribute(String paramString);
  
  public abstract Integer getIntUserAttribute(String paramString);
  
  public abstract boolean getOptOutStatus();
  
  public abstract String getStringUserAttribute(String paramString);
  
  public abstract void purgeLocation();
  
  public abstract void putUserAttribute(String paramString, Boolean paramBoolean);
  
  public abstract void putUserAttribute(String paramString, Float paramFloat);
  
  public abstract void putUserAttribute(String paramString, Integer paramInteger);
  
  public abstract void putUserAttribute(String paramString1, String paramString2);
  
  public abstract void record(UpsightAnalyticsEvent paramUpsightAnalyticsEvent);
  
  public abstract void registerDataProvider(UpsightDataProvider paramUpsightDataProvider);
  
  public abstract void setOptOutStatus(boolean paramBoolean);
  
  public abstract void trackLocation(UpsightLocationTracker.Data paramData);
  
  public abstract void trackPurchase(int paramInt, String paramString1, double paramDouble1, double paramDouble2, String paramString2, Intent paramIntent, UpsightPublisherData paramUpsightPublisherData)
    throws UpsightException;
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.UpsightAnalyticsApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */