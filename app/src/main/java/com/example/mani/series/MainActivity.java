package com.example.mani.series;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ScrollView scw;
    private LinearLayout seriesLayout;
    private Context mCont;
    private ArrayList<Series> series_array;
    private int nSeries;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCont = this;
        seriesLayout = (LinearLayout) findViewById(R.id.seriesLayout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nSeries = 0;
        series_array = new ArrayList<Series>();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog ins = new Dialog(mCont);
                ins.setContentView(R.layout.insert_dialog);
                ins.setTitle("Insert new series");
                ins.show();
                final Button dialogOk = (Button) ins.findViewById(R.id.dialogButtonOK);
                dialogOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText tit = (EditText)ins.findViewById(R.id.dialogTitle);
                        String title = (String) tit.getText().toString();

                        EditText seas = (EditText) ins.findViewById(R.id.dialogSeason);
                        int season = Integer.parseInt((String) seas.getText().toString());

                        EditText ep = (EditText) ins.findViewById(R.id.dialogEpisode);
                        int episode = Integer.parseInt((String)ep.getText().toString());

                        series_array.add(nSeries, new Series(mCont, seriesLayout, title, season, episode));
                        nSeries++;

                        ins.dismiss();
                    }
                });

                final Button dialogCancel = (Button) ins.findViewById(R.id.dialogButtonCancel);
                dialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ins.dismiss();
                    }
                });
            }
        });



        Series a = new Series(mCont, seriesLayout, "Ciao belliffimo", 6, 1);

        /*Button b = new Button(this);
        b.setText("hola");
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        seriesLayout.addView(b, lp);*/

        /*FrameLayout fl = new FrameLayout(this);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 380);
        fl.setBackgroundResource(R.drawable.layout_border);
        //fl.setMinimumHeight(380);
        fl.setLayoutParams(lp);

        TextView title = new TextView(this);
        title.setText("nuova serie bajisjioahjieo");
        title.setGravity(Gravity.TOP | Gravity.LEFT);
        fl.addView(title);

        TextView season = new TextView(this);
        season.setText("Season:");
        season.setGravity(Gravity.CENTER | Gravity.LEFT);
        fl.addView(season);

        TextView episode = new TextView(this);
        episode.setText("Episode:");
        episode.setGravity(Gravity.BOTTOM | Gravity.LEFT);
        fl.addView(episode);

        InputFilter[] filtrino = new InputFilter[1];
        filtrino[0]=new InputFilter.LengthFilter(4);

        FrameLayout.LayoutParams lpS = new FrameLayout.LayoutParams (FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        EditText txtSeason = new EditText(this);
        //txtSeason.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        txtSeason.setFilters(filtrino);
        txtSeason.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        txtSeason.setInputType(InputType.TYPE_CLASS_NUMBER);
        lpS.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL;
        lpS.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        lpS.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        txtSeason.setMinWidth(150);
        txtSeason.setLayoutParams(lpS);
        fl.addView(txtSeason);

        FrameLayout.LayoutParams lpE = new FrameLayout.LayoutParams (FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        EditText txtEpisode = new EditText(this);
        //txtEpisode.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        txtEpisode.setFilters(filtrino);
        txtEpisode.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        txtEpisode.setInputType(InputType.TYPE_CLASS_NUMBER);
        lpE.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        lpE.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        lpE.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        txtEpisode.setMinWidth(150);
        txtEpisode.setLayoutParams(lpE);
        fl.addView(txtEpisode);

        FrameLayout.LayoutParams lpBS = new FrameLayout.LayoutParams (FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        Button save = new Button(this);
        save.setText("Save");
        lpBS.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;
        lpBS.height = 115;
        save.setLayoutParams(lpBS);
        fl.addView(save);

        FrameLayout.LayoutParams lpTB = new FrameLayout.LayoutParams (FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        ToggleButton finish = new ToggleButton(this);
        finish.setTextOff("Not finish");
        finish.setTextOn("Finished");
        finish.setChecked(false);
        lpTB.height = 115;
        lpTB.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        finish.setLayoutParams(lpTB);
        fl.addView(finish);

        seriesLayout.addView(fl);*/
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.mani.series/http/host/path")
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
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.mani.series/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
