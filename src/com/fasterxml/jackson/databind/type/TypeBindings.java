package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class TypeBindings
{
  private static final JavaType[] NO_TYPES = new JavaType[0];
  public static final JavaType UNBOUND = new SimpleType(Object.class);
  protected Map<String, JavaType> _bindings;
  protected final Class<?> _contextClass;
  protected final JavaType _contextType;
  private final TypeBindings _parentBindings;
  protected HashSet<String> _placeholders;
  protected final TypeFactory _typeFactory;
  
  public TypeBindings(TypeFactory paramTypeFactory, JavaType paramJavaType)
  {
    this(paramTypeFactory, null, paramJavaType.getRawClass(), paramJavaType);
  }
  
  private TypeBindings(TypeFactory paramTypeFactory, TypeBindings paramTypeBindings, Class<?> paramClass, JavaType paramJavaType)
  {
    _typeFactory = paramTypeFactory;
    _parentBindings = paramTypeBindings;
    _contextClass = paramClass;
    _contextType = paramJavaType;
  }
  
  public TypeBindings(TypeFactory paramTypeFactory, Class<?> paramClass)
  {
    this(paramTypeFactory, null, paramClass, null);
  }
  
  public void _addPlaceholder(String paramString)
  {
    if (_placeholders == null) {
      _placeholders = new HashSet();
    }
    _placeholders.add(paramString);
  }
  
  protected void _resolve()
  {
    _resolveBindings(_contextClass);
    if (_contextType != null)
    {
      int j = _contextType.containedTypeCount();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          addBinding(_contextType.containedTypeName(i), _contextType.containedType(i));
          i += 1;
        }
      }
    }
    if (_bindings == null) {
      _bindings = Collections.emptyMap();
    }
  }
  
  protected void _resolveBindings(Type paramType)
  {
    if (paramType == null) {
      return;
    }
    Object localObject3;
    Object localObject2;
    int i;
    int j;
    if ((paramType instanceof ParameterizedType))
    {
      paramType = (ParameterizedType)paramType;
      localObject1 = paramType.getActualTypeArguments();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject3 = (Class)paramType.getRawType();
        localObject2 = ((Class)localObject3).getTypeParameters();
        if (localObject2.length != localObject1.length) {
          throw new IllegalArgumentException("Strange parametrized type (in class " + ((Class)localObject3).getName() + "): number of type arguments != number of type parameters (" + localObject1.length + " vs " + localObject2.length + ")");
        }
        i = 0;
        j = localObject1.length;
        if (i < j)
        {
          localObject3 = localObject2[i].getName();
          if (_bindings == null)
          {
            _bindings = new LinkedHashMap();
            label161:
            _addPlaceholder((String)localObject3);
            _bindings.put(localObject3, _typeFactory._constructType(localObject1[i], this));
          }
          for (;;)
          {
            i += 1;
            break;
            if (!_bindings.containsKey(localObject3)) {
              break label161;
            }
          }
        }
      }
      localObject1 = (Class)paramType.getRawType();
    }
    do
    {
      do
      {
        do
        {
          _resolveBindings(((Class)localObject1).getGenericSuperclass());
          paramType = ((Class)localObject1).getGenericInterfaces();
          j = paramType.length;
          i = 0;
          while (i < j)
          {
            _resolveBindings(paramType[i]);
            i += 1;
          }
          break;
          if (!(paramType instanceof Class)) {
            break;
          }
          localObject2 = (Class)paramType;
          paramType = ((Class)localObject2).getDeclaringClass();
          if ((paramType != null) && (!paramType.isAssignableFrom((Class)localObject2))) {
            _resolveBindings(((Class)localObject2).getDeclaringClass());
          }
          localObject3 = ((Class)localObject2).getTypeParameters();
          localObject1 = localObject2;
        } while (localObject3 == null);
        localObject1 = localObject2;
      } while (localObject3.length <= 0);
      localObject1 = null;
      paramType = (Type)localObject1;
      if (_contextType != null)
      {
        paramType = (Type)localObject1;
        if (((Class)localObject2).isAssignableFrom(_contextType.getRawClass())) {
          paramType = _typeFactory.findTypeParameters(_contextType, (Class)localObject2);
        }
      }
      i = 0;
      localObject1 = localObject2;
    } while (i >= localObject3.length);
    Type localType = localObject3[i];
    Object localObject1 = localType.getName();
    localType = localType.getBounds()[0];
    if (localType != null)
    {
      if (_bindings != null) {
        break label477;
      }
      _bindings = new LinkedHashMap();
      label439:
      _addPlaceholder((String)localObject1);
      if ((paramType == null) || (paramType.length <= i)) {
        break label494;
      }
      _bindings.put(localObject1, paramType[i]);
    }
    for (;;)
    {
      i += 1;
      break;
      label477:
      if (!_bindings.containsKey(localObject1)) {
        break label439;
      }
      continue;
      label494:
      _bindings.put(localObject1, _typeFactory._constructType(localType, this));
    }
  }
  
  public void addBinding(String paramString, JavaType paramJavaType)
  {
    if ((_bindings == null) || (_bindings.size() == 0)) {
      _bindings = new LinkedHashMap();
    }
    _bindings.put(paramString, paramJavaType);
  }
  
  public TypeBindings childInstance()
  {
    return new TypeBindings(_typeFactory, this, _contextClass, _contextType);
  }
  
  @Deprecated
  public JavaType findType(String paramString)
  {
    return findType(paramString, true);
  }
  
  public JavaType findType(String paramString, boolean paramBoolean)
  {
    if (_bindings == null) {
      _resolve();
    }
    Object localObject = (JavaType)_bindings.get(paramString);
    if (localObject != null) {
      return (JavaType)localObject;
    }
    if ((_placeholders != null) && (_placeholders.contains(paramString))) {
      return UNBOUND;
    }
    if (_parentBindings != null) {
      return _parentBindings.findType(paramString);
    }
    if ((_contextClass != null) && (_contextClass.getEnclosingClass() != null) && (!Modifier.isStatic(_contextClass.getModifiers()))) {
      return UNBOUND;
    }
    if (!paramBoolean) {
      return null;
    }
    if (_contextClass != null) {
      localObject = _contextClass.getName();
    }
    for (;;)
    {
      throw new IllegalArgumentException("Type variable '" + paramString + "' can not be resolved (with context of class " + (String)localObject + ")");
      if (_contextType != null) {
        localObject = _contextType.toString();
      } else {
        localObject = "UNKNOWN";
      }
    }
  }
  
  public int getBindingCount()
  {
    if (_bindings == null) {
      _resolve();
    }
    return _bindings.size();
  }
  
  public JavaType resolveType(Class<?> paramClass)
  {
    return _typeFactory._constructType(paramClass, this);
  }
  
  public JavaType resolveType(Type paramType)
  {
    return _typeFactory._constructType(paramType, this);
  }
  
  public String toString()
  {
    if (_bindings == null) {
      _resolve();
    }
    StringBuilder localStringBuilder = new StringBuilder("[TypeBindings for ");
    if (_contextType != null) {
      localStringBuilder.append(_contextType.toString());
    }
    for (;;)
    {
      localStringBuilder.append(": ").append(_bindings).append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(_contextClass.getName());
    }
  }
  
  public JavaType[] typesAsArray()
  {
    if (_bindings == null) {
      _resolve();
    }
    if (_bindings.size() == 0) {
      return NO_TYPES;
    }
    return (JavaType[])_bindings.values().toArray(new JavaType[_bindings.size()]);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.type.TypeBindings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */