package spacemadness.com.lunarconsole.console;

public class Console$Options
{
  private final int capacity;
  private int trimCount;
  
  public Console$Options(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Invalid capacity: " + paramInt);
    }
    capacity = paramInt;
    trimCount = 1;
  }
  
  public Options clone()
  {
    Options localOptions = new Options(capacity);
    trimCount = trimCount;
    return localOptions;
  }
  
  public int getCapacity()
  {
    return capacity;
  }
  
  public int getTrimCount()
  {
    return trimCount;
  }
  
  public void setTrimCount(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > capacity)) {
      throw new IllegalArgumentException("Illegal trim count: " + paramInt);
    }
    trimCount = paramInt;
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.Console.Options
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */