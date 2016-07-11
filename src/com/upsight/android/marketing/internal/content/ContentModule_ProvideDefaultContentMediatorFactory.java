package com.upsight.android.marketing.internal.content;

import dagger.internal.Factory;

public final class ContentModule_ProvideDefaultContentMediatorFactory
  implements Factory<DefaultContentMediator>
{
  private final ContentModule module;
  
  static
  {
    if (!ContentModule_ProvideDefaultContentMediatorFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ContentModule_ProvideDefaultContentMediatorFactory(ContentModule paramContentModule)
  {
    assert (paramContentModule != null);
    module = paramContentModule;
  }
  
  public static Factory<DefaultContentMediator> create(ContentModule paramContentModule)
  {
    return new ContentModule_ProvideDefaultContentMediatorFactory(paramContentModule);
  }
  
  public DefaultContentMediator get()
  {
    DefaultContentMediator localDefaultContentMediator = module.provideDefaultContentMediator();
    if (localDefaultContentMediator == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localDefaultContentMediator;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.ContentModule_ProvideDefaultContentMediatorFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */