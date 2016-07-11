package com.unity3d.player;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;

public class UnityPlayerActivity
  extends Activity
{
  protected UnityPlayer mUnityPlayer;
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 2) {
      return mUnityPlayer.injectEvent(paramKeyEvent);
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    mUnityPlayer.configurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setFormat(2);
    mUnityPlayer = new UnityPlayer(this);
    setContentView(mUnityPlayer);
    mUnityPlayer.requestFocus();
  }
  
  protected void onDestroy()
  {
    mUnityPlayer.quit();
    super.onDestroy();
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return mUnityPlayer.injectEvent(paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return mUnityPlayer.injectEvent(paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return mUnityPlayer.injectEvent(paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    mUnityPlayer.pause();
  }
  
  protected void onResume()
  {
    super.onResume();
    mUnityPlayer.resume();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return mUnityPlayer.injectEvent(paramMotionEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    mUnityPlayer.windowFocusChanged(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.UnityPlayerActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */