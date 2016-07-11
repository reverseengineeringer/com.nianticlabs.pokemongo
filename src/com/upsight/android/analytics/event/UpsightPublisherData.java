package com.upsight.android.analytics.event;

import android.text.TextUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

@JsonDeserialize(using=Deserializer.class)
@JsonSerialize(using=Serializer.class)
public class UpsightPublisherData
{
  private final ObjectNode mDataMap;
  
  private UpsightPublisherData(Builder paramBuilder)
  {
    mDataMap = mDataMap;
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
      paramObject = (UpsightPublisherData)paramObject;
      if (mDataMap == null) {
        break;
      }
    } while (mDataMap.equals(mDataMap));
    while (mDataMap != null) {
      return false;
    }
    return true;
  }
  
  public String getData(String paramString)
  {
    return mDataMap.get(paramString).toString();
  }
  
  public int hashCode()
  {
    if (mDataMap != null) {
      return mDataMap.hashCode();
    }
    return 0;
  }
  
  public static class Builder
  {
    private static final ObjectMapper sObjectMapper = new ObjectMapper();
    private final ObjectNode mDataMap;
    
    public Builder()
    {
      mDataMap = sObjectMapper.createObjectNode();
    }
    
    Builder(ObjectNode paramObjectNode)
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
        paramUpsightPublisherData = mDataMap.fields();
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
  
  public static class Deserializer
    extends JsonDeserializer<UpsightPublisherData>
  {
    public UpsightPublisherData deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      return new UpsightPublisherData.Builder((ObjectNode)paramJsonParser.readValueAs(ObjectNode.class)).build();
    }
  }
  
  public static final class Serializer
    extends JsonSerializer<UpsightPublisherData>
  {
    public void serialize(UpsightPublisherData paramUpsightPublisherData, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException
    {
      paramSerializerProvider.defaultSerializeValue(mDataMap, paramJsonGenerator);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.event.UpsightPublisherData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */