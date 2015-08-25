package weareallthesame.view.games.choosecharacterfromsoundgame;

import android.content.ClipData;
import android.content.ClipDescription;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnLongClickListener;

public class MyClickListener implements OnLongClickListener {

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
		String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
		System.out.println(item.toString());
		ClipData data = new ClipData(v.getTag().toString(), mimeTypes, item);
		DragShadowBuilder dsb = new View.DragShadowBuilder(v);

		v.startDrag(data, dsb, v, 0);
		v.setVisibility(View.INVISIBLE);

		return true;
	}
}