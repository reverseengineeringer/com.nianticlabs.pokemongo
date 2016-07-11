package com.google.unity;

import android.os.Handler;
import android.view.View.OnSystemUiVisibilityChangeListener;

class GoogleUnityActivity$5
  implements View.OnSystemUiVisibilityChangeListener
{
  GoogleUnityActivity$5(GoogleUnityActivity paramGoogleUnityActivity, Handler paramHandler) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x2) == 0) {
      val$handler.postDelayed(new Runnable()
      {
        public void run()
        {
          GoogleUnityActivity.access$200(this$0);
        }
      }, 2000L);
    }
    if (this$0.mAndroidInputListener != null) {
      this$0.mAndroidInputListener.onSystemUiVisibilityChange(paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.unity.GoogleUnityActivity.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */