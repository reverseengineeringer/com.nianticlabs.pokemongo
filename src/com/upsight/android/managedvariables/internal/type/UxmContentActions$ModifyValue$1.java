package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import rx.functions.Func1;

class UxmContentActions$ModifyValue$1
  implements Func1<T, JsonNode>
{
  UxmContentActions$ModifyValue$1(UxmContentActions.ModifyValue paramModifyValue, ObjectMapper paramObjectMapper) {}
  
  public JsonNode call(T paramT)
  {
    return val$mapper.valueToTree(paramT);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.ModifyValue.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */