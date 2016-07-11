package rx.functions;

final class Actions$6
  implements Func5<T1, T2, T3, T4, T5, R>
{
  Actions$6(Action5 paramAction5, Object paramObject) {}
  
  public R call(T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4, T5 paramT5)
  {
    val$action.call(paramT1, paramT2, paramT3, paramT4, paramT5);
    return (R)val$result;
  }
}

/* Location:
 * Qualified Name:     rx.functions.Actions.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */