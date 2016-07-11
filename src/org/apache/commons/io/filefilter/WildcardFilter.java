package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

@Deprecated
public class WildcardFilter
  extends AbstractFileFilter
  implements Serializable
{
  private final String[] wildcards;
  
  public WildcardFilter(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("The wildcard must not be null");
    }
    wildcards = new String[] { paramString };
  }
  
  public WildcardFilter(List<String> paramList)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("The wildcard list must not be null");
    }
    wildcards = ((String[])paramList.toArray(new String[paramList.size()]));
  }
  
  public WildcardFilter(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      throw new IllegalArgumentException("The wildcard array must not be null");
    }
    wildcards = new String[paramArrayOfString.length];
    System.arraycopy(paramArrayOfString, 0, wildcards, 0, paramArrayOfString.length);
  }
  
  public boolean accept(File paramFile)
  {
    if (paramFile.isDirectory()) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = wildcards;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (FilenameUtils.wildcardMatch(paramFile.getName(), str)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    if ((paramFile != null) && (new File(paramFile, paramString).isDirectory())) {}
    for (;;)
    {
      return false;
      paramFile = wildcards;
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        if (FilenameUtils.wildcardMatch(paramString, paramFile[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.WildcardFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */