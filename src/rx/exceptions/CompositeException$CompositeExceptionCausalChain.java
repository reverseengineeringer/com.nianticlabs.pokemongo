package rx.exceptions;

final class CompositeException$CompositeExceptionCausalChain
  extends RuntimeException
{
  static String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
  private static final long serialVersionUID = 3875212506787802066L;
  
  public String getMessage()
  {
    return MESSAGE;
  }
}

/* Location:
 * Qualified Name:     rx.exceptions.CompositeException.CompositeExceptionCausalChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */