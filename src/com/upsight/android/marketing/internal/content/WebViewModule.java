package com.upsight.android.marketing.internal.content;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class WebViewModule
{
  @Provides
  @Singleton
  ContentTemplateWebViewClientFactory provideContentTemplateWebViewClientFactory(UpsightContext paramUpsightContext)
  {
    UpsightCoreComponent localUpsightCoreComponent = paramUpsightContext.getCoreComponent();
    return new ContentTemplateWebViewClientFactory(localUpsightCoreComponent.bus(), localUpsightCoreComponent.objectMapper(), paramUpsightContext.getLogger());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.WebViewModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */