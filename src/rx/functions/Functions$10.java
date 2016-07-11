package rx.functions;

final class Functions$10
  implements FuncN<R>
{
  Functions$10(Func9 paramFunc9) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 9) {
      throw new RuntimeException("Func9 expecting 9 arguments.");
    }
    return (R)val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5], paramVarArgs[6], paramVarArgs[7], paramVarArgs[8]);
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */