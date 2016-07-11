package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.annotation.NoClass;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ClassUtil
{
  private static void _addSuperTypes(Class<?> paramClass1, Class<?> paramClass2, Collection<Class<?>> paramCollection, boolean paramBoolean)
  {
    if ((paramClass1 == paramClass2) || (paramClass1 == null) || (paramClass1 == Object.class)) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
    } while (paramCollection.contains(paramClass1));
    paramCollection.add(paramClass1);
    Class[] arrayOfClass = paramClass1.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      _addSuperTypes(arrayOfClass[i], paramClass2, paramCollection, true);
      i += 1;
    }
    _addSuperTypes(paramClass1.getSuperclass(), paramClass2, paramCollection, true);
  }
  
  public static String canBeABeanType(Class<?> paramClass)
  {
    if (paramClass.isAnnotation()) {
      return "annotation";
    }
    if (paramClass.isArray()) {
      return "array";
    }
    if (paramClass.isEnum()) {
      return "enum";
    }
    if (paramClass.isPrimitive()) {
      return "primitive";
    }
    return null;
  }
  
  public static void checkAndFixAccess(Member paramMember)
  {
    Object localObject = (AccessibleObject)paramMember;
    try
    {
      ((AccessibleObject)localObject).setAccessible(true);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      while (((AccessibleObject)localObject).isAccessible()) {}
      localObject = paramMember.getDeclaringClass();
      throw new IllegalArgumentException("Can not access " + paramMember + " (from class " + ((Class)localObject).getName() + "; failed to set access: " + localSecurityException.getMessage());
    }
  }
  
  public static <T> T createInstance(Class<T> paramClass, boolean paramBoolean)
    throws IllegalArgumentException
  {
    Object localObject = findConstructor(paramClass, paramBoolean);
    if (localObject == null) {
      throw new IllegalArgumentException("Class " + paramClass.getName() + " has no default (no arg) constructor");
    }
    try
    {
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      return (T)localObject;
    }
    catch (Exception localException)
    {
      unwrapAndThrowAsIAE(localException, "Failed to instantiate class " + paramClass.getName() + ", problem: " + localException.getMessage());
    }
    return null;
  }
  
  public static Object defaultValue(Class<?> paramClass)
  {
    if (paramClass == Integer.TYPE) {
      return Integer.valueOf(0);
    }
    if (paramClass == Long.TYPE) {
      return Long.valueOf(0L);
    }
    if (paramClass == Boolean.TYPE) {
      return Boolean.FALSE;
    }
    if (paramClass == Double.TYPE) {
      return Double.valueOf(0.0D);
    }
    if (paramClass == Float.TYPE) {
      return Float.valueOf(0.0F);
    }
    if (paramClass == Byte.TYPE) {
      return Byte.valueOf((byte)0);
    }
    if (paramClass == Short.TYPE) {
      return Short.valueOf((short)0);
    }
    if (paramClass == Character.TYPE) {
      return Character.valueOf('\000');
    }
    throw new IllegalArgumentException("Class " + paramClass.getName() + " is not a primitive type");
  }
  
  @Deprecated
  public static Class<?> findClass(String paramString)
    throws ClassNotFoundException
  {
    if (paramString.indexOf('.') < 0)
    {
      if ("int".equals(paramString)) {
        return Integer.TYPE;
      }
      if ("long".equals(paramString)) {
        return Long.TYPE;
      }
      if ("float".equals(paramString)) {
        return Float.TYPE;
      }
      if ("double".equals(paramString)) {
        return Double.TYPE;
      }
      if ("boolean".equals(paramString)) {
        return Boolean.TYPE;
      }
      if ("byte".equals(paramString)) {
        return Byte.TYPE;
      }
      if ("char".equals(paramString)) {
        return Character.TYPE;
      }
      if ("short".equals(paramString)) {
        return Short.TYPE;
      }
      if ("void".equals(paramString)) {
        return Void.TYPE;
      }
    }
    Class localClass = null;
    ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
    Throwable localThrowable;
    if (localClassLoader != null) {
      try
      {
        localClass = Class.forName(paramString, true, localClassLoader);
        return localClass;
      }
      catch (Exception localException1)
      {
        localThrowable = getRootCause(localException1);
      }
    }
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Exception localException2)
    {
      paramString = localThrowable;
      if (localThrowable == null) {
        paramString = getRootCause(localException2);
      }
      if ((paramString instanceof RuntimeException)) {
        throw ((RuntimeException)paramString);
      }
      throw new ClassNotFoundException(paramString.getMessage(), paramString);
    }
  }
  
  public static <T> Constructor<T> findConstructor(Class<T> paramClass, boolean paramBoolean)
    throws IllegalArgumentException
  {
    try
    {
      Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
      if (paramBoolean)
      {
        checkAndFixAccess(localConstructor);
        return localConstructor;
      }
      if (!Modifier.isPublic(localConstructor.getModifiers())) {
        throw new IllegalArgumentException("Default constructor for " + paramClass.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: can not instantiate type");
      }
    }
    catch (NoSuchMethodException paramClass)
    {
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        unwrapAndThrowAsIAE(localException, "Failed to find default constructor of class " + paramClass.getName() + ", problem: " + localException.getMessage());
      }
      return localException;
    }
  }
  
  public static Class<? extends Enum<?>> findEnumType(Class<?> paramClass)
  {
    Object localObject = paramClass;
    if (paramClass.getSuperclass() != Enum.class) {
      localObject = paramClass.getSuperclass();
    }
    return (Class<? extends Enum<?>>)localObject;
  }
  
  public static Class<? extends Enum<?>> findEnumType(Enum<?> paramEnum)
  {
    Class localClass = paramEnum.getClass();
    paramEnum = localClass;
    if (localClass.getSuperclass() != Enum.class) {
      paramEnum = localClass.getSuperclass();
    }
    return paramEnum;
  }
  
  public static Class<? extends Enum<?>> findEnumType(EnumMap<?, ?> paramEnumMap)
  {
    if (!paramEnumMap.isEmpty()) {
      return findEnumType((Enum)paramEnumMap.keySet().iterator().next());
    }
    return EnumTypeLocator.instance.enumTypeFor(paramEnumMap);
  }
  
  public static Class<? extends Enum<?>> findEnumType(EnumSet<?> paramEnumSet)
  {
    if (!paramEnumSet.isEmpty()) {
      return findEnumType((Enum)paramEnumSet.iterator().next());
    }
    return EnumTypeLocator.instance.enumTypeFor(paramEnumSet);
  }
  
  public static List<Class<?>> findSuperTypes(Class<?> paramClass1, Class<?> paramClass2)
  {
    return findSuperTypes(paramClass1, paramClass2, new ArrayList(8));
  }
  
  public static List<Class<?>> findSuperTypes(Class<?> paramClass1, Class<?> paramClass2, List<Class<?>> paramList)
  {
    _addSuperTypes(paramClass1, paramClass2, paramList, false);
    return paramList;
  }
  
  public static String getClassDescription(Object paramObject)
  {
    if (paramObject == null) {
      return "unknown";
    }
    if ((paramObject instanceof Class)) {}
    for (paramObject = (Class)paramObject;; paramObject = paramObject.getClass()) {
      return ((Class)paramObject).getName();
    }
  }
  
  public static Class<?> getOuterClass(Class<?> paramClass)
  {
    try
    {
      if (paramClass.getEnclosingMethod() != null) {
        return null;
      }
      if (!Modifier.isStatic(paramClass.getModifiers()))
      {
        paramClass = paramClass.getEnclosingClass();
        return paramClass;
      }
    }
    catch (NullPointerException paramClass)
    {
      return null;
    }
    catch (SecurityException paramClass) {}
    return null;
  }
  
  public static Throwable getRootCause(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    return paramThrowable;
  }
  
  @Deprecated
  public static boolean hasGetterSignature(Method paramMethod)
  {
    if (Modifier.isStatic(paramMethod.getModifiers())) {}
    Class[] arrayOfClass;
    do
    {
      return false;
      arrayOfClass = paramMethod.getParameterTypes();
    } while (((arrayOfClass != null) && (arrayOfClass.length != 0)) || (Void.TYPE == paramMethod.getReturnType()));
    return true;
  }
  
  public static boolean isBogusClass(Class<?> paramClass)
  {
    return (paramClass == Void.class) || (paramClass == Void.TYPE) || (paramClass == NoClass.class);
  }
  
  public static boolean isCollectionMapOrArray(Class<?> paramClass)
  {
    if (paramClass.isArray()) {}
    while ((Collection.class.isAssignableFrom(paramClass)) || (Map.class.isAssignableFrom(paramClass))) {
      return true;
    }
    return false;
  }
  
  public static boolean isConcrete(Class<?> paramClass)
  {
    return (paramClass.getModifiers() & 0x600) == 0;
  }
  
  public static boolean isConcrete(Member paramMember)
  {
    return (paramMember.getModifiers() & 0x600) == 0;
  }
  
  public static boolean isJacksonStdImpl(Class<?> paramClass)
  {
    return paramClass.getAnnotation(JacksonStdImpl.class) != null;
  }
  
  public static boolean isJacksonStdImpl(Object paramObject)
  {
    return (paramObject != null) && (isJacksonStdImpl(paramObject.getClass()));
  }
  
  public static String isLocalType(Class<?> paramClass, boolean paramBoolean)
  {
    try
    {
      if (paramClass.getEnclosingMethod() != null) {
        return "local/anonymous";
      }
      if ((!paramBoolean) && (paramClass.getEnclosingClass() != null) && (!Modifier.isStatic(paramClass.getModifiers()))) {
        return "non-static member class";
      }
    }
    catch (NullPointerException paramClass)
    {
      return null;
    }
    catch (SecurityException paramClass)
    {
      for (;;) {}
    }
  }
  
  public static boolean isNonStaticInnerClass(Class<?> paramClass)
  {
    return (paramClass.getEnclosingClass() != null) && (!Modifier.isStatic(paramClass.getModifiers()));
  }
  
  public static boolean isProxyType(Class<?> paramClass)
  {
    paramClass = paramClass.getName();
    return (paramClass.startsWith("net.sf.cglib.proxy.")) || (paramClass.startsWith("org.hibernate.proxy."));
  }
  
  public static void throwAsIAE(Throwable paramThrowable)
  {
    throwAsIAE(paramThrowable, paramThrowable.getMessage());
  }
  
  public static void throwAsIAE(Throwable paramThrowable, String paramString)
  {
    if ((paramThrowable instanceof RuntimeException)) {
      throw ((RuntimeException)paramThrowable);
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    throw new IllegalArgumentException(paramString, paramThrowable);
  }
  
  public static void throwRootCause(Throwable paramThrowable)
    throws Exception
  {
    paramThrowable = getRootCause(paramThrowable);
    if ((paramThrowable instanceof Exception)) {
      throw ((Exception)paramThrowable);
    }
    throw ((Error)paramThrowable);
  }
  
  public static void unwrapAndThrowAsIAE(Throwable paramThrowable)
  {
    throwAsIAE(getRootCause(paramThrowable));
  }
  
  public static void unwrapAndThrowAsIAE(Throwable paramThrowable, String paramString)
  {
    throwAsIAE(getRootCause(paramThrowable), paramString);
  }
  
  public static Class<?> wrapperType(Class<?> paramClass)
  {
    if (paramClass == Integer.TYPE) {
      return Integer.class;
    }
    if (paramClass == Long.TYPE) {
      return Long.class;
    }
    if (paramClass == Boolean.TYPE) {
      return Boolean.class;
    }
    if (paramClass == Double.TYPE) {
      return Double.class;
    }
    if (paramClass == Float.TYPE) {
      return Float.class;
    }
    if (paramClass == Byte.TYPE) {
      return Byte.class;
    }
    if (paramClass == Short.TYPE) {
      return Short.class;
    }
    if (paramClass == Character.TYPE) {
      return Character.class;
    }
    throw new IllegalArgumentException("Class " + paramClass.getName() + " is not a primitive type");
  }
  
  private static class EnumTypeLocator
  {
    static final EnumTypeLocator instance = new EnumTypeLocator();
    private final Field enumMapTypeField = locateField(EnumMap.class, "elementType", Class.class);
    private final Field enumSetTypeField = locateField(EnumSet.class, "elementType", Class.class);
    
    private Object get(Object paramObject, Field paramField)
    {
      try
      {
        paramObject = paramField.get(paramObject);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        throw new IllegalArgumentException((Throwable)paramObject);
      }
    }
    
    private static Field locateField(Class<?> paramClass1, String paramString, Class<?> paramClass2)
    {
      Object localObject = null;
      Field[] arrayOfField = paramClass1.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      paramClass1 = (Class<?>)localObject;
      if (i < j)
      {
        paramClass1 = arrayOfField[i];
        if ((!paramString.equals(paramClass1.getName())) || (paramClass1.getType() != paramClass2)) {}
      }
      else
      {
        paramString = paramClass1;
        if (paramClass1 != null) {
          break label112;
        }
        j = arrayOfField.length;
        i = 0;
      }
      for (;;)
      {
        paramString = paramClass1;
        if (i >= j) {
          break label112;
        }
        localObject = arrayOfField[i];
        paramString = paramClass1;
        if (((Field)localObject).getType() == paramClass2)
        {
          if (paramClass1 != null)
          {
            return null;
            i += 1;
            break;
          }
          paramString = (String)localObject;
        }
        i += 1;
        paramClass1 = paramString;
      }
      label112:
      if (paramString != null) {}
      try
      {
        paramString.setAccessible(true);
        return paramString;
      }
      catch (Throwable paramClass1)
      {
        for (;;) {}
      }
    }
    
    public Class<? extends Enum<?>> enumTypeFor(EnumMap<?, ?> paramEnumMap)
    {
      if (enumMapTypeField != null) {
        return (Class)get(paramEnumMap, enumMapTypeField);
      }
      throw new IllegalStateException("Can not figure out type for EnumMap (odd JDK platform?)");
    }
    
    public Class<? extends Enum<?>> enumTypeFor(EnumSet<?> paramEnumSet)
    {
      if (enumSetTypeField != null) {
        return (Class)get(paramEnumSet, enumSetTypeField);
      }
      throw new IllegalStateException("Can not figure out type for EnumSet (odd JDK platform?)");
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.ClassUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */