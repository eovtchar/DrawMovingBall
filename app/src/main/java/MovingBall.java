package ee.eovchar.drawmovingball;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

public class MovingBall extends View

{
    private Paint canvasPaint;
    private Handler h;
    private int scene_width;
    private int scene_height;
    private Bitmap mBitmap;
    private Paint mPaint = new Paint();
    private int pictWidth;
    private int pictHeight;

    private int x = 50;
    private int y = 50;
    private int circleRadius = 50;
    //na skolko warik budet peremewatsja
    private int dx = 15;
    private int dy = 15;
    //final - ozna4aet 4to pomenjat ee v programme ja ne mogy
    private final int FRAME_RATE = 10;

    public MovingBall(Context context, int start_x, int start_y)
    {
        super(context);
        h = new Handler();

        x = start_x;
        y = start_y;

        // Выводим значок из ресурсов
        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.ball);
        pictWidth = mBitmap.getWidth();
        pictHeight = mBitmap.getHeight();

        canvasPaint = new Paint();

        canvasPaint.setStyle(Paint.Style.FILL);
        canvasPaint.setColor(Color.WHITE);
    }

    private Runnable r = new Runnable()
    {
        @Override
        public void run()
        {
            invalidate();
        }
    };

    @Override
    protected void onDraw(Canvas sceneCanvas)
    {
        super.onDraw(sceneCanvas);
        sceneCanvas.drawPaint(canvasPaint);

        sceneCanvas.drawBitmap(mBitmap,x,y,mPaint);
        x = x + dx;
        y += dy; // y = y + dy

        if (x>scene_width - pictWidth || x < 0)
        {
            dx = dx * -1;
        }
        if (y>scene_height - pictHeight || y < 0)
        {
            dy = dy * -1;
        }

        h.postDelayed(r, FRAME_RATE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldWidth, int oldHeight)
    {
        super.onSizeChanged(w, h, oldWidth, oldHeight);
        scene_width = this.getWidth();
        scene_height = this.getHeight();
    }

}
