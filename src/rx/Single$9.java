package rx;

class Single$9
  extends Subscriber<T>
{
  Single$9(Single paramSingle, SingleSubscriber paramSingleSubscriber) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    val$te.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    val$te.onSuccess(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.Single.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */