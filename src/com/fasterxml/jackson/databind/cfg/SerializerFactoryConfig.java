package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import java.io.Serializable;

public final class SerializerFactoryConfig
  implements Serializable
{
  protected static final BeanSerializerModifier[] NO_MODIFIERS = new BeanSerializerModifier[0];
  protected static final Serializers[] NO_SERIALIZERS = new Serializers[0];
  private static final long serialVersionUID = 1L;
  protected final Serializers[] _additionalKeySerializers;
  protected final Serializers[] _additionalSerializers;
  protected final BeanSerializerModifier[] _modifiers;
  
  public SerializerFactoryConfig()
  {
    this(null, null, null);
  }
  
  protected SerializerFactoryConfig(Serializers[] paramArrayOfSerializers1, Serializers[] paramArrayOfSerializers2, BeanSerializerModifier[] paramArrayOfBeanSerializerModifier)
  {
    Serializers[] arrayOfSerializers = paramArrayOfSerializers1;
    if (paramArrayOfSerializers1 == null) {
      arrayOfSerializers = NO_SERIALIZERS;
    }
    _additionalSerializers = arrayOfSerializers;
    paramArrayOfSerializers1 = paramArrayOfSerializers2;
    if (paramArrayOfSerializers2 == null) {
      paramArrayOfSerializers1 = NO_SERIALIZERS;
    }
    _additionalKeySerializers = paramArrayOfSerializers1;
    paramArrayOfSerializers1 = paramArrayOfBeanSerializerModifier;
    if (paramArrayOfBeanSerializerModifier == null) {
      paramArrayOfSerializers1 = NO_MODIFIERS;
    }
    _modifiers = paramArrayOfSerializers1;
  }
  
  public boolean hasKeySerializers()
  {
    return _additionalKeySerializers.length > 0;
  }
  
  public boolean hasSerializerModifiers()
  {
    return _modifiers.length > 0;
  }
  
  public boolean hasSerializers()
  {
    return _additionalSerializers.length > 0;
  }
  
  public Iterable<Serializers> keySerializers()
  {
    return new ArrayIterator(_additionalKeySerializers);
  }
  
  public Iterable<BeanSerializerModifier> serializerModifiers()
  {
    return new ArrayIterator(_modifiers);
  }
  
  public Iterable<Serializers> serializers()
  {
    return new ArrayIterator(_additionalSerializers);
  }
  
  public SerializerFactoryConfig withAdditionalKeySerializers(Serializers paramSerializers)
  {
    if (paramSerializers == null) {
      throw new IllegalArgumentException("Can not pass null Serializers");
    }
    paramSerializers = (Serializers[])ArrayBuilders.insertInListNoDup(_additionalKeySerializers, paramSerializers);
    return new SerializerFactoryConfig(_additionalSerializers, paramSerializers, _modifiers);
  }
  
  public SerializerFactoryConfig withAdditionalSerializers(Serializers paramSerializers)
  {
    if (paramSerializers == null) {
      throw new IllegalArgumentException("Can not pass null Serializers");
    }
    return new SerializerFactoryConfig((Serializers[])ArrayBuilders.insertInListNoDup(_additionalSerializers, paramSerializers), _additionalKeySerializers, _modifiers);
  }
  
  public SerializerFactoryConfig withSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier)
  {
    if (paramBeanSerializerModifier == null) {
      throw new IllegalArgumentException("Can not pass null modifier");
    }
    paramBeanSerializerModifier = (BeanSerializerModifier[])ArrayBuilders.insertInListNoDup(_modifiers, paramBeanSerializerModifier);
    return new SerializerFactoryConfig(_additionalSerializers, _additionalKeySerializers, paramBeanSerializerModifier);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */