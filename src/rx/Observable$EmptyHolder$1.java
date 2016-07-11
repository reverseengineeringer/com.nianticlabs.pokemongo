package rx;

final class Observable$EmptyHolder$1
  implements Observable.OnSubscribe<Object>
{
  public void call(Subscriber<? super Object> paramSubscriber)
  {
    paramSubscriber.onCompleted();
  }
}

/* Location:
 * Qualified Name:     rx.Observable.EmptyHolder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */