package com.upsight.android.analytics.internal.association;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.annotation.Created;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import rx.Observable;
import rx.functions.Action1;

class AssociationManagerImpl
  implements AssociationManager
{
  static final long ASSOCIATION_EXPIRY = 604800000L;
  private static final String KEY_UPSIGHT_DATA = "upsight_data";
  private final Map<String, Set<Association>> mAssociations;
  private final Clock mClock;
  private final UpsightDataStore mDataStore;
  private boolean mIsLaunched = false;
  
  AssociationManagerImpl(UpsightDataStore paramUpsightDataStore, Clock paramClock)
  {
    mDataStore = paramUpsightDataStore;
    mClock = paramClock;
    mAssociations = new HashMap();
  }
  
  /* Error */
  void addAssociation(String paramString, Association paramAssociation)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne +7 -> 15
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 41	com/upsight/android/analytics/internal/association/AssociationManagerImpl:mAssociations	Ljava/util/Map;
    //   22: aload_1
    //   23: invokeinterface 56 2 0
    //   28: checkcast 58	java/util/Set
    //   31: astore 5
    //   33: aload 5
    //   35: astore 4
    //   37: aload 5
    //   39: ifnonnull +12 -> 51
    //   42: new 60	java/util/HashSet
    //   45: dup
    //   46: invokespecial 61	java/util/HashSet:<init>	()V
    //   49: astore 4
    //   51: aload 4
    //   53: aload_2
    //   54: invokeinterface 65 2 0
    //   59: pop
    //   60: aload_0
    //   61: getfield 41	com/upsight/android/analytics/internal/association/AssociationManagerImpl:mAssociations	Ljava/util/Map;
    //   64: aload_1
    //   65: aload 4
    //   67: invokeinterface 69 3 0
    //   72: pop
    //   73: goto -58 -> 15
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	AssociationManagerImpl
    //   0	81	1	paramString	String
    //   0	81	2	paramAssociation	Association
    //   6	2	3	bool	boolean
    //   35	31	4	localObject	Object
    //   31	7	5	localSet	Set
    // Exception table:
    //   from	to	target	type
    //   2	7	76	finally
    //   18	33	76	finally
    //   42	51	76	finally
    //   51	73	76	finally
  }
  
  public void associate(String paramString, ObjectNode paramObjectNode)
  {
    try
    {
      associateInner(paramString, paramObjectNode);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  void associateInner(String paramString, ObjectNode paramObjectNode)
  {
    int i;
    for (;;)
    {
      Association localAssociation;
      try
      {
        paramString = (Set)mAssociations.get(paramString);
        if (paramString == null) {
          break label303;
        }
        i = 0;
        paramString = paramString.iterator();
        if (!paramString.hasNext()) {
          break label303;
        }
        localAssociation = (Association)paramString.next();
        if (mClock.currentTimeMillis() - localAssociation.getTimestampMs() > 604800000L)
        {
          paramString.remove();
          mDataStore.removeObservable(Association.class, new String[] { localAssociation.getId() }).subscribe();
          continue;
        }
        if (i != 0) {
          continue;
        }
      }
      finally {}
      Object localObject2 = localAssociation.getUpsightDataFilter();
      Object localObject1 = paramObjectNode.path("upsight_data");
      if (((JsonNode)localObject1).isObject())
      {
        localObject1 = (ObjectNode)localObject1;
        Object localObject3 = ((ObjectNode)localObject1).path(matchKey);
        if (((JsonNode)localObject3).isValueNode())
        {
          localObject2 = matchValues.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            if (!((JsonNode)localObject3).equals((JsonNode)((Iterator)localObject2).next())) {
              break;
            }
            localObject2 = localAssociation.getUpsightData().fields();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject2).next();
              ((ObjectNode)localObject1).put((String)((Map.Entry)localObject3).getKey(), (JsonNode)((Map.Entry)localObject3).getValue());
            }
            paramString.remove();
            mDataStore.removeObservable(Association.class, new String[] { localAssociation.getId() }).subscribe();
            i = 1;
          }
        }
      }
    }
    label303:
  }
  
  @Created
  public void handleCreate(Association paramAssociation)
  {
    addAssociation(paramAssociation.getWith(), paramAssociation);
  }
  
  public void launch()
  {
    try
    {
      if (!mIsLaunched)
      {
        mIsLaunched = true;
        launchInner();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void launchInner()
  {
    try
    {
      mDataStore.subscribe(this);
      mDataStore.fetchObservable(Association.class).subscribe(new Action1()
      {
        public void call(Association paramAnonymousAssociation)
        {
          addAssociation(paramAnonymousAssociation.getWith(), paramAnonymousAssociation);
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.association.AssociationManagerImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */