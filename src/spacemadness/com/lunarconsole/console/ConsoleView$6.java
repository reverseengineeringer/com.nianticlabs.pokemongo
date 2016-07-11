package spacemadness.com.lunarconsole.console;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class ConsoleView$6
  implements TextView.OnEditorActionListener
{
  ConsoleView$6(ConsoleView paramConsoleView) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 3)
    {
      ConsoleView.access$500(this$0);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleView.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */