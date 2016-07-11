package rx.subjects;

final class ReplaySubject$PairEvictionPolicy
  implements ReplaySubject.EvictionPolicy
{
  final ReplaySubject.EvictionPolicy first;
  final ReplaySubject.EvictionPolicy second;
  
  public ReplaySubject$PairEvictionPolicy(ReplaySubject.EvictionPolicy paramEvictionPolicy1, ReplaySubject.EvictionPolicy paramEvictionPolicy2)
  {
    first = paramEvictionPolicy1;
    second = paramEvictionPolicy2;
  }
  
  public void evict(ReplaySubject.NodeList<Object> paramNodeList)
  {
    first.evict(paramNodeList);
    second.evict(paramNodeList);
  }
  
  public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList)
  {
    first.evictFinal(paramNodeList);
    second.evictFinal(paramNodeList);
  }
  
  public boolean test(Object paramObject, long paramLong)
  {
    return (first.test(paramObject, paramLong)) || (second.test(paramObject, paramLong));
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.PairEvictionPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */