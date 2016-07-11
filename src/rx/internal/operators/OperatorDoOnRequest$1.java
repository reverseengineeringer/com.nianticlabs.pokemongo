package rx.internal.operators;

import rx.Producer;
import rx.functions.Action1;

class OperatorDoOnRequest$1
  implements Producer
{
  OperatorDoOnRequest$1(OperatorDoOnRequest paramOperatorDoOnRequest, OperatorDoOnRequest.ParentSubscriber paramParentSubscriber) {}
  
  public void request(long paramLong)
  {
    OperatorDoOnRequest.access$100(this$0).call(Long.valueOf(paramLong));
    OperatorDoOnRequest.ParentSubscriber.access$200(val$parent, paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorDoOnRequest.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */