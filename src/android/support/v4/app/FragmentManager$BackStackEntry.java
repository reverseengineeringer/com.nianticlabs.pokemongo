package android.support.v4.app;

import android.support.annotation.StringRes;

public abstract interface FragmentManager$BackStackEntry
{
  public abstract CharSequence getBreadCrumbShortTitle();
  
  @StringRes
  public abstract int getBreadCrumbShortTitleRes();
  
  public abstract CharSequence getBreadCrumbTitle();
  
  @StringRes
  public abstract int getBreadCrumbTitleRes();
  
  public abstract int getId();
  
  public abstract String getName();
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentManager.BackStackEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */