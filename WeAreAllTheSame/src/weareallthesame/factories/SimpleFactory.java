package weareallthesame.factories;

import java.util.Iterator;

import weareallthesame.factories.simplefactories.DayFactory;
import weareallthesame.factories.simplefactories.LetterFactory;
import weareallthesame.factories.simplefactories.MonthFactory;
import weareallthesame.factories.simplefactories.NumberFactory;
import weareallthesame.factories.simplefactories.SimpleFactoryInterface;

public class SimpleFactory {

	public static SimpleFactoryInterface getFactory(Iterator<String> tags,
			int maxPosition) {
		while (tags.hasNext()) {

			String type = tags.next();

			if (type.equalsIgnoreCase("letters")) {
				return new LetterFactory();
			}
			if (type.equalsIgnoreCase("months")) {
				return new MonthFactory();
			}
			if (type.equalsIgnoreCase("days")) {
				return new DayFactory();
			}
			if (type.equalsIgnoreCase("numbers")) {
				return new NumberFactory(maxPosition);
			}
		}
		return null;

	}
}
