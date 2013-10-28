package arevir.chris.rootcheck;

import java.io.IOException;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	boolean root;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void checkRoot(View v) {
        @SuppressWarnings("unused")
		Process p;
        try {
            p = Runtime.getRuntime().exec("su");
            root = true;
        } catch (IOException e) {
            root = false;
        }

        TextView result = (TextView) findViewById(R.id.resultText);
        if (root){
            result.setText("Your device appears to be rooted, congrats!");
            result.setTextColor(Color.GREEN);
        } else {
            result.setText("Your device does not appear to be rooted, something must've gone wrong");
            result.setTextColor(Color.RED);
        }
    }

}
