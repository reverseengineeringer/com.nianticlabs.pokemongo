package rx.observables;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.internal.operators.BackpressureUtils;

final class AbstractOnSubscribe$SubscriptionProducer<T, S>
  implements Producer
{
  final AbstractOnSubscribe.SubscriptionState<T, S> state;
  
  private AbstractOnSubscribe$SubscriptionProducer(AbstractOnSubscribe.SubscriptionState<T, S> paramSubscriptionState)
  {
    state = paramSubscriptionState;
  }
  
  protected boolean doNext()
  {
    if (state.use()) {}
    try
    {
      int i = state.phase();
      AbstractOnSubscribe.SubscriptionState.access$600(state).next(state);
      if (!state.verify()) {
        throw new IllegalStateException("No event produced or stop called @ Phase: " + i + " -> " + state.phase() + ", Calls: " + state.calls());
      }
    }
    catch (Throwable localThrowable)
    {
      state.terminate();
      AbstractOnSubscribe.SubscriptionState.access$500(state).onError(localThrowable);
      return false;
      if ((state.accept()) || (state.stopRequested()))
      {
        state.terminate();
        return false;
      }
      AbstractOnSubscribe.SubscriptionState.access$708(state);
      return true;
    }
    finally
    {
      state.free();
    }
  }
  
  public void request(long paramLong)
  {
    if ((paramLong > 0L) && (BackpressureUtils.getAndAddRequest(AbstractOnSubscribe.SubscriptionState.access$400(state), paramLong) == 0L))
    {
      if (paramLong != Long.MAX_VALUE) {
        break label51;
      }
      while ((!AbstractOnSubscribe.SubscriptionState.access$500(state).isUnsubscribed()) && (doNext())) {}
    }
    label51:
    do
    {
      do
      {
        return;
        while (AbstractOnSubscribe.SubscriptionState.access$500(state).isUnsubscribed()) {}
      } while ((!doNext()) || (AbstractOnSubscribe.SubscriptionState.access$400(state).decrementAndGet() <= 0L));
    } while (!AbstractOnSubscribe.SubscriptionState.access$500(state).isUnsubscribed());
  }
}

/* Location:
 * Qualified Name:     rx.observables.AbstractOnSubscribe.SubscriptionProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */