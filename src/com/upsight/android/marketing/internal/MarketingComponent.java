package com.upsight.android.marketing.internal;

import com.upsight.android.marketing.UpsightMarketingComponent;
import dagger.Component;
import javax.inject.Singleton;

@Component(modules={MarketingModule.class})
@Singleton
public abstract interface MarketingComponent
  extends UpsightMarketingComponent
{}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.MarketingComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */