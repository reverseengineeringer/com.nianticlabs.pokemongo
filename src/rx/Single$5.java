package rx;

final class Single$5
  implements Single.OnSubscribe<T>
{
  Single$5(Single paramSingle) {}
  
  public void call(final SingleSubscriber<? super T> paramSingleSubscriber)
  {
    val$source.subscribe(new SingleSubscriber()
    {
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSingleSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onSuccess(Single<? extends T> paramAnonymousSingle)
      {
        paramAnonymousSingle.subscribe(paramSingleSubscriber);
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.Single.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */