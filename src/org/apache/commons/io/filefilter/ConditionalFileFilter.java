package org.apache.commons.io.filefilter;

import java.util.List;

public abstract interface ConditionalFileFilter
{
  public abstract void addFileFilter(IOFileFilter paramIOFileFilter);
  
  public abstract List<IOFileFilter> getFileFilters();
  
  public abstract boolean removeFileFilter(IOFileFilter paramIOFileFilter);
  
  public abstract void setFileFilters(List<IOFileFilter> paramList);
}

/* Location:
 * Qualified Name:     org.apache.commons.io.filefilter.ConditionalFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */