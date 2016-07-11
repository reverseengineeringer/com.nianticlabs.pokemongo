package com.upsight.android;

import com.upsight.android.marketing.UpsightBillboardManager;
import com.upsight.android.marketing.UpsightMarketingApi;
import com.upsight.android.marketing.UpsightMarketingComponent;
import com.upsight.android.marketing.internal.content.DefaultContentMediator;
import com.upsight.android.marketing.internal.content.MarketingContentFactory;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class UpsightMarketingExtension_MembersInjector
  implements MembersInjector<UpsightMarketingExtension>
{
  private final Provider<UpsightBillboardManager> mBillboardManagerProvider;
  private final Provider<DefaultContentMediator> mDefaultContentMediatorProvider;
  private final Provider<MarketingContentFactory> mMarketingContentFactoryProvider;
  private final Provider<UpsightMarketingApi> mMarketingProvider;
  private final MembersInjector<UpsightExtension<UpsightMarketingComponent, UpsightMarketingApi>> supertypeInjector;
  
  static
  {
    if (!UpsightMarketingExtension_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UpsightMarketingExtension_MembersInjector(MembersInjector<UpsightExtension<UpsightMarketingComponent, UpsightMarketingApi>> paramMembersInjector, Provider<UpsightMarketingApi> paramProvider, Provider<MarketingContentFactory> paramProvider1, Provider<UpsightBillboardManager> paramProvider2, Provider<DefaultContentMediator> paramProvider3)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    mMarketingProvider = paramProvider;
    assert (paramProvider1 != null);
    mMarketingContentFactoryProvider = paramProvider1;
    assert (paramProvider2 != null);
    mBillboardManagerProvider = paramProvider2;
    assert (paramProvider3 != null);
    mDefaultContentMediatorProvider = paramProvider3;
  }
  
  public static MembersInjector<UpsightMarketingExtension> create(MembersInjector<UpsightExtension<UpsightMarketingComponent, UpsightMarketingApi>> paramMembersInjector, Provider<UpsightMarketingApi> paramProvider, Provider<MarketingContentFactory> paramProvider1, Provider<UpsightBillboardManager> paramProvider2, Provider<DefaultContentMediator> paramProvider3)
  {
    return new UpsightMarketingExtension_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }
  
  public void injectMembers(UpsightMarketingExtension paramUpsightMarketingExtension)
  {
    if (paramUpsightMarketingExtension == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(paramUpsightMarketingExtension);
    mMarketing = ((UpsightMarketingApi)mMarketingProvider.get());
    mMarketingContentFactory = ((MarketingContentFactory)mMarketingContentFactoryProvider.get());
    mBillboardManager = ((UpsightBillboardManager)mBillboardManagerProvider.get());
    mDefaultContentMediator = ((DefaultContentMediator)mDefaultContentMediatorProvider.get());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.UpsightMarketingExtension_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */