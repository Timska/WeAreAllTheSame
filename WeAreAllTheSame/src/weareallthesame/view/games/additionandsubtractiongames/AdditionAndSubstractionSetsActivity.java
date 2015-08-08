package weareallthesame.view.games.additionandsubtractiongames;

import weareallthesame.view.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class AdditionAndSubstractionSetsActivity extends Activity {

	
	private AdditionAndSubstractionSetsView setOne;
	private AdditionAndSubstractionSetsView setTwo;
	private LinearLayout linLayout;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addition_and_substraction_sets);
		
		
		linLayout=(LinearLayout) findViewById(R.id.addition_and_substraction_sets_container);
		setOne=new AdditionAndSubstractionSetsView(getApplicationContext(), 5, 4, "+", 300, 300);
		linLayout.addView(setOne);
	}


}
