package com.bpc.nopphon.bpc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    int fl=2;
    int tmpFl;
    public static final String FL_LENGTH = "Float_Length";
    public static final String BPC_UI = "UI_Type";

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences FLOAT_LONG = getSharedPreferences(FL_LENGTH, MODE_PRIVATE);
        SharedPreferences UI_TYPE = getSharedPreferences(BPC_UI, MODE_PRIVATE);

        int UI = UI_TYPE.getInt(BPC_UI,1);
        int restoredFL = FLOAT_LONG.getInt(FL_LENGTH,2);

        fl = restoredFL;

        if(UI == 1)
        {
            setContentView(R.layout.activity_main);
        }
        else if(UI == 2)
        {
            setContentView(R.layout.widget);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void calc(View v){
        EditText gotED = (EditText)findViewById(R.id.got);
        EditText fullED = (EditText)findViewById(R.id.full);
        EditText percentED = (EditText)findViewById(R.id.percent);
        RadioGroup selected = (RadioGroup)findViewById(R.id.radioGroup);

        int select = selected.getCheckedRadioButtonId();

        double a,b,sum;
        switch (select){
            case R.id.tickPercent:
                try {
                    String got = gotED.getText().toString();
                    a = Double.parseDouble(got);

                    String full = fullED.getText().toString();
                    b = Double.parseDouble(full);

                    sum = (a/b)*100;
                    if(fl==0){
                        percentED.setText(String.format("%.0f", sum));
                    }
                    else if(fl == 1){
                        percentED.setText(String.format("%.1f", sum));
                    }
                    else if(fl == 2){
                        percentED.setText(String.format("%.2f", sum));
                    }
                    else if(fl == 3){
                        percentED.setText(String.format("%.3f", sum));
                    }
                    else if(fl == 4){
                        percentED.setText(String.format("%.4f", sum));
                    }
                    else if(fl == 5){
                        percentED.setText(String.format("%.5f", sum));
                    }
                    else if(fl == 6){
                        percentED.setText(String.format("%.6f", sum));
                    }
                    else if(fl == 7){
                        percentED.setText(String.format("%.7f", sum));
                    }
                    else if(fl == 8){
                        percentED.setText(String.format("%.8f", sum));
                    }
                    else if(fl == 9){
                        percentED.setText(String.format("%.9f", sum));
                    }
                    else if(fl == 10){
                        percentED.setText(String.format("%.10f", sum));
                    }
                    else if(fl == 11){
                        percentED.setText(String.format("%.11f", sum));
                    }
                    else if(fl == 12){
                        percentED.setText(String.format("%.12f", sum));
                    }
                    else if(fl == 13){
                        percentED.setText(String.format("%.13f", sum));
                    }
                    else if(fl == 14){
                        percentED.setText(Double.toString(sum));
                    }
                    percentED.setTextColor(Color.parseColor("#FFBC0000"));
                    gotED.setTextColor(Color.parseColor("#ff000000"));
                    fullED.setTextColor(Color.parseColor("#ff000000"));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        getWindow().setStatusBarColor(Color.parseColor("#ff00840f"));

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "ไม่สามารถคำนวณได้ ข้อมูลไม่ถูกต้อง",
                            Toast.LENGTH_SHORT).show();
                    gotED.setTextColor(Color.parseColor("#ff000000"));
                    fullED.setTextColor(Color.parseColor("#ff000000"));
                    percentED.setTextColor(Color.parseColor("#ff000000"));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        getWindow().setStatusBarColor(Color.parseColor("#ff8c0003"));
                }
                break;
            case R.id.tickFull:
                try {
                    String got = gotED.getText().toString();
                    a = Double.parseDouble(got);

                    String percent = percentED.getText().toString();
                    b = Double.parseDouble(percent);

                    sum = (a/b)*100;
                    if(fl==0){
                        fullED.setText(String.format("%.0f", sum));
                    }
                    else if(fl == 1){
                        fullED.setText(String.format("%.1f", sum));
                    }
                    else if(fl == 2){
                        fullED.setText(String.format("%.2f", sum));
                    }
                    else if(fl == 3){
                        fullED.setText(String.format("%.3f", sum));
                    }
                    else if(fl == 4){
                        fullED.setText(String.format("%.4f", sum));
                    }
                    else if(fl == 5){
                        fullED.setText(String.format("%.5f", sum));
                    }
                    else if(fl == 6){
                        fullED.setText(String.format("%.6f", sum));
                    }
                    else if(fl == 7){
                        fullED.setText(String.format("%.7f", sum));
                    }
                    else if(fl == 8){
                        fullED.setText(String.format("%.8f", sum));
                    }
                    else if(fl == 9){
                        fullED.setText(String.format("%.9f", sum));
                    }
                    else if(fl == 10){
                        fullED.setText(String.format("%.10f", sum));
                    }
                    else if(fl == 11){
                        fullED.setText(String.format("%.11f", sum));
                    }
                    else if(fl == 12){
                        fullED.setText(String.format("%.12f", sum));
                    }
                    else if(fl == 13){
                        fullED.setText(String.format("%.13f", sum));
                    }
                    else if(fl == 14){
                        fullED.setText(Double.toString(sum));
                    }
                    fullED.setTextColor(Color.parseColor("#FFBC0000"));
                    gotED.setTextColor(Color.parseColor("#ff000000"));
                    percentED.setTextColor(Color.parseColor("#ff000000"));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        getWindow().setStatusBarColor(Color.parseColor("#ff00840f"));

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "ไม่สามารถคำนวณได้ ข้อมูลไม่ถูกต้อง",
                            Toast.LENGTH_SHORT).show();
                    gotED.setTextColor(Color.parseColor("#ff000000"));
                    fullED.setTextColor(Color.parseColor("#ff000000"));
                    percentED.setTextColor(Color.parseColor("#ff000000"));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        getWindow().setStatusBarColor(Color.parseColor("#ff8c0003"));
                }
                break;
            case R.id.tickGot:
                try {
                    String full = fullED.getText().toString();
                    a = Double.parseDouble(full);

                    String percent = percentED.getText().toString();
                    b = Double.parseDouble(percent);

                    sum = (a*b)/100;

                    if(fl==0){
                        gotED.setText(String.format("%.0f", sum));
                    }
                    else if(fl == 1){
                        gotED.setText(String.format("%.1f", sum));
                    }
                    else if(fl == 2){
                        gotED.setText(String.format("%.2f", sum));
                    }
                    else if(fl == 3){
                        gotED.setText(String.format("%.3f", sum));
                    }
                    else if(fl == 4){
                        gotED.setText(String.format("%.4f", sum));
                    }
                    else if(fl == 5){
                        gotED.setText(String.format("%.5f", sum));
                    }
                    else if(fl == 6){
                        gotED.setText(String.format("%.6f", sum));
                    }
                    else if(fl == 7){
                        gotED.setText(String.format("%.7f", sum));
                    }
                    else if(fl == 8){
                        gotED.setText(String.format("%.8f", sum));
                    }
                    else if(fl == 9){
                        gotED.setText(String.format("%.9f", sum));
                    }
                    else if(fl == 10){
                        gotED.setText(String.format("%.10f", sum));
                    }
                    else if(fl == 11){
                        gotED.setText(String.format("%.11f", sum));
                    }
                    else if(fl == 12){
                        gotED.setText(String.format("%.12f", sum));
                    }
                    else if(fl == 13){
                        gotED.setText(String.format("%.13f", sum));
                    }
                    else if(fl == 14){
                        gotED.setText(Double.toString(sum));
                    }
                    gotED.setTextColor(Color.parseColor("#FFBC0000"));
                    fullED.setTextColor(Color.parseColor("#ff000000"));
                    percentED.setTextColor(Color.parseColor("#ff000000"));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        getWindow().setStatusBarColor(Color.parseColor("#ff00840f"));

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "ไม่สามารถคำนวณได้ ข้อมูลไม่ถูกต้อง",
                            Toast.LENGTH_SHORT).show();
                    gotED.setTextColor(Color.parseColor("#ff000000"));
                    fullED.setTextColor(Color.parseColor("#ff000000"));
                    percentED.setTextColor(Color.parseColor("#ff000000"));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                        getWindow().setStatusBarColor(Color.parseColor("#ff8c0003"));
                }
                break;
        }
    }

    public void clr(View V){
        EditText got = (EditText)findViewById(R.id.got);
        EditText full = (EditText)findViewById(R.id.full);
        EditText percent = (EditText)findViewById(R.id.percent);

        got.setTextColor(Color.parseColor("#ff000000"));
        full.setTextColor(Color.parseColor("#ff000000"));
        percent.setTextColor(Color.parseColor("#ff000000"));
        got.setText("");
        full.setText("");
        percent.setText("");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(Color.parseColor("#ff00840f"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    //Set Seekbar adjustment
        int id = item.getItemId();

        //All sharedPreference declare here
        final SharedPreferences.Editor FL_EDIT = getSharedPreferences(FL_LENGTH, MODE_PRIVATE).edit(); //Length Adjust

        //SeekBar Length adjust
        AlertDialog.Builder adjust = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View layoutFromInflater = inflater.inflate(R.layout.dialog, null);
        adjust.setView(layoutFromInflater);
        adjust.setTitle("เลื่อนเพื่อปรับทศนิยม ");
        adjust.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                fl = tmpFl;
                FL_EDIT.putInt(FL_LENGTH,tmpFl);
                FL_EDIT.apply();

            }
        });
        adjust.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            final AlertDialog diag = adjust.create();
            diag.show();
            final TextView status = (TextView) diag.findViewById(R.id.prog);
            SeekBar seek = (SeekBar) diag.findViewById(R.id.seek);
            seek.setMax(14);
            seek.setProgress(fl);
            if (fl != 14 && fl != 0) {
                status.setText("ปัจจุบัน " + fl + " ตำแหน่ง");
            } else if (fl == 0) {
                status.setText("ปัจจุบัน ไม่มีทศนิยม");
            } else if (fl == 14) {
                status.setText("ปัจจุบัน ทศนิยมแบบวิทยาศาสตร์");
            }


            seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (progress == 0) {
                        status.setText("ไม่มีทศนิยม");
                    } else if (progress > 0 && progress < 14) {
                        status.setText("ทศนิยม " + progress + " ตำแหน่ง");
                    } else if (progress == 14) {
                        status.setText("ทศนิยมแบบวิทยาศาสตร์");
                    }
                    tmpFl = progress;
                }

                public void onStartTrackingTouch(SeekBar arg0) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
            return true;
        }

        if (id == R.id.action_about) {
            AlertDialog.Builder diag2 = new AlertDialog.Builder(this);
            LayoutInflater aboutinf = getLayoutInflater();
            View layoutAb = aboutinf.inflate(R.layout.about, null);
            diag2.setTitle("เกี่ยวกับ");
            diag2.setNegativeButton("เข้าใจแล้ว", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            diag2.setView(layoutAb);
            AlertDialog about = diag2.create();
            about.show();
            return true;
        }

        if (id == R.id.ui_selection) {
            Intent ui = new Intent(this,UI_select.class);
            startActivity(ui);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }
