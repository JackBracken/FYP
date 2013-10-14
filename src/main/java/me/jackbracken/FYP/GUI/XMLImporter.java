package main.java.me.jackbracken.FYP.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import main.java.me.jackbracken.FYP.FileUtilities.ParseUserFile;
import main.java.me.jackbracken.FYP.FileUtilities.UnicodeBOMInputStream;
import main.java.me.jackbracken.FYP.Models.User;

public class XMLImporter extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	static final String title = "FYP XML Importer Utility";
	static final String newline = "\n";

	// Set up BufferedReader
	String currentLine = "";
	FileInputStream fis;
	UnicodeBOMInputStream ubis;
	InputStreamReader isr;
	BufferedReader br;

	JButton openButton, applyButton;
	JTextArea textArea;
	JTable userTable;
	JFileChooser fileChooser;
	GridLayout buttonStrip = new GridLayout(1, 2);

	// Create JTable to show data
	String[] colNames = { "ID", "Reputation", "Creation Date", "Display Name",
			"Last Access", "Location", "About", "Views", "Up Votes",
			"Down Votes", "Email hash", "Age" };
	Vector<String> colHeader = new Vector<String>(Arrays.asList(colNames));

	public XMLImporter(String name) {
		super(name);
		setResizable(false);
		setSize(900, 600);
		setLocationRelativeTo(null);

		// Create text area to display text
		textArea = new JTextArea();
		textArea.setMargin(new Insets(5, 5, 5, 5));
		textArea.setEditable(false);

		// Vector<TableColumn> tableColumns = new Vector<TableColumn>();
		// TableColumn t = new TableColumn();
		// for(String s: colNames) {
		// tableColumns.add(t);
		// tableColumns.get(tableColumns.size()-1).setHeaderValue(s);
		// }

		// JTableHeader userTableHeader = new JTableHeader();

		Object[][] data = { { null, null, null, null, null, null, null, null,
				null, null, null, null } };

		userTable = new JTable(data, colNames);
		JScrollPane scrollPane = new JScrollPane(userTable);

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
		buttonPanel.add(applyButton).setEnabled(false);

		add(scrollPane, BorderLayout.CENTER);
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

				applyButton.setEnabled(true);
				ParseUserFile puf = new ParseUserFile(file);
				userTable = new JTable(puf.getUsers(), colHeader);
				add(userTable, BorderLayout.CENTER);
				
			} else {
				// textArea.append("Open command cancelled by user." + newline);
			}
			textArea.setCaretPosition(textArea.getDocument().getLength());
		} else if (e.getSource() == applyButton) {
			// Import file into database
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
