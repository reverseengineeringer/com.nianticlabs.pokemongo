package rx.functions;

public abstract interface Action2<T1, T2>
  extends Action
{
  public abstract void call(T1 paramT1, T2 paramT2);
}

/* Location:
 * Qualified Name:     rx.functions.Action2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */