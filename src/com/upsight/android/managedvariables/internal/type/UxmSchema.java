package com.upsight.android.managedvariables.internal.type;

import android.text.TextUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.managedvariables.type.UpsightManagedBoolean;
import com.upsight.android.managedvariables.type.UpsightManagedFloat;
import com.upsight.android.managedvariables.type.UpsightManagedInt;
import com.upsight.android.managedvariables.type.UpsightManagedString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class UxmSchema
{
  private static final String ITEM_SCHEMA_KEY_DEFAULT = "default";
  private static final String ITEM_SCHEMA_KEY_TAG = "tag";
  private static final String ITEM_SCHEMA_KEY_TYPE = "type";
  private static final Map<Class<? extends ManagedVariable>, Class<? extends BaseSchema>> sClassSchemaMap = new HashMap() {};
  private static final Map<String, Class<? extends BaseSchema>> sModelTypeSchemaMap = new HashMap() {};
  private static final Map<String, String> sTypeSchemaMap = new HashMap() {};
  private List<BaseSchema> mItemList = new ArrayList();
  private Map<String, BaseSchema> mItemSchemaMap = new HashMap();
  private UpsightLogger mLogger;
  public final String mSchemaJsonString;
  
  UxmSchema(UpsightLogger paramUpsightLogger)
  {
    mLogger = paramUpsightLogger;
    mSchemaJsonString = null;
  }
  
  private UxmSchema(List<BaseSchema> paramList, Map<String, BaseSchema> paramMap, UpsightLogger paramUpsightLogger, String paramString)
  {
    mItemList = paramList;
    mItemSchemaMap = paramMap;
    mLogger = paramUpsightLogger;
    mSchemaJsonString = paramString;
  }
  
  public static UxmSchema create(String paramString, ObjectMapper paramObjectMapper, UpsightLogger paramUpsightLogger)
    throws IllegalArgumentException
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    ArrayNode localArrayNode;
    Object localObject;
    for (;;)
    {
      try
      {
        localArrayNode = (ArrayNode)paramObjectMapper.readTree(paramString);
        Iterator localIterator = localArrayNode.iterator();
        if (!localIterator.hasNext()) {
          break label592;
        }
        paramString = (JsonNode)localIterator.next();
        if (!paramString.isObject())
        {
          paramString = "Managed variable schema must be a JSON object: " + paramString;
          paramUpsightLogger.e("Upsight", paramString, new Object[0]);
          throw new IllegalArgumentException(paramString);
        }
      }
      catch (IOException paramObjectMapper)
      {
        paramString = "Failed to parse UXM schema JSON: " + paramString;
        paramUpsightLogger.e("Upsight", paramObjectMapper, paramString, new Object[0]);
        throw new IllegalArgumentException(paramString, paramObjectMapper);
      }
      catch (ClassCastException paramObjectMapper)
      {
        paramString = "UXM schema must be a JSON array: " + paramString;
        paramUpsightLogger.e("Upsight", paramObjectMapper, paramString, new Object[0]);
        throw new IllegalArgumentException(paramString, paramObjectMapper);
      }
      if (!paramString.path("tag").isTextual())
      {
        paramString = "Managed variable schema must contain a tag: " + paramString;
        paramUpsightLogger.e("Upsight", paramString, new Object[0]);
        throw new IllegalArgumentException(paramString);
      }
      if (!paramString.path("type").isTextual())
      {
        paramString = "Managed variable schema must contain a type: " + paramString;
        paramUpsightLogger.e("Upsight", paramString, new Object[0]);
        throw new IllegalArgumentException(paramString);
      }
      if (!paramString.has("default"))
      {
        paramString = "Managed variable schema must contain a default value: " + paramString;
        paramUpsightLogger.e("Upsight", paramString, new Object[0]);
        throw new IllegalArgumentException(paramString);
      }
      localObject = (String)sTypeSchemaMap.get(paramString.path("type").asText());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        ((ObjectNode)paramString).put("type", (String)localObject);
        String str = paramString.path("tag").asText();
        Class localClass = (Class)sModelTypeSchemaMap.get(localObject);
        if (localClass == null) {
          break label549;
        }
        try
        {
          localObject = (BaseSchema)paramObjectMapper.treeToValue(paramString, localClass);
          localArrayList.add(localObject);
          localHashMap.put(str, localObject);
        }
        catch (JsonProcessingException paramObjectMapper)
        {
          paramString = "Managed variable contains invalid fields: " + paramString;
          paramUpsightLogger.e("Upsight", paramObjectMapper, paramString, new Object[0]);
          throw new IllegalArgumentException(paramString, paramObjectMapper);
        }
      }
    }
    paramString = "Managed variable contains invalid types: " + paramString;
    paramUpsightLogger.e("Upsight", paramString, new Object[0]);
    throw new IllegalArgumentException(paramString);
    label549:
    paramString = "Unknown managed variable type: " + (String)localObject;
    paramUpsightLogger.e("Upsight", paramString, new Object[0]);
    throw new IllegalArgumentException(paramString);
    label592:
    return new UxmSchema(localArrayList, localHashMap, paramUpsightLogger, localArrayNode.toString());
  }
  
  public <T extends ManagedVariable> BaseSchema get(Class<T> paramClass, String paramString)
  {
    BaseSchema localBaseSchema = (BaseSchema)mItemSchemaMap.get(paramString);
    if (localBaseSchema == null) {
      paramClass = null;
    }
    Class localClass1;
    Class localClass2;
    do
    {
      return paramClass;
      localClass1 = (Class)sClassSchemaMap.get(paramClass);
      localClass2 = (Class)sModelTypeSchemaMap.get(type);
      if ((localClass1 == null) || (localClass2 == null)) {
        break;
      }
      paramClass = localBaseSchema;
    } while (localClass2.equals(localClass1));
    paramClass = "The tag is not of the expected class: " + paramString;
    mLogger.e("Upsight", paramClass, new Object[0]);
    throw new IllegalArgumentException(paramClass);
  }
  
  public List<BaseSchema> getAllOrdered()
  {
    return new ArrayList(mItemList);
  }
  
  public static class BaseSchema<T>
  {
    @JsonProperty("default")
    public T defaultValue;
    @JsonProperty("description")
    public String description;
    @JsonProperty("tag")
    public String tag;
    @JsonProperty("type")
    public String type;
  }
  
  public static class BooleanSchema
    extends UxmSchema.BaseSchema<Boolean>
  {}
  
  public static class FloatSchema
    extends UxmSchema.BaseSchema<Float>
  {
    @JsonProperty("max")
    public Float max;
    @JsonProperty("min")
    public Float min;
  }
  
  public static class IntSchema
    extends UxmSchema.BaseSchema<Integer>
  {
    @JsonProperty("max")
    public Integer max;
    @JsonProperty("min")
    public Integer min;
  }
  
  public static class StringSchema
    extends UxmSchema.BaseSchema<String>
  {}
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmSchema
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */