package com.braincraft.social.activity;

import android.content.Intent;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.braincraft.social.R;

/**
 * Created by ADMIN on 11/5/2018.
 */

public class AndroidListViewActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.terms);
        // storing string resources into Array
        String[] adobe_products = getResources().getStringArray(R.array.adobe_products);

        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, adobe_products));

        ListView lv = getListView();

        // listening to single list item on click
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item
                String product = ((TextView) view).getText().toString();

                if(position==0)
                {
                    startActivity(new Intent(AndroidListViewActivity.this,PushNotification.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
               else if(position==1)
                {
                    startActivity(new Intent(AndroidListViewActivity.this,BlockUser.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                else if(position==2)
                {

                }
                else if(position==3)
                {
                    startActivity(new Intent(AndroidListViewActivity.this,Help.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                else if(position==4)
                {
                    startActivity(new Intent(AndroidListViewActivity.this,About.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                else if(position==5)
                {
                    startActivity(new Intent(AndroidListViewActivity.this,Privacy.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                else if(position==6)
                {
                    startActivity(new Intent(AndroidListViewActivity.this,Terms.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                else if(position==7)
                {
                    startActivity(new Intent(AndroidListViewActivity.this,ChangePassword.class));
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