package rx.functions;

final class Actions$5
  implements Func4<T1, T2, T3, T4, R>
{
  Actions$5(Action4 paramAction4, Object paramObject) {}
  
  public R call(T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4)
  {
    val$action.call(paramT1, paramT2, paramT3, paramT4);
    return (R)val$result;
  }
}

/* Location:
 * Qualified Name:     rx.functions.Actions.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */