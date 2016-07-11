package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public class DefaultFileComparator
  extends AbstractFileComparator
  implements Serializable
{
  public static final Comparator<File> DEFAULT_COMPARATOR = new DefaultFileComparator();
  public static final Comparator<File> DEFAULT_REVERSE = new ReverseComparator(DEFAULT_COMPARATOR);
  
  public int compare(File paramFile1, File paramFile2)
  {
    return paramFile1.compareTo(paramFile2);
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.comparator.DefaultFileComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */