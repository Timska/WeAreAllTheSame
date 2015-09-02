package weareallthesame.view.games.questiongame;

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

public class QuestionGameTextViewAdapter extends BaseAdapter {

	private Context mContext;
	private Typeface tf;
	private ArrayList<String> answers;
	private int textColor;

	public QuestionGameTextViewAdapter(Context c, ArrayList<String> answers,
			Typeface tf, int color) {
		mContext = c;
		this.tf = tf;
		this.answers = new ArrayList<String>();
		this.answers = answers;
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

		String text = answers.get(position);

		textView.setTextSize(18);
		textView.setTextColor(textColor);
		textView.setTypeface(tf);
		textView.setHeight(100);
		textView.setGravity(Gravity.CENTER);
		textView.setText(text);
		return textView;
	}

}