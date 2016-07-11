package com.nianticproject.holoholo.sfida.service;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.nianticproject.holoholo.sfida.SfidaMessage;
import com.nianticproject.holoholo.sfida.SfidaNotification;
import com.nianticproject.holoholo.sfida.SfidaUtils;
import com.nianticproject.holoholo.sfida.constants.SfidaConstants.ConnectionState;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class SfidaService$1
  extends BroadcastReceiver
{
  SfidaService$1(SfidaService paramSfidaService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    Log.d(SfidaService.access$000(), "onReceive() : " + paramIntent.getAction());
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      Log.d(SfidaService.access$000(), "onReceived() action was null");
    }
    label104:
    do
    {
      return;
      switch (paramContext.hashCode())
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          Log.d(SfidaService.access$000(), "onReceive() : " + paramContext);
          return;
          if (!paramContext.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
            break label104;
          }
          continue;
          if (!paramContext.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
            break label104;
          }
          i = 1;
          continue;
          if (!paramContext.equals("com.nianticproject.holoholo.sfida.dismiss")) {
            break label104;
          }
          i = 2;
          continue;
          if (!paramContext.equals("com.nianticproject.holoholo.sfida.vibrate")) {
            break label104;
          }
          i = 3;
          continue;
          if (!paramContext.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
            break label104;
          }
          i = 4;
        }
      }
      SfidaService.access$100(this$0, paramIntent);
      return;
    } while (SfidaService.access$200(this$0) != SfidaConstants.ConnectionState.RE_BOND);
    this$0.setConnectionState(SfidaConstants.ConnectionState.NO_CONNECTION);
    SfidaUtils.createBond(this$0.getDevice(SfidaService.access$300(this$0)));
    SfidaService.access$400(this$0, "com.nianticproject.holoholo.sfida.ACTION_CREATE_BOND");
    return;
    SfidaNotification.dissmiss(this$0.getApplicationContext());
    this$0.disconnectBluetooth();
    return;
    this$0.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getBlinkRed());
    return;
    paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    try
    {
      paramContext.getClass().getMethod("setPairingConfirmation", new Class[] { Boolean.TYPE }).invoke(paramContext, new Object[] { Boolean.valueOf(true) });
      paramContext.getClass().getMethod("cancelPairingUserInput", new Class[0]).invoke(paramContext, new Object[0]);
      return;
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.service.SfidaService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */