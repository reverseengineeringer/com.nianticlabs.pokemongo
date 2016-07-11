package com.upsight.android.unity;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractUpsightPlugin
{
  protected static final String MANAGER_NAME = "UpsightManager";
  protected static final String TAG = "Upsight";
  private Field mUnityPlayerActivityField;
  private Class<?> mUnityPlayerClass;
  private Method mUnitySendMessageMethod;
  
  public AbstractUpsightPlugin()
  {
    try
    {
      mUnityPlayerClass = Class.forName("com.unity3d.player.UnityPlayer");
      mUnityPlayerActivityField = mUnityPlayerClass.getField("currentActivity");
      mUnitySendMessageMethod = mUnityPlayerClass.getMethod("UnitySendMessage", new Class[] { String.class, String.class, String.class });
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.i("Upsight", "could not find UnityPlayer class: " + localClassNotFoundException.getMessage());
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.i("Upsight", "could not find currentActivity field: " + localNoSuchFieldException.getMessage());
      return;
    }
    catch (Exception localException)
    {
      Log.i("Upsight", "unkown exception occurred locating getActivity(): " + localException.getMessage());
    }
  }
  
  public void UnitySendMessage(final String paramString1, final String paramString2)
  {
    if (paramString2 != null) {}
    while (mUnitySendMessageMethod != null)
    {
      try
      {
        mUnitySendMessageMethod.invoke(null, new Object[] { "UpsightManager", paramString1, paramString2 });
        return;
      }
      catch (IllegalArgumentException paramString1)
      {
        Log.i("Upsight", "could not find UnitySendMessage method: " + paramString1.getMessage());
        return;
      }
      catch (IllegalAccessException paramString1)
      {
        Log.i("Upsight", "could not find UnitySendMessage method: " + paramString1.getMessage());
        return;
      }
      catch (InvocationTargetException paramString1)
      {
        Log.i("Upsight", "could not find UnitySendMessage method: " + paramString1.getMessage());
        return;
      }
      paramString2 = "";
    }
    Log.i("Upsight", "UnitySendMessage: UpsightManager, " + paramString1 + ", " + paramString2);
    runSafelyOnUiThread(new Runnable()
    {
      public void run()
      {
        Activity localActivity = getActivity();
        if (localActivity != null) {
          Toast.makeText(localActivity, "UnitySendMessage:\n" + paramString1 + "\n" + paramString2, 1).show();
        }
      }
    });
  }
  
  protected Activity getActivity()
  {
    if (mUnityPlayerActivityField != null) {
      try
      {
        Activity localActivity = (Activity)mUnityPlayerActivityField.get(mUnityPlayerClass);
        if (localActivity == null) {
          Log.e("Upsight", "Something has gone terribly wrong. The Unity Activity does not exist. This could be due to a low memory situation");
        }
        return localActivity;
      }
      catch (Exception localException)
      {
        Log.i("Upsight", "error getting currentActivity: " + localException.getMessage());
      }
    }
    return null;
  }
  
  protected void runSafelyOnUiThread(final Runnable paramRunnable)
  {
    Activity localActivity = getActivity();
    if (localActivity != null) {
      localActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          try
          {
            paramRunnable.run();
            return;
          }
          catch (Exception localException)
          {
            Log.e("Upsight", "Exception running command on UI thread: " + localException.getMessage());
          }
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.unity.AbstractUpsightPlugin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */