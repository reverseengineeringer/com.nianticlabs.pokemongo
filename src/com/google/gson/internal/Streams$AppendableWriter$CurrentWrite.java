package com.google.gson.internal;

class Streams$AppendableWriter$CurrentWrite
  implements CharSequence
{
  char[] chars;
  
  public char charAt(int paramInt)
  {
    return chars[paramInt];
  }
  
  public int length()
  {
    return chars.length;
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return new String(chars, paramInt1, paramInt2 - paramInt1);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.Streams.AppendableWriter.CurrentWrite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */