package com.fasterxml.jackson.core.sym;

final class BytesToNameCanonicalizer$Bucket
{
  public final int hash;
  public final int length;
  public final Name name;
  public final Bucket next;
  
  BytesToNameCanonicalizer$Bucket(Name paramName, Bucket paramBucket)
  {
    name = paramName;
    next = paramBucket;
    if (paramBucket == null) {}
    for (int i = 1;; i = length + 1)
    {
      length = i;
      hash = paramName.hashCode();
      return;
    }
  }
  
  public Name find(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if ((hash == paramInt1) && (name.equals(paramInt2, paramInt3)))
    {
      localObject = name;
      return (Name)localObject;
    }
    for (Bucket localBucket = next;; localBucket = next)
    {
      if (localBucket == null) {
        break label80;
      }
      if (hash == paramInt1)
      {
        Name localName = name;
        localObject = localName;
        if (localName.equals(paramInt2, paramInt3)) {
          break;
        }
      }
    }
    label80:
    return null;
  }
  
  public Name find(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject;
    if ((hash == paramInt1) && (name.equals(paramInt2, paramInt3, paramInt4)))
    {
      localObject = name;
      return (Name)localObject;
    }
    for (Bucket localBucket = next;; localBucket = next)
    {
      if (localBucket == null) {
        break label84;
      }
      if (hash == paramInt1)
      {
        Name localName = name;
        localObject = localName;
        if (localName.equals(paramInt2, paramInt3, paramInt4)) {
          break;
        }
      }
    }
    label84:
    return null;
  }
  
  public Name find(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    Object localObject;
    if ((hash == paramInt1) && (name.equals(paramArrayOfInt, paramInt2)))
    {
      localObject = name;
      return (Name)localObject;
    }
    for (Bucket localBucket = next;; localBucket = next)
    {
      if (localBucket == null) {
        break label80;
      }
      if (hash == paramInt1)
      {
        Name localName = name;
        localObject = localName;
        if (localName.equals(paramArrayOfInt, paramInt2)) {
          break;
        }
      }
    }
    label80:
    return null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer.Bucket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */