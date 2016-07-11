package com.nianticlabs.nia.sensors;

public class AngleFilter
{
  private static final float FRICTION_COEFFICIENT_1 = 1.0F;
  private static final float FRICTION_COEFFICIENT_2 = 0.5F;
  private static final float MAX_DT = 10.0F;
  private static final float SIGNAL_LEVEL = 10.0F;
  private static final float STEP_SIZE = 0.5F;
  private static final float TIME_NORMALIZATION_MS = 100.0F;
  protected float currentValue;
  private long lastReadingTime = 0L;
  private float speed = 0.0F;
  private final boolean wrap;
  
  public AngleFilter(boolean paramBoolean)
  {
    wrap = paramBoolean;
  }
  
  private void step(float paramFloat1, float paramFloat2)
  {
    paramFloat2 = (paramFloat2 - currentValue) / 10.0F;
    speed += Math.abs(paramFloat2) * paramFloat2 * paramFloat1;
    if (speed != 0.0F)
    {
      paramFloat2 = paramFloat2 * 10.0F / speed;
      paramFloat2 = (float)(1.0D * Math.exp(-paramFloat2 * paramFloat2) + 0.5D);
      if (paramFloat2 * paramFloat1 >= 1.0F) {
        speed = 0.0F;
      }
    }
    else
    {
      return;
    }
    speed -= speed * paramFloat2 * paramFloat1;
    currentValue += speed * paramFloat1;
  }
  
  public float filter(long paramLong, float paramFloat)
  {
    if ((lastReadingTime == 0L) || (paramLong < lastReadingTime)) {
      currentValue = paramFloat;
    }
    for (;;)
    {
      lastReadingTime = paramLong;
      if (!wrap) {
        break label206;
      }
      while (currentValue >= 360.0F) {
        currentValue -= 360.0F;
      }
      float f1 = paramFloat;
      if (wrap)
      {
        f1 = paramFloat;
        if (Math.abs(paramFloat - currentValue) * 2.0F > 360.0F) {
          if (paramFloat >= currentValue) {
            break label148;
          }
        }
      }
      label148:
      for (f1 = paramFloat + 360.0F;; f1 = paramFloat - 360.0F)
      {
        float f2 = (float)(paramLong - lastReadingTime) / 100.0F;
        if (f2 <= 10.0F)
        {
          paramFloat = f2;
          if (f2 >= 0.0F) {
            break label157;
          }
        }
        currentValue = f1;
        speed = 0.0F;
        break;
      }
      label157:
      while (paramFloat > 0.0F)
      {
        step(Math.min(0.5F, paramFloat), f1);
        paramFloat -= 0.5F;
      }
    }
    while (currentValue < 0.0F) {
      currentValue += 360.0F;
    }
    label206:
    return currentValue;
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.sensors.AngleFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */