package weareallthesame.view.games.chooseitemgame;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class ChooseItemImageViewAdapter extends BaseAdapter {

	private Context mContext;
	private ArrayList<Integer> answers;
	private int height, width;

	public ChooseItemImageViewAdapter(Context c,
			ArrayList<Integer> resourcePaths, int width, int height) {
		mContext = c;
		this.answers = new ArrayList<Integer>();
		this.answers = resourcePaths;
		this.height = height;
		this.width = width;

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
		TextView imageView;
		if (convertView == null) {
			imageView = new TextView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			imageView.setPadding(8, 8, 8, 8);

		} else {
			imageView = (TextView) convertView;
		}

		imageView.setGravity(Gravity.CENTER);
		// imageView.setHeight(height);
		// imageView.setWidth(width);
		imageView.setBackgroundResource(answers.get(position));
		return imageView;
	}

}