package rx.functions;

final class Functions$1
  implements FuncN<R>
{
  Functions$1(Func0 paramFunc0) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 0) {
      throw new RuntimeException("Func0 expecting 0 arguments.");
    }
    return (R)val$f.call();
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */