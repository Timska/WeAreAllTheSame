package weareallthesame.view.games.classifyitemsgames;

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

public class ClassifyItemsTextViewAdapter extends BaseAdapter {

	private Context mContext;
	private Typeface tf;
	private ArrayList<String> answers;
	private int height, width;
	private int textColor;
	private String longestString;

	public ClassifyItemsTextViewAdapter(Context c, ArrayList<String> answers,
			Typeface tf, int width, int height, int color, String longestString) {
		mContext = c;
		this.tf = tf;
		this.answers = new ArrayList<String>();
		this.answers = answers;
		this.height = height;
		this.width = width;
		this.textColor = color;
		this.longestString = longestString;
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
		Paint paint = new Paint();
		float size = paint.measureText(longestString);
		textView.setTypeface(tf);
		textView.setTag(text);
		textView.setTextSize(18);
		textView.setTextColor(textColor);
		textView.setWidth((int) size + 20);
		textView.setHeight(height);
		textView.setGravity(Gravity.CENTER);
		textView.setText(text);
		return textView;
	}

}