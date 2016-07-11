package spacemadness.com.lunarconsole.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ToggleButton
  extends Button
{
  private boolean on;
  private OnStateChangeListener stateChangeListener;
  
  public ToggleButton(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ToggleButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ToggleButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  @TargetApi(21)
  public ToggleButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init();
  }
  
  private void init()
  {
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = ToggleButton.this;
        if (!on) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setOn(bool);
          return;
        }
      }
    });
  }
  
  private void notifyStateChanged()
  {
    if (stateChangeListener != null) {
      stateChangeListener.onStateChanged(this);
    }
  }
  
  public OnStateChangeListener getOnStateChangeListener()
  {
    return stateChangeListener;
  }
  
  public boolean isOn()
  {
    return on;
  }
  
  public void setOn(boolean paramBoolean)
  {
    if (on != paramBoolean)
    {
      on = paramBoolean;
      notifyStateChanged();
    }
  }
  
  public void setOnStateChangeListener(OnStateChangeListener paramOnStateChangeListener)
  {
    stateChangeListener = paramOnStateChangeListener;
  }
  
  public static abstract interface OnStateChangeListener
  {
    public abstract void onStateChanged(ToggleButton paramToggleButton);
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.ui.ToggleButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */