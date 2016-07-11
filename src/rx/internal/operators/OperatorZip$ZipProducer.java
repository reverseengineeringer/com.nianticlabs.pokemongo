package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

final class OperatorZip$ZipProducer<R>
  extends AtomicLong
  implements Producer
{
  private static final long serialVersionUID = -1216676403723546796L;
  private OperatorZip.Zip<R> zipper;
  
  public OperatorZip$ZipProducer(OperatorZip.Zip<R> paramZip)
  {
    zipper = paramZip;
  }
  
  public void request(long paramLong)
  {
    BackpressureUtils.getAndAddRequest(this, paramLong);
    zipper.tick();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorZip.ZipProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */