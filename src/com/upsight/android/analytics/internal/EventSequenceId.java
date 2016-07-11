package com.upsight.android.analytics.internal;

import android.content.Context;
import com.upsight.android.internal.util.PreferencesHelper;

public final class EventSequenceId
{
  private static final long INITIAL_SEQUENCE_ID = 1L;
  private static final String PREFERENCES_KEY_SEQ_ID = "seq_id";
  
  public static long getAndIncrement(Context paramContext)
  {
    try
    {
      long l = PreferencesHelper.getLong(paramContext, "seq_id", 1L);
      PreferencesHelper.putLong(paramContext, "seq_id", l + 1L);
      return l;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.EventSequenceId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */