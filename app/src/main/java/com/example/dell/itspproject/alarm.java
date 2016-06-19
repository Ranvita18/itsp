package com.example.dell.itspproject;

import android.app.Activity;
import android.app.AlarmManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.AlarmManager;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Calendar;


/**
 * Created by DELL on 19-06-2016.
 */

public class alarm extends Activity {
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView update_text;
    Context context;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);
        this.context = this;

        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarm_timepicker = (TimePicker) findViewById(R.id.timePicker2);

        update_text = (TextView) findViewById(R.id.update_text);

        final Calendar calendar = Calendar.getInstance();

        Button alarm_on = (Button) findViewById(R.id.alarm_on);

        Button alarm_off = (Button) findViewById(R.id.alarm_off);

        alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                set_alarm_text("Alarm On!");

            }
        });

        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());
                set_alarm_text("Alarm Off!");

            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void set_alarm_text(String output) {
        update_text.setText(output);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "alarm Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.dell.itspproject/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "alarm Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.dell.itspproject/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
