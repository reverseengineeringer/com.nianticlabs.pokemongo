package rx.internal.operators;

import rx.Producer;

final class OperatorConcat$ConcatProducer<T>
  implements Producer
{
  final OperatorConcat.ConcatSubscriber<T> cs;
  
  OperatorConcat$ConcatProducer(OperatorConcat.ConcatSubscriber<T> paramConcatSubscriber)
  {
    cs = paramConcatSubscriber;
  }
  
  public void request(long paramLong)
  {
    OperatorConcat.ConcatSubscriber.access$100(cs, paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorConcat.ConcatProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */