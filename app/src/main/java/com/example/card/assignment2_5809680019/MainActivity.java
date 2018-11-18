package com.example.card.assignment2_5809680019;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int type = event.sensor.getType();
        float x,y,z;

        String[] goods = {"วันนี้คุณโชคดี ลองซื้อหวยสิ","ช่วงนี้เป็นขาขึ้นของคุณ","จากนี้ไปอีกสองอาทิตย์ ชีวิตคุณจะมีแต่ความสุข"};
        String[] fairs = {"ชีวิตคุณอยู่ในช่วงปกติ ไม่ดี ไม่ร้าย","จะดีไม่ดีอยู่ที่ตัวคุณ ดวงไม่ได้ช่วย","ชีวิตคุณปกติ"};
        String[] bads = {"ขอเตือนว่าอย่าออกจากบ้านช่วงนี้","หากไม่อยากซวย อย่าทำอะไรที่มีความเสี่ยง","ทำบุญก็ไม่ช่วย คุณกำลังอยู่ในช่วงขาลง"};


        if(type == Sensor.TYPE_ACCELEROMETER) {
            x=event.values[0];
            y=event.values[1];
            z=event.values[2];
            if(x > 20 || y > 20 || z > 20){
                Random rand = new Random();
                int typeOf = rand.nextInt(3);
                int index = rand.nextInt(3);

                String ans;
                if(typeOf == 0){
                    ans = goods[index];
                }
                else if(typeOf == 1){
                    ans = fairs[index];
                }
                else{
                    ans = bads[index];
                }

                TextView text=(TextView)findViewById(R.id.test);
                text.setText(ans);

            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
