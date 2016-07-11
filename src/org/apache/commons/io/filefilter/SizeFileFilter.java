package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class SizeFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private final boolean acceptLarger;
  private final long size;
  
  public SizeFileFilter(long paramLong)
  {
    this(paramLong, true);
  }
  
  public SizeFileFilter(long paramLong, boolean paramBoolean)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("The size must be non-negative");
    }
    size = paramLong;
    acceptLarger = paramBoolean;
  }
  
  public boolean accept(File paramFile)
  {
    boolean bool;
    if (paramFile.length() < size) {
      bool = true;
    }
    while (acceptLarger) {
      if (!bool)
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public String toString()
  {
    if (acceptLarger) {}
    for (String str = ">=";; str = "<") {
      return super.toString() + "(" + str + size + ")";
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.SizeFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */