package rx.internal.operators;

import rx.Producer;

class OperatorSwitch$SwitchSubscriber$1
  implements Producer
{
  OperatorSwitch$SwitchSubscriber$1(OperatorSwitch.SwitchSubscriber paramSwitchSubscriber) {}
  
  public void request(long paramLong)
  {
    if (this$0.infinite) {
      return;
    }
    if (paramLong == Long.MAX_VALUE) {
      this$0.infinite = true;
    }
    for (;;)
    {
      synchronized (this$0.guard)
      {
        OperatorSwitch.SwitchSubscriber.InnerSubscriber localInnerSubscriber = this$0.currentSubscriber;
        if (this$0.currentSubscriber == null)
        {
          l = this$0.initialRequested + paramLong;
          if (l < 0L)
          {
            this$0.infinite = true;
            if (localInnerSubscriber == null) {
              break;
            }
            if (!this$0.infinite) {
              break label173;
            }
            localInnerSubscriber.requestMore(Long.MAX_VALUE);
            return;
          }
          this$0.initialRequested = l;
        }
      }
      long l = OperatorSwitch.SwitchSubscriber.InnerSubscriber.access$100(this$0.currentSubscriber) + paramLong;
      if (l < 0L) {
        this$0.infinite = true;
      } else {
        OperatorSwitch.SwitchSubscriber.InnerSubscriber.access$102(this$0.currentSubscriber, l);
      }
    }
    label173:
    ((OperatorSwitch.SwitchSubscriber.InnerSubscriber)localObject2).requestMore(paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSwitch.SwitchSubscriber.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */