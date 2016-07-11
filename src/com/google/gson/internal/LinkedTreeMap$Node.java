package com.google.gson.internal;

import java.util.Map.Entry;

final class LinkedTreeMap$Node<K, V>
  implements Map.Entry<K, V>
{
  int height;
  final K key;
  Node<K, V> left;
  Node<K, V> next;
  Node<K, V> parent;
  Node<K, V> prev;
  Node<K, V> right;
  V value;
  
  LinkedTreeMap$Node()
  {
    key = null;
    prev = this;
    next = this;
  }
  
  LinkedTreeMap$Node(Node<K, V> paramNode1, K paramK, Node<K, V> paramNode2, Node<K, V> paramNode3)
  {
    parent = paramNode1;
    key = paramK;
    height = 1;
    next = paramNode2;
    prev = paramNode3;
    next = this;
    prev = this;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Map.Entry))
    {
      paramObject = (Map.Entry)paramObject;
      if (key != null) {
        break label56;
      }
      bool1 = bool2;
      if (((Map.Entry)paramObject).getKey() == null)
      {
        if (value != null) {
          break label77;
        }
        bool1 = bool2;
        if (((Map.Entry)paramObject).getValue() != null) {}
      }
    }
    for (;;)
    {
      bool1 = true;
      label56:
      label77:
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!key.equals(((Map.Entry)paramObject).getKey()));
        break;
        bool1 = bool2;
      } while (!value.equals(((Map.Entry)paramObject).getValue()));
    }
  }
  
  public Node<K, V> first()
  {
    Object localObject = this;
    for (Node localNode = left; localNode != null; localNode = left) {
      localObject = localNode;
    }
    return (Node<K, V>)localObject;
  }
  
  public K getKey()
  {
    return (K)key;
  }
  
  public V getValue()
  {
    return (V)value;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (key == null)
    {
      i = 0;
      if (value != null) {
        break label33;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = key.hashCode();
      break;
      label33:
      j = value.hashCode();
    }
  }
  
  public Node<K, V> last()
  {
    Object localObject = this;
    for (Node localNode = right; localNode != null; localNode = right) {
      localObject = localNode;
    }
    return (Node<K, V>)localObject;
  }
  
  public V setValue(V paramV)
  {
    Object localObject = value;
    value = paramV;
    return (V)localObject;
  }
  
  public String toString()
  {
    return key + "=" + value;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.LinkedTreeMap.Node
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */