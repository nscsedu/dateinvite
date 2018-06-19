package com.braincraft.social.dateinvite;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.Button;

/**
 * Created by ADMIN on 15/4/2018.
 */

public class Terms  extends AppCompatActivity {
    private Button submit, btnlogin_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terms);


        btnlogin_submit = (Button) findViewById(R.id.button);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                startActivity(new Intent(Terms.this,RegistarActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        toolbar.setNavigationIcon(com.braincraft.social.R.drawable.back_icon);

    }
}