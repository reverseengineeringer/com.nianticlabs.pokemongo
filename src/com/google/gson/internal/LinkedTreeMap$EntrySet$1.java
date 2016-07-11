package com.google.gson.internal;

import java.util.Map.Entry;

class LinkedTreeMap$EntrySet$1
  extends LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>
{
  LinkedTreeMap$EntrySet$1(LinkedTreeMap.EntrySet paramEntrySet)
  {
    super(this$0, null);
  }
  
  public Map.Entry<K, V> next()
  {
    return nextNode();
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.LinkedTreeMap.EntrySet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */