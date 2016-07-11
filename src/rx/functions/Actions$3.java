package rx.functions;

final class Actions$3
  implements Func2<T1, T2, R>
{
  Actions$3(Action2 paramAction2, Object paramObject) {}
  
  public R call(T1 paramT1, T2 paramT2)
  {
    val$action.call(paramT1, paramT2);
    return (R)val$result;
  }
}

/* Location:
 * Qualified Name:     rx.functions.Actions.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */