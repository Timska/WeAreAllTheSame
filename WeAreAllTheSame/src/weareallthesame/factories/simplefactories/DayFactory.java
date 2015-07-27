package weareallthesame.factories.simplefactories;

import java.util.Random;

public class DayFactory implements SimpleFactoryInterface {

	private static String[] days = {"Понеделник", "Вторник", "Среда",
		"Четврток", "Петок", "Сабота", "Недела"};

	@Override
	public String getOnPosition(int position) {
		return days[position];
	}

	@Override
	public String getDefault() {
		Random random = new Random();
		return days[random.nextInt(days.length)];
	}

	@Override
	public int compare(String o1, String o2) {
		if(o1.equals(o2)){
			return 0;
		}
		for(int i=0;i<days.length;++i){
			if(o1.equals(days[i])){
				return -1;
			}
			if(o2.equals(days[i])){
				return 1;
			}
		}
		return 0;
	}
}
