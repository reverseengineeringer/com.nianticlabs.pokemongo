package spacemadness.com.lunarconsole.console;

import spacemadness.com.lunarconsole.core.Destroyable;
import spacemadness.com.lunarconsole.debug.Log;

public class Console
  implements Destroyable, ConsoleAdapter.DataSource
{
  private static final LunarConsoleListener NULL_LISTENER = new LunarConsoleListener()
  {
    public void onAddEntry(Console paramAnonymousConsole, ConsoleEntry paramAnonymousConsoleEntry, boolean paramAnonymousBoolean) {}
    
    public void onClearEntries(Console paramAnonymousConsole) {}
    
    public void onRemoveEntries(Console paramAnonymousConsole, int paramAnonymousInt1, int paramAnonymousInt2) {}
  };
  private LunarConsoleListener consoleListener;
  private final ConsoleEntryList entries;
  private final Options options;
  
  public Console(Options paramOptions)
  {
    if (paramOptions == null) {
      throw new NullPointerException("Options is null");
    }
    options = paramOptions.clone();
    entries = new ConsoleEntryList(paramOptions.getCapacity(), paramOptions.getTrimCount());
    consoleListener = NULL_LISTENER;
  }
  
  private void notifyEntriesCleared()
  {
    try
    {
      consoleListener.onClearEntries(this);
      return;
    }
    catch (Exception localException)
    {
      Log.e(localException, "Error while notifying delegate", new Object[0]);
    }
  }
  
  private void notifyEntryAdded(ConsoleEntry paramConsoleEntry, boolean paramBoolean)
  {
    try
    {
      consoleListener.onAddEntry(this, paramConsoleEntry, paramBoolean);
      return;
    }
    catch (Exception paramConsoleEntry)
    {
      Log.e(paramConsoleEntry, "Error while notifying delegate", new Object[0]);
    }
  }
  
  private void notifyRemoveEntries(int paramInt1, int paramInt2)
  {
    try
    {
      consoleListener.onRemoveEntries(this, paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      Log.e(localException, "Error while notifying delegate", new Object[0]);
    }
  }
  
  public void clear()
  {
    entries.clear();
    notifyEntriesCleared();
  }
  
  public void destroy()
  {
    entries.clear();
  }
  
  public ConsoleEntryList entries()
  {
    return entries;
  }
  
  public int entriesCount()
  {
    return entries.count();
  }
  
  public ConsoleEntry entryAtIndex(int paramInt)
  {
    return entries.getEntry(paramInt);
  }
  
  public LunarConsoleListener getConsoleListener()
  {
    return consoleListener;
  }
  
  public ConsoleEntry getEntry(int paramInt)
  {
    return entries.getEntry(paramInt);
  }
  
  public int getEntryCount()
  {
    return entries.count();
  }
  
  public String getText()
  {
    return entries.getText();
  }
  
  public boolean isTrimmed()
  {
    return entries.isTrimmed();
  }
  
  public void logMessage(String paramString1, String paramString2, byte paramByte)
  {
    logMessage(new ConsoleEntry(paramByte, paramString1, paramString2));
  }
  
  void logMessage(ConsoleEntry paramConsoleEntry)
  {
    int i = entries.trimmedCount();
    index = entries.totalCount();
    boolean bool = entries.filterEntry(paramConsoleEntry);
    entries.addEntry(paramConsoleEntry);
    i = entries.trimmedCount() - i;
    if (i > 0) {
      notifyRemoveEntries(0, i);
    }
    notifyEntryAdded(paramConsoleEntry, bool);
  }
  
  public void setConsoleListener(LunarConsoleListener paramLunarConsoleListener)
  {
    if (paramLunarConsoleListener != null) {}
    for (;;)
    {
      consoleListener = paramLunarConsoleListener;
      return;
      paramLunarConsoleListener = NULL_LISTENER;
    }
  }
  
  public int trimmedCount()
  {
    return entries.trimmedCount();
  }
  
  public static class Options
  {
    private final int capacity;
    private int trimCount;
    
    public Options(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("Invalid capacity: " + paramInt);
      }
      capacity = paramInt;
      trimCount = 1;
    }
    
    public Options clone()
    {
      Options localOptions = new Options(capacity);
      trimCount = trimCount;
      return localOptions;
    }
    
    public int getCapacity()
    {
      return capacity;
    }
    
    public int getTrimCount()
    {
      return trimCount;
    }
    
    public void setTrimCount(int paramInt)
    {
      if ((paramInt <= 0) || (paramInt > capacity)) {
        throw new IllegalArgumentException("Illegal trim count: " + paramInt);
      }
      trimCount = paramInt;
    }
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.Console
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */