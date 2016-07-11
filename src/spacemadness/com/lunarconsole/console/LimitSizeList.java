package spacemadness.com.lunarconsole.console;

import java.util.Iterator;
import spacemadness.com.lunarconsole.utils.CycleArray;

public class LimitSizeList<T>
  implements Iterable<T>
{
  private final CycleArray<T> internalArray;
  private final int trimSize;
  
  public LimitSizeList(Class<? extends T> paramClass, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Illegal capacity: " + paramInt1);
    }
    internalArray = new CycleArray(paramClass, paramInt1);
    trimSize = paramInt2;
  }
  
  public void addObject(T paramT)
  {
    if (willOverflow()) {
      trimHead(trimSize);
    }
    internalArray.add(paramT);
  }
  
  public int capacity()
  {
    return internalArray.getCapacity();
  }
  
  public void clear()
  {
    internalArray.clear();
  }
  
  public int count()
  {
    return internalArray.realLength();
  }
  
  public int getTrimSize()
  {
    return trimSize;
  }
  
  public boolean isOverfloating()
  {
    return (internalArray.getHeadIndex() > 0) && (willOverflow());
  }
  
  public boolean isTrimmed()
  {
    return trimmedCount() > 0;
  }
  
  public Iterator<T> iterator()
  {
    return internalArray.iterator();
  }
  
  public T objectAtIndex(int paramInt)
  {
    return (T)internalArray.get(internalArray.getHeadIndex() + paramInt);
  }
  
  public int overflowCount()
  {
    return internalArray.getHeadIndex();
  }
  
  public int totalCount()
  {
    return internalArray.length();
  }
  
  public void trimHead(int paramInt)
  {
    internalArray.trimHeadIndex(paramInt);
  }
  
  public int trimmedCount()
  {
    return totalCount() - count();
  }
  
  public boolean willOverflow()
  {
    return internalArray.realLength() == internalArray.getCapacity();
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.LimitSizeList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */