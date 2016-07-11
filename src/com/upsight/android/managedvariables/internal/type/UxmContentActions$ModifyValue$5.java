package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.logger.UpsightLogger;
import rx.functions.Action1;

class UxmContentActions$ModifyValue$5
  implements Action1<Throwable>
{
  UxmContentActions$ModifyValue$5(UxmContentActions.ModifyValue paramModifyValue, UpsightLogger paramUpsightLogger, Class paramClass, UxmContent paramUxmContent, UxmContentActions.UxmContentActionContext paramUxmContentActionContext) {}
  
  public void call(Throwable paramThrowable)
  {
    val$logger.e("Upsight", paramThrowable, "Failed to fetch managed variable of class " + val$clazz, new Object[0]);
    val$content.signalActionCompleted(val$actionContext.mBus);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.ModifyValue.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */