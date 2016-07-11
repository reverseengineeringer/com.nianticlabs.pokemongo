package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import java.io.Serializable;

public class DeserializerFactoryConfig
  implements Serializable
{
  protected static final KeyDeserializers[] DEFAULT_KEY_DESERIALIZERS = { new StdKeyDeserializers() };
  protected static final AbstractTypeResolver[] NO_ABSTRACT_TYPE_RESOLVERS;
  protected static final Deserializers[] NO_DESERIALIZERS = new Deserializers[0];
  protected static final BeanDeserializerModifier[] NO_MODIFIERS = new BeanDeserializerModifier[0];
  protected static final ValueInstantiators[] NO_VALUE_INSTANTIATORS;
  private static final long serialVersionUID = 1L;
  protected final AbstractTypeResolver[] _abstractTypeResolvers;
  protected final Deserializers[] _additionalDeserializers;
  protected final KeyDeserializers[] _additionalKeyDeserializers;
  protected final BeanDeserializerModifier[] _modifiers;
  protected final ValueInstantiators[] _valueInstantiators;
  
  static
  {
    NO_ABSTRACT_TYPE_RESOLVERS = new AbstractTypeResolver[0];
    NO_VALUE_INSTANTIATORS = new ValueInstantiators[0];
  }
  
  public DeserializerFactoryConfig()
  {
    this(null, null, null, null, null);
  }
  
  protected DeserializerFactoryConfig(Deserializers[] paramArrayOfDeserializers, KeyDeserializers[] paramArrayOfKeyDeserializers, BeanDeserializerModifier[] paramArrayOfBeanDeserializerModifier, AbstractTypeResolver[] paramArrayOfAbstractTypeResolver, ValueInstantiators[] paramArrayOfValueInstantiators)
  {
    Deserializers[] arrayOfDeserializers = paramArrayOfDeserializers;
    if (paramArrayOfDeserializers == null) {
      arrayOfDeserializers = NO_DESERIALIZERS;
    }
    _additionalDeserializers = arrayOfDeserializers;
    paramArrayOfDeserializers = paramArrayOfKeyDeserializers;
    if (paramArrayOfKeyDeserializers == null) {
      paramArrayOfDeserializers = DEFAULT_KEY_DESERIALIZERS;
    }
    _additionalKeyDeserializers = paramArrayOfDeserializers;
    paramArrayOfDeserializers = paramArrayOfBeanDeserializerModifier;
    if (paramArrayOfBeanDeserializerModifier == null) {
      paramArrayOfDeserializers = NO_MODIFIERS;
    }
    _modifiers = paramArrayOfDeserializers;
    paramArrayOfDeserializers = paramArrayOfAbstractTypeResolver;
    if (paramArrayOfAbstractTypeResolver == null) {
      paramArrayOfDeserializers = NO_ABSTRACT_TYPE_RESOLVERS;
    }
    _abstractTypeResolvers = paramArrayOfDeserializers;
    paramArrayOfDeserializers = paramArrayOfValueInstantiators;
    if (paramArrayOfValueInstantiators == null) {
      paramArrayOfDeserializers = NO_VALUE_INSTANTIATORS;
    }
    _valueInstantiators = paramArrayOfDeserializers;
  }
  
  public Iterable<AbstractTypeResolver> abstractTypeResolvers()
  {
    return new ArrayIterator(_abstractTypeResolvers);
  }
  
  public Iterable<BeanDeserializerModifier> deserializerModifiers()
  {
    return new ArrayIterator(_modifiers);
  }
  
  public Iterable<Deserializers> deserializers()
  {
    return new ArrayIterator(_additionalDeserializers);
  }
  
  public boolean hasAbstractTypeResolvers()
  {
    return _abstractTypeResolvers.length > 0;
  }
  
  public boolean hasDeserializerModifiers()
  {
    return _modifiers.length > 0;
  }
  
  public boolean hasDeserializers()
  {
    return _additionalDeserializers.length > 0;
  }
  
  public boolean hasKeyDeserializers()
  {
    return _additionalKeyDeserializers.length > 0;
  }
  
  public boolean hasValueInstantiators()
  {
    return _valueInstantiators.length > 0;
  }
  
  public Iterable<KeyDeserializers> keyDeserializers()
  {
    return new ArrayIterator(_additionalKeyDeserializers);
  }
  
  public Iterable<ValueInstantiators> valueInstantiators()
  {
    return new ArrayIterator(_valueInstantiators);
  }
  
  public DeserializerFactoryConfig withAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver)
  {
    if (paramAbstractTypeResolver == null) {
      throw new IllegalArgumentException("Can not pass null resolver");
    }
    paramAbstractTypeResolver = (AbstractTypeResolver[])ArrayBuilders.insertInListNoDup(_abstractTypeResolvers, paramAbstractTypeResolver);
    return new DeserializerFactoryConfig(_additionalDeserializers, _additionalKeyDeserializers, _modifiers, paramAbstractTypeResolver, _valueInstantiators);
  }
  
  public DeserializerFactoryConfig withAdditionalDeserializers(Deserializers paramDeserializers)
  {
    if (paramDeserializers == null) {
      throw new IllegalArgumentException("Can not pass null Deserializers");
    }
    return new DeserializerFactoryConfig((Deserializers[])ArrayBuilders.insertInListNoDup(_additionalDeserializers, paramDeserializers), _additionalKeyDeserializers, _modifiers, _abstractTypeResolvers, _valueInstantiators);
  }
  
  public DeserializerFactoryConfig withAdditionalKeyDeserializers(KeyDeserializers paramKeyDeserializers)
  {
    if (paramKeyDeserializers == null) {
      throw new IllegalArgumentException("Can not pass null KeyDeserializers");
    }
    paramKeyDeserializers = (KeyDeserializers[])ArrayBuilders.insertInListNoDup(_additionalKeyDeserializers, paramKeyDeserializers);
    return new DeserializerFactoryConfig(_additionalDeserializers, paramKeyDeserializers, _modifiers, _abstractTypeResolvers, _valueInstantiators);
  }
  
  public DeserializerFactoryConfig withDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier)
  {
    if (paramBeanDeserializerModifier == null) {
      throw new IllegalArgumentException("Can not pass null modifier");
    }
    paramBeanDeserializerModifier = (BeanDeserializerModifier[])ArrayBuilders.insertInListNoDup(_modifiers, paramBeanDeserializerModifier);
    return new DeserializerFactoryConfig(_additionalDeserializers, _additionalKeyDeserializers, paramBeanDeserializerModifier, _abstractTypeResolvers, _valueInstantiators);
  }
  
  public DeserializerFactoryConfig withValueInstantiators(ValueInstantiators paramValueInstantiators)
  {
    if (paramValueInstantiators == null) {
      throw new IllegalArgumentException("Can not pass null resolver");
    }
    paramValueInstantiators = (ValueInstantiators[])ArrayBuilders.insertInListNoDup(_valueInstantiators, paramValueInstantiators);
    return new DeserializerFactoryConfig(_additionalDeserializers, _additionalKeyDeserializers, _modifiers, _abstractTypeResolvers, paramValueInstantiators);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */