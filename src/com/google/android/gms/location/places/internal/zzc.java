package com.google.android.gms.location.places.internal;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import java.util.Iterator;
import java.util.List;

public class zzc
{
  public static CharSequence zza(String paramString, List<AutocompletePredictionEntity.SubstringEntity> paramList, CharacterStyle paramCharacterStyle)
  {
    if (paramCharacterStyle == null) {
      return paramString;
    }
    paramString = new SpannableString(paramString);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AutocompletePredictionEntity.SubstringEntity localSubstringEntity = (AutocompletePredictionEntity.SubstringEntity)paramList.next();
      CharacterStyle localCharacterStyle = CharacterStyle.wrap(paramCharacterStyle);
      int i = localSubstringEntity.getOffset();
      int j = localSubstringEntity.getOffset();
      paramString.setSpan(localCharacterStyle, i, localSubstringEntity.getLength() + j, 0);
    }
    return paramString;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */