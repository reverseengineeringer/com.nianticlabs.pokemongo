package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class AgeFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private final boolean acceptOlder;
  private final long cutoff;
  
  public AgeFileFilter(long paramLong)
  {
    this(paramLong, true);
  }
  
  public AgeFileFilter(long paramLong, boolean paramBoolean)
  {
    acceptOlder = paramBoolean;
    cutoff = paramLong;
  }
  
  public AgeFileFilter(File paramFile)
  {
    this(paramFile, true);
  }
  
  public AgeFileFilter(File paramFile, boolean paramBoolean)
  {
    this(paramFile.lastModified(), paramBoolean);
  }
  
  public AgeFileFilter(Date paramDate)
  {
    this(paramDate, true);
  }
  
  public AgeFileFilter(Date paramDate, boolean paramBoolean)
  {
    this(paramDate.getTime(), paramBoolean);
  }
  
  public boolean accept(File paramFile)
  {
    boolean bool2 = FileUtils.isFileNewer(paramFile, cutoff);
    boolean bool1 = bool2;
    if (acceptOlder)
    {
      if (!bool2) {
        bool1 = true;
      }
    }
    else {
      return bool1;
    }
    return false;
  }
  
  public String toString()
  {
    if (acceptOlder) {}
    for (String str = "<=";; str = ">") {
      return super.toString() + "(" + str + cutoff + ")";
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.AgeFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */