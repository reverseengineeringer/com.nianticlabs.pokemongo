package com.nianticproject.holoholo.sfida.service;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.util.Log;
import com.nianticproject.holoholo.sfida.SfidaUtils;

@TargetApi(18)
public class SfidaGattCallback
  extends BluetoothGattCallback
{
  public static final String TAG = SfidaGattCallback.class.getSimpleName();
  private SfidaService sfidaService;
  
  public SfidaGattCallback(SfidaService paramSfidaService)
  {
    sfidaService = paramSfidaService;
  }
  
  public void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    sfidaService.onSfidaUpdated(paramBluetoothGattCharacteristic);
  }
  
  public void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    if (paramInt == 0)
    {
      sfidaService.onSfidaUpdated(paramBluetoothGattCharacteristic);
      return;
    }
    Log.e(TAG, "[BLE] onCharacteristicRead() Read failed.");
  }
  
  public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    Log.d(TAG, "[BLE] onCharacteristicWrite() \n  UUID   : " + paramBluetoothGattCharacteristic.getUuid() + "\n" + "  status : " + SfidaUtils.getGattStateName(paramInt) + "\n" + "  value  : " + SfidaUtils.byteArrayToString(paramBluetoothGattCharacteristic.getValue()));
    sfidaService.setIsReceivedWriteCallback(true);
    if (paramInt == 133) {
      sfidaService.disconnectBluetooth();
    }
  }
  
  public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    Log.d(TAG, "[BLE] onConnectionStateChange() oldState : " + SfidaUtils.getConnectionStateName(paramInt1) + " → newState : " + SfidaUtils.getConnectionStateName(paramInt2));
    switch (paramInt2)
    {
    default: 
      Log.e(TAG, "[BLE] onConnectionStateChange() UnhandledState status : " + paramInt1 + " " + "newState : " + paramInt2);
    case 19: 
    case 34: 
    case 133: 
      return;
    case 2: 
      Log.d(TAG, "[BLE] Connected with GATT server.");
      sfidaService.onConnectedWithGattServer(paramBluetoothGatt);
      return;
    }
    Log.d(TAG, "[BLE] Disconnected from GATT server.");
    sfidaService.onDisconnectedWithGattServer();
  }
  
  public void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    super.onDescriptorWrite(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
    Log.d(TAG, "[BLE] onDescriptorWrite() \n  UUID   : " + paramBluetoothGattDescriptor.getUuid() + "\n" + "  status : " + SfidaUtils.getGattStateName(paramInt) + "\n" + "  value  : " + SfidaUtils.byteArrayToString(paramBluetoothGattDescriptor.getValue()));
    switch (paramInt)
    {
    }
    for (;;)
    {
      sfidaService.setIsReceivedNotifyCallback(true);
      return;
      Log.e(TAG, "Too early to call enableSecurityServiceNotify().");
      continue;
      Log.e(TAG, "SFIDA is already unpaired");
      continue;
      Log.e(TAG, "SFIDA is already paired with other device");
    }
  }
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    Log.d(TAG, "[BLE] onServicesDiscovered() : " + SfidaUtils.getGattStateName(paramInt));
    switch (paramInt)
    {
    default: 
      Log.e(TAG, "[BLE] onServicesDiscovered received error: " + paramInt);
      return;
    }
    sfidaService.onServiceDiscovered();
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.service.SfidaGattCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */