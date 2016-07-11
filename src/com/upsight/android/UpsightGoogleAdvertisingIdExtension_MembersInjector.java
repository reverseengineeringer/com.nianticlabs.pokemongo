package com.upsight.android;

import com.upsight.android.googleadvertisingid.UpsightGoogleAdvertisingProviderComponent;
import com.upsight.android.googleadvertisingid.internal.GooglePlayAdvertisingProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class UpsightGoogleAdvertisingIdExtension_MembersInjector
  implements MembersInjector<UpsightGoogleAdvertisingIdExtension>
{
  private final Provider<GooglePlayAdvertisingProvider> mAdvertisingIdProvider;
  private final MembersInjector<UpsightExtension<UpsightGoogleAdvertisingProviderComponent, Void>> supertypeInjector;
  
  static
  {
    if (!UpsightGoogleAdvertisingIdExtension_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UpsightGoogleAdvertisingIdExtension_MembersInjector(MembersInjector<UpsightExtension<UpsightGoogleAdvertisingProviderComponent, Void>> paramMembersInjector, Provider<GooglePlayAdvertisingProvider> paramProvider)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    mAdvertisingIdProvider = paramProvider;
  }
  
  public static MembersInjector<UpsightGoogleAdvertisingIdExtension> create(MembersInjector<UpsightExtension<UpsightGoogleAdvertisingProviderComponent, Void>> paramMembersInjector, Provider<GooglePlayAdvertisingProvider> paramProvider)
  {
    return new UpsightGoogleAdvertisingIdExtension_MembersInjector(paramMembersInjector, paramProvider);
  }
  
  public void injectMembers(UpsightGoogleAdvertisingIdExtension paramUpsightGoogleAdvertisingIdExtension)
  {
    if (paramUpsightGoogleAdvertisingIdExtension == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(paramUpsightGoogleAdvertisingIdExtension);
    mAdvertisingIdProvider = ((GooglePlayAdvertisingProvider)mAdvertisingIdProvider.get());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.UpsightGoogleAdvertisingIdExtension_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */