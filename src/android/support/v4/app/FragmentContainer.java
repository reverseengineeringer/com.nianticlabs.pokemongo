package android.support.v4.app;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;

public abstract class FragmentContainer
{
  @Nullable
  public abstract View onFindViewById(@IdRes int paramInt);
  
  public abstract boolean onHasView();
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentContainer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */