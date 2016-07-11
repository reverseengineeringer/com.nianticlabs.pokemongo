package android.support.v4.widget;

import android.widget.PopupWindow;

class PopupWindowCompat$Api23PopupWindowImpl
  extends PopupWindowCompat.Api21PopupWindowImpl
{
  public boolean getOverlapAnchor(PopupWindow paramPopupWindow)
  {
    return PopupWindowCompatApi23.getOverlapAnchor(paramPopupWindow);
  }
  
  public int getWindowLayoutType(PopupWindow paramPopupWindow)
  {
    return PopupWindowCompatApi23.getWindowLayoutType(paramPopupWindow);
  }
  
  public void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    PopupWindowCompatApi23.setOverlapAnchor(paramPopupWindow, paramBoolean);
  }
  
  public void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
  {
    PopupWindowCompatApi23.setWindowLayoutType(paramPopupWindow, paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.PopupWindowCompat.Api23PopupWindowImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */