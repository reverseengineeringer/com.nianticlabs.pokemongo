package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzsf
{
  private static void zza(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
    throws IllegalAccessException, InvocationTargetException
  {
    if (paramObject == null) {
      return;
    }
    int m;
    Class localClass;
    int i;
    String str;
    Object localObject2;
    if ((paramObject instanceof zzse))
    {
      m = paramStringBuffer1.length();
      if (paramString != null)
      {
        paramStringBuffer2.append(paramStringBuffer1).append(zzfB(paramString)).append(" <\n");
        paramStringBuffer1.append("  ");
      }
      localClass = paramObject.getClass();
      Object localObject1 = localClass.getFields();
      int n = localObject1.length;
      i = 0;
      if (i < n)
      {
        Object localObject3 = localObject1[i];
        j = ((Field)localObject3).getModifiers();
        str = ((Field)localObject3).getName();
        if ("cachedSize".equals(str)) {}
        for (;;)
        {
          i += 1;
          break;
          if (((j & 0x1) == 1) && ((j & 0x8) != 8) && (!str.startsWith("_")) && (!str.endsWith("_")))
          {
            localObject2 = ((Field)localObject3).getType();
            localObject3 = ((Field)localObject3).get(paramObject);
            if (((Class)localObject2).isArray())
            {
              if (((Class)localObject2).getComponentType() == Byte.TYPE)
              {
                zza(str, localObject3, paramStringBuffer1, paramStringBuffer2);
              }
              else
              {
                if (localObject3 == null) {}
                for (j = 0;; j = Array.getLength(localObject3))
                {
                  int k = 0;
                  while (k < j)
                  {
                    zza(str, Array.get(localObject3, k), paramStringBuffer1, paramStringBuffer2);
                    k += 1;
                  }
                  break;
                }
              }
            }
            else {
              zza(str, localObject3, paramStringBuffer1, paramStringBuffer2);
            }
          }
        }
      }
      localObject1 = localClass.getMethods();
      int j = localObject1.length;
      i = 0;
      label277:
      if (i < j)
      {
        str = localObject1[i].getName();
        if (str.startsWith("set")) {
          str = str.substring(3);
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = localClass.getMethod("has" + str, new Class[0]);
        if (((Boolean)((Method)localObject2).invoke(paramObject, new Object[0])).booleanValue()) {
          continue;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        continue;
      }
      i += 1;
      break label277;
      try
      {
        localObject2 = localClass.getMethod("get" + str, new Class[0]);
        zza(str, ((Method)localObject2).invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2);
      }
      catch (NoSuchMethodException localNoSuchMethodException1) {}
      if (paramString == null) {
        break;
      }
      paramStringBuffer1.setLength(m);
      paramStringBuffer2.append(paramStringBuffer1).append(">\n");
      return;
      paramString = zzfB(paramString);
      paramStringBuffer2.append(paramStringBuffer1).append(paramString).append(": ");
      if ((paramObject instanceof String))
      {
        paramString = zzfC((String)paramObject);
        paramStringBuffer2.append("\"").append(paramString).append("\"");
        paramStringBuffer2.append("\n");
        return;
      }
      if ((paramObject instanceof byte[])) {
        zza((byte[])paramObject, paramStringBuffer2);
      } else {
        paramStringBuffer2.append(paramObject);
      }
    }
  }
  
  private static void zza(byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    if (paramArrayOfByte == null)
    {
      paramStringBuffer.append("\"\"");
      return;
    }
    paramStringBuffer.append('"');
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      if ((j == 92) || (j == 34)) {
        paramStringBuffer.append('\\').append((char)j);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((j >= 32) && (j < 127)) {
          paramStringBuffer.append((char)j);
        } else {
          paramStringBuffer.append(String.format("\\%03o", new Object[] { Integer.valueOf(j) }));
        }
      }
    }
    paramStringBuffer.append('"');
  }
  
  private static String zzcz(String paramString)
  {
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      if ((c >= ' ') && (c <= '~') && (c != '"') && (c != '\'')) {
        localStringBuilder.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String zzfB(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (i == 0) {
        localStringBuffer.append(Character.toLowerCase(c));
      }
      for (;;)
      {
        i += 1;
        break;
        if (Character.isUpperCase(c)) {
          localStringBuffer.append('_').append(Character.toLowerCase(c));
        } else {
          localStringBuffer.append(c);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  private static String zzfC(String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("http"))
    {
      str = paramString;
      if (paramString.length() > 200) {
        str = paramString.substring(0, 200) + "[...]";
      }
    }
    return zzcz(str);
  }
  
  public static <T extends zzse> String zzg(T paramT)
  {
    if (paramT == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      zza(null, paramT, new StringBuffer(), localStringBuffer);
      return localStringBuffer.toString();
    }
    catch (IllegalAccessException paramT)
    {
      return "Error printing proto: " + paramT.getMessage();
    }
    catch (InvocationTargetException paramT) {}
    return "Error printing proto: " + paramT.getMessage();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */