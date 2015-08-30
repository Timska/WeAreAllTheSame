package weareallthesame.view.games.choosecharacterfromsoundgame;

import android.content.ClipData;
import android.content.ClipDescription;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;

public class MyClickListener implements OnTouchListener {

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
		String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
		System.out.println(item.toString());
		ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);
		DragShadowBuilder dsb = new View.DragShadowBuilder(v);
		v.startDrag(data, dsb, v, 0);
		v.setVisibility(View.INVISIBLE);
		return false;
	}
}