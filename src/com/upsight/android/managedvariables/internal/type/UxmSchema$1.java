package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.managedvariables.type.UpsightManagedBoolean;
import com.upsight.android.managedvariables.type.UpsightManagedFloat;
import com.upsight.android.managedvariables.type.UpsightManagedInt;
import com.upsight.android.managedvariables.type.UpsightManagedString;
import java.util.HashMap;

final class UxmSchema$1
  extends HashMap<Class<? extends ManagedVariable>, Class<? extends UxmSchema.BaseSchema>>
{
  UxmSchema$1()
  {
    put(UpsightManagedString.class, UxmSchema.StringSchema.class);
    put(UpsightManagedBoolean.class, UxmSchema.BooleanSchema.class);
    put(UpsightManagedInt.class, UxmSchema.IntSchema.class);
    put(UpsightManagedFloat.class, UxmSchema.FloatSchema.class);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmSchema.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */