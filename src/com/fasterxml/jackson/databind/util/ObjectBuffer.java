package com.fasterxml.jackson.databind.util;

import java.lang.reflect.Array;
import java.util.List;

public final class ObjectBuffer
{
  private static final int MAX_CHUNK = 262144;
  private static final int SMALL_CHUNK = 16384;
  private Object[] _freeBuffer;
  private LinkedNode<Object[]> _head;
  private int _size;
  private LinkedNode<Object[]> _tail;
  
  protected final void _copyTo(Object paramObject, int paramInt1, Object[] paramArrayOfObject, int paramInt2)
  {
    int i = 0;
    for (LinkedNode localLinkedNode = _head; localLinkedNode != null; localLinkedNode = localLinkedNode.next())
    {
      Object[] arrayOfObject = (Object[])localLinkedNode.value();
      int j = arrayOfObject.length;
      System.arraycopy(arrayOfObject, 0, paramObject, i, j);
      i += j;
    }
    System.arraycopy(paramArrayOfObject, 0, paramObject, i, paramInt2);
    paramInt2 = i + paramInt2;
    if (paramInt2 != paramInt1) {
      throw new IllegalStateException("Should have gotten " + paramInt1 + " entries, got " + paramInt2);
    }
  }
  
  protected void _reset()
  {
    if (_tail != null) {
      _freeBuffer = ((Object[])_tail.value());
    }
    _tail = null;
    _head = null;
    _size = 0;
  }
  
  public Object[] appendCompletedChunk(Object[] paramArrayOfObject)
  {
    LinkedNode localLinkedNode = new LinkedNode(paramArrayOfObject, null);
    int j;
    int i;
    if (_head == null)
    {
      _tail = localLinkedNode;
      _head = localLinkedNode;
      j = paramArrayOfObject.length;
      _size += j;
      if (j >= 16384) {
        break label77;
      }
      i = j + j;
    }
    for (;;)
    {
      return new Object[i];
      _tail.linkNext(localLinkedNode);
      _tail = localLinkedNode;
      break;
      label77:
      i = j;
      if (j < 262144) {
        i = j + (j >> 2);
      }
    }
  }
  
  public int bufferedSize()
  {
    return _size;
  }
  
  public void completeAndClearBuffer(Object[] paramArrayOfObject, int paramInt, List<Object> paramList)
  {
    for (LinkedNode localLinkedNode = _head; localLinkedNode != null; localLinkedNode = localLinkedNode.next())
    {
      Object[] arrayOfObject = (Object[])localLinkedNode.value();
      i = 0;
      int j = arrayOfObject.length;
      while (i < j)
      {
        paramList.add(arrayOfObject[i]);
        i += 1;
      }
    }
    int i = 0;
    while (i < paramInt)
    {
      paramList.add(paramArrayOfObject[i]);
      i += 1;
    }
  }
  
  public Object[] completeAndClearBuffer(Object[] paramArrayOfObject, int paramInt)
  {
    int i = paramInt + _size;
    Object[] arrayOfObject = new Object[i];
    _copyTo(arrayOfObject, i, paramArrayOfObject, paramInt);
    return arrayOfObject;
  }
  
  public <T> T[] completeAndClearBuffer(Object[] paramArrayOfObject, int paramInt, Class<T> paramClass)
  {
    int i = paramInt + _size;
    paramClass = (Object[])Array.newInstance(paramClass, i);
    _copyTo(paramClass, i, paramArrayOfObject, paramInt);
    _reset();
    return paramClass;
  }
  
  public int initialCapacity()
  {
    if (_freeBuffer == null) {
      return 0;
    }
    return _freeBuffer.length;
  }
  
  public Object[] resetAndStart()
  {
    _reset();
    if (_freeBuffer == null) {
      return new Object[12];
    }
    return _freeBuffer;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.ObjectBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */