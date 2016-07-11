package com.voxelbusters.nativeplugins.features.reachability;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.voxelbusters.NativeBinding;
import com.voxelbusters.nativeplugins.NativePluginHelper;
import com.voxelbusters.nativeplugins.base.interfaces.IAppLifeCycleListener;
import com.voxelbusters.nativeplugins.utilities.Debug;

public class NetworkReachabilityHandler
  implements IAppLifeCycleListener
{
  private static NetworkReachabilityHandler INSTANCE;
  static boolean isSocketConnected = false;
  static boolean isWifiReachable = false;
  ConnectivityListener connectivityListener;
  Context context;
  HostConnectionPoller socketPoller = new HostConnectionPoller();
  
  public static NetworkReachabilityHandler getInstance()
  {
    if (INSTANCE == null) {
      INSTANCE = new NetworkReachabilityHandler();
    }
    return INSTANCE;
  }
  
  public static void sendSocketConnectionStatus(boolean paramBoolean)
  {
    if (isSocketConnected != paramBoolean)
    {
      isSocketConnected = paramBoolean;
      if (!isSocketConnected) {
        break label27;
      }
    }
    label27:
    for (String str = "true";; str = "false")
    {
      NativePluginHelper.sendMessage("NetworkSocketStatusChange", str);
      return;
    }
  }
  
  public static void sendWifiReachabilityStatus(boolean paramBoolean)
  {
    if (isWifiReachable != paramBoolean)
    {
      isWifiReachable = paramBoolean;
      if (!isWifiReachable) {
        break label27;
      }
    }
    label27:
    for (String str = "true";; str = "false")
    {
      NativePluginHelper.sendMessage("NetworkHardwareStatusChange", str);
      return;
    }
  }
  
  void StartSocketPoller(String paramString, int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    socketPoller.setIp(paramString);
    socketPoller.setPort(paramInt1);
    socketPoller.setConnectionTimeOutPeriod(paramInt2);
    socketPoller.setMaxRetryCount(paramInt3);
    socketPoller.setTimeGapBetweenPolls(paramFloat);
    socketPoller.Start();
  }
  
  void StartTestingNetworkHardware()
  {
    pauseReachability();
    connectivityListener = new ConnectivityListener();
    registerBroadcastReceiver(connectivityListener);
    connectivityListener.updateConnectionStatus(context);
  }
  
  public void initialize(String paramString, int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    context = NativePluginHelper.getCurrentContext();
    StartTestingNetworkHardware();
    StartSocketPoller(paramString, paramInt1, paramFloat, paramInt2, paramInt3);
    NativeBinding.addAppLifeCycleListener(this);
  }
  
  public void onApplicationPause() {}
  
  public void onApplicationQuit()
  {
    pauseReachability();
    NativeBinding.removeAppLifeCycleListener(this);
  }
  
  public void onApplicationResume() {}
  
  public void pauseReachability()
  {
    try
    {
      context.unregisterReceiver(connectivityListener);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Debug.warning("NativePlugins.NetworkConnectivity", "Already unregistered!" + localIllegalArgumentException.getMessage());
    }
  }
  
  void registerBroadcastReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    IntentFilter localIntentFilter1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    IntentFilter localIntentFilter2 = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
    IntentFilter localIntentFilter3 = new IntentFilter("android.net.wifi.STATE_CHANGE");
    context.registerReceiver(paramBroadcastReceiver, localIntentFilter1);
    context.registerReceiver(paramBroadcastReceiver, localIntentFilter2);
    context.registerReceiver(paramBroadcastReceiver, localIntentFilter3);
  }
  
  public void resumeReachability()
  {
    try
    {
      registerBroadcastReceiver(connectivityListener);
      connectivityListener.updateConnectionStatus(context);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Debug.warning("NativePlugins.NetworkConnectivity", "Already registered! " + localIllegalArgumentException.getMessage());
    }
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.reachability.NetworkReachabilityHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */