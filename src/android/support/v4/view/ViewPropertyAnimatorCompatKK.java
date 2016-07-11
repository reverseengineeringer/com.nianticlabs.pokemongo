package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;

class ViewPropertyAnimatorCompatKK
{
  public static void setUpdateListener(final View paramView, ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener)
  {
    paramView.animate().setUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        val$listener.onAnimationUpdate(paramView);
      }
    });
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompatKK
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */