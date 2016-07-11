package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;

public class WildcardFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private final IOCase caseSensitivity;
  private final String[] wildcards;
  
  public WildcardFileFilter(String paramString)
  {
    this(paramString, null);
  }
  
  public WildcardFileFilter(String paramString, IOCase paramIOCase)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("The wildcard must not be null");
    }
    wildcards = new String[] { paramString };
    paramString = paramIOCase;
    if (paramIOCase == null) {
      paramString = IOCase.SENSITIVE;
    }
    caseSensitivity = paramString;
  }
  
  public WildcardFileFilter(List<String> paramList)
  {
    this(paramList, null);
  }
  
  public WildcardFileFilter(List<String> paramList, IOCase paramIOCase)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("The wildcard list must not be null");
    }
    wildcards = ((String[])paramList.toArray(new String[paramList.size()]));
    paramList = paramIOCase;
    if (paramIOCase == null) {
      paramList = IOCase.SENSITIVE;
    }
    caseSensitivity = paramList;
  }
  
  public WildcardFileFilter(String[] paramArrayOfString)
  {
    this(paramArrayOfString, null);
  }
  
  public WildcardFileFilter(String[] paramArrayOfString, IOCase paramIOCase)
  {
    if (paramArrayOfString == null) {
      throw new IllegalArgumentException("The wildcard array must not be null");
    }
    wildcards = new String[paramArrayOfString.length];
    System.arraycopy(paramArrayOfString, 0, wildcards, 0, paramArrayOfString.length);
    paramArrayOfString = paramIOCase;
    if (paramIOCase == null) {
      paramArrayOfString = IOCase.SENSITIVE;
    }
    caseSensitivity = paramArrayOfString;
  }
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    String[] arrayOfString = wildcards;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (FilenameUtils.wildcardMatch(paramFile, arrayOfString[i], caseSensitivity)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    paramFile = wildcards;
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      if (FilenameUtils.wildcardMatch(paramString, paramFile[i], caseSensitivity)) {
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
    if (wildcards != null)
    {
      int i = 0;
      while (i < wildcards.length)
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(wildcards[i]);
        i += 1;
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.WildcardFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */