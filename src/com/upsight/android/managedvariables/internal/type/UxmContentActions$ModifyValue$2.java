package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import rx.functions.Func1;

class UxmContentActions$ModifyValue$2
  implements Func1<ObjectNode, Boolean>
{
  UxmContentActions$ModifyValue$2(UxmContentActions.ModifyValue paramModifyValue, String paramString, JsonNode paramJsonNode) {}
  
  public Boolean call(ObjectNode paramObjectNode)
  {
    return Boolean.valueOf(paramObjectNode.path(val$propertyName).equals(val$propertyValue));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.ModifyValue.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */