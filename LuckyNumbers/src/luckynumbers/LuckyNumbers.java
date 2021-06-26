package luckynumbers;
import luckynumbers.model.*;
import luckynumbers.control.*;
import luckynumbers.view.*;

public class LuckyNumbers {

	public static void main(String[] args) {
		Model game = new Game();
		Controller controller = new Controller(game, new MyView(game));
		controller.play();
	}

}
