package com.unity3d.player;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class t
{
  public static t a;
  private final ViewGroup b;
  private Set c = new HashSet();
  private View d;
  private View e;
  
  t(ViewGroup paramViewGroup)
  {
    b = paramViewGroup;
    a = this;
  }
  
  private void e(View paramView)
  {
    b.addView(paramView, b.getChildCount());
  }
  
  private void f(View paramView)
  {
    b.removeView(paramView);
    b.requestLayout();
  }
  
  public final Context a()
  {
    return b.getContext();
  }
  
  public final void a(View paramView)
  {
    c.add(paramView);
    if (d != null) {
      e(paramView);
    }
  }
  
  public final void b(View paramView)
  {
    c.remove(paramView);
    if (d != null) {
      f(paramView);
    }
  }
  
  public final void c(View paramView)
  {
    if (d != paramView)
    {
      d = paramView;
      b.addView(paramView);
      paramView = c.iterator();
      while (paramView.hasNext()) {
        e((View)paramView.next());
      }
      if (e != null) {
        e.setVisibility(4);
      }
    }
  }
  
  public final void d(View paramView)
  {
    if (d == paramView)
    {
      Iterator localIterator = c.iterator();
      while (localIterator.hasNext()) {
        f((View)localIterator.next());
      }
      b.removeView(paramView);
      d = null;
      if (e != null) {
        e.setVisibility(0);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */