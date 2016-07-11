package com.unity3d.player;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class s$3
  implements TextView.OnEditorActionListener
{
  s$3(s params) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6) {
      s.a(a, s.a(a), false);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.s.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */