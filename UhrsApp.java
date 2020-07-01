/*
 * Project: university-human-resource
 * Version: 0.1.0
 * File: UhrsApp.java
 * ------
 * Author: Ashish Yadav (contact@ashiish.me)
 * GitHub: https://github.com/ashiishme
 */

import javax.swing.SwingUtilities;

import View.MainAppFrame;

public class UhrsApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainAppFrame::new);
    }
}
