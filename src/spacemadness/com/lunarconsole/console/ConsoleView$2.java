package spacemadness.com.lunarconsole.console;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import spacemadness.com.lunarconsole.R.id;
import spacemadness.com.lunarconsole.R.layout;
import spacemadness.com.lunarconsole.R.string;
import spacemadness.com.lunarconsole.debug.Log;
import spacemadness.com.lunarconsole.utils.StackTrace;
import spacemadness.com.lunarconsole.utils.ThreadUtils;

class ConsoleView$2
  implements AdapterView.OnItemClickListener
{
  ConsoleView$2(ConsoleView paramConsoleView, Console paramConsole) {}
  
  public void onItemClick(final AdapterView<?> paramAdapterView, final View paramView, int paramInt, long paramLong)
  {
    final Context localContext = this$0.getContext();
    final ConsoleEntry localConsoleEntry = val$console.getEntry(paramInt);
    paramView.setBackgroundColor(-16777216);
    ThreadUtils.runOnUIThread(new Runnable()
    {
      public void run()
      {
        try
        {
          paramView.setBackgroundColor(localConsoleEntry.getBackgroundColor(localContext));
          return;
        }
        catch (Exception localException)
        {
          Log.e(localException, "Error while settings entry background color", new Object[0]);
        }
      }
    }, 200L);
    paramView = new AlertDialog.Builder(localContext);
    View localView = LayoutInflater.from(localContext).inflate(R.layout.lunar_layout_log_details_dialog, null);
    ImageView localImageView = (ImageView)localView.findViewById(R.id.lunar_console_log_details_icon);
    TextView localTextView1 = (TextView)localView.findViewById(R.id.lunar_console_log_details_message);
    TextView localTextView2 = (TextView)localView.findViewById(R.id.lunar_console_log_details_stacktrace);
    final String str = message;
    if (localConsoleEntry.hasStackTrace()) {}
    for (paramAdapterView = StackTrace.optimize(stackTrace);; paramAdapterView = this$0.getResources().getString(R.string.lunar_console_log_details_dialog_no_stacktrace_warning))
    {
      localTextView1.setText(str);
      localTextView2.setText(paramAdapterView);
      localImageView.setImageDrawable(localConsoleEntry.getIconDrawable(localContext));
      paramView.setView(localView);
      paramView.setPositiveButton(R.string.lunar_console_log_details_dialog_button_copy_to_clipboard, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          String str = str;
          paramAnonymousDialogInterface = str;
          if (localConsoleEntry.hasStackTrace()) {
            paramAnonymousDialogInterface = str + "\n\n" + paramAdapterView;
          }
          ConsoleView.access$000(this$0, paramAnonymousDialogInterface);
        }
      });
      paramView.create().show();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleView.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */