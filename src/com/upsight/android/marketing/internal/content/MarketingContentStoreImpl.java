package com.upsight.android.marketing.internal.content;

import android.text.TextUtils;
import com.squareup.otto.Bus;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.marketing.UpsightMarketingContentStore;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class MarketingContentStoreImpl
  extends UpsightMarketingContentStore
  implements MarketingContentStore
{
  public static final long DEFAULT_TIME_TO_LIVE_MS = 600000L;
  private Bus mBus;
  private Clock mClock;
  private final Map<String, MarketingContent> mContentMap = new HashMap();
  private final Map<String, String> mParentEligibilityMap = new HashMap();
  private final Map<String, Set<String>> mScopeEligibilityMap = new HashMap();
  private final Map<String, Long> mTimestamps = new HashMap();
  
  public MarketingContentStoreImpl(Bus paramBus, Clock paramClock)
  {
    mBus = paramBus;
    mClock = paramClock;
  }
  
  /* Error */
  public MarketingContent get(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	com/upsight/android/marketing/internal/content/MarketingContentStoreImpl:mTimestamps	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 54 2 0
    //   12: checkcast 56	java/lang/Long
    //   15: astore_2
    //   16: aload_2
    //   17: ifnull +42 -> 59
    //   20: aload_0
    //   21: getfield 43	com/upsight/android/marketing/internal/content/MarketingContentStoreImpl:mClock	Lcom/upsight/android/analytics/internal/session/Clock;
    //   24: invokeinterface 62 1 0
    //   29: aload_2
    //   30: invokevirtual 65	java/lang/Long:longValue	()J
    //   33: ldc2_w 9
    //   36: ladd
    //   37: lcmp
    //   38: ifgt +21 -> 59
    //   41: aload_0
    //   42: getfield 35	com/upsight/android/marketing/internal/content/MarketingContentStoreImpl:mContentMap	Ljava/util/Map;
    //   45: aload_1
    //   46: invokeinterface 54 2 0
    //   51: checkcast 67	com/upsight/android/marketing/internal/content/MarketingContent
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: areturn
    //   59: aload_0
    //   60: aload_1
    //   61: invokevirtual 71	com/upsight/android/marketing/internal/content/MarketingContentStoreImpl:remove	(Ljava/lang/String;)Z
    //   64: pop
    //   65: aconst_null
    //   66: astore_1
    //   67: goto -12 -> 55
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	MarketingContentStoreImpl
    //   0	75	1	paramString	String
    //   15	15	2	localLong	Long
    // Exception table:
    //   from	to	target	type
    //   2	16	70	finally
    //   20	55	70	finally
    //   59	65	70	finally
  }
  
  public Set<String> getIdsForScope(String paramString)
  {
    try
    {
      Set localSet = (Set)mScopeEligibilityMap.get(paramString);
      paramString = localSet;
      if (localSet == null) {
        paramString = new HashSet();
      }
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public boolean isContentReady(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 83	com/upsight/android/marketing/internal/content/MarketingContentStoreImpl:getIdsForScope	(Ljava/lang/String;)Ljava/util/Set;
    //   7: invokeinterface 87 1 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifne +9 -> 23
    //   17: iconst_1
    //   18: istore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_2
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_2
    //   25: goto -6 -> 19
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	MarketingContentStoreImpl
    //   0	33	1	paramString	String
    //   12	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
  }
  
  public boolean presentScopedContent(String paramString, String[] paramArrayOfString)
  {
    for (;;)
    {
      MarketingContent localMarketingContent;
      int i;
      try
      {
        localMarketingContent = (MarketingContent)mContentMap.get(paramString);
        if ((localMarketingContent == null) || (paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
          break label147;
        }
        int j = paramArrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str = paramArrayOfString[i];
          Object localObject = (Set)mScopeEligibilityMap.get(str);
          if (localObject != null)
          {
            ((Set)localObject).add(paramString);
          }
          else
          {
            localObject = new HashSet();
            ((Set)localObject).add(paramString);
            mScopeEligibilityMap.put(str, localObject);
          }
        }
      }
      finally {}
      localMarketingContent.markPresentable(new MarketingContent.ScopedAvailabilityEvent(paramString, paramArrayOfString), mBus);
      label147:
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      i += 1;
    }
  }
  
  /* Error */
  public boolean presentScopelessContent(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/upsight/android/marketing/internal/content/MarketingContentStoreImpl:mContentMap	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 54 2 0
    //   12: checkcast 67	com/upsight/android/marketing/internal/content/MarketingContent
    //   15: astore 4
    //   17: aload 4
    //   19: ifnull +46 -> 65
    //   22: aload_2
    //   23: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifne +39 -> 65
    //   29: aload_0
    //   30: getfield 39	com/upsight/android/marketing/internal/content/MarketingContentStoreImpl:mParentEligibilityMap	Ljava/util/Map;
    //   33: aload_2
    //   34: aload_1
    //   35: invokeinterface 97 3 0
    //   40: pop
    //   41: aload 4
    //   43: new 115	com/upsight/android/marketing/internal/content/MarketingContent$ScopelessAvailabilityEvent
    //   46: dup
    //   47: aload_1
    //   48: aload_2
    //   49: invokespecial 118	com/upsight/android/marketing/internal/content/MarketingContent$ScopelessAvailabilityEvent:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 41	com/upsight/android/marketing/internal/content/MarketingContentStoreImpl:mBus	Lcom/squareup/otto/Bus;
    //   56: invokevirtual 106	com/upsight/android/marketing/internal/content/MarketingContent:markPresentable	(Lcom/upsight/android/marketing/internal/content/MarketingContent$AvailabilityEvent;Lcom/squareup/otto/Bus;)V
    //   59: iconst_1
    //   60: istore_3
    //   61: aload_0
    //   62: monitorexit
    //   63: iload_3
    //   64: ireturn
    //   65: iconst_0
    //   66: istore_3
    //   67: goto -6 -> 61
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	MarketingContentStoreImpl
    //   0	75	1	paramString1	String
    //   0	75	2	paramString2	String
    //   60	7	3	bool	boolean
    //   15	27	4	localMarketingContent	MarketingContent
    // Exception table:
    //   from	to	target	type
    //   2	17	70	finally
    //   22	59	70	finally
  }
  
  public boolean put(String paramString, MarketingContent paramMarketingContent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        bool1 = bool2;
        if (paramMarketingContent != null)
        {
          mContentMap.put(paramString, paramMarketingContent);
          mTimestamps.put(paramString, Long.valueOf(mClock.currentTimeMillis()));
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public boolean remove(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    Object localObject;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break label217;
        }
        if (mContentMap.remove(paramString) != null)
        {
          bool1 = true;
          bool2 = bool1;
          if (!bool1) {
            break label217;
          }
          localIterator = mScopeEligibilityMap.keySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (String)localIterator.next();
          localObject = (Set)mScopeEligibilityMap.get(localObject);
          if ((localObject == null) || (!((Set)localObject).contains(paramString))) {
            continue;
          }
          localIterator.remove();
          continue;
        }
        bool1 = false;
      }
      finally {}
    }
    Iterator localIterator = mParentEligibilityMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      String str = (String)mParentEligibilityMap.get(localObject);
      if ((paramString.equals(localObject)) || (paramString.equals(str))) {
        localIterator.remove();
      }
    }
    mTimestamps.remove(paramString);
    bool2 = bool1;
    label217:
    return bool2;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentStoreImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */