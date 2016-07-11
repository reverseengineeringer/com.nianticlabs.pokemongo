package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.IOCase;

public class SuffixFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private final IOCase caseSensitivity;
  private final String[] suffixes;
  
  public SuffixFileFilter(String paramString)
  {
    this(paramString, IOCase.SENSITIVE);
  }
  
  public SuffixFileFilter(String paramString, IOCase paramIOCase)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("The suffix must not be null");
    }
    suffixes = new String[] { paramString };
    paramString = paramIOCase;
    if (paramIOCase == null) {
      paramString = IOCase.SENSITIVE;
    }
    caseSensitivity = paramString;
  }
  
  public SuffixFileFilter(List<String> paramList)
  {
    this(paramList, IOCase.SENSITIVE);
  }
  
  public SuffixFileFilter(List<String> paramList, IOCase paramIOCase)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("The list of suffixes must not be null");
    }
    suffixes = ((String[])paramList.toArray(new String[paramList.size()]));
    paramList = paramIOCase;
    if (paramIOCase == null) {
      paramList = IOCase.SENSITIVE;
    }
    caseSensitivity = paramList;
  }
  
  public SuffixFileFilter(String[] paramArrayOfString)
  {
    this(paramArrayOfString, IOCase.SENSITIVE);
  }
  
  public SuffixFileFilter(String[] paramArrayOfString, IOCase paramIOCase)
  {
    if (paramArrayOfString == null) {
      throw new IllegalArgumentException("The array of suffixes must not be null");
    }
    suffixes = new String[paramArrayOfString.length];
    System.arraycopy(paramArrayOfString, 0, suffixes, 0, paramArrayOfString.length);
    paramArrayOfString = paramIOCase;
    if (paramIOCase == null) {
      paramArrayOfString = IOCase.SENSITIVE;
    }
    caseSensitivity = paramArrayOfString;
  }
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    String[] arrayOfString = suffixes;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (caseSensitivity.checkEndsWith(paramFile, str)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    paramFile = suffixes;
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      String str = paramFile[i];
      if (caseSensitivity.checkEndsWith(paramString, str)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(");
    if (suffixes != null)
    {
      int i = 0;
      while (i < suffixes.length)
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(suffixes[i]);
        i += 1;
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.SuffixFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */