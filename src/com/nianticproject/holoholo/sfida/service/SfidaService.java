package com.nianticproject.holoholo.sfida.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import com.nianticproject.holoholo.sfida.SfidaMessage;
import com.nianticproject.holoholo.sfida.SfidaNotification;
import com.nianticproject.holoholo.sfida.SfidaUtils;
import com.nianticproject.holoholo.sfida.constants.SfidaConstants.CertificationState;
import com.nianticproject.holoholo.sfida.constants.SfidaConstants.ConnectionState;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@TargetApi(18)
public class SfidaService
  extends Service
{
  private static final String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";
  public static final String EXTRA_DATA_CHARACTERISTIC = "com.nianticproject.holoholo.sfida..EXTRA_DATA_TYPE";
  public static final String EXTRA_DATA_RAW = "com.nianticproject.holoholo.sfida.EXTRA_DATA_RAW";
  private static final String TAG = SfidaService.class.getSimpleName();
  private static final boolean USE_AUTO_CONNECT = false;
  private final IBinder binder = new LocalBinder();
  private BluetoothAdapter bluetoothAdapter;
  private String bluetoothDeviceAddress;
  private BluetoothGatt bluetoothGatt;
  private BluetoothManager bluetoothManager;
  private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i = 0;
      Log.d(SfidaService.TAG, "onReceive() : " + paramAnonymousIntent.getAction());
      paramAnonymousContext = paramAnonymousIntent.getAction();
      if (paramAnonymousContext == null) {
        Log.d(SfidaService.TAG, "onReceived() action was null");
      }
      label104:
      do
      {
        return;
        switch (paramAnonymousContext.hashCode())
        {
        default: 
          i = -1;
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            Log.d(SfidaService.TAG, "onReceive() : " + paramAnonymousContext);
            return;
            if (!paramAnonymousContext.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
              break label104;
            }
            continue;
            if (!paramAnonymousContext.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
              break label104;
            }
            i = 1;
            continue;
            if (!paramAnonymousContext.equals("com.nianticproject.holoholo.sfida.dismiss")) {
              break label104;
            }
            i = 2;
            continue;
            if (!paramAnonymousContext.equals("com.nianticproject.holoholo.sfida.vibrate")) {
              break label104;
            }
            i = 3;
            continue;
            if (!paramAnonymousContext.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
              break label104;
            }
            i = 4;
          }
        }
        SfidaService.this.onBondStateChanged(paramAnonymousIntent);
        return;
      } while (connectionState != SfidaConstants.ConnectionState.RE_BOND);
      setConnectionState(SfidaConstants.ConnectionState.NO_CONNECTION);
      SfidaUtils.createBond(getDevice(bluetoothDeviceAddress));
      SfidaService.this.sendBroadcast("com.nianticproject.holoholo.sfida.ACTION_CREATE_BOND");
      return;
      SfidaNotification.dissmiss(getApplicationContext());
      disconnectBluetooth();
      return;
      sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getBlinkRed());
      return;
      paramAnonymousContext = (BluetoothDevice)paramAnonymousIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      try
      {
        paramAnonymousContext.getClass().getMethod("setPairingConfirmation", new Class[] { Boolean.TYPE }).invoke(paramAnonymousContext, new Object[] { Boolean.valueOf(true) });
        paramAnonymousContext.getClass().getMethod("cancelPairingUserInput", new Class[0]).invoke(paramAnonymousContext, new Object[0]);
        return;
      }
      catch (IllegalAccessException paramAnonymousContext)
      {
        paramAnonymousContext.printStackTrace();
        return;
      }
      catch (InvocationTargetException paramAnonymousContext)
      {
        paramAnonymousContext.printStackTrace();
        return;
      }
      catch (NoSuchMethodException paramAnonymousContext)
      {
        paramAnonymousContext.printStackTrace();
      }
    }
  };
  private Certificator certificator = new Certificator(this);
  private volatile SfidaConstants.ConnectionState connectionState = SfidaConstants.ConnectionState.NO_CONNECTION;
  private volatile boolean isReceivedNotifyCallback = false;
  private volatile boolean isReceivedWriteCallback = false;
  private SfidaButtonDetector sfidaButtonDetector = new SfidaButtonDetector();
  
  private Boolean isBoundDevice(BluetoothDevice paramBluetoothDevice)
  {
    Object localObject = bluetoothAdapter.getBondedDevices();
    if ((localObject != null) && (((Set)localObject).size() != 0))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((BluetoothDevice)((Iterator)localObject).next()).getAddress().equals(paramBluetoothDevice.getAddress())) {
          return Boolean.valueOf(true);
        }
      }
    }
    return Boolean.valueOf(false);
  }
  
  private void onBondStateChanged(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
    int j = paramIntent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE);
    Log.d(TAG, "[BLE] ACTION_BOND_STATE_CHANGED oldState : " + SfidaUtils.getBondStateName(j) + " → newState : " + SfidaUtils.getBondStateName(i));
    paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    if (paramIntent != null) {}
    switch (i)
    {
    case 11: 
    default: 
      return;
    case 12: 
      try
      {
        paramIntent.getClass().getMethod("cancelPairingUserInput", new Class[0]).invoke(paramIntent, new Object[0]);
        connect(paramIntent);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        for (;;)
        {
          localInvocationTargetException.printStackTrace();
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;)
        {
          localNoSuchMethodException.printStackTrace();
        }
      }
    }
    if (j == 12)
    {
      setConnectionState(SfidaConstants.ConnectionState.RE_BOND);
      certificator.setCertificationState(SfidaConstants.CertificationState.NO_CERTIFICATION);
      disconnectBluetooth();
      return;
    }
    if (j == 11)
    {
      setConnectionState(SfidaConstants.ConnectionState.NO_CONNECTION);
      sendBroadcast("com.nianticproject.holoholo.sfida.ACTION_BOND_CANCELED");
      return;
    }
    Log.d(TAG, "Unhandled oldState : " + j);
  }
  
  private void sendBroadcast(String paramString)
  {
    sendBroadcast(new Intent(paramString));
  }
  
  private void startCertificateSequence()
  {
    certificator.startCertification();
  }
  
  public void closeBluetoothGatt()
  {
    if (bluetoothGatt == null) {
      return;
    }
    bluetoothGatt.close();
    bluetoothGatt = null;
  }
  
  public boolean connect(BluetoothDevice paramBluetoothDevice)
  {
    if (isBoundDevice(paramBluetoothDevice).booleanValue())
    {
      setConnectionState(SfidaConstants.ConnectionState.CONNECT_GATT);
      String str = paramBluetoothDevice.getAddress();
      if ((bluetoothAdapter == null) || (str == null))
      {
        Log.w(TAG, "[BLE] BluetoothAdapter not initialized or unspecified address.");
        return false;
      }
      if ((bluetoothDeviceAddress != null) && (str.equals(bluetoothDeviceAddress)) && (bluetoothGatt != null))
      {
        Log.d(TAG, "[BLE] Trying to use an existing bluetoothGatt for connection.");
        return bluetoothGatt.connect();
      }
      bluetoothGatt = paramBluetoothDevice.connectGatt(this, false, new SfidaGattCallback(this));
      Log.d(TAG, "Trying to create a new connection.");
      bluetoothDeviceAddress = str;
    }
    for (;;)
    {
      return true;
      setConnectionState(SfidaConstants.ConnectionState.BONDING);
      SfidaUtils.createBond(paramBluetoothDevice);
    }
  }
  
  public boolean disconnectBluetooth()
  {
    if ((bluetoothAdapter == null) || (bluetoothGatt == null))
    {
      Log.w(TAG, "[BLE] BluetoothAdapter not initialized");
      return false;
    }
    bluetoothGatt.disconnect();
    return true;
  }
  
  public boolean enableDeviceControlServiceNotify()
  {
    Log.d(TAG, "enableDeviceControlServiceNotify()");
    BluetoothGattCharacteristic localBluetoothGattCharacteristic = findCharacteristic(SfidaMessage.UUID_DEVICE_CONTROL_SERVICE, SfidaMessage.UUID_BUTTON_NOTIF_CHAR);
    if (localBluetoothGattCharacteristic != null)
    {
      boolean bool = sendToEnableSfidaNotification(localBluetoothGattCharacteristic, true, SfidaMessage.UUID_BUTTON_NOTIF_CHAR);
      Log.d(TAG, "enableDeviceControlServiceNotify() result : " + bool);
      return bool;
    }
    Log.e(TAG, "enableDeviceControlServiceNotify() BluetoothGattCharacteristic not found.");
    return false;
  }
  
  public boolean enableSecurityServiceNotify()
  {
    return enableSecurityServiceNotify(null);
  }
  
  public boolean enableSecurityServiceNotify(SfidaWatchDog.OnTimeoutListener paramOnTimeoutListener)
  {
    Log.d(TAG, "enableSecurityServiceNotify()");
    BluetoothGattCharacteristic localBluetoothGattCharacteristic = findCharacteristic(SfidaMessage.UUID_CERTIFICATE_SERVICE, SfidaMessage.UUID_SFIDA_COMMANDS_CHAR);
    if (localBluetoothGattCharacteristic != null)
    {
      boolean bool = sendToEnableSfidaNotification(localBluetoothGattCharacteristic, true, SfidaMessage.UUID_SFIDA_COMMANDS_CHAR, paramOnTimeoutListener);
      Log.d(TAG, "enableSecurityServiceNotify() result : " + bool);
      return bool;
    }
    Log.e(TAG, "enableSecurityServiceNotify() BluetoothGattCharacteristic not found.");
    return false;
  }
  
  public BluetoothGattCharacteristic findCharacteristic(UUID paramUUID1, UUID paramUUID2)
  {
    if (bluetoothGatt == null) {
      return null;
    }
    paramUUID1 = bluetoothGatt.getService(paramUUID1);
    if (paramUUID1 != null) {
      return paramUUID1.getCharacteristic(paramUUID2);
    }
    Log.e(TAG, "findCharacteristic() characteristic was not found.");
    return null;
  }
  
  public String getBluetoothAddress()
  {
    return bluetoothDeviceAddress;
  }
  
  public BluetoothDevice getDevice(String paramString)
  {
    BluetoothDevice localBluetoothDevice = bluetoothAdapter.getRemoteDevice(paramString);
    paramString = localBluetoothDevice;
    if (localBluetoothDevice == null)
    {
      Log.w(TAG, "[BLE] Device not found.  Unable to connect.");
      paramString = null;
    }
    return paramString;
  }
  
  public boolean getIsReceivedNotifyCallback()
  {
    return isReceivedNotifyCallback;
  }
  
  public boolean getIsReceivedWriteCallback()
  {
    return isReceivedWriteCallback;
  }
  
  public List<BluetoothGattService> getSupportedGattServices()
  {
    if (bluetoothGatt == null) {
      return null;
    }
    return bluetoothGatt.getServices();
  }
  
  public boolean initialize()
  {
    if (bluetoothManager == null)
    {
      bluetoothManager = ((BluetoothManager)getSystemService("bluetooth"));
      if (bluetoothManager == null)
      {
        Log.e(TAG, "Unable to initialize BluetoothManager.");
        return false;
      }
    }
    bluetoothAdapter = bluetoothManager.getAdapter();
    if (bluetoothAdapter == null)
    {
      Log.e(TAG, "Unable to obtain a BluetoothAdapter.");
      return false;
    }
    return true;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Log.d(TAG, "onBind()");
    paramIntent = new IntentFilter();
    paramIntent.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
    paramIntent.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
    paramIntent.addAction("com.nianticproject.holoholo.sfida.dismiss");
    paramIntent.addAction("com.nianticproject.holoholo.sfida.vibrate");
    registerReceiver(broadcastReceiver, paramIntent);
    return binder;
  }
  
  public void onCertificationComplete()
  {
    setConnectionState(SfidaConstants.ConnectionState.CONNECTED);
    enableDeviceControlServiceNotify();
    sendBroadcast("com.nianticproject.holoholo.sfida.ACTION_CERTIFICATE_COMPLETE");
    SfidaNotification.showSfidaNotification(getApplicationContext());
  }
  
  public void onConnectedWithGattServer(BluetoothGatt paramBluetoothGatt)
  {
    paramBluetoothGatt.discoverServices();
    setConnectionState(SfidaConstants.ConnectionState.DISCOVERING_SERVICE);
    sendBroadcast("com.nianticproject.holoholo.sfida.ACTION_GATT_CONNECTED");
  }
  
  public void onDestroy()
  {
    Log.d(TAG, "onDestroy()");
    super.onDestroy();
    closeBluetoothGatt();
    unregisterReceiver(broadcastReceiver);
    if (sfidaButtonDetector != null) {
      sfidaButtonDetector.release();
    }
    SfidaNotification.dissmiss(getApplicationContext());
  }
  
  public void onDisconnectedWithGattServer()
  {
    if (connectionState != SfidaConstants.ConnectionState.RE_BOND)
    {
      closeBluetoothGatt();
      sendBroadcast("com.nianticproject.holoholo.sfida.ACTION_GATT_DISCONNECTED");
      setConnectionState(SfidaConstants.ConnectionState.NO_CONNECTION);
      SfidaNotification.dissmiss(getApplicationContext());
    }
  }
  
  public void onServiceDiscovered()
  {
    switch (connectionState)
    {
    default: 
      return;
    case ???: 
      setConnectionState(SfidaConstants.ConnectionState.CERTIFICATION);
      startCertificateSequence();
      sendBroadcast("com.nianticproject.holoholo.sfida.ACTION_GATT_SERVICES_DISCOVERED");
      return;
    }
    setConnectionState(SfidaConstants.ConnectionState.NO_CONNECTION);
    disconnectBluetooth();
  }
  
  public void onSfidaUpdated(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    Intent localIntent = new Intent("com.nianticproject.holoholo.sfida.ACTION_DATA_AVAILABLE");
    byte[] arrayOfByte = paramBluetoothGattCharacteristic.getValue();
    UUID localUUID = paramBluetoothGattCharacteristic.getUuid();
    String str1 = SfidaUtils.byteArrayToString(arrayOfByte);
    String str2 = SfidaUtils.byteArrayToBitString(arrayOfByte);
    Log.d(TAG, "[BLE] onSfidaUpdated()");
    Log.d(TAG, "  RawData : " + str1);
    Log.d(TAG, "  Bit : " + str2);
    Log.d(TAG, "  UUID    : " + localUUID.toString());
    try
    {
      i = paramBluetoothGattCharacteristic.getIntValue(18, 0).intValue();
      Log.d(TAG, "  type    : " + i);
      SfidaWatchDog.getInstance().stopWatch();
      if (SfidaMessage.UUID_SFIDA_COMMANDS_CHAR.equals(localUUID))
      {
        if (certificator == null) {
          certificator = new Certificator(this);
        }
        certificator.onSfidaUpdated(str1);
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              localNullPointerException.printStackTrace();
            }
            if (!SfidaMessage.UUID_FW_VERSION_CHAR.equals(localUUID)) {
              break;
            }
          } while ((arrayOfByte == null) || (arrayOfByte.length <= 0));
          try
          {
            localIntent.putExtra("com.nianticproject.holoholo.sfida.EXTRA_DATA_RAW", new String(arrayOfByte, "US-ASCII"));
            localIntent.putExtra("com.nianticproject.holoholo.sfida..EXTRA_DATA_TYPE", localUUID);
            sendBroadcast(localIntent);
            return;
          }
          catch (UnsupportedEncodingException paramBluetoothGattCharacteristic)
          {
            paramBluetoothGattCharacteristic.printStackTrace();
            return;
          }
          if (!SfidaMessage.UUID_BATTERY_LEVEL_CHAR.equals(localUUID)) {
            break;
          }
        } while ((arrayOfByte == null) || (arrayOfByte.length <= 0));
        int i = paramBluetoothGattCharacteristic.getValue()[0];
        Log.d(TAG, "BatteryLevel received. " + i + "%");
        return;
        if (!SfidaMessage.UUID_BUTTON_NOTIF_CHAR.equals(localUUID)) {
          break;
        }
      } while (arrayOfByte == null);
      sfidaButtonDetector.setButtonStatus(arrayOfByte, false);
      localIntent.putExtra("com.nianticproject.holoholo.sfida.EXTRA_DATA_RAW", arrayOfByte);
      localIntent.putExtra("com.nianticproject.holoholo.sfida..EXTRA_DATA_TYPE", localUUID);
      sendBroadcast(localIntent);
      return;
      sendBroadcast(localIntent);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Log.d(TAG, "onUnbind()");
    return super.onUnbind(paramIntent);
  }
  
  public void readBatteryLevel()
  {
    Log.d(TAG, "readBatteryLevel()");
    BluetoothGattCharacteristic localBluetoothGattCharacteristic = findCharacteristic(SfidaMessage.UUID_BATTERY_SERVICE, SfidaMessage.UUID_BATTERY_LEVEL_CHAR);
    if (localBluetoothGattCharacteristic != null)
    {
      readCharacteristic(localBluetoothGattCharacteristic);
      return;
    }
    Log.e(TAG, "readBatteryLevel() BluetoothGattCharacteristic not found.");
  }
  
  public boolean readCertificateMessage(UUID paramUUID)
  {
    Log.d(TAG, "readCertificateMessage()");
    if (paramUUID == null) {
      throw new NullPointerException();
    }
    paramUUID = findCharacteristic(SfidaMessage.UUID_CERTIFICATE_SERVICE, paramUUID);
    if (paramUUID != null)
    {
      boolean bool = readCharacteristic(paramUUID);
      Log.d(TAG, "readCertificateMessage() : " + bool);
      return bool;
    }
    Log.e(TAG, "readCertificateMessage() BluetoothGattCharacteristic not found.");
    return false;
  }
  
  public boolean readCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    if ((bluetoothAdapter == null) || (bluetoothGatt == null))
    {
      Log.w(TAG, "[BLE] BluetoothAdapter not initialized");
      return false;
    }
    bluetoothGatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, true);
    return bluetoothGatt.readCharacteristic(paramBluetoothGattCharacteristic);
  }
  
  public void readFwVersionMessage()
  {
    Log.d(TAG, "readFwVersionMessage()");
    BluetoothGattCharacteristic localBluetoothGattCharacteristic = findCharacteristic(SfidaMessage.UUID_DEVICE_CONTROL_SERVICE, SfidaMessage.UUID_FW_VERSION_CHAR);
    if (localBluetoothGattCharacteristic != null)
    {
      readCharacteristic(localBluetoothGattCharacteristic);
      return;
    }
    Log.e(TAG, "readFwVersionMessage() BluetoothGattCharacteristic not found.");
  }
  
  public boolean sendCertificateMessage(byte[] paramArrayOfByte)
  {
    return sendCertificateMessage(paramArrayOfByte, null);
  }
  
  public boolean sendCertificateMessage(byte[] paramArrayOfByte, SfidaWatchDog.OnTimeoutListener paramOnTimeoutListener)
  {
    Log.d(TAG, "sendCertificateMessage()");
    if (paramArrayOfByte == null) {
      throw new NullPointerException();
    }
    Log.d(TAG, "sendCertificateMessage() \n  value : " + SfidaUtils.byteArrayToString(paramArrayOfByte) + "\n" + "  UUID  : " + SfidaMessage.UUID_CENTRAL_TO_SFIDA_CHAR);
    BluetoothGattCharacteristic localBluetoothGattCharacteristic = findCharacteristic(SfidaMessage.UUID_CERTIFICATE_SERVICE, SfidaMessage.UUID_CENTRAL_TO_SFIDA_CHAR);
    if (localBluetoothGattCharacteristic != null)
    {
      localBluetoothGattCharacteristic.setValue(paramArrayOfByte);
      boolean bool = writeCharacteristic(localBluetoothGattCharacteristic, paramOnTimeoutListener);
      Log.d(TAG, "sendCertificateMessage() result : " + bool);
      return bool;
    }
    Log.e(TAG, "sendCertificateMessage() BluetoothGattCharacteristic not found.");
    return false;
  }
  
  public boolean sendDeviceControlMessage(UUID paramUUID, byte[] paramArrayOfByte)
  {
    return sendDeviceControlMessage(paramUUID, paramArrayOfByte, null);
  }
  
  public boolean sendDeviceControlMessage(UUID paramUUID, byte[] paramArrayOfByte, SfidaWatchDog.OnTimeoutListener paramOnTimeoutListener)
  {
    Log.d(TAG, "[BLE] sendDeviceControlMessage() \n  value : " + SfidaUtils.byteArrayToString(paramArrayOfByte) + "\n" + "  UUID  : " + paramUUID);
    paramUUID = findCharacteristic(SfidaMessage.UUID_DEVICE_CONTROL_SERVICE, paramUUID);
    if (paramUUID != null)
    {
      paramUUID.setValue(paramArrayOfByte);
      boolean bool = writeCharacteristic(paramUUID, paramOnTimeoutListener);
      Log.d(TAG, "sendDeviceControlMessage() result : " + bool);
      return bool;
    }
    Log.e(TAG, "sendDeviceControlMessage() BluetoothGattCharacteristic not found.");
    return false;
  }
  
  public boolean sendDeviceControlMessage(UUID paramUUID, byte[] paramArrayOfByte, SfidaWatchDog.OnTimeoutListener paramOnTimeoutListener, int paramInt)
  {
    Log.d(TAG, "[BLE] sendDeviceControlMessage() \n  value : " + SfidaUtils.byteArrayToString(paramArrayOfByte) + "\n" + "  UUID  : " + paramUUID + " Timeout : " + paramInt);
    paramUUID = findCharacteristic(SfidaMessage.UUID_DEVICE_CONTROL_SERVICE, paramUUID);
    if (paramUUID != null)
    {
      paramUUID.setValue(paramArrayOfByte);
      boolean bool = writeCharacteristic(paramUUID, paramOnTimeoutListener, paramInt);
      Log.d(TAG, "sendDeviceControlMessage() result : " + bool);
      return bool;
    }
    Log.e(TAG, "sendDeviceControlMessage() BluetoothGattCharacteristic not found.");
    return false;
  }
  
  public boolean sendToEnableSfidaNotification(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean, UUID paramUUID)
  {
    return sendToEnableSfidaNotification(paramBluetoothGattCharacteristic, paramBoolean, paramUUID, null);
  }
  
  public boolean sendToEnableSfidaNotification(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean, UUID paramUUID, SfidaWatchDog.OnTimeoutListener paramOnTimeoutListener)
  {
    if ((bluetoothAdapter == null) || (bluetoothGatt == null))
    {
      Log.w(TAG, "[BLE] BluetoothAdapter not initialized");
      paramBoolean = false;
    }
    boolean bool;
    do
    {
      do
      {
        return paramBoolean;
        bool = bluetoothGatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, paramBoolean);
        if ((!bool) || (!paramUUID.equals(paramBluetoothGattCharacteristic.getUuid()))) {
          break;
        }
        paramUUID = paramBluetoothGattCharacteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
        paramUUID.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        Log.d(TAG, " permission : " + paramUUID.getPermissions());
        bool = bluetoothGatt.writeDescriptor(paramUUID);
        if ((bool) && (paramOnTimeoutListener != null))
        {
          isReceivedNotifyCallback = false;
          SfidaWatchDog.getInstance().startWatch(paramBluetoothGattCharacteristic.getUuid(), paramOnTimeoutListener);
          return bool;
        }
        paramBoolean = bool;
      } while (bool);
      Log.e(TAG, "failed writeDescriptor()");
      return bool;
      paramBoolean = bool;
    } while (bool);
    Log.e(TAG, "failed setCharacteristicNotification()");
    return bool;
  }
  
  public void setConnectionState(SfidaConstants.ConnectionState paramConnectionState)
  {
    Log.d(TAG, "ConnectionState [" + connectionState + "] → [" + paramConnectionState + "]");
    connectionState = paramConnectionState;
  }
  
  public void setIsReceivedNotifyCallback(boolean paramBoolean)
  {
    isReceivedNotifyCallback = paramBoolean;
  }
  
  public void setIsReceivedWriteCallback(boolean paramBoolean)
  {
    isReceivedWriteCallback = paramBoolean;
  }
  
  public void setOnClickSfidaListener(@Nullable SfidaButtonDetector.OnClickListener paramOnClickListener)
  {
    if (sfidaButtonDetector != null) {
      sfidaButtonDetector.setOnclickListener(paramOnClickListener);
    }
  }
  
  public boolean writeCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, SfidaWatchDog.OnTimeoutListener paramOnTimeoutListener)
  {
    Log.d(TAG, "writeCharacteristic()");
    boolean bool = bluetoothGatt.writeCharacteristic(paramBluetoothGattCharacteristic);
    if (bool)
    {
      isReceivedWriteCallback = false;
      if (paramOnTimeoutListener != null) {
        SfidaWatchDog.getInstance().startWatch(paramBluetoothGattCharacteristic.getUuid(), paramOnTimeoutListener);
      }
    }
    return bool;
  }
  
  public boolean writeCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, SfidaWatchDog.OnTimeoutListener paramOnTimeoutListener, int paramInt)
  {
    Log.d(TAG, "writeCharacteristic()");
    boolean bool = bluetoothGatt.writeCharacteristic(paramBluetoothGattCharacteristic);
    if (bool)
    {
      isReceivedWriteCallback = false;
      if (paramOnTimeoutListener != null) {
        SfidaWatchDog.getInstance().startWatch(paramBluetoothGattCharacteristic.getUuid(), paramOnTimeoutListener, paramInt);
      }
    }
    return bool;
  }
  
  public class LocalBinder
    extends Binder
  {
    public LocalBinder() {}
    
    public SfidaService getService()
    {
      return SfidaService.this;
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.service.SfidaService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */