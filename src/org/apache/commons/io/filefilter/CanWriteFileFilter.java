package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class CanWriteFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  public static final IOFileFilter CANNOT_WRITE = new NotFileFilter(CAN_WRITE);
  public static final IOFileFilter CAN_WRITE = new CanWriteFileFilter();
  
  public boolean accept(File paramFile)
  {
    return paramFile.canWrite();
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.CanWriteFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */