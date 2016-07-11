package rx.internal.operators;

import rx.functions.Action0;

class OperatorWindowWithTime$InexactSubscriber$2
  implements Action0
{
  OperatorWindowWithTime$InexactSubscriber$2(OperatorWindowWithTime.InexactSubscriber paramInexactSubscriber, OperatorWindowWithTime.CountedSerializedSubject paramCountedSerializedSubject) {}
  
  public void call()
  {
    this$1.terminateChunk(val$chunk);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.InexactSubscriber.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */