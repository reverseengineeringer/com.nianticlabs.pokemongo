package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CompositeFileComparator
  extends AbstractFileComparator
  implements Serializable
{
  private static final Comparator<?>[] NO_COMPARATORS = new Comparator[0];
  private final Comparator<File>[] delegates;
  
  public CompositeFileComparator(Iterable<Comparator<File>> paramIterable)
  {
    if (paramIterable == null)
    {
      delegates = ((Comparator[])NO_COMPARATORS);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add((Comparator)paramIterable.next());
    }
    delegates = ((Comparator[])localArrayList.toArray(new Comparator[localArrayList.size()]));
  }
  
  public CompositeFileComparator(Comparator<File>... paramVarArgs)
  {
    if (paramVarArgs == null)
    {
      delegates = ((Comparator[])NO_COMPARATORS);
      return;
    }
    delegates = ((Comparator[])new Comparator[paramVarArgs.length]);
    System.arraycopy(paramVarArgs, 0, delegates, 0, paramVarArgs.length);
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    int i = 0;
    Comparator[] arrayOfComparator = delegates;
    int k = arrayOfComparator.length;
    int j = 0;
    for (;;)
    {
      if (j < k)
      {
        i = arrayOfComparator[j].compare(paramFile1, paramFile2);
        if (i == 0) {}
      }
      else
      {
        return i;
      }
      j += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append('{');
    int i = 0;
    while (i < delegates.length)
    {
      if (i > 0) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(delegates[i]);
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.comparator.CompositeFileComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */