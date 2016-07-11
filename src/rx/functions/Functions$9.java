package rx.functions;

final class Functions$9
  implements FuncN<R>
{
  Functions$9(Func8 paramFunc8) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 8) {
      throw new RuntimeException("Func8 expecting 8 arguments.");
    }
    return (R)val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5], paramVarArgs[6], paramVarArgs[7]);
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */