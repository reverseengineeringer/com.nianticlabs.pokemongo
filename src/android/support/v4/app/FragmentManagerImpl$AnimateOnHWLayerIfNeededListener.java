package android.support.v4.app;

import android.support.annotation.CallSuper;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FragmentManagerImpl$AnimateOnHWLayerIfNeededListener
  implements Animation.AnimationListener
{
  private boolean mShouldRunOnHWLayer = false;
  private View mView;
  
  public FragmentManagerImpl$AnimateOnHWLayerIfNeededListener(View paramView, Animation paramAnimation)
  {
    if ((paramView == null) || (paramAnimation == null)) {
      return;
    }
    mView = paramView;
  }
  
  @CallSuper
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (mShouldRunOnHWLayer) {
      mView.post(new Runnable()
      {
        public void run()
        {
          ViewCompat.setLayerType(mView, 0, null);
        }
      });
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  @CallSuper
  public void onAnimationStart(Animation paramAnimation)
  {
    mShouldRunOnHWLayer = FragmentManagerImpl.shouldRunOnHWLayer(mView, paramAnimation);
    if (mShouldRunOnHWLayer) {
      mView.post(new Runnable()
      {
        public void run()
        {
          ViewCompat.setLayerType(mView, 2, null);
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.AnimateOnHWLayerIfNeededListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */