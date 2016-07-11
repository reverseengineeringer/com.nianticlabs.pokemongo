package com.nianticproject.holoholo.sfida.service;

import android.util.Log;

public class SfidaButtonDetector
{
  private static final int NOTIFY_BIT_SIZE = 10;
  private static final int SFIDA_BUTTON_NOTIFY_BYTE_ARRAY_SIZE = 2;
  private static final String TAG = SfidaButtonDetector.class.getSimpleName();
  int count = 0;
  private OnClickListener onClickListener;
  private ButtonStatus preButtonStatus = new ButtonStatus();
  
  private boolean[] createTestCase()
  {
    boolean[] arrayOfBoolean = new boolean[10];
    if (count == 0)
    {
      arrayOfBoolean[0] = false;
      arrayOfBoolean[1] = false;
      arrayOfBoolean[2] = false;
      arrayOfBoolean[3] = false;
      arrayOfBoolean[4] = false;
      arrayOfBoolean[5] = false;
      arrayOfBoolean[6] = false;
      arrayOfBoolean[7] = false;
      arrayOfBoolean[8] = false;
      arrayOfBoolean[9] = true;
    }
    for (;;)
    {
      count += 1;
      return arrayOfBoolean;
      if (count == 1)
      {
        arrayOfBoolean[0] = false;
        arrayOfBoolean[1] = true;
        arrayOfBoolean[2] = false;
        arrayOfBoolean[3] = true;
        arrayOfBoolean[4] = false;
        arrayOfBoolean[5] = true;
        arrayOfBoolean[6] = false;
        arrayOfBoolean[7] = true;
        arrayOfBoolean[8] = false;
        arrayOfBoolean[9] = true;
      }
    }
  }
  
  private ButtonStatus getButtonStatus(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    ButtonStatus localButtonStatus = new ButtonStatus();
    paramBoolean = preButtonStatus.value[9];
    Log.d(TAG, "isPreValuePressed start with : " + paramBoolean);
    int j = paramArrayOfBoolean.length;
    int i = 0;
    if (i < j)
    {
      boolean bool = paramArrayOfBoolean[i];
      if (bool) {
        if (!paramBoolean)
        {
          pressedCount += 1;
          if (onClickListener != null) {
            onClickListener.onPress();
          }
        }
      }
      for (;;)
      {
        paramBoolean = bool;
        i += 1;
        break;
        if (paramBoolean)
        {
          clickedCount += 1;
          releasedCount += 1;
          if (onClickListener != null) {
            onClickListener.onClick();
          }
          if (onClickListener != null) {
            onClickListener.onRelease();
          }
        }
      }
    }
    value = paramArrayOfBoolean;
    return localButtonStatus;
  }
  
  public void release()
  {
    setOnclickListener(null);
  }
  
  public void setButtonStatus(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 2)) {
      return;
    }
    boolean[] arrayOfBoolean = new boolean[10];
    int j = paramArrayOfByte[0];
    int i = 0;
    int k;
    if (i < 2)
    {
      if ((Integer.valueOf(j).intValue() & 1 << i) != 0) {}
      for (k = 1;; k = 0)
      {
        arrayOfBoolean[(1 - i)] = k;
        i = (byte)(i + 1);
        break;
      }
    }
    j = paramArrayOfByte[1];
    i = 0;
    if (i < 8)
    {
      if ((Integer.valueOf(j).intValue() & 1 << i) != 0) {}
      for (k = 1;; k = 0)
      {
        arrayOfBoolean[(9 - i)] = k;
        i = (byte)(i + 1);
        break;
      }
    }
    preButtonStatus = getButtonStatus(arrayOfBoolean, paramBoolean);
  }
  
  public void setOnclickListener(OnClickListener paramOnClickListener)
  {
    onClickListener = paramOnClickListener;
  }
  
  private static class ButtonStatus
  {
    int clickedCount;
    int pressedCount;
    int releasedCount;
    boolean[] value = new boolean[10];
  }
  
  public static abstract interface OnClickListener
  {
    public abstract void onClick();
    
    public abstract void onPress();
    
    public abstract void onRelease();
  }
}

/* Location:
 * Qualified Name:     com.nianticproject.holoholo.sfida.service.SfidaButtonDetector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */