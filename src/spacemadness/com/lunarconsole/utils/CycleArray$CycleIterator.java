package spacemadness.com.lunarconsole.utils;

import java.util.Iterator;

class CycleArray$CycleIterator
  implements Iterator<E>
{
  private int index;
  
  public CycleArray$CycleIterator(CycleArray paramCycleArray)
  {
    index = paramCycleArray.getHeadIndex();
  }
  
  public boolean hasNext()
  {
    return index < this$0.length();
  }
  
  public E next()
  {
    CycleArray localCycleArray = this$0;
    int i = index;
    index = (i + 1);
    return (E)localCycleArray.get(i);
  }
  
  public void remove()
  {
    throw new NotImplementedException();
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.utils.CycleArray.CycleIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */