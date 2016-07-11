package rx.internal.operators;

import rx.Notification;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;

class OnSubscribeRedo$3
  implements Observable.Operator<Notification<?>, Notification<?>>
{
  OnSubscribeRedo$3(OnSubscribeRedo paramOnSubscribeRedo) {}
  
  public Subscriber<? super Notification<?>> call(final Subscriber<? super Notification<?>> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      public void onCompleted()
      {
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(Notification<?> paramAnonymousNotification)
      {
        if ((paramAnonymousNotification.isOnCompleted()) && (OnSubscribeRedo.access$300(this$0)))
        {
          paramSubscriber.onCompleted();
          return;
        }
        if ((paramAnonymousNotification.isOnError()) && (OnSubscribeRedo.access$400(this$0)))
        {
          paramSubscriber.onError(paramAnonymousNotification.getThrowable());
          return;
        }
        paramSubscriber.onNext(paramAnonymousNotification);
      }
      
      public void setProducer(Producer paramAnonymousProducer)
      {
        paramAnonymousProducer.request(Long.MAX_VALUE);
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */