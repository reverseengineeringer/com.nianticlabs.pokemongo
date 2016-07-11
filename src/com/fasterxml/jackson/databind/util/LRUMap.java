package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class LRUMap<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected transient int _jdkSerializeMaxEntries;
  protected final transient ConcurrentHashMap<K, V> _map;
  protected final transient int _maxEntries;
  
  public LRUMap(int paramInt1, int paramInt2)
  {
    _map = new ConcurrentHashMap(paramInt1, 0.8F, 4);
    _maxEntries = paramInt2;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    _jdkSerializeMaxEntries = paramObjectInputStream.readInt();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(_jdkSerializeMaxEntries);
  }
  
  public void clear()
  {
    _map.clear();
  }
  
  public V get(Object paramObject)
  {
    return (V)_map.get(paramObject);
  }
  
  public V put(K paramK, V paramV)
  {
    if (_map.size() >= _maxEntries) {}
    try
    {
      if (_map.size() >= _maxEntries) {
        clear();
      }
      return (V)_map.put(paramK, paramV);
    }
    finally {}
  }
  
  public V putIfAbsent(K paramK, V paramV)
  {
    if (_map.size() >= _maxEntries) {}
    try
    {
      if (_map.size() >= _maxEntries) {
        clear();
      }
      return (V)_map.putIfAbsent(paramK, paramV);
    }
    finally {}
  }
  
  protected Object readResolve()
  {
    return new LRUMap(_jdkSerializeMaxEntries, _jdkSerializeMaxEntries);
  }
  
  public int size()
  {
    return _map.size();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.LRUMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */