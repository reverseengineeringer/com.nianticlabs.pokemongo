package rx;

final class Single$4
  implements Single.OnSubscribe<T>
{
  Single$4(Object paramObject) {}
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    paramSingleSubscriber.onSuccess(val$value);
  }
}

/* Location:
 * Qualified Name:     rx.Single.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */