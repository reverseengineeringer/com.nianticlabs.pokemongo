package rx.internal.util.unsafe;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public final class UnsafeAccess
{
  public static final Unsafe UNSAFE;
  
  static
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = Unsafe.class.getDeclaredField("theUnsafe");
      ((Field)localObject2).setAccessible(true);
      localObject2 = (Unsafe)((Field)localObject2).get(null);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    UNSAFE = (Unsafe)localObject1;
  }
  
  private UnsafeAccess()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static long addressOf(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      long l = UNSAFE.objectFieldOffset(paramClass);
      return l;
    }
    catch (NoSuchFieldException paramClass)
    {
      paramString = new InternalError();
      paramString.initCause(paramClass);
      throw paramString;
    }
  }
  
  public static boolean compareAndSwapInt(Object paramObject, long paramLong, int paramInt1, int paramInt2)
  {
    return UNSAFE.compareAndSwapInt(paramObject, paramLong, paramInt1, paramInt2);
  }
  
  public static int getAndAddInt(Object paramObject, long paramLong, int paramInt)
  {
    int i;
    do
    {
      i = UNSAFE.getIntVolatile(paramObject, paramLong);
    } while (!UNSAFE.compareAndSwapInt(paramObject, paramLong, i, i + paramInt));
    return i;
  }
  
  public static int getAndIncrementInt(Object paramObject, long paramLong)
  {
    int i;
    do
    {
      i = UNSAFE.getIntVolatile(paramObject, paramLong);
    } while (!UNSAFE.compareAndSwapInt(paramObject, paramLong, i, i + 1));
    return i;
  }
  
  public static int getAndSetInt(Object paramObject, long paramLong, int paramInt)
  {
    int i;
    do
    {
      i = UNSAFE.getIntVolatile(paramObject, paramLong);
    } while (!UNSAFE.compareAndSwapInt(paramObject, paramLong, i, paramInt));
    return i;
  }
  
  public static final boolean isUnsafeAvailable()
  {
    return UNSAFE != null;
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.unsafe.UnsafeAccess
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */