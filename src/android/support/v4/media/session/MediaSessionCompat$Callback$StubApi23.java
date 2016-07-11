package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

class MediaSessionCompat$Callback$StubApi23
  extends MediaSessionCompat.Callback.StubApi21
  implements MediaSessionCompatApi23.Callback
{
  private MediaSessionCompat$Callback$StubApi23(MediaSessionCompat.Callback paramCallback)
  {
    super(paramCallback, null);
  }
  
  public void onPlayFromUri(Uri paramUri, Bundle paramBundle)
  {
    this$0.onPlayFromUri(paramUri, paramBundle);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.Callback.StubApi23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */