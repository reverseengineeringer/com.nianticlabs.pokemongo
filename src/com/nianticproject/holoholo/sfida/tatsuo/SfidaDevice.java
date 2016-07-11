package com.nianticproject.holoholo.sfida.tatsuo;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class SfidaDevice
{
  private static final String TAG = SfidaDevice.class.getSimpleName();
  private BluetoothGatt bluetoothGatt;
  private final BluetoothGattCallback bluetoothGattCallback = new BluetoothGattCallback()
  {
    public void onButtonUpdated(int paramAnonymousInt)
    {
      if (buttonPresses == null) {
        SfidaDevice.access$402(SfidaDevice.this, new int[] { paramAnonymousInt });
      }
      for (;;)
      {
        Log.d(SfidaDevice.TAG, String.format("SFIDA button press returns %d", new Object[] { Integer.valueOf(paramAnonymousInt) }));
        return;
        int[] arrayOfInt = new int[buttonPresses.length + 1];
        System.arraycopy(buttonPresses, 0, arrayOfInt, 0, buttonPresses.length);
        arrayOfInt[buttonPresses.length] = paramAnonymousInt;
        SfidaDevice.access$402(SfidaDevice.this, arrayOfInt);
      }
    }
    
    public void onCharacteristicChanged(BluetoothGatt paramAnonymousBluetoothGatt, BluetoothGattCharacteristic paramAnonymousBluetoothGattCharacteristic)
    {
      paramAnonymousBluetoothGatt = paramAnonymousBluetoothGattCharacteristic.getValue();
      onButtonUpdated(paramAnonymousBluetoothGatt[0] * 256 + paramAnonymousBluetoothGatt[1]);
    }
    
    public void onConnectionStateChange(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      Log.d(SfidaDevice.TAG, String.format("onConnectionStateChange. status: %d", new Object[] { Integer.valueOf(paramAnonymousInt1) }));
      if (paramAnonymousInt2 == 2)
      {
        SfidaDevice.access$102(SfidaDevice.this, 2);
        Log.d(SfidaDevice.TAG, "Connected to GATT server.");
        Log.d(SfidaDevice.TAG, String.format("Attempting to start service discovery: %s", new Object[] { Boolean.valueOf(bluetoothGatt.discoverServices()) }));
      }
      while (paramAnonymousInt2 != 0) {
        return;
      }
      SfidaDevice.access$102(SfidaDevice.this, 0);
      SfidaDevice.access$202(SfidaDevice.this, null);
      Log.d(SfidaDevice.TAG, "Disconnected from GATT server.");
    }
    
    public void onServicesDiscovered(BluetoothGatt paramAnonymousBluetoothGatt, int paramAnonymousInt)
    {
      if (paramAnonymousInt != 0) {
        Log.e(SfidaDevice.TAG, String.format("GATT Failed to discover service. status: %d", new Object[] { Integer.valueOf(paramAnonymousInt) }));
      }
      for (;;)
      {
        return;
        SfidaDevice.access$302(SfidaDevice.this, paramAnonymousBluetoothGatt.getService(SfidaUUID.SFIDA_DEV_CTRL_SVC_UUID));
        if (service == null)
        {
          Log.e(SfidaDevice.TAG, "GATT Service not found: SFIDA_DEV_CTRL_SVC");
          return;
        }
        Log.d(SfidaDevice.TAG, "GATT onServicesDiscovered service is set");
        Object localObject = service.getCharacteristic(SfidaUUID.SFIDA_BUTTON_NOTIF_CHAR_UUID);
        if (localObject != null)
        {
          paramAnonymousBluetoothGatt.setCharacteristicNotification((BluetoothGattCharacteristic)localObject, true);
          localObject = ((BluetoothGattCharacteristic)localObject).getDescriptors();
          paramAnonymousInt = 0;
          while (paramAnonymousInt < ((List)localObject).size())
          {
            BluetoothGattDescriptor localBluetoothGattDescriptor = (BluetoothGattDescriptor)((List)localObject).get(paramAnonymousInt);
            localBluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            paramAnonymousBluetoothGatt.writeDescriptor(localBluetoothGattDescriptor);
            paramAnonymousInt += 1;
          }
        }
      }
    }
  };
  private int[] buttonPresses;
  private int connectionState = 0;
  private Context context;
  private BluetoothDevice device;
  private BluetoothGattService service;
  
  public SfidaDevice(Context paramContext, BluetoothDevice paramBluetoothDevice)
  {
    context = paramContext;
    device = paramBluetoothDevice;
  }
  
  private byte[] read(UUID paramUUID)
  {
    if (service == null)
    {
      Log.e(TAG, "No SFIDA Service.");
      return null;
    }
    paramUUID = service.getCharacteristic(paramUUID);
    if (paramUUID == null)
    {
      Log.e(TAG, "Characteristic not found: SFIDA_LED_VIBR_CTRL_CHAR");
      return null;
    }
    bluetoothGatt.readCharacteristic(paramUUID);
    return paramUUID.getValue();
  }
  
  private void write(UUID paramUUID, byte[] paramArrayOfByte)
  {
    if (service == null)
    {
      Log.e(TAG, "No SFIDA Service.");
      return;
    }
    paramUUID = service.getCharacteristic(paramUUID);
    if (paramUUID == null)
    {
      Log.e(TAG, "Characteristic not found: SFIDA_LED_VIBR_CTRL_CHAR");
      return;
    }
    paramUUID.setValue(paramArrayOfByte);
    bluetoothGatt.writeCharacteristic(paramUUID);
  }
  
  public void connect()
  {
    Log.d(TAG, "Connect to the GATT server");
    if (bluetoothGatt == null) {
      bluetoothGatt = device.connectGatt(context, true, bluetoothGattCallback);
    }
  }
  
  public String getVersion()
  {
    byte[] arrayOfByte = read(SfidaUUID.SFIDA_FW_VERSION);
    if (arrayOfByte != null) {
      return new String(arrayOfByte);
    }
    return "Unknown";
  }
  
  public boolean hasGattService()
  {
    if (service != null) {
      Log.d(TAG, "GATT hasGattService returns true");
    }
    return service != null;
  }
  
  @Deprecated
  public void play(int paramInt)
  {
    buttonPresses = null;
    playFlash(16711680, 0, 2, 10000, 1000, 10000);
  }
  
  public void play(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    buttonPresses = null;
    byte[] arrayOfByte = new SfidaFlashPatternBuilder(null).setPriority(1).setInputReadTimeMs(paramInt4).addFlash(paramInt3, paramInt1, paramInt2, false).build();
    write(SfidaUUID.SFIDA_LED_VIBR_CTRL_CHAR_UUID, arrayOfByte);
  }
  
  public void playFlash(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int j = paramInt4 / paramInt5;
    int i = j;
    if (j > 30)
    {
      paramInt5 = paramInt4 / 30;
      i = 30;
    }
    Object localObject = new SfidaFlashPatternBuilder(null);
    ((SfidaFlashPatternBuilder)localObject).setPriority(1);
    ((SfidaFlashPatternBuilder)localObject).setInputReadTimeMs(paramInt6);
    paramInt4 = 0;
    while (paramInt4 < i / 2)
    {
      ((SfidaFlashPatternBuilder)localObject).addFlash(paramInt5, paramInt1, paramInt3, false);
      ((SfidaFlashPatternBuilder)localObject).addFlash(paramInt5, paramInt2, 0, false);
      paramInt4 += 1;
    }
    localObject = ((SfidaFlashPatternBuilder)localObject).build();
    write(SfidaUUID.SFIDA_LED_VIBR_CTRL_CHAR_UUID, (byte[])localObject);
  }
  
  public void playPattern(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3, int paramInt4, int paramInt5)
  {
    SfidaFlashPatternBuilder localSfidaFlashPatternBuilder = new SfidaFlashPatternBuilder(null);
    localSfidaFlashPatternBuilder.setPriority(1);
    localSfidaFlashPatternBuilder.setInputReadTimeMs(paramInt5);
    paramInt5 = 0;
    while (paramInt5 < paramInt3)
    {
      localSfidaFlashPatternBuilder.addFlash(paramArrayOfInt[paramInt5], paramInt1, paramInt2, false);
      localSfidaFlashPatternBuilder.addFlash(paramInt4, 0, 0, false);
      paramInt5 += 1;
    }
    paramArrayOfInt = localSfidaFlashPatternBuilder.build();
    write(SfidaUUID.SFIDA_LED_VIBR_CTRL_CHAR_UUID, paramArrayOfInt);
  }
  
  public int[] readButtonPresses()
  {
    if ((buttonPresses != null) && (buttonPresses.length > 0))
    {
      Log.d(TAG, String.format("SFIDA readButtonPresses %s", new Object[] { buttonPresses.toString() }));
      int[] arrayOfInt = buttonPresses;
      buttonPresses = null;
      return arrayOfInt;
    }
    return new int[0];
  }
  
  public void stop()
  {
    byte[] arrayOfByte = new SfidaFlashPatternBuilder(null).setPriority(7).addFlash(100, 255, 0, false).build();
    write(SfidaUUID.SFIDA_LED_VIBR_CTRL_CHAR_UUID, arrayOfByte);
  }
  
  private static class SfidaFlashPatternBuilder
  {
    private int inputReadTimeMs;
    private List<SfidaFlash> patterns = new ArrayList();
    private int priority;
    
    public SfidaFlashPatternBuilder addFlash(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      if (patterns.size() < 30)
      {
        patterns.add(new SfidaFlash(paramInt1, paramInt2, paramInt3, paramBoolean));
        return this;
      }
      throw new InvalidParameterException("Number of flash patterns exceeded limit.");
    }
    
    public byte[] build()
    {
      byte[] arrayOfByte = new byte[patterns.size() * 3 + 4];
      int j = 0 + 1;
      arrayOfByte[0] = ((byte)(inputReadTimeMs / 50));
      int i = j + 1;
      arrayOfByte[j] = 0;
      int k = i + 1;
      arrayOfByte[i] = 0;
      j = k + 1;
      arrayOfByte[k] = ((byte)((priority & 0x7) << 5 | patterns.size() & 0x1F));
      i = 0;
      if (i < patterns.size())
      {
        SfidaFlash localSfidaFlash = (SfidaFlash)patterns.get(i);
        int m = j + 1;
        arrayOfByte[j] = ((byte)(flashTimeMs / 50));
        k = m + 1;
        arrayOfByte[m] = ((byte)(Color.green(color) >> 4 << 4 | Color.red(color >> 4) & 0xF));
        if (interpolationEnabled) {}
        for (j = 1;; j = 0)
        {
          arrayOfByte[k] = ((byte)(j << 7 | (vibrationLevel & 0x7) << 4 | Color.blue(color) >> 4 & 0xF));
          i += 1;
          j = k + 1;
          break;
        }
      }
      return arrayOfByte;
    }
    
    public SfidaFlashPatternBuilder setInputReadTimeMs(int paramInt)
    {
      inputReadTimeMs = paramInt;
      return this;
    }
    
    public SfidaFlashPatternBuilder setPriority(int paramInt)
    {
      priority = paramInt;
      return this;
    }
    
    private static class SfidaFlash
    {
      public int color;
      public int flashTimeMs;
      public boolean interpolationEnabled;
      public int vibrationLevel;
      
      public SfidaFlash(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
      {
        flashTimeMs = paramInt1;
        color = paramInt2;
        vibrationLevel = paramInt3;
        interpolationEnabled = paramBoolean;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.tatsuo.SfidaDevice
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */