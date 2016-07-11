package spacemadness.com.lunarconsole.debug;

public class Tag
{
  public boolean enabled;
  public final String name;
  
  public Tag(String paramString)
  {
    this(paramString, false);
  }
  
  public Tag(String paramString, boolean paramBoolean)
  {
    name = paramString;
    enabled = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.debug.Tag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */