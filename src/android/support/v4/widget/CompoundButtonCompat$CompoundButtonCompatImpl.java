package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

abstract interface CompoundButtonCompat$CompoundButtonCompatImpl
{
  public abstract Drawable getButtonDrawable(CompoundButton paramCompoundButton);
  
  public abstract ColorStateList getButtonTintList(CompoundButton paramCompoundButton);
  
  public abstract PorterDuff.Mode getButtonTintMode(CompoundButton paramCompoundButton);
  
  public abstract void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList);
  
  public abstract void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode);
}

/* Location:
 * Qualified Name:     android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */