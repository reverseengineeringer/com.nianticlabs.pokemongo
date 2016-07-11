package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.zzw;

final class zza$zza
{
  public final Uri uri;
  
  public zza$zza(Uri paramUri)
  {
    uri = paramUri;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zza)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    return zzw.equal(uri, uri);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { uri });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.images.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */