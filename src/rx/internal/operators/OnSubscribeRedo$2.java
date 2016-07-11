package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.internal.producers.ProducerArbiter;
import rx.subjects.BehaviorSubject;
import rx.subscriptions.SerialSubscription;

class OnSubscribeRedo$2
  implements Action0
{
  OnSubscribeRedo$2(OnSubscribeRedo paramOnSubscribeRedo, Subscriber paramSubscriber, BehaviorSubject paramBehaviorSubject, ProducerArbiter paramProducerArbiter, AtomicLong paramAtomicLong, SerialSubscription paramSerialSubscription) {}
  
  public void call()
  {
    if (val$child.isUnsubscribed()) {
      return;
    }
    Subscriber local1 = new Subscriber()
    {
      boolean done;
      
      private void decrementConsumerCapacity()
      {
        long l;
        do
        {
          l = val$consumerCapacity.get();
        } while ((l != Long.MAX_VALUE) && (!val$consumerCapacity.compareAndSet(l, l - 1L)));
      }
      
      public void onCompleted()
      {
        if (!done)
        {
          done = true;
          unsubscribe();
          val$terminals.onNext(Notification.createOnCompleted());
        }
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        if (!done)
        {
          done = true;
          unsubscribe();
          val$terminals.onNext(Notification.createOnError(paramAnonymousThrowable));
        }
      }
      
      public void onNext(T paramAnonymousT)
      {
        if (!done)
        {
          val$child.onNext(paramAnonymousT);
          decrementConsumerCapacity();
          val$arbiter.produced(1L);
        }
      }
      
      public void setProducer(Producer paramAnonymousProducer)
      {
        val$arbiter.setProducer(paramAnonymousProducer);
      }
    };
    val$sourceSubscriptions.set(local1);
    OnSubscribeRedo.access$200(this$0).unsafeSubscribe(local1);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */