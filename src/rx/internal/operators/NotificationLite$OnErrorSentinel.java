package rx.internal.operators;

import java.io.Serializable;

class NotificationLite$OnErrorSentinel
  implements Serializable
{
  private static final long serialVersionUID = 3L;
  private final Throwable e;
  
  public NotificationLite$OnErrorSentinel(Throwable paramThrowable)
  {
    e = paramThrowable;
  }
  
  public String toString()
  {
    return "Notification=>Error:" + e;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.NotificationLite.OnErrorSentinel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */