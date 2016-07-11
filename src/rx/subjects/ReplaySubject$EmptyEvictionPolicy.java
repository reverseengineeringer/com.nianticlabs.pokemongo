package rx.subjects;

final class ReplaySubject$EmptyEvictionPolicy
  implements ReplaySubject.EvictionPolicy
{
  public void evict(ReplaySubject.NodeList<Object> paramNodeList) {}
  
  public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList) {}
  
  public boolean test(Object paramObject, long paramLong)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.EmptyEvictionPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */