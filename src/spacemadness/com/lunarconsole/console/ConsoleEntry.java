package spacemadness.com.lunarconsole.console;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import spacemadness.com.lunarconsole.R.color;
import spacemadness.com.lunarconsole.R.drawable;
import spacemadness.com.lunarconsole.R.id;

public class ConsoleEntry
{
  private static final int[] LOG_ENTRY_ICON_RES_LOOKUP = new int[5];
  public int index;
  public final String message;
  public final String stackTrace;
  public final byte type;
  
  static
  {
    LOG_ENTRY_ICON_RES_LOOKUP[0] = R.drawable.lunar_console_icon_log_error;
    LOG_ENTRY_ICON_RES_LOOKUP[1] = R.drawable.lunar_console_icon_log_error;
    LOG_ENTRY_ICON_RES_LOOKUP[2] = R.drawable.lunar_console_icon_log_warning;
    LOG_ENTRY_ICON_RES_LOOKUP[3] = R.drawable.lunar_console_icon_log;
    LOG_ENTRY_ICON_RES_LOOKUP[4] = R.drawable.lunar_console_icon_log_error;
  }
  
  public ConsoleEntry(byte paramByte, String paramString)
  {
    this(paramByte, paramString, null);
  }
  
  public ConsoleEntry(byte paramByte, String paramString1, String paramString2)
  {
    type = paramByte;
    message = paramString1;
    stackTrace = paramString2;
  }
  
  private int getIconResId(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < LOG_ENTRY_ICON_RES_LOOKUP.length)) {
      return LOG_ENTRY_ICON_RES_LOOKUP[paramInt];
    }
    return R.drawable.lunar_console_icon_log;
  }
  
  public int getBackgroundColor(Context paramContext)
  {
    if (index % 2 == 0) {}
    for (int i = R.color.lunar_console_color_cell_background_dark;; i = R.color.lunar_console_color_cell_background_light) {
      return paramContext.getResources().getColor(i);
    }
  }
  
  public Drawable getIconDrawable(Context paramContext)
  {
    int i = getIconResId(type);
    return paramContext.getResources().getDrawable(i);
  }
  
  public boolean hasStackTrace()
  {
    return (stackTrace != null) && (stackTrace.length() > 0);
  }
  
  public static class ViewHolder
    extends ConsoleAdapter.ViewHolder<ConsoleEntry>
  {
    private final ImageView iconView;
    private final View layout;
    private final TextView messageView;
    
    public ViewHolder(View paramView)
    {
      super();
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
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */