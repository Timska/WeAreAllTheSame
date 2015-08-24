package weareallthesame.view.games.hangmangame;

import android.R.color;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class TextViewAdapter extends BaseAdapter {

	private Context mContext;
	private Typeface tf;

	public TextViewAdapter(Context c, Typeface tf) {
		mContext = c;
		this.tf = tf;
	}

	public int getCount() {
		return ALPHABET.length;
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

		textView.setTypeface(tf);
		textView.setTextSize(20);
		textView.setText((ALPHABET[position]));

		return textView;
	}

	// public static final String[] ALPHABET = { "A", "B", "A", "V","G", "G" };
	public static final String[] ALPHABET = { "А", "Б", "В", "Г", "Д", "Ѓ",
			"Е", "Ж", "З", "Ѕ", "И", "Ј", "К", "Л", "Љ", "М", "Н", "Њ", "О",
			"П", "Р", "С", "Т", "Ќ", "У", "Ф", "Х", "Ц", "Ч", "Џ", "Ш" };

}