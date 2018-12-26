package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Dialog.ModalExclusionType;

public class JFrameManual extends JFrame {
	private JPanel contentPane;
	
	public JFrameManual() {
		
		setTitle(Messages.getString("JFrameManual.0")); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 647, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JTextArea txtrLaAplicacinSe = new JTextArea();
		txtrLaAplicacinSe.setFont(new Font(Messages.getString("JFrameManual.1"), Font.BOLD, 11)); //$NON-NLS-1$
		txtrLaAplicacinSe.setText(Messages.getString("JFrameManual.2")); //$NON-NLS-1$
		txtrLaAplicacinSe.setEditable(false);
		scrollPane.setViewportView(txtrLaAplicacinSe);
	}





}
