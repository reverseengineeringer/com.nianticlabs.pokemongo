package org.apache.commons.io;

import java.io.File;
import java.io.IOException;

public class FileDeleteStrategy
{
  public static final FileDeleteStrategy FORCE = new ForceFileDeleteStrategy();
  public static final FileDeleteStrategy NORMAL = new FileDeleteStrategy("Normal");
  private final String name;
  
  protected FileDeleteStrategy(String paramString)
  {
    name = paramString;
  }
  
  public void delete(File paramFile)
    throws IOException
  {
    if ((paramFile.exists()) && (!doDelete(paramFile))) {
      throw new IOException("Deletion failed: " + paramFile);
    }
  }
  
  public boolean deleteQuietly(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return true;
    }
    try
    {
      boolean bool = doDelete(paramFile);
      return bool;
    }
    catch (IOException paramFile) {}
    return false;
  }
  
  protected boolean doDelete(File paramFile)
    throws IOException
  {
    return paramFile.delete();
  }
  
  public String toString()
  {
    return "FileDeleteStrategy[" + name + "]";
  }
  
  static class ForceFileDeleteStrategy
    extends FileDeleteStrategy
  {
    ForceFileDeleteStrategy()
    {
      super();
    }
    
    protected boolean doDelete(File paramFile)
      throws IOException
    {
      FileUtils.forceDelete(paramFile);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.FileDeleteStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */