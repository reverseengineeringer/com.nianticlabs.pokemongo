package rx.functions;

final class Actions$4
  implements Func3<T1, T2, T3, R>
{
  Actions$4(Action3 paramAction3, Object paramObject) {}
  
  public R call(T1 paramT1, T2 paramT2, T3 paramT3)
  {
    val$action.call(paramT1, paramT2, paramT3);
    return (R)val$result;
  }
}

/* Location:
 * Qualified Name:     rx.functions.Actions.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */