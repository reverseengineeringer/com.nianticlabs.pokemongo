package android.support.v4.media;

import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;

class MediaDescriptionCompatApi23
  extends MediaDescriptionCompatApi21
{
  public static Uri getMediaUri(Object paramObject)
  {
    return ((MediaDescription)paramObject).getMediaUri();
  }
  
  static class Builder
    extends MediaDescriptionCompatApi21.Builder
  {
    public static void setMediaUri(Object paramObject, Uri paramUri)
    {
      ((MediaDescription.Builder)paramObject).setMediaUri(paramUri);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.MediaDescriptionCompatApi23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */