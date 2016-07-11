package com.fasterxml.jackson.databind.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T>
  implements Iterator<T>, Iterable<T>
{
  private final T[] _a;
  private int _index;
  
  public ArrayIterator(T[] paramArrayOfT)
  {
    _a = paramArrayOfT;
    _index = 0;
  }
  
  public boolean hasNext()
  {
    return _index < _a.length;
  }
  
  public Iterator<T> iterator()
  {
    return this;
  }
  
  public T next()
  {
    if (_index >= _a.length) {
      throw new NoSuchElementException();
    }
    Object[] arrayOfObject = _a;
    int i = _index;
    _index = (i + 1);
    return (T)arrayOfObject[i];
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.ArrayIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */