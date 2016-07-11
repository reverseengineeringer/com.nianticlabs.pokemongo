package android.support.v4.app;

import android.view.View;
import android.view.animation.Animation;

class FragmentManagerImpl$5
  extends FragmentManagerImpl.AnimateOnHWLayerIfNeededListener
{
  FragmentManagerImpl$5(FragmentManagerImpl paramFragmentManagerImpl, View paramView, Animation paramAnimation, Fragment paramFragment)
  {
    super(paramView, paramAnimation);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    if (val$fragment.mAnimatingAway != null)
    {
      val$fragment.mAnimatingAway = null;
      this$0.moveToState(val$fragment, val$fragment.mStateAfterAnimating, 0, 0, false);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */