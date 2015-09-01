package weareallthesame.factories;

import weareallthesame.view.R;
import weareallthesame.view.games.additionandsubtractiongames.AdditionAndSubstractionNumbersActivity;
import weareallthesame.view.games.additionandsubtractiongames.AdditionAndSubstractionSetsActivity;
import weareallthesame.view.games.choosecharacterfromsoundgame.ChooseCharacterFromSoundActivity;
import weareallthesame.view.games.chooseitemgame.FindPictureFromPictureActivity;
import weareallthesame.view.games.chooseitemgame.FindThePictureFromTheSoundActivity;
import weareallthesame.view.games.chooseitemgame.FindThePictureFromTheWordActivity;
import weareallthesame.view.games.chooseitemgame.FindTheWordFromThePictureActivity;
import weareallthesame.view.games.chooseoperatorgames.ChooseOperatorNumbersActivity;
import weareallthesame.view.games.chooseoperatorgames.ChooseOperatorSetsActivity;
import weareallthesame.view.games.choosesigngames.ChooseSignBetweenNumbers;
import weareallthesame.view.games.choosesigngames.ChooseSignSetsActivity;
import weareallthesame.view.games.classifyitemsgames.ClassifyItemsImagesActivity;
import weareallthesame.view.games.classifyitemsgames.ClassifyTheElementsActivity;
import weareallthesame.view.games.connectitemsgames.ConnectItemsActivity;
import weareallthesame.view.games.hangmangame.HangmanGameActivity;
import weareallthesame.view.games.hangmangame.HangmanGameStandardActivity;
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
				return OrderElementsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.letters_orderWord))){
				return HangmanGameActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.letters_hangman))){
				return HangmanGameStandardActivity.class;
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
				return ChooseSignBetweenNumbers.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_sets))){
				return ChooseSignSetsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_substractNumbers))){
				return AdditionAndSubstractionNumbersActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_substractSets))){
				return AdditionAndSubstractionSetsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_chooseOperator))){
				return ChooseOperatorNumbersActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_chooseOperatorSets))){
				return ChooseOperatorSetsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.numbers_classify))){
				return ClassifyTheElementsActivity.class;
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
				return ConnectItemsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_groupPictures))){
				return ClassifyItemsImagesActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.animals_groupWords))){
				return ClassifyTheElementsActivity.class;
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
				return ConnectItemsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.colorsandobjects_whatsTheColor))){
				return FindTheWordFromThePictureActivity.class;
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
				return ConnectItemsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.fruitsandvegetables_groupPictures))){
				return ClassifyItemsImagesActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.fruitsandvegetables_groupWords))){
				return ClassifyTheElementsActivity.class;
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
				return ConnectItemsActivity.class;
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
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.shapes_classifyPictures))){
				return ClassifyItemsImagesActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.shapes_classifyWords))){
				return ClassifyTheElementsActivity.class;
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
				return ConnectItemsActivity.class;
			}
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.weather_outsideWeather))){
				return FindThePictureFromTheSoundActivity.class;
			}
		}
		if(categoryType.equalsIgnoreCase("Year")){
			if(gameName.equalsIgnoreCase(context.getResources().getString(R.string.year_groupWords))){
				return ClassifyTheElementsActivity.class;
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
