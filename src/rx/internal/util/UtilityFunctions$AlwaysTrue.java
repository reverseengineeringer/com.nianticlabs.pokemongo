package rx.internal.util;

import rx.functions.Func1;

 enum UtilityFunctions$AlwaysTrue
  implements Func1<Object, Boolean>
{
  INSTANCE;
  
  private UtilityFunctions$AlwaysTrue() {}
  
  public Boolean call(Object paramObject)
  {
    return Boolean.valueOf(true);
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.UtilityFunctions.AlwaysTrue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */