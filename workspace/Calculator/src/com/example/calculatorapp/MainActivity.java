package com.example.calculatorapp;

import com.cal.calculatorapp.R;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
 
public class MainActivity extends Activity {
 
	EditText txtNo1;
	EditText txtNo2;
	RadioGroup grpOperation;
	RadioButton rdAdd;
	RadioButton rdSub;
	RadioButton rdMul;
	Chronometer chrono;
 
	private String radioBtnValue = "add";
 
	private String result;
 
	TextView txtResult;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		chrono = (Chronometer) findViewById(R.id.chrono);
 
		//Start Chronometer
		startchronometer();
 
		txtNo2 = (EditText) findViewById(R.id.edtno2);
		txtNo1 = (EditText) findViewById(R.id.edtno1);
		txtResult = (TextView) findViewById(R.id.txtResult);
 
		txtNo2.addTextChangedListener(addthevaluesListerner);
 
		grpOperation = (RadioGroup) findViewById(R.id.rdgrpOps);
		rdAdd = (RadioButton) findViewById(R.id.rdAdd);
		rdSub = (RadioButton) findViewById(R.id.rdSub);
		rdMul = (RadioButton) findViewById(R.id.rdMul);
 
		addRadioChange();
 
	}
 
	private void startchronometer()
	{
 
		int millisecond=0;
		String chronotext = chrono.getText().toString();
 
		String array[] = chronotext.split(":");
 
		if(array.length == 2)
			millisecond = Integer.parseInt(array[0]) * 60 * 1000 +
					Integer.parseInt(array[1]) *1000;
 
		chrono.setBase(SystemClock.elapsedRealtime() - millisecond);
 
		chrono.start();
	}
 
	private void addRadioChange()
	{
		grpOperation.setOnCheckedChangeListener(new OnCheckedChangeListener() {
 
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				int id = grpOperation.getCheckedRadioButtonId();
				View rdView = grpOperation.findViewById(id);
				int radbuttonID = grpOperation.indexOfChild((rdView));
				RadioButton btn = (RadioButton) grpOperation.getChildAt(radbuttonID);
				radioBtnValue = (String)btn.getText();
				//Call the Update Text
				updatetext();
 
			}
		});
	}
 
	private TextWatcher addthevaluesListerner = new TextWatcher(){
 
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
 
		}
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
 
		}
 
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			try
			{
				result =s.toString();
			}
			catch (Exception e)
			{
			}
			updatetext();
		}
 
	};
 
	public void updatetext()
	{
		if(radioBtnValue.equalsIgnoreCase("add"))
			txtResult.setText(Integer.toString(Integer.parseInt(result) + Integer.parseInt(txtNo1.getText().toString())));
		else if (radioBtnValue.equalsIgnoreCase("sub"))
			txtResult.setText(Integer.toString(Integer.parseInt(result) - Integer.parseInt(txtNo1.getText().toString())));
		else if (radioBtnValue.equalsIgnoreCase("mul"))
			txtResult.setText(Integer.toString(Integer.parseInt(result) * Integer.parseInt(txtNo1.getText().toString())));
	}
 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}