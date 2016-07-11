package android.support.v4.app;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

public abstract interface ActionBarDrawerToggle$Delegate
{
  @Nullable
  public abstract Drawable getThemeUpIndicator();
  
  public abstract void setActionBarDescription(@StringRes int paramInt);
  
  public abstract void setActionBarUpIndicator(Drawable paramDrawable, @StringRes int paramInt);
}

/* Location:
 * Qualified Name:     android.support.v4.app.ActionBarDrawerToggle.Delegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */