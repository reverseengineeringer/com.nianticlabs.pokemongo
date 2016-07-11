package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

public class DirectoryWalker$CancelException
  extends IOException
{
  private static final long serialVersionUID = 1347339620135041008L;
  private final int depth;
  private final File file;
  
  public DirectoryWalker$CancelException(File paramFile, int paramInt)
  {
    this("Operation Cancelled", paramFile, paramInt);
  }
  
  public DirectoryWalker$CancelException(String paramString, File paramFile, int paramInt)
  {
    super(paramString);
    file = paramFile;
    depth = paramInt;
  }
  
  public int getDepth()
  {
    return depth;
  }
  
  public File getFile()
  {
    return file;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.DirectoryWalker.CancelException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */