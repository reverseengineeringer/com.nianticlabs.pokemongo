package com.fasterxml.jackson.core.sym;

final class ByteQuadsCanonicalizer$TableInfo
{
  public final int count;
  public final int longNameOffset;
  public final int[] mainHash;
  public final String[] names;
  public final int size;
  public final int spilloverEnd;
  public final int tertiaryShift;
  
  public ByteQuadsCanonicalizer$TableInfo(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, String[] paramArrayOfString, int paramInt4, int paramInt5)
  {
    size = paramInt1;
    count = paramInt2;
    tertiaryShift = paramInt3;
    mainHash = paramArrayOfInt;
    names = paramArrayOfString;
    spilloverEnd = paramInt4;
    longNameOffset = paramInt5;
  }
  
  public ByteQuadsCanonicalizer$TableInfo(ByteQuadsCanonicalizer paramByteQuadsCanonicalizer)
  {
    size = _hashSize;
    count = _count;
    tertiaryShift = _tertiaryShift;
    mainHash = _hashArea;
    names = _names;
    spilloverEnd = _spilloverEnd;
    longNameOffset = _longNameOffset;
  }
  
  public static TableInfo createInitial(int paramInt)
  {
    int i = paramInt << 3;
    return new TableInfo(paramInt, 0, ByteQuadsCanonicalizer._calcTertiaryShift(paramInt), new int[i], new String[paramInt << 1], i - paramInt, i);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer.TableInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */