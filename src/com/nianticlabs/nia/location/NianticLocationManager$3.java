package com.nianticlabs.nia.location;

class NianticLocationManager$3
  implements Runnable
{
  NianticLocationManager$3(NianticLocationManager paramNianticLocationManager, int paramInt1, double paramDouble, int paramInt2) {}
  
  public void run()
  {
    if (NianticLocationManager.access$400(this$0)) {
      throw new IllegalStateException("Already started.");
    }
    NianticLocationManager.access$502(this$0, val$gps_update_time_ms);
    NianticLocationManager.access$602(this$0, (float)val$update_distance);
    NianticLocationManager.access$702(this$0, val$net_update_time_ms);
    NianticLocationManager.access$802(this$0, (float)val$update_distance);
    NianticLocationManager.access$900(this$0);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.location.NianticLocationManager.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */