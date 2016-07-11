package com.nianticlabs.nia.unity;

import android.app.Activity;
import android.util.Log;
import java.lang.reflect.Field;

public class UnityUtil
{
  private static final String TAG = UnityUtil.class.getSimpleName();
  private static volatile Activity activity;
  
  public static Activity getActivity()
  {
    if (activity != null) {
      return activity;
    }
    try
    {
      activity = (Activity)Class.forName("com.unity3d.player.UnityPlayer").getField("currentActivity").get(null);
      Activity localActivity = activity;
      return localActivity;
    }
    catch (Exception localException)
    {
      Log.e(TAG, "Unable to get currentActivity", localException);
    }
    return null;
  }
  
  public static void init() {}
  
  private static native void nativeInit();
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.unity.UnityUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */