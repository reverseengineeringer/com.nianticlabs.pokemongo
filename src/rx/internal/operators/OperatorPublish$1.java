package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

final class OperatorPublish$1
  implements Observable.OnSubscribe<T>
{
  OperatorPublish$1(AtomicReference paramAtomicReference) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        localObject2 = (OperatorPublish.PublishSubscriber)val$curr.get();
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((OperatorPublish.PublishSubscriber)localObject2).isUnsubscribed()) {
            break;
          }
        }
        localObject1 = new OperatorPublish.PublishSubscriber(val$curr);
        ((OperatorPublish.PublishSubscriber)localObject1).init();
      } while (!val$curr.compareAndSet(localObject2, localObject1));
      localObject2 = new OperatorPublish.InnerProducer((OperatorPublish.PublishSubscriber)localObject1, paramSubscriber);
    } while (!((OperatorPublish.PublishSubscriber)localObject1).add((OperatorPublish.InnerProducer)localObject2));
    paramSubscriber.add((Subscription)localObject2);
    paramSubscriber.setProducer((Producer)localObject2);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorPublish.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */