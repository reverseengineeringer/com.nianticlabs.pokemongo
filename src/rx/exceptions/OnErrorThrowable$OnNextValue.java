package rx.exceptions;

import java.util.HashSet;
import java.util.Set;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

public class OnErrorThrowable$OnNextValue
  extends RuntimeException
{
  private static final long serialVersionUID = -3454462756050397899L;
  private final Object value;
  
  public OnErrorThrowable$OnNextValue(Object paramObject)
  {
    super("OnError while emitting onNext value: " + renderValue(paramObject));
    value = paramObject;
  }
  
  static String renderValue(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    if (Primitives.INSTANCE.contains(paramObject.getClass())) {
      return paramObject.toString();
    }
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof Enum)) {
      return ((Enum)paramObject).name();
    }
    String str = RxJavaPlugins.getInstance().getErrorHandler().handleOnNextValueRendering(paramObject);
    if (str != null) {
      return str;
    }
    return paramObject.getClass().getName() + ".class";
  }
  
  public Object getValue()
  {
    return value;
  }
  
  private static final class Primitives
  {
    static final Set<Class<?>> INSTANCE = ;
    
    private static Set<Class<?>> create()
    {
      HashSet localHashSet = new HashSet();
      localHashSet.add(Boolean.class);
      localHashSet.add(Character.class);
      localHashSet.add(Byte.class);
      localHashSet.add(Short.class);
      localHashSet.add(Integer.class);
      localHashSet.add(Long.class);
      localHashSet.add(Float.class);
      localHashSet.add(Double.class);
      return localHashSet;
    }
  }
}

/* Location:
 * Qualified Name:     rx.exceptions.OnErrorThrowable.OnNextValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */