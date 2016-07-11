package rx;

public abstract interface Observer<T>
{
  public abstract void onCompleted();
  
  public abstract void onError(Throwable paramThrowable);
  
  public abstract void onNext(T paramT);
}

/* Location:
 * Qualified Name:     rx.Observer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */