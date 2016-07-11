package com.fasterxml.jackson.databind.util;

public final class LinkedNode<T>
{
  private LinkedNode<T> next;
  private final T value;
  
  public LinkedNode(T paramT, LinkedNode<T> paramLinkedNode)
  {
    value = paramT;
    next = paramLinkedNode;
  }
  
  public static <ST> boolean contains(LinkedNode<ST> paramLinkedNode, ST paramST)
  {
    while (paramLinkedNode != null)
    {
      if (paramLinkedNode.value() == paramST) {
        return true;
      }
      paramLinkedNode = paramLinkedNode.next();
    }
    return false;
  }
  
  public void linkNext(LinkedNode<T> paramLinkedNode)
  {
    if (next != null) {
      throw new IllegalStateException();
    }
    next = paramLinkedNode;
  }
  
  public LinkedNode<T> next()
  {
    return next;
  }
  
  public T value()
  {
    return (T)value;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.LinkedNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */