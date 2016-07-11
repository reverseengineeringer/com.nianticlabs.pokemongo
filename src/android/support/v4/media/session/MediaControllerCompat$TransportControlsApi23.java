package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

class MediaControllerCompat$TransportControlsApi23
  extends MediaControllerCompat.TransportControlsApi21
{
  public MediaControllerCompat$TransportControlsApi23(Object paramObject)
  {
    super(paramObject);
  }
  
  public void playFromUri(Uri paramUri, Bundle paramBundle)
  {
    MediaControllerCompatApi23.TransportControls.playFromUri(mControlsObj, paramUri, paramBundle);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.session.MediaControllerCompat.TransportControlsApi23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */