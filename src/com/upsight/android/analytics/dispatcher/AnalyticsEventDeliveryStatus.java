package com.upsight.android.analytics.dispatcher;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.persistence.annotation.UpsightStorableIdentifier;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.dispatcher.delivery.status")
public final class AnalyticsEventDeliveryStatus
{
  @JsonProperty("id")
  @UpsightStorableIdentifier
  String id;
  @JsonProperty("failure_reason")
  private String mFailureReason;
  @JsonProperty("source_event_id")
  private String mOriginEventId;
  @JsonProperty("status")
  private boolean mStatus;
  
  AnalyticsEventDeliveryStatus() {}
  
  AnalyticsEventDeliveryStatus(String paramString1, boolean paramBoolean, String paramString2)
  {
    mOriginEventId = paramString1;
    mStatus = paramBoolean;
    mFailureReason = paramString2;
  }
  
  public static AnalyticsEventDeliveryStatus fromFailure(String paramString1, String paramString2)
  {
    return new AnalyticsEventDeliveryStatus(paramString1, false, paramString2);
  }
  
  public static AnalyticsEventDeliveryStatus fromSuccess(String paramString)
  {
    return new AnalyticsEventDeliveryStatus(paramString, true, null);
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
      paramObject = (AnalyticsEventDeliveryStatus)paramObject;
    } while ((id != null) && (id != null) && (id.equals(id)));
    return false;
  }
  
  public String getFailureReason()
  {
    return mFailureReason;
  }
  
  public String getSourceEventId()
  {
    return mOriginEventId;
  }
  
  public int hashCode()
  {
    if (id != null) {
      return id.hashCode();
    }
    return 0;
  }
  
  public boolean wasDelivered()
  {
    return mStatus;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.dispatcher.AnalyticsEventDeliveryStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */