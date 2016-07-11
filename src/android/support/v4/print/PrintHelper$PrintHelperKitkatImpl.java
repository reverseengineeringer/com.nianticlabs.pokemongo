package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.FileNotFoundException;

final class PrintHelper$PrintHelperKitkatImpl
  implements PrintHelper.PrintHelperVersionImpl
{
  private final PrintHelperKitkat mPrintHelper;
  
  PrintHelper$PrintHelperKitkatImpl(Context paramContext)
  {
    mPrintHelper = new PrintHelperKitkat(paramContext);
  }
  
  public int getColorMode()
  {
    return mPrintHelper.getColorMode();
  }
  
  public int getOrientation()
  {
    return mPrintHelper.getOrientation();
  }
  
  public int getScaleMode()
  {
    return mPrintHelper.getScaleMode();
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap, final PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    PrintHelperKitkat.OnPrintFinishCallback local1 = null;
    if (paramOnPrintFinishCallback != null) {
      local1 = new PrintHelperKitkat.OnPrintFinishCallback()
      {
        public void onFinish()
        {
          paramOnPrintFinishCallback.onFinish();
        }
      };
    }
    mPrintHelper.printBitmap(paramString, paramBitmap, local1);
  }
  
  public void printBitmap(String paramString, Uri paramUri, final PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
    throws FileNotFoundException
  {
    PrintHelperKitkat.OnPrintFinishCallback local2 = null;
    if (paramOnPrintFinishCallback != null) {
      local2 = new PrintHelperKitkat.OnPrintFinishCallback()
      {
        public void onFinish()
        {
          paramOnPrintFinishCallback.onFinish();
        }
      };
    }
    mPrintHelper.printBitmap(paramString, paramUri, local2);
  }
  
  public void setColorMode(int paramInt)
  {
    mPrintHelper.setColorMode(paramInt);
  }
  
  public void setOrientation(int paramInt)
  {
    mPrintHelper.setOrientation(paramInt);
  }
  
  public void setScaleMode(int paramInt)
  {
    mPrintHelper.setScaleMode(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.print.PrintHelper.PrintHelperKitkatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */