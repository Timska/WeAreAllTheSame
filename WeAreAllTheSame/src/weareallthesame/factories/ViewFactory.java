package weareallthesame.factories;

import weareallthesame.view.R;
import weareallthesame.view.games.additionandsubtractiongames.AdditionAndSubstractionNumbersActivity;
import weareallthesame.view.games.additionandsubtractiongames.AdditionAndSubstractionSetsActivity;
import weareallthesame.view.games.choosecharacterfromsoundgame.ChooseCharacterFromSoundActivity;
import weareallthesame.view.games.chooseitemgame.FindPictureFromPictureActivity;
import weareallthesame.view.games.chooseitemgame.FindThePictureFromTheSoundActivity;
import weareallthesame.view.games.chooseitemgame.FindThePictureFromTheWordActivity;
import weareallthesame.view.games.chooseitemgame.FindTheWordFromThePictureActivity;
import weareallthesame.view.games.choosesigngames.ChooseTheSignNumbersActivity;
import weareallthesame.view.games.connectitemsgames.ConnectItemsActivity;
import weareallthesame.view.games.hangmangame.HangmanGameActivity;
import weareallthesame.view.games.howmanygame.HowManyObjectsActivity;
import weareallthesame.view.games.orderelementsgame.OrderElementsActivity;
import weareallthesame.view.games.questiongame.QuestionGameActivity;
import android.content.Context;

public class ViewFactory {

	@SuppressWarnings("rawtypes")
	public static Class getActivityClass(String categoryType, String gameName, Context context){
		if(categoryType.equalsIgnoreCase("Letters")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.letters_chooseLetter))){
				return ChooseCharacterFromSoundActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.letters_fillLetters))){
				return HangmanGameActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.letters_orderLetters))){
				return HangmanGameActivity.class;
			}
			
		}
		if(categoryType.equalsIgnoreCase("Numbers")){
			System.out.println("Ime na igra " + gameName);
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_addNumbers))){
				return AdditionAndSubstractionNumbersActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_addSets))){
				return AdditionAndSubstractionSetsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_chooseNumber))){
				return ChooseCharacterFromSoundActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_choosePicture))){
				return FindThePictureFromTheWordActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_chooseWord))){
				return FindTheWordFromThePictureActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_countObjects))){
				return HowManyObjectsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_orderNumbers))){
				return OrderElementsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_findSign))){
				return ChooseTheSignNumbersActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_sets))){
				//TODO go nema uste konkretnoto activity
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_substractNumbers))){
				return AdditionAndSubstractionNumbersActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_substractSets))){
				return AdditionAndSubstractionSetsActivity.class;
			}
			
		}
		if(categoryType.equalsIgnoreCase("Animals")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_chooseAnimal))){
				return FindThePictureFromTheSoundActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_choosePicture))){
				return FindThePictureFromTheWordActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_chooseWord))){
				return FindTheWordFromThePictureActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_connectAnimals))){
				//TODO go nema toa activity seuste
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_groupPictures))){
				//TODO go nema toa activity
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_groupWords))){
				//TODO go nema toa activity
			}
		}
		if(categoryType.equalsIgnoreCase("ClothesAndBodyParts")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.clothesandbodyparts_chooseBodyPartFromPicture))){
				return FindThePictureFromTheWordActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.clothesandbodyparts_chooseBodyPartFromWord))){
				return FindTheWordFromThePictureActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.clothesandbodyparts_chooseClothingFromPicture))){
				return FindThePictureFromTheWordActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.clothesandbodyparts_chooseClothingFromWord))){
				return FindTheWordFromThePictureActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.clothesandbodyparts_connect))){
				return ConnectItemsActivity.class;
			}
		}
		if(categoryType.equalsIgnoreCase("ColorsAndObjects")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.colorsandobjects_chooseColor))){
				return FindThePictureFromTheWordActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.colorsandobjects_chooseObject))){
				return FindThePictureFromTheWordActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.colorsandobjects_connect))){
				//TODO nema takvo activity
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.colorsandobjects_whatsTheColor))){
				return ConnectItemsActivity.class;
			}
		}
		if(categoryType.equalsIgnoreCase("Day")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.day_dayParts))){
				return ConnectItemsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.day_whatsTheTime))){
				return FindTheWordFromThePictureActivity.class;
			}
		}
		if(categoryType.equalsIgnoreCase("Emotions")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.emotions_choosePicture))){
				return FindThePictureFromTheWordActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.emotions_chooseWord))){
				return FindTheWordFromThePictureActivity.class;
			}
		}
		if(categoryType.equalsIgnoreCase("FruitsAndVegetables")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.fruitsandvegetables_choosePicture))){
				return FindThePictureFromTheWordActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.fruitsandvegetables_chooseWord))){
				return FindTheWordFromThePictureActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.fruitsandvegetables_connectPictures))){
				//TODO go nema toa activity
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.fruitsandvegetables_groupPictures))){
				//TODO go nema toa activity
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.fruitsandvegetables_groupWords))){
				//TODO go nema toa activity
			}
		}
		if(categoryType.equalsIgnoreCase("Prepositions")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.prepositions_choosePicture))){
				return FindThePictureFromTheWordActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.prepositions_choosePreposition))){
				return FindTheWordFromThePictureActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.prepositions_connect))){
				//TODO go nema toa activity
			}
		}
		if(categoryType.equalsIgnoreCase("Shapes")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.shapes_choosePicture))){
				return FindThePictureFromTheWordActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.shapes_chooseWord))){
				return FindTheWordFromThePictureActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.shapes_looksLike))){
				return FindTheWordFromThePictureActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.shapes_similarity))){
				return FindPictureFromPictureActivity.class;
			}
		}
		if(categoryType.equalsIgnoreCase("Weather")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.weather_choosePicture))){
				return FindThePictureFromTheWordActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.weather_chooseWord))){
				return FindTheWordFromThePictureActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.weather_connectPictures))){
				//TODO ne e gotovo toa activity
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.weather_outsideWeather))){
				return FindThePictureFromTheSoundActivity.class;
			}
		}
		if(categoryType.equalsIgnoreCase("Year")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.year_groupWords))){
				//TODO ne e gotovo toa activity.
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.year_orderDays))){
				return OrderElementsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.year_orderMonths))){
				return OrderElementsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.year_questions))){
				return QuestionGameActivity.class;
			}
		}
		
		return null;
	}
}
