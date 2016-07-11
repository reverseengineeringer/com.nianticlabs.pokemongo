package com.voxelbusters;

import android.util.Log;
import com.voxelbusters.nativeplugins.base.interfaces.IAppLifeCycleListener;
import com.voxelbusters.nativeplugins.utilities.StringUtility;
import java.util.ArrayList;
import java.util.Iterator;

public class NativeBinding
{
  public static ArrayList<IAppLifeCycleListener> appLifeCycleListeners = new ArrayList();
  public static boolean isAppForeground = true;
  
  public static void addAppLifeCycleListener(IAppLifeCycleListener paramIAppLifeCycleListener)
  {
    if (!appLifeCycleListeners.contains(paramIAppLifeCycleListener)) {
      appLifeCycleListeners.add(paramIAppLifeCycleListener);
    }
  }
  
  public static void enableDebug(boolean paramBoolean)
  {
    com.voxelbusters.nativeplugins.utilities.Debug.ENABLED = paramBoolean;
  }
  
  public static boolean isApplicationForeground()
  {
    return isAppForeground;
  }
  
  public static void logMessage(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = StringUtility.getBase64DecodedString(paramString1) + "\n" + StringUtility.getBase64DecodedString(paramString3);
    if (paramString2.equals("ERROR"))
    {
      Log.e("Unity", paramString1);
      return;
    }
    if (paramString2.equals("WARNING"))
    {
      Log.w("Unity", paramString1);
      return;
    }
    if (paramString2.equals("INFO"))
    {
      Log.i("Unity", paramString1);
      return;
    }
    Log.d("Unity", paramString1);
  }
  
  public static void onApplicationPause()
  {
    isAppForeground = false;
    Iterator localIterator = appLifeCycleListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((IAppLifeCycleListener)localIterator.next()).onApplicationPause();
    }
  }
  
  public static void onApplicationQuit()
  {
    isAppForeground = false;
    Iterator localIterator = appLifeCycleListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((IAppLifeCycleListener)localIterator.next()).onApplicationQuit();
    }
  }
  
  public static void onApplicationResume()
  {
    isAppForeground = true;
    Iterator localIterator = appLifeCycleListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((IAppLifeCycleListener)localIterator.next()).onApplicationResume();
    }
  }
  
  public static void removeAppLifeCycleListener(IAppLifeCycleListener paramIAppLifeCycleListener)
  {
    appLifeCycleListeners.remove(paramIAppLifeCycleListener);
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.NativeBinding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */