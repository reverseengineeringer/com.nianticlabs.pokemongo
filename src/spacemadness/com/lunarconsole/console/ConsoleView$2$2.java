package spacemadness.com.lunarconsole.console;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ConsoleView$2$2
  implements DialogInterface.OnClickListener
{
  ConsoleView$2$2(ConsoleView.2 param2, String paramString1, ConsoleEntry paramConsoleEntry, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = val$message;
    paramDialogInterface = str;
    if (val$entry.hasStackTrace()) {
      paramDialogInterface = str + "\n\n" + val$stackTrace;
    }
    ConsoleView.access$000(this$1.this$0, paramDialogInterface);
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleView.2.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */