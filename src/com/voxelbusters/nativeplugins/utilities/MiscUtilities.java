package com.voxelbusters.nativeplugins.utilities;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import com.voxelbusters.nativeplugins.features.sharing.SharingHelper;
import java.util.Comparator;

public class MiscUtilities
{
  public static Comparator<ResolveInfo> resolveInfoComparator = new Comparator()
  {
    public int compare(ResolveInfo paramAnonymousResolveInfo1, ResolveInfo paramAnonymousResolveInfo2)
    {
      boolean bool1 = SharingHelper.isSocialNetwork(activityInfo.packageName);
      boolean bool2 = SharingHelper.isSocialNetwork(activityInfo.packageName);
      if (((bool1) && (bool2)) || (bool1)) {
        return -1;
      }
      if (bool2) {
        return 1;
      }
      return 0;
    }
  };
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.utilities.MiscUtilities
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */