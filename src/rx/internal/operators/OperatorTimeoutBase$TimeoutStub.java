package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Func4;

abstract interface OperatorTimeoutBase$TimeoutStub<T>
  extends Func4<OperatorTimeoutBase.TimeoutSubscriber<T>, Long, T, Scheduler.Worker, Subscription>
{}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimeoutBase.TimeoutStub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */