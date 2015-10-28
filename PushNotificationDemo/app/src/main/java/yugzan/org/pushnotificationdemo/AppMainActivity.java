package yugzan.org.pushnotificationdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AppMainActivity extends AppCompatActivity {

    private TextView topinfo;
//    private EditText message;
//    private Button send;
    private String registerId;
    private String gcmMessage = "receiver message.";

    private void Setup(){
        topinfo = (TextView)findViewById(R.id.topinfo);
//        message = (EditText)findViewById(R.id.message);
//        send = (Button)findViewById(R.id.send);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);

        Setup();
        Bundle extras = (savedInstanceState != null)? savedInstanceState : getIntent().getExtras();

        gcmMessage = (extras != null)? extras.getString("message"): gcmMessage;

        PushGCM gcm = new PushGCM(this);
        gcm.openGCM();
        registerId =  gcm.getRegistrationId();
        topinfo.setText(gcmMessage);
        Log.i("regId", registerId);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, gcmMessage , Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_app_main, menu);
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case (PushReceiver.NOTIFICATION_ID) : {
                if (resultCode == Activity.RESULT_OK) {
                    // your stuff


                }
                break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

