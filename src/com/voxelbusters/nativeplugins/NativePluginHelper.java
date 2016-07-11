package com.voxelbusters.nativeplugins;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.unity3d.player.UnityPlayer;
import com.voxelbusters.nativeplugins.defines.UnityDefines;
import com.voxelbusters.nativeplugins.utilities.Debug;
import com.voxelbusters.nativeplugins.utilities.StringUtility;
import java.util.ArrayList;
import java.util.HashMap;

public class NativePluginHelper
{
  public static void executeOnUIThread(Runnable paramRunnable)
  {
    Activity localActivity = (Activity)getCurrentContext();
    if (localActivity != null) {
      localActivity.runOnUiThread(paramRunnable);
    }
  }
  
  public static Activity getCurrentActivity()
  {
    return (Activity)getCurrentContext();
  }
  
  public static Context getCurrentContext()
  {
    return UnityPlayer.currentActivity;
  }
  
  public static boolean isApplicationRunning()
  {
    return getCurrentContext() != null;
  }
  
  public static void sendMessage(String paramString)
  {
    sendMessage(paramString, "");
  }
  
  public static void sendMessage(String paramString1, String paramString2)
  {
    if (!StringUtility.isNullOrEmpty(paramString1))
    {
      Debug.log("UnitySendMessage", "Method Name : " + paramString1 + " " + "Message : " + paramString2);
      if (getCurrentContext() != null) {
        UnityPlayer.UnitySendMessage(UnityDefines.NATIVE_BINDING_EVENT_LISTENER, paramString1, paramString2);
      }
    }
  }
  
  public static void sendMessage(String paramString, ArrayList paramArrayList)
  {
    String str = "";
    if (paramArrayList != null) {
      str = new Gson().toJson(paramArrayList);
    }
    sendMessage(paramString, str);
  }
  
  public static void sendMessage(String paramString, HashMap paramHashMap)
  {
    String str = "";
    if (paramHashMap != null) {
      str = new Gson().toJson(paramHashMap);
    }
    sendMessage(paramString, str);
  }
  
  public static void startActivityOnUiThread(Intent paramIntent)
  {
    executeOnUIThread(new Runnable()
    {
      public void run()
      {
        NativePluginHelper.getCurrentContext().startActivity(NativePluginHelper.this);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.NativePluginHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */