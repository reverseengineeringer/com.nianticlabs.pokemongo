package rx.functions;

public abstract interface Func1<T, R>
  extends Function
{
  public abstract R call(T paramT);
}

/* Location:
 * Qualified Name:     rx.functions.Func1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */