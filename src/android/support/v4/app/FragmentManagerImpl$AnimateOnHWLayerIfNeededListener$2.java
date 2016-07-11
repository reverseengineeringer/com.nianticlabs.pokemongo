package android.support.v4.app;

import android.support.v4.view.ViewCompat;

class FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$2
  implements Runnable
{
  FragmentManagerImpl$AnimateOnHWLayerIfNeededListener$2(FragmentManagerImpl.AnimateOnHWLayerIfNeededListener paramAnimateOnHWLayerIfNeededListener) {}
  
  public void run()
  {
    ViewCompat.setLayerType(FragmentManagerImpl.AnimateOnHWLayerIfNeededListener.access$000(this$0), 0, null);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentManagerImpl.AnimateOnHWLayerIfNeededListener.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */