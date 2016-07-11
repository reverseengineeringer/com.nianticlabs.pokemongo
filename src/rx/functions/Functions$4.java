package rx.functions;

final class Functions$4
  implements FuncN<R>
{
  Functions$4(Func3 paramFunc3) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 3) {
      throw new RuntimeException("Func3 expecting 3 arguments.");
    }
    return (R)val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */