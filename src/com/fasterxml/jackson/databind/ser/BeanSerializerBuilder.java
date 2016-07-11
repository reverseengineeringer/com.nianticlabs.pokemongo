package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import java.util.List;

public class BeanSerializerBuilder
{
  private static final BeanPropertyWriter[] NO_PROPERTIES = new BeanPropertyWriter[0];
  protected AnyGetterWriter _anyGetter;
  protected final BeanDescription _beanDesc;
  protected SerializationConfig _config;
  protected Object _filterId;
  protected BeanPropertyWriter[] _filteredProperties;
  protected ObjectIdWriter _objectIdWriter;
  protected List<BeanPropertyWriter> _properties;
  protected AnnotatedMember _typeId;
  
  public BeanSerializerBuilder(BeanDescription paramBeanDescription)
  {
    _beanDesc = paramBeanDescription;
  }
  
  protected BeanSerializerBuilder(BeanSerializerBuilder paramBeanSerializerBuilder)
  {
    _beanDesc = _beanDesc;
    _properties = _properties;
    _filteredProperties = _filteredProperties;
    _anyGetter = _anyGetter;
    _filterId = _filterId;
  }
  
  public JsonSerializer<?> build()
  {
    if ((_properties == null) || (_properties.isEmpty())) {
      if ((_anyGetter == null) && (_objectIdWriter == null)) {
        return null;
      }
    }
    for (BeanPropertyWriter[] arrayOfBeanPropertyWriter = NO_PROPERTIES;; arrayOfBeanPropertyWriter = (BeanPropertyWriter[])_properties.toArray(new BeanPropertyWriter[_properties.size()])) {
      return new BeanSerializer(_beanDesc.getType(), this, arrayOfBeanPropertyWriter, _filteredProperties);
    }
  }
  
  public BeanSerializer createDummy()
  {
    return BeanSerializer.createDummy(_beanDesc.getType());
  }
  
  public AnyGetterWriter getAnyGetter()
  {
    return _anyGetter;
  }
  
  public BeanDescription getBeanDescription()
  {
    return _beanDesc;
  }
  
  public AnnotatedClass getClassInfo()
  {
    return _beanDesc.getClassInfo();
  }
  
  public Object getFilterId()
  {
    return _filterId;
  }
  
  public BeanPropertyWriter[] getFilteredProperties()
  {
    return _filteredProperties;
  }
  
  public ObjectIdWriter getObjectIdWriter()
  {
    return _objectIdWriter;
  }
  
  public List<BeanPropertyWriter> getProperties()
  {
    return _properties;
  }
  
  public AnnotatedMember getTypeId()
  {
    return _typeId;
  }
  
  public boolean hasProperties()
  {
    return (_properties != null) && (_properties.size() > 0);
  }
  
  public void setAnyGetter(AnyGetterWriter paramAnyGetterWriter)
  {
    _anyGetter = paramAnyGetterWriter;
  }
  
  protected void setConfig(SerializationConfig paramSerializationConfig)
  {
    _config = paramSerializationConfig;
  }
  
  public void setFilterId(Object paramObject)
  {
    _filterId = paramObject;
  }
  
  public void setFilteredProperties(BeanPropertyWriter[] paramArrayOfBeanPropertyWriter)
  {
    _filteredProperties = paramArrayOfBeanPropertyWriter;
  }
  
  public void setObjectIdWriter(ObjectIdWriter paramObjectIdWriter)
  {
    _objectIdWriter = paramObjectIdWriter;
  }
  
  public void setProperties(List<BeanPropertyWriter> paramList)
  {
    _properties = paramList;
  }
  
  public void setTypeId(AnnotatedMember paramAnnotatedMember)
  {
    if (_typeId != null) {
      throw new IllegalArgumentException("Multiple type ids specified with " + _typeId + " and " + paramAnnotatedMember);
    }
    _typeId = paramAnnotatedMember;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.BeanSerializerBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */