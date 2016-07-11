package android.support.v4.content;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class FileProvider$SimplePathStrategy
  implements FileProvider.PathStrategy
{
  private final String mAuthority;
  private final HashMap<String, File> mRoots = new HashMap();
  
  public FileProvider$SimplePathStrategy(String paramString)
  {
    mAuthority = paramString;
  }
  
  public void addRoot(String paramString, File paramFile)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Name must not be empty");
    }
    try
    {
      File localFile = paramFile.getCanonicalFile();
      mRoots.put(paramString, localFile);
      return;
    }
    catch (IOException paramString)
    {
      throw new IllegalArgumentException("Failed to resolve canonical path for " + paramFile, paramString);
    }
  }
  
  public File getFileForUri(Uri paramUri)
  {
    Object localObject2 = paramUri.getEncodedPath();
    int i = ((String)localObject2).indexOf('/', 1);
    Object localObject1 = Uri.decode(((String)localObject2).substring(1, i));
    localObject2 = Uri.decode(((String)localObject2).substring(i + 1));
    localObject1 = (File)mRoots.get(localObject1);
    if (localObject1 == null) {
      throw new IllegalArgumentException("Unable to find configured root for " + paramUri);
    }
    paramUri = new File((File)localObject1, (String)localObject2);
    try
    {
      localObject2 = paramUri.getCanonicalFile();
      if (!((File)localObject2).getPath().startsWith(((File)localObject1).getPath())) {
        throw new SecurityException("Resolved path jumped beyond configured root");
      }
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Failed to resolve canonical path for " + paramUri);
    }
    return (File)localObject2;
  }
  
  public Uri getUriForFile(File paramFile)
  {
    String str2;
    try
    {
      str2 = paramFile.getCanonicalPath();
      paramFile = null;
      Iterator localIterator = mRoots.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str3 = ((File)localEntry.getValue()).getPath();
        if ((str2.startsWith(str3)) && ((paramFile == null) || (str3.length() > ((File)paramFile.getValue()).getPath().length()))) {
          paramFile = localEntry;
        }
      }
      if (paramFile != null) {
        break label156;
      }
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Failed to resolve canonical path for " + paramFile);
    }
    throw new IllegalArgumentException("Failed to find configured root that contains " + str2);
    label156:
    String str1 = ((File)paramFile.getValue()).getPath();
    if (str1.endsWith("/")) {}
    for (str1 = str2.substring(str1.length());; str1 = str2.substring(str1.length() + 1))
    {
      paramFile = Uri.encode((String)paramFile.getKey()) + '/' + Uri.encode(str1, "/");
      return new Uri.Builder().scheme("content").authority(mAuthority).encodedPath(paramFile).build();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.FileProvider.SimplePathStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */