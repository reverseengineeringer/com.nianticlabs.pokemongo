package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import com.upsight.android.analytics.internal.session.Clock;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;
import rx.Scheduler;

@Module
public final class DeliveryModule
{
  @Provides
  @Singleton
  public QueueBuilder provideQueueBuilder(UpsightContext paramUpsightContext, Clock paramClock, @Named("dispatcher-threadpool") Scheduler paramScheduler1, @Named("dispatcher-batching") Scheduler paramScheduler2, SignatureVerifier paramSignatureVerifier, Provider<ResponseParser> paramProvider)
  {
    return new QueueBuilder(paramUpsightContext, paramUpsightContext.getCoreComponent().objectMapper(), paramClock, paramUpsightContext.getLogger(), paramScheduler1, paramScheduler2, paramSignatureVerifier, paramProvider);
  }
  
  @Provides
  @Singleton
  public SignatureVerifier provideResponseVerifier(UpsightContext paramUpsightContext)
  {
    return new BouncySignatureVerifier(paramUpsightContext);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.DeliveryModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */