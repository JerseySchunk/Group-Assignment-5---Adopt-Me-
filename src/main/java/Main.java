import javax.swing.SwingUtilities;
import adoptme.model.Shelter;
import adoptme.model.Pet;
import adoptme.view.MainFrame;
import adoptme.controller.PetController;

/*
 * The start of the program!
 * 
 * Will initialize the components of the application while
 * following the MVC expectations. 
 */

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			//This is the Model
			Shelter<Pet> shelter = new Shelter<>();
			//This is the view
			MainFrame frame = new MainFrame();
			//This is the controller
			new PetController(shelter, frame);
			//This makes the GUI visible
			frame.setVisible(true);
		});
	}
}
