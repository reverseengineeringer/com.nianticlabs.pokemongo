package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

final class BufferUntilSubscriber$OnSubscribeAction<T>
  implements Observable.OnSubscribe<T>
{
  final BufferUntilSubscriber.State<T> state;
  
  public BufferUntilSubscriber$OnSubscribeAction(BufferUntilSubscriber.State<T> paramState)
  {
    state = paramState;
  }
  
  public void call(Subscriber<? super T> arg1)
  {
    if (state.casObserverRef(null, ???))
    {
      ???.add(Subscriptions.create(new Action0()
      {
        public void call()
        {
          state.observerRef = BufferUntilSubscriber.access$000();
        }
      }));
      int i = 0;
      for (;;)
      {
        synchronized (state.guard)
        {
          if (!state.emitting)
          {
            state.emitting = true;
            i = 1;
          }
          if (i == 0) {
            break;
          }
          ??? = NotificationLite.instance();
          Object localObject1 = state.buffer.poll();
          if (localObject1 != null) {
            ???.accept(state.observerRef, localObject1);
          }
        }
        synchronized (state.guard)
        {
          if (state.buffer.isEmpty())
          {
            state.emitting = false;
            return;
          }
        }
      }
    }
    ???.onError(new IllegalStateException("Only one subscriber allowed!"));
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BufferUntilSubscriber.OnSubscribeAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */