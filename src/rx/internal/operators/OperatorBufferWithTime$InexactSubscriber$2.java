package rx.internal.operators;

import java.util.List;
import rx.functions.Action0;

class OperatorBufferWithTime$InexactSubscriber$2
  implements Action0
{
  OperatorBufferWithTime$InexactSubscriber$2(OperatorBufferWithTime.InexactSubscriber paramInexactSubscriber, List paramList) {}
  
  public void call()
  {
    this$1.emitChunk(val$chunk);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithTime.InexactSubscriber.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */