package android.support.v4.content;

import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;

class SharedPreferencesCompat$EditorCompat$EditorHelperBaseImpl
  implements SharedPreferencesCompat.EditorCompat.Helper
{
  public void apply(@NonNull SharedPreferences.Editor paramEditor)
  {
    paramEditor.commit();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.SharedPreferencesCompat.EditorCompat.EditorHelperBaseImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */