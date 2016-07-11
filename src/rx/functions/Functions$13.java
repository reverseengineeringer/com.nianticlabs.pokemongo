package rx.functions;

final class Functions$13
  implements FuncN<Void>
{
  Functions$13(Action2 paramAction2) {}
  
  public Void call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 2) {
      throw new RuntimeException("Action3 expecting 2 arguments.");
    }
    val$f.call(paramVarArgs[0], paramVarArgs[1]);
    return null;
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */