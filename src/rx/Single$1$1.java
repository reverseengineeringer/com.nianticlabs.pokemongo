package rx;

import rx.internal.producers.SingleDelayedProducer;

class Single$1$1
  extends SingleSubscriber<T>
{
  Single$1$1(Single.1 param1, SingleDelayedProducer paramSingleDelayedProducer, Subscriber paramSubscriber) {}
  
  public void onError(Throwable paramThrowable)
  {
    val$child.onError(paramThrowable);
  }
  
  public void onSuccess(T paramT)
  {
    val$producer.setValue(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.Single.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */