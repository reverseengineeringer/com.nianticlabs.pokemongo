package com.upsight.android.marketing.internal.billboard;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.upsight.android.analytics.internal.session.ApplicationStatus;
import com.upsight.android.analytics.internal.session.ApplicationStatus.State;
import com.upsight.android.marketing.UpsightBillboard.Dimensions;
import com.upsight.android.marketing.UpsightBillboard.Dimensions.LayoutOrientation;
import com.upsight.android.marketing.UpsightBillboard.Handler;
import com.upsight.android.marketing.UpsightBillboard.PresentationStyle;
import com.upsight.android.marketing.UpsightBillboardManager;
import com.upsight.android.marketing.UpsightContentMediator;
import com.upsight.android.marketing.internal.content.MarketingContent;
import com.upsight.android.marketing.internal.content.MarketingContent.ScopedAvailabilityEvent;
import com.upsight.android.marketing.internal.content.MarketingContent.ScopelessAvailabilityEvent;
import com.upsight.android.marketing.internal.content.MarketingContentActions.DestroyEvent;
import com.upsight.android.marketing.internal.content.MarketingContentActions.PurchasesEvent;
import com.upsight.android.marketing.internal.content.MarketingContentActions.RewardsEvent;
import com.upsight.android.marketing.internal.content.MarketingContentModel;
import com.upsight.android.marketing.internal.content.MarketingContentModel.Presentation.DialogLayout;
import com.upsight.android.marketing.internal.content.MarketingContentModel.Presentation.DialogLayout.Dimensions;
import com.upsight.android.marketing.internal.content.MarketingContentStore;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.annotation.Created;
import com.upsight.android.persistence.annotation.Updated;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class BillboardManagerImpl
  implements UpsightBillboardManager
{
  private final MarketingContentStore mContentStore;
  private final Map<String, Billboard> mFilledBillboards = new HashMap();
  private final Map<String, UpsightContentMediator> mMediators = new HashMap();
  private final Map<String, Billboard> mUnfilledBillboards = new HashMap();
  
  BillboardManagerImpl(UpsightDataStore paramUpsightDataStore, MarketingContentStore paramMarketingContentStore, Bus paramBus)
  {
    mContentStore = paramMarketingContentStore;
    paramBus.register(this);
    paramUpsightDataStore.subscribe(this);
  }
  
  private void detachBillboard(String paramString)
  {
    try
    {
      Billboard localBillboard = (Billboard)mFilledBillboards.get(paramString);
      if (localBillboard != null)
      {
        localBillboard.getHandler().onDetach();
        mFilledBillboards.remove(paramString);
      }
      return;
    }
    finally {}
  }
  
  private Set<UpsightBillboard.Dimensions> getDimensions(MarketingContent paramMarketingContent)
  {
    HashSet localHashSet = new HashSet();
    paramMarketingContent = paramMarketingContent.getContentModel().getDialogLayouts();
    if ((paramMarketingContent != null) && (portrait != null) && (portrait.w > 0) && (portrait.h > 0)) {
      localHashSet.add(new UpsightBillboard.Dimensions(UpsightBillboard.Dimensions.LayoutOrientation.Portrait, portrait.w, portrait.h));
    }
    if ((paramMarketingContent != null) && (landscape != null) && (landscape.w > 0) && (landscape.h > 0)) {
      localHashSet.add(new UpsightBillboard.Dimensions(UpsightBillboard.Dimensions.LayoutOrientation.Landscape, landscape.w, landscape.h));
    }
    return localHashSet;
  }
  
  private UpsightBillboard.PresentationStyle getPresentationStyle(MarketingContent paramMarketingContent)
  {
    paramMarketingContent = paramMarketingContent.getContentModel().getPresentationStyle();
    if ("dialog".equals(paramMarketingContent)) {
      return UpsightBillboard.PresentationStyle.Dialog;
    }
    if ("fullscreen".equals(paramMarketingContent)) {
      return UpsightBillboard.PresentationStyle.Fullscreen;
    }
    return UpsightBillboard.PresentationStyle.None;
  }
  
  private boolean tryAttachBillboard(String paramString, Billboard paramBillboard)
  {
    boolean bool2 = false;
    MarketingContent localMarketingContent = (MarketingContent)mContentStore.get(paramString);
    boolean bool1 = bool2;
    if (paramBillboard != null)
    {
      bool1 = bool2;
      if (paramBillboard.getMarketingContent() == null)
      {
        bool1 = bool2;
        if (localMarketingContent != null)
        {
          bool1 = bool2;
          if (localMarketingContent.isAvailable())
          {
            UpsightContentMediator localUpsightContentMediator = (UpsightContentMediator)mMediators.get(localMarketingContent.getContentProvider());
            bool1 = bool2;
            if (localUpsightContentMediator != null)
            {
              bool1 = bool2;
              if (localUpsightContentMediator.isAvailable())
              {
                ViewGroup localViewGroup = paramBillboard.getHandler().onAttach(paramBillboard.getScope(), getPresentationStyle(localMarketingContent), getDimensions(localMarketingContent));
                bool1 = bool2;
                if (localViewGroup != null)
                {
                  localMarketingContent.markConsumed();
                  localUpsightContentMediator.displayContent(localMarketingContent, localViewGroup);
                  paramBillboard.setMarketingContent(localMarketingContent);
                  mUnfilledBillboards.remove(paramBillboard.getScope());
                  mFilledBillboards.put(paramString, paramBillboard);
                  localMarketingContent.executeActions("content_displayed");
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  @Subscribe
  public void handleActionEvent(MarketingContentActions.DestroyEvent paramDestroyEvent)
  {
    try
    {
      detachBillboard(mId);
      return;
    }
    finally
    {
      paramDestroyEvent = finally;
      throw paramDestroyEvent;
    }
  }
  
  @Subscribe
  public void handleActionEvent(MarketingContentActions.PurchasesEvent paramPurchasesEvent)
  {
    try
    {
      Billboard localBillboard = (Billboard)mFilledBillboards.get(mId);
      if (localBillboard != null) {
        localBillboard.getHandler().onPurchases(mPurchases);
      }
      return;
    }
    finally {}
  }
  
  @Subscribe
  public void handleActionEvent(MarketingContentActions.RewardsEvent paramRewardsEvent)
  {
    try
    {
      Billboard localBillboard = (Billboard)mFilledBillboards.get(mId);
      if (localBillboard != null) {
        localBillboard.getHandler().onRewards(mRewards);
      }
      return;
    }
    finally {}
  }
  
  @Subscribe
  public void handleAvailabilityEvent(MarketingContent.ScopedAvailabilityEvent paramScopedAvailabilityEvent)
  {
    try
    {
      Iterator localIterator = paramScopedAvailabilityEvent.getScopes().iterator();
      boolean bool;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        String str = (String)localIterator.next();
        bool = tryAttachBillboard(paramScopedAvailabilityEvent.getId(), (Billboard)mUnfilledBillboards.get(str));
      } while (!bool);
      return;
    }
    finally {}
  }
  
  @Subscribe
  public void handleAvailabilityEvent(MarketingContent.ScopelessAvailabilityEvent paramScopelessAvailabilityEvent)
  {
    try
    {
      if (!TextUtils.isEmpty(paramScopelessAvailabilityEvent.getParentId()))
      {
        Billboard localBillboard = (Billboard)mFilledBillboards.get(paramScopelessAvailabilityEvent.getParentId());
        if (localBillboard != null)
        {
          MarketingContent localMarketingContent1 = localBillboard.getMarketingContent();
          MarketingContent localMarketingContent2 = (MarketingContent)mContentStore.get(paramScopelessAvailabilityEvent.getId());
          if ((localMarketingContent1 != null) && (localMarketingContent2 != null) && (localMarketingContent2.isAvailable()))
          {
            UpsightContentMediator localUpsightContentMediator1 = (UpsightContentMediator)mMediators.get(localMarketingContent1.getContentProvider());
            UpsightContentMediator localUpsightContentMediator2 = (UpsightContentMediator)mMediators.get(localMarketingContent2.getContentProvider());
            if ((localUpsightContentMediator1 != null) && (localUpsightContentMediator1.isAvailable()) && (localUpsightContentMediator2 != null) && (localUpsightContentMediator2.isAvailable()))
            {
              localMarketingContent2.markConsumed();
              localBillboard.getHandler().onNextView();
              ViewGroup localViewGroup = (ViewGroup)localBillboard.getMarketingContent().getContentView().getParent();
              localUpsightContentMediator1.hideContent(localMarketingContent1, localViewGroup);
              localUpsightContentMediator2.displayContent(localMarketingContent2, localViewGroup);
              localBillboard.setMarketingContent(localMarketingContent2);
              mFilledBillboards.remove(paramScopelessAvailabilityEvent.getParentId());
              mFilledBillboards.put(paramScopelessAvailabilityEvent.getId(), localBillboard);
              localMarketingContent2.executeActions("content_displayed");
            }
          }
        }
      }
      return;
    }
    finally {}
  }
  
  @Created
  @Updated
  public void onApplicationStatus(ApplicationStatus paramApplicationStatus)
  {
    if (paramApplicationStatus.getState() == ApplicationStatus.State.BACKGROUND)
    {
      paramApplicationStatus = mFilledBillboards.keySet().iterator();
      while (paramApplicationStatus.hasNext())
      {
        Object localObject = (String)paramApplicationStatus.next();
        localObject = (MarketingContent)mContentStore.get((String)localObject);
        if (localObject != null) {
          ((MarketingContent)localObject).executeActions("app_backgrounded");
        }
      }
    }
  }
  
  public boolean registerBillboard(Billboard paramBillboard)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBillboard != null) {}
    try
    {
      Object localObject = paramBillboard.getScope();
      bool1 = bool2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        bool1 = bool2;
        if (paramBillboard.getHandler() != null)
        {
          bool1 = bool2;
          if (mUnfilledBillboards.get(localObject) == null)
          {
            bool2 = true;
            mUnfilledBillboards.put(localObject, paramBillboard);
            localObject = mContentStore.getIdsForScope((String)localObject).iterator();
            do
            {
              bool1 = bool2;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              bool1 = tryAttachBillboard((String)((Iterator)localObject).next(), paramBillboard);
            } while (!bool1);
            bool1 = bool2;
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public boolean registerContentMediator(UpsightContentMediator paramUpsightContentMediator)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramUpsightContentMediator != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramUpsightContentMediator.getContentProvider()))
      {
        if (mMediators.put(paramUpsightContentMediator.getContentProvider(), paramUpsightContentMediator) != paramUpsightContentMediator) {
          break label46;
        }
        bool1 = true;
      }
    }
    return bool1;
    label46:
    return false;
  }
  
  /* Error */
  public boolean unregisterBillboard(Billboard paramBillboard)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 172	com/upsight/android/marketing/internal/billboard/Billboard:getScope	()Ljava/lang/String;
    //   6: astore_1
    //   7: aload_0
    //   8: getfield 24	com/upsight/android/marketing/internal/billboard/BillboardManagerImpl:mUnfilledBillboards	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 65 2 0
    //   17: astore_1
    //   18: aload_1
    //   19: ifnull +9 -> 28
    //   22: iconst_1
    //   23: istore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_2
    //   30: goto -6 -> 24
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	BillboardManagerImpl
    //   0	38	1	paramBillboard	Billboard
    //   23	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	33	finally
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.billboard.BillboardManagerImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */