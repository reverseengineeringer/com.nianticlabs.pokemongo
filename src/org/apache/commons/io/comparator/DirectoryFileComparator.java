package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public class DirectoryFileComparator
  extends AbstractFileComparator
  implements Serializable
{
  public static final Comparator<File> DIRECTORY_COMPARATOR = new DirectoryFileComparator();
  public static final Comparator<File> DIRECTORY_REVERSE = new ReverseComparator(DIRECTORY_COMPARATOR);
  
  private int getType(File paramFile)
  {
    if (paramFile.isDirectory()) {
      return 1;
    }
    return 2;
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    return getType(paramFile1) - getType(paramFile2);
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.comparator.DirectoryFileComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */