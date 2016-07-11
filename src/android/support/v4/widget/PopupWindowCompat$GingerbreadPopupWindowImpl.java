package android.support.v4.widget;

import android.widget.PopupWindow;

class PopupWindowCompat$GingerbreadPopupWindowImpl
  extends PopupWindowCompat.BasePopupWindowImpl
{
  public int getWindowLayoutType(PopupWindow paramPopupWindow)
  {
    return PopupWindowCompatGingerbread.getWindowLayoutType(paramPopupWindow);
  }
  
  public void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
  {
    PopupWindowCompatGingerbread.setWindowLayoutType(paramPopupWindow, paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.PopupWindowCompat.GingerbreadPopupWindowImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */