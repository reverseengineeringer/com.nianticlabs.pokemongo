package rx.functions;

public abstract interface Func2<T1, T2, R>
  extends Function
{
  public abstract R call(T1 paramT1, T2 paramT2);
}

/* Location:
 * Qualified Name:     rx.functions.Func2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */