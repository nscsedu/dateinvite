package com.braincraft.social.dateinvite;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.braincraft.social.R;
import com.braincraft.social.activity.ContactAdmin;
import com.braincraft.social.activity.SettingsActivity;
import com.braincraft.social.activity.MessageText;
import com.braincraft.social.activity.VideoMessage;
import com.braincraft.social.activity.Liked;
import com.braincraft.social.activity.LikedMe;
import com.braincraft.social.dateinvite.*;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static com.braincraft.social.activity.InformationActivity.selectedItemText;

public class MainTest extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    private ImageView settings;
    private LinearLayout messages,videomessages,likedme,liked;
    private ImageView likedandme,normalmessage,videomessage,goprofile;
    private TextView contact_admin,go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_test);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



      /*  setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("androidtest123");*/

        contact_admin=(TextView) findViewById(R.id.contact_admin);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        View header = navigationView.getHeaderView(0);
        settings = (ImageView) header.findViewById(R.id.settings);
        messages = (LinearLayout) header.findViewById(R.id.messages);

        liked = (LinearLayout) header.findViewById(R.id.liked);
        likedme = (LinearLayout) header.findViewById(R.id.likedme) ;
        videomessages = (LinearLayout) header.findViewById(R.id.videomessages);



        normalmessage=(ImageView) toolbar.findViewById(R.id.normalmessage) ;
       videomessage=(ImageView) toolbar.findViewById(R.id.videomessage) ;
        likedandme=(ImageView)toolbar.findViewById(R.id.likedandme) ;
       goprofile=(ImageView) toolbar.findViewById(R.id.goprofile) ;
        go=(TextView) header.findViewById(R.id.go) ;

        settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(MainTest.this,SettingsActivity.class));

            }
        });

       /* messages.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(MainTest.this, com.braincraft.social.dateinvite.LoginActivity.class));

            }
        });*/
        contact_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(MainTest.this,ContactAdmin.class));

            }
        });
      likedme.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(MainTest.this,LikedMe.class));

            }
        });
        liked.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(MainTest.this,Liked.class));

            }
        });

        videomessages.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(MainTest.this,VideoMessage.class));

            }
        });

        contact_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText
                        (getApplicationContext(), "Selected123 : " + selectedItemText, Toast.LENGTH_SHORT)
                        .show();

                startActivity(new Intent(MainTest.this,ContactAdmin.class));

            }
        });


       go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(MainTest.this,Invite.class));

            }
        });





        /*normalmessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(MainTest.this,MessageText.class));

            }
        });*/

/*
        normalmessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(MainTest.this,MessageText.class));

            }
        });
       likedandme.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(MainTest.this,LikedMe.class));

            }
        });


       videomessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(MainTest.this,VideoMessage.class));

            }
        });


        goprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(MainTest.this,Invite.class));

            }
        });*/

        /*ImageView ib = (ImageView)navigationView.findViewById(R.id.settings);
        ib.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                //startActivity(new Intent(MainTest.this,CardActivity.class));

            }
        });*/




        //initCollapsingToolbar();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new MainTest.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        /*try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar1 if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar1 item clicks here. The action bar1 will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.normalmessage) {
            startActivity(new Intent(MainTest.this,MessageText.class));
            return true;
        }*/


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       /* if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(MainTest.this,PushNotification.class));

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }*/
        /*else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        Album a = new Album("True Romance", "New York", covers[0]);
        albumList.add(a);

        a = new Album("Xscpae", "New York", covers[1]);
        albumList.add(a);

        a = new Album("Maroon 5", "New York", covers[2]);
        albumList.add(a);

        a = new Album("Born to Die", "New York", covers[3]);
        albumList.add(a);

        a = new Album("Honeymoon", "New York", covers[4]);
        albumList.add(a);

        a = new Album("I Need a Doctor", "New York", covers[5]);
        albumList.add(a);

        a = new Album("Loud", "New York", covers[6]);
        albumList.add(a);

        a = new Album("Legend", "New York", covers[7]);
        albumList.add(a);

        a = new Album("Hello", "New York", covers[8]);
        albumList.add(a);

        a = new Album("Greatest Hits", "New York", covers[9]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
