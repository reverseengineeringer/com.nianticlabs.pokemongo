package rx.internal.operators;

import java.util.Queue;
import rx.Subscriber;
import rx.internal.util.RxRingBuffer;

final class OperatorMerge$InnerSubscriber<T>
  extends Subscriber<T>
{
  static final int limit = RxRingBuffer.SIZE / 4;
  volatile boolean done;
  final long id;
  int outstanding;
  final OperatorMerge.MergeSubscriber<T> parent;
  volatile RxRingBuffer queue;
  
  public OperatorMerge$InnerSubscriber(OperatorMerge.MergeSubscriber<T> paramMergeSubscriber, long paramLong)
  {
    parent = paramMergeSubscriber;
    id = paramLong;
  }
  
  public void onCompleted()
  {
    done = true;
    parent.emit();
  }
  
  public void onError(Throwable paramThrowable)
  {
    done = true;
    parent.getOrCreateErrorQueue().offer(paramThrowable);
    parent.emit();
  }
  
  public void onNext(T paramT)
  {
    parent.tryEmit(this, paramT);
  }
  
  public void onStart()
  {
    outstanding = RxRingBuffer.SIZE;
    request(RxRingBuffer.SIZE);
  }
  
  public void requestMore(long paramLong)
  {
    int i = outstanding - (int)paramLong;
    if (i > limit) {
      outstanding = i;
    }
    do
    {
      return;
      outstanding = RxRingBuffer.SIZE;
      i = RxRingBuffer.SIZE - i;
    } while (i <= 0);
    request(i);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorMerge.InnerSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */