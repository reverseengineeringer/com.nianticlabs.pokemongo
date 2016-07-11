package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class TrueFileFilter
  implements IOFileFilter, Serializable
{
  public static final IOFileFilter INSTANCE = TRUE;
  public static final IOFileFilter TRUE = new TrueFileFilter();
  
  public boolean accept(File paramFile)
  {
    return true;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.TrueFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */