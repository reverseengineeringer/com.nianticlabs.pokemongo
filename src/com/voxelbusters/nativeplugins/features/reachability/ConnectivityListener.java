package com.voxelbusters.nativeplugins.features.reachability;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectivityListener
  extends BroadcastReceiver
{
  boolean isConnected;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    updateConnectionStatus(paramContext);
  }
  
  public void updateConnectionStatus(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnected())) {}
    for (boolean bool = true;; bool = false)
    {
      NetworkReachabilityHandler.sendWifiReachabilityStatus(bool);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.reachability.ConnectivityListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */