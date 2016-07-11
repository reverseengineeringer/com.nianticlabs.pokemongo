package com.upsight.android.managedvariables.internal.type;

import android.text.TextUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.analytics.internal.action.ActionMap;
import com.upsight.android.analytics.internal.action.ActionMapResponse;
import com.upsight.android.managedvariables.experience.UpsightUserExperience;
import com.upsight.android.managedvariables.experience.UpsightUserExperience.Handler;
import java.util.Iterator;

public final class UxmContentFactory
{
  private static final String ACTION_MODIFY_VALUE = "action_modify_value";
  private static final String ACTION_SET_BUNDLE_ID = "action_set_bundle_id";
  private static final String KEY_ACTIONS = "actions";
  private static final String KEY_ACTION_TYPE = "action_type";
  private static final UxmContentActions.UxmContentActionFactory sUxmContentActionFactory = new UxmContentActions.UxmContentActionFactory();
  private UxmContentActions.UxmContentActionContext mActionContext;
  private UpsightUserExperience mUserExperience;
  
  public UxmContentFactory(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, UpsightUserExperience paramUpsightUserExperience)
  {
    mActionContext = paramUxmContentActionContext;
    mUserExperience = paramUpsightUserExperience;
  }
  
  public UxmContent create(ActionMapResponse paramActionMapResponse)
  {
    Object localObject2 = null;
    String str = paramActionMapResponse.getActionMapId();
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = localObject2;
      if ("datastore_factory".equals(paramActionMapResponse.getActionFactory()))
      {
        boolean bool3 = false;
        boolean bool2 = false;
        paramActionMapResponse = paramActionMapResponse.getActionMap();
        boolean bool1 = bool3;
        if (paramActionMapResponse != null)
        {
          bool1 = bool3;
          if (paramActionMapResponse.isArray())
          {
            localObject1 = paramActionMapResponse.iterator();
            do
            {
              bool1 = bool2;
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = ((JsonNode)((Iterator)localObject1).next()).findPath("actions");
              bool1 = bool2;
              if (localObject2 != null)
              {
                bool1 = bool2;
                if (((JsonNode)localObject2).isArray())
                {
                  localObject2 = ((JsonNode)localObject2).iterator();
                  JsonNode localJsonNode;
                  do
                  {
                    bool1 = bool2;
                    if (!((Iterator)localObject2).hasNext()) {
                      break;
                    }
                    localJsonNode = ((JsonNode)((Iterator)localObject2).next()).findPath("action_type");
                  } while ((!"action_set_bundle_id".equals(localJsonNode.asText())) && (!"action_modify_value".equals(localJsonNode.asText())));
                  bool1 = mUserExperience.getHandler().onReceive();
                }
              }
              bool2 = bool1;
            } while (!bool1);
          }
        }
        localObject1 = UxmContent.create(str, new ActionMap(sUxmContentActionFactory, mActionContext, paramActionMapResponse), bool1);
      }
    }
    return (UxmContent)localObject1;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */