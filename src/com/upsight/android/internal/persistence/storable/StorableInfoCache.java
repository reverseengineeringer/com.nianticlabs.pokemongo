package com.upsight.android.internal.persistence.storable;

import android.text.TextUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.UpsightException;
import com.upsight.android.persistence.UpsightStorableSerializer;
import com.upsight.android.persistence.annotation.UpsightStorableIdentifier;
import com.upsight.android.persistence.annotation.UpsightStorableType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

public final class StorableInfoCache
{
  private final ConcurrentHashMap<Class<?>, StorableIdentifierAccessor> mAccessorMap = new ConcurrentHashMap();
  private final ConcurrentHashMap<Class<?>, StorableInfo<?>> mInfoMap = new ConcurrentHashMap();
  private final ObjectMapper mObjectMapper;
  private final ConcurrentHashMap<Class<?>, UpsightStorableSerializer<?>> mSerializerMap = new ConcurrentHashMap();
  
  StorableInfoCache(ObjectMapper paramObjectMapper)
  {
    mObjectMapper = paramObjectMapper;
  }
  
  private StorableIdentifierAccessor resolveIdentifierAccessor(Class<?> paramClass)
    throws UpsightException
  {
    Object localObject1 = (StorableIdentifierAccessor)mAccessorMap.get(paramClass);
    if (localObject1 != null) {
      return (StorableIdentifierAccessor)localObject1;
    }
    Object localObject2 = paramClass;
    while ((localObject1 == null) && (localObject2 != null))
    {
      Field[] arrayOfField = ((Class)localObject2).getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      Object localObject3;
      for (;;)
      {
        localObject3 = localObject1;
        if (i >= j) {
          break label106;
        }
        localObject3 = arrayOfField[i];
        if ((UpsightStorableIdentifier)((Field)localObject3).getAnnotation(UpsightStorableIdentifier.class) != null) {
          break;
        }
        i += 1;
      }
      if (((Field)localObject3).getType().equals(String.class))
      {
        localObject3 = new StorableFieldIdentifierAccessor((Field)localObject3);
        label106:
        localObject2 = ((Class)localObject2).getSuperclass();
        localObject1 = localObject3;
      }
      else
      {
        throw new UpsightException("Field annotated with @%s must be of type String.", new Object[] { UpsightStorableIdentifier.class.getSimpleName() });
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new StorableIdentifierNoopAccessor();
    }
    mAccessorMap.put(paramClass, localObject2);
    return (StorableIdentifierAccessor)localObject2;
  }
  
  private <T> UpsightStorableSerializer<T> resolveSerializer(Class<T> paramClass)
  {
    UpsightStorableSerializer localUpsightStorableSerializer = (UpsightStorableSerializer)mSerializerMap.get(paramClass);
    Object localObject = localUpsightStorableSerializer;
    if (localUpsightStorableSerializer == null)
    {
      localObject = new DefaultJsonSerializer(mObjectMapper, paramClass);
      mSerializerMap.put(paramClass, localObject);
    }
    return (UpsightStorableSerializer<T>)localObject;
  }
  
  private <T> StorableTypeAccessor<T> resolveType(Class<T> paramClass)
    throws UpsightException
  {
    Object localObject1 = null;
    Object localObject2 = (UpsightStorableType)paramClass.getAnnotation(UpsightStorableType.class);
    if (localObject2 != null)
    {
      if (TextUtils.isEmpty(((UpsightStorableType)localObject2).value())) {
        throw new UpsightException("Class annotated with @%s must define non empty value.", new Object[] { UpsightStorableType.class.getSimpleName() });
      }
      localObject1 = new StorableStaticTypeAccessor(((UpsightStorableType)localObject2).value());
    }
    localObject2 = paramClass.getDeclaredMethods();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = localObject2[i];
      UpsightStorableType localUpsightStorableType = (UpsightStorableType)localMethod.getAnnotation(UpsightStorableType.class);
      paramClass = (Class<T>)localObject1;
      if (localUpsightStorableType != null)
      {
        if (!localMethod.getReturnType().equals(String.class)) {
          throw new UpsightException("Method annotated with @%s must return empty.", new Object[] { UpsightStorableType.class });
        }
        if (localMethod.getParameterTypes().length > 0) {
          throw new UpsightException("Method annotated with @%s must have no parameters.", new Object[] { UpsightStorableType.class });
        }
        if (localObject1 != null) {
          throw new UpsightException("@%s can only be defined once in class.", new Object[] { UpsightStorableType.class.getSimpleName() });
        }
        if (!TextUtils.isEmpty(localUpsightStorableType.value())) {
          throw new UpsightException("Method annotated with @%s should not define type in annotation but return it.", new Object[] { UpsightStorableType.class.getSimpleName() });
        }
        if (!Modifier.isPublic(localMethod.getModifiers())) {
          throw new UpsightException("Method annotated with @%s must be public.", new Object[] { UpsightStorableType.class.getSimpleName() });
        }
        paramClass = new StorableMethodTypeAccessor(localMethod);
      }
      i += 1;
      localObject1 = paramClass;
    }
    if (localObject1 == null) {
      throw new UpsightException("Class must either be annotated or have method annotated with %s.", new Object[] { UpsightStorableType.class.getSimpleName() });
    }
    return (StorableTypeAccessor<T>)localObject1;
  }
  
  public <T> StorableInfo<T> get(Class<T> paramClass)
    throws UpsightException
  {
    if (paramClass == null) {
      throw new IllegalArgumentException("Class can not be null.");
    }
    StorableInfo localStorableInfo = (StorableInfo)mInfoMap.get(paramClass);
    Object localObject = localStorableInfo;
    if (localStorableInfo == null)
    {
      localObject = resolveSerializer(paramClass);
      StorableTypeAccessor localStorableTypeAccessor = resolveType(paramClass);
      localStorableInfo = new StorableInfo(localStorableTypeAccessor, (UpsightStorableSerializer)localObject, resolveIdentifierAccessor(paramClass));
      localObject = localStorableInfo;
      if (!localStorableTypeAccessor.isDynamic())
      {
        mInfoMap.put(paramClass, localStorableInfo);
        localObject = localStorableInfo;
      }
    }
    return (StorableInfo<T>)localObject;
  }
  
  public <T> void setSerializer(Class<T> paramClass, UpsightStorableSerializer<T> paramUpsightStorableSerializer)
  {
    mSerializerMap.put(paramClass, paramUpsightStorableSerializer);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.StorableInfoCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */