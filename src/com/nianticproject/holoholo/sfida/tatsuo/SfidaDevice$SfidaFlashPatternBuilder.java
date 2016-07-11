package com.nianticproject.holoholo.sfida.tatsuo;

import android.graphics.Color;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

class SfidaDevice$SfidaFlashPatternBuilder
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

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.tatsuo.SfidaDevice.SfidaFlashPatternBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */