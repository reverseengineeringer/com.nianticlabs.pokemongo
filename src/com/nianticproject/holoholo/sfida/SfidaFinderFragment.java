package com.nianticproject.holoholo.sfida;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Toast;
import com.nianticproject.holoholo.sfida.constants.SfidaConstants.SfidaVersion;
import java.util.List;

@TargetApi(18)
public class SfidaFinderFragment
  extends Fragment
{
  private static String BLE_NAME;
  private static final int REQUEST_ENABLE_BT = 10;
  private static final long SCAN_PERIOD = -559038737L;
  public static final String TAG = SfidaFinderFragment.class.getSimpleName();
  private BluetoothAdapter bluetoothAdapter;
  private List<String> bluetoothAddressFilter;
  private boolean isFiltered = false;
  private boolean isScanningSfida = false;
  private BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback()
  {
    public void onLeScan(BluetoothDevice paramAnonymousBluetoothDevice, int paramAnonymousInt, byte[] paramAnonymousArrayOfByte)
    {
      if (!isScanningSfida) {}
      String str1;
      do
      {
        return;
        Log.d(SfidaFinderFragment.TAG, "onLeScan() scanRecord : " + SfidaUtils.byteArrayToString(paramAnonymousArrayOfByte));
        str1 = paramAnonymousBluetoothDevice.getName();
        String str2 = paramAnonymousBluetoothDevice.getAddress();
        paramAnonymousInt = paramAnonymousBluetoothDevice.getBondState();
        if ((str1 == null) || (!str1.contains(SfidaFinderFragment.BLE_NAME))) {
          break;
        }
        Log.d(SfidaFinderFragment.TAG, "SFIDA found, device bondState : " + SfidaUtils.getBondStateName(paramAnonymousInt));
        if ((str2 != null) && (isFiltered) && (!SfidaFinderFragment.this.isFilteredDevice(str2)))
        {
          Log.d(SfidaFinderFragment.TAG, str1 + " was not filtered.");
          return;
        }
      } while (onDeviceDiscoveredListener == null);
      onDeviceDiscoveredListener.onDeviceDiscovered(paramAnonymousBluetoothDevice, SfidaFinderFragment.this.detectButtonPressed(paramAnonymousArrayOfByte));
      return;
      Log.d(SfidaFinderFragment.TAG, "deviceName : [" + str1 + "] was not contained GO PLUS name.");
    }
  };
  private OnDeviceDiscoveredListener onDeviceDiscoveredListener;
  
  private boolean checkBluetoothSettingEnable(Activity paramActivity)
  {
    if (!paramActivity.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))
    {
      Toast.makeText(paramActivity, "BluetoothLE not supported.", 0).show();
      return false;
    }
    return true;
  }
  
  public static SfidaFinderFragment createInstance()
  {
    return new SfidaFinderFragment();
  }
  
  private boolean detectButtonPressed(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfByte.length > 27)
    {
      bool1 = bool2;
      if (paramArrayOfByte[26] != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean enableBt()
  {
    if ((bluetoothAdapter == null) || (!bluetoothAdapter.isEnabled()))
    {
      startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 10);
      return false;
    }
    return true;
  }
  
  private void init(Activity paramActivity)
  {
    bluetoothAdapter = ((BluetoothManager)paramActivity.getSystemService("bluetooth")).getAdapter();
  }
  
  private boolean isFilteredDevice(String paramString)
  {
    return (bluetoothAddressFilter != null) && (bluetoothAddressFilter.contains(paramString));
  }
  
  private void scanLeDevice(boolean paramBoolean)
  {
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("scanLeDevice() : ");
    if (paramBoolean) {}
    for (String str1 = "start scan.";; str1 = "cancel scan.")
    {
      Log.d(str2, str1);
      if (!paramBoolean) {
        break;
      }
      isScanningSfida = true;
      Log.d(TAG, "scanCallback : " + leScanCallback);
      bluetoothAdapter.startLeScan(leScanCallback);
      return;
    }
    isScanningSfida = false;
    bluetoothAdapter.stopLeScan(leScanCallback);
    bluetoothAdapter.cancelDiscovery();
  }
  
  public void cancelFindSfida()
  {
    scanLeDevice(false);
  }
  
  public void executeFindSfida()
  {
    if ((enableBt()) && (!isScanningSfida)) {
      scanLeDevice(true);
    }
  }
  
  public void executeFindSfida(List<String> paramList)
  {
    bluetoothAddressFilter = paramList;
    isFiltered = true;
    executeFindSfida();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    switch (com.nianticproject.holoholo.sfida.constants.SfidaConstants.SFIDA_VERSION)
    {
    }
    while (!checkBluetoothSettingEnable(paramActivity))
    {
      return;
      BLE_NAME = "SFIDA";
      continue;
      BLE_NAME = "EBISU";
      continue;
      BLE_NAME = "EBISU";
      continue;
      BLE_NAME = "Pokemon GO Plus";
    }
    init(paramActivity);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDetach()
  {
    super.onDetach();
    bluetoothAddressFilter = null;
  }
  
  public void onPause()
  {
    Log.d(TAG, "onPause()");
    super.onPause();
    scanLeDevice(false);
  }
  
  public void onResume()
  {
    Log.d(TAG, "onResume()");
    super.onResume();
  }
  
  public void setOnDeviceDiscoveredListener(OnDeviceDiscoveredListener paramOnDeviceDiscoveredListener)
  {
    onDeviceDiscoveredListener = paramOnDeviceDiscoveredListener;
  }
  
  public void setSfidaVersion(SfidaConstants.SfidaVersion paramSfidaVersion)
  {
    com.nianticproject.holoholo.sfida.constants.SfidaConstants.SFIDA_VERSION = paramSfidaVersion;
    switch (paramSfidaVersion)
    {
    default: 
      return;
    case ???: 
      BLE_NAME = "SFIDA";
      return;
    case ???: 
      BLE_NAME = "EBISU";
      return;
    case ???: 
      BLE_NAME = "EBISU";
      return;
    }
    BLE_NAME = "Pokemon GO Plus";
  }
  
  public static abstract interface OnDeviceDiscoveredListener
  {
    public abstract void onDeviceDiscovered(BluetoothDevice paramBluetoothDevice, boolean paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.SfidaFinderFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */