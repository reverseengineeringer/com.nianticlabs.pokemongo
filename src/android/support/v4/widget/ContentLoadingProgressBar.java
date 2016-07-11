package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  private static final int MIN_DELAY = 500;
  private static final int MIN_SHOW_TIME = 500;
  private final Runnable mDelayedHide = new Runnable()
  {
    public void run()
    {
      ContentLoadingProgressBar.access$002(ContentLoadingProgressBar.this, false);
      ContentLoadingProgressBar.access$102(ContentLoadingProgressBar.this, -1L);
      setVisibility(8);
    }
  };
  private final Runnable mDelayedShow = new Runnable()
  {
    public void run()
    {
      ContentLoadingProgressBar.access$202(ContentLoadingProgressBar.this, false);
      if (!mDismissed)
      {
        ContentLoadingProgressBar.access$102(ContentLoadingProgressBar.this, System.currentTimeMillis());
        setVisibility(0);
      }
    }
  };
  private boolean mDismissed = false;
  private boolean mPostedHide = false;
  private boolean mPostedShow = false;
  private long mStartTime = -1L;
  
  public ContentLoadingProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentLoadingProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void removeCallbacks()
  {
    removeCallbacks(mDelayedHide);
    removeCallbacks(mDelayedShow);
  }
  
  public void hide()
  {
    mDismissed = true;
    removeCallbacks(mDelayedShow);
    long l = System.currentTimeMillis() - mStartTime;
    if ((l >= 500L) || (mStartTime == -1L)) {
      setVisibility(8);
    }
    while (mPostedHide) {
      return;
    }
    postDelayed(mDelayedHide, 500L - l);
    mPostedHide = true;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    removeCallbacks();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks();
  }
  
  public void show()
  {
    mStartTime = -1L;
    mDismissed = false;
    removeCallbacks(mDelayedHide);
    if (!mPostedShow)
    {
      postDelayed(mDelayedShow, 500L);
      mPostedShow = true;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.ContentLoadingProgressBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */