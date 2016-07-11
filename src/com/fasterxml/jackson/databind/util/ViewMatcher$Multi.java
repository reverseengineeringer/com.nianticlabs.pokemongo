package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

final class ViewMatcher$Multi
  extends ViewMatcher
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final Class<?>[] _views;
  
  public ViewMatcher$Multi(Class<?>[] paramArrayOfClass)
  {
    _views = paramArrayOfClass;
  }
  
  public boolean isVisibleForView(Class<?> paramClass)
  {
    int i = 0;
    int j = _views.length;
    while (i < j)
    {
      Class localClass = _views[i];
      if ((paramClass == localClass) || (localClass.isAssignableFrom(paramClass))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.ViewMatcher.Multi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */