package org.apache.commons.io;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

final class FileCleaningTracker$Tracker
  extends PhantomReference<Object>
{
  private final FileDeleteStrategy deleteStrategy;
  private final String path;
  
  FileCleaningTracker$Tracker(String paramString, FileDeleteStrategy paramFileDeleteStrategy, Object paramObject, ReferenceQueue<? super Object> paramReferenceQueue)
  {
    super(paramObject, paramReferenceQueue);
    path = paramString;
    paramString = paramFileDeleteStrategy;
    if (paramFileDeleteStrategy == null) {
      paramString = FileDeleteStrategy.NORMAL;
    }
    deleteStrategy = paramString;
  }
  
  public boolean delete()
  {
    return deleteStrategy.deleteQuietly(new File(path));
  }
  
  public String getPath()
  {
    return path;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.FileCleaningTracker.Tracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */