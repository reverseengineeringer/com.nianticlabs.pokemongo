package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Func3;

abstract interface OperatorTimeoutBase$FirstTimeoutStub<T>
  extends Func3<OperatorTimeoutBase.TimeoutSubscriber<T>, Long, Scheduler.Worker, Subscription>
{}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorTimeoutBase.FirstTimeoutStub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */