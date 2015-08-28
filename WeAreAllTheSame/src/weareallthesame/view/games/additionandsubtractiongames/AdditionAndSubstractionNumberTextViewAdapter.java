package weareallthesame.view.games.additionandsubtractiongames;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class AdditionAndSubstractionNumberTextViewAdapter extends BaseAdapter {

	private Context mContext;
	private Typeface tf;
	private ArrayList<String> answers;

	public AdditionAndSubstractionNumberTextViewAdapter(Context c,
			ArrayList<String> answers) {
		mContext = c;
		//this.tf = tf;
		this.answers = new ArrayList<String>();
		this.answers = answers;
	}

	public int getCount() {
		return answers.size();
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView;
		if (convertView == null) {
			textView = new TextView(mContext);
			textView.setLayoutParams(new GridView.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			textView.setPadding(8, 8, 8, 8);

		} else {
			textView = (TextView) convertView;
		}

		//textView.setTypeface(tf);
		textView.setTextSize(20);
		textView.setTextColor(Color.RED);
		textView.setBackgroundColor(Color.BLACK);
		textView.setText(answers.get(position));

		return textView;
	}

	


}