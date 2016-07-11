package rx.exceptions;

import java.io.PrintWriter;

class CompositeException$WrappedPrintWriter
  extends CompositeException.PrintStreamOrWriter
{
  private final PrintWriter printWriter;
  
  CompositeException$WrappedPrintWriter(PrintWriter paramPrintWriter)
  {
    super(null);
    printWriter = paramPrintWriter;
  }
  
  Object lock()
  {
    return printWriter;
  }
  
  void println(Object paramObject)
  {
    printWriter.println(paramObject);
  }
}

/* Location:
 * Qualified Name:     rx.exceptions.CompositeException.WrappedPrintWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */