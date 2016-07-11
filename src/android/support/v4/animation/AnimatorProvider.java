package android.support.v4.animation;

import android.view.View;

abstract interface AnimatorProvider
{
  public abstract void clearInterpolator(View paramView);
  
  public abstract ValueAnimatorCompat emptyValueAnimator();
}

/* Location:
 * Qualified Name:     android.support.v4.animation.AnimatorProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */