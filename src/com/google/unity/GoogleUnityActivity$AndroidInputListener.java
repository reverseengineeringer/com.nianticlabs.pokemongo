package com.google.unity;

import android.view.KeyEvent;
import android.view.MotionEvent;

public abstract interface GoogleUnityActivity$AndroidInputListener
{
  public abstract boolean onGenericMotionEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract void onSystemUiVisibilityChange(int paramInt);
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
}

/* Location:
 * Qualified Name:     com.google.unity.GoogleUnityActivity.AndroidInputListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */