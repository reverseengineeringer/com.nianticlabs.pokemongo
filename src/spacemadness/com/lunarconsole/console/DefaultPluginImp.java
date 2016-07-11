package spacemadness.com.lunarconsole.console;

import android.app.Activity;
import android.view.View;
import java.lang.ref.WeakReference;
import spacemadness.com.lunarconsole.core.LunarConsoleException;
import spacemadness.com.lunarconsole.utils.UIUtils;

class DefaultPluginImp
  implements ConsolePluginImp
{
  private final WeakReference<View> rootViewRef;
  
  public DefaultPluginImp(Activity paramActivity)
  {
    paramActivity = UIUtils.getRootViewGroup(paramActivity);
    if (paramActivity == null) {
      throw new LunarConsoleException("Can't initialize plugin: root view not found");
    }
    rootViewRef = new WeakReference(paramActivity);
  }
  
  public View getTouchRecepientView()
  {
    return (View)rootViewRef.get();
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.console.DefaultPluginImp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */