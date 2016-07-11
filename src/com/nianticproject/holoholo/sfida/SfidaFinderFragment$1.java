package com.nianticproject.holoholo.sfida;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.util.Log;

class SfidaFinderFragment$1
  implements BluetoothAdapter.LeScanCallback
{
  SfidaFinderFragment$1(SfidaFinderFragment paramSfidaFinderFragment) {}
  
  public void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (!SfidaFinderFragment.access$000(this$0)) {}
    String str1;
    do
    {
      return;
      Log.d(SfidaFinderFragment.TAG, "onLeScan() scanRecord : " + SfidaUtils.byteArrayToString(paramArrayOfByte));
      str1 = paramBluetoothDevice.getName();
      String str2 = paramBluetoothDevice.getAddress();
      paramInt = paramBluetoothDevice.getBondState();
      if ((str1 == null) || (!str1.contains(SfidaFinderFragment.access$100()))) {
        break;
      }
      Log.d(SfidaFinderFragment.TAG, "SFIDA found, device bondState : " + SfidaUtils.getBondStateName(paramInt));
      if ((str2 != null) && (SfidaFinderFragment.access$200(this$0)) && (!SfidaFinderFragment.access$300(this$0, str2)))
      {
        Log.d(SfidaFinderFragment.TAG, str1 + " was not filtered.");
        return;
      }
    } while (SfidaFinderFragment.access$400(this$0) == null);
    SfidaFinderFragment.access$400(this$0).onDeviceDiscovered(paramBluetoothDevice, SfidaFinderFragment.access$500(this$0, paramArrayOfByte));
    return;
    Log.d(SfidaFinderFragment.TAG, "deviceName : [" + str1 + "] was not contained GO PLUS name.");
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.SfidaFinderFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */