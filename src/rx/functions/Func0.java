package rx.functions;

import java.util.concurrent.Callable;

public abstract interface Func0<R>
  extends Function, Callable<R>
{
  public abstract R call();
}

/* Location:
 * Qualified Name:     rx.functions.Func0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */