package ee.eovchar.drawmovingball;

import android.app.Activity;
import android.os.Bundle;

import ee.eovchar.drawmovingball.MovingBall;

public class MainActivity extends Activity
{
    private int start_x = 10;
    private int start_y = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovingBall movingBall = new MovingBall(this, start_x, start_y);
        setContentView(movingBall);
    }
}
