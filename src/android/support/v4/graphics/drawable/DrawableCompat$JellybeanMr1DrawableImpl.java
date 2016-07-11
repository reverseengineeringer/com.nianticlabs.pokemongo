package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

class DrawableCompat$JellybeanMr1DrawableImpl
  extends DrawableCompat.HoneycombDrawableImpl
{
  public int getLayoutDirection(Drawable paramDrawable)
  {
    int i = DrawableCompatJellybeanMr1.getLayoutDirection(paramDrawable);
    if (i < 0) {
      return i;
    }
    return 0;
  }
  
  public void setLayoutDirection(Drawable paramDrawable, int paramInt)
  {
    DrawableCompatJellybeanMr1.setLayoutDirection(paramDrawable, paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat.JellybeanMr1DrawableImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */