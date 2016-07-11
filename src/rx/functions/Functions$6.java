package rx.functions;

final class Functions$6
  implements FuncN<R>
{
  Functions$6(Func5 paramFunc5) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 5) {
      throw new RuntimeException("Func5 expecting 5 arguments.");
    }
    return (R)val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4]);
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */