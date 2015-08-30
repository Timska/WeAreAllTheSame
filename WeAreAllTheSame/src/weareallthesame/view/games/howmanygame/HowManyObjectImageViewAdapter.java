package weareallthesame.view.games.howmanygame;

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

public class HowManyObjectImageViewAdapter extends BaseAdapter {

	private Context mContext;
	private ArrayList<Integer> answers;
	private int height, width;

	public HowManyObjectImageViewAdapter(Context c,
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
		ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
			imageView.setPadding(30, 30, 30, 30);

		} else {
			imageView = (ImageView) convertView;
		}

		//imageView.setGravity(Gravity.CENTER);
		// imageView.setHeight(height);
		// imageView.setWidth(width);
		imageView.setBackgroundResource(answers.get(position));
		return imageView;
	}

}