package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

final class s$2
  extends EditText
{
  s$2(s params, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      s.a(a, s.a(a), true);
    }
    while (paramInt == 84) {
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      ((InputMethodManager)s.b(a).getSystemService("input_method")).showSoftInput(this, 0);
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.s.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */