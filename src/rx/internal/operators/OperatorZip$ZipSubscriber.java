package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

final class OperatorZip$ZipSubscriber
  extends Subscriber<Observable[]>
{
  final Subscriber<? super R> child;
  final OperatorZip.ZipProducer<R> producer;
  boolean started = false;
  final OperatorZip.Zip<R> zipper;
  
  public OperatorZip$ZipSubscriber(Subscriber<? super R> paramSubscriber, OperatorZip.Zip<R> paramZip, OperatorZip.ZipProducer<R> paramZipProducer)
  {
    super(paramZip);
    child = paramZip;
    zipper = paramZipProducer;
    OperatorZip.ZipProducer localZipProducer;
    producer = localZipProducer;
  }
  
  public void onCompleted()
  {
    if (!started) {
      child.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    child.onError(paramThrowable);
  }
  
  public void onNext(Observable[] paramArrayOfObservable)
  {
    if ((paramArrayOfObservable == null) || (paramArrayOfObservable.length == 0))
    {
      child.onCompleted();
      return;
    }
    started = true;
    zipper.start(paramArrayOfObservable, producer);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorZip.ZipSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */