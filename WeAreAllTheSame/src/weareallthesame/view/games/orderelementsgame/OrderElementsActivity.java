package weareallthesame.view.games.orderelementsgame;

import java.util.ArrayList;
import java.util.Collections;

import weareallthesame.view.R;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrderElementsActivity extends Activity {

	private ArrayList<String> answers;
	private ArrayList<TextView> txtAnswers;
	private LinearLayout container;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_elements);
		
		answers=new ArrayList<String>();
		answers.add("igor");
		answers.add("zorica");
		answers.add("marija");
		answers.add("aleksandra");
		answers.add("martin");
		
		txtAnswers=new ArrayList<TextView>();
		container=(LinearLayout) findViewById(R.id.order_elements_container);
		for(int i=0;i<answers.size();++i){
			TextView tx=new TextView(getApplicationContext());
			tx.setText(answers.get(i));
			tx.setTag(String.format("%d", i));
		//	tx.setBackgroundResource(R.drawable.play_button);
			txtAnswers.add(tx);
			
			
		}
		Collections.shuffle(txtAnswers);
		for(int i=0;i<answers.size();++i){
			String tag=(String) txtAnswers.get(i).getTag();
			tag+=" "+i;
			txtAnswers.get(i).setTag(tag);
			container.addView(txtAnswers.get(i));
			//System.out.println(txtAnswers.get(i).getTag());
			txtAnswers.get(i).setOnLongClickListener(new MyClickListener());
			txtAnswers.get(i).setOnDragListener(new MyDragListener());
		}
	}


	private final class MyClickListener implements OnLongClickListener {

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

	

	private final class MyDragListener implements OnDragListener {

		
		
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
				String [] tagsDraggedTextView=tag.split(" ");
				String [] tagsReceivingTextView=((String) receivingLayoutView.getTag()).split(" ");

				
				if (tagsDraggedTextView[0].equals(tagsReceivingTextView[1])) {
					System.out.println("Dropped");
					System.out.println("Dragged text view"+tagsDraggedTextView[0]+" "+tagsDraggedTextView[1]);
					System.out.println("Dropping text view" + tagsReceivingTextView[0]+" "+tagsReceivingTextView[1]);
					ViewGroup draggedImageViewParentLayout = (ViewGroup) draggedTextView
							.getParent();
					//draggedImageViewParentLayout.removeView(draggedTextView);
					TextView dropTarget = (TextView) receivingLayoutView;
					TextView draggedView = (TextView) draggedTextView;
					String targetText=(String) dropTarget.getText();
					dropTarget.setText(draggedView.getText());
					draggedView.setText(targetText);
					dropTarget.setTag(tagsReceivingTextView[0]+" "+tagsDraggedTextView[1]);
					draggedView.setTag(tagsDraggedTextView[0] +" "+ tagsReceivingTextView[1]);

					draggedTextView.setVisibility(View.VISIBLE);
					return true;
				} else {
					draggedTextView.setVisibility(View.VISIBLE);
					System.out.println("not dropped");
					System.out.println("Dragged text view"+tagsDraggedTextView[0]+" "+tagsDraggedTextView[1]);
					System.out.println("Dropping text view" + tagsReceivingTextView[0]+" "+tagsReceivingTextView[1]);
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
