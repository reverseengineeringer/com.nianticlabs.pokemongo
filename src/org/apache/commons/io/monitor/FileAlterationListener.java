package org.apache.commons.io.monitor;

import java.io.File;

public abstract interface FileAlterationListener
{
  public abstract void onDirectoryChange(File paramFile);
  
  public abstract void onDirectoryCreate(File paramFile);
  
  public abstract void onDirectoryDelete(File paramFile);
  
  public abstract void onFileChange(File paramFile);
  
  public abstract void onFileCreate(File paramFile);
  
  public abstract void onFileDelete(File paramFile);
  
  public abstract void onStart(FileAlterationObserver paramFileAlterationObserver);
  
  public abstract void onStop(FileAlterationObserver paramFileAlterationObserver);
}

/* Location:
 * Qualified Name:     org.apache.commons.io.monitor.FileAlterationListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */