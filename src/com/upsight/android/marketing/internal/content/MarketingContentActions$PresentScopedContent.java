package com.upsight.android.marketing.internal.content;

import android.text.TextUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.analytics.internal.action.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MarketingContentActions$PresentScopedContent
  extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
{
  public static final String ID = "id";
  public static final String SCOPE_LIST = "scope_list";
  
  private MarketingContentActions$PresentScopedContent(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramMarketingContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(MarketingContent paramMarketingContent)
  {
    String str = optParamString("id");
    Object localObject = optParamJsonArray("scope_list");
    if ((!TextUtils.isEmpty(str)) && (localObject != null) && (((JsonNode)localObject).isArray()))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((JsonNode)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        JsonNode localJsonNode = (JsonNode)((Iterator)localObject).next();
        if (localJsonNode.isTextual()) {
          localArrayList.add(localJsonNode.asText());
        }
      }
      getActionContextmContentStore.presentScopedContent(str, (String[])localArrayList.toArray(new String[localArrayList.size()]));
    }
    paramMarketingContent.signalActionCompleted(getActionContextmBus);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.PresentScopedContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */