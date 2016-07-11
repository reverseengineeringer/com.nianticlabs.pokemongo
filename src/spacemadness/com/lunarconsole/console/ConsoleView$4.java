package spacemadness.com.lunarconsole.console;

import android.text.Editable;
import android.text.TextWatcher;

class ConsoleView$4
  implements TextWatcher
{
  ConsoleView$4(ConsoleView paramConsoleView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    ConsoleView.access$300(this$0, paramEditable.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleView.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */