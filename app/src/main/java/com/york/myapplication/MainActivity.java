package com.york.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import com.google.android.material.snackbar.Snackbar;
import com.york.myapplication.network.NetworkActivity;
import com.york.myapplication.recycler.RcyclerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Button btn = findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("App", "Button clicked!!!");
//                Toast.makeText(MainActivity.this, "Btn Clicked", Toast.LENGTH_LONG).show();
//                Snackbar.make(v, "Btn Clicked", Snackbar.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);

                Bundle parameters = new Bundle();
                intent.putExtras(parameters);

                parameters.putString("name", "Vassilis");
                intent.putExtra("name", "Vassilis");
                intent.putExtra("age", 100);
                startActivityForResult(intent, 5000);
            }
        });

        Button btnContact = findViewById(R.id.btn_contact);
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_CALL);
//                intent.setData(Uri.parse("tel:+306936249616"));
//                startActivity(intent);

                Intent intent = new Intent(MainActivity.this, NetworkActivity.class);
                startActivity(intent);
                //composeEmail(new String[]{"a@a.com"}, "");
            }
        });

        Button btnRecycler = findViewById(R.id.btn_recycler);
        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RcyclerActivity.class);
                startActivity(intent);
            }
        });

        TextView txt = findViewById(R.id.txn_title);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("App", "TextView clicked!!!");
                Toast.makeText(MainActivity.this, "TextView Clicked", Toast.LENGTH_LONG).show();
                Snackbar.make(v, "TextView Clicked", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null) {
            return;
        }

        String name = data.getStringExtra("name");
        int age = data.getIntExtra("age", -1);

        if (age > 0) {

        }
    }

    public void composeEmail(String[] addresses, String subject) {

        ShareCompat.IntentBuilder.from(this)
                .setType("message/rfc822")
                .addEmailTo(addresses)
                .setSubject(subject)
                .setText("")
                //.setHtmlText(body) //If you are using HTML in your body text
                .setChooserTitle("Select Email client")
                .startChooser();


//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
//        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
    }
}