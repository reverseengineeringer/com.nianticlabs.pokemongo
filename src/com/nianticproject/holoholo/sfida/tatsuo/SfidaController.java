package com.nianticproject.holoholo.sfida.tatsuo;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

@TargetApi(18)
public class SfidaController
{
  private static final String TAG = SfidaController.class.getSimpleName();
  private static SfidaController instance_;
  private BluetoothAdapter bluetoothAdapter;
  private final Context context;
  private BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback()
  {
    public void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
    {
      Log.d(SfidaController.TAG, String.format("Found device: %s address: %s", new Object[] { paramAnonymousBluetoothDevice.getName(), paramAnonymousBluetoothDevice.getAddress() }));
      if ("EBISU".equals(paramAnonymousBluetoothDevice.getName()))
      {
        Log.d(SfidaController.TAG, String.format("Found SFIDA device: %s", new Object[] { paramAnonymousBluetoothDevice.getAddress() }));
        SfidaController.access$102(SfidaController.this, new SfidaDevice(context, paramAnonymousBluetoothDevice));
        sfidaDevice.connect();
        stopScan();
      }
    }
  };
  private SfidaDevice sfidaDevice;
  
  public SfidaController(Context paramContext)
  {
    context = paramContext;
  }
  
  public static SfidaController get(Context paramContext)
  {
    if (instance_ == null) {
      instance_ = new SfidaController(paramContext);
    }
    return instance_;
  }
  
  @Nullable
  public SfidaDevice getSfidaDevice()
  {
    return sfidaDevice;
  }
  
  public boolean init()
  {
    Log.d(TAG, "Initialize SfidaController..");
    bluetoothAdapter = ((BluetoothManager)context.getSystemService("bluetooth")).getAdapter();
    if (bluetoothAdapter == null)
    {
      Log.d(TAG, "No Bluetooth available.");
      return false;
    }
    if (!bluetoothAdapter.isEnabled())
    {
      Log.d(TAG, "Bluetooth disabled.");
      return false;
    }
    return true;
  }
  
  public void startScan()
  {
    Log.d(TAG, "Start bluetooth device scan");
    bluetoothAdapter.startLeScan(leScanCallback);
  }
  
  public void stopScan()
  {
    Log.d(TAG, "Stop bluetooth device scan");
    bluetoothAdapter.stopLeScan(leScanCallback);
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.tatsuo.SfidaController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */