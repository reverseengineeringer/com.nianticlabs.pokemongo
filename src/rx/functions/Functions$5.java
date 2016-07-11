package rx.functions;

final class Functions$5
  implements FuncN<R>
{
  Functions$5(Func4 paramFunc4) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 4) {
      throw new RuntimeException("Func4 expecting 4 arguments.");
    }
    return (R)val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3]);
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */