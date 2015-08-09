package weareallthesame.view.games.additionandsubtractiongames;

import weareallthesame.view.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AdditionAndSubstractionSetsActivity extends Activity {

	
	private AdditionAndSubstractionSetsView setTwo;
	private AdditionAndSubstractionSetView setOne;
	private LinearLayout linLayout;
	private View setOneView;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addition_and_substraction_sets);
		
		setOneView=findViewById(R.id.addition_and_substraction_sets_set_one);
		setOne=new AdditionAndSubstractionSetView(this.getBaseContext(), 2);
		setOneView=setOne;
		
		
	}


}
