package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

class DrawableCompat$MDrawableImpl
  extends DrawableCompat.LollipopMr1DrawableImpl
{
  public int getLayoutDirection(Drawable paramDrawable)
  {
    return DrawableCompatApi23.getLayoutDirection(paramDrawable);
  }
  
  public void setLayoutDirection(Drawable paramDrawable, int paramInt)
  {
    DrawableCompatApi23.setLayoutDirection(paramDrawable, paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat.MDrawableImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */