package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import rx.functions.Func1;

class UxmContentActions$ModifyValue$3
  implements Func1<ObjectNode, ObjectNode>
{
  UxmContentActions$ModifyValue$3(UxmContentActions.ModifyValue paramModifyValue, String paramString, JsonNode paramJsonNode) {}
  
  public ObjectNode call(ObjectNode paramObjectNode)
  {
    paramObjectNode.replace(val$propertyName, val$propertyValue);
    return paramObjectNode;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.ModifyValue.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */