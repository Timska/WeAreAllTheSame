package weareallthesame.view.games.hangmangame;

import java.util.ArrayList;

import weareallthesame.view.R;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class LettersListActivity extends Activity {

	private GridView letters;
	private ArrayList<TextView> txtLetters;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_letters_list);

		letters = (GridView) findViewById(R.id.letters_container);

		Typeface custom_font = Typeface.createFromAsset(getAssets(),
				"fonts/amerika_.ttf");
		letters.setAdapter(new TextViewAdapter(this,custom_font));

		letters.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Toast.makeText(LettersListActivity.this, "" + position,
						Toast.LENGTH_SHORT).show();
			}
		});
	}

}
