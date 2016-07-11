package android.support.v4.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Locale;

class TextUtilsCompat$TextUtilsCompatJellybeanMr1Impl
  extends TextUtilsCompat.TextUtilsCompatImpl
{
  private TextUtilsCompat$TextUtilsCompatJellybeanMr1Impl()
  {
    super(null);
  }
  
  public int getLayoutDirectionFromLocale(@Nullable Locale paramLocale)
  {
    return TextUtilsCompatJellybeanMr1.getLayoutDirectionFromLocale(paramLocale);
  }
  
  @NonNull
  public String htmlEncode(@NonNull String paramString)
  {
    return TextUtilsCompatJellybeanMr1.htmlEncode(paramString);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.text.TextUtilsCompat.TextUtilsCompatJellybeanMr1Impl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */