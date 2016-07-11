package spacemadness.com.lunarconsole.console;

import java.util.Iterator;
import spacemadness.com.lunarconsole.utils.ObjectUtils;
import spacemadness.com.lunarconsole.utils.StringUtils;

public class ConsoleEntryList
{
  private LimitSizeEntryList currentEntries;
  private final LimitSizeEntryList entries;
  private int errorCount;
  private String filterText;
  private LimitSizeEntryList filteredEntries;
  private int logCount;
  private int logDisabledTypesMask;
  private int warningCount;
  
  public ConsoleEntryList(int paramInt1, int paramInt2)
  {
    entries = new LimitSizeEntryList(paramInt1, paramInt2);
    currentEntries = entries;
    logDisabledTypesMask = 0;
  }
  
  private boolean appendFilter()
  {
    if (isFiltering())
    {
      useFilteredFromEntries(filteredEntries);
      return true;
    }
    return applyFilter();
  }
  
  private boolean applyFilter()
  {
    if ((StringUtils.length(filterText) > 0) || (hasLogTypeFilters())) {}
    for (int i = 1; i != 0; i = 0)
    {
      useFilteredFromEntries(entries);
      return true;
    }
    return removeFilter();
  }
  
  private LimitSizeEntryList filterEntries(LimitSizeEntryList paramLimitSizeEntryList)
  {
    LimitSizeEntryList localLimitSizeEntryList = new LimitSizeEntryList(paramLimitSizeEntryList.capacity(), paramLimitSizeEntryList.getTrimSize());
    paramLimitSizeEntryList = paramLimitSizeEntryList.iterator();
    while (paramLimitSizeEntryList.hasNext())
    {
      ConsoleEntry localConsoleEntry = (ConsoleEntry)paramLimitSizeEntryList.next();
      if (isFiltered(localConsoleEntry)) {
        localLimitSizeEntryList.addObject(localConsoleEntry);
      }
    }
    return localLimitSizeEntryList;
  }
  
  private boolean hasLogTypeFilters()
  {
    return logDisabledTypesMask != 0;
  }
  
  private boolean isFiltered(ConsoleEntry paramConsoleEntry)
  {
    if ((logDisabledTypesMask & ConsoleLogType.getMask(type)) != 0) {}
    while ((StringUtils.length(filterText) != 0) && (!StringUtils.containsIgnoreCase(message, filterText))) {
      return false;
    }
    return true;
  }
  
  private boolean removeFilter()
  {
    if (isFiltering())
    {
      currentEntries = entries;
      filteredEntries = null;
      return true;
    }
    return false;
  }
  
  private void useFilteredFromEntries(LimitSizeEntryList paramLimitSizeEntryList)
  {
    paramLimitSizeEntryList = filterEntries(paramLimitSizeEntryList);
    currentEntries = paramLimitSizeEntryList;
    filteredEntries = paramLimitSizeEntryList;
  }
  
  public void addEntry(ConsoleEntry paramConsoleEntry)
  {
    entries.addObject(paramConsoleEntry);
    int i = type;
    if (i == 3) {
      logCount += 1;
    }
    do
    {
      return;
      if (i == 2)
      {
        warningCount += 1;
        return;
      }
    } while (!ConsoleLogType.isErrorType(i));
    errorCount += 1;
  }
  
  public void clear()
  {
    entries.clear();
    if (filteredEntries != null) {
      filteredEntries.clear();
    }
    logCount = 0;
    warningCount = 0;
    errorCount = 0;
  }
  
  public int count()
  {
    return currentEntries.count();
  }
  
  public boolean filterEntry(ConsoleEntry paramConsoleEntry)
  {
    if (isFiltering())
    {
      if (isFiltered(paramConsoleEntry)) {
        filteredEntries.addObject(paramConsoleEntry);
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public ConsoleEntry getEntry(int paramInt)
  {
    return (ConsoleEntry)currentEntries.objectAtIndex(paramInt);
  }
  
  public int getErrorCount()
  {
    return errorCount;
  }
  
  public String getFilterText()
  {
    return filterText;
  }
  
  public int getLogCount()
  {
    return logCount;
  }
  
  public String getText()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int k = currentEntries.count();
    Iterator localIterator = currentEntries.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(nextmessage);
      int j = i + 1;
      i = j;
      if (j < k)
      {
        localStringBuilder.append('\n');
        i = j;
      }
    }
    return localStringBuilder.toString();
  }
  
  public int getWarningCount()
  {
    return warningCount;
  }
  
  public boolean isFilterLogTypeEnabled(int paramInt)
  {
    return (logDisabledTypesMask & ConsoleLogType.getMask(paramInt)) == 0;
  }
  
  public boolean isFiltering()
  {
    return filteredEntries != null;
  }
  
  public boolean isOverfloating()
  {
    return currentEntries.isOverfloating();
  }
  
  public boolean isTrimmed()
  {
    return currentEntries.isTrimmed();
  }
  
  public int overflowAmount()
  {
    return currentEntries.overflowCount();
  }
  
  public boolean setFilterByLogType(int paramInt, boolean paramBoolean)
  {
    return setFilterByLogTypeMask(ConsoleLogType.getMask(paramInt), paramBoolean);
  }
  
  public boolean setFilterByLogTypeMask(int paramInt, boolean paramBoolean)
  {
    int i = logDisabledTypesMask;
    if (paramBoolean) {
      logDisabledTypesMask |= paramInt;
    }
    while (i != logDisabledTypesMask) {
      if (paramBoolean)
      {
        return appendFilter();
        logDisabledTypesMask &= (paramInt ^ 0xFFFFFFFF);
      }
      else
      {
        return applyFilter();
      }
    }
    return false;
  }
  
  public boolean setFilterByText(String paramString)
  {
    if (!ObjectUtils.areEqual(filterText, paramString))
    {
      String str = filterText;
      filterText = paramString;
      if ((StringUtils.length(paramString) > StringUtils.length(str)) && ((StringUtils.length(str) == 0) || (StringUtils.hasPrefix(paramString, str)))) {
        return appendFilter();
      }
      return applyFilter();
    }
    return false;
  }
  
  public int totalCount()
  {
    return currentEntries.totalCount();
  }
  
  public void trimHead(int paramInt)
  {
    entries.trimHead(paramInt);
  }
  
  public int trimmedCount()
  {
    return currentEntries.trimmedCount();
  }
  
  private static class LimitSizeEntryList
    extends LimitSizeList<ConsoleEntry>
  {
    public LimitSizeEntryList(int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleEntryList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */