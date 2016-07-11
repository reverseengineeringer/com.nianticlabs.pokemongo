package rx;

import rx.functions.Func1;

public abstract interface Observable$Operator<R, T>
  extends Func1<Subscriber<? super R>, Subscriber<? super T>>
{}

/* Location:
 * Qualified Name:     rx.Observable.Operator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */