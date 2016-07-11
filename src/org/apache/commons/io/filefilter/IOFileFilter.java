package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public abstract interface IOFileFilter
  extends FileFilter, FilenameFilter
{
  public abstract boolean accept(File paramFile);
  
  public abstract boolean accept(File paramFile, String paramString);
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.IOFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */