/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IHM;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Alexis
 */
public class Options extends JDialog {
    
    public Options(JFrame parent, String title, boolean modal) {
        // On appelle le constructeur de JDialog correspondant:
            super(parent, title, modal);
        // On personalise le JDialogue:
            this.setSize(400, 300);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setVisible(true);

    }
}
