package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public abstract class PropertyBindingException
  extends JsonMappingException
{
  private static final int MAX_DESC_LENGTH = 1000;
  protected transient String _propertiesAsString;
  protected final Collection<Object> _propertyIds;
  protected final String _propertyName;
  protected final Class<?> _referringClass;
  
  protected PropertyBindingException(String paramString1, JsonLocation paramJsonLocation, Class<?> paramClass, String paramString2, Collection<Object> paramCollection)
  {
    super(paramString1, paramJsonLocation);
    _referringClass = paramClass;
    _propertyName = paramString2;
    _propertyIds = paramCollection;
  }
  
  public Collection<Object> getKnownPropertyIds()
  {
    if (_propertyIds == null) {
      return null;
    }
    return Collections.unmodifiableCollection(_propertyIds);
  }
  
  public String getMessageSuffix()
  {
    Object localObject2 = _propertiesAsString;
    Object localObject1 = localObject2;
    int i;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (_propertyIds != null)
      {
        localObject1 = new StringBuilder(100);
        i = _propertyIds.size();
        if (i != 1) {
          break label100;
        }
        ((StringBuilder)localObject1).append(" (one known property: \"");
        ((StringBuilder)localObject1).append(String.valueOf(_propertyIds.iterator().next()));
        ((StringBuilder)localObject1).append('"');
      }
    }
    label100:
    label200:
    for (;;)
    {
      ((StringBuilder)localObject1).append("])");
      localObject1 = ((StringBuilder)localObject1).toString();
      _propertiesAsString = ((String)localObject1);
      return (String)localObject1;
      ((StringBuilder)localObject1).append(" (").append(i).append(" known properties: ");
      localObject2 = _propertyIds.iterator();
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label200;
        }
        ((StringBuilder)localObject1).append('"');
        ((StringBuilder)localObject1).append(String.valueOf(((Iterator)localObject2).next()));
        ((StringBuilder)localObject1).append('"');
        if (((StringBuilder)localObject1).length() > 1000)
        {
          ((StringBuilder)localObject1).append(" [truncated]");
          break;
        }
        if (((Iterator)localObject2).hasNext()) {
          ((StringBuilder)localObject1).append(", ");
        }
      }
    }
  }
  
  public String getPropertyName()
  {
    return _propertyName;
  }
  
  public Class<?> getReferringClass()
  {
    return _referringClass;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.exc.PropertyBindingException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */