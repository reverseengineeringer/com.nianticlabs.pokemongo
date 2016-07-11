package rx;

final class Observable$EmptyHolder
{
  static final Observable<Object> INSTANCE = Observable.create(new Observable.OnSubscribe()
  {
    public void call(Subscriber<? super Object> paramAnonymousSubscriber)
    {
      paramAnonymousSubscriber.onCompleted();
    }
  });
}

/* Location:
 * Qualified Name:     rx.Observable.EmptyHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */