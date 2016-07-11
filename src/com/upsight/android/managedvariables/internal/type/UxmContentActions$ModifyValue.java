package com.upsight.android.managedvariables.internal.type;

import android.text.TextUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.analytics.internal.action.ActionContext;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import java.util.Iterator;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

class UxmContentActions$ModifyValue
  extends Action<UxmContent, UxmContentActions.UxmContentActionContext>
{
  private static final String MATCH = "match";
  private static final String OPERATOR = "operator";
  private static final String OPERATOR_SET = "set";
  private static final String PROPERTY_NAME = "property_name";
  private static final String PROPERTY_VALUE = "property_value";
  private static final String TYPE = "type";
  private static final String VALUES = "values";
  
  private UxmContentActions$ModifyValue(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramUxmContentActionContext, paramString, paramJsonNode);
  }
  
  private <T> void modifyValue(final UxmContent paramUxmContent, final Class<T> paramClass, JsonNode paramJsonNode1, JsonNode paramJsonNode2)
  {
    final UxmContentActions.UxmContentActionContext localUxmContentActionContext = (UxmContentActions.UxmContentActionContext)getActionContext();
    final ObjectMapper localObjectMapper = mMapper;
    final UpsightLogger localUpsightLogger = mUpsight.getLogger();
    final UpsightDataStore localUpsightDataStore = mUpsight.getDataStore();
    final Object localObject1 = localUpsightDataStore.fetchObservable(paramClass).map(new Func1()
    {
      public JsonNode call(T paramAnonymousT)
      {
        return localObjectMapper.valueToTree(paramAnonymousT);
      }
    }).cast(ObjectNode.class);
    final Object localObject2 = localObjectMapper.createObjectNode();
    final Object localObject3 = paramJsonNode1.iterator();
    paramJsonNode1 = (JsonNode)localObject1;
    while (((Iterator)localObject3).hasNext())
    {
      final JsonNode localJsonNode = (JsonNode)((Iterator)localObject3).next();
      localObject1 = localJsonNode.path("property_name").asText();
      localJsonNode = localJsonNode.path("property_value");
      paramJsonNode1 = paramJsonNode1.filter(new Func1()
      {
        public Boolean call(ObjectNode paramAnonymousObjectNode)
        {
          return Boolean.valueOf(paramAnonymousObjectNode.path(localObject1).equals(localJsonNode));
        }
      });
      ((ObjectNode)localObject2).replace((String)localObject1, localJsonNode);
    }
    paramJsonNode1 = paramJsonNode1.defaultIfEmpty(localObject2);
    paramJsonNode2 = paramJsonNode2.iterator();
    while (paramJsonNode2.hasNext())
    {
      localObject3 = (JsonNode)paramJsonNode2.next();
      localObject1 = ((JsonNode)localObject3).path("operator").asText();
      localObject2 = ((JsonNode)localObject3).path("property_name").asText();
      localObject3 = ((JsonNode)localObject3).path("property_value");
      if ("set".equals(localObject1)) {
        paramJsonNode1 = paramJsonNode1.map(new Func1()
        {
          public ObjectNode call(ObjectNode paramAnonymousObjectNode)
          {
            paramAnonymousObjectNode.replace(localObject2, localObject3);
            return paramAnonymousObjectNode;
          }
        });
      }
    }
    paramJsonNode1.subscribeOn(mUpsight.getCoreComponent().subscribeOnScheduler()).observeOn(mUpsight.getCoreComponent().observeOnScheduler()).subscribe(new Action1()new Action1
    {
      public void call(final ObjectNode paramAnonymousObjectNode)
      {
        try
        {
          localUpsightDataStore.storeObservable(localObjectMapper.treeToValue(paramAnonymousObjectNode, paramClass)).subscribeOn(localUxmContentActionContextmUpsight.getCoreComponent().subscribeOnScheduler()).observeOn(localUxmContentActionContextmUpsight.getCoreComponent().observeOnScheduler()).subscribe(new Action1()new Action1
          {
            public void call(T paramAnonymous2T)
            {
              val$logger.d("Upsight", "Modified managed variable of class " + val$clazz + " with value " + paramAnonymousObjectNode, new Object[0]);
            }
          }, new Action1()new Action0
          {
            public void call(Throwable paramAnonymous2Throwable)
            {
              val$logger.e("Upsight", paramAnonymous2Throwable, "Failed to modify managed variable of class " + val$clazz, new Object[0]);
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
        catch (JsonProcessingException paramAnonymousObjectNode)
        {
          localUpsightLogger.e("Upsight", paramAnonymousObjectNode, "Failed to parse managed variable of class " + paramClass, new Object[0]);
          paramUxmContent.signalActionCompleted(localUxmContentActionContextmBus);
        }
      }
    }, new Action1()
    {
      public void call(Throwable paramAnonymousThrowable)
      {
        localUpsightLogger.e("Upsight", paramAnonymousThrowable, "Failed to fetch managed variable of class " + paramClass, new Object[0]);
        paramUxmContent.signalActionCompleted(localUxmContentActionContextmBus);
      }
    });
  }
  
  public void execute(UxmContent paramUxmContent)
  {
    int j = 1;
    ActionContext localActionContext = getActionContext();
    int i = j;
    String str;
    Class localClass;
    if (paramUxmContent.shouldApplyBundle())
    {
      str = optParamString("type");
      ArrayNode localArrayNode1 = optParamJsonArray("match");
      ArrayNode localArrayNode2 = optParamJsonArray("values");
      i = j;
      if (!TextUtils.isEmpty(str))
      {
        i = j;
        if (localArrayNode1 != null)
        {
          i = j;
          if (localArrayNode2 != null)
          {
            localClass = null;
            if (!"com.upsight.uxm.string".equals(str)) {
              break label114;
            }
            localClass = ManagedString.Model.class;
            if (localClass == null) {
              break label165;
            }
            modifyValue(paramUxmContent, localClass, localArrayNode1, localArrayNode2);
          }
        }
      }
    }
    for (i = 0;; i = j)
    {
      if (i != 0) {
        paramUxmContent.signalActionCompleted(mBus);
      }
      return;
      label114:
      if ("com.upsight.uxm.boolean".equals(str))
      {
        localClass = ManagedBoolean.Model.class;
        break;
      }
      if ("com.upsight.uxm.integer".equals(str))
      {
        localClass = ManagedInt.Model.class;
        break;
      }
      if (!"com.upsight.uxm.float".equals(str)) {
        break;
      }
      localClass = ManagedFloat.Model.class;
      break;
      label165:
      mLogger.e("Upsight", "Failed to execute action_modify_value due to unknown managed variable type " + str, new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.ModifyValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */