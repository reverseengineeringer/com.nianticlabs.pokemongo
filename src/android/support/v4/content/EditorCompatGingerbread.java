package android.support.v4.content;

import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;

class EditorCompatGingerbread
{
  public static void apply(@NonNull SharedPreferences.Editor paramEditor)
  {
    try
    {
      paramEditor.apply();
      return;
    }
    catch (AbstractMethodError localAbstractMethodError)
    {
      paramEditor.commit();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.EditorCompatGingerbread
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */