package spacemadness.com.lunarconsole.console;

import android.content.Context;
import android.view.View;
import spacemadness.com.lunarconsole.debug.Log;

class ConsoleView$2$1
  implements Runnable
{
  ConsoleView$2$1(ConsoleView.2 param2, View paramView, ConsoleEntry paramConsoleEntry, Context paramContext) {}
  
  public void run()
  {
    try
    {
      val$view.setBackgroundColor(val$entry.getBackgroundColor(val$ctx));
      return;
    }
    catch (Exception localException)
    {
      Log.e(localException, "Error while settings entry background color", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleView.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */