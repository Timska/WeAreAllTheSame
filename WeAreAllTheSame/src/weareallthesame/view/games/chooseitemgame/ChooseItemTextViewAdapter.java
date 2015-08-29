package weareallthesame.view.games.chooseitemgame;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class ChooseItemTextViewAdapter extends BaseAdapter {

	private Context mContext;
	private Typeface tf;
	private ArrayList<String> answers;
	private int height, width;
	private int textColor;

	public ChooseItemTextViewAdapter(Context c, ArrayList<String> answers,
			Typeface tf, int width, int height, int color) {
		mContext = c;
		this.tf = tf;
		this.answers = new ArrayList<String>();
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
			GridView.LayoutParams lp=new GridView.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			
			textView.setLayoutParams(lp);
			textView.setPadding(10, 10, 10, 10);
			

		} else {
			textView = (TextView) convertView;
		}

		textView.setTypeface(tf);
		textView.setTextSize(25);
		//textView.setBackground(getGradientDrawable(textColor));
		textView.setTextColor(textColor);
		
		textView.setWidth(width);
		textView.setGravity(Gravity.CENTER);
		
		textView.setText(answers.get(position));
		return textView;
	}

	private GradientDrawable getGradientDrawable(int color) {

		GradientDrawable gd = new GradientDrawable();
		gd.setColor(color);
		gd.setCornerRadius(10);
		gd.setShape(GradientDrawable.RECTANGLE);
		//gd.setStroke(2, Color.BLACK, 5, 5);
		return gd;

	}

}