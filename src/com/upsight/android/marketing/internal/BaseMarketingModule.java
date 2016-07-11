package com.upsight.android.marketing.internal;

import com.upsight.android.UpsightContext;
import com.upsight.android.marketing.UpsightBillboardManager;
import com.upsight.android.marketing.UpsightMarketingApi;
import com.upsight.android.marketing.UpsightMarketingContentStore;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

@Module
public final class BaseMarketingModule
{
  public static final String SCHEDULER_MAIN = "main";
  private final UpsightContext mUpsight;
  
  public BaseMarketingModule(UpsightContext paramUpsightContext)
  {
    mUpsight = paramUpsightContext;
  }
  
  @Provides
  @Named("main")
  @Singleton
  Scheduler provideMainScheduler()
  {
    return AndroidSchedulers.mainThread();
  }
  
  @Provides
  @Singleton
  UpsightMarketingApi provideMarketingApi(UpsightBillboardManager paramUpsightBillboardManager, UpsightMarketingContentStore paramUpsightMarketingContentStore)
  {
    return new Marketing(paramUpsightBillboardManager, paramUpsightMarketingContentStore);
  }
  
  @Provides
  @Singleton
  UpsightContext provideUpsightContext()
  {
    return mUpsight;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.BaseMarketingModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */