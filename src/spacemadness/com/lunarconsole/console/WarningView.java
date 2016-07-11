package spacemadness.com.lunarconsole.console;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import spacemadness.com.lunarconsole.R.id;
import spacemadness.com.lunarconsole.R.layout;
import spacemadness.com.lunarconsole.core.Destroyable;
import spacemadness.com.lunarconsole.debug.Log;
import spacemadness.com.lunarconsole.debug.Tags;

public class WarningView
  extends FrameLayout
  implements Destroyable
{
  private Listener listener;
  private TextView messageText;
  
  public WarningView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public WarningView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  @TargetApi(11)
  public WarningView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  @TargetApi(21)
  public WarningView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.lunar_layout_warning, null, false);
    setupUI(paramContext);
    addView(paramContext, new FrameLayout.LayoutParams(-1, -2, 81));
  }
  
  private void notifyDetails()
  {
    if (listener != null) {}
    try
    {
      listener.onDetailsClick(this);
      return;
    }
    catch (Exception localException)
    {
      Log.e("Error while notifying listener", new Object[0]);
    }
  }
  
  private void notifyDismiss()
  {
    if (listener != null) {}
    try
    {
      listener.onDismissClick(this);
      return;
    }
    catch (Exception localException)
    {
      Log.e("Error while notifying listener", new Object[0]);
    }
  }
  
  private void setOnClickListener(View paramView, int paramInt, View.OnClickListener paramOnClickListener)
  {
    paramView.findViewById(paramInt).setOnClickListener(paramOnClickListener);
  }
  
  private void setupUI(View paramView)
  {
    messageText = ((TextView)paramView.findViewById(R.id.lunar_console_text_warning_message));
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    setOnClickListener(paramView, R.id.lunar_console_button_dismiss, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        WarningView.this.notifyDismiss();
      }
    });
    setOnClickListener(paramView, R.id.lunar_console_button_details, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        WarningView.this.notifyDetails();
      }
    });
  }
  
  public void destroy()
  {
    Log.d(Tags.WARNING_VIEW, "Destroy warning", new Object[0]);
    listener = null;
  }
  
  public Listener getListener()
  {
    return listener;
  }
  
  public void setListener(Listener paramListener)
  {
    listener = paramListener;
  }
  
  public void setMessage(String paramString)
  {
    messageText.setText(paramString);
  }
  
  public static abstract interface Listener
  {
    public abstract void onDetailsClick(WarningView paramWarningView);
    
    public abstract void onDismissClick(WarningView paramWarningView);
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.WarningView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */