package com.fasterxml.jackson.databind.util;

final class PrimitiveArrayBuilder$Node<T>
{
  final T _data;
  final int _dataLength;
  Node<T> _next;
  
  public PrimitiveArrayBuilder$Node(T paramT, int paramInt)
  {
    _data = paramT;
    _dataLength = paramInt;
  }
  
  public int copyData(T paramT, int paramInt)
  {
    System.arraycopy(_data, 0, paramT, paramInt, _dataLength);
    return paramInt + _dataLength;
  }
  
  public T getData()
  {
    return (T)_data;
  }
  
  public void linkNext(Node<T> paramNode)
  {
    if (_next != null) {
      throw new IllegalStateException();
    }
    _next = paramNode;
  }
  
  public Node<T> next()
  {
    return _next;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.PrimitiveArrayBuilder.Node
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */