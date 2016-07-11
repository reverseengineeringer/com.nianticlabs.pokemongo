package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;
import java.lang.reflect.Proxy;

public class ClassLoaderObjectInputStream
  extends ObjectInputStream
{
  private final ClassLoader classLoader;
  
  public ClassLoaderObjectInputStream(ClassLoader paramClassLoader, InputStream paramInputStream)
    throws IOException, StreamCorruptedException
  {
    super(paramInputStream);
    classLoader = paramClassLoader;
  }
  
  protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass)
    throws IOException, ClassNotFoundException
  {
    Class localClass = Class.forName(paramObjectStreamClass.getName(), false, classLoader);
    if (localClass != null) {
      return localClass;
    }
    return super.resolveClass(paramObjectStreamClass);
  }
  
  protected Class<?> resolveProxyClass(String[] paramArrayOfString)
    throws IOException, ClassNotFoundException
  {
    Object localObject = new Class[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localObject[i] = Class.forName(paramArrayOfString[i], false, classLoader);
      i += 1;
    }
    try
    {
      localObject = Proxy.getProxyClass(classLoader, (Class[])localObject);
      return (Class<?>)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return super.resolveProxyClass(paramArrayOfString);
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.ClassLoaderObjectInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */