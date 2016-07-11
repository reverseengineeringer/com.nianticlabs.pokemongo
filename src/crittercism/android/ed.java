package crittercism.android;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class ed
{
  public static final ed a = new ed();
  private ee b = new a((byte)0);
  private ThreadLocal c = new ThreadLocal();
  
  private SimpleDateFormat b()
  {
    SimpleDateFormat localSimpleDateFormat2 = (SimpleDateFormat)c.get();
    SimpleDateFormat localSimpleDateFormat1 = localSimpleDateFormat2;
    if (localSimpleDateFormat2 == null)
    {
      localSimpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);
      localSimpleDateFormat1.setTimeZone(TimeZone.getTimeZone("GMT"));
      localSimpleDateFormat1.setLenient(false);
      c.set(localSimpleDateFormat1);
    }
    return localSimpleDateFormat1;
  }
  
  public final long a(String paramString)
  {
    return b().parse(paramString).getTime();
  }
  
  public final String a()
  {
    return a(b.a());
  }
  
  public final String a(Date paramDate)
  {
    return b().format(paramDate);
  }
  
  final class a
    implements ee
  {
    private a() {}
    
    public final Date a()
    {
      return new Date();
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.ed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */