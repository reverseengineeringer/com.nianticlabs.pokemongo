package rx.internal.operators;

import rx.functions.Action0;

class BufferUntilSubscriber$OnSubscribeAction$1
  implements Action0
{
  BufferUntilSubscriber$OnSubscribeAction$1(BufferUntilSubscriber.OnSubscribeAction paramOnSubscribeAction) {}
  
  public void call()
  {
    this$0.state.observerRef = BufferUntilSubscriber.access$000();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.BufferUntilSubscriber.OnSubscribeAction.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */