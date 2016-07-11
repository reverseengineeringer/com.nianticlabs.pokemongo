package rx.subjects;

import rx.functions.Action1;
import rx.internal.operators.NotificationLite;

final class AsyncSubject$1
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  AsyncSubject$1(SubjectSubscriptionManager paramSubjectSubscriptionManager) {}
  
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    Object localObject = val$state.get();
    NotificationLite localNotificationLite = val$state.nl;
    paramSubjectObserver.accept(localObject, localNotificationLite);
    if ((localObject == null) || ((!localNotificationLite.isCompleted(localObject)) && (!localNotificationLite.isError(localObject)))) {
      paramSubjectObserver.onCompleted();
    }
  }
}

/* Location:
 * Qualified Name:     rx.subjects.AsyncSubject.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */