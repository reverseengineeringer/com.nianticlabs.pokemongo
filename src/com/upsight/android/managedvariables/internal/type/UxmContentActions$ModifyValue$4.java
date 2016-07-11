package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

class UxmContentActions$ModifyValue$4
  implements Action1<ObjectNode>
{
  UxmContentActions$ModifyValue$4(UxmContentActions.ModifyValue paramModifyValue, UpsightDataStore paramUpsightDataStore, ObjectMapper paramObjectMapper, Class paramClass, UxmContentActions.UxmContentActionContext paramUxmContentActionContext, UpsightLogger paramUpsightLogger, UxmContent paramUxmContent) {}
  
  public void call(final ObjectNode paramObjectNode)
  {
    try
    {
      val$dataStore.storeObservable(val$mapper.treeToValue(paramObjectNode, val$clazz)).subscribeOn(val$actionContext.mUpsight.getCoreComponent().subscribeOnScheduler()).observeOn(val$actionContext.mUpsight.getCoreComponent().observeOnScheduler()).subscribe(new Action1()new Action1
      {
        public void call(T paramAnonymousT)
        {
          val$logger.d("Upsight", "Modified managed variable of class " + val$clazz + " with value " + paramObjectNode, new Object[0]);
        }
      }, new Action1()new Action0
      {
        public void call(Throwable paramAnonymousThrowable)
        {
          val$logger.e("Upsight", paramAnonymousThrowable, "Failed to modify managed variable of class " + val$clazz, new Object[0]);
        }
      }, new Action0()
      {
        public void call()
        {
          val$content.signalActionCompleted(val$actionContext.mBus);
        }
      });
      return;
    }
    catch (JsonProcessingException paramObjectNode)
    {
      val$logger.e("Upsight", paramObjectNode, "Failed to parse managed variable of class " + val$clazz, new Object[0]);
      val$content.signalActionCompleted(val$actionContext.mBus);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.ModifyValue.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */