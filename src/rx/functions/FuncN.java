package rx.functions;

public abstract interface FuncN<R>
  extends Function
{
  public abstract R call(Object... paramVarArgs);
}

/* Location:
 * Qualified Name:     rx.functions.FuncN
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */