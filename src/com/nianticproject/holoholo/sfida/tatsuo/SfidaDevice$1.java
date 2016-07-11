package com.nianticproject.holoholo.sfida.tatsuo;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.util.Log;
import java.util.List;

class SfidaDevice$1
  extends BluetoothGattCallback
{
  SfidaDevice$1(SfidaDevice paramSfidaDevice) {}
  
  public void onButtonUpdated(int paramInt)
  {
    if (SfidaDevice.access$400(this$0) == null) {
      SfidaDevice.access$402(this$0, new int[] { paramInt });
    }
    for (;;)
    {
      Log.d(SfidaDevice.access$000(), String.format("SFIDA button press returns %d", new Object[] { Integer.valueOf(paramInt) }));
      return;
      int[] arrayOfInt = new int[SfidaDevice.access$400(this$0).length + 1];
      System.arraycopy(SfidaDevice.access$400(this$0), 0, arrayOfInt, 0, SfidaDevice.access$400(this$0).length);
      arrayOfInt[SfidaDevice.access$400(this$0).length] = paramInt;
      SfidaDevice.access$402(this$0, arrayOfInt);
    }
  }
  
  public void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    paramBluetoothGatt = paramBluetoothGattCharacteristic.getValue();
    onButtonUpdated(paramBluetoothGatt[0] * 256 + paramBluetoothGatt[1]);
  }
  
  public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    Log.d(SfidaDevice.access$000(), String.format("onConnectionStateChange. status: %d", new Object[] { Integer.valueOf(paramInt1) }));
    if (paramInt2 == 2)
    {
      SfidaDevice.access$102(this$0, 2);
      Log.d(SfidaDevice.access$000(), "Connected to GATT server.");
      Log.d(SfidaDevice.access$000(), String.format("Attempting to start service discovery: %s", new Object[] { Boolean.valueOf(SfidaDevice.access$200(this$0).discoverServices()) }));
    }
    while (paramInt2 != 0) {
      return;
    }
    SfidaDevice.access$102(this$0, 0);
    SfidaDevice.access$202(this$0, null);
    Log.d(SfidaDevice.access$000(), "Disconnected from GATT server.");
  }
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    if (paramInt != 0) {
      Log.e(SfidaDevice.access$000(), String.format("GATT Failed to discover service. status: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    for (;;)
    {
      return;
      SfidaDevice.access$302(this$0, paramBluetoothGatt.getService(SfidaUUID.SFIDA_DEV_CTRL_SVC_UUID));
      if (SfidaDevice.access$300(this$0) == null)
      {
        Log.e(SfidaDevice.access$000(), "GATT Service not found: SFIDA_DEV_CTRL_SVC");
        return;
      }
      Log.d(SfidaDevice.access$000(), "GATT onServicesDiscovered service is set");
      Object localObject = SfidaDevice.access$300(this$0).getCharacteristic(SfidaUUID.SFIDA_BUTTON_NOTIF_CHAR_UUID);
      if (localObject != null)
      {
        paramBluetoothGatt.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, true);
        localObject = ((BluetoothGattCharacteristic)localObject).getDescriptors();
        paramInt = 0;
        while (paramInt < ((List)localObject).size())
        {
          BluetoothGattDescriptor localBluetoothGattDescriptor = (BluetoothGattDescriptor)((List)localObject).get(paramInt);
          localBluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
          paramBluetoothGatt.writeDescriptor(localBluetoothGattDescriptor);
          paramInt += 1;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.tatsuo.SfidaDevice.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */