package rx;

import rx.internal.producers.SingleDelayedProducer;

class Single$1
  implements Observable.OnSubscribe<T>
{
  Single$1(Single paramSingle, Single.OnSubscribe paramOnSubscribe) {}
  
  public void call(final Subscriber<? super T> paramSubscriber)
  {
    final Object localObject = new SingleDelayedProducer(paramSubscriber);
    paramSubscriber.setProducer((Producer)localObject);
    localObject = new SingleSubscriber()
    {
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onSuccess(T paramAnonymousT)
      {
        localObject.setValue(paramAnonymousT);
      }
    };
    paramSubscriber.add((Subscription)localObject);
    val$f.call(localObject);
  }
}

/* Location:
 * Qualified Name:     rx.Single.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */