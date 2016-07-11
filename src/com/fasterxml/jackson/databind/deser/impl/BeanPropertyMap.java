package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BeanPropertyMap
  implements Iterable<SettableBeanProperty>, Serializable
{
  private static final long serialVersionUID = 2L;
  protected final boolean _caseInsensitive;
  private Object[] _hashArea;
  private int _hashMask;
  private SettableBeanProperty[] _propsInOrder;
  private int _size;
  private int _spillCount;
  
  public BeanPropertyMap(boolean paramBoolean, Collection<SettableBeanProperty> paramCollection)
  {
    _caseInsensitive = paramBoolean;
    _propsInOrder = ((SettableBeanProperty[])paramCollection.toArray(new SettableBeanProperty[paramCollection.size()]));
    init(paramCollection);
  }
  
  private final SettableBeanProperty _find2(String paramString, int paramInt, Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return null;
      int i = _hashMask + 1;
      paramInt = (paramInt >> 1) + i << 1;
      paramObject = _hashArea[paramInt];
      if (paramString.equals(paramObject)) {
        return (SettableBeanProperty)_hashArea[(paramInt + 1)];
      }
      if (paramObject != null)
      {
        i = (i >> 1) + i << 1;
        int j = _spillCount;
        paramInt = i;
        while (paramInt < i + j)
        {
          paramObject = _hashArea[paramInt];
          if ((paramObject == paramString) || (paramString.equals(paramObject))) {
            return (SettableBeanProperty)_hashArea[(paramInt + 1)];
          }
          paramInt += 2;
        }
      }
    }
  }
  
  private int _findFromOrdered(SettableBeanProperty paramSettableBeanProperty)
  {
    int i = 0;
    int j = _propsInOrder.length;
    while (i < j)
    {
      if (_propsInOrder[i] == paramSettableBeanProperty) {
        return i;
      }
      i += 1;
    }
    throw new IllegalStateException("Illegal state: property '" + paramSettableBeanProperty.getName() + "' missing from _propsInOrder");
  }
  
  private final int _hashCode(String paramString)
  {
    return paramString.hashCode() & _hashMask;
  }
  
  public static BeanPropertyMap construct(Collection<SettableBeanProperty> paramCollection, boolean paramBoolean)
  {
    return new BeanPropertyMap(paramBoolean, paramCollection);
  }
  
  private static final int findSize(int paramInt)
  {
    int j;
    if (paramInt <= 5)
    {
      j = 8;
      return j;
    }
    if (paramInt <= 12) {
      return 16;
    }
    int i = 32;
    for (;;)
    {
      j = i;
      if (i >= paramInt + (paramInt >> 2)) {
        break;
      }
      i += i;
    }
  }
  
  private List<SettableBeanProperty> properties()
  {
    ArrayList localArrayList = new ArrayList(_size);
    int i = 1;
    int j = _hashArea.length;
    while (i < j)
    {
      SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)_hashArea[i];
      if (localSettableBeanProperty != null) {
        localArrayList.add(localSettableBeanProperty);
      }
      i += 2;
    }
    return localArrayList;
  }
  
  protected SettableBeanProperty _rename(SettableBeanProperty paramSettableBeanProperty, NameTransformer paramNameTransformer)
  {
    if (paramSettableBeanProperty == null) {
      return paramSettableBeanProperty;
    }
    SettableBeanProperty localSettableBeanProperty = paramSettableBeanProperty.withSimpleName(paramNameTransformer.transform(paramSettableBeanProperty.getName()));
    JsonDeserializer localJsonDeserializer = localSettableBeanProperty.getValueDeserializer();
    paramSettableBeanProperty = localSettableBeanProperty;
    if (localJsonDeserializer != null)
    {
      paramNameTransformer = localJsonDeserializer.unwrappingDeserializer(paramNameTransformer);
      paramSettableBeanProperty = localSettableBeanProperty;
      if (paramNameTransformer != localJsonDeserializer) {
        paramSettableBeanProperty = localSettableBeanProperty.withValueDeserializer(paramNameTransformer);
      }
    }
    return paramSettableBeanProperty;
  }
  
  public BeanPropertyMap assignIndexes()
  {
    int j = 1;
    int m = _hashArea.length;
    int i = 0;
    if (j < m)
    {
      SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)_hashArea[j];
      if (localSettableBeanProperty == null) {
        break label54;
      }
      int k = i + 1;
      localSettableBeanProperty.assignIndex(i);
      i = k;
    }
    label54:
    for (;;)
    {
      j += 2;
      break;
      return this;
    }
  }
  
  public SettableBeanProperty find(int paramInt)
  {
    int i = 1;
    int j = _hashArea.length;
    while (i < j)
    {
      SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)_hashArea[i];
      if ((localSettableBeanProperty != null) && (paramInt == localSettableBeanProperty.getPropertyIndex())) {
        return localSettableBeanProperty;
      }
      i += 2;
    }
    return null;
  }
  
  public SettableBeanProperty find(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Can not pass null property name");
    }
    String str = paramString;
    if (_caseInsensitive) {
      str = paramString.toLowerCase();
    }
    int i = str.hashCode() & _hashMask;
    int j = i << 1;
    paramString = _hashArea[j];
    if ((paramString == str) || (str.equals(paramString))) {
      return (SettableBeanProperty)_hashArea[(j + 1)];
    }
    return _find2(str, i, paramString);
  }
  
  public boolean findDeserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
    throws IOException
  {
    SettableBeanProperty localSettableBeanProperty = find(paramString);
    if (localSettableBeanProperty == null) {
      return false;
    }
    try
    {
      localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
      return true;
    }
    catch (Exception paramJsonParser)
    {
      for (;;)
      {
        wrapAndThrow(paramJsonParser, paramObject, paramString, paramDeserializationContext);
      }
    }
  }
  
  public SettableBeanProperty[] getPropertiesInInsertionOrder()
  {
    return _propsInOrder;
  }
  
  protected final String getPropertyName(SettableBeanProperty paramSettableBeanProperty)
  {
    if (_caseInsensitive) {
      return paramSettableBeanProperty.getName().toLowerCase();
    }
    return paramSettableBeanProperty.getName();
  }
  
  protected void init(Collection<SettableBeanProperty> paramCollection)
  {
    _size = paramCollection.size();
    int n = findSize(_size);
    _hashMask = (n - 1);
    Object localObject = new Object[((n >> 1) + n) * 2];
    int k = 0;
    Iterator localIterator = paramCollection.iterator();
    paramCollection = (Collection<SettableBeanProperty>)localObject;
    while (localIterator.hasNext())
    {
      SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)localIterator.next();
      if (localSettableBeanProperty != null)
      {
        String str = getPropertyName(localSettableBeanProperty);
        int i1 = _hashCode(str);
        int m = i1 << 1;
        localObject = paramCollection;
        int i = m;
        int j = k;
        if (paramCollection[m] != null)
        {
          m = (i1 >> 1) + n << 1;
          localObject = paramCollection;
          i = m;
          j = k;
          if (paramCollection[m] != null)
          {
            m = ((n >> 1) + n << 1) + k;
            k += 2;
            localObject = paramCollection;
            i = m;
            j = k;
            if (m >= paramCollection.length)
            {
              localObject = Arrays.copyOf(paramCollection, paramCollection.length + 4);
              j = k;
              i = m;
            }
          }
        }
        localObject[i] = str;
        localObject[(i + 1)] = localSettableBeanProperty;
        paramCollection = (Collection<SettableBeanProperty>)localObject;
        k = j;
      }
    }
    _hashArea = paramCollection;
    _spillCount = k;
  }
  
  public Iterator<SettableBeanProperty> iterator()
  {
    return properties().iterator();
  }
  
  public void remove(SettableBeanProperty paramSettableBeanProperty)
  {
    ArrayList localArrayList = new ArrayList(_size);
    String str = getPropertyName(paramSettableBeanProperty);
    boolean bool2 = false;
    int i = 1;
    int j = _hashArea.length;
    if (i < j)
    {
      SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)_hashArea[i];
      boolean bool1;
      if (localSettableBeanProperty == null) {
        bool1 = bool2;
      }
      for (;;)
      {
        i += 2;
        bool2 = bool1;
        break;
        bool1 = bool2;
        if (!bool2)
        {
          bool2 = str.equals(localSettableBeanProperty.getName());
          bool1 = bool2;
          if (bool2)
          {
            _propsInOrder[_findFromOrdered(localSettableBeanProperty)] = null;
            bool1 = bool2;
            continue;
          }
        }
        localArrayList.add(localSettableBeanProperty);
      }
    }
    if (!bool2) {
      throw new NoSuchElementException("No entry '" + paramSettableBeanProperty.getName() + "' found, can't remove");
    }
    init(localArrayList);
  }
  
  public BeanPropertyMap renameAll(NameTransformer paramNameTransformer)
  {
    if ((paramNameTransformer == null) || (paramNameTransformer == NameTransformer.NOP)) {
      return this;
    }
    int j = _propsInOrder.length;
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    if (i < j)
    {
      SettableBeanProperty localSettableBeanProperty = _propsInOrder[i];
      if (localSettableBeanProperty == null) {
        localArrayList.add(localSettableBeanProperty);
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(_rename(localSettableBeanProperty, paramNameTransformer));
      }
    }
    return new BeanPropertyMap(_caseInsensitive, localArrayList);
  }
  
  public void replace(SettableBeanProperty paramSettableBeanProperty)
  {
    String str = getPropertyName(paramSettableBeanProperty);
    int i = 1;
    int j = _hashArea.length;
    while (i < j)
    {
      SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)_hashArea[i];
      if ((localSettableBeanProperty != null) && (localSettableBeanProperty.getName().equals(str)))
      {
        _hashArea[i] = paramSettableBeanProperty;
        _propsInOrder[_findFromOrdered(localSettableBeanProperty)] = paramSettableBeanProperty;
        return;
      }
      i += 2;
    }
    throw new NoSuchElementException("No entry '" + paramSettableBeanProperty.getName() + "' found, can't replace");
  }
  
  public int size()
  {
    return _size;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Properties=[");
    int i = 0;
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)localIterator.next();
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(localSettableBeanProperty.getName());
      localStringBuilder.append('(');
      localStringBuilder.append(localSettableBeanProperty.getType());
      localStringBuilder.append(')');
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public BeanPropertyMap withProperty(SettableBeanProperty paramSettableBeanProperty)
  {
    String str = getPropertyName(paramSettableBeanProperty);
    int i = 1;
    int j = _hashArea.length;
    while (i < j)
    {
      SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)_hashArea[i];
      if ((localSettableBeanProperty != null) && (localSettableBeanProperty.getName().equals(str)))
      {
        _hashArea[i] = paramSettableBeanProperty;
        _propsInOrder[_findFromOrdered(localSettableBeanProperty)] = paramSettableBeanProperty;
        return this;
      }
      i += 2;
    }
    int m = _hashCode(str);
    int k = _hashMask + 1;
    j = m << 1;
    i = j;
    if (_hashArea[j] != null)
    {
      j = (m >> 1) + k << 1;
      i = j;
      if (_hashArea[j] != null)
      {
        j = ((k >> 1) + k << 1) + _spillCount;
        _spillCount += 2;
        i = j;
        if (j >= _hashArea.length)
        {
          _hashArea = Arrays.copyOf(_hashArea, _hashArea.length + 4);
          i = j;
        }
      }
    }
    _hashArea[i] = str;
    _hashArea[(i + 1)] = paramSettableBeanProperty;
    i = _propsInOrder.length;
    _propsInOrder = ((SettableBeanProperty[])Arrays.copyOf(_propsInOrder, i + 1));
    _propsInOrder[i] = paramSettableBeanProperty;
    return this;
  }
  
  protected void wrapAndThrow(Throwable paramThrowable, Object paramObject, String paramString, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramDeserializationContext == null) || (paramDeserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS))) {}
    for (int i = 1; (paramThrowable instanceof IOException); i = 0)
    {
      if ((i != 0) && ((paramThrowable instanceof JsonProcessingException))) {
        break label100;
      }
      throw ((IOException)paramThrowable);
    }
    if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    label100:
    throw JsonMappingException.wrapWithPath(paramThrowable, paramObject, paramString);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */