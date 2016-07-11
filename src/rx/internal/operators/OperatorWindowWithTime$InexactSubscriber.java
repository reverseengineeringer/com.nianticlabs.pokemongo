package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

final class OperatorWindowWithTime$InexactSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super Observable<T>> child;
  final List<OperatorWindowWithTime.CountedSerializedSubject<T>> chunks;
  boolean done;
  final Object guard;
  final Scheduler.Worker worker;
  
  public OperatorWindowWithTime$InexactSubscriber(Subscriber<? super Observable<T>> paramSubscriber, Scheduler.Worker paramWorker)
  {
    super(paramWorker);
    child = paramWorker;
    Scheduler.Worker localWorker;
    worker = localWorker;
    guard = new Object();
    chunks = new LinkedList();
  }
  
  OperatorWindowWithTime.CountedSerializedSubject<T> createCountedSerializedSubject()
  {
    BufferUntilSubscriber localBufferUntilSubscriber = BufferUntilSubscriber.create();
    return new OperatorWindowWithTime.CountedSerializedSubject(localBufferUntilSubscriber, localBufferUntilSubscriber);
  }
  
  public void onCompleted()
  {
    synchronized (guard)
    {
      if (done) {
        return;
      }
      done = true;
      ArrayList localArrayList = new ArrayList(chunks);
      chunks.clear();
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        nextconsumer.onCompleted();
      }
    }
    child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    synchronized (guard)
    {
      if (done) {
        return;
      }
      done = true;
      ArrayList localArrayList = new ArrayList(chunks);
      chunks.clear();
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        nextconsumer.onError(paramThrowable);
      }
    }
    child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    Object localObject2;
    synchronized (guard)
    {
      if (done) {
        return;
      }
      localObject2 = new ArrayList(chunks);
      Iterator localIterator = chunks.iterator();
      while (localIterator.hasNext())
      {
        OperatorWindowWithTime.CountedSerializedSubject localCountedSerializedSubject = (OperatorWindowWithTime.CountedSerializedSubject)localIterator.next();
        int i = count + 1;
        count = i;
        if (i == this$0.size) {
          localIterator.remove();
        }
      }
    }
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (OperatorWindowWithTime.CountedSerializedSubject)((Iterator)???).next();
      consumer.onNext(paramT);
      if (count == this$0.size) {
        consumer.onCompleted();
      }
    }
  }
  
  public void onStart()
  {
    request(Long.MAX_VALUE);
  }
  
  void scheduleChunk()
  {
    worker.schedulePeriodically(new Action0()
    {
      public void call()
      {
        startNewChunk();
      }
    }, this$0.timeshift, this$0.timeshift, this$0.unit);
  }
  
  void startNewChunk()
  {
    final OperatorWindowWithTime.CountedSerializedSubject localCountedSerializedSubject = createCountedSerializedSubject();
    synchronized (guard)
    {
      if (done) {
        return;
      }
      chunks.add(localCountedSerializedSubject);
    }
  }
  
  void terminateChunk(OperatorWindowWithTime.CountedSerializedSubject<T> paramCountedSerializedSubject)
  {
    int j = 0;
    synchronized (guard)
    {
      if (done) {
        return;
      }
      Iterator localIterator = chunks.iterator();
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
      } while ((OperatorWindowWithTime.CountedSerializedSubject)localIterator.next() != paramCountedSerializedSubject);
      int i = 1;
      localIterator.remove();
      if (i != 0)
      {
        consumer.onCompleted();
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.InexactSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */