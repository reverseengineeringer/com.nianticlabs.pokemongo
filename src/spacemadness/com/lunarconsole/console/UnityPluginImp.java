package spacemadness.com.lunarconsole.console;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.unity3d.player.UnityPlayer;
import java.lang.ref.WeakReference;
import spacemadness.com.lunarconsole.core.LunarConsoleException;
import spacemadness.com.lunarconsole.utils.UIUtils;

public class UnityPluginImp
  implements ConsolePluginImp
{
  private final WeakReference<UnityPlayer> playerRef;
  
  public UnityPluginImp(Activity paramActivity)
  {
    paramActivity = resolveUnityPlayerInstance(paramActivity);
    if (paramActivity == null) {
      throw new LunarConsoleException("Can't initialize plugin: UnityPlayer instance not resolved");
    }
    playerRef = new WeakReference(paramActivity);
  }
  
  private UnityPlayer getPlayer()
  {
    return (UnityPlayer)playerRef.get();
  }
  
  private static UnityPlayer resolveUnityPlayerInstance(Activity paramActivity)
  {
    return resolveUnityPlayerInstance(UIUtils.getRootViewGroup(paramActivity));
  }
  
  private static UnityPlayer resolveUnityPlayerInstance(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup instanceof UnityPlayer)) {
      return (UnityPlayer)paramViewGroup;
    }
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      Object localObject = paramViewGroup.getChildAt(i);
      if ((localObject instanceof UnityPlayer)) {
        return (UnityPlayer)localObject;
      }
      if ((localObject instanceof ViewGroup))
      {
        localObject = resolveUnityPlayerInstance((ViewGroup)localObject);
        if (localObject != null) {
          return (UnityPlayer)localObject;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public View getTouchRecepientView()
  {
    return getPlayer();
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.UnityPluginImp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */