package com.braincraft.social.activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.braincraft.social.R;

/**
 * Created by ADMIN on 11/5/2018.
 */

public class ListDisplay extends AppCompatActivity {
    // Array of strings...
    String[] mobileArray = {"Push Notification","Block Users","Make my profile invisible","Help",
            "About Dateinvite","Privacy Policy","Terms and Conditions","Change Password","Log Out","","","","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Settings");


        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item
                String product = ((TextView) view).getText().toString();

                if(position==0)
                {
                    startActivity(new Intent(ListDisplay.this,PushNotification.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                else if(position==1)
                {
                    startActivity(new Intent(ListDisplay.this,BlockUser.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                else if(position==2)
                {

                }
                else if(position==3)
                {
                    startActivity(new Intent(ListDisplay.this,Help.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                else if(position==4)
                {
                    startActivity(new Intent(ListDisplay.this,About.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                else if(position==5)
                {
                    startActivity(new Intent(ListDisplay.this,Privacy.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                else if(position==6)
                {
                    startActivity(new Intent(ListDisplay.this,Terms.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                else if(position==7)
                {
                    startActivity(new Intent(ListDisplay.this,ChangePassword.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                else if(position==8)
                {
                    Intent i = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


                // Launching new Activity on selecting single List Item
              /*  Intent i = new Intent(getApplicationContext(), SingleListItem.class);
                // sending data to new activity
                i.putExtra("product", product);
                startActivity(i);*/

            }
        });
    }
}
