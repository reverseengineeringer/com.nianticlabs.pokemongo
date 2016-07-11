package com.google.vr.platform.unity;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.google.unity.GoogleUnityActivity;
import com.google.unity.GoogleUnityActivity.AndroidInputListener;
import com.google.vr.cardboard.NFCUtils;
import com.google.vr.cardboard.UiLayer;
import com.google.vr.cardboard.UiUtils;
import com.unity3d.player.UnityPlayer;

public class UnityVrActivityListener
  implements GoogleUnityActivity.AndroidInputListener
{
  private static final long NO_DOWNTIME = -1L;
  private static final String TAG = UnityVrActivityListener.class.getSimpleName();
  private static final long TAP_TIME_MS = 50L;
  private boolean alignmentMarkerEnabled = true;
  private final NFCUtils nfcUtils = new NFCUtils();
  private boolean settingsButtonEnabled = true;
  private boolean showVrBackButtonOnlyInVR = true;
  private boolean tapInProgress = false;
  private boolean tapIsTrigger = false;
  private int touchX = 0;
  private int touchY = 0;
  private UiLayer uiLayer;
  private final GoogleUnityActivity unityActivity = (GoogleUnityActivity)UnityPlayer.currentActivity;
  private boolean vrBackButtonEnabled = true;
  private Runnable vrBackButtonListener = new Runnable()
  {
    public void run() {}
  };
  private boolean vrModeEnabled = true;
  
  static
  {
    System.loadLibrary("vrunity");
  }
  
  public UnityVrActivityListener()
  {
    unityActivity.attachInputListener(this);
    nfcUtils.onCreate(unityActivity);
    uiLayer = new UiLayer(unityActivity);
    uiLayer.attachUiLayer(null);
    uiLayer.setEnabled(true);
    setVRModeEnabled(vrModeEnabled);
    onPause(false);
  }
  
  public static float[] getDisplayMetrics()
  {
    Display localDisplay = UnityPlayer.currentActivity.getWindowManager().getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    try
    {
      localDisplay.getRealMetrics(localDisplayMetrics);
      return new float[] { widthPixels, heightPixels, xdpi, ydpi };
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      for (;;)
      {
        localDisplay.getMetrics(localDisplayMetrics);
      }
    }
  }
  
  private long injectMotionEventInternal(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    long l2 = SystemClock.uptimeMillis();
    long l1 = paramLong;
    if (paramLong == -1L) {
      l1 = l2;
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(l1, l2, paramInt1, paramInt2, paramInt3, 0);
    localMotionEvent.setSource(paramInt4);
    unityActivity.injectUnityEvent(localMotionEvent);
    localMotionEvent.recycle();
    return l2;
  }
  
  private static native void setApplicationState(ClassLoader paramClassLoader, Context paramContext);
  
  public static void setUnityApplicationState()
  {
    Activity localActivity = UnityPlayer.currentActivity;
    setApplicationState(localActivity.getClass().getClassLoader(), localActivity.getApplicationContext());
  }
  
  private static native void vrBackButtonPressed();
  
  public void injectKeyDown(int paramInt)
  {
    unityActivity.injectUnityEvent(new KeyEvent(0, paramInt));
  }
  
  public void injectKeyPress(final int paramInt)
  {
    injectKeyDown(paramInt);
    unityActivity.getUnityPlayer().postDelayed(new Runnable()
    {
      public void run()
      {
        injectKeyUp(paramInt);
      }
    }, 50L);
  }
  
  public void injectKeyUp(int paramInt)
  {
    unityActivity.injectUnityEvent(new KeyEvent(1, paramInt));
  }
  
  public void injectMouseMove(int paramInt1, int paramInt2)
  {
    injectMotionEventInternal(7, paramInt1, paramInt2, 8194, -1L);
  }
  
  public void injectSingleTap()
  {
    if (tapInProgress) {
      return;
    }
    tapInProgress = true;
    final int i = touchX;
    final int j = touchY;
    final long l = injectTouchDown(i, j);
    unityActivity.getUnityPlayer().postDelayed(new Runnable()
    {
      public void run()
      {
        injectTouchUp(i, j, l);
        UnityVrActivityListener.access$102(UnityVrActivityListener.this, false);
        if ((tapIsTrigger) && ((i != touchX) || (j != touchY))) {
          injectMouseMove(touchX, touchY);
        }
      }
    }, 50L);
  }
  
  public long injectTouchDown(int paramInt1, int paramInt2)
  {
    return injectMotionEventInternal(0, paramInt1, paramInt2, 4098, -1L);
  }
  
  public void injectTouchUp(int paramInt1, int paramInt2, long paramLong)
  {
    injectMotionEventInternal(1, paramInt1, paramInt2, 4098, paramLong);
  }
  
  public void launchConfigureActivity()
  {
    UiUtils.launchOrInstallCardboard(unityActivity, false);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return ((paramInt == 24) || (paramInt == 25)) && (vrModeEnabled);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return ((paramInt == 24) || (paramInt == 25)) && (vrModeEnabled);
  }
  
  public void onPause(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      nfcUtils.onPause(unityActivity);
      return;
    }
    nfcUtils.onResume(unityActivity);
  }
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((tapIsTrigger) && (vrModeEnabled)) {
      injectSingleTap();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((tapIsTrigger) && (vrModeEnabled))
    {
      if (paramMotionEvent.getAction() == 0) {
        injectSingleTap();
      }
      return true;
    }
    return false;
  }
  
  public void setAlignmentMarkerEnabled(boolean paramBoolean)
  {
    alignmentMarkerEnabled = paramBoolean;
    UiLayer localUiLayer = uiLayer;
    if ((alignmentMarkerEnabled) && (vrModeEnabled)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localUiLayer.setAlignmentMarkerEnabled(paramBoolean);
      return;
    }
  }
  
  public void setSettingsButtonEnabled(boolean paramBoolean)
  {
    settingsButtonEnabled = paramBoolean;
    UiLayer localUiLayer = uiLayer;
    if ((settingsButtonEnabled) && (vrModeEnabled)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localUiLayer.setSettingsButtonEnabled(paramBoolean);
      return;
    }
  }
  
  public void setShowVrBackButtonOnlyInVR(boolean paramBoolean)
  {
    showVrBackButtonOnlyInVR = paramBoolean;
    setVRBackButtonEnabled(vrBackButtonEnabled);
  }
  
  public void setTapIsTrigger(boolean paramBoolean)
  {
    tapIsTrigger = paramBoolean;
  }
  
  public void setTouchCoordinates(int paramInt1, int paramInt2)
  {
    touchX = paramInt1;
    touchY = paramInt2;
    if ((tapIsTrigger) && (!tapInProgress)) {
      injectMouseMove(paramInt1, paramInt2);
    }
  }
  
  public void setVRBackButtonEnabled(boolean paramBoolean)
  {
    vrBackButtonEnabled = paramBoolean;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (vrBackButtonEnabled) {
      if (!vrModeEnabled)
      {
        localObject1 = localObject2;
        if (showVrBackButtonOnlyInVR) {}
      }
      else
      {
        localObject1 = vrBackButtonListener;
      }
    }
    uiLayer.setBackButtonListener((Runnable)localObject1);
  }
  
  public void setVRModeEnabled(boolean paramBoolean)
  {
    vrModeEnabled = paramBoolean;
    setSettingsButtonEnabled(settingsButtonEnabled);
    setAlignmentMarkerEnabled(alignmentMarkerEnabled);
    setVRBackButtonEnabled(vrBackButtonEnabled);
  }
}

/* Location:
 * Qualified Name:     com.google.vr.platform.unity.UnityVrActivityListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */