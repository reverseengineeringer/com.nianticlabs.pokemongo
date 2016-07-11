package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class FileFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  public static final IOFileFilter FILE = new FileFileFilter();
  
  public boolean accept(File paramFile)
  {
    return paramFile.isFile();
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.FileFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */