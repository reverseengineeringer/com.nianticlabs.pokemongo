package rx.schedulers;

import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.MultipleAssignmentSubscription;

class ExecutorScheduler$ExecutorSchedulerWorker$1
  implements Action0
{
  ExecutorScheduler$ExecutorSchedulerWorker$1(ExecutorScheduler.ExecutorSchedulerWorker paramExecutorSchedulerWorker, MultipleAssignmentSubscription paramMultipleAssignmentSubscription) {}
  
  public void call()
  {
    this$0.tasks.remove(val$mas);
  }
}

/* Location:
 * Qualified Name:     rx.schedulers.ExecutorScheduler.ExecutorSchedulerWorker.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */