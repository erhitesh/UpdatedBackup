package com.cal.calculatorapp.test;

import com.example.calculatorapp.MainActivity;
import com.robotium.solo.Solo;
import com.cal.calculatorapp.R;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class AddTestCases extends ActivityInstrumentationTestCase2<MainActivity> {
	
	private Solo solo;
	
	public AddTestCases(){
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}


	public void testAddition(){
		EditText txtVal1 = (EditText) solo.getView(R.id.edtno1);
		EditText txtVal2 = (EditText) solo.getView(R.id.edtno2);
		solo.enterText(txtVal1, "100");
		solo.enterText(txtVal2, "20");
		Log.d("Calculator test","Add Pass");
		RadioButton button = (RadioButton) solo.getView(R.id.rdSub);
		solo.clickOnView(button);
		TextView resultTxt = (TextView) solo.getView(R.id.txtResult);
		System.out.println("result"+resultTxt.getText());
		
		if (resultTxt.getText().toString().equalsIgnoreCase("120")){
			Log.d("Calculator test","Add Pass");
			System.out.println("Pass");
		}
		
	
	}
	
	/*public void checkElementPresent(){
		solo.waitForCondition(new Condition() {
			
			public boolean isSatisfied() {
				// TODO Auto-generated method stub
				return solo.isRadioButtonChecked("add");
			}
		}, 10);
	}*/
	
	@Override
	protected void tearDown() throws Exception{
       /* try {
        	solo.finalize();
        } catch (Throwable e) {
            e.printStackTrace();
            }
            getActivity().finish();
            super.tearDown(); */
            }
}
