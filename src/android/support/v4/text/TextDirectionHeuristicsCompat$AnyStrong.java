package android.support.v4.text;

class TextDirectionHeuristicsCompat$AnyStrong
  implements TextDirectionHeuristicsCompat.TextDirectionAlgorithm
{
  public static final AnyStrong INSTANCE_LTR = new AnyStrong(false);
  public static final AnyStrong INSTANCE_RTL = new AnyStrong(true);
  private final boolean mLookForRtl;
  
  private TextDirectionHeuristicsCompat$AnyStrong(boolean paramBoolean)
  {
    mLookForRtl = paramBoolean;
  }
  
  public int checkRtl(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int k = 1;
    int i = 0;
    int j = paramInt1;
    for (;;)
    {
      if (j < paramInt1 + paramInt2) {
        switch (TextDirectionHeuristicsCompat.access$200(Character.getDirectionality(paramCharSequence.charAt(j))))
        {
        default: 
          j += 1;
          break;
        case 0: 
          if (mLookForRtl) {
            i = 0;
          }
          break;
        }
      }
    }
    do
    {
      do
      {
        return i;
        i = 1;
        break;
        i = k;
      } while (!mLookForRtl);
      i = 1;
      break;
      if (i == 0) {
        break label115;
      }
      i = k;
    } while (mLookForRtl);
    return 0;
    label115:
    return 2;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.text.TextDirectionHeuristicsCompat.AnyStrong
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */