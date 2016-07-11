package com.upsight.android.marketing.internal.content;

import com.upsight.android.analytics.internal.action.ActionableStore;
import java.util.Set;

public abstract interface MarketingContentStore
  extends ActionableStore<MarketingContent>
{
  public abstract Set<String> getIdsForScope(String paramString);
  
  public abstract boolean presentScopedContent(String paramString, String[] paramArrayOfString);
  
  public abstract boolean presentScopelessContent(String paramString1, String paramString2);
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */