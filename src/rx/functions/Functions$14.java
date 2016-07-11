package rx.functions;

final class Functions$14
  implements FuncN<Void>
{
  Functions$14(Action3 paramAction3) {}
  
  public Void call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 3) {
      throw new RuntimeException("Action3 expecting 3 arguments.");
    }
    val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
    return null;
  }
}

/* Location:
 * Qualified Name:     rx.functions.Functions.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */