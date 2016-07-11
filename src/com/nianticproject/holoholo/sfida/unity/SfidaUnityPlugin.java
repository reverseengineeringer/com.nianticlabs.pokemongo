package com.nianticproject.holoholo.sfida.unity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import com.nianticproject.holoholo.sfida.SfidaFinderFragment;
import com.nianticproject.holoholo.sfida.SfidaFinderFragment.OnDeviceDiscoveredListener;
import com.nianticproject.holoholo.sfida.SfidaMessage;
import com.nianticproject.holoholo.sfida.SfidaUtils;
import com.nianticproject.holoholo.sfida.service.SfidaButtonDetector.OnClickListener;
import com.nianticproject.holoholo.sfida.service.SfidaService;
import com.nianticproject.holoholo.sfida.service.SfidaService.LocalBinder;
import com.unity3d.player.UnityPlayer;
import java.util.UUID;

public class SfidaUnityPlugin
  implements UnityInterface
{
  private static final String TAG = SfidaUnityPlugin.class.getSimpleName();
  private static final int TIMEOUT = 800;
  private static final String UNITY_GAME_OBJECT = "AndroidSfidaConnection";
  private static final String UNITY_METHOD_ENTER_ENCOUNTER_STATE = "EnterEncounterState";
  private static final String UNITY_METHOD_HACK_POKESTOP = "HackPokestop";
  private static final String UNITY_METHOD_NOTIFY_CONNECTED = "OnSfidaConnected";
  private static final String UNITY_METHOD_NOTIFY_DISCONNECTED = "OnSfidaDisconnected";
  private static final String UNITY_METHOD_THROW_POKEBALL = "ThrowPokeball";
  private static SfidaUnityPlugin instance = new SfidaUnityPlugin();
  private Activity activity;
  private BluetoothDevice device;
  private BroadcastReceiver gattUpdateReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      SfidaUnityPlugin.this.onBroadcastUpdated(paramAnonymousIntent);
    }
  };
  private Handler handler;
  private boolean isReceiverRegistered = false;
  private boolean isServiceBound = false;
  private boolean isSfidaConnected = false;
  private PeriodicVibrateRunnable runnable;
  private ServiceConnection serviceConnection = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      Log.d(SfidaUnityPlugin.TAG, "onServiceConnected()");
      SfidaUnityPlugin.access$102(SfidaUnityPlugin.this, ((SfidaService.LocalBinder)paramAnonymousIBinder).getService());
      if (!sfidaService.initialize())
      {
        Log.e(SfidaUnityPlugin.TAG, "Unable to initialize Bluetooth");
        return;
      }
      sfidaService.connect(device);
      SfidaUnityPlugin.access$302(SfidaUnityPlugin.this, true);
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      Log.d(SfidaUnityPlugin.TAG, "[BLE] onServiceDisconnected()");
      SfidaUnityPlugin.access$102(SfidaUnityPlugin.this, null);
    }
  };
  private SfidaService sfidaService;
  
  private void addSfidaFinderFragment()
  {
    SfidaFinderFragment localSfidaFinderFragment = SfidaFinderFragment.createInstance();
    localSfidaFinderFragment.setOnDeviceDiscoveredListener(new SfidaDiscoveredListener(null));
    getActivity().getFragmentManager().beginTransaction().add(localSfidaFinderFragment, SfidaFinderFragment.class.getName()).commit();
  }
  
  private Activity getActivity()
  {
    if (activity != null) {
      return activity;
    }
    return UnityPlayer.currentActivity;
  }
  
  private Context getContext()
  {
    return getActivity().getApplicationContext();
  }
  
  public static SfidaUnityPlugin getInstance()
  {
    return instance;
  }
  
  private SfidaFinderFragment getSfidaFinderFragment()
  {
    return (SfidaFinderFragment)getActivity().getFragmentManager().findFragmentByTag(SfidaFinderFragment.class.getName());
  }
  
  private boolean isEnableSfida()
  {
    return (sfidaService != null) && (isSfidaConnected);
  }
  
  private IntentFilter makeGattUpdateIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.nianticproject.holoholo.sfida.ACTION_GATT_CONNECTED");
    localIntentFilter.addAction("com.nianticproject.holoholo.sfida.ACTION_GATT_DISCONNECTED");
    localIntentFilter.addAction("com.nianticproject.holoholo.sfida.ACTION_DATA_AVAILABLE");
    localIntentFilter.addAction("com.nianticproject.holoholo.sfida.ACTION_CERTIFICATE_COMPLETE");
    localIntentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
    return localIntentFilter;
  }
  
  private boolean notifyPokeballBrokenOneShakeThree()
  {
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(null);
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getPokeballShakeThree());
  }
  
  private boolean notifyPokeballBrokenShakeOnce()
  {
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(null);
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getPokeballShakeOnce());
  }
  
  private boolean notifyPokeballBrokenShakeTwice()
  {
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(null);
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getPokeballShakeTwice());
  }
  
  private void onBroadcastUpdated(Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    Log.d(TAG, "onBroadcastUpdated() " + (String)localObject);
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
        if (((String)localObject).equals("com.nianticproject.holoholo.sfida.ACTION_GATT_CONNECTED"))
        {
          i = 0;
          continue;
          if (((String)localObject).equals("com.nianticproject.holoholo.sfida.ACTION_GATT_DISCONNECTED"))
          {
            i = 1;
            continue;
            if (((String)localObject).equals("com.nianticproject.holoholo.sfida.ACTION_CERTIFICATE_COMPLETE"))
            {
              i = 2;
              continue;
              if (((String)localObject).equals("com.nianticproject.holoholo.sfida.ACTION_DATA_AVAILABLE"))
              {
                i = 3;
                continue;
                if (((String)localObject).equals("com.nianticproject.holoholo.sfida.ACTION_CREATE_BOND"))
                {
                  i = 4;
                  continue;
                  if (((String)localObject).equals("com.nianticproject.holoholo.sfida.ACTION_BOND_CANCELED")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    isSfidaConnected = true;
    return;
    isSfidaConnected = false;
    Toast.makeText(getActivity(), "PokemonGoPlus disconnected", 1).show();
    UnityPlayer.UnitySendMessage("AndroidSfidaConnection", "OnSfidaDisconnected", "");
    return;
    Toast.makeText(getActivity(), "Pokémon GO Plus connected.", 0).show();
    UnityPlayer.UnitySendMessage("AndroidSfidaConnection", "OnSfidaConnected", "");
    return;
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      Log.wtf(TAG, "ops!");
      return;
    }
    localObject = (UUID)paramIntent.getSerializable("com.nianticproject.holoholo.sfida..EXTRA_DATA_TYPE");
    if (localObject == null)
    {
      Log.d(TAG, "characteristicUUID is Null");
      return;
    }
    if (((UUID)localObject).equals(SfidaMessage.UUID_FW_VERSION_CHAR))
    {
      paramIntent = paramIntent.getString("com.nianticproject.holoholo.sfida.EXTRA_DATA_RAW");
      Log.d(TAG, "SFIDA Version : " + paramIntent);
      return;
    }
    paramIntent = SfidaUtils.byteArrayToString(paramIntent.getByteArray("com.nianticproject.holoholo.sfida.EXTRA_DATA_RAW"));
    Log.d(TAG, "[BLE] raw data " + paramIntent);
    return;
    Toast.makeText(getActivity(), "Pairing...\nClick Plus again.", 1).show();
    return;
    Toast.makeText(getActivity(), "Canceled pairing. Retry or refresh Pokémon GO Plus connection.", 1).show();
  }
  
  private void readFwVersion()
  {
    sfidaService.readFwVersionMessage();
  }
  
  private void registerReceiver()
  {
    getActivity().registerReceiver(gattUpdateReceiver, makeGattUpdateIntentFilter());
    isReceiverRegistered = true;
  }
  
  private void startScanSfida()
  {
    SfidaFinderFragment localSfidaFinderFragment = getSfidaFinderFragment();
    if (localSfidaFinderFragment != null) {
      localSfidaFinderFragment.executeFindSfida();
    }
  }
  
  private void startSfidaConnection(BluetoothDevice paramBluetoothDevice)
  {
    device = paramBluetoothDevice;
    if (isServiceBound)
    {
      sfidaService.connect(paramBluetoothDevice);
      return;
    }
    paramBluetoothDevice = new Intent(getActivity(), SfidaService.class);
    getActivity().bindService(paramBluetoothDevice, serviceConnection, 1);
  }
  
  private void stopScanSfida()
  {
    SfidaFinderFragment localSfidaFinderFragment = getSfidaFinderFragment();
    if (localSfidaFinderFragment != null) {
      localSfidaFinderFragment.cancelFindSfida();
    }
  }
  
  public void connect()
  {
    Log.d(TAG, "connect()");
    getActivity().runOnUiThread(new Runnable()
    {
      public void run()
      {
        Toast.makeText(SfidaUnityPlugin.this.getActivity(), "Finding Pokémon GO Plus.", 0).show();
      }
    });
    startScanSfida();
  }
  
  public void disconnect()
  {
    Log.d(TAG, "disconnect()");
    if ((sfidaService != null) && (isSfidaConnected)) {
      sfidaService.disconnectBluetooth();
    }
  }
  
  public boolean init()
  {
    Log.d(TAG, "init()");
    if (Build.VERSION.SDK_INT >= 18)
    {
      addSfidaFinderFragment();
      registerReceiver();
      return true;
    }
    return false;
  }
  
  public boolean notifyCancel()
  {
    Log.d(TAG, "notifyCancel()");
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(null);
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getCancelPattern());
  }
  
  public boolean notifyCancelDowser()
  {
    Log.d(TAG, "notifyCancelDowser()");
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(null);
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getDowserCancel());
  }
  
  public boolean notifyError()
  {
    Log.d(TAG, "notifyError()");
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(null);
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getError());
  }
  
  public boolean notifyFoundDowser()
  {
    Log.d(TAG, "notifyFoundDowser()");
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(null);
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getDowserVisible());
  }
  
  public boolean notifyNoPokeball()
  {
    Log.d(TAG, "notifyNoPokeball()");
    if (!isEnableSfida()) {
      return false;
    }
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getNoPokeball());
  }
  
  public boolean notifyPokeballShakeAndBroken(String paramString)
  {
    Log.d(TAG, "notifyPokeballShakeAndBroken() shakeCount : " + paramString);
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(null);
    switch (Integer.valueOf(paramString).intValue())
    {
    default: 
      return false;
    case 0: 
      return true;
    case 1: 
      return notifyPokeballBrokenShakeOnce();
    case 2: 
      return notifyPokeballBrokenShakeTwice();
    }
    return notifyPokeballBrokenOneShakeThree();
  }
  
  public boolean notifyPokemonCaught()
  {
    Log.d(TAG, "notifyPokemonCaught()");
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(null);
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getPokemonCaught());
  }
  
  public boolean notifyProximityDowser(String paramString)
  {
    Log.d(TAG, "notifyProximityDowser()");
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(null);
    switch (Integer.valueOf(paramString).intValue())
    {
    default: 
      return false;
    case 1: 
      paramString = SfidaMessage.getDowserProximity1();
    }
    for (;;)
    {
      return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, paramString);
      paramString = SfidaMessage.getDowserProximity2();
      continue;
      paramString = SfidaMessage.getDowserProximity3();
      continue;
      paramString = SfidaMessage.getDowserProximity4();
      continue;
      paramString = SfidaMessage.getDowserProximity5();
    }
  }
  
  public boolean notifyReachedPokestop(String paramString)
  {
    Log.d(TAG, "notifyReachedPokestop() id : " + paramString);
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(new PokestopClickCallback(paramString)
    {
      public void onClick()
      {
        super.onClick();
        sfidaService.setOnClickSfidaListener(null);
        UnityPlayer.UnitySendMessage("AndroidSfidaConnection", "HackPokestop", getId());
      }
    });
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getReachedPokestop());
  }
  
  public boolean notifyReadyForThrowPokeball(String paramString)
  {
    Log.d(TAG, "notifyReadyForThrowPokeball() : " + paramString);
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(new SfidaButtonDetector.OnClickListener()
    {
      public void onClick()
      {
        sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getThrewPokeball());
        sfidaService.setOnClickSfidaListener(null);
        UnityPlayer.UnitySendMessage("AndroidSfidaConnection", "ThrowPokeball", "");
      }
      
      public void onPress() {}
      
      public void onRelease() {}
    });
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getReadyForThrowPokeball());
  }
  
  public boolean notifyRewardItems(String paramString)
  {
    Log.d(TAG, "notifyRewardItems() count : " + paramString);
    if (!isEnableSfida()) {
      return false;
    }
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getRewardItems(Integer.valueOf(paramString).intValue()));
  }
  
  public boolean notifySpawnedLegendaryPokemon(String paramString)
  {
    Log.d(TAG, "notifySpawnedLegendaryPokemon() id : " + paramString);
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(new EncounterPokemonClickCallback(paramString)
    {
      public void onClick()
      {
        super.onClick();
        sfidaService.setOnClickSfidaListener(null);
        UnityPlayer.UnitySendMessage("AndroidSfidaConnection", "EnterEncounterState", getId());
      }
    });
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getSpawnedLegendaryPokemon());
  }
  
  public boolean notifySpawnedPokemon(String paramString)
  {
    Log.d(TAG, "notifySpawnedPokemon() id : " + paramString);
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(new EncounterPokemonClickCallback(paramString)
    {
      public void onClick()
      {
        super.onClick();
        sfidaService.setOnClickSfidaListener(null);
        UnityPlayer.UnitySendMessage("AndroidSfidaConnection", "EnterEncounterState", getId());
      }
    });
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getSpawnedPokemon());
  }
  
  public boolean notifySpawnedUncaughtPokemon(String paramString)
  {
    Log.d(TAG, "notifySpawnedUncaughtPokemon() id : " + paramString);
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(new EncounterPokemonClickCallback(paramString)
    {
      public void onClick()
      {
        super.onClick();
        sfidaService.setOnClickSfidaListener(null);
        UnityPlayer.UnitySendMessage("AndroidSfidaConnection", "EnterEncounterState", getId());
      }
    });
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getSpawnedUncaughtPokemon());
  }
  
  public boolean notifyStartDowser()
  {
    Log.d(TAG, "notifyStartDowser()");
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(null);
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getDonePattern());
  }
  
  public boolean oneShotVibrate()
  {
    if (!isEnableSfida()) {
      return false;
    }
    sfidaService.setOnClickSfidaListener(null);
    return sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getCaptureSucceed());
  }
  
  public void releaseSfida()
  {
    Log.d(TAG, "releaseSfida()");
    if (isReceiverRegistered) {
      getActivity().unregisterReceiver(gattUpdateReceiver);
    }
    for (;;)
    {
      if (isServiceBound)
      {
        getActivity().unbindService(serviceConnection);
        isServiceBound = false;
      }
      if (handler != null)
      {
        handler.removeCallbacksAndMessages(null);
        handler = null;
      }
      return;
      Log.d(TAG, "releaseSfida() isNotReceiverRegistered");
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    activity = paramActivity;
  }
  
  private class PeriodicVibrateRunnable
    implements Runnable
  {
    Handler handler;
    
    public PeriodicVibrateRunnable(Handler paramHandler)
    {
      handler = paramHandler;
    }
    
    public void run()
    {
      Log.d(SfidaUnityPlugin.TAG, getClass().getName() + " run()");
      sfidaService.sendDeviceControlMessage(SfidaMessage.UUID_LED_VIBRATE_CTRL_CHAR, SfidaMessage.getCaptureSucceed());
      if (handler != null) {
        handler.postDelayed(this, 1000L);
      }
    }
    
    public void stop()
    {
      handler.removeCallbacks(null);
      handler = null;
    }
  }
  
  private class SfidaDiscoveredListener
    implements SfidaFinderFragment.OnDeviceDiscoveredListener
  {
    private SfidaDiscoveredListener() {}
    
    public void onDeviceDiscovered(BluetoothDevice paramBluetoothDevice, boolean paramBoolean)
    {
      Toast.makeText(SfidaUnityPlugin.this.getActivity(), "Pokémon GO Plus discovered.", 0).show();
      SfidaUnityPlugin.this.stopScanSfida();
      SfidaUnityPlugin.this.startSfidaConnection(paramBluetoothDevice);
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.unity.SfidaUnityPlugin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */