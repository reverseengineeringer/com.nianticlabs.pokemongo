package com.unity3d.player;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;

final class s$1
  implements View.OnFocusChangeListener
{
  s$1(s params) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      a.getWindow().setSoftInputMode(5);
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.s.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */