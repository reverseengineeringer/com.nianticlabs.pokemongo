package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

public class ExtensionFileComparator
  extends AbstractFileComparator
  implements Serializable
{
  public static final Comparator<File> EXTENSION_COMPARATOR = new ExtensionFileComparator();
  public static final Comparator<File> EXTENSION_INSENSITIVE_COMPARATOR = new ExtensionFileComparator(IOCase.INSENSITIVE);
  public static final Comparator<File> EXTENSION_INSENSITIVE_REVERSE = new ReverseComparator(EXTENSION_INSENSITIVE_COMPARATOR);
  public static final Comparator<File> EXTENSION_REVERSE = new ReverseComparator(EXTENSION_COMPARATOR);
  public static final Comparator<File> EXTENSION_SYSTEM_COMPARATOR = new ExtensionFileComparator(IOCase.SYSTEM);
  public static final Comparator<File> EXTENSION_SYSTEM_REVERSE = new ReverseComparator(EXTENSION_SYSTEM_COMPARATOR);
  private final IOCase caseSensitivity;
  
  public ExtensionFileComparator()
  {
    caseSensitivity = IOCase.SENSITIVE;
  }
  
  public ExtensionFileComparator(IOCase paramIOCase)
  {
    IOCase localIOCase = paramIOCase;
    if (paramIOCase == null) {
      localIOCase = IOCase.SENSITIVE;
    }
    caseSensitivity = localIOCase;
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    paramFile1 = FilenameUtils.getExtension(paramFile1.getName());
    paramFile2 = FilenameUtils.getExtension(paramFile2.getName());
    return caseSensitivity.checkCompareTo(paramFile1, paramFile2);
  }
  
  public String toString()
  {
    return super.toString() + "[caseSensitivity=" + caseSensitivity + "]";
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.comparator.ExtensionFileComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */