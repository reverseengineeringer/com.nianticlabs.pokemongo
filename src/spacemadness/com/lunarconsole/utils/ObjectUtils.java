package spacemadness.com.lunarconsole.utils;

public class ObjectUtils
{
  public static boolean areEqual(Object paramObject1, Object paramObject2)
  {
    return ((paramObject1 != null) && (paramObject1.equals(paramObject2))) || ((paramObject1 == null) && (paramObject2 == null));
  }
  
  public static <T> T as(Object paramObject, Class<? extends T> paramClass)
  {
    if (paramClass.isInstance(paramObject)) {
      return (T)paramObject;
    }
    return null;
  }
  
  public static <T> T notNullOrDefault(T paramT1, T paramT2)
  {
    if (paramT2 == null) {
      throw new NullPointerException("Default object is null");
    }
    if (paramT1 != null) {
      return paramT1;
    }
    return paramT2;
  }
  
  public static String toString(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.toString();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.utils.ObjectUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */