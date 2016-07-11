package rx;

final class Single$3
  implements Single.OnSubscribe<T>
{
  Single$3(Throwable paramThrowable) {}
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    paramSingleSubscriber.onError(val$exception);
  }
}

/* Location:
 * Qualified Name:     rx.Single.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */