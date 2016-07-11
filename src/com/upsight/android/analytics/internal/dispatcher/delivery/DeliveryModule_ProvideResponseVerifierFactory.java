package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DeliveryModule_ProvideResponseVerifierFactory
  implements Factory<SignatureVerifier>
{
  private final DeliveryModule module;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!DeliveryModule_ProvideResponseVerifierFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public DeliveryModule_ProvideResponseVerifierFactory(DeliveryModule paramDeliveryModule, Provider<UpsightContext> paramProvider)
  {
    assert (paramDeliveryModule != null);
    module = paramDeliveryModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
  }
  
  public static Factory<SignatureVerifier> create(DeliveryModule paramDeliveryModule, Provider<UpsightContext> paramProvider)
  {
    return new DeliveryModule_ProvideResponseVerifierFactory(paramDeliveryModule, paramProvider);
  }
  
  public SignatureVerifier get()
  {
    SignatureVerifier localSignatureVerifier = module.provideResponseVerifier((UpsightContext)upsightProvider.get());
    if (localSignatureVerifier == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localSignatureVerifier;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.DeliveryModule_ProvideResponseVerifierFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */