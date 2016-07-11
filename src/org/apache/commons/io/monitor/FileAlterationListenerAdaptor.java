package org.apache.commons.io.monitor;

import java.io.File;

public class FileAlterationListenerAdaptor
  implements FileAlterationListener
{
  public void onDirectoryChange(File paramFile) {}
  
  public void onDirectoryCreate(File paramFile) {}
  
  public void onDirectoryDelete(File paramFile) {}
  
  public void onFileChange(File paramFile) {}
  
  public void onFileCreate(File paramFile) {}
  
  public void onFileDelete(File paramFile) {}
  
  public void onStart(FileAlterationObserver paramFileAlterationObserver) {}
  
  public void onStop(FileAlterationObserver paramFileAlterationObserver) {}
}

/* Location:
 * Qualified Name:     org.apache.commons.io.monitor.FileAlterationListenerAdaptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */