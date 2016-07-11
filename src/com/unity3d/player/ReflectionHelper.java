package com.unity3d.player;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;

final class ReflectionHelper
{
  protected static boolean LOG = false;
  protected static final boolean LOGV = false;
  private static a[] a = new a['က'];
  
  private static float a(Class paramClass1, Class paramClass2)
  {
    if (paramClass1.equals(paramClass2)) {
      return 1.0F;
    }
    if ((!paramClass1.isPrimitive()) && (!paramClass2.isPrimitive())) {
      try
      {
        Class localClass = paramClass1.asSubclass(paramClass2);
        if (localClass != null) {
          return 0.5F;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        try
        {
          paramClass1 = paramClass2.asSubclass(paramClass1);
          if (paramClass1 != null) {
            return 0.1F;
          }
        }
        catch (ClassCastException paramClass1) {}
      }
    }
    return 0.0F;
  }
  
  private static float a(Class paramClass, Class[] paramArrayOfClass1, Class[] paramArrayOfClass2)
  {
    int j = 0;
    if (paramArrayOfClass2.length == 0) {
      return 0.1F;
    }
    if (paramArrayOfClass1 == null) {}
    for (int i = 0; i + 1 != paramArrayOfClass2.length; i = paramArrayOfClass1.length) {
      return 0.0F;
    }
    float f1 = 1.0F;
    float f2 = f1;
    if (paramArrayOfClass1 != null)
    {
      int k = paramArrayOfClass1.length;
      i = 0;
      for (;;)
      {
        f2 = f1;
        if (j >= k) {
          break;
        }
        f1 *= a(paramArrayOfClass1[j], paramArrayOfClass2[i]);
        j += 1;
        i += 1;
      }
    }
    return f2 * a(paramClass, paramArrayOfClass2[(paramArrayOfClass2.length - 1)]);
  }
  
  private static Class a(String paramString, int[] paramArrayOfInt)
  {
    while (paramArrayOfInt[0] < paramString.length())
    {
      int i = paramArrayOfInt[0];
      paramArrayOfInt[0] = (i + 1);
      char c = paramString.charAt(i);
      if ((c != '(') && (c != ')')) {
        if (c == 'L')
        {
          i = paramString.indexOf(';', paramArrayOfInt[0]);
          if (i == -1) {
            break;
          }
          paramString = paramString.substring(paramArrayOfInt[0], i);
          paramArrayOfInt[0] = (i + 1);
          paramString = paramString.replace('/', '.');
        }
      }
      try
      {
        paramString = Class.forName(paramString);
        return paramString;
      }
      catch (ClassNotFoundException paramString)
      {
        for (;;) {}
      }
      if (c == 'Z') {
        return Boolean.TYPE;
      }
      if (c == 'I') {
        return Integer.TYPE;
      }
      if (c == 'F') {
        return Float.TYPE;
      }
      if (c == 'V') {
        return Void.TYPE;
      }
      if (c == 'B') {
        return Byte.TYPE;
      }
      if (c == 'S') {
        return Short.TYPE;
      }
      if (c == 'J') {
        return Long.TYPE;
      }
      if (c == 'D') {
        return Double.TYPE;
      }
      if (c == '[') {
        return Array.newInstance(a(paramString, paramArrayOfInt), 0).getClass();
      }
      m.Log(5, "! parseType; " + c + " is not known!");
    }
    return null;
  }
  
  private static void a(a parama, Member paramMember)
  {
    a = paramMember;
    a[(parama.hashCode() & a.length - 1)] = parama;
  }
  
  private static boolean a(a parama)
  {
    a locala = a[(parama.hashCode() & a.length - 1)];
    if (!parama.equals(locala)) {
      return false;
    }
    a = a;
    return true;
  }
  
  private static Class[] a(String paramString)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    Object localObject = new ArrayList();
    while (arrayOfInt[0] < paramString.length())
    {
      Class localClass = a(paramString, arrayOfInt);
      if (localClass == null) {
        break;
      }
      ((ArrayList)localObject).add(localClass);
    }
    paramString = new Class[((ArrayList)localObject).size()];
    localObject = ((ArrayList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      paramString[i] = ((Class)((Iterator)localObject).next());
      i += 1;
    }
    return paramString;
  }
  
  protected static Constructor getConstructorID(Class paramClass, String paramString)
  {
    Object localObject = null;
    a locala = new a(paramClass, "", paramString);
    int i;
    if (a(locala))
    {
      localObject = (Constructor)a;
      if (localObject == null) {
        throw new NoSuchMethodError("<init>" + paramString + " in class " + paramClass.getName());
      }
    }
    else
    {
      Class[] arrayOfClass = a(paramString);
      float f1 = 0.0F;
      Constructor[] arrayOfConstructor = paramClass.getConstructors();
      int j = arrayOfConstructor.length;
      i = 0;
      label97:
      if (i < j)
      {
        Constructor localConstructor = arrayOfConstructor[i];
        float f2 = a(Void.TYPE, localConstructor.getParameterTypes(), arrayOfClass);
        if (f2 <= f1) {
          break label169;
        }
        localObject = localConstructor;
        if (f2 != 1.0F)
        {
          localObject = localConstructor;
          f1 = f2;
        }
      }
    }
    label169:
    for (;;)
    {
      i += 1;
      break label97;
      a(locala, (Member)localObject);
      break;
      return (Constructor)localObject;
    }
  }
  
  protected static Field getFieldID(Class paramClass, String paramString1, String paramString2, boolean paramBoolean)
  {
    a locala = new a(paramClass, paramString1, paramString2);
    Object localObject2;
    Object localObject1;
    label43:
    float f1;
    if (a(locala))
    {
      localObject2 = (Field)a;
      if (localObject2 != null) {
        break label300;
      }
      if (paramBoolean)
      {
        localObject1 = "non-static";
        throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", new Object[] { localObject1, paramString1, paramString2, paramClass.getName() }));
      }
    }
    else
    {
      Class[] arrayOfClass = a(paramString2);
      localObject2 = null;
      f1 = 0.0F;
      localObject1 = paramClass;
      paramClass = (Class)localObject2;
      label98:
      localObject2 = paramClass;
      if (localObject1 != null)
      {
        Field[] arrayOfField = ((Class)localObject1).getDeclaredFields();
        int j = arrayOfField.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            localObject2 = arrayOfField[i];
            if ((paramBoolean == Modifier.isStatic(((Field)localObject2).getModifiers())) && (((Field)localObject2).getName().compareTo(paramString1) == 0))
            {
              float f2 = a(((Field)localObject2).getType(), null, arrayOfClass);
              if (f2 > f1)
              {
                if (f2 != 1.0F)
                {
                  paramClass = (Class)localObject2;
                  f1 = f2;
                  label194:
                  i += 1;
                  continue;
                }
                f1 = f2;
                paramClass = (Class)localObject2;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = paramClass;
      if (f1 != 1.0F)
      {
        localObject2 = paramClass;
        if (!((Class)localObject1).isPrimitive())
        {
          localObject2 = paramClass;
          if (!((Class)localObject1).isInterface())
          {
            localObject2 = paramClass;
            if (!localObject1.equals(Object.class))
            {
              localObject2 = paramClass;
              if (!localObject1.equals(Void.TYPE))
              {
                localObject1 = ((Class)localObject1).getSuperclass();
                break label98;
              }
            }
          }
        }
      }
      a(locala, (Member)localObject2);
      paramClass = (Class)localObject1;
      break;
      localObject1 = "static";
      break label43;
      label300:
      return (Field)localObject2;
      break label194;
    }
  }
  
  protected static Method getMethodID(Class paramClass, String paramString1, String paramString2, boolean paramBoolean)
  {
    a locala = new a(paramClass, paramString1, paramString2);
    Object localObject2;
    Object localObject1;
    label43:
    float f1;
    if (a(locala))
    {
      localObject2 = (Method)a;
      if (localObject2 != null) {
        break label305;
      }
      if (paramBoolean)
      {
        localObject1 = "non-static";
        throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", new Object[] { localObject1, paramString1, paramString2, paramClass.getName() }));
      }
    }
    else
    {
      Class[] arrayOfClass = a(paramString2);
      localObject2 = null;
      f1 = 0.0F;
      localObject1 = paramClass;
      paramClass = (Class)localObject2;
      label99:
      localObject2 = paramClass;
      if (localObject1 != null)
      {
        Method[] arrayOfMethod = ((Class)localObject1).getDeclaredMethods();
        int j = arrayOfMethod.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            localObject2 = arrayOfMethod[i];
            if ((paramBoolean == Modifier.isStatic(((Method)localObject2).getModifiers())) && (((Method)localObject2).getName().compareTo(paramString1) == 0))
            {
              float f2 = a(((Method)localObject2).getReturnType(), ((Method)localObject2).getParameterTypes(), arrayOfClass);
              if (f2 > f1)
              {
                if (f2 != 1.0F)
                {
                  paramClass = (Class)localObject2;
                  f1 = f2;
                  label199:
                  i += 1;
                  continue;
                }
                f1 = f2;
                paramClass = (Class)localObject2;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = paramClass;
      if (f1 != 1.0F)
      {
        localObject2 = paramClass;
        if (!((Class)localObject1).isPrimitive())
        {
          localObject2 = paramClass;
          if (!((Class)localObject1).isInterface())
          {
            localObject2 = paramClass;
            if (!localObject1.equals(Object.class))
            {
              localObject2 = paramClass;
              if (!localObject1.equals(Void.TYPE))
              {
                localObject1 = ((Class)localObject1).getSuperclass();
                break label99;
              }
            }
          }
        }
      }
      a(locala, (Member)localObject2);
      paramClass = (Class)localObject1;
      break;
      localObject1 = "static";
      break label43;
      label305:
      return (Method)localObject2;
      break label199;
    }
  }
  
  private static native void nativeProxyFinalize(int paramInt);
  
  private static native Object nativeProxyInvoke(int paramInt, String paramString, Object[] paramArrayOfObject);
  
  protected static Object newProxyInstance(int paramInt, Class paramClass)
  {
    return newProxyInstance(paramInt, new Class[] { paramClass });
  }
  
  protected static Object newProxyInstance(int paramInt, final Class[] paramArrayOfClass)
  {
    Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), paramArrayOfClass, new InvocationHandler()
    {
      protected final void finalize()
      {
        try
        {
          ReflectionHelper.a(a);
          return;
        }
        finally
        {
          super.finalize();
        }
      }
      
      public final Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
      {
        return ReflectionHelper.a(a, paramAnonymousMethod.getName(), paramAnonymousArrayOfObject);
      }
    });
  }
  
  private static final class a
  {
    public volatile Member a;
    private final Class b;
    private final String c;
    private final String d;
    private final int e;
    
    a(Class paramClass, String paramString1, String paramString2)
    {
      b = paramClass;
      c = paramString1;
      d = paramString2;
      e = (((b.hashCode() + 527) * 31 + c.hashCode()) * 31 + d.hashCode());
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          break;
        }
        paramObject = (a)paramObject;
      } while ((e == e) && (d.equals(d)) && (c.equals(c)) && (b.equals(b)));
      return false;
      return false;
    }
    
    public final int hashCode()
    {
      return e;
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.ReflectionHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */