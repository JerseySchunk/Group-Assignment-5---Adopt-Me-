import javax.swing.SwingUtilities;
import adoptme.model.Shelter;
import adoptme.model.Pet;
import adoptme.view.MainFrame;
import adoptme.controller.PetController;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Shelter<Pet> shelter = new Shelter<>();
			MainFrame frame = new MainFrame();
			new PetController(shelter, frame);
			frame.setVisible(true);
		});
	}
}
