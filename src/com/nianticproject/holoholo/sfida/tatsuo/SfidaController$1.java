package com.nianticproject.holoholo.sfida.tatsuo;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.util.Log;

class SfidaController$1
  implements BluetoothAdapter.LeScanCallback
{
  SfidaController$1(SfidaController paramSfidaController) {}
  
  public void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    Log.d(SfidaController.access$000(), String.format("Found device: %s address: %s", new Object[] { paramBluetoothDevice.getName(), paramBluetoothDevice.getAddress() }));
    if ("EBISU".equals(paramBluetoothDevice.getName()))
    {
      Log.d(SfidaController.access$000(), String.format("Found SFIDA device: %s", new Object[] { paramBluetoothDevice.getAddress() }));
      SfidaController.access$102(this$0, new SfidaDevice(SfidaController.access$200(this$0), paramBluetoothDevice));
      SfidaController.access$100(this$0).connect();
      this$0.stopScan();
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.tatsuo.SfidaController.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */