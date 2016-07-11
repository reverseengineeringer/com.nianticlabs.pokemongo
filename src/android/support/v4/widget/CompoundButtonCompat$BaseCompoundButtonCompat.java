package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

class CompoundButtonCompat$BaseCompoundButtonCompat
  implements CompoundButtonCompat.CompoundButtonCompatImpl
{
  public Drawable getButtonDrawable(CompoundButton paramCompoundButton)
  {
    return CompoundButtonCompatDonut.getButtonDrawable(paramCompoundButton);
  }
  
  public ColorStateList getButtonTintList(CompoundButton paramCompoundButton)
  {
    return CompoundButtonCompatDonut.getButtonTintList(paramCompoundButton);
  }
  
  public PorterDuff.Mode getButtonTintMode(CompoundButton paramCompoundButton)
  {
    return CompoundButtonCompatDonut.getButtonTintMode(paramCompoundButton);
  }
  
  public void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    CompoundButtonCompatDonut.setButtonTintList(paramCompoundButton, paramColorStateList);
  }
  
  public void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    CompoundButtonCompatDonut.setButtonTintMode(paramCompoundButton, paramMode);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.CompoundButtonCompat.BaseCompoundButtonCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */