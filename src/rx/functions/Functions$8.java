package rx.functions;

final class Functions$8
  implements FuncN<R>
{
  Functions$8(Func7 paramFunc7) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 7) {
      throw new RuntimeException("Func7 expecting 7 arguments.");
    }
    return (R)val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5], paramVarArgs[6]);
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */