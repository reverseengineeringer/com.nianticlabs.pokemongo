package spacemadness.com.lunarconsole.console;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import spacemadness.com.lunarconsole.ui.ToggleImageButton;

class ConsoleView$3
  implements View.OnTouchListener
{
  ConsoleView$3(ConsoleView paramConsoleView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((ConsoleView.access$100(this$0)) && (paramMotionEvent.getAction() == 0)) {
      ConsoleView.access$200(this$0).setOn(false);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleView.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */