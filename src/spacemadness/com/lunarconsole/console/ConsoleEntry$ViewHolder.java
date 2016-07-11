package spacemadness.com.lunarconsole.console;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import spacemadness.com.lunarconsole.R.id;

public class ConsoleEntry$ViewHolder
  extends ConsoleAdapter.ViewHolder<ConsoleEntry>
{
  private final ImageView iconView;
  private final View layout;
  private final TextView messageView;
  
  public ConsoleEntry$ViewHolder(View paramView)
  {
    super(paramView);
    layout = paramView.findViewById(R.id.lunar_console_log_entry_layout);
    iconView = ((ImageView)paramView.findViewById(R.id.lunar_console_log_entry_icon));
    messageView = ((TextView)paramView.findViewById(R.id.lunar_console_log_entry_message));
  }
  
  public void onBindViewHolder(ConsoleEntry paramConsoleEntry)
  {
    Context localContext = getContext();
    layout.setBackgroundColor(paramConsoleEntry.getBackgroundColor(localContext));
    iconView.setImageDrawable(paramConsoleEntry.getIconDrawable(localContext));
    messageView.setText(message);
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleEntry.ViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */