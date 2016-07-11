package rx.exceptions;

import java.io.PrintStream;

class CompositeException$WrappedPrintStream
  extends CompositeException.PrintStreamOrWriter
{
  private final PrintStream printStream;
  
  CompositeException$WrappedPrintStream(PrintStream paramPrintStream)
  {
    super(null);
    printStream = paramPrintStream;
  }
  
  Object lock()
  {
    return printStream;
  }
  
  void println(Object paramObject)
  {
    printStream.println(paramObject);
  }
}

/* Location:
 * Qualified Name:     rx.exceptions.CompositeException.WrappedPrintStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */