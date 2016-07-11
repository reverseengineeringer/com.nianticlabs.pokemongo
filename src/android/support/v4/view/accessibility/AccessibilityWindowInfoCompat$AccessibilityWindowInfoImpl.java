package android.support.v4.view.accessibility;

import android.graphics.Rect;

abstract interface AccessibilityWindowInfoCompat$AccessibilityWindowInfoImpl
{
  public abstract void getBoundsInScreen(Object paramObject, Rect paramRect);
  
  public abstract Object getChild(Object paramObject, int paramInt);
  
  public abstract int getChildCount(Object paramObject);
  
  public abstract int getId(Object paramObject);
  
  public abstract int getLayer(Object paramObject);
  
  public abstract Object getParent(Object paramObject);
  
  public abstract Object getRoot(Object paramObject);
  
  public abstract int getType(Object paramObject);
  
  public abstract boolean isAccessibilityFocused(Object paramObject);
  
  public abstract boolean isActive(Object paramObject);
  
  public abstract boolean isFocused(Object paramObject);
  
  public abstract Object obtain();
  
  public abstract Object obtain(Object paramObject);
  
  public abstract void recycle(Object paramObject);
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityWindowInfoCompat.AccessibilityWindowInfoImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */