package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.Serializable;

public class DelegateFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private final FileFilter fileFilter;
  private final FilenameFilter filenameFilter;
  
  public DelegateFileFilter(FileFilter paramFileFilter)
  {
    if (paramFileFilter == null) {
      throw new IllegalArgumentException("The FileFilter must not be null");
    }
    fileFilter = paramFileFilter;
    filenameFilter = null;
  }
  
  public DelegateFileFilter(FilenameFilter paramFilenameFilter)
  {
    if (paramFilenameFilter == null) {
      throw new IllegalArgumentException("The FilenameFilter must not be null");
    }
    filenameFilter = paramFilenameFilter;
    fileFilter = null;
  }
  
  public boolean accept(File paramFile)
  {
    if (fileFilter != null) {
      return fileFilter.accept(paramFile);
    }
    return super.accept(paramFile);
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    if (filenameFilter != null) {
      return filenameFilter.accept(paramFile, paramString);
    }
    return super.accept(paramFile, paramString);
  }
  
  public String toString()
  {
    if (fileFilter != null) {}
    for (String str = fileFilter.toString();; str = filenameFilter.toString()) {
      return super.toString() + "(" + str + ")";
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.DelegateFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */