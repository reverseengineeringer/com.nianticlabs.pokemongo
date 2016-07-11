package com.google.unity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.PopupWindow;

class GoogleUnityActivity$4
  implements Runnable
{
  GoogleUnityActivity$4(GoogleUnityActivity paramGoogleUnityActivity, Activity paramActivity, int paramInt) {}
  
  public void run()
  {
    if (GoogleUnityActivity.access$000(this$0) != null)
    {
      GoogleUnityActivity.access$000(this$0).dismiss();
      GoogleUnityActivity.access$002(this$0, null);
    }
    GoogleUnityActivity.access$002(this$0, new PopupWindow(val$self));
    GoogleUnityActivity.access$000(this$0).setWindowLayoutMode(-1, -1);
    GoogleUnityActivity.access$000(this$0).setClippingEnabled(false);
    GoogleUnityActivity.access$000(this$0).setBackgroundDrawable(null);
    LayoutInflater localLayoutInflater = LayoutInflater.from(val$self);
    GoogleUnityActivity.access$102(this$0, localLayoutInflater.inflate(val$layoutResId, null));
    GoogleUnityActivity.access$000(this$0).setContentView(GoogleUnityActivity.access$100(this$0));
    GoogleUnityActivity.access$000(this$0).setTouchable(false);
    GoogleUnityActivity.access$000(this$0).showAtLocation(val$self.getWindow().getDecorView(), 80, 0, 0);
  }
}

/* Location:
 * Qualified Name:     com.google.unity.GoogleUnityActivity.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */