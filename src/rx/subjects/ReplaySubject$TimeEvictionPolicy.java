package rx.subjects;

import rx.Scheduler;
import rx.schedulers.Timestamped;

final class ReplaySubject$TimeEvictionPolicy
  implements ReplaySubject.EvictionPolicy
{
  final long maxAgeMillis;
  final Scheduler scheduler;
  
  public ReplaySubject$TimeEvictionPolicy(long paramLong, Scheduler paramScheduler)
  {
    maxAgeMillis = paramLong;
    scheduler = paramScheduler;
  }
  
  public void evict(ReplaySubject.NodeList<Object> paramNodeList)
  {
    long l = scheduler.now();
    while ((!paramNodeList.isEmpty()) && (test(head.next.value, l))) {
      paramNodeList.removeFirst();
    }
  }
  
  public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList)
  {
    long l = scheduler.now();
    while ((size > 1) && (test(head.next.value, l))) {
      paramNodeList.removeFirst();
    }
  }
  
  public boolean test(Object paramObject, long paramLong)
  {
    return ((Timestamped)paramObject).getTimestampMillis() <= paramLong - maxAgeMillis;
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.TimeEvictionPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */