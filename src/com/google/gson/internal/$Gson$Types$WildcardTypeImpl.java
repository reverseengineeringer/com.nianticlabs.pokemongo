package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

final class $Gson$Types$WildcardTypeImpl
  implements WildcardType, Serializable
{
  private static final long serialVersionUID = 0L;
  private final Type lowerBound;
  private final Type upperBound;
  
  public $Gson$Types$WildcardTypeImpl(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
  {
    if (paramArrayOfType2.length <= 1)
    {
      bool1 = true;
      .Gson.Preconditions.checkArgument(bool1);
      if (paramArrayOfType1.length != 1) {
        break label87;
      }
      bool1 = true;
      label27:
      .Gson.Preconditions.checkArgument(bool1);
      if (paramArrayOfType2.length != 1) {
        break label97;
      }
      .Gson.Preconditions.checkNotNull(paramArrayOfType2[0]);
      .Gson.Types.access$000(paramArrayOfType2[0]);
      if (paramArrayOfType1[0] != Object.class) {
        break label92;
      }
    }
    label87:
    label92:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      .Gson.Preconditions.checkArgument(bool1);
      lowerBound = .Gson.Types.canonicalize(paramArrayOfType2[0]);
      upperBound = Object.class;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label27;
    }
    label97:
    .Gson.Preconditions.checkNotNull(paramArrayOfType1[0]);
    .Gson.Types.access$000(paramArrayOfType1[0]);
    lowerBound = null;
    upperBound = .Gson.Types.canonicalize(paramArrayOfType1[0]);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof WildcardType)) && (.Gson.Types.equals(this, (WildcardType)paramObject));
  }
  
  public Type[] getLowerBounds()
  {
    if (lowerBound != null) {
      return new Type[] { lowerBound };
    }
    return .Gson.Types.EMPTY_TYPE_ARRAY;
  }
  
  public Type[] getUpperBounds()
  {
    return new Type[] { upperBound };
  }
  
  public int hashCode()
  {
    if (lowerBound != null) {}
    for (int i = lowerBound.hashCode() + 31;; i = 1) {
      return i ^ upperBound.hashCode() + 31;
    }
  }
  
  public String toString()
  {
    if (lowerBound != null) {
      return "? super " + .Gson.Types.typeToString(lowerBound);
    }
    if (upperBound == Object.class) {
      return "?";
    }
    return "? extends " + .Gson.Types.typeToString(upperBound);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal..Gson.Types.WildcardTypeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */