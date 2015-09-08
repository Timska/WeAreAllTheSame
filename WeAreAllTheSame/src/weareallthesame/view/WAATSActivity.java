package weareallthesame.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WAATSActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_waats);

		Thread thread = new Thread() {

			@Override
			public void run() {
				try {
					synchronized (this) {
						wait(3000);
					}
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}

				startActivity(new Intent(getApplicationContext(), MainActivity.class));
				finish();
			}

		};
		
		thread.start();
	}

}
