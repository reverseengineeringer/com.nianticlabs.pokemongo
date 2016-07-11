package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GsonBuilder
{
  private boolean complexMapKeySerialization;
  private String datePattern;
  private int dateStyle = 2;
  private boolean escapeHtmlChars = true;
  private Excluder excluder = Excluder.DEFAULT;
  private final List<TypeAdapterFactory> factories = new ArrayList();
  private FieldNamingStrategy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
  private boolean generateNonExecutableJson;
  private final List<TypeAdapterFactory> hierarchyFactories = new ArrayList();
  private final Map<Type, InstanceCreator<?>> instanceCreators = new HashMap();
  private LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
  private boolean prettyPrinting;
  private boolean serializeNulls;
  private boolean serializeSpecialFloatingPointValues;
  private int timeStyle = 2;
  
  private void addTypeAdaptersForDate(String paramString, int paramInt1, int paramInt2, List<TypeAdapterFactory> paramList)
  {
    if ((paramString != null) && (!"".equals(paramString.trim()))) {}
    for (paramString = new DefaultDateTypeAdapter(paramString);; paramString = new DefaultDateTypeAdapter(paramInt1, paramInt2))
    {
      paramList.add(TreeTypeAdapter.newFactory(TypeToken.get(java.util.Date.class), paramString));
      paramList.add(TreeTypeAdapter.newFactory(TypeToken.get(Timestamp.class), paramString));
      paramList.add(TreeTypeAdapter.newFactory(TypeToken.get(java.sql.Date.class), paramString));
      do
      {
        return;
      } while ((paramInt1 == 2) || (paramInt2 == 2));
    }
  }
  
  public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy paramExclusionStrategy)
  {
    excluder = excluder.withExclusionStrategy(paramExclusionStrategy, false, true);
    return this;
  }
  
  public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy paramExclusionStrategy)
  {
    excluder = excluder.withExclusionStrategy(paramExclusionStrategy, true, false);
    return this;
  }
  
  public Gson create()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(factories);
    Collections.reverse(localArrayList);
    localArrayList.addAll(hierarchyFactories);
    addTypeAdaptersForDate(datePattern, dateStyle, timeStyle, localArrayList);
    return new Gson(excluder, fieldNamingPolicy, instanceCreators, serializeNulls, complexMapKeySerialization, generateNonExecutableJson, escapeHtmlChars, prettyPrinting, serializeSpecialFloatingPointValues, longSerializationPolicy, localArrayList);
  }
  
  public GsonBuilder disableHtmlEscaping()
  {
    escapeHtmlChars = false;
    return this;
  }
  
  public GsonBuilder disableInnerClassSerialization()
  {
    excluder = excluder.disableInnerClassSerialization();
    return this;
  }
  
  public GsonBuilder enableComplexMapKeySerialization()
  {
    complexMapKeySerialization = true;
    return this;
  }
  
  public GsonBuilder excludeFieldsWithModifiers(int... paramVarArgs)
  {
    excluder = excluder.withModifiers(paramVarArgs);
    return this;
  }
  
  public GsonBuilder excludeFieldsWithoutExposeAnnotation()
  {
    excluder = excluder.excludeFieldsWithoutExposeAnnotation();
    return this;
  }
  
  public GsonBuilder generateNonExecutableJson()
  {
    generateNonExecutableJson = true;
    return this;
  }
  
  public GsonBuilder registerTypeAdapter(Type paramType, Object paramObject)
  {
    if (((paramObject instanceof JsonSerializer)) || ((paramObject instanceof JsonDeserializer)) || ((paramObject instanceof InstanceCreator)) || ((paramObject instanceof TypeAdapter))) {}
    for (boolean bool = true;; bool = false)
    {
      .Gson.Preconditions.checkArgument(bool);
      if ((paramObject instanceof InstanceCreator)) {
        instanceCreators.put(paramType, (InstanceCreator)paramObject);
      }
      if (((paramObject instanceof JsonSerializer)) || ((paramObject instanceof JsonDeserializer)))
      {
        TypeToken localTypeToken = TypeToken.get(paramType);
        factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(localTypeToken, paramObject));
      }
      if ((paramObject instanceof TypeAdapter)) {
        factories.add(TypeAdapters.newFactory(TypeToken.get(paramType), (TypeAdapter)paramObject));
      }
      return this;
    }
  }
  
  public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory paramTypeAdapterFactory)
  {
    factories.add(paramTypeAdapterFactory);
    return this;
  }
  
  public GsonBuilder registerTypeHierarchyAdapter(Class<?> paramClass, Object paramObject)
  {
    if (((paramObject instanceof JsonSerializer)) || ((paramObject instanceof JsonDeserializer)) || ((paramObject instanceof TypeAdapter))) {}
    for (boolean bool = true;; bool = false)
    {
      .Gson.Preconditions.checkArgument(bool);
      if (((paramObject instanceof JsonDeserializer)) || ((paramObject instanceof JsonSerializer))) {
        hierarchyFactories.add(0, TreeTypeAdapter.newTypeHierarchyFactory(paramClass, paramObject));
      }
      if ((paramObject instanceof TypeAdapter)) {
        factories.add(TypeAdapters.newTypeHierarchyFactory(paramClass, (TypeAdapter)paramObject));
      }
      return this;
    }
  }
  
  public GsonBuilder serializeNulls()
  {
    serializeNulls = true;
    return this;
  }
  
  public GsonBuilder serializeSpecialFloatingPointValues()
  {
    serializeSpecialFloatingPointValues = true;
    return this;
  }
  
  public GsonBuilder setDateFormat(int paramInt)
  {
    dateStyle = paramInt;
    datePattern = null;
    return this;
  }
  
  public GsonBuilder setDateFormat(int paramInt1, int paramInt2)
  {
    dateStyle = paramInt1;
    timeStyle = paramInt2;
    datePattern = null;
    return this;
  }
  
  public GsonBuilder setDateFormat(String paramString)
  {
    datePattern = paramString;
    return this;
  }
  
  public GsonBuilder setExclusionStrategies(ExclusionStrategy... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      ExclusionStrategy localExclusionStrategy = paramVarArgs[i];
      excluder = excluder.withExclusionStrategy(localExclusionStrategy, true, true);
      i += 1;
    }
    return this;
  }
  
  public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy paramFieldNamingPolicy)
  {
    fieldNamingPolicy = paramFieldNamingPolicy;
    return this;
  }
  
  public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy paramFieldNamingStrategy)
  {
    fieldNamingPolicy = paramFieldNamingStrategy;
    return this;
  }
  
  public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy paramLongSerializationPolicy)
  {
    longSerializationPolicy = paramLongSerializationPolicy;
    return this;
  }
  
  public GsonBuilder setPrettyPrinting()
  {
    prettyPrinting = true;
    return this;
  }
  
  public GsonBuilder setVersion(double paramDouble)
  {
    excluder = excluder.withVersion(paramDouble);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.GsonBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */