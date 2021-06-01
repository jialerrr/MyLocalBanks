package rp.edu.sg.c346.id20021576.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvOCBC, tvDBS, tvUOB;

    String wordClicked = "";
    String visit= "Visit Website";
    String call = "Contact Bank";
    String fav= "Toggle Favourites";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvDBS = findViewById(R.id.tvDBS);
        tvUOB = findViewById(R.id.tvUOB);

        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,visit);
        menu.add(0,1,1,call);
        menu.add(0, 2, 2,fav);

        if (v == tvOCBC){
            wordClicked = "OCBC";
        } else if (v == tvDBS){
            wordClicked = "DBS";
        } else if (v == tvUOB){
            wordClicked = "UOB";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked == "OCBC") {
            if (item.getItemId() == 0) {

                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway"));
                startActivity(intentWeb);

                return true;
            } else if (item.getItemId() == 1) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentCall);

                return true;
            } else if (item.getItemId() == 2) {
                if (tvOCBC.getCurrentTextColor()==getResources().getColor(R.color.red)){
                    tvOCBC.setTextColor(getResources().getColor(R.color.black));
                } else {
                    tvOCBC.setTextColor(getResources().getColor(R.color.red));
                }

                return true;
            }
        } else if (wordClicked == "DBS") {
            if (item.getItemId() == 0) {

                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com/default.page"));
                startActivity(intentWeb);

                return true;
            } else if (item.getItemId() == 1) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1800222200"));
                startActivity(intentCall);

                return true;
            } else if (item.getItemId() == 2) {
                if (tvDBS.getCurrentTextColor()==getResources().getColor(R.color.red)){
                    tvDBS.setTextColor(getResources().getColor(R.color.black));
                } else {
                    tvDBS.setTextColor(getResources().getColor(R.color.red));
                }

                return true;
            }
        } else if (wordClicked == "UOB"){
            if (item.getItemId() == 0) {

                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg/"));
                startActivity(intentWeb);

                return true;
            } else if (item.getItemId() == 1) {

                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(intentCall);

                return true;
            } else if (item.getItemId() == 2) {
                if (tvUOB.getCurrentTextColor()==getResources().getColor(R.color.red)){
                    tvUOB.setTextColor(getResources().getColor(R.color.black));
                } else {
                    tvUOB.setTextColor(getResources().getColor(R.color.red));
                }

                return true;
            }
        }

        return super.onContextItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvOCBC.setText(getString(R.string.ocbc));
            tvDBS.setText(getString(R.string.dbs));
            tvUOB.setText(getString(R.string.uob));
            visit = getString(R.string.visit);
            call = getString(R.string.call);
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvOCBC.setText(R.string.chiOCBC);
            tvDBS.setText(R.string.chiDBS);
            tvUOB.setText(R.string.chiUOB);
            visit = getString(R.string.chiVisit);
            call = getString(R.string.chiDial);
            fav = getString(R.string.chiFav);
            return true;
        } else {
            tvOCBC.setText(R.string.error);
            tvDBS.setText(R.string.error);
            tvUOB.setText(R.string.error);
            visit = getString(R.string.error);
            call = getString(R.string.error);
            fav = getString(R.string.fav);
        }

        return super.onOptionsItemSelected(item);


    }
}