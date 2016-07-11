package com.nianticlabs.nia.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.WindowManager;
import com.nianticlabs.nia.contextservice.ContextService;
import com.nianticlabs.nia.contextservice.ServiceStatus;

public class NianticSensorManager
  extends ContextService
  implements SensorEventListener
{
  private static final float ANGLE_CHANGE_THRESHOLD_DEGREES = 1.0F;
  private static final int DECLINATION_UPDATE_INTERVAL_MSEC = 600000;
  private static final boolean ENABLE_VERBOSE_LOGS = false;
  private static final int MAX_SENSOR_UPDATE_DIFF_MSEC = 5000;
  private static final int MIN_SENSOR_UPDATE_INTERVAL_MSEC = 50;
  private static final float SINE_OF_45_DEGREES = (float)Math.sqrt(2.0D) / 2.0F;
  private static final String TAG = "NianticSensorManager";
  private Sensor accelerometer;
  private float[] accelerometerData = new float[3];
  private long accelerometerReadingMs;
  private float declination;
  private long declinationUpdateTimeMs;
  private final Display display;
  private Sensor gravity;
  private Sensor gyroscope;
  private float lastAzimuthUpdate;
  private float lastPitchUpdate;
  private long lastUpdateTimeMs;
  private Sensor linearAcceleration;
  private Sensor magnetic;
  private float[] magneticData = new float[3];
  private long magnetometerReadingMs;
  private final AngleFilter orientationFilter = new AngleFilter(true);
  private Sensor rotation;
  private float[] rotationData = new float[5];
  private final SensorManager sensorManager;
  private ServiceStatus status = ServiceStatus.UNDEFINED;
  private final float[] tmpMatrix1 = new float[9];
  private final float[] tmpMatrix2 = new float[9];
  private final float[] tmpMatrix3 = new float[9];
  private final float[] tmpOrientationAngles = new float[3];
  
  public NianticSensorManager(Context paramContext, long paramLong)
  {
    super(paramContext, paramLong);
    display = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    sensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    gravity = sensorManager.getDefaultSensor(9);
    gyroscope = sensorManager.getDefaultSensor(4);
    accelerometer = sensorManager.getDefaultSensor(1);
    magnetic = sensorManager.getDefaultSensor(2);
    rotation = sensorManager.getDefaultSensor(11);
    linearAcceleration = sensorManager.getDefaultSensor(10);
  }
  
  private void calcMatrixFromRotationVector(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f8 = paramArrayOfFloat1[3];
    float f9 = paramArrayOfFloat1[0];
    float f10 = paramArrayOfFloat1[1];
    float f11 = paramArrayOfFloat1[2];
    float f1 = 2.0F * f9 * f9;
    float f2 = 2.0F * f10 * f10;
    float f3 = 2.0F * f11 * f11;
    float f4 = 2.0F * f9 * f10;
    float f5 = 2.0F * f11 * f8;
    float f6 = 2.0F * f9 * f11;
    float f7 = 2.0F * f10 * f8;
    f10 = 2.0F * f10 * f11;
    f8 = 2.0F * f9 * f8;
    paramArrayOfFloat2[0] = (1.0F - f2 - f3);
    paramArrayOfFloat2[1] = (f4 - f5);
    paramArrayOfFloat2[2] = (f6 + f7);
    paramArrayOfFloat2[3] = (f4 + f5);
    paramArrayOfFloat2[4] = (1.0F - f1 - f3);
    paramArrayOfFloat2[5] = (f10 - f8);
    paramArrayOfFloat2[6] = (f6 - f7);
    paramArrayOfFloat2[7] = (f10 + f8);
    paramArrayOfFloat2[8] = (1.0F - f1 - f2);
  }
  
  private float computeRotationVectorW(float[] paramArrayOfFloat)
  {
    float f1 = 0.0F;
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      float f2 = paramArrayOfFloat[i];
      f1 += f2 * f2;
      i += 1;
    }
    return (float)Math.sqrt(1.0F - Math.min(f1, 1.0F));
  }
  
  private float getDeclination()
  {
    long l = System.currentTimeMillis();
    if ((declinationUpdateTimeMs + 600000L > l) && (0 != 0))
    {
      declinationUpdateTimeMs = l;
      throw new NullPointerException();
    }
    return declination;
  }
  
  private native void nativeCompassUpdate(long paramLong, float paramFloat);
  
  private native void nativeSensorUpdate(int paramInt, long paramLong, float[] paramArrayOfFloat);
  
  private void safeCompassUpdate(long paramLong, float paramFloat)
  {
    synchronized (callbackLock)
    {
      nativeCompassUpdate(paramLong, paramFloat);
      return;
    }
  }
  
  private void safeSensorUpdate(int paramInt, long paramLong, float[] paramArrayOfFloat)
  {
    synchronized (callbackLock)
    {
      nativeSensorUpdate(paramInt, paramLong, paramArrayOfFloat);
      return;
    }
  }
  
  private void startSensorManager()
  {
    if (gravity != null) {
      sensorManager.registerListener(this, gravity, 3, ContextService.getServiceHandler());
    }
    if (gyroscope != null) {
      sensorManager.registerListener(this, gyroscope, 3, ContextService.getServiceHandler());
    }
    if (accelerometer != null) {
      sensorManager.registerListener(this, accelerometer, 2, ContextService.getServiceHandler());
    }
    if (magnetic != null) {
      sensorManager.registerListener(this, magnetic, 2, ContextService.getServiceHandler());
    }
    if (rotation != null) {
      sensorManager.registerListener(this, rotation, 2, ContextService.getServiceHandler());
    }
    if (linearAcceleration != null) {
      sensorManager.registerListener(this, linearAcceleration, 3, ContextService.getServiceHandler());
    }
    status = ServiceStatus.INITIALIZED;
  }
  
  private void stopSensorManager()
  {
    sensorManager.unregisterListener(this);
    status = ServiceStatus.STOPPED;
  }
  
  private boolean updateOrientation(long paramLong, float[] paramArrayOfFloat)
  {
    int i;
    int j;
    float[] arrayOfFloat;
    switch (display.getRotation())
    {
    default: 
      i = 1;
      j = 2;
      arrayOfFloat = tmpOrientationAngles;
      if (SensorManager.remapCoordinateSystem(paramArrayOfFloat, i, j, tmpMatrix2)) {
        break;
      }
    }
    do
    {
      return false;
      i = 2;
      j = 129;
      break;
      i = 130;
      j = 1;
      break;
      i = 129;
      j = 130;
      break;
      if (tmpMatrix2[7] <= SINE_OF_45_DEGREES) {
        break label231;
      }
    } while (!SensorManager.remapCoordinateSystem(tmpMatrix2, 1, 3, tmpMatrix3));
    SensorManager.getOrientation(tmpMatrix3, arrayOfFloat);
    for (float f1 = (float)Math.toDegrees(arrayOfFloat[1]) - 90.0F;; f1 = (float)Math.toDegrees(arrayOfFloat[1]))
    {
      float f2 = MathUtil.wrapAngle(arrayOfFloat[0] + 0.017453292F * getDeclination());
      f2 = orientationFilter.filter(paramLong, 57.29578F * f2);
      if ((Math.abs(f2 - lastAzimuthUpdate) < 1.0F) && (Math.abs(f1 - lastPitchUpdate) < 1.0F)) {
        break;
      }
      lastAzimuthUpdate = f2;
      lastPitchUpdate = f1;
      lastUpdateTimeMs = paramLong;
      return true;
      label231:
      SensorManager.getOrientation(tmpMatrix2, arrayOfFloat);
    }
  }
  
  private boolean updateOrientationFromRaw(long paramLong)
  {
    if (lastUpdateTimeMs + 50L > paramLong) {}
    float[] arrayOfFloat;
    do
    {
      do
      {
        return false;
      } while (Math.abs(accelerometerReadingMs - magnetometerReadingMs) > 5000L);
      arrayOfFloat = tmpMatrix1;
    } while (!SensorManager.getRotationMatrix(arrayOfFloat, null, accelerometerData, magneticData));
    return updateOrientation(paramLong, arrayOfFloat);
  }
  
  private boolean updateOrientationFromRotation(long paramLong)
  {
    if (lastUpdateTimeMs + 50L > paramLong) {
      return false;
    }
    float[] arrayOfFloat = tmpMatrix1;
    calcMatrixFromRotationVector(rotationData, arrayOfFloat);
    return updateOrientation(paramLong, arrayOfFloat);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onPause()
  {
    stopSensorManager();
  }
  
  public void onResume()
  {
    startSensorManager();
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    status = ServiceStatus.RUNNING;
    long l = System.currentTimeMillis();
    switch (sensor.getType())
    {
    }
    for (;;)
    {
      safeSensorUpdate(sensor.getType(), l, values);
      return;
      accelerometerReadingMs = l;
      System.arraycopy(values, 0, accelerometerData, 0, accelerometerData.length);
      if (updateOrientationFromRaw(l))
      {
        safeCompassUpdate(lastUpdateTimeMs, lastAzimuthUpdate);
        continue;
        magnetometerReadingMs = l;
        System.arraycopy(values, 0, magneticData, 0, magneticData.length);
        if (updateOrientationFromRaw(l))
        {
          safeCompassUpdate(lastUpdateTimeMs, lastAzimuthUpdate);
          continue;
          System.arraycopy(values, 0, rotationData, 0, Math.min(values.length, rotationData.length));
          if (values.length == 3) {
            rotationData[3] = computeRotationVectorW(rotationData);
          }
          if (updateOrientationFromRotation(l)) {
            safeCompassUpdate(lastUpdateTimeMs, lastAzimuthUpdate);
          }
        }
      }
    }
  }
  
  public void onStart() {}
  
  public void onStop() {}
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.sensors.NianticSensorManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */