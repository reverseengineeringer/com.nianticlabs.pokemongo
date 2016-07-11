package com.upsight.android.internal;

import android.content.Context;
import android.util.Log;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;
import com.upsight.android.internal.logger.LogWriter;
import com.upsight.android.internal.persistence.storable.StorableIdFactory;
import com.upsight.android.logger.UpsightLogger.Level;
import dagger.Module;
import dagger.Provides;
import java.util.UUID;
import javax.inject.Singleton;

@Module
public final class ContextModule
{
  private final Context mApplicationContext;
  
  public ContextModule(Context paramContext)
  {
    mApplicationContext = paramContext.getApplicationContext();
  }
  
  @Provides
  @Singleton
  Context provideApplicationContext()
  {
    return mApplicationContext;
  }
  
  @Provides
  @Singleton
  Bus provideBus()
  {
    return new Bus(ThreadEnforcer.ANY);
  }
  
  @Provides
  @Singleton
  LogWriter provideLogWriter()
  {
    new LogWriter()
    {
      private void logMessage(String paramAnonymousString1, UpsightLogger.Level paramAnonymousLevel, String paramAnonymousString2)
      {
        switch (ContextModule.3.$SwitchMap$com$upsight$android$logger$UpsightLogger$Level[paramAnonymousLevel.ordinal()])
        {
        default: 
          return;
        case 1: 
          Log.v(paramAnonymousString1, paramAnonymousString2);
          return;
        case 2: 
          Log.d(paramAnonymousString1, paramAnonymousString2);
          return;
        case 3: 
          Log.i(paramAnonymousString1, paramAnonymousString2);
          return;
        case 4: 
          Log.w(paramAnonymousString1, paramAnonymousString2);
          return;
        }
        Log.e(paramAnonymousString1, paramAnonymousString2);
      }
      
      public void write(String paramAnonymousString1, UpsightLogger.Level paramAnonymousLevel, String paramAnonymousString2)
      {
        if (paramAnonymousString2.length() > 4000)
        {
          int j = paramAnonymousString2.length() / 4000;
          int i = 0;
          if (i <= j)
          {
            int k = (i + 1) * 4000;
            if (k >= paramAnonymousString2.length()) {
              logMessage(paramAnonymousString1, paramAnonymousLevel, paramAnonymousString2.substring(i * 4000));
            }
            for (;;)
            {
              i += 1;
              break;
              logMessage(paramAnonymousString1, paramAnonymousLevel, paramAnonymousString2.substring(i * 4000, k));
            }
          }
        }
        else
        {
          logMessage(paramAnonymousString1, paramAnonymousLevel, paramAnonymousString2);
        }
      }
    };
  }
  
  @Provides
  @Singleton
  StorableIdFactory provideTypeIdGenerator()
  {
    new StorableIdFactory()
    {
      public String createObjectID()
      {
        return UUID.randomUUID().toString();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.ContextModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */