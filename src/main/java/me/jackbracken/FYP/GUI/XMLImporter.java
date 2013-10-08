package main.java.me.jackbracken.FYP.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class XMLImporter extends JFrame implements ActionListener {
	static final String title = "FYP XML Importer Utility";
	static final String newline = "\n";
	JButton openButton, applyButton;
	JTextArea textArea;
	JFileChooser fileChooser;
	GridLayout buttonStrip = new GridLayout(1, 2);

	public XMLImporter(String name) {
		super(name);
		setResizable(false);
		setSize(900, 600);
		setLocationRelativeTo(null);

		// Create text area to display text
		textArea = new JTextArea();
		textArea.setMargin(new Insets(5, 5, 5, 5));
		textArea.setEditable(false);
		JScrollPane textAreaScrollPane = new JScrollPane(textArea);

		// Create file chooser
		fileChooser = new JFileChooser();

		// Set up buttons
		openButton = new JButton("Select file...");
		openButton.addActionListener(this);

		applyButton = new JButton("Apply selection...");
		applyButton.addActionListener(this);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(buttonStrip);
		buttonPanel.add(openButton);
		buttonPanel.add(applyButton);

		add(textAreaScrollPane, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		XMLImporter frame = new XMLImporter(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Display the window.
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// Handle open button action.
		if (e.getSource() == openButton) {
			int returnVal = fileChooser.showOpenDialog(XMLImporter.this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				// This is where a real application would open the file.
				textArea.append("Opening: " + file.getName() + "." + newline);
			} else {
				textArea.append("Open command cancelled by user." + newline);
			}
			textArea.setCaretPosition(textArea.getDocument().getLength());

			// Handle save button action.
		} else if (e.getSource() == applyButton) {
			int returnVal = fileChooser.showSaveDialog(XMLImporter.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				// This is where a real application would save the file.
				textArea.append("Saving: " + file.getName() + "." + newline);
			} else {
				textArea.append("Save command cancelled by user." + newline);
			}
			textArea.setCaretPosition(textArea.getDocument().getLength());
		}
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
