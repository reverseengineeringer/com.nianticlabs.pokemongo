package com.upsight.android.analytics.internal.dispatcher.schema;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import com.upsight.android.analytics.provider.UpsightDataProvider;
import com.upsight.android.internal.util.NetworkHelper;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeviceBlockProvider
  extends UpsightDataProvider
{
  public static final String CARRIER_KEY = "device.carrier";
  public static final String CONNECTION_KEY = "device.connection";
  private static final String DEVICE_TYPE_PHONE = "phone";
  private static final String DEVICE_TYPE_TABLET = "tablet";
  public static final String HARDWARE_KEY = "device.hardware";
  public static final String JAILBROKEN_KEY = "device.jailbroken";
  private static final String KERNEL_BUILD_KEY_TEST = "test-keys";
  public static final String LIMITED_AD_TRACKING_KEY = "device.limit_ad_tracking";
  public static final String MANUFACTURER_KEY = "device.manufacturer";
  private static final String OS_ANDROID = "android";
  public static final String OS_KEY = "device.os";
  public static final String OS_VERSION_KEY = "device.os_version";
  private static final String SPACE = " ";
  public static final String TYPE_KEY = "device.type";
  
  DeviceBlockProvider(Context paramContext)
  {
    put("device.carrier", NetworkHelper.getNetworkOperatorName(paramContext));
    put("device.connection", NetworkHelper.getActiveNetworkType(paramContext));
    put("device.hardware", Build.MODEL);
    put("device.jailbroken", Boolean.valueOf(isRooted()));
    put("device.manufacturer", Build.MANUFACTURER);
    put("device.os", "android");
    put("device.os_version", Build.VERSION.RELEASE + " " + Build.VERSION.SDK_INT);
    put("device.type", getDeviceType(paramContext));
  }
  
  private String getDeviceType(Context paramContext)
  {
    String str = "phone";
    if ((getResourcesgetConfigurationscreenLayout & 0xF) >= 3) {
      str = "tablet";
    }
    return str;
  }
  
  private boolean isRooted()
  {
    String str = Build.TAGS;
    return (str != null) && (str.contains("test-keys"));
  }
  
  public Set<String> availableKeys()
  {
    return new HashSet(Arrays.asList(new String[] { "device.os", "device.os_version", "device.type", "device.hardware", "device.manufacturer", "device.carrier", "device.connection", "device.jailbroken" }));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.schema.DeviceBlockProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */