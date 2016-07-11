package com.upsight.android.analytics.internal;

import com.upsight.android.analytics.event.UpsightAnalyticsEvent;
import com.upsight.android.analytics.event.UpsightAnalyticsEvent.Builder;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;

public abstract class AnalyticsEvent<U>
  extends UpsightAnalyticsEvent<U, UpsightPublisherData>
{
  protected AnalyticsEvent() {}
  
  protected AnalyticsEvent(String paramString, U paramU, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramU, paramUpsightPublisherData);
  }
  
  public static abstract class Builder<T extends AnalyticsEvent<U>, U>
    extends UpsightAnalyticsEvent.Builder<T, U, UpsightPublisherData>
  {
    protected final UpsightPublisherData.Builder mPublisherDataBuilder = new UpsightPublisherData.Builder();
    
    public Builder<T, U> put(UpsightPublisherData paramUpsightPublisherData)
    {
      mPublisherDataBuilder.put(paramUpsightPublisherData);
      return this;
    }
    
    public Builder<T, U> put(String paramString, char paramChar)
    {
      mPublisherDataBuilder.put(paramString, paramChar);
      return this;
    }
    
    public Builder<T, U> put(String paramString, double paramDouble)
    {
      mPublisherDataBuilder.put(paramString, paramDouble);
      return this;
    }
    
    public Builder<T, U> put(String paramString, float paramFloat)
    {
      mPublisherDataBuilder.put(paramString, paramFloat);
      return this;
    }
    
    public Builder<T, U> put(String paramString, int paramInt)
    {
      mPublisherDataBuilder.put(paramString, paramInt);
      return this;
    }
    
    public Builder<T, U> put(String paramString, long paramLong)
    {
      mPublisherDataBuilder.put(paramString, paramLong);
      return this;
    }
    
    public Builder<T, U> put(String paramString, CharSequence paramCharSequence)
    {
      mPublisherDataBuilder.put(paramString, paramCharSequence);
      return this;
    }
    
    public Builder<T, U> put(String paramString, boolean paramBoolean)
    {
      mPublisherDataBuilder.put(paramString, paramBoolean);
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.AnalyticsEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */