package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public class zze
{
  private final long zzahV;
  private final int zzahW;
  private final SimpleArrayMap<String, Long> zzahX;
  
  public zze()
  {
    zzahV = 60000L;
    zzahW = 10;
    zzahX = new SimpleArrayMap(10);
  }
  
  public zze(int paramInt, long paramLong)
  {
    zzahV = paramLong;
    zzahW = paramInt;
    zzahX = new SimpleArrayMap();
  }
  
  private void zzb(long paramLong1, long paramLong2)
  {
    int i = zzahX.size() - 1;
    while (i >= 0)
    {
      if (paramLong2 - ((Long)zzahX.valueAt(i)).longValue() > paramLong1) {
        zzahX.removeAt(i);
      }
      i -= 1;
    }
  }
  
  public Long zzcx(String paramString)
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = zzahV;
    try
    {
      while (zzahX.size() >= zzahW)
      {
        zzb(l1, l2);
        l1 /= 2L;
        Log.w("ConnectionTracker", "The max capacity " + zzahW + " is not enough. Current durationThreshold is: " + l1);
      }
      paramString = (Long)zzahX.put(paramString, Long.valueOf(l2));
    }
    finally {}
    return paramString;
  }
  
  public boolean zzcy(String paramString)
  {
    for (;;)
    {
      try
      {
        if (zzahX.remove(paramString) != null)
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */