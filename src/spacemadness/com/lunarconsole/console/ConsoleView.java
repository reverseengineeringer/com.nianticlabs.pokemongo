package spacemadness.com.lunarconsole.console;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import spacemadness.com.lunarconsole.R.drawable;
import spacemadness.com.lunarconsole.R.id;
import spacemadness.com.lunarconsole.R.layout;
import spacemadness.com.lunarconsole.R.string;
import spacemadness.com.lunarconsole.core.Destroyable;
import spacemadness.com.lunarconsole.debug.Log;
import spacemadness.com.lunarconsole.debug.Tags;
import spacemadness.com.lunarconsole.ui.LogTypeButton;
import spacemadness.com.lunarconsole.ui.ToggleButton;
import spacemadness.com.lunarconsole.ui.ToggleButton.OnStateChangeListener;
import spacemadness.com.lunarconsole.ui.ToggleImageButton;
import spacemadness.com.lunarconsole.ui.ToggleImageButton.OnStateChangeListener;
import spacemadness.com.lunarconsole.utils.StackTrace;
import spacemadness.com.lunarconsole.utils.StringUtils;
import spacemadness.com.lunarconsole.utils.ThreadUtils;
import spacemadness.com.lunarconsole.utils.UIUtils;

public class ConsoleView
  extends LinearLayout
  implements Destroyable, LunarConsoleListener, ToggleButton.OnStateChangeListener
{
  private final Console console;
  private final LogTypeButton errorButton;
  private final ListView listView;
  private Listener listener;
  private final LogTypeButton logButton;
  private final TextView overflowText;
  private final ConsoleAdapter recyclerViewAdapter;
  private final View rootView;
  private ToggleImageButton scrollLockButton;
  private boolean scrollLocked;
  private boolean softKeyboardVisible;
  private final LogTypeButton warningButton;
  
  public ConsoleView(Context paramContext, final Console paramConsole)
  {
    super(paramContext);
    if (paramConsole == null) {
      throw new NullPointerException("Console is null");
    }
    console = paramConsole;
    console.setConsoleListener(this);
    scrollLocked = ConsoleViewState.scrollLocked;
    setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    rootView = LayoutInflater.from(paramContext).inflate(R.layout.lunar_layout_console, this, false);
    addView(rootView, new LinearLayout.LayoutParams(-1, -1));
    recyclerViewAdapter = new ConsoleAdapter(paramConsole);
    LinearLayout localLinearLayout = (LinearLayout)findExistingViewById(R.id.lunar_console_recycler_view_container);
    listView = new ListView(paramContext);
    listView.setDivider(null);
    listView.setDividerHeight(0);
    listView.setAdapter(recyclerViewAdapter);
    listView.setOverScrollMode(2);
    listView.setScrollingCacheEnabled(false);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(final AdapterView<?> paramAnonymousAdapterView, final View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        final Context localContext = getContext();
        final ConsoleEntry localConsoleEntry = paramConsole.getEntry(paramAnonymousInt);
        paramAnonymousView.setBackgroundColor(-16777216);
        ThreadUtils.runOnUIThread(new Runnable()
        {
          public void run()
          {
            try
            {
              paramAnonymousView.setBackgroundColor(localConsoleEntry.getBackgroundColor(localContext));
              return;
            }
            catch (Exception localException)
            {
              Log.e(localException, "Error while settings entry background color", new Object[0]);
            }
          }
        }, 200L);
        paramAnonymousView = new AlertDialog.Builder(localContext);
        View localView = LayoutInflater.from(localContext).inflate(R.layout.lunar_layout_log_details_dialog, null);
        ImageView localImageView = (ImageView)localView.findViewById(R.id.lunar_console_log_details_icon);
        TextView localTextView1 = (TextView)localView.findViewById(R.id.lunar_console_log_details_message);
        TextView localTextView2 = (TextView)localView.findViewById(R.id.lunar_console_log_details_stacktrace);
        final String str = message;
        if (localConsoleEntry.hasStackTrace()) {}
        for (paramAnonymousAdapterView = StackTrace.optimize(stackTrace);; paramAnonymousAdapterView = getResources().getString(R.string.lunar_console_log_details_dialog_no_stacktrace_warning))
        {
          localTextView1.setText(str);
          localTextView2.setText(paramAnonymousAdapterView);
          localImageView.setImageDrawable(localConsoleEntry.getIconDrawable(localContext));
          paramAnonymousView.setView(localView);
          paramAnonymousView.setPositiveButton(R.string.lunar_console_log_details_dialog_button_copy_to_clipboard, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              String str = str;
              paramAnonymous2DialogInterface = str;
              if (localConsoleEntry.hasStackTrace()) {
                paramAnonymous2DialogInterface = str + "\n\n" + paramAnonymousAdapterView;
              }
              ConsoleView.this.copyToClipboard(paramAnonymous2DialogInterface);
            }
          });
          paramAnonymousView.create().show();
          return;
        }
      }
    });
    listView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if ((scrollLocked) && (paramAnonymousMotionEvent.getAction() == 0)) {
          scrollLockButton.setOn(false);
        }
        return false;
      }
    });
    localLinearLayout.addView(listView, new LinearLayout.LayoutParams(-1, -1));
    setupFilterTextEdit();
    logButton = ((LogTypeButton)findExistingViewById(R.id.lunar_console_log_button));
    warningButton = ((LogTypeButton)findExistingViewById(R.id.lunar_console_warning_button));
    errorButton = ((LogTypeButton)findExistingViewById(R.id.lunar_console_error_button));
    setupLogTypeButtons();
    setupOperationsButtons();
    setupFakeStatusBar();
    overflowText = ((TextView)findExistingViewById(R.id.lunar_console_text_overflow));
    reloadData();
  }
  
  private void clearConsole()
  {
    console.clear();
  }
  
  private boolean copyConsoleOutputToClipboard()
  {
    return copyToClipboard(console.getText());
  }
  
  private boolean copyToClipboard(String paramString)
  {
    try
    {
      ((ClipboardManager)getContext().getSystemService("clipboard")).setText(paramString);
      UIUtils.showToast(getContext(), "Copied to clipboard");
      return true;
    }
    catch (Exception paramString)
    {
      Log.e(paramString, "Error to copy text to clipboard", new Object[0]);
    }
    return false;
  }
  
  private void filterByText(String paramString)
  {
    if (console.entries().setFilterByText(paramString)) {
      reloadData();
    }
  }
  
  private <T extends View> T findExistingViewById(int paramInt)
    throws ClassCastException
  {
    return findExistingViewById(rootView, paramInt);
  }
  
  private <T extends View> T findExistingViewById(View paramView, int paramInt)
    throws ClassCastException
  {
    paramView = paramView.findViewById(paramInt);
    if (paramView == null) {
      throw new IllegalArgumentException("View with id " + paramInt + " not found");
    }
    return paramView;
  }
  
  private void hideSoftKeyboard()
  {
    softKeyboardVisible = false;
    ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  private void notifyClose()
  {
    softKeyboardVisible = false;
    if (listener != null) {
      listener.onClose(this);
    }
  }
  
  private void reloadData()
  {
    recyclerViewAdapter.notifyDataSetChanged();
    updateOverflowText();
  }
  
  private void scrollToBottom(Console paramConsole)
  {
    if (scrollLocked)
    {
      int i = paramConsole.getEntryCount();
      if (i > 0) {
        listView.setSelection(i - 1);
      }
    }
  }
  
  private void scrollToTop(Console paramConsole)
  {
    if (paramConsole.getEntryCount() > 0) {
      listView.setSelection(0);
    }
  }
  
  private boolean sendConsoleOutputByEmail()
  {
    try
    {
      String str1 = StringUtils.TryFormat("'%s' console log", new Object[] { getContext().getPackageName() });
      String str2 = console.getText();
      Intent localIntent = new Intent("android.intent.action.SENDTO");
      localIntent.setData(Uri.parse("mailto:"));
      localIntent.putExtra("android.intent.extra.SUBJECT", str1);
      localIntent.putExtra("android.intent.extra.TEXT", str2);
      if (localIntent.resolveActivity(getContext().getPackageManager()) != null)
      {
        getContext().startActivity(localIntent);
        return true;
      }
      UIUtils.showToast(getContext(), "Can't send email");
      return false;
    }
    catch (Exception localException)
    {
      Log.e(localException, "Error while trying to send console output by email", new Object[0]);
    }
    return false;
  }
  
  private void setFilterByLogTypeMask(int paramInt, boolean paramBoolean)
  {
    if (console.entries().setFilterByLogTypeMask(paramInt, paramBoolean)) {
      reloadData();
    }
  }
  
  private void setOnClickListener(int paramInt, View.OnClickListener paramOnClickListener)
  {
    findExistingViewById(paramInt).setOnClickListener(paramOnClickListener);
  }
  
  private void setupFakeStatusBar()
  {
    String str = String.format(getResources().getString(R.string.lunar_console_title_fake_status_bar), new Object[] { ConsolePlugin.getVersion() });
    TextView localTextView = (TextView)findExistingViewById(R.id.lunar_console_fake_status_bar);
    localTextView.setText(str);
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        scrollLockButton.setOn(false);
        ConsoleView.this.scrollToTop(console);
      }
    });
  }
  
  private EditText setupFilterTextEdit()
  {
    EditText localEditText = (EditText)findExistingViewById(R.id.lunar_console_text_edit_filter);
    String str = console.entries().getFilterText();
    if (!StringUtils.IsNullOrEmpty(str))
    {
      localEditText.setText(str);
      localEditText.setSelection(str.length());
    }
    localEditText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        ConsoleView.this.filterByText(paramAnonymousEditable.toString());
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    localEditText.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ConsoleView.access$402(ConsoleView.this, true);
      }
    });
    localEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 3)
        {
          ConsoleView.this.hideSoftKeyboard();
          return true;
        }
        return false;
      }
    });
    return localEditText;
  }
  
  private void setupLogTypeButton(LogTypeButton paramLogTypeButton, int paramInt)
  {
    paramLogTypeButton.setOn(console.entries().isFilterLogTypeEnabled(paramInt));
    paramLogTypeButton.setOnStateChangeListener(this);
  }
  
  private void setupLogTypeButtons()
  {
    setupLogTypeButton(logButton, 3);
    setupLogTypeButton(warningButton, 2);
    setupLogTypeButton(errorButton, 0);
    updateLogButtons();
  }
  
  private void setupOperationsButtons()
  {
    setOnClickListener(R.id.lunar_console_button_clear, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ConsoleView.this.clearConsole();
      }
    });
    scrollLockButton = ((ToggleImageButton)rootView.findViewById(R.id.lunar_console_button_lock));
    Resources localResources = getContext().getResources();
    scrollLockButton.setOnDrawable(localResources.getDrawable(R.drawable.lunar_console_icon_button_lock));
    scrollLockButton.setOffDrawable(localResources.getDrawable(R.drawable.lunar_console_icon_button_unlock));
    scrollLockButton.setOn(scrollLocked);
    scrollLockButton.setOnStateChangeListener(new ToggleImageButton.OnStateChangeListener()
    {
      public void onStateChanged(ToggleImageButton paramAnonymousToggleImageButton)
      {
        ConsoleView.this.toggleScrollLock();
      }
    });
    setOnClickListener(R.id.lunar_console_button_copy, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ConsoleView.this.copyConsoleOutputToClipboard();
      }
    });
    setOnClickListener(R.id.lunar_console_button_email, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ConsoleView.this.sendConsoleOutputByEmail();
      }
    });
    setOnClickListener(R.id.lunar_console_button_close, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ConsoleView.this.notifyClose();
      }
    });
  }
  
  private void toggleScrollLock()
  {
    if (!scrollLocked) {}
    for (boolean bool = true;; bool = false)
    {
      scrollLocked = bool;
      ConsoleViewState.scrollLocked = scrollLocked;
      scrollToBottom(console);
      return;
    }
  }
  
  private void updateLogButtons()
  {
    ConsoleEntryList localConsoleEntryList = console.entries();
    logButton.setCount(localConsoleEntryList.getLogCount());
    warningButton.setCount(localConsoleEntryList.getWarningCount());
    errorButton.setCount(localConsoleEntryList.getErrorCount());
  }
  
  private void updateOverflowText()
  {
    int i = console.trimmedCount();
    if (i > 0)
    {
      overflowText.setVisibility(0);
      String str = getResources().getString(R.string.lunar_console_overflow_warning_text, new Object[] { Integer.valueOf(i) });
      overflowText.setText(str);
      return;
    }
    overflowText.setVisibility(8);
  }
  
  public void destroy()
  {
    Log.d(Tags.CONSOLE, "Destroy console", new Object[0]);
    console.setConsoleListener(null);
    setListener(null);
  }
  
  public boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (paramKeyEvent.getAction() == 1)
      {
        if (softKeyboardVisible) {
          hideSoftKeyboard();
        }
      }
      else {
        return true;
      }
      notifyClose();
      return true;
    }
    return super.dispatchKeyEventPreIme(paramKeyEvent);
  }
  
  public Listener getListener()
  {
    return listener;
  }
  
  public void onAddEntry(Console paramConsole, ConsoleEntry paramConsoleEntry, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      recyclerViewAdapter.notifyDataSetChanged();
      scrollToBottom(paramConsole);
    }
    updateLogButtons();
  }
  
  public void onClearEntries(Console paramConsole)
  {
    reloadData();
    updateLogButtons();
  }
  
  public void onRemoveEntries(Console paramConsole, int paramInt1, int paramInt2)
  {
    recyclerViewAdapter.notifyDataSetChanged();
    scrollToBottom(paramConsole);
    updateLogButtons();
    updateOverflowText();
  }
  
  public void onStateChanged(ToggleButton paramToggleButton)
  {
    boolean bool = true;
    int i = 0;
    if (paramToggleButton == logButton)
    {
      i = 0x0 | ConsoleLogType.getMask(3);
      if (paramToggleButton.isOn()) {
        break label79;
      }
    }
    for (;;)
    {
      setFilterByLogTypeMask(i, bool);
      return;
      if (paramToggleButton == warningButton)
      {
        i = 0x0 | ConsoleLogType.getMask(2);
        break;
      }
      if (paramToggleButton != errorButton) {
        break;
      }
      i = 0x0 | ConsoleLogType.getMask(4) | ConsoleLogType.getMask(0) | ConsoleLogType.getMask(1);
      break;
      label79:
      bool = false;
    }
  }
  
  public void setListener(Listener paramListener)
  {
    listener = paramListener;
  }
  
  public static abstract interface Listener
  {
    public abstract void onClose(ConsoleView paramConsoleView);
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.ConsoleView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */