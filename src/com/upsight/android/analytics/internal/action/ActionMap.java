package com.upsight.android.analytics.internal.action;

import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.UpsightException;
import com.upsight.android.logger.UpsightLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ActionMap<T extends Actionable, U extends ActionContext>
  extends HashMap<String, List<Action<T, U>>>
{
  private static final String ACTIONS = "actions";
  private static final String TAG = ActionMap.class.getSimpleName();
  private static final String TRIGGER = "trigger";
  private int mActiveActionCount = 0;
  private boolean mIsActionMapCompleted = false;
  
  public ActionMap(ActionFactory<T, U> paramActionFactory, U paramU, JsonNode paramJsonNode)
  {
    if ((paramJsonNode != null) && (paramJsonNode.isArray()))
    {
      Iterator localIterator = paramJsonNode.elements();
      while (localIterator.hasNext())
      {
        paramJsonNode = (JsonNode)localIterator.next();
        JsonNode localJsonNode2 = paramJsonNode.get("trigger");
        JsonNode localJsonNode3 = paramJsonNode.get("actions");
        if ((localJsonNode2 != null) && (localJsonNode2.isTextual()) && (localJsonNode3 != null) && (localJsonNode3.isArray()))
        {
          int j = localJsonNode3.size();
          if (j > 0)
          {
            ArrayList localArrayList = new ArrayList(j);
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label209;
              }
              paramJsonNode = null;
              try
              {
                JsonNode localJsonNode1 = localJsonNode3.get(i);
                paramJsonNode = localJsonNode1;
                localArrayList.add(paramActionFactory.create(paramU, localJsonNode1));
              }
              catch (UpsightException localUpsightException)
              {
                for (;;)
                {
                  mLogger.e(TAG, localUpsightException, "Unable to create action from actionJSON=" + paramJsonNode, new Object[0]);
                }
              }
              i += 1;
            }
            label209:
            if (localArrayList.size() > 0) {
              put(localJsonNode2.asText(), localArrayList);
            }
          }
        }
      }
    }
  }
  
  private boolean isFinished()
  {
    return (mIsActionMapCompleted) && (mActiveActionCount == 0);
  }
  
  public void executeActions(String paramString, T paramT)
  {
    try
    {
      paramString = (List)get(paramString);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          Action localAction = (Action)paramString.next();
          mActiveActionCount += 1;
          localAction.execute(paramT);
        }
      }
    }
    finally {}
  }
  
  public boolean signalActionCompleted()
  {
    try
    {
      mActiveActionCount -= 1;
      boolean bool = isFinished();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean signalActionMapCompleted()
  {
    try
    {
      mIsActionMapCompleted = true;
      boolean bool = isFinished();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.action.ActionMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */