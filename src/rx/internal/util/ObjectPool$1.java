package rx.internal.util;

import java.util.Queue;
import rx.functions.Action0;

class ObjectPool$1
  implements Action0
{
  ObjectPool$1(ObjectPool paramObjectPool, int paramInt1, int paramInt2) {}
  
  public void call()
  {
    int j = ObjectPool.access$000(this$0).size();
    int k;
    int i;
    if (j < val$min)
    {
      k = val$max;
      i = 0;
      while (i < k - j)
      {
        ObjectPool.access$000(this$0).add(this$0.createObject());
        i += 1;
      }
    }
    if (j > val$max)
    {
      k = val$max;
      i = 0;
      while (i < j - k)
      {
        ObjectPool.access$000(this$0).poll();
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.util.ObjectPool.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */