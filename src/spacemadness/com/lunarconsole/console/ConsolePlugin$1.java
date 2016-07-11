package spacemadness.com.lunarconsole.console;

import java.util.List;
import spacemadness.com.lunarconsole.debug.Log;

final class ConsolePlugin$1
  implements ConsoleEntryDispatcher.OnDispatchListener
{
  public void onDispatchEntries(List<ConsoleEntry> paramList)
  {
    if (ConsolePlugin.access$000() != null)
    {
      ConsolePlugin.access$100(ConsolePlugin.access$000(), paramList);
      return;
    }
    Log.e("Can't log message: plugin instance is not initialized", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsolePlugin.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */