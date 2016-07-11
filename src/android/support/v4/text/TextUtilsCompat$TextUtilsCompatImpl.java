package android.support.v4.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Locale;

class TextUtilsCompat$TextUtilsCompatImpl
{
  private static int getLayoutDirectionFromFirstChar(@NonNull Locale paramLocale)
  {
    switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
    {
    default: 
      return 0;
    }
    return 1;
  }
  
  public int getLayoutDirectionFromLocale(@Nullable Locale paramLocale)
  {
    if ((paramLocale != null) && (!paramLocale.equals(TextUtilsCompat.ROOT)))
    {
      String str = ICUCompat.maximizeAndGetScript(paramLocale);
      if (str == null) {
        return getLayoutDirectionFromFirstChar(paramLocale);
      }
      if ((str.equalsIgnoreCase(TextUtilsCompat.access$000())) || (str.equalsIgnoreCase(TextUtilsCompat.access$100()))) {
        return 1;
      }
    }
    return 0;
  }
  
  @NonNull
  public String htmlEncode(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        localStringBuilder.append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("&lt;");
        continue;
        localStringBuilder.append("&gt;");
        continue;
        localStringBuilder.append("&amp;");
        continue;
        localStringBuilder.append("&#39;");
        continue;
        localStringBuilder.append("&quot;");
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.text.TextUtilsCompat.TextUtilsCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */