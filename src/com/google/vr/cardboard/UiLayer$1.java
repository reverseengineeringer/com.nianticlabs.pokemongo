package com.google.vr.cardboard;

import android.view.View;
import android.view.View.OnClickListener;

class UiLayer$1
  implements View.OnClickListener
{
  UiLayer$1(UiLayer paramUiLayer) {}
  
  public void onClick(View paramView)
  {
    UiUtils.launchOrInstallCardboard(paramView.getContext());
  }
}

/* Location:
 * Qualified Name:     com.google.vr.cardboard.UiLayer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */