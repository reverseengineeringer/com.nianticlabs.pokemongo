package com.nianticlabs.nia.sensors;

public final class MathUtil
{
  public static final float DEGREES_TO_RADIANS = 0.017453292F;
  public static final float HALF_PI = 1.5707964F;
  public static final double NANOSECONDS_PER_SECOND = 1.0E9D;
  public static final long NANOSECONDS_PER_SECOND_AS_LONG = 1000000000L;
  public static final float PI = 3.1415927F;
  public static final float RADIANS_TO_DEGREES = 57.29578F;
  public static final float TWO_PI = 6.2831855F;
  
  public static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat2, Math.min(paramFloat3, paramFloat1));
  }
  
  public static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.max(paramInt2, Math.min(paramInt3, paramInt1));
  }
  
  public static float degToRad(float paramFloat)
  {
    return 0.017453292F * paramFloat;
  }
  
  public static float ease(float paramFloat)
  {
    return (float)Math.sin(Math.max(Math.min(1.0F, paramFloat), 0.0F) * 3.141592653589793D / 2.0D);
  }
  
  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  public static float linearStep(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return saturate((paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1));
  }
  
  public static long nextPowerOf2(long paramLong)
  {
    paramLong = Math.max(paramLong, 0L) - 1L;
    paramLong |= paramLong >> 1;
    paramLong |= paramLong >> 2;
    paramLong |= paramLong >> 4;
    paramLong |= paramLong >> 8;
    return (paramLong | paramLong >> 16) + 1L;
  }
  
  public static double normalizeAngle(double paramDouble)
  {
    double d;
    for (;;)
    {
      d = paramDouble;
      if (paramDouble <= 3.141592653589793D) {
        break;
      }
      paramDouble -= 6.283185307179586D;
    }
    while (d <= -3.141592653589793D) {
      d += 6.283185307179586D;
    }
    return d;
  }
  
  public static float normalizeAngle(float paramFloat)
  {
    float f;
    for (;;)
    {
      f = paramFloat;
      if (paramFloat <= 3.1415927F) {
        break;
      }
      paramFloat -= 6.2831855F;
    }
    while (f <= -3.1415927F) {
      f += 6.2831855F;
    }
    return f;
  }
  
  public static float[] quadraticBezier(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt)
  {
    float[] arrayOfFloat = new float[paramInt * 2];
    int i = 0;
    while (i < paramInt)
    {
      float f = i * (1.0F / (paramInt - 1));
      arrayOfFloat[(i * 2)] = ((1.0F - f) * (1.0F - f) * paramFloat1 + (1.0F - f) * 2.0F * f * paramFloat3 + f * f * paramFloat5);
      arrayOfFloat[(i * 2 + 1)] = ((1.0F - f) * (1.0F - f) * paramFloat2 + (1.0F - f) * 2.0F * f * paramFloat4 + f * f * paramFloat6);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public static float radToDeg(float paramFloat)
  {
    return 57.29578F * paramFloat;
  }
  
  public static float randomRange(float paramFloat1, float paramFloat2)
  {
    return (paramFloat2 - paramFloat1) * (float)Math.random() + paramFloat1;
  }
  
  public static float saturate(float paramFloat)
  {
    return clamp(paramFloat, 0.0F, 1.0F);
  }
  
  public static double wrapAngle(double paramDouble)
  {
    double d;
    for (;;)
    {
      d = paramDouble;
      if (paramDouble < 6.283185307179586D) {
        break;
      }
      paramDouble -= 6.283185307179586D;
    }
    while (d < 0.0D) {
      d += 6.283185307179586D;
    }
    return d;
  }
  
  public static float wrapAngle(float paramFloat)
  {
    float f;
    for (;;)
    {
      f = paramFloat;
      if (paramFloat < 6.2831855F) {
        break;
      }
      paramFloat -= 6.2831855F;
    }
    while (f < 0.0F) {
      f += 6.2831855F;
    }
    return f;
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.sensors.MathUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */