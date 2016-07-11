package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

public final class MediaDescriptionCompat$Builder
{
  private CharSequence mDescription;
  private Bundle mExtras;
  private Bitmap mIcon;
  private Uri mIconUri;
  private String mMediaId;
  private Uri mMediaUri;
  private CharSequence mSubtitle;
  private CharSequence mTitle;
  
  public MediaDescriptionCompat build()
  {
    return new MediaDescriptionCompat(mMediaId, mTitle, mSubtitle, mDescription, mIcon, mIconUri, mExtras, mMediaUri, null);
  }
  
  public Builder setDescription(@Nullable CharSequence paramCharSequence)
  {
    mDescription = paramCharSequence;
    return this;
  }
  
  public Builder setExtras(@Nullable Bundle paramBundle)
  {
    mExtras = paramBundle;
    return this;
  }
  
  public Builder setIconBitmap(@Nullable Bitmap paramBitmap)
  {
    mIcon = paramBitmap;
    return this;
  }
  
  public Builder setIconUri(@Nullable Uri paramUri)
  {
    mIconUri = paramUri;
    return this;
  }
  
  public Builder setMediaId(@Nullable String paramString)
  {
    mMediaId = paramString;
    return this;
  }
  
  public Builder setMediaUri(@Nullable Uri paramUri)
  {
    mMediaUri = paramUri;
    return this;
  }
  
  public Builder setSubtitle(@Nullable CharSequence paramCharSequence)
  {
    mSubtitle = paramCharSequence;
    return this;
  }
  
  public Builder setTitle(@Nullable CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    return this;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.MediaDescriptionCompat.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */