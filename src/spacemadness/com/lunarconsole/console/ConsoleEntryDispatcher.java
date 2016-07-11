package spacemadness.com.lunarconsole.console;

import java.util.ArrayList;
import java.util.List;
import spacemadness.com.lunarconsole.debug.Log;
import spacemadness.com.lunarconsole.utils.ThreadUtils;

class ConsoleEntryDispatcher
{
  private final Runnable dispatchRunnable;
  private final List<ConsoleEntry> entries;
  private final OnDispatchListener listener;
  
  public ConsoleEntryDispatcher(OnDispatchListener paramOnDispatchListener)
  {
    if (paramOnDispatchListener == null) {
      throw new NullPointerException("Listener is null");
    }
    listener = paramOnDispatchListener;
    entries = new ArrayList();
    dispatchRunnable = createDispatchRunnable();
  }
  
  private Runnable createDispatchRunnable()
  {
    new Runnable()
    {
      public void run()
      {
        dispatchEntries();
      }
    };
  }
  
  public void add(ConsoleEntry paramConsoleEntry)
  {
    synchronized (entries)
    {
      entries.add(paramConsoleEntry);
      if (entries.size() == 1) {
        postEntriesDispatch();
      }
      return;
    }
  }
  
  public void cancelAll()
  {
    cancelEntriesDispatch();
    synchronized (entries)
    {
      entries.clear();
      return;
    }
  }
  
  protected void cancelEntriesDispatch()
  {
    ThreadUtils.cancel(dispatchRunnable);
  }
  
  protected void dispatchEntries()
  {
    synchronized (entries)
    {
      try
      {
        listener.onDispatchEntries(entries);
        entries.clear();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e(localException, "Can't dispatch entries", new Object[0]);
        }
      }
    }
  }
  
  protected void postEntriesDispatch()
  {
    ThreadUtils.runOnUIThread(dispatchRunnable);
  }
  
  public static abstract interface OnDispatchListener
  {
    public abstract void onDispatchEntries(List<ConsoleEntry> paramList);
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleEntryDispatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */