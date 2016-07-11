package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.logger.UpsightLogger;
import rx.functions.Action1;

class UxmContentActions$ModifyValue$4$1
  implements Action1<T>
{
  UxmContentActions$ModifyValue$4$1(UxmContentActions.ModifyValue.4 param4, ObjectNode paramObjectNode) {}
  
  public void call(T paramT)
  {
    this$1.val$logger.d("Upsight", "Modified managed variable of class " + this$1.val$clazz + " with value " + val$modelNode, new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.ModifyValue.4.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */