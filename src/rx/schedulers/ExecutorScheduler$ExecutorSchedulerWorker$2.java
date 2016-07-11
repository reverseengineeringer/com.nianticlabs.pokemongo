package rx.schedulers;

import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;
import rx.subscriptions.MultipleAssignmentSubscription;

class ExecutorScheduler$ExecutorSchedulerWorker$2
  implements Action0
{
  ExecutorScheduler$ExecutorSchedulerWorker$2(ExecutorScheduler.ExecutorSchedulerWorker paramExecutorSchedulerWorker, MultipleAssignmentSubscription paramMultipleAssignmentSubscription, Action0 paramAction0, Subscription paramSubscription) {}
  
  public void call()
  {
    if (val$mas.isUnsubscribed()) {}
    Subscription localSubscription;
    do
    {
      return;
      localSubscription = this$0.schedule(val$action);
      val$mas.set(localSubscription);
    } while (localSubscription.getClass() != ScheduledAction.class);
    ((ScheduledAction)localSubscription).add(val$removeMas);
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.ExecutorScheduler.ExecutorSchedulerWorker.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */