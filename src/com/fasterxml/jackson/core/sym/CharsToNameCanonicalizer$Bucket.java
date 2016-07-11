package com.fasterxml.jackson.core.sym;

final class CharsToNameCanonicalizer$Bucket
{
  public final int length;
  public final Bucket next;
  public final String symbol;
  
  public CharsToNameCanonicalizer$Bucket(String paramString, Bucket paramBucket)
  {
    symbol = paramString;
    next = paramBucket;
    if (paramBucket == null) {}
    for (int i = 1;; i = length + 1)
    {
      length = i;
      return;
    }
  }
  
  public String has(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (symbol.length() != paramInt2) {}
    int j;
    do
    {
      while (symbol.charAt(i) != paramArrayOfChar[(paramInt1 + i)])
      {
        return null;
        i = 0;
      }
      j = i + 1;
      int i = j;
    } while (j < paramInt2);
    return symbol;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer.Bucket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */