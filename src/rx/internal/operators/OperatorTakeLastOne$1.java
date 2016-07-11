package rx.internal.operators;

import rx.Producer;

class OperatorTakeLastOne$1
  implements Producer
{
  OperatorTakeLastOne$1(OperatorTakeLastOne paramOperatorTakeLastOne, OperatorTakeLastOne.ParentSubscriber paramParentSubscriber) {}
  
  public void request(long paramLong)
  {
    val$parent.requestMore(paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTakeLastOne.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */