package rx.exceptions;

public class MissingBackpressureException
  extends Exception
{
  private static final long serialVersionUID = 7250870679677032194L;
  
  public MissingBackpressureException() {}
  
  public MissingBackpressureException(String paramString)
  {
    super(paramString);
  }
}

/* Location:
 * Qualified Name:     rx.exceptions.MissingBackpressureException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */