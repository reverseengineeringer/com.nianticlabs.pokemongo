package rx;

class Observable$NeverObservable<T>
  extends Observable<T>
{
  Observable$NeverObservable()
  {
    super(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super T> paramAnonymousSubscriber) {}
    });
  }
  
  static <T> NeverObservable<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  private static class Holder
  {
    static final Observable.NeverObservable<?> INSTANCE = new Observable.NeverObservable();
  }
}

/* Location:
 * Qualified Name:     rx.Observable.NeverObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */