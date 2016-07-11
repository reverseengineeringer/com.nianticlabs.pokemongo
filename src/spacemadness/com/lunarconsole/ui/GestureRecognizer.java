package spacemadness.com.lunarconsole.ui;

import android.view.MotionEvent;
import spacemadness.com.lunarconsole.debug.Log;

public abstract class GestureRecognizer<T extends GestureRecognizer>
{
  private OnGestureListener<T> listener;
  
  public OnGestureListener<T> getListener()
  {
    return listener;
  }
  
  protected void notifyGestureRecognizer()
  {
    if (listener != null) {}
    try
    {
      listener.onGesture(this);
      return;
    }
    catch (Exception localException)
    {
      Log.e(localException, "Error while notifying gesture listener", new Object[0]);
    }
  }
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public void setListener(OnGestureListener<T> paramOnGestureListener)
  {
    listener = paramOnGestureListener;
  }
  
  public static abstract interface OnGestureListener<T extends GestureRecognizer>
  {
    public abstract void onGesture(T paramT);
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.ui.GestureRecognizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */