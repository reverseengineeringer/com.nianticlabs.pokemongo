package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.View;

public class ActivityOptionsCompat
{
  public static ActivityOptionsCompat makeCustomAnimation(Context paramContext, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(paramContext, paramInt1, paramInt2));
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeScaleUpAnimation(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(paramActivity, paramView, paramString));
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity paramActivity, Pair<View, String>... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      if (paramVarArgs != null)
      {
        View[] arrayOfView = new View[paramVarArgs.length];
        String[] arrayOfString = new String[paramVarArgs.length];
        int i = 0;
        for (;;)
        {
          localObject1 = arrayOfString;
          localObject2 = arrayOfView;
          if (i >= paramVarArgs.length) {
            break;
          }
          arrayOfView[i] = ((View)first);
          arrayOfString[i] = ((String)second);
          i += 1;
        }
      }
      return new ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(paramActivity, (View[])localObject2, (String[])localObject1));
    }
    return new ActivityOptionsCompat();
  }
  
  public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View paramView, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(paramView, paramBitmap, paramInt1, paramInt2));
    }
    return new ActivityOptionsCompat();
  }
  
  public Bundle toBundle()
  {
    return null;
  }
  
  public void update(ActivityOptionsCompat paramActivityOptionsCompat) {}
  
  private static class ActivityOptionsImpl21
    extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompat21 mImpl;
    
    ActivityOptionsImpl21(ActivityOptionsCompat21 paramActivityOptionsCompat21)
    {
      mImpl = paramActivityOptionsCompat21;
    }
    
    public Bundle toBundle()
    {
      return mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsImpl21))
      {
        paramActivityOptionsCompat = (ActivityOptionsImpl21)paramActivityOptionsCompat;
        mImpl.update(mImpl);
      }
    }
  }
  
  private static class ActivityOptionsImplJB
    extends ActivityOptionsCompat
  {
    private final ActivityOptionsCompatJB mImpl;
    
    ActivityOptionsImplJB(ActivityOptionsCompatJB paramActivityOptionsCompatJB)
    {
      mImpl = paramActivityOptionsCompatJB;
    }
    
    public Bundle toBundle()
    {
      return mImpl.toBundle();
    }
    
    public void update(ActivityOptionsCompat paramActivityOptionsCompat)
    {
      if ((paramActivityOptionsCompat instanceof ActivityOptionsImplJB))
      {
        paramActivityOptionsCompat = (ActivityOptionsImplJB)paramActivityOptionsCompat;
        mImpl.update(mImpl);
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.ActivityOptionsCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */