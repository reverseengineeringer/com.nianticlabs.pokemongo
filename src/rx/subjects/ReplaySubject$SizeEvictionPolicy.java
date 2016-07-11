package rx.subjects;

final class ReplaySubject$SizeEvictionPolicy
  implements ReplaySubject.EvictionPolicy
{
  final int maxSize;
  
  public ReplaySubject$SizeEvictionPolicy(int paramInt)
  {
    maxSize = paramInt;
  }
  
  public void evict(ReplaySubject.NodeList<Object> paramNodeList)
  {
    while (paramNodeList.size() > maxSize) {
      paramNodeList.removeFirst();
    }
  }
  
  public void evictFinal(ReplaySubject.NodeList<Object> paramNodeList)
  {
    while (paramNodeList.size() > maxSize + 1) {
      paramNodeList.removeFirst();
    }
  }
  
  public boolean test(Object paramObject, long paramLong)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.SizeEvictionPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */