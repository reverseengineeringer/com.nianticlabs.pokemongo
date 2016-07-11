package rx;

class Observable$ThrowObservable$1
  implements Observable.OnSubscribe<T>
{
  Observable$ThrowObservable$1(Throwable paramThrowable) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.onError(val$exception);
  }
}

/* Location:
 * Qualified Name:     rx.Observable.ThrowObservable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */