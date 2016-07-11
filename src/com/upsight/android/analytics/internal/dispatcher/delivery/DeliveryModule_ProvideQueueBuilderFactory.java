package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.session.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;
import rx.Scheduler;

public final class DeliveryModule_ProvideQueueBuilderFactory
  implements Factory<QueueBuilder>
{
  private final Provider<Clock> clockProvider;
  private final DeliveryModule module;
  private final Provider<ResponseParser> responseParserProvider;
  private final Provider<Scheduler> retryExecutorProvider;
  private final Provider<Scheduler> sendExecutorProvider;
  private final Provider<SignatureVerifier> signatureVerifierProvider;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!DeliveryModule_ProvideQueueBuilderFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public DeliveryModule_ProvideQueueBuilderFactory(DeliveryModule paramDeliveryModule, Provider<UpsightContext> paramProvider, Provider<Clock> paramProvider1, Provider<Scheduler> paramProvider2, Provider<Scheduler> paramProvider3, Provider<SignatureVerifier> paramProvider4, Provider<ResponseParser> paramProvider5)
  {
    assert (paramDeliveryModule != null);
    module = paramDeliveryModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
    assert (paramProvider1 != null);
    clockProvider = paramProvider1;
    assert (paramProvider2 != null);
    retryExecutorProvider = paramProvider2;
    assert (paramProvider3 != null);
    sendExecutorProvider = paramProvider3;
    assert (paramProvider4 != null);
    signatureVerifierProvider = paramProvider4;
    assert (paramProvider5 != null);
    responseParserProvider = paramProvider5;
  }
  
  public static Factory<QueueBuilder> create(DeliveryModule paramDeliveryModule, Provider<UpsightContext> paramProvider, Provider<Clock> paramProvider1, Provider<Scheduler> paramProvider2, Provider<Scheduler> paramProvider3, Provider<SignatureVerifier> paramProvider4, Provider<ResponseParser> paramProvider5)
  {
    return new DeliveryModule_ProvideQueueBuilderFactory(paramDeliveryModule, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5);
  }
  
  public QueueBuilder get()
  {
    QueueBuilder localQueueBuilder = module.provideQueueBuilder((UpsightContext)upsightProvider.get(), (Clock)clockProvider.get(), (Scheduler)retryExecutorProvider.get(), (Scheduler)sendExecutorProvider.get(), (SignatureVerifier)signatureVerifierProvider.get(), responseParserProvider);
    if (localQueueBuilder == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localQueueBuilder;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.DeliveryModule_ProvideQueueBuilderFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */