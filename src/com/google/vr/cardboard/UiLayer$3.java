package com.google.vr.cardboard;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;

class UiLayer$3
  implements Runnable
{
  UiLayer$3(UiLayer paramUiLayer, ViewGroup paramViewGroup) {}
  
  public void run()
  {
    if (val$parentView == null)
    {
      ((Activity)UiLayer.access$200(this$0)).addContentView(UiLayer.access$100(this$0), new RelativeLayout.LayoutParams(-1, -1));
      return;
    }
    val$parentView.addView(UiLayer.access$100(this$0));
  }
}

/* Location:
 * Qualified Name:     com.google.vr.cardboard.UiLayer.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */