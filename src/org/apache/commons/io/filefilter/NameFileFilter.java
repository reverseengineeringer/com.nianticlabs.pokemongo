package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.IOCase;

public class NameFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private final IOCase caseSensitivity;
  private final String[] names;
  
  public NameFileFilter(String paramString)
  {
    this(paramString, null);
  }
  
  public NameFileFilter(String paramString, IOCase paramIOCase)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("The wildcard must not be null");
    }
    names = new String[] { paramString };
    paramString = paramIOCase;
    if (paramIOCase == null) {
      paramString = IOCase.SENSITIVE;
    }
    caseSensitivity = paramString;
  }
  
  public NameFileFilter(List<String> paramList)
  {
    this(paramList, null);
  }
  
  public NameFileFilter(List<String> paramList, IOCase paramIOCase)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("The list of names must not be null");
    }
    names = ((String[])paramList.toArray(new String[paramList.size()]));
    paramList = paramIOCase;
    if (paramIOCase == null) {
      paramList = IOCase.SENSITIVE;
    }
    caseSensitivity = paramList;
  }
  
  public NameFileFilter(String[] paramArrayOfString)
  {
    this(paramArrayOfString, null);
  }
  
  public NameFileFilter(String[] paramArrayOfString, IOCase paramIOCase)
  {
    if (paramArrayOfString == null) {
      throw new IllegalArgumentException("The array of names must not be null");
    }
    names = new String[paramArrayOfString.length];
    System.arraycopy(paramArrayOfString, 0, names, 0, paramArrayOfString.length);
    paramArrayOfString = paramIOCase;
    if (paramIOCase == null) {
      paramArrayOfString = IOCase.SENSITIVE;
    }
    caseSensitivity = paramArrayOfString;
  }
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    String[] arrayOfString = names;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (caseSensitivity.checkEquals(paramFile, str)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    paramFile = names;
    int j = paramFile.length;
    int i = 0;
    while (i < j)
    {
      String str = paramFile[i];
      if (caseSensitivity.checkEquals(paramString, str)) {
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
    if (names != null)
    {
      int i = 0;
      while (i < names.length)
      {
        if (i > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(names[i]);
        i += 1;
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.NameFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */