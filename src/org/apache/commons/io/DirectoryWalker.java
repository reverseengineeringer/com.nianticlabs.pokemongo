package org.apache.commons.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

public abstract class DirectoryWalker<T>
{
  private final int depthLimit;
  private final FileFilter filter;
  
  protected DirectoryWalker()
  {
    this(null, -1);
  }
  
  protected DirectoryWalker(FileFilter paramFileFilter, int paramInt)
  {
    filter = paramFileFilter;
    depthLimit = paramInt;
  }
  
  protected DirectoryWalker(IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2, int paramInt)
  {
    if ((paramIOFileFilter1 == null) && (paramIOFileFilter2 == null))
    {
      filter = null;
      depthLimit = paramInt;
      return;
    }
    if (paramIOFileFilter1 != null) {
      label27:
      if (paramIOFileFilter2 == null) {
        break label66;
      }
    }
    for (;;)
    {
      filter = FileFilterUtils.or(new IOFileFilter[] { FileFilterUtils.makeDirectoryOnly(paramIOFileFilter1), FileFilterUtils.makeFileOnly(paramIOFileFilter2) });
      break;
      paramIOFileFilter1 = TrueFileFilter.TRUE;
      break label27;
      label66:
      paramIOFileFilter2 = TrueFileFilter.TRUE;
    }
  }
  
  private void walk(File paramFile, int paramInt, Collection<T> paramCollection)
    throws IOException
  {
    checkIfCancelled(paramFile, paramInt, paramCollection);
    int j;
    if (handleDirectory(paramFile, paramInt, paramCollection))
    {
      handleDirectoryStart(paramFile, paramInt, paramCollection);
      j = paramInt + 1;
      if ((depthLimit < 0) || (j <= depthLimit))
      {
        checkIfCancelled(paramFile, paramInt, paramCollection);
        if (filter != null) {
          break label103;
        }
      }
    }
    label103:
    for (File[] arrayOfFile = paramFile.listFiles();; arrayOfFile = paramFile.listFiles(filter))
    {
      arrayOfFile = filterDirectoryContents(paramFile, paramInt, arrayOfFile);
      if (arrayOfFile != null) {
        break;
      }
      handleRestricted(paramFile, j, paramCollection);
      handleDirectoryEnd(paramFile, paramInt, paramCollection);
      checkIfCancelled(paramFile, paramInt, paramCollection);
      return;
    }
    int k = arrayOfFile.length;
    int i = 0;
    label124:
    File localFile;
    if (i < k)
    {
      localFile = arrayOfFile[i];
      if (!localFile.isDirectory()) {
        break label164;
      }
      walk(localFile, j, paramCollection);
    }
    for (;;)
    {
      i += 1;
      break label124;
      break;
      label164:
      checkIfCancelled(localFile, j, paramCollection);
      handleFile(localFile, j, paramCollection);
      checkIfCancelled(localFile, j, paramCollection);
    }
  }
  
  protected final void checkIfCancelled(File paramFile, int paramInt, Collection<T> paramCollection)
    throws IOException
  {
    if (handleIsCancelled(paramFile, paramInt, paramCollection)) {
      throw new CancelException(paramFile, paramInt);
    }
  }
  
  protected File[] filterDirectoryContents(File paramFile, int paramInt, File[] paramArrayOfFile)
    throws IOException
  {
    return paramArrayOfFile;
  }
  
  protected void handleCancelled(File paramFile, Collection<T> paramCollection, CancelException paramCancelException)
    throws IOException
  {
    throw paramCancelException;
  }
  
  protected boolean handleDirectory(File paramFile, int paramInt, Collection<T> paramCollection)
    throws IOException
  {
    return true;
  }
  
  protected void handleDirectoryEnd(File paramFile, int paramInt, Collection<T> paramCollection)
    throws IOException
  {}
  
  protected void handleDirectoryStart(File paramFile, int paramInt, Collection<T> paramCollection)
    throws IOException
  {}
  
  protected void handleEnd(Collection<T> paramCollection)
    throws IOException
  {}
  
  protected void handleFile(File paramFile, int paramInt, Collection<T> paramCollection)
    throws IOException
  {}
  
  protected boolean handleIsCancelled(File paramFile, int paramInt, Collection<T> paramCollection)
    throws IOException
  {
    return false;
  }
  
  protected void handleRestricted(File paramFile, int paramInt, Collection<T> paramCollection)
    throws IOException
  {}
  
  protected void handleStart(File paramFile, Collection<T> paramCollection)
    throws IOException
  {}
  
  protected final void walk(File paramFile, Collection<T> paramCollection)
    throws IOException
  {
    if (paramFile == null) {
      throw new NullPointerException("Start Directory is null");
    }
    try
    {
      handleStart(paramFile, paramCollection);
      walk(paramFile, 0, paramCollection);
      handleEnd(paramCollection);
      return;
    }
    catch (CancelException localCancelException)
    {
      handleCancelled(paramFile, paramCollection, localCancelException);
    }
  }
  
  public static class CancelException
    extends IOException
  {
    private static final long serialVersionUID = 1347339620135041008L;
    private final int depth;
    private final File file;
    
    public CancelException(File paramFile, int paramInt)
    {
      this("Operation Cancelled", paramFile, paramInt);
    }
    
    public CancelException(String paramString, File paramFile, int paramInt)
    {
      super();
      file = paramFile;
      depth = paramInt;
    }
    
    public int getDepth()
    {
      return depth;
    }
    
    public File getFile()
    {
      return file;
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.DirectoryWalker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */