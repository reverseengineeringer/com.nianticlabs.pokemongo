package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class EmptyFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  public static final IOFileFilter EMPTY = new EmptyFileFilter();
  public static final IOFileFilter NOT_EMPTY = new NotFileFilter(EMPTY);
  
  public boolean accept(File paramFile)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        bool1 = bool2;
        if (paramFile.length != 0) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    if (paramFile.length() == 0L) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.EmptyFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */