package com.example.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String wordClicked = "";
    boolean fDBS = false;
    boolean fOCBC = false;
    boolean fUOB = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_language, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (v == tvDBS) {
            wordClicked = "DBS";
        } else if (v == tvOCBC) {
            wordClicked = "OCBC";
        } else if (v == tvUOB) {
            wordClicked = "UOB";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (id == R.id.WebsiteSelection) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(i);


            } else if (id == R.id.ContactSelection) {
                Intent iCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18001111111l));
                startActivity(iCall);

            } else if (id == R.id.favouriteSelection) {
                if (!fDBS) {
                    fDBS = true;
                    tvDBS.setTextColor(Color.RED);
                } else {
                    fDBS = false;
                    tvDBS.setTextColor(Color.BLACK);
                }
            }

        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (id == R.id.WebsiteSelection) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(i);

            } else if (id == R.id.ContactSelection) {
                Intent iCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18003633333l));
                startActivity(iCall);

            } else if (id == R.id.favouriteSelection) {
                if (!fOCBC) {
                    fOCBC = true;
                    tvOCBC.setTextColor(Color.RED);
                } else {
                    fOCBC = false;
                    tvOCBC.setTextColor(Color.BLACK);
                }
            }

        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (id == R.id.WebsiteSelection) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(i);

            } else if (id == R.id.ContactSelection) {
                Intent iCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 18002222121l));
                startActivity(iCall);

            } else if (id == R.id.favouriteSelection) {
                if (!fUOB) {
                    fUOB = true;
                    tvUOB.setTextColor(Color.RED);
                } else {
                    fUOB = false;
                    tvUOB.setTextColor(Color.BLACK);
                }
            }
        }
        return super.onContextItemSelected(item);
    }

}