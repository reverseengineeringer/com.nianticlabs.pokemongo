package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.Collections;
import java.util.List;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoStubImpl
  implements AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
{
  public void addAction(Object paramObject, int paramInt) {}
  
  public void addAction(Object paramObject1, Object paramObject2) {}
  
  public void addChild(Object paramObject, View paramView) {}
  
  public void addChild(Object paramObject, View paramView, int paramInt) {}
  
  public boolean canOpenPopup(Object paramObject)
  {
    return false;
  }
  
  public List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString)
  {
    return Collections.emptyList();
  }
  
  public List<Object> findAccessibilityNodeInfosByViewId(Object paramObject, String paramString)
  {
    return Collections.emptyList();
  }
  
  public Object findFocus(Object paramObject, int paramInt)
  {
    return null;
  }
  
  public Object focusSearch(Object paramObject, int paramInt)
  {
    return null;
  }
  
  public int getAccessibilityActionId(Object paramObject)
  {
    return 0;
  }
  
  public CharSequence getAccessibilityActionLabel(Object paramObject)
  {
    return null;
  }
  
  public List<Object> getActionList(Object paramObject)
  {
    return null;
  }
  
  public int getActions(Object paramObject)
  {
    return 0;
  }
  
  public void getBoundsInParent(Object paramObject, Rect paramRect) {}
  
  public void getBoundsInScreen(Object paramObject, Rect paramRect) {}
  
  public Object getChild(Object paramObject, int paramInt)
  {
    return null;
  }
  
  public int getChildCount(Object paramObject)
  {
    return 0;
  }
  
  public CharSequence getClassName(Object paramObject)
  {
    return null;
  }
  
  public Object getCollectionInfo(Object paramObject)
  {
    return null;
  }
  
  public int getCollectionInfoColumnCount(Object paramObject)
  {
    return 0;
  }
  
  public int getCollectionInfoRowCount(Object paramObject)
  {
    return 0;
  }
  
  public int getCollectionItemColumnIndex(Object paramObject)
  {
    return 0;
  }
  
  public int getCollectionItemColumnSpan(Object paramObject)
  {
    return 0;
  }
  
  public Object getCollectionItemInfo(Object paramObject)
  {
    return null;
  }
  
  public int getCollectionItemRowIndex(Object paramObject)
  {
    return 0;
  }
  
  public int getCollectionItemRowSpan(Object paramObject)
  {
    return 0;
  }
  
  public CharSequence getContentDescription(Object paramObject)
  {
    return null;
  }
  
  public CharSequence getError(Object paramObject)
  {
    return null;
  }
  
  public Bundle getExtras(Object paramObject)
  {
    return new Bundle();
  }
  
  public int getInputType(Object paramObject)
  {
    return 0;
  }
  
  public Object getLabelFor(Object paramObject)
  {
    return null;
  }
  
  public Object getLabeledBy(Object paramObject)
  {
    return null;
  }
  
  public int getLiveRegion(Object paramObject)
  {
    return 0;
  }
  
  public int getMaxTextLength(Object paramObject)
  {
    return -1;
  }
  
  public int getMovementGranularities(Object paramObject)
  {
    return 0;
  }
  
  public CharSequence getPackageName(Object paramObject)
  {
    return null;
  }
  
  public Object getParent(Object paramObject)
  {
    return null;
  }
  
  public Object getRangeInfo(Object paramObject)
  {
    return null;
  }
  
  public CharSequence getText(Object paramObject)
  {
    return null;
  }
  
  public int getTextSelectionEnd(Object paramObject)
  {
    return -1;
  }
  
  public int getTextSelectionStart(Object paramObject)
  {
    return -1;
  }
  
  public Object getTraversalAfter(Object paramObject)
  {
    return null;
  }
  
  public Object getTraversalBefore(Object paramObject)
  {
    return null;
  }
  
  public String getViewIdResourceName(Object paramObject)
  {
    return null;
  }
  
  public Object getWindow(Object paramObject)
  {
    return null;
  }
  
  public int getWindowId(Object paramObject)
  {
    return 0;
  }
  
  public boolean isAccessibilityFocused(Object paramObject)
  {
    return false;
  }
  
  public boolean isCheckable(Object paramObject)
  {
    return false;
  }
  
  public boolean isChecked(Object paramObject)
  {
    return false;
  }
  
  public boolean isClickable(Object paramObject)
  {
    return false;
  }
  
  public boolean isCollectionInfoHierarchical(Object paramObject)
  {
    return false;
  }
  
  public boolean isCollectionItemHeading(Object paramObject)
  {
    return false;
  }
  
  public boolean isCollectionItemSelected(Object paramObject)
  {
    return false;
  }
  
  public boolean isContentInvalid(Object paramObject)
  {
    return false;
  }
  
  public boolean isDismissable(Object paramObject)
  {
    return false;
  }
  
  public boolean isEditable(Object paramObject)
  {
    return false;
  }
  
  public boolean isEnabled(Object paramObject)
  {
    return false;
  }
  
  public boolean isFocusable(Object paramObject)
  {
    return false;
  }
  
  public boolean isFocused(Object paramObject)
  {
    return false;
  }
  
  public boolean isLongClickable(Object paramObject)
  {
    return false;
  }
  
  public boolean isMultiLine(Object paramObject)
  {
    return false;
  }
  
  public boolean isPassword(Object paramObject)
  {
    return false;
  }
  
  public boolean isScrollable(Object paramObject)
  {
    return false;
  }
  
  public boolean isSelected(Object paramObject)
  {
    return false;
  }
  
  public boolean isVisibleToUser(Object paramObject)
  {
    return false;
  }
  
  public Object newAccessibilityAction(int paramInt, CharSequence paramCharSequence)
  {
    return null;
  }
  
  public Object obtain()
  {
    return null;
  }
  
  public Object obtain(View paramView)
  {
    return null;
  }
  
  public Object obtain(View paramView, int paramInt)
  {
    return null;
  }
  
  public Object obtain(Object paramObject)
  {
    return null;
  }
  
  public Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    return null;
  }
  
  public Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public boolean performAction(Object paramObject, int paramInt)
  {
    return false;
  }
  
  public boolean performAction(Object paramObject, int paramInt, Bundle paramBundle)
  {
    return false;
  }
  
  public void recycle(Object paramObject) {}
  
  public boolean refresh(Object paramObject)
  {
    return false;
  }
  
  public boolean removeAction(Object paramObject1, Object paramObject2)
  {
    return false;
  }
  
  public boolean removeChild(Object paramObject, View paramView)
  {
    return false;
  }
  
  public boolean removeChild(Object paramObject, View paramView, int paramInt)
  {
    return false;
  }
  
  public void setAccessibilityFocused(Object paramObject, boolean paramBoolean) {}
  
  public void setBoundsInParent(Object paramObject, Rect paramRect) {}
  
  public void setBoundsInScreen(Object paramObject, Rect paramRect) {}
  
  public void setCanOpenPopup(Object paramObject, boolean paramBoolean) {}
  
  public void setCheckable(Object paramObject, boolean paramBoolean) {}
  
  public void setChecked(Object paramObject, boolean paramBoolean) {}
  
  public void setClassName(Object paramObject, CharSequence paramCharSequence) {}
  
  public void setClickable(Object paramObject, boolean paramBoolean) {}
  
  public void setCollectionInfo(Object paramObject1, Object paramObject2) {}
  
  public void setCollectionItemInfo(Object paramObject1, Object paramObject2) {}
  
  public void setContentDescription(Object paramObject, CharSequence paramCharSequence) {}
  
  public void setContentInvalid(Object paramObject, boolean paramBoolean) {}
  
  public void setDismissable(Object paramObject, boolean paramBoolean) {}
  
  public void setEditable(Object paramObject, boolean paramBoolean) {}
  
  public void setEnabled(Object paramObject, boolean paramBoolean) {}
  
  public void setError(Object paramObject, CharSequence paramCharSequence) {}
  
  public void setFocusable(Object paramObject, boolean paramBoolean) {}
  
  public void setFocused(Object paramObject, boolean paramBoolean) {}
  
  public void setInputType(Object paramObject, int paramInt) {}
  
  public void setLabelFor(Object paramObject, View paramView) {}
  
  public void setLabelFor(Object paramObject, View paramView, int paramInt) {}
  
  public void setLabeledBy(Object paramObject, View paramView) {}
  
  public void setLabeledBy(Object paramObject, View paramView, int paramInt) {}
  
  public void setLiveRegion(Object paramObject, int paramInt) {}
  
  public void setLongClickable(Object paramObject, boolean paramBoolean) {}
  
  public void setMaxTextLength(Object paramObject, int paramInt) {}
  
  public void setMovementGranularities(Object paramObject, int paramInt) {}
  
  public void setMultiLine(Object paramObject, boolean paramBoolean) {}
  
  public void setPackageName(Object paramObject, CharSequence paramCharSequence) {}
  
  public void setParent(Object paramObject, View paramView) {}
  
  public void setParent(Object paramObject, View paramView, int paramInt) {}
  
  public void setPassword(Object paramObject, boolean paramBoolean) {}
  
  public void setRangeInfo(Object paramObject1, Object paramObject2) {}
  
  public void setScrollable(Object paramObject, boolean paramBoolean) {}
  
  public void setSelected(Object paramObject, boolean paramBoolean) {}
  
  public void setSource(Object paramObject, View paramView) {}
  
  public void setSource(Object paramObject, View paramView, int paramInt) {}
  
  public void setText(Object paramObject, CharSequence paramCharSequence) {}
  
  public void setTextSelection(Object paramObject, int paramInt1, int paramInt2) {}
  
  public void setTraversalAfter(Object paramObject, View paramView) {}
  
  public void setTraversalAfter(Object paramObject, View paramView, int paramInt) {}
  
  public void setTraversalBefore(Object paramObject, View paramView) {}
  
  public void setTraversalBefore(Object paramObject, View paramView, int paramInt) {}
  
  public void setViewIdResourceName(Object paramObject, String paramString) {}
  
  public void setVisibleToUser(Object paramObject, boolean paramBoolean) {}
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */