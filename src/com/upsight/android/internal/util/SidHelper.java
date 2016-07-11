package com.upsight.android.internal.util;

import android.content.Context;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class SidHelper
{
  private static final int BYTE_BUFFER_CAPACITY = 8;
  public static final String PREFERENCE_KEY_SID = "sid";
  
  public static String getSid(Context paramContext)
  {
    try
    {
      String str = PreferencesHelper.getString(paramContext, "sid", null);
      Object localObject = str;
      if (str == null)
      {
        localObject = UUID.randomUUID();
        localObject = new BigInteger(1, longToBytes(((UUID)localObject).getLeastSignificantBits() ^ ((UUID)localObject).getMostSignificantBits())).toString();
        PreferencesHelper.putString(paramContext, "sid", (String)localObject);
      }
      return (String)localObject;
    }
    finally {}
  }
  
  private static byte[] longToBytes(long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.putLong(paramLong);
    return localByteBuffer.array();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.util.SidHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */