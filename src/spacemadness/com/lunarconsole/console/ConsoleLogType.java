package spacemadness.com.lunarconsole.console;

public final class ConsoleLogType
{
  public static final byte ASSERT = 1;
  public static final byte COUNT = 5;
  public static final byte ERROR = 0;
  public static final byte EXCEPTION = 4;
  public static final byte LOG = 3;
  public static final byte WARNING = 2;
  
  public static int getMask(int paramInt)
  {
    return 1 << paramInt;
  }
  
  public static boolean isErrorType(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 0) || (paramInt == 1);
  }
  
  public static boolean isValidType(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < 5);
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleLogType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */