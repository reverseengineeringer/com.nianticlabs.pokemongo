package com.nianticproject.holoholo.sfida.unity;

import android.bluetooth.BluetoothDevice;
import android.widget.Toast;
import com.nianticproject.holoholo.sfida.SfidaFinderFragment.OnDeviceDiscoveredListener;

class SfidaUnityPlugin$SfidaDiscoveredListener
  implements SfidaFinderFragment.OnDeviceDiscoveredListener
{
  private SfidaUnityPlugin$SfidaDiscoveredListener(SfidaUnityPlugin paramSfidaUnityPlugin) {}
  
  public void onDeviceDiscovered(BluetoothDevice paramBluetoothDevice, boolean paramBoolean)
  {
    Toast.makeText(SfidaUnityPlugin.access$500(this$0), "Pokémon GO Plus discovered.", 0).show();
    SfidaUnityPlugin.access$700(this$0);
    SfidaUnityPlugin.access$800(this$0, paramBluetoothDevice);
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.unity.SfidaUnityPlugin.SfidaDiscoveredListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */