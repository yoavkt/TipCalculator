package il.ac.huji.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        
        final Button button = (Button) findViewById(R.id.btnCalculate);
        
        button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//sets the tip precent
				final double tipPrecent=0.12;
				//converts the tip check box to boolean value
				boolean toRound= ((CheckBox) findViewById(R.id.chkRound)).isChecked();
				//gets the tip amount and convert to num.
				double billAmount= Double.parseDouble( ((EditText) findViewById(R.id.edtBillAmount)).getText().toString());
				// sets the right value in the result number
				double result =tipPrecent*billAmount;
				int roundedRes = (int) Math.round(tipPrecent*billAmount);
				String outString = (toRound) ? "Tip: $" + roundedRes : "Tip: $" +String.format("%.2f", result);
				//creates the result string
					//stam
				//sets the text
				TextView resultText = (TextView) findViewById(R.id.txtTipResult);
				resultText.setText(outString);
				
			}});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }
    
}
