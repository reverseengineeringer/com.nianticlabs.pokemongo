package com.upsight.android.marketing.internal.content;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.otto.Bus;
import com.upsight.android.logger.UpsightLogger;
import java.io.IOException;
import java.util.Iterator;

class ContentTemplateWebViewClient
  extends WebViewClient
{
  private static final String DISPATCH_CALLBACK = "javascript:PlayHaven.nativeAPI.callback(\"%s\", %s, %s, %s)";
  private static final String DISPATCH_CALLBACK_PROTOCOL = "javascript:window.PlayHavenDispatchProtocolVersion=7";
  private static final String DISPATCH_LOAD_CONTEXT = "ph://loadContext";
  private static final String DISPATCH_PARAM_KEY_CALLBACK_ID = "callback";
  private static final String DISPATCH_PARAM_KEY_CONTEXT = "context";
  private static final String DISPATCH_PARAM_KEY_TRIGGER = "trigger";
  private static final String DISPATCH_PARAM_KEY_VIEW_DATA = "view_data";
  private static final String DISPATCH_SCHEME = "ph://";
  private final Bus mBus;
  private boolean mIsTemplateLoaded = false;
  private final UpsightLogger mLogger;
  private final ObjectMapper mMapper;
  private final MarketingContent mMarketingContent;
  
  public ContentTemplateWebViewClient(MarketingContent paramMarketingContent, Bus paramBus, ObjectMapper paramObjectMapper, UpsightLogger paramUpsightLogger)
  {
    mMarketingContent = paramMarketingContent;
    mBus = paramBus;
    mMapper = paramObjectMapper;
    mLogger = paramUpsightLogger;
  }
  
  private boolean handleActionDispatch(String paramString)
  {
    boolean bool2 = false;
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.startsWith("ph://"))
      {
        bool2 = true;
        Object localObject = Uri.parse(paramString).getQueryParameter("context");
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramString = null;
          try
          {
            localObject = mMapper.readTree((String)localObject);
            paramString = (String)localObject;
            JsonNode localJsonNode;
            if (((JsonNode)localObject).hasNonNull("trigger"))
            {
              paramString = (String)localObject;
              localJsonNode = ((JsonNode)localObject).path("trigger");
              paramString = (String)localObject;
              bool1 = bool2;
              if (localJsonNode.isTextual())
              {
                paramString = (String)localObject;
                mMarketingContent.executeActions(localJsonNode.asText());
                return true;
              }
            }
            else
            {
              paramString = (String)localObject;
              bool1 = bool2;
              if (((JsonNode)localObject).hasNonNull("view_data"))
              {
                paramString = (String)localObject;
                localJsonNode = ((JsonNode)localObject).path("view_data");
                paramString = (String)localObject;
                Iterator localIterator = localJsonNode.fieldNames();
                for (;;)
                {
                  paramString = (String)localObject;
                  bool1 = bool2;
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  paramString = (String)localObject;
                  String str = (String)localIterator.next();
                  paramString = (String)localObject;
                  mMarketingContent.putExtra(str, localJsonNode.path(str).toString());
                }
              }
            }
            return bool1;
          }
          catch (IOException localIOException)
          {
            mLogger.e(getClass().getSimpleName(), localIOException, "Failed to parse contextNode=" + paramString, new Object[0]);
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  @TargetApi(19)
  private boolean handleLoadContextDispatch(WebView paramWebView, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.startsWith("ph://loadContext"))
      {
        bool1 = true;
        paramString = String.format("javascript:PlayHaven.nativeAPI.callback(\"%s\", %s, %s, %s)", new Object[] { Uri.parse(paramString).getQueryParameter("callback"), mMarketingContent.getContentModel().getContext(), null, null });
        paramWebView.loadUrl("javascript:window.PlayHavenDispatchProtocolVersion=7");
        if (Build.VERSION.SDK_INT < 19) {
          break label89;
        }
        paramWebView.evaluateJavascript(paramString, null);
      }
    }
    return bool1;
    label89:
    paramWebView.loadUrl(paramString);
    return true;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (!mIsTemplateLoaded)
    {
      mIsTemplateLoaded = true;
      mMarketingContent.markLoaded(mBus);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return (handleLoadContextDispatch(paramWebView, paramString)) || (handleActionDispatch(paramString)) || (super.shouldOverrideUrlLoading(paramWebView, paramString));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.ContentTemplateWebViewClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */