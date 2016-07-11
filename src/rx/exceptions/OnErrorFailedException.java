package rx.exceptions;

public class OnErrorFailedException
  extends RuntimeException
{
  private static final long serialVersionUID = -419289748403337611L;
  
  public OnErrorFailedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public OnErrorFailedException(Throwable paramThrowable)
  {
    super(paramThrowable.getMessage(), paramThrowable);
  }
}

/* Location:
 * Qualified Name:     rx.exceptions.OnErrorFailedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */