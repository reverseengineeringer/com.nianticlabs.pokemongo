package rx.functions;

final class Functions$7
  implements FuncN<R>
{
  Functions$7(Func6 paramFunc6) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 6) {
      throw new RuntimeException("Func6 expecting 6 arguments.");
    }
    return (R)val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5]);
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */