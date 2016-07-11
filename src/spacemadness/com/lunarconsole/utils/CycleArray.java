package spacemadness.com.lunarconsole.utils;

import java.lang.reflect.Array;
import java.util.Iterator;

public class CycleArray<E>
  implements Iterable<E>
{
  private final Class<? extends E> componentType;
  private int headIndex;
  private E[] internalArray;
  private int length;
  
  public CycleArray(Class<? extends E> paramClass, int paramInt)
  {
    if (paramClass == null) {
      throw new NullPointerException("Component type is null");
    }
    componentType = paramClass;
    internalArray = ((Object[])Array.newInstance(paramClass, paramInt));
  }
  
  private int toArrayIndex(E[] paramArrayOfE, int paramInt)
  {
    return paramInt % paramArrayOfE.length;
  }
  
  public E add(E paramE)
  {
    int i = toArrayIndex(length);
    Object localObject = internalArray[i];
    internalArray[i] = paramE;
    length += 1;
    if (length - headIndex > internalArray.length)
    {
      headIndex += 1;
      return (E)localObject;
    }
    return null;
  }
  
  public void clear()
  {
    int i = 0;
    while (i < internalArray.length)
    {
      internalArray[i] = null;
      i += 1;
    }
    length = 0;
    headIndex = 0;
  }
  
  public boolean contains(Object paramObject)
  {
    int i = headIndex;
    while (i < length)
    {
      int j = toArrayIndex(i);
      if (ObjectUtils.areEqual(internalArray[j], paramObject)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public E get(int paramInt)
  {
    paramInt = toArrayIndex(paramInt);
    return (E)internalArray[paramInt];
  }
  
  public int getCapacity()
  {
    return internalArray.length;
  }
  
  public int getHeadIndex()
  {
    return headIndex;
  }
  
  public E[] internalArray()
  {
    return internalArray;
  }
  
  public boolean isValidIndex(int paramInt)
  {
    return (paramInt >= headIndex) && (paramInt < length);
  }
  
  public Iterator<E> iterator()
  {
    return new CycleIterator();
  }
  
  public int length()
  {
    return length;
  }
  
  public int realLength()
  {
    return length - headIndex;
  }
  
  public void set(int paramInt, E paramE)
  {
    paramInt = toArrayIndex(paramInt);
    internalArray[paramInt] = paramE;
  }
  
  public void setCapacity(int paramInt)
  {
    if (paramInt > getCapacity())
    {
      arrayOfObject = (Object[])Array.newInstance(componentType, paramInt);
      j = realLength();
      i = toArrayIndex(internalArray, headIndex);
      for (paramInt = toArrayIndex(arrayOfObject, headIndex); j > 0; paramInt = toArrayIndex(arrayOfObject, paramInt + k))
      {
        k = Math.min(j, Math.min(internalArray.length - i, arrayOfObject.length - paramInt));
        System.arraycopy(internalArray, i, arrayOfObject, paramInt, k);
        j -= k;
        i = toArrayIndex(internalArray, i + k);
      }
      internalArray = arrayOfObject;
    }
    while (paramInt >= getCapacity())
    {
      Object[] arrayOfObject;
      int j;
      int i;
      int k;
      return;
    }
    throw new NotImplementedException();
  }
  
  public int toArrayIndex(int paramInt)
  {
    return paramInt % internalArray.length;
  }
  
  public void trimHeadIndex(int paramInt)
  {
    trimToHeadIndex(headIndex + paramInt);
  }
  
  public void trimLength(int paramInt)
  {
    trimToLength(length - paramInt);
  }
  
  public void trimToHeadIndex(int paramInt)
  {
    if ((paramInt < headIndex) || (paramInt > length)) {
      throw new IllegalArgumentException("Trimmed head index " + paramInt + " should be between head index " + headIndex + " and length " + length);
    }
    headIndex = paramInt;
  }
  
  public void trimToLength(int paramInt)
  {
    if ((paramInt < headIndex) || (paramInt > length)) {
      throw new IllegalArgumentException("Trimmed length " + paramInt + " should be between head index " + headIndex + " and length " + length);
    }
    length = paramInt;
  }
  
  private class CycleIterator
    implements Iterator<E>
  {
    private int index = getHeadIndex();
    
    public CycleIterator() {}
    
    public boolean hasNext()
    {
      return index < length();
    }
    
    public E next()
    {
      CycleArray localCycleArray = CycleArray.this;
      int i = index;
      index = (i + 1);
      return (E)localCycleArray.get(i);
    }
    
    public void remove()
    {
      throw new NotImplementedException();
    }
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.utils.CycleArray
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */