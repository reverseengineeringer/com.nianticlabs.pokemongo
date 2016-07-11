package com.unity3d.player;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import java.util.List;

final class n$1
  extends Fragment
{
  n$1(n paramn, List paramList, FragmentManager paramFragmentManager, Runnable paramRunnable) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt != 15881) {
      return;
    }
    paramInt = 0;
    if ((paramInt < paramArrayOfString.length) && (paramInt < paramArrayOfInt.length))
    {
      StringBuilder localStringBuilder = new StringBuilder().append(paramArrayOfString[paramInt]);
      if (paramArrayOfInt[paramInt] == 0) {}
      for (String str = " granted";; str = " denied")
      {
        m.Log(4, str);
        paramInt += 1;
        break;
      }
    }
    paramArrayOfString = b.beginTransaction();
    paramArrayOfString.remove(this);
    paramArrayOfString.commit();
    c.run();
  }
  
  public final void onStart()
  {
    super.onStart();
    requestPermissions((String[])a.toArray(new String[0]), 15881);
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.n.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */