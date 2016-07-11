package rx.internal.operators;

import rx.Observable;
import rx.functions.Func0;

class OperatorBufferWithSingleObservable$1
  implements Func0<Observable<? extends TClosing>>
{
  OperatorBufferWithSingleObservable$1(OperatorBufferWithSingleObservable paramOperatorBufferWithSingleObservable, Observable paramObservable) {}
  
  public Observable<? extends TClosing> call()
  {
    return val$bufferClosing;
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSingleObservable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */