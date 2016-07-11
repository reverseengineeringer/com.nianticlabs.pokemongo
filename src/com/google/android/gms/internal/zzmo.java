package com.google.android.gms.internal;

import android.database.CharArrayBuffer;
import android.text.TextUtils;

public final class zzmo
{
  public static void zzb(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    if (TextUtils.isEmpty(paramString)) {
      sizeCopied = 0;
    }
    for (;;)
    {
      sizeCopied = paramString.length();
      return;
      if ((data == null) || (data.length < paramString.length())) {
        data = paramString.toCharArray();
      } else {
        paramString.getChars(0, paramString.length(), data, 0);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */