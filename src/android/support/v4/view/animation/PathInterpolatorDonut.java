package android.support.v4.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

class PathInterpolatorDonut
  implements Interpolator
{
  private static final float PRECISION = 0.002F;
  private final float[] mX;
  private final float[] mY;
  
  public PathInterpolatorDonut(float paramFloat1, float paramFloat2)
  {
    this(createQuad(paramFloat1, paramFloat2));
  }
  
  public PathInterpolatorDonut(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(createCubic(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  public PathInterpolatorDonut(Path paramPath)
  {
    paramPath = new PathMeasure(paramPath, false);
    float f = paramPath.getLength();
    int j = (int)(f / 0.002F) + 1;
    mX = new float[j];
    mY = new float[j];
    float[] arrayOfFloat = new float[2];
    int i = 0;
    while (i < j)
    {
      paramPath.getPosTan(i * f / (j - 1), arrayOfFloat, null);
      mX[i] = arrayOfFloat[0];
      mY[i] = arrayOfFloat[1];
      i += 1;
    }
  }
  
  private static Path createCubic(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0F, 1.0F);
    return localPath;
  }
  
  private static Path createQuad(float paramFloat1, float paramFloat2)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.quadTo(paramFloat1, paramFloat2, 1.0F, 1.0F);
    return localPath;
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    if (paramFloat >= 1.0F) {
      return 1.0F;
    }
    int i = 0;
    int j = mX.length - 1;
    while (j - i > 1)
    {
      int k = (i + j) / 2;
      if (paramFloat < mX[k]) {
        j = k;
      } else {
        i = k;
      }
    }
    float f = mX[j] - mX[i];
    if (f == 0.0F) {
      return mY[i];
    }
    paramFloat = (paramFloat - mX[i]) / f;
    f = mY[i];
    return (mY[j] - f) * paramFloat + f;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.animation.PathInterpolatorDonut
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */