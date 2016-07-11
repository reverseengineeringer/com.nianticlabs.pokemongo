package com.nianticproject.holoholo.sfida;

import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.Toast;
import java.lang.reflect.Method;

public class SfidaUtils
{
  private static final String TAG = SfidaUtils.class.getSimpleName();
  
  public static String byteArrayToBitString(byte[] paramArrayOfByte)
  {
    Object localObject = "";
    int m = paramArrayOfByte.length;
    int i = 0;
    while (i < m)
    {
      int n = paramArrayOfByte[i];
      int j = 0;
      if (j < 8)
      {
        localObject = new StringBuilder().append((String)localObject);
        if ((128 >> j & n) != 0) {}
        for (int k = 1;; k = 0)
        {
          localObject = String.valueOf(k);
          j += 1;
          break;
        }
      }
      localObject = (String)localObject + " ";
      i += 1;
    }
    return (String)localObject;
  }
  
  public static String byteArrayToString(byte[] paramArrayOfByte)
  {
    String str = "";
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      str = str + String.valueOf(k);
      i += 1;
    }
    return str;
  }
  
  @TargetApi(19)
  public static void createBond(BluetoothDevice paramBluetoothDevice)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      Log.d(TAG, "createBond() Start Pairing...");
      paramBluetoothDevice.createBond();
      return;
    }
    try
    {
      Log.d(TAG, "createBond() Start Pairing...");
      paramBluetoothDevice.getClass().getMethod("createBond", (Class[])null).invoke(paramBluetoothDevice, (Object[])null);
      Log.d(TAG, "createBond() Pairing finished.");
      return;
    }
    catch (Exception paramBluetoothDevice)
    {
      Log.e(TAG, paramBluetoothDevice.getMessage());
    }
  }
  
  public static String getBondStateName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return String.valueOf(paramInt);
    case 10: 
      return "BOND_NONE";
    case 11: 
      return "BOND_BONDING";
    }
    return "BOND_BONDED";
  }
  
  public static String getConnectionStateName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return String.valueOf(paramInt);
    case 0: 
      return "STATE_DISCONNECTED";
    case 1: 
      return "STATE_CONNECTING";
    case 2: 
      return "STATE_CONNECTED";
    }
    return "STATE_DISCONNECTING";
  }
  
  public static String getGattStateName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return String.valueOf(paramInt);
    case 0: 
      return "GATT_SUCCESS";
    case 2: 
      return "GATT_READ_NOT_PERMITTED";
    case 3: 
      return "GATT_WRITE_NOT_PERMITTED";
    case 5: 
      return "GATT_INSUFFICIENT_AUTHENTICATION";
    case 6: 
      return "GATT_REQUEST_NOT_SUPPORTED";
    case 15: 
      return "GATT_INSUFFICIENT_ENCRYPTION";
    case 7: 
      return "GATT_INVALID_OFFSET";
    case 13: 
      return "GATT_INVALID_ATTRIBUTE_LENGTH";
    case 143: 
      return "GATT_CONNECTION_CONGESTED";
    case 257: 
      return "GATT_FAILURE";
    case 8: 
      return "GATT_INSUF_AUTHENTICATION";
    case 129: 
      return "GATT_INTERNAL_ERROR";
    }
    return "GATT_ERROR";
  }
  
  public static byte[] hexStringToByteArray(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    return arrayOfByte;
  }
  
  public static boolean refreshDeviceCache(BluetoothGatt paramBluetoothGatt)
  {
    try
    {
      Method localMethod = paramBluetoothGatt.getClass().getMethod("refresh", new Class[0]);
      if (localMethod != null)
      {
        boolean bool = ((Boolean)localMethod.invoke(paramBluetoothGatt, new Object[0])).booleanValue();
        return bool;
      }
    }
    catch (Exception paramBluetoothGatt)
    {
      Log.e(TAG, "An exception occurred while refreshing device");
    }
    return false;
  }
  
  public static void removeBond(BluetoothDevice paramBluetoothDevice)
  {
    try
    {
      Log.d("removeBond()", "Start remove bond...");
      paramBluetoothDevice.getClass().getMethod("removeBond", (Class[])null).invoke(paramBluetoothDevice, (Object[])null);
      Log.d("removeBond()", "remove bond finished.");
      return;
    }
    catch (Exception paramBluetoothDevice)
    {
      Log.e("removeBond()", paramBluetoothDevice.getMessage());
    }
  }
  
  public static void toast(Activity paramActivity, final String paramString, final int paramInt)
  {
    if (paramActivity != null) {
      paramActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          Toast.makeText(val$activity, paramString, paramInt).show();
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.SfidaUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */