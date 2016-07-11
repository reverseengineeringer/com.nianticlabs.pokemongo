package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public class LastModifiedFileComparator
  extends AbstractFileComparator
  implements Serializable
{
  public static final Comparator<File> LASTMODIFIED_COMPARATOR = new LastModifiedFileComparator();
  public static final Comparator<File> LASTMODIFIED_REVERSE = new ReverseComparator(LASTMODIFIED_COMPARATOR);
  
  public int compare(File paramFile1, File paramFile2)
  {
    long l = paramFile1.lastModified() - paramFile2.lastModified();
    if (l < 0L) {
      return -1;
    }
    if (l > 0L) {
      return 1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.comparator.LastModifiedFileComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */