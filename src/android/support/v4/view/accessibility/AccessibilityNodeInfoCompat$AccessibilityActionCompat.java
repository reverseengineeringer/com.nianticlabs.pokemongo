package android.support.v4.view.accessibility;

public class AccessibilityNodeInfoCompat$AccessibilityActionCompat
{
  public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
  public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
  public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS;
  public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
  public static final AccessibilityActionCompat ACTION_CLICK;
  public static final AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
  public static final AccessibilityActionCompat ACTION_COPY;
  public static final AccessibilityActionCompat ACTION_CUT;
  public static final AccessibilityActionCompat ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
  public static final AccessibilityActionCompat ACTION_EXPAND;
  public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, null);
  public static final AccessibilityActionCompat ACTION_LONG_CLICK;
  public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
  public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
  public static final AccessibilityActionCompat ACTION_PASTE;
  public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
  public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
  public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
  public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
  public static final AccessibilityActionCompat ACTION_SELECT;
  public static final AccessibilityActionCompat ACTION_SET_SELECTION;
  public static final AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, null);
  private final Object mAction;
  
  static
  {
    ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
    ACTION_SELECT = new AccessibilityActionCompat(4, null);
    ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
    ACTION_CLICK = new AccessibilityActionCompat(16, null);
    ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
    ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
    ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
    ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, null);
    ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, null);
    ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, null);
    ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, null);
    ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
    ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
    ACTION_COPY = new AccessibilityActionCompat(16384, null);
    ACTION_PASTE = new AccessibilityActionCompat(32768, null);
    ACTION_CUT = new AccessibilityActionCompat(65536, null);
    ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, null);
    ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
  }
  
  public AccessibilityNodeInfoCompat$AccessibilityActionCompat(int paramInt, CharSequence paramCharSequence)
  {
    this(AccessibilityNodeInfoCompat.access$000().newAccessibilityAction(paramInt, paramCharSequence));
  }
  
  private AccessibilityNodeInfoCompat$AccessibilityActionCompat(Object paramObject)
  {
    mAction = paramObject;
  }
  
  public int getId()
  {
    return AccessibilityNodeInfoCompat.access$000().getAccessibilityActionId(mAction);
  }
  
  public CharSequence getLabel()
  {
    return AccessibilityNodeInfoCompat.access$000().getAccessibilityActionLabel(mAction);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */