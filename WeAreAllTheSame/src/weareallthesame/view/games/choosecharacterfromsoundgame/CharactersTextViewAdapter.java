package weareallthesame.view.games.choosecharacterfromsoundgame;

import java.util.ArrayList;
import java.util.Random;

import weareallthesame.view.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class CharactersTextViewAdapter extends BaseAdapter {

	private Context mContext;
	private Typeface tf;
	private ArrayList<String> answers;
	private int width,height;
	int count;
	private Random r=new Random();
	private int [] colors={R.color.blue,R.color.green,R.color.red,R.color.yellow,R.color.pink};

	public CharactersTextViewAdapter(Context c, ArrayList<String> answers,
			Typeface tf, int height, int width) {
		mContext = c;
		this.tf = tf;
		this.answers = new ArrayList<String>();
		this.answers = answers;
		this.width=width;
		this.height=height;
		count=0;
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
		textView.setTextSize(30);
		textView.setGravity(Gravity.CENTER);
		textView.setTextColor(Color.RED);
		count++;
		textView.setText(answers.get(position));
		
		return textView;
	}

}
