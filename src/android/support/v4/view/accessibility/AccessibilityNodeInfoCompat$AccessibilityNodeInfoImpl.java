package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.List;

abstract interface AccessibilityNodeInfoCompat$AccessibilityNodeInfoImpl
{
  public abstract void addAction(Object paramObject, int paramInt);
  
  public abstract void addAction(Object paramObject1, Object paramObject2);
  
  public abstract void addChild(Object paramObject, View paramView);
  
  public abstract void addChild(Object paramObject, View paramView, int paramInt);
  
  public abstract boolean canOpenPopup(Object paramObject);
  
  public abstract List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString);
  
  public abstract List<Object> findAccessibilityNodeInfosByViewId(Object paramObject, String paramString);
  
  public abstract Object findFocus(Object paramObject, int paramInt);
  
  public abstract Object focusSearch(Object paramObject, int paramInt);
  
  public abstract int getAccessibilityActionId(Object paramObject);
  
  public abstract CharSequence getAccessibilityActionLabel(Object paramObject);
  
  public abstract List<Object> getActionList(Object paramObject);
  
  public abstract int getActions(Object paramObject);
  
  public abstract void getBoundsInParent(Object paramObject, Rect paramRect);
  
  public abstract void getBoundsInScreen(Object paramObject, Rect paramRect);
  
  public abstract Object getChild(Object paramObject, int paramInt);
  
  public abstract int getChildCount(Object paramObject);
  
  public abstract CharSequence getClassName(Object paramObject);
  
  public abstract Object getCollectionInfo(Object paramObject);
  
  public abstract int getCollectionInfoColumnCount(Object paramObject);
  
  public abstract int getCollectionInfoRowCount(Object paramObject);
  
  public abstract int getCollectionItemColumnIndex(Object paramObject);
  
  public abstract int getCollectionItemColumnSpan(Object paramObject);
  
  public abstract Object getCollectionItemInfo(Object paramObject);
  
  public abstract int getCollectionItemRowIndex(Object paramObject);
  
  public abstract int getCollectionItemRowSpan(Object paramObject);
  
  public abstract CharSequence getContentDescription(Object paramObject);
  
  public abstract CharSequence getError(Object paramObject);
  
  public abstract Bundle getExtras(Object paramObject);
  
  public abstract int getInputType(Object paramObject);
  
  public abstract Object getLabelFor(Object paramObject);
  
  public abstract Object getLabeledBy(Object paramObject);
  
  public abstract int getLiveRegion(Object paramObject);
  
  public abstract int getMaxTextLength(Object paramObject);
  
  public abstract int getMovementGranularities(Object paramObject);
  
  public abstract CharSequence getPackageName(Object paramObject);
  
  public abstract Object getParent(Object paramObject);
  
  public abstract Object getRangeInfo(Object paramObject);
  
  public abstract CharSequence getText(Object paramObject);
  
  public abstract int getTextSelectionEnd(Object paramObject);
  
  public abstract int getTextSelectionStart(Object paramObject);
  
  public abstract Object getTraversalAfter(Object paramObject);
  
  public abstract Object getTraversalBefore(Object paramObject);
  
  public abstract String getViewIdResourceName(Object paramObject);
  
  public abstract Object getWindow(Object paramObject);
  
  public abstract int getWindowId(Object paramObject);
  
  public abstract boolean isAccessibilityFocused(Object paramObject);
  
  public abstract boolean isCheckable(Object paramObject);
  
  public abstract boolean isChecked(Object paramObject);
  
  public abstract boolean isClickable(Object paramObject);
  
  public abstract boolean isCollectionInfoHierarchical(Object paramObject);
  
  public abstract boolean isCollectionItemHeading(Object paramObject);
  
  public abstract boolean isCollectionItemSelected(Object paramObject);
  
  public abstract boolean isContentInvalid(Object paramObject);
  
  public abstract boolean isDismissable(Object paramObject);
  
  public abstract boolean isEditable(Object paramObject);
  
  public abstract boolean isEnabled(Object paramObject);
  
  public abstract boolean isFocusable(Object paramObject);
  
  public abstract boolean isFocused(Object paramObject);
  
  public abstract boolean isLongClickable(Object paramObject);
  
  public abstract boolean isMultiLine(Object paramObject);
  
  public abstract boolean isPassword(Object paramObject);
  
  public abstract boolean isScrollable(Object paramObject);
  
  public abstract boolean isSelected(Object paramObject);
  
  public abstract boolean isVisibleToUser(Object paramObject);
  
  public abstract Object newAccessibilityAction(int paramInt, CharSequence paramCharSequence);
  
  public abstract Object obtain();
  
  public abstract Object obtain(View paramView);
  
  public abstract Object obtain(View paramView, int paramInt);
  
  public abstract Object obtain(Object paramObject);
  
  public abstract Object obtainCollectionInfo(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3);
  
  public abstract Object obtainCollectionItemInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean performAction(Object paramObject, int paramInt);
  
  public abstract boolean performAction(Object paramObject, int paramInt, Bundle paramBundle);
  
  public abstract void recycle(Object paramObject);
  
  public abstract boolean refresh(Object paramObject);
  
  public abstract boolean removeAction(Object paramObject1, Object paramObject2);
  
  public abstract boolean removeChild(Object paramObject, View paramView);
  
  public abstract boolean removeChild(Object paramObject, View paramView, int paramInt);
  
  public abstract void setAccessibilityFocused(Object paramObject, boolean paramBoolean);
  
  public abstract void setBoundsInParent(Object paramObject, Rect paramRect);
  
  public abstract void setBoundsInScreen(Object paramObject, Rect paramRect);
  
  public abstract void setCanOpenPopup(Object paramObject, boolean paramBoolean);
  
  public abstract void setCheckable(Object paramObject, boolean paramBoolean);
  
  public abstract void setChecked(Object paramObject, boolean paramBoolean);
  
  public abstract void setClassName(Object paramObject, CharSequence paramCharSequence);
  
  public abstract void setClickable(Object paramObject, boolean paramBoolean);
  
  public abstract void setCollectionInfo(Object paramObject1, Object paramObject2);
  
  public abstract void setCollectionItemInfo(Object paramObject1, Object paramObject2);
  
  public abstract void setContentDescription(Object paramObject, CharSequence paramCharSequence);
  
  public abstract void setContentInvalid(Object paramObject, boolean paramBoolean);
  
  public abstract void setDismissable(Object paramObject, boolean paramBoolean);
  
  public abstract void setEditable(Object paramObject, boolean paramBoolean);
  
  public abstract void setEnabled(Object paramObject, boolean paramBoolean);
  
  public abstract void setError(Object paramObject, CharSequence paramCharSequence);
  
  public abstract void setFocusable(Object paramObject, boolean paramBoolean);
  
  public abstract void setFocused(Object paramObject, boolean paramBoolean);
  
  public abstract void setInputType(Object paramObject, int paramInt);
  
  public abstract void setLabelFor(Object paramObject, View paramView);
  
  public abstract void setLabelFor(Object paramObject, View paramView, int paramInt);
  
  public abstract void setLabeledBy(Object paramObject, View paramView);
  
  public abstract void setLabeledBy(Object paramObject, View paramView, int paramInt);
  
  public abstract void setLiveRegion(Object paramObject, int paramInt);
  
  public abstract void setLongClickable(Object paramObject, boolean paramBoolean);
  
  public abstract void setMaxTextLength(Object paramObject, int paramInt);
  
  public abstract void setMovementGranularities(Object paramObject, int paramInt);
  
  public abstract void setMultiLine(Object paramObject, boolean paramBoolean);
  
  public abstract void setPackageName(Object paramObject, CharSequence paramCharSequence);
  
  public abstract void setParent(Object paramObject, View paramView);
  
  public abstract void setParent(Object paramObject, View paramView, int paramInt);
  
  public abstract void setPassword(Object paramObject, boolean paramBoolean);
  
  public abstract void setRangeInfo(Object paramObject1, Object paramObject2);
  
  public abstract void setScrollable(Object paramObject, boolean paramBoolean);
  
  public abstract void setSelected(Object paramObject, boolean paramBoolean);
  
  public abstract void setSource(Object paramObject, View paramView);
  
  public abstract void setSource(Object paramObject, View paramView, int paramInt);
  
  public abstract void setText(Object paramObject, CharSequence paramCharSequence);
  
  public abstract void setTextSelection(Object paramObject, int paramInt1, int paramInt2);
  
  public abstract void setTraversalAfter(Object paramObject, View paramView);
  
  public abstract void setTraversalAfter(Object paramObject, View paramView, int paramInt);
  
  public abstract void setTraversalBefore(Object paramObject, View paramView);
  
  public abstract void setTraversalBefore(Object paramObject, View paramView, int paramInt);
  
  public abstract void setViewIdResourceName(Object paramObject, String paramString);
  
  public abstract void setVisibleToUser(Object paramObject, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */