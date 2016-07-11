package com.upsight.android.marketing.internal.content;

import android.view.View;
import com.squareup.otto.Bus;
import com.upsight.android.analytics.internal.action.ActionMap;
import com.upsight.android.analytics.internal.action.Actionable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketingContent
  extends Actionable
{
  public static final String TRIGGER_APP_BACKGROUNDED = "app_backgrounded";
  public static final String TRIGGER_CONTENT_DISMISSED = "content_dismissed";
  public static final String TRIGGER_CONTENT_DISPLAYED = "content_displayed";
  public static final String TRIGGER_CONTENT_RECEIVED = "content_received";
  public static final String UPSIGHT_CONTENT_PROVIDER = "upsight";
  private AvailabilityEvent mAvailabilityEvent;
  private MarketingContentModel mContentModel = null;
  private View mContentView = null;
  private Map<String, String> mExtras = new HashMap();
  private boolean mIsConsumed = false;
  private boolean mIsLoaded = false;
  
  private MarketingContent(String paramString, ActionMap<MarketingContent, MarketingContentActions.MarketingContentActionContext> paramActionMap)
  {
    super(paramString, paramActionMap);
  }
  
  public static MarketingContent create(String paramString, ActionMap<MarketingContent, MarketingContentActions.MarketingContentActionContext> paramActionMap)
  {
    return new MarketingContent(paramString, paramActionMap);
  }
  
  private void notifyAvailability(Bus paramBus)
  {
    if (isAvailable()) {
      paramBus.post(mAvailabilityEvent);
    }
  }
  
  public MarketingContentModel getContentModel()
  {
    return mContentModel;
  }
  
  public String getContentProvider()
  {
    return "upsight";
  }
  
  public View getContentView()
  {
    return mContentView;
  }
  
  public String getExtra(String paramString)
  {
    return (String)mExtras.get(paramString);
  }
  
  public boolean isAvailable()
  {
    return (isLoaded()) && (mAvailabilityEvent != null) && (!mIsConsumed);
  }
  
  boolean isLoaded()
  {
    return (mContentModel != null) && (mContentView != null) && (mIsLoaded);
  }
  
  public void markConsumed()
  {
    mIsConsumed = true;
  }
  
  public void markLoaded(Bus paramBus)
  {
    mIsLoaded = true;
    paramBus.post(new ContentLoadedEvent(getId(), null));
    notifyAvailability(paramBus);
  }
  
  public void markPresentable(AvailabilityEvent paramAvailabilityEvent, Bus paramBus)
  {
    mAvailabilityEvent = paramAvailabilityEvent;
    notifyAvailability(paramBus);
  }
  
  public void putExtra(String paramString1, String paramString2)
  {
    mExtras.put(paramString1, paramString2);
  }
  
  public void setContentModel(MarketingContentModel paramMarketingContentModel)
  {
    mContentModel = paramMarketingContentModel;
  }
  
  public void setContentView(View paramView)
  {
    mContentView = paramView;
  }
  
  public static abstract class AvailabilityEvent
  {
    private final String mId;
    
    private AvailabilityEvent(String paramString)
    {
      mId = paramString;
    }
    
    public String getId()
    {
      return mId;
    }
  }
  
  public static class ContentLoadedEvent
  {
    private final String mId;
    
    private ContentLoadedEvent(String paramString)
    {
      mId = paramString;
    }
    
    public String getId()
    {
      return mId;
    }
  }
  
  public static class ScopedAvailabilityEvent
    extends MarketingContent.AvailabilityEvent
  {
    private final String[] mScopes;
    
    public ScopedAvailabilityEvent(String paramString, String[] paramArrayOfString)
    {
      super(null);
      mScopes = paramArrayOfString;
    }
    
    public List<String> getScopes()
    {
      return Arrays.asList(mScopes);
    }
  }
  
  public static class ScopelessAvailabilityEvent
    extends MarketingContent.AvailabilityEvent
  {
    private final String mParentId;
    
    public ScopelessAvailabilityEvent(String paramString1, String paramString2)
    {
      super(null);
      mParentId = paramString2;
    }
    
    public String getParentId()
    {
      return mParentId;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */