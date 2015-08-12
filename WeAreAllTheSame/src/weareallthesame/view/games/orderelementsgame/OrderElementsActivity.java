package weareallthesame.view.games.orderelementsgame;

import java.util.ArrayList;

import weareallthesame.view.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrderElementsActivity extends Activity {

	private ArrayList<String> answers;
	private ArrayList<TextView> txtAnwers;
	private LinearLayout container;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_elements);
		
		answers=new ArrayList<String>();
		answers.add("ma");
		answers.add("al");
		answers.add("ma");
		answers.add("zo");
		answers.add("ig");

		txtAnwers=new ArrayList<TextView>();
		container=(LinearLayout) findViewById(R.id.order_elements_container);
		for(int i=0;i<answers.size();++i){
			//txtAnswers
		}
	}


	private final class MyDragListener implements OnDragListener {

		String index;
		public MyDragListener(String i){
			this.index=i;
		}
		
		@Override
		public boolean onDrag(View receivingLayoutView, DragEvent event) {
			// TODO Auto-generated method stub

			View draggedTextView = (View) event.getLocalState();

			switch (event.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED:
				break;
			case DragEvent.ACTION_DRAG_ENTERED:
				break;
			case DragEvent.ACTION_DRAG_LOCATION:
				break;
			case DragEvent.ACTION_DROP:

				String tag = (String) draggedTextView.getTag();

				if (tag.equals(index)) {
					ViewGroup draggedImageViewParentLayout = (ViewGroup) draggedTextView
							.getParent();
					draggedImageViewParentLayout.removeView(draggedTextView);
					TextView dropTarget = (TextView) receivingLayoutView;
					TextView droppedView = (TextView) draggedTextView;
					dropTarget.setText(droppedView.getText());

					draggedTextView.setVisibility(View.VISIBLE);
					return true;
				} else {
					draggedTextView.setVisibility(View.VISIBLE);
					return false;
				}

			case DragEvent.ACTION_DRAG_ENDED:

				if (!event.getResult()) {

					draggedTextView.setVisibility(View.VISIBLE);
				}
			default:
				break;
			}
			return true;
		}

	}

}
