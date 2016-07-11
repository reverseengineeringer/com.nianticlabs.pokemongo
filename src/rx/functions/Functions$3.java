package rx.functions;

final class Functions$3
  implements FuncN<R>
{
  Functions$3(Func2 paramFunc2) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 2) {
      throw new RuntimeException("Func2 expecting 2 arguments.");
    }
    return (R)val$f.call(paramVarArgs[0], paramVarArgs[1]);
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */