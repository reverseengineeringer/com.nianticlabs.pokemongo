package com.upsight.android.managedvariables.internal.type;

import android.text.TextUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.squareup.otto.Bus;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import com.upsight.android.UpsightException;
import com.upsight.android.UpsightExtension;
import com.upsight.android.analytics.event.uxm.UpsightUxmEnumerateEvent;
import com.upsight.android.analytics.event.uxm.UpsightUxmEnumerateEvent.Builder;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.analytics.internal.action.ActionContext;
import com.upsight.android.analytics.internal.action.ActionFactory;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.internal.util.PreferencesHelper;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.managedvariables.UpsightManagedVariablesComponent;
import com.upsight.android.persistence.UpsightDataStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import rx.Observable;
import rx.Scheduler.Worker;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

public final class UxmContentActions
{
  private static final Map<String, InternalFactory> FACTORY_MAP = new HashMap() {};
  
  static class Destroy
    extends Action<UxmContent, UxmContentActions.UxmContentActionContext>
  {
    private Destroy(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
    }
    
    public void execute(UxmContent paramUxmContent)
    {
      Bus localBus = getActionContextmBus;
      paramUxmContent.signalActionCompleted(localBus);
      paramUxmContent.signalActionMapCompleted(localBus);
    }
  }
  
  private static abstract interface InternalFactory
  {
    public abstract Action<UxmContent, UxmContentActions.UxmContentActionContext> create(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, String paramString, JsonNode paramJsonNode);
  }
  
  static class ModifyValue
    extends Action<UxmContent, UxmContentActions.UxmContentActionContext>
  {
    private static final String MATCH = "match";
    private static final String OPERATOR = "operator";
    private static final String OPERATOR_SET = "set";
    private static final String PROPERTY_NAME = "property_name";
    private static final String PROPERTY_VALUE = "property_value";
    private static final String TYPE = "type";
    private static final String VALUES = "values";
    
    private ModifyValue(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
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
  
  static class NotifyUxmValuesSynchronized
    extends Action<UxmContent, UxmContentActions.UxmContentActionContext>
  {
    private static final String TAGS = "tags";
    
    private NotifyUxmValuesSynchronized(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
    }
    
    public void execute(UxmContent paramUxmContent)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = optParamJsonArray("tags");
      if ((paramUxmContent.shouldApplyBundle()) && (localObject != null))
      {
        localObject = ((ArrayNode)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          JsonNode localJsonNode = (JsonNode)((Iterator)localObject).next();
          if (localJsonNode.isTextual()) {
            localArrayList.add(localJsonNode.asText());
          }
        }
      }
      localObject = getActionContextmBus;
      ((Bus)localObject).post(new UxmContentActions.ScheduleSyncNotificationEvent(paramUxmContent.getId(), localArrayList, null));
      paramUxmContent.signalActionCompleted((Bus)localObject);
    }
  }
  
  public static class ScheduleSyncNotificationEvent
  {
    public final String mId;
    public final List<String> mTags;
    
    private ScheduleSyncNotificationEvent(String paramString, List<String> paramList)
    {
      mId = paramString;
      mTags = paramList;
    }
  }
  
  static class SetBundleId
    extends Action<UxmContent, UxmContentActions.UxmContentActionContext>
  {
    private static final String BUNDLE_ID = "bundle.id";
    
    private SetBundleId(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
    }
    
    public void execute(UxmContent paramUxmContent)
    {
      if (paramUxmContent.shouldApplyBundle()) {
        PreferencesHelper.putString(getActionContextmUpsight, "uxmBundleId", optParamString("bundle.id"));
      }
      paramUxmContent.signalActionCompleted(getActionContextmBus);
    }
  }
  
  public static class UxmContentActionContext
    extends ActionContext
  {
    public UxmContentActionContext(UpsightContext paramUpsightContext, Bus paramBus, ObjectMapper paramObjectMapper, Clock paramClock, Scheduler.Worker paramWorker, UpsightLogger paramUpsightLogger)
    {
      super(paramBus, paramObjectMapper, paramClock, paramWorker, paramUpsightLogger);
    }
  }
  
  public static class UxmContentActionFactory
    implements ActionFactory<UxmContent, UxmContentActions.UxmContentActionContext>
  {
    public static final String TYPE = "datastore_factory";
    
    public Action<UxmContent, UxmContentActions.UxmContentActionContext> create(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, JsonNode paramJsonNode)
      throws UpsightException
    {
      if (paramJsonNode == null) {
        throw new UpsightException("Failed to create Action. JSON is null.", new Object[0]);
      }
      String str = paramJsonNode.get("action_type").asText();
      paramJsonNode = paramJsonNode.get("parameters");
      UxmContentActions.InternalFactory localInternalFactory = (UxmContentActions.InternalFactory)UxmContentActions.FACTORY_MAP.get(str);
      if (localInternalFactory == null) {
        throw new UpsightException("Failed to create Action. Unknown action type.", new Object[0]);
      }
      return localInternalFactory.create(paramUxmContentActionContext, str, paramJsonNode);
    }
  }
  
  static class UxmEnumerate
    extends Action<UxmContent, UxmContentActions.UxmContentActionContext>
  {
    private UxmEnumerate(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
    }
    
    public void execute(UxmContent paramUxmContent)
    {
      ActionContext localActionContext = getActionContext();
      String str = mUpsight.getUpsightExtension("com.upsight.extension.managedvariables").getComponent()).uxmSchema().mSchemaJsonString;
      try
      {
        UpsightUxmEnumerateEvent.createBuilder(new JSONArray(str)).record(mUpsight);
        paramUxmContent.signalActionCompleted(mBus);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          mUpsight.getLogger().e("Upsight", localJSONException, "Failed to send UXM enumerate event", new Object[0]);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */