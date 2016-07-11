package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.logger.UpsightLogger;
import rx.functions.Action1;

class UxmContentActions$ModifyValue$4$2
  implements Action1<Throwable>
{
  UxmContentActions$ModifyValue$4$2(UxmContentActions.ModifyValue.4 param4) {}
  
  public void call(Throwable paramThrowable)
  {
    this$1.val$logger.e("Upsight", paramThrowable, "Failed to modify managed variable of class " + this$1.val$clazz, new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.ModifyValue.4.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */