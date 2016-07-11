package rx.subjects;

abstract interface ReplaySubject$EvictionPolicy
{
  public abstract void evict(ReplaySubject.NodeList<Object> paramNodeList);
  
  public abstract void evictFinal(ReplaySubject.NodeList<Object> paramNodeList);
  
  public abstract boolean test(Object paramObject, long paramLong);
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.EvictionPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */