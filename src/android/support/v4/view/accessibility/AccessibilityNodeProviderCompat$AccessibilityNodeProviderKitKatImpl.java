package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl
  extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl
{
  public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat)
  {
    AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge()
    {
      public Object createAccessibilityNodeInfo(int paramAnonymousInt)
      {
        AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = paramAccessibilityNodeProviderCompat.createAccessibilityNodeInfo(paramAnonymousInt);
        if (localAccessibilityNodeInfoCompat == null) {
          return null;
        }
        return localAccessibilityNodeInfoCompat.getInfo();
      }
      
      public List<Object> findAccessibilityNodeInfosByText(String paramAnonymousString, int paramAnonymousInt)
      {
        paramAnonymousString = paramAccessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(paramAnonymousString, paramAnonymousInt);
        ArrayList localArrayList = new ArrayList();
        int i = paramAnonymousString.size();
        paramAnonymousInt = 0;
        while (paramAnonymousInt < i)
        {
          localArrayList.add(((AccessibilityNodeInfoCompat)paramAnonymousString.get(paramAnonymousInt)).getInfo());
          paramAnonymousInt += 1;
        }
        return localArrayList;
      }
      
      public Object findFocus(int paramAnonymousInt)
      {
        AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = paramAccessibilityNodeProviderCompat.findFocus(paramAnonymousInt);
        if (localAccessibilityNodeInfoCompat == null) {
          return null;
        }
        return localAccessibilityNodeInfoCompat.getInfo();
      }
      
      public boolean performAction(int paramAnonymousInt1, int paramAnonymousInt2, Bundle paramAnonymousBundle)
      {
        return paramAccessibilityNodeProviderCompat.performAction(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBundle);
      }
    });
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */