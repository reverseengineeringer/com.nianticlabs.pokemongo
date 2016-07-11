package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.otto.Bus;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.action.ActionContext;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.logger.UpsightLogger;
import rx.Scheduler.Worker;

public class UxmContentActions$UxmContentActionContext
  extends ActionContext
{
  public UxmContentActions$UxmContentActionContext(UpsightContext paramUpsightContext, Bus paramBus, ObjectMapper paramObjectMapper, Clock paramClock, Scheduler.Worker paramWorker, UpsightLogger paramUpsightLogger)
  {
    super(paramUpsightContext, paramBus, paramObjectMapper, paramClock, paramWorker, paramUpsightLogger);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.UxmContentActionContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */