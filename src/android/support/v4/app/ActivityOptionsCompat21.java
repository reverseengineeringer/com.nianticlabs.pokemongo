package android.support.v4.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

class ActivityOptionsCompat21
{
  private final ActivityOptions mActivityOptions;
  
  private ActivityOptionsCompat21(ActivityOptions paramActivityOptions)
  {
    mActivityOptions = paramActivityOptions;
  }
  
  public static ActivityOptionsCompat21 makeSceneTransitionAnimation(Activity paramActivity, View paramView, String paramString)
  {
    return new ActivityOptionsCompat21(ActivityOptions.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
  }
  
  public static ActivityOptionsCompat21 makeSceneTransitionAnimation(Activity paramActivity, View[] paramArrayOfView, String[] paramArrayOfString)
  {
    Object localObject = null;
    if (paramArrayOfView != null)
    {
      Pair[] arrayOfPair = new Pair[paramArrayOfView.length];
      int i = 0;
      for (;;)
      {
        localObject = arrayOfPair;
        if (i >= arrayOfPair.length) {
          break;
        }
        arrayOfPair[i] = Pair.create(paramArrayOfView[i], paramArrayOfString[i]);
        i += 1;
      }
    }
    return new ActivityOptionsCompat21(ActivityOptions.makeSceneTransitionAnimation(paramActivity, (Pair[])localObject));
  }
  
  public Bundle toBundle()
  {
    return mActivityOptions.toBundle();
  }
  
  public void update(ActivityOptionsCompat21 paramActivityOptionsCompat21)
  {
    mActivityOptions.update(mActivityOptions);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */