package fi.ptm.checkradiotogglebuttonsexample;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 *
 * @author PTM
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // listen checked changes on Switch
        Switch switchButton = (Switch) findViewById(R.id.toggleButton2);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
                if (isChecked) {
                    // Enable list
                    for(int i=0;i< rg.getChildCount();i++){
                        ((RadioButton)rg.getChildAt(i)).setEnabled(true);
                    }
                } else {
                    // Enable list
                    for(int i=0;i< rg.getChildCount();i++){
                        ((RadioButton)rg.getChildAt(i)).setEnabled(false);
                    }
                }
            }
        });
    }

    // following method handles the click event for checkboxes
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox_milk:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Yes Milk!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Why not Milk?", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox_beers:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Yes Beers!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Why not Beers?", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox_tee:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Yes Tee!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Why not Tee?", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // following method handles the click event for radio buttons
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton_yes:
                if (checked) Toast.makeText(getApplicationContext(), "Ok lets buy those!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton_maybe:
                if (checked) Toast.makeText(getApplicationContext(), "Not sure??", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton_no:
                if (checked) Toast.makeText(getApplicationContext(), "Oh - leave those...", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // following method handles the click event for toggle button
    public void onToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        CheckBox milk = (CheckBox) findViewById(R.id.checkBox_milk);
        CheckBox beers = (CheckBox) findViewById(R.id.checkBox_beers);
        CheckBox tee = (CheckBox) findViewById(R.id.checkBox_tee);
        // enable or disable checkboxes
        if (on) {
            // Enable list
            milk.setEnabled(true);
            beers.setEnabled(true);
            tee.setEnabled(true);
        } else {
            // Disable list
            milk.setEnabled(false);
            beers.setEnabled(false);
            tee.setEnabled(false);
        }
    }


}
