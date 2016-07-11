package spacemadness.com.lunarconsole.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class ToggleImageButton
  extends ImageButton
{
  private Drawable offDrawable;
  private boolean on;
  private Drawable onDrawable;
  private OnStateChangeListener stateChangeListener;
  
  public ToggleImageButton(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ToggleImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ToggleImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  @TargetApi(21)
  public ToggleImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
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
        paramAnonymousView = ToggleImageButton.this;
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
  
  public Drawable getOffDrawable()
  {
    return offDrawable;
  }
  
  public Drawable getOnDrawable()
  {
    return onDrawable;
  }
  
  public OnStateChangeListener getOnStateChangeListener()
  {
    return stateChangeListener;
  }
  
  public boolean isOn()
  {
    return on;
  }
  
  public void setOffDrawable(Drawable paramDrawable)
  {
    offDrawable = paramDrawable;
  }
  
  public void setOn(boolean paramBoolean)
  {
    boolean bool = on;
    on = paramBoolean;
    if (on) {}
    for (Drawable localDrawable = onDrawable;; localDrawable = offDrawable)
    {
      if (localDrawable != null) {
        setImageDrawable(localDrawable);
      }
      if (bool != paramBoolean) {
        notifyStateChanged();
      }
      return;
    }
  }
  
  public void setOnDrawable(Drawable paramDrawable)
  {
    onDrawable = paramDrawable;
  }
  
  public void setOnStateChangeListener(OnStateChangeListener paramOnStateChangeListener)
  {
    stateChangeListener = paramOnStateChangeListener;
  }
  
  public static abstract interface OnStateChangeListener
  {
    public abstract void onStateChanged(ToggleImageButton paramToggleImageButton);
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.ui.ToggleImageButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */