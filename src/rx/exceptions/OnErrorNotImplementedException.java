package rx.exceptions;

public class OnErrorNotImplementedException
  extends RuntimeException
{
  private static final long serialVersionUID = -6298857009889503852L;
  
  public OnErrorNotImplementedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public OnErrorNotImplementedException(Throwable paramThrowable)
  {
    super(paramThrowable.getMessage(), paramThrowable);
  }
}

/* Location:
 * Qualified Name:     rx.exceptions.OnErrorNotImplementedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */