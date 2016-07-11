package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Excluder
  implements TypeAdapterFactory, Cloneable
{
  public static final Excluder DEFAULT = new Excluder();
  private static final double IGNORE_VERSIONS = -1.0D;
  private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();
  private int modifiers = 136;
  private boolean requireExpose;
  private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
  private boolean serializeInnerClasses = true;
  private double version = -1.0D;
  
  private boolean isAnonymousOrLocal(Class<?> paramClass)
  {
    return (!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()));
  }
  
  private boolean isInnerClass(Class<?> paramClass)
  {
    return (paramClass.isMemberClass()) && (!isStatic(paramClass));
  }
  
  private boolean isStatic(Class<?> paramClass)
  {
    return (paramClass.getModifiers() & 0x8) != 0;
  }
  
  private boolean isValidSince(Since paramSince)
  {
    return (paramSince == null) || (paramSince.value() <= version);
  }
  
  private boolean isValidUntil(Until paramUntil)
  {
    return (paramUntil == null) || (paramUntil.value() > version);
  }
  
  private boolean isValidVersion(Since paramSince, Until paramUntil)
  {
    return (isValidSince(paramSince)) && (isValidUntil(paramUntil));
  }
  
  protected Excluder clone()
  {
    try
    {
      Excluder localExcluder = (Excluder)super.clone();
      return localExcluder;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  public <T> TypeAdapter<T> create(final Gson paramGson, final TypeToken<T> paramTypeToken)
  {
    Class localClass = paramTypeToken.getRawType();
    final boolean bool1 = excludeClass(localClass, true);
    final boolean bool2 = excludeClass(localClass, false);
    if ((!bool1) && (!bool2)) {
      return null;
    }
    new TypeAdapter()
    {
      private TypeAdapter<T> delegate;
      
      private TypeAdapter<T> delegate()
      {
        TypeAdapter localTypeAdapter = delegate;
        if (localTypeAdapter != null) {
          return localTypeAdapter;
        }
        localTypeAdapter = paramGson.getDelegateAdapter(Excluder.this, paramTypeToken);
        delegate = localTypeAdapter;
        return localTypeAdapter;
      }
      
      public T read(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (bool2)
        {
          paramAnonymousJsonReader.skipValue();
          return null;
        }
        return (T)delegate().read(paramAnonymousJsonReader);
      }
      
      public void write(JsonWriter paramAnonymousJsonWriter, T paramAnonymousT)
        throws IOException
      {
        if (bool1)
        {
          paramAnonymousJsonWriter.nullValue();
          return;
        }
        delegate().write(paramAnonymousJsonWriter, paramAnonymousT);
      }
    };
  }
  
  public Excluder disableInnerClassSerialization()
  {
    Excluder localExcluder = clone();
    serializeInnerClasses = false;
    return localExcluder;
  }
  
  public boolean excludeClass(Class<?> paramClass, boolean paramBoolean)
  {
    if ((version != -1.0D) && (!isValidVersion((Since)paramClass.getAnnotation(Since.class), (Until)paramClass.getAnnotation(Until.class)))) {
      return true;
    }
    if ((!serializeInnerClasses) && (isInnerClass(paramClass))) {
      return true;
    }
    if (isAnonymousOrLocal(paramClass)) {
      return true;
    }
    if (paramBoolean) {}
    for (Object localObject = serializationStrategies;; localObject = deserializationStrategies)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ExclusionStrategy)((Iterator)localObject).next()).shouldSkipClass(paramClass));
      return true;
    }
    return false;
  }
  
  public boolean excludeField(Field paramField, boolean paramBoolean)
  {
    if ((modifiers & paramField.getModifiers()) != 0) {
      return true;
    }
    if ((version != -1.0D) && (!isValidVersion((Since)paramField.getAnnotation(Since.class), (Until)paramField.getAnnotation(Until.class)))) {
      return true;
    }
    if (paramField.isSynthetic()) {
      return true;
    }
    if (requireExpose)
    {
      localObject = (Expose)paramField.getAnnotation(Expose.class);
      if (localObject != null)
      {
        if (!paramBoolean) {
          break label97;
        }
        if (((Expose)localObject).serialize()) {
          break label106;
        }
      }
      label97:
      while (!((Expose)localObject).deserialize()) {
        return true;
      }
    }
    label106:
    if ((!serializeInnerClasses) && (isInnerClass(paramField.getType()))) {
      return true;
    }
    if (isAnonymousOrLocal(paramField.getType())) {
      return true;
    }
    if (paramBoolean) {}
    for (Object localObject = serializationStrategies; !((List)localObject).isEmpty(); localObject = deserializationStrategies)
    {
      paramField = new FieldAttributes(paramField);
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ExclusionStrategy)((Iterator)localObject).next()).shouldSkipField(paramField));
      return true;
    }
    return false;
  }
  
  public Excluder excludeFieldsWithoutExposeAnnotation()
  {
    Excluder localExcluder = clone();
    requireExpose = true;
    return localExcluder;
  }
  
  public Excluder withExclusionStrategy(ExclusionStrategy paramExclusionStrategy, boolean paramBoolean1, boolean paramBoolean2)
  {
    Excluder localExcluder = clone();
    if (paramBoolean1)
    {
      serializationStrategies = new ArrayList(serializationStrategies);
      serializationStrategies.add(paramExclusionStrategy);
    }
    if (paramBoolean2)
    {
      deserializationStrategies = new ArrayList(deserializationStrategies);
      deserializationStrategies.add(paramExclusionStrategy);
    }
    return localExcluder;
  }
  
  public Excluder withModifiers(int... paramVarArgs)
  {
    Excluder localExcluder = clone();
    modifiers = 0;
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      int k = paramVarArgs[i];
      modifiers |= k;
      i += 1;
    }
    return localExcluder;
  }
  
  public Excluder withVersion(double paramDouble)
  {
    Excluder localExcluder = clone();
    version = paramDouble;
    return localExcluder;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.Excluder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */