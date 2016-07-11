package spacemadness.com.lunarconsole.console;

public abstract interface LunarConsoleListener
{
  public abstract void onAddEntry(Console paramConsole, ConsoleEntry paramConsoleEntry, boolean paramBoolean);
  
  public abstract void onClearEntries(Console paramConsole);
  
  public abstract void onRemoveEntries(Console paramConsole, int paramInt1, int paramInt2);
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.LunarConsoleListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */