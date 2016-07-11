package com.upsight.android.analytics.internal;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.upsight.android.Upsight;
import com.upsight.android.UpsightAnalyticsExtension;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.UpsightAnalyticsComponent;
import com.upsight.android.analytics.internal.configuration.ConfigurationManager;
import com.upsight.android.analytics.internal.dispatcher.Dispatcher;
import com.upsight.android.analytics.internal.session.ApplicationStatus;
import com.upsight.android.analytics.internal.session.ApplicationStatus.State;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightSubscription;
import com.upsight.android.persistence.annotation.Created;
import com.upsight.android.persistence.annotation.Updated;
import javax.inject.Inject;

public class DispatcherService
  extends Service
{
  private static final long STATUS_CHECK_INTERVAL = 25000L;
  private static final int STOP_AFTER_DEAD_INTERVALS = 4;
  @Inject
  ConfigurationManager mConfigurationManager;
  private UpsightSubscription mDataStoreSubscription;
  private int mDeadIntervalsInARow;
  @Inject
  Dispatcher mDispatcher;
  private Handler mHandler;
  private Runnable mSelfStopTask = new Runnable()
  {
    public void run()
    {
      if (mDispatcher.hasPendingRecords())
      {
        DispatcherService.access$002(DispatcherService.this, 0);
        mHandler.postDelayed(mSelfStopTask, 25000L);
        return;
      }
      if (mDeadIntervalsInARow == 4)
      {
        stopSelf();
        return;
      }
      DispatcherService.access$008(DispatcherService.this);
      mHandler.postDelayed(mSelfStopTask, 25000L);
    }
  };
  
  @Created
  @Updated
  public void onApplicationStatus(ApplicationStatus paramApplicationStatus)
  {
    if (paramApplicationStatus.getState() == ApplicationStatus.State.BACKGROUND)
    {
      mDeadIntervalsInARow = 0;
      mHandler.postDelayed(mSelfStopTask, 25000L);
      return;
    }
    mHandler.removeCallbacks(mSelfStopTask);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    UpsightContext localUpsightContext = Upsight.createContext(this);
    ((UpsightAnalyticsComponent)((UpsightAnalyticsExtension)localUpsightContext.getUpsightExtension("com.upsight.extension.analytics")).getComponent()).inject(this);
    mHandler = new Handler();
    mDataStoreSubscription = localUpsightContext.getDataStore().subscribe(this);
    mDispatcher.launch();
    mConfigurationManager.launch();
  }
  
  public void onDestroy()
  {
    mHandler.removeCallbacks(mSelfStopTask);
    mDataStoreSubscription.unsubscribe();
    mConfigurationManager.terminate();
    mDispatcher.terminate();
    super.onDestroy();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.DispatcherService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */