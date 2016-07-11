package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.Module.SetupContext;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SimpleModule
  extends Module
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected SimpleAbstractTypeResolver _abstractTypes = null;
  protected BeanDeserializerModifier _deserializerModifier = null;
  protected SimpleDeserializers _deserializers = null;
  protected SimpleKeyDeserializers _keyDeserializers = null;
  protected SimpleSerializers _keySerializers = null;
  protected HashMap<Class<?>, Class<?>> _mixins = null;
  protected final String _name;
  protected PropertyNamingStrategy _namingStrategy = null;
  protected BeanSerializerModifier _serializerModifier = null;
  protected SimpleSerializers _serializers = null;
  protected LinkedHashSet<NamedType> _subtypes = null;
  protected SimpleValueInstantiators _valueInstantiators = null;
  protected final Version _version;
  
  public SimpleModule()
  {
    if (getClass() == SimpleModule.class) {}
    for (String str = "SimpleModule-" + System.identityHashCode(this);; str = getClass().getName())
    {
      _name = str;
      _version = Version.unknownVersion();
      return;
    }
  }
  
  public SimpleModule(Version paramVersion)
  {
    _name = paramVersion.getArtifactId();
    _version = paramVersion;
  }
  
  public SimpleModule(String paramString)
  {
    this(paramString, Version.unknownVersion());
  }
  
  public SimpleModule(String paramString, Version paramVersion)
  {
    _name = paramString;
    _version = paramVersion;
  }
  
  public SimpleModule(String paramString, Version paramVersion, List<JsonSerializer<?>> paramList)
  {
    this(paramString, paramVersion, null, paramList);
  }
  
  public SimpleModule(String paramString, Version paramVersion, Map<Class<?>, JsonDeserializer<?>> paramMap)
  {
    this(paramString, paramVersion, paramMap, null);
  }
  
  public SimpleModule(String paramString, Version paramVersion, Map<Class<?>, JsonDeserializer<?>> paramMap, List<JsonSerializer<?>> paramList)
  {
    _name = paramString;
    _version = paramVersion;
    if (paramMap != null) {
      _deserializers = new SimpleDeserializers(paramMap);
    }
    if (paramList != null) {
      _serializers = new SimpleSerializers(paramList);
    }
  }
  
  public <T> SimpleModule addAbstractTypeMapping(Class<T> paramClass, Class<? extends T> paramClass1)
  {
    if (_abstractTypes == null) {
      _abstractTypes = new SimpleAbstractTypeResolver();
    }
    _abstractTypes = _abstractTypes.addMapping(paramClass, paramClass1);
    return this;
  }
  
  public <T> SimpleModule addDeserializer(Class<T> paramClass, JsonDeserializer<? extends T> paramJsonDeserializer)
  {
    if (_deserializers == null) {
      _deserializers = new SimpleDeserializers();
    }
    _deserializers.addDeserializer(paramClass, paramJsonDeserializer);
    return this;
  }
  
  public SimpleModule addKeyDeserializer(Class<?> paramClass, KeyDeserializer paramKeyDeserializer)
  {
    if (_keyDeserializers == null) {
      _keyDeserializers = new SimpleKeyDeserializers();
    }
    _keyDeserializers.addDeserializer(paramClass, paramKeyDeserializer);
    return this;
  }
  
  public <T> SimpleModule addKeySerializer(Class<? extends T> paramClass, JsonSerializer<T> paramJsonSerializer)
  {
    if (_keySerializers == null) {
      _keySerializers = new SimpleSerializers();
    }
    _keySerializers.addSerializer(paramClass, paramJsonSerializer);
    return this;
  }
  
  public SimpleModule addSerializer(JsonSerializer<?> paramJsonSerializer)
  {
    if (_serializers == null) {
      _serializers = new SimpleSerializers();
    }
    _serializers.addSerializer(paramJsonSerializer);
    return this;
  }
  
  public <T> SimpleModule addSerializer(Class<? extends T> paramClass, JsonSerializer<T> paramJsonSerializer)
  {
    if (_serializers == null) {
      _serializers = new SimpleSerializers();
    }
    _serializers.addSerializer(paramClass, paramJsonSerializer);
    return this;
  }
  
  public SimpleModule addValueInstantiator(Class<?> paramClass, ValueInstantiator paramValueInstantiator)
  {
    if (_valueInstantiators == null) {
      _valueInstantiators = new SimpleValueInstantiators();
    }
    _valueInstantiators = _valueInstantiators.addValueInstantiator(paramClass, paramValueInstantiator);
    return this;
  }
  
  public String getModuleName()
  {
    return _name;
  }
  
  public Object getTypeId()
  {
    if (getClass() == SimpleModule.class) {
      return null;
    }
    return super.getTypeId();
  }
  
  public SimpleModule registerSubtypes(NamedType... paramVarArgs)
  {
    if (_subtypes == null) {
      _subtypes = new LinkedHashSet(Math.max(16, paramVarArgs.length));
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      NamedType localNamedType = paramVarArgs[i];
      _subtypes.add(localNamedType);
      i += 1;
    }
    return this;
  }
  
  public SimpleModule registerSubtypes(Class<?>... paramVarArgs)
  {
    if (_subtypes == null) {
      _subtypes = new LinkedHashSet(Math.max(16, paramVarArgs.length));
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Class<?> localClass = paramVarArgs[i];
      _subtypes.add(new NamedType(localClass));
      i += 1;
    }
    return this;
  }
  
  public void setAbstractTypes(SimpleAbstractTypeResolver paramSimpleAbstractTypeResolver)
  {
    _abstractTypes = paramSimpleAbstractTypeResolver;
  }
  
  public SimpleModule setDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier)
  {
    _deserializerModifier = paramBeanDeserializerModifier;
    return this;
  }
  
  public void setDeserializers(SimpleDeserializers paramSimpleDeserializers)
  {
    _deserializers = paramSimpleDeserializers;
  }
  
  public void setKeyDeserializers(SimpleKeyDeserializers paramSimpleKeyDeserializers)
  {
    _keyDeserializers = paramSimpleKeyDeserializers;
  }
  
  public void setKeySerializers(SimpleSerializers paramSimpleSerializers)
  {
    _keySerializers = paramSimpleSerializers;
  }
  
  public SimpleModule setMixInAnnotation(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (_mixins == null) {
      _mixins = new HashMap();
    }
    _mixins.put(paramClass1, paramClass2);
    return this;
  }
  
  protected SimpleModule setNamingStrategy(PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    _namingStrategy = paramPropertyNamingStrategy;
    return this;
  }
  
  public SimpleModule setSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier)
  {
    _serializerModifier = paramBeanSerializerModifier;
    return this;
  }
  
  public void setSerializers(SimpleSerializers paramSimpleSerializers)
  {
    _serializers = paramSimpleSerializers;
  }
  
  public void setValueInstantiators(SimpleValueInstantiators paramSimpleValueInstantiators)
  {
    _valueInstantiators = paramSimpleValueInstantiators;
  }
  
  public void setupModule(Module.SetupContext paramSetupContext)
  {
    if (_serializers != null) {
      paramSetupContext.addSerializers(_serializers);
    }
    if (_deserializers != null) {
      paramSetupContext.addDeserializers(_deserializers);
    }
    if (_keySerializers != null) {
      paramSetupContext.addKeySerializers(_keySerializers);
    }
    if (_keyDeserializers != null) {
      paramSetupContext.addKeyDeserializers(_keyDeserializers);
    }
    if (_abstractTypes != null) {
      paramSetupContext.addAbstractTypeResolver(_abstractTypes);
    }
    if (_valueInstantiators != null) {
      paramSetupContext.addValueInstantiators(_valueInstantiators);
    }
    if (_deserializerModifier != null) {
      paramSetupContext.addBeanDeserializerModifier(_deserializerModifier);
    }
    if (_serializerModifier != null) {
      paramSetupContext.addBeanSerializerModifier(_serializerModifier);
    }
    if ((_subtypes != null) && (_subtypes.size() > 0)) {
      paramSetupContext.registerSubtypes((NamedType[])_subtypes.toArray(new NamedType[_subtypes.size()]));
    }
    if (_namingStrategy != null) {
      paramSetupContext.setNamingStrategy(_namingStrategy);
    }
    if (_mixins != null)
    {
      Iterator localIterator = _mixins.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramSetupContext.setMixInAnnotations((Class)localEntry.getKey(), (Class)localEntry.getValue());
      }
    }
  }
  
  public Version version()
  {
    return _version;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.module.SimpleModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */