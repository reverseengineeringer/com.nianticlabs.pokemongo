package org.apache.commons.io.monitor;

import java.io.File;
import java.io.Serializable;

public class FileEntry
  implements Serializable
{
  static final FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
  private FileEntry[] children;
  private boolean directory;
  private boolean exists;
  private final File file;
  private long lastModified;
  private long length;
  private String name;
  private final FileEntry parent;
  
  public FileEntry(File paramFile)
  {
    this((FileEntry)null, paramFile);
  }
  
  public FileEntry(FileEntry paramFileEntry, File paramFile)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("File is missing");
    }
    file = paramFile;
    parent = paramFileEntry;
    name = paramFile.getName();
  }
  
  public FileEntry[] getChildren()
  {
    if (children != null) {
      return children;
    }
    return EMPTY_ENTRIES;
  }
  
  public File getFile()
  {
    return file;
  }
  
  public long getLastModified()
  {
    return lastModified;
  }
  
  public long getLength()
  {
    return length;
  }
  
  public int getLevel()
  {
    if (parent == null) {
      return 0;
    }
    return parent.getLevel() + 1;
  }
  
  public String getName()
  {
    return name;
  }
  
  public FileEntry getParent()
  {
    return parent;
  }
  
  public boolean isDirectory()
  {
    return directory;
  }
  
  public boolean isExists()
  {
    return exists;
  }
  
  public FileEntry newChildInstance(File paramFile)
  {
    return new FileEntry(this, paramFile);
  }
  
  public boolean refresh(File paramFile)
  {
    long l2 = 0L;
    boolean bool2 = false;
    boolean bool3 = exists;
    long l3 = lastModified;
    boolean bool4 = directory;
    long l4 = length;
    name = paramFile.getName();
    exists = paramFile.exists();
    boolean bool1;
    if (exists)
    {
      bool1 = paramFile.isDirectory();
      directory = bool1;
      if (!exists) {
        break label166;
      }
    }
    label166:
    for (long l1 = paramFile.lastModified();; l1 = 0L)
    {
      lastModified = l1;
      l1 = l2;
      if (exists)
      {
        l1 = l2;
        if (!directory) {
          l1 = paramFile.length();
        }
      }
      length = l1;
      if ((exists == bool3) && (lastModified == l3) && (directory == bool4))
      {
        bool1 = bool2;
        if (length == l4) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      bool1 = false;
      break;
    }
  }
  
  public void setChildren(FileEntry[] paramArrayOfFileEntry)
  {
    children = paramArrayOfFileEntry;
  }
  
  public void setDirectory(boolean paramBoolean)
  {
    directory = paramBoolean;
  }
  
  public void setExists(boolean paramBoolean)
  {
    exists = paramBoolean;
  }
  
  public void setLastModified(long paramLong)
  {
    lastModified = paramLong;
  }
  
  public void setLength(long paramLong)
  {
    length = paramLong;
  }
  
  public void setName(String paramString)
  {
    name = paramString;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.monitor.FileEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */