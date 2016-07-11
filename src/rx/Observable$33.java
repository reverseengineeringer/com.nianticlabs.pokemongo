package rx;

class Observable$33
  extends Subscriber<T>
{
  Observable$33(Observable paramObservable, Observer paramObserver) {}
  
  public void onCompleted()
  {
    val$observer.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    val$observer.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    val$observer.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.33
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */