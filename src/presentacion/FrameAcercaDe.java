package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Point;

public class FrameAcercaDe extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtAcerca;

	public FrameAcercaDe() {
		setTitle(Messages.getString("FrameAcercaDe.0")); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 647, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setFont(new Font(Messages.getString("FrameAcercaDe.1"), Font.BOLD, 11)); //$NON-NLS-1$
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		txtAcerca = new JTextArea();
		txtAcerca.setEditable(false);
		txtAcerca.setFont(new Font(Messages.getString("FrameAcercaDe.2"), Font.BOLD, 11)); //$NON-NLS-1$
		txtAcerca.setText(Messages.getString("FrameAcercaDe.3")); //$NON-NLS-1$
		scrollPane.setViewportView(txtAcerca);
	
	}

}
