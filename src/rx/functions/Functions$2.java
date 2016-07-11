package rx.functions;

final class Functions$2
  implements FuncN<R>
{
  Functions$2(Func1 paramFunc1) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 1) {
      throw new RuntimeException("Func1 expecting 1 argument.");
    }
    return (R)val$f.call(paramVarArgs[0]);
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */