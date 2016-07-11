package com.google.unity;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class GoogleUnityActivity$3
  implements View.OnKeyListener
{
  GoogleUnityActivity$3(GoogleUnityActivity paramGoogleUnityActivity) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getAction())
    {
    default: 
      return this$0.injectUnityEvent(paramKeyEvent);
    case 0: 
      return this$0.onKeyDown(paramInt, paramKeyEvent);
    }
    return this$0.onKeyUp(paramInt, paramKeyEvent);
  }
}

/* Location:
 * Qualified Name:     com.google.unity.GoogleUnityActivity.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */