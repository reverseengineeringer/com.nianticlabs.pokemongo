package rx.functions;

final class Functions$11
  implements FuncN<Void>
{
  Functions$11(Action0 paramAction0) {}
  
  public Void call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 0) {
      throw new RuntimeException("Action0 expecting 0 arguments.");
    }
    val$f.call();
    return null;
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */