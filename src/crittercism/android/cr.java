package crittercism.android;

import java.io.UnsupportedEncodingException;

public final class cr
{
  private static final byte[] a;
  private static final byte[] b = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] c;
  
  static
  {
    try
    {
      byte[] arrayOfByte1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".getBytes("UTF-8");
      a = arrayOfByte1;
      c = new byte[] { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9 };
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        byte[] arrayOfByte2 = b;
      }
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramInt * 4 / 3;
    if (paramInt % 3 > 0) {}
    byte[] arrayOfByte;
    int k;
    for (int i = 4;; i = 0)
    {
      arrayOfByte = new byte[i + j + j / 76];
      j = 0;
      i = 0;
      k = 0;
      while (k < paramInt - 2)
      {
        a(paramArrayOfByte, k + 0, 3, arrayOfByte, i);
        int n = j + 4;
        j = n;
        int m = i;
        if (n == 76)
        {
          arrayOfByte[(i + 4)] = 10;
          m = i + 1;
          j = 0;
        }
        k += 3;
        i = m + 4;
      }
    }
    j = i;
    if (k < paramInt)
    {
      a(paramArrayOfByte, k + 0, paramInt - k, arrayOfByte, i);
      j = i + 4;
    }
    try
    {
      paramArrayOfByte = new String(arrayOfByte, 0, j, "UTF-8");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte) {}
    return new String(arrayOfByte, 0, j);
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int k = 0;
    int i;
    if (paramInt2 > 0)
    {
      i = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      label18:
      if (paramInt2 <= 1) {
        break label100;
      }
    }
    label100:
    for (int j = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16;; j = 0)
    {
      if (paramInt2 > 2) {
        k = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      }
      paramInt1 = k | j | i;
      switch (paramInt2)
      {
      default: 
        return paramArrayOfByte2;
        i = 0;
        break label18;
      }
    }
    paramArrayOfByte2[paramInt3] = a[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = a[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = a[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = a[(paramInt1 & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = a[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = a[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = a[(paramInt1 >>> 6 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = a[(paramInt1 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = a[(paramInt1 >>> 12 & 0x3F)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.cr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */