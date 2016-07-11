package com.upsight.android.analytics.event;

import android.text.TextUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.Map.Entry;

public class UpsightPublisherData$Builder
{
  private static final ObjectMapper sObjectMapper = new ObjectMapper();
  private final ObjectNode mDataMap;
  
  public UpsightPublisherData$Builder()
  {
    mDataMap = sObjectMapper.createObjectNode();
  }
  
  UpsightPublisherData$Builder(ObjectNode paramObjectNode)
  {
    mDataMap = paramObjectNode;
  }
  
  public UpsightPublisherData build()
  {
    return new UpsightPublisherData(this, null);
  }
  
  public Builder put(UpsightPublisherData paramUpsightPublisherData)
  {
    if (paramUpsightPublisherData != null)
    {
      paramUpsightPublisherData = UpsightPublisherData.access$000(paramUpsightPublisherData).fields();
      while (paramUpsightPublisherData.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramUpsightPublisherData.next();
        mDataMap.replace((String)localEntry.getKey(), (JsonNode)localEntry.getValue());
      }
    }
    return this;
  }
  
  public Builder put(String paramString, char paramChar)
  {
    if (!TextUtils.isEmpty(paramString)) {
      mDataMap.put(paramString, String.valueOf(paramChar));
    }
    return this;
  }
  
  public Builder put(String paramString, double paramDouble)
  {
    if (!TextUtils.isEmpty(paramString)) {
      mDataMap.put(paramString, paramDouble);
    }
    return this;
  }
  
  public Builder put(String paramString, float paramFloat)
  {
    if (!TextUtils.isEmpty(paramString)) {
      mDataMap.put(paramString, paramFloat);
    }
    return this;
  }
  
  public Builder put(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      mDataMap.put(paramString, paramInt);
    }
    return this;
  }
  
  public Builder put(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString)) {
      mDataMap.put(paramString, paramLong);
    }
    return this;
  }
  
  public Builder put(String paramString, CharSequence paramCharSequence)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramCharSequence != null)) {
      mDataMap.put(paramString, paramCharSequence.toString());
    }
    return this;
  }
  
  public Builder put(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {
      mDataMap.put(paramString, paramBoolean);
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.UpsightPublisherData.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */