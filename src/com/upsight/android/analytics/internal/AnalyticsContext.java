package com.upsight.android.analytics.internal;

import android.content.ContextWrapper;
import android.content.res.Resources;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.R.raw;
import com.upsight.android.logger.UpsightLogger;
import java.io.IOException;
import javax.inject.Inject;
import org.apache.commons.io.IOUtils;

public class AnalyticsContext
  extends ContextWrapper
{
  private static final String LOG_TAG = AnalyticsContext.class.getSimpleName();
  private final UpsightContext mUpsight;
  
  @Inject
  public AnalyticsContext(UpsightContext paramUpsightContext)
  {
    super(paramUpsightContext);
    mUpsight = paramUpsightContext;
  }
  
  public String getDefaultDispatcherConfiguration()
  {
    try
    {
      String str = IOUtils.toString(getResources().openRawResource(R.raw.dispatcher_config));
      return str;
    }
    catch (IOException localIOException)
    {
      mUpsight.getLogger().e(LOG_TAG, "Could not read default configuration.", new Object[] { localIOException });
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.AnalyticsContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */