package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import rx.exceptions.Exceptions;

class BlockingOperatorMostRecent$MostRecentObserver$1
  implements Iterator<T>
{
  private Object buf = null;
  
  BlockingOperatorMostRecent$MostRecentObserver$1(BlockingOperatorMostRecent.MostRecentObserver paramMostRecentObserver) {}
  
  public boolean hasNext()
  {
    buf = this$0.value;
    return !this$0.nl.isCompleted(buf);
  }
  
  public T next()
  {
    try
    {
      if (buf == null) {
        buf = this$0.value;
      }
      if (this$0.nl.isCompleted(buf)) {
        throw new NoSuchElementException();
      }
    }
    finally
    {
      buf = null;
    }
    if (this$0.nl.isError(buf)) {
      throw Exceptions.propagate(this$0.nl.getError(buf));
    }
    Object localObject2 = this$0.nl.getValue(buf);
    buf = null;
    return (T)localObject2;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Read only iterator");
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BlockingOperatorMostRecent.MostRecentObserver.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */