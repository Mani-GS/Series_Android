package com.example.mani.series;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Series {
    private Context cont;
    private LinearLayout seriesLayout;
    private FrameLayout lay;
    private TextView lblTitle, lblSeason, lblEpisode;
    private EditText txtSeason, txtEpisode;
    private Button btnSave;
    private ToggleButton btnFinish;
    private FrameLayout.LayoutParams lp, lpS, lpE, lpBS, lpTB;
    private InputFilter[] filters;

    private int season, episode;
    private String title;
    private boolean finish;

    Series(Context cont, LinearLayout seriesLayout, String title, int season , int episode){
        this.seriesLayout = seriesLayout;
        this.cont = cont;
        this.title = title;
        this.episode = episode;
        this.season = season;

        initGUI();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void initGUI(){
        lay = new FrameLayout(cont);
        lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 380);
        lay.setBackgroundResource(R.drawable.layout_border);
        lay.setLayoutParams(lp);

        lblTitle = new TextView(cont);
        lblTitle.setText(title);
        lblTitle.setGravity(Gravity.TOP | Gravity.LEFT);
        lay.addView(lblTitle);

        lblSeason = new TextView(cont);
        lblSeason.setText("Season:");
        lblSeason.setGravity(Gravity.CENTER | Gravity.LEFT);
        lay.addView(lblSeason);

        lblEpisode = new TextView(cont);
        lblEpisode.setText("Episode:");
        lblEpisode.setGravity(Gravity.BOTTOM | Gravity.LEFT);
        lay.addView(lblEpisode);

        filters = new InputFilter[1];
        filters[0]=new InputFilter.LengthFilter(4);

        lpS = new FrameLayout.LayoutParams (FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        txtSeason = new EditText(cont);
        txtSeason.setFilters(filters);
        txtSeason.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        txtSeason.setInputType(InputType.TYPE_CLASS_NUMBER);
        lpS.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL;
        lpS.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        lpS.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        txtSeason.setMinWidth(150);
        txtSeason.setLayoutParams(lpS);
        txtSeason.setText("" + season);
        lay.addView(txtSeason);

        lpE = new FrameLayout.LayoutParams (FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        txtEpisode = new EditText(cont);
        txtEpisode.setFilters(filters);
        txtEpisode.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        txtEpisode.setInputType(InputType.TYPE_CLASS_NUMBER);
        lpE.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        lpE.height = FrameLayout.LayoutParams.WRAP_CONTENT;
        lpE.width = FrameLayout.LayoutParams.WRAP_CONTENT;
        txtEpisode.setMinWidth(150);
        txtEpisode.setLayoutParams(lpE);
        txtEpisode.setText("" + episode);
        lay.addView(txtEpisode);

        lpBS = new FrameLayout.LayoutParams (FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        btnSave = new Button(cont);
        btnSave.setText("Save");
        lpBS.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;
        lpBS.height = 115;
        btnSave.setLayoutParams(lpBS);
        lay.addView(btnSave);

        lpTB = new FrameLayout.LayoutParams (FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        btnFinish = new ToggleButton(cont);
        btnFinish.setTextOff("Not finish");
        btnFinish.setTextOn("Finished");
        btnFinish.setChecked(false);
        lpTB.height = 115;
        lpTB.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        btnFinish.setLayoutParams(lpTB);
        lay.addView(btnFinish);

        seriesLayout.addView(lay);
    }
}
