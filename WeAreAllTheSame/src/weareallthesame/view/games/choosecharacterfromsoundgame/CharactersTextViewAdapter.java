package weareallthesame.view.games.choosecharacterfromsoundgame;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class CharactersTextViewAdapter extends BaseAdapter {

	private Context mContext;
	private Typeface tf;
	private ArrayList<String> answers;
	private int width,height;

	public CharactersTextViewAdapter(Context c, ArrayList<String> answers,
			Typeface tf, int height, int width) {
		mContext = c;
		this.tf = tf;
		this.answers = new ArrayList<String>();
		this.answers = answers;
		this.width=width;
		this.height=height;
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
					LayoutParams.WRAP_CONTENT,height));
			textView.setPadding(8, 8, 8, 8);
			

		} else {
			textView = (TextView) convertView;
		}

		textView.setTypeface(tf);
		//textView.setTextAppearance(android.R.style.TextAppearance_DeviceDefault_Large);
		textView.setTextSize(30);
		textView.setGravity(Gravity.CENTER);
		textView.setTextColor(Color.BLUE);
		//textView.setBackgroundColor(Color.BLACK);
		textView.setText(answers.get(position));

		return textView;
	}

}
