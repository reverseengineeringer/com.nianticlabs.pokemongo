package spacemadness.com.lunarconsole.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;

public class LogTypeButton
  extends ToggleButton
{
  private static final int MAX_COUNT = 999;
  private int count;
  private float offAlpha;
  
  public LogTypeButton(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public LogTypeButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LogTypeButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  @TargetApi(21)
  public LogTypeButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init();
  }
  
  private void init()
  {
    count = Integer.MAX_VALUE;
    offAlpha = 0.25F;
  }
  
  public float getOffAlpha()
  {
    return offAlpha;
  }
  
  public void setCount(int paramInt)
  {
    if (count != paramInt)
    {
      if (paramInt >= 999) {
        break label29;
      }
      setText(Integer.toString(paramInt));
    }
    for (;;)
    {
      count = paramInt;
      return;
      label29:
      if (count < 999) {
        setText("999+");
      }
    }
  }
  
  public void setOffAlpha(float paramFloat)
  {
    offAlpha = paramFloat;
  }
  
  public void setOn(boolean paramBoolean)
  {
    super.setOn(paramBoolean);
    if (Build.VERSION.SDK_INT >= 11) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (float f = 1.0F;; f = offAlpha)
    {
      setAlpha(f);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.ui.LogTypeButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */