package luckynumbers.view;
import luckynumbers.model.*;

public interface View {
	public void displayWelcome();
	public void displayGame();
	public void displayWinner();
	public int askPlayerCount();
	public Position askPosition();
	public void displayError(String message);
}
