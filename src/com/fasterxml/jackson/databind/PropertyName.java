package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.io.Serializable;

public class PropertyName
  implements Serializable
{
  public static final PropertyName NO_NAME = new PropertyName(new String(""), null);
  public static final PropertyName USE_DEFAULT = new PropertyName("", null);
  private static final String _NO_NAME = "";
  private static final String _USE_DEFAULT = "";
  private static final long serialVersionUID = 1L;
  protected SerializableString _encodedSimple;
  protected final String _namespace;
  protected final String _simpleName;
  
  public PropertyName(String paramString)
  {
    this(paramString, null);
  }
  
  public PropertyName(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    _simpleName = str;
    _namespace = paramString2;
  }
  
  public static PropertyName construct(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return USE_DEFAULT;
    }
    return new PropertyName(InternCache.instance.intern(paramString), null);
  }
  
  public static PropertyName construct(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    if ((paramString2 == null) && (str.length() == 0)) {
      return USE_DEFAULT;
    }
    return new PropertyName(InternCache.instance.intern(str), paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool3;
        } while (paramObject == null);
        bool1 = bool3;
      } while (paramObject.getClass() != getClass());
      paramObject = (PropertyName)paramObject;
      if (_simpleName != null) {
        break;
      }
      bool1 = bool3;
    } while (_simpleName != null);
    if (_namespace == null)
    {
      if (_namespace == null) {}
      for (bool1 = bool2;; bool1 = false)
      {
        return bool1;
        if (_simpleName.equals(_simpleName)) {
          break;
        }
        return false;
      }
    }
    return _namespace.equals(_namespace);
  }
  
  public String getNamespace()
  {
    return _namespace;
  }
  
  public String getSimpleName()
  {
    return _simpleName;
  }
  
  public boolean hasNamespace()
  {
    return _namespace != null;
  }
  
  public boolean hasSimpleName()
  {
    return _simpleName.length() > 0;
  }
  
  public boolean hasSimpleName(String paramString)
  {
    if (paramString == null) {
      return _simpleName == null;
    }
    return paramString.equals(_simpleName);
  }
  
  public int hashCode()
  {
    if (_namespace == null) {
      return _simpleName.hashCode();
    }
    return _namespace.hashCode() ^ _simpleName.hashCode();
  }
  
  public PropertyName internSimpleName()
  {
    if (_simpleName.length() == 0) {}
    String str;
    do
    {
      return this;
      str = InternCache.instance.intern(_simpleName);
    } while (str == _simpleName);
    return new PropertyName(str, _namespace);
  }
  
  public boolean isEmpty()
  {
    return (_namespace == null) && (_simpleName.isEmpty());
  }
  
  protected Object readResolve()
  {
    PropertyName localPropertyName;
    if ((_simpleName == null) || ("".equals(_simpleName))) {
      localPropertyName = USE_DEFAULT;
    }
    do
    {
      do
      {
        return localPropertyName;
        localPropertyName = this;
      } while (!_simpleName.equals(""));
      localPropertyName = this;
    } while (_namespace != null);
    return NO_NAME;
  }
  
  public SerializableString simpleAsEncoded(MapperConfig<?> paramMapperConfig)
  {
    SerializableString localSerializableString = _encodedSimple;
    Object localObject = localSerializableString;
    if (localSerializableString == null) {
      if (paramMapperConfig != null) {
        break label36;
      }
    }
    label36:
    for (paramMapperConfig = new SerializedString(_simpleName);; paramMapperConfig = paramMapperConfig.compileString(_simpleName))
    {
      _encodedSimple = paramMapperConfig;
      localObject = paramMapperConfig;
      return (SerializableString)localObject;
    }
  }
  
  public String toString()
  {
    if (_namespace == null) {
      return _simpleName;
    }
    return "{" + _namespace + "}" + _simpleName;
  }
  
  public PropertyName withNamespace(String paramString)
  {
    if (paramString == null)
    {
      if (_namespace != null) {}
    }
    else {
      while (paramString.equals(_namespace)) {
        return this;
      }
    }
    return new PropertyName(_simpleName, paramString);
  }
  
  public PropertyName withSimpleName(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (str.equals(_simpleName)) {
      return this;
    }
    return new PropertyName(str, _namespace);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.PropertyName
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */