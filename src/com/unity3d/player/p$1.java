package com.unity3d.player;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import java.util.Queue;

final class p$1
  implements Runnable
{
  p$1(p paramp) {}
  
  private static void a(View paramView, MotionEvent paramMotionEvent)
  {
    if (q.b) {
      q.j.a(paramView, paramMotionEvent);
    }
  }
  
  public final void run()
  {
    for (;;)
    {
      MotionEvent localMotionEvent = (MotionEvent)p.a(a).poll();
      if (localMotionEvent == null) {
        break;
      }
      View localView = p.b(a).getWindow().getDecorView();
      int i = localMotionEvent.getSource();
      if ((i & 0x2) != 0) {
        switch (localMotionEvent.getAction() & 0xFF)
        {
        default: 
          a(localView, localMotionEvent);
          break;
        case 0: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
          localView.dispatchTouchEvent(localMotionEvent);
          break;
        }
      } else if ((i & 0x4) != 0) {
        localView.dispatchTrackballEvent(localMotionEvent);
      } else {
        a(localView, localMotionEvent);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.p.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */