package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.io.IOCase;

public class NameFileComparator
  extends AbstractFileComparator
  implements Serializable
{
  public static final Comparator<File> NAME_COMPARATOR = new NameFileComparator();
  public static final Comparator<File> NAME_INSENSITIVE_COMPARATOR = new NameFileComparator(IOCase.INSENSITIVE);
  public static final Comparator<File> NAME_INSENSITIVE_REVERSE = new ReverseComparator(NAME_INSENSITIVE_COMPARATOR);
  public static final Comparator<File> NAME_REVERSE = new ReverseComparator(NAME_COMPARATOR);
  public static final Comparator<File> NAME_SYSTEM_COMPARATOR = new NameFileComparator(IOCase.SYSTEM);
  public static final Comparator<File> NAME_SYSTEM_REVERSE = new ReverseComparator(NAME_SYSTEM_COMPARATOR);
  private final IOCase caseSensitivity;
  
  public NameFileComparator()
  {
    caseSensitivity = IOCase.SENSITIVE;
  }
  
  public NameFileComparator(IOCase paramIOCase)
  {
    IOCase localIOCase = paramIOCase;
    if (paramIOCase == null) {
      localIOCase = IOCase.SENSITIVE;
    }
    caseSensitivity = localIOCase;
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    return caseSensitivity.checkCompareTo(paramFile1.getName(), paramFile2.getName());
  }
  
  public String toString()
  {
    return super.toString() + "[caseSensitivity=" + caseSensitivity + "]";
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.comparator.NameFileComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */