package rx.functions;

final class Functions$12
  implements FuncN<Void>
{
  Functions$12(Action1 paramAction1) {}
  
  public Void call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 1) {
      throw new RuntimeException("Action1 expecting 1 argument.");
    }
    val$f.call(paramVarArgs[0]);
    return null;
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */