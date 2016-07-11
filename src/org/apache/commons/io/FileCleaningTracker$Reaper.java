package org.apache.commons.io;

import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.List;

final class FileCleaningTracker$Reaper
  extends Thread
{
  FileCleaningTracker$Reaper(FileCleaningTracker paramFileCleaningTracker)
  {
    super("File Reaper");
    setPriority(10);
    setDaemon(true);
  }
  
  public void run()
  {
    while ((!this$0.exitWhenFinished) || (this$0.trackers.size() > 0)) {
      try
      {
        FileCleaningTracker.Tracker localTracker = (FileCleaningTracker.Tracker)this$0.q.remove();
        this$0.trackers.remove(localTracker);
        if (!localTracker.delete()) {
          this$0.deleteFailures.add(localTracker.getPath());
        }
        localTracker.clear();
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.FileCleaningTracker.Reaper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */