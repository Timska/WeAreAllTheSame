package weareallthesame.view.games.choosesigngames;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class ChooseSignTextViewAdapter extends BaseAdapter {

	private Context mContext;
	private Typeface tf;
	private ArrayList<Character> answers;
	private int height, width;
	private int textColor;
	private String longestString;

	public ChooseSignTextViewAdapter(Context c, ArrayList<Character> answers,
			Typeface tf, int width, int height, int color) {
		mContext = c;
		this.tf = tf;
		this.answers = new ArrayList<Character>();
		this.answers = answers;
		this.height = height;
		this.width = width;
		this.textColor = color;

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
			GridView.LayoutParams lp = new GridView.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

			textView.setLayoutParams(lp);

		} else {
			textView = (TextView) convertView;
		}

		char text = answers.get(position);
		textView.setTypeface(tf);
		textView.setTextSize(30);
		textView.setTextColor(textColor);
		// textView.setHeight(height);
		textView.setGravity(Gravity.CENTER);
		System.out.println(text);
		textView.setText(Character.toString(text));
		return textView;
	}

}