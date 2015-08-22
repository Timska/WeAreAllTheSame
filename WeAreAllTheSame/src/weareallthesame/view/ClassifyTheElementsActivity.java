package weareallthesame.view;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ClassifyTheElementsActivity extends Activity {

	private ArrayList<TextView> elements;
	private ArrayList<String> elementsGroupOne;
	private ArrayList<String> elementsGroupTwo;
	private LinearLayout groupOne;
	private LinearLayout groupTwo;
	private GridView container;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classify_the_elements);
		
		elements=new ArrayList<TextView>();
		elementsGroupOne=new ArrayList<String>();
		elementsGroupTwo=new ArrayList<String>();
		
		container=(GridView) findViewById(R.id.classify_elements_container);
		groupOne=(LinearLayout) findViewById(R.id.classify_elements_group_one);
		groupTwo=(LinearLayout) findViewById(R.id.classify_elements_group_two);
		
	}

	
}
