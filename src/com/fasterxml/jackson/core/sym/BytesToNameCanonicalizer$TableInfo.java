package com.fasterxml.jackson.core.sym;

final class BytesToNameCanonicalizer$TableInfo
{
  public final int collCount;
  public final int collEnd;
  public final BytesToNameCanonicalizer.Bucket[] collList;
  public final int count;
  public final int longestCollisionList;
  public final int[] mainHash;
  public final int mainHashMask;
  public final Name[] mainNames;
  
  public BytesToNameCanonicalizer$TableInfo(int paramInt1, int paramInt2, int[] paramArrayOfInt, Name[] paramArrayOfName, BytesToNameCanonicalizer.Bucket[] paramArrayOfBucket, int paramInt3, int paramInt4, int paramInt5)
  {
    count = paramInt1;
    mainHashMask = paramInt2;
    mainHash = paramArrayOfInt;
    mainNames = paramArrayOfName;
    collList = paramArrayOfBucket;
    collCount = paramInt3;
    collEnd = paramInt4;
    longestCollisionList = paramInt5;
  }
  
  public BytesToNameCanonicalizer$TableInfo(BytesToNameCanonicalizer paramBytesToNameCanonicalizer)
  {
    count = _count;
    mainHashMask = _hashMask;
    mainHash = _hash;
    mainNames = _mainNames;
    collList = _collList;
    collCount = _collCount;
    collEnd = _collEnd;
    longestCollisionList = _longestCollisionList;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer.TableInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */