/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hddinventory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author linkxs
 */
public class FileOperations {
    private PrimaryInterface pi;

    public FileOperations(PrimaryInterface pi) {
	this.pi = pi;
    }

    public Vector<Hdd> readHddDbFile(File file) {
	if (file != null) {
	    try {
		ObjectInputStream fin = new ObjectInputStream(
			new FileInputStream(file));
		fin.readUTF(); // The first line is just trash
		Vector<Hdd> hddDb = (Vector<Hdd>) fin.readObject();
		fin.close();
		return hddDb;
	    } catch (Exception e) {
		pi.appendToConsole("Issue reading hddDb from file: " + e.getMessage());
		return null;
	    }
	} else {
	    JFileChooser fc = new JFileChooser();
	    fc.setSelectedFile(new File("*.hdd"));

	    if (fc.showSaveDialog(pi) != JFileChooser.CANCEL_OPTION) {
		return this.readHddDbFile(fc.getSelectedFile());
	    }
	    return null;
	}
    }

    public void writeHddDbFile(Vector<Hdd> hddDb) {
	JFileChooser fc = new JFileChooser();
	fc.setSelectedFile(new File("*.hdd"));
	// As long as the user didn't cancel, proceed
	if (fc.showSaveDialog(pi) != JFileChooser.CANCEL_OPTION) {
	    try {
		ObjectOutputStream fout = new ObjectOutputStream(
			new FileOutputStream(fc.getSelectedFile(), false));
		// If you open the key in a text editor.. You see this
		// descriptor.
		fout.writeUTF("--THE FOLLOWING IS A HddInventory BINARY DATABASE FILE--\n");
		fout.writeObject(hddDb);
		fout.writeUTF("\n--------------------------------------------------------");

		fout.flush();
		fout.close();

		JOptionPane.showMessageDialog(pi,
			"Database successfully saved to " + fc.getSelectedFile());
	    } catch (Exception e) {
		System.err.println("Issues saving to file. " + e.getMessage());
	    }
	}
    }
}
