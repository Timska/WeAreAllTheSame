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
		setOne=new AdditionAndSubstractionSetsView(getApplicationContext(), 3);
		setTwo=new AdditionAndSubstractionSetsView(getApplicationContext(), 2);
		
		
		LayoutParams lp= new LayoutParams(200,200);
		
		linLayout.addView(setOne,lp);
		linLayout.addView(setTwo,lp);
		//this.addContentView(setOne, null);
		//this.addContentView(setTwo, null);
	}


}
