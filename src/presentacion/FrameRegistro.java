package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;

import dominio.Doctor;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FrameRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passwordRepite;
	private JPasswordField password;
	private JLabel tic;
	ArrayList<Doctor> usuarios=new ArrayList<Doctor>();
	private JLabel tic2;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JButton btnRegistrar;
	

	public FrameRegistro(ArrayList<Doctor> usuarios) {
		this.usuarios=usuarios;
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameRegistro.class.getResource(Messages.getString("FrameRegistro.0")))); //$NON-NLS-1$
		setTitle(Messages.getString("FrameRegistro.1")); //$NON-NLS-1$
		setResizable(false);
		setBackground(SystemColor.text);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(SystemColor.text);
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		GridBagLayout gbl_panelBotones = new GridBagLayout();
		gbl_panelBotones.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 51, 0, 0, 0, 0, 0, 44, 0};
		gbl_panelBotones.rowHeights = new int[]{0, 0};
		gbl_panelBotones.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBotones.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelBotones.setLayout(gbl_panelBotones);
		
		JButton btnCancelar = new JButton(Messages.getString("FrameRegistro.2")); //$NON-NLS-1$
		btnCancelar.addActionListener(new BtnCancelarActionListener());
		btnCancelar.setFont(new Font(Messages.getString("FrameRegistro.3"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.gridwidth = 6;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 0;
		gbc_btnCancelar.gridy = 0;
		panelBotones.add(btnCancelar, gbc_btnCancelar);
		
		JButton btnLimpiar = new JButton(Messages.getString("FrameRegistro.4")); //$NON-NLS-1$
		btnLimpiar.addActionListener(new BtnLimpiarActionListener());
		
		JButton btnCheck = new JButton(Messages.getString("FrameRegistro.5")); //$NON-NLS-1$
		btnCheck.addActionListener(new BtnCheckActionListener());
		btnCheck.setFont(new Font(Messages.getString("FrameRegistro.6"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_btnCheck = new GridBagConstraints();
		gbc_btnCheck.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCheck.gridwidth = 5;
		gbc_btnCheck.insets = new Insets(0, 0, 0, 5);
		gbc_btnCheck.gridx = 6;
		gbc_btnCheck.gridy = 0;
		panelBotones.add(btnCheck, gbc_btnCheck);
		btnLimpiar.setFont(new Font(Messages.getString("FrameRegistro.7"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLimpiar.gridwidth = 3;
		gbc_btnLimpiar.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpiar.gridx = 11;
		gbc_btnLimpiar.gridy = 0;
		panelBotones.add(btnLimpiar, gbc_btnLimpiar);
		
		btnRegistrar = new JButton(Messages.getString("FrameRegistro.8")); //$NON-NLS-1$
		btnRegistrar.setEnabled(false);
		btnRegistrar.addActionListener(new BtnRegistrarActionListener());
		btnRegistrar.setFont(new Font(Messages.getString("FrameRegistro.9"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegistrar.gridwidth = 4;
		gbc_btnRegistrar.gridx = 14;
		gbc_btnRegistrar.gridy = 0;
		panelBotones.add(btnRegistrar, gbc_btnRegistrar);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setFont(new Font(Messages.getString("FrameRegistro.10"), Font.PLAIN, 11)); //$NON-NLS-1$
		panel.setBorder(new TitledBorder(UIManager.getBorder(Messages.getString("FrameRegistro.11")), Messages.getString("FrameRegistro.12"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))); //$NON-NLS-1$ //$NON-NLS-2$
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{20, 0, 0, 0, 0, 0, 0, 25, 20, 0};
		gbl_panel.rowHeights = new int[]{24, 20, 0, 22, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel(Messages.getString("FrameRegistro.13")); //$NON-NLS-1$
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		JLabel label_1 = new JLabel(Messages.getString("FrameRegistro.14")); //$NON-NLS-1$
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);
		
		JLabel lblUsuario = new JLabel(Messages.getString("FrameRegistro.15")); //$NON-NLS-1$
		lblUsuario.setFont(new Font(Messages.getString("FrameRegistro.16"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 1;
		panel.add(lblUsuario, gbc_lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBackground(SystemColor.scrollbar);
		textUsuario.setBorder(new TitledBorder(null, Messages.getString("FrameRegistro.17"), TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK)); //$NON-NLS-1$
		textUsuario.setFont(new Font(Messages.getString("FrameRegistro.18"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_textUsuario = new GridBagConstraints();
		gbc_textUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsuario.gridx = 2;
		gbc_textUsuario.gridy = 1;
		panel.add(textUsuario, gbc_textUsuario);
		textUsuario.setColumns(10);
		
		tic2 = new JLabel(Messages.getString("FrameRegistro.19")); //$NON-NLS-1$
		tic2.setVisible(false);
		tic2.setIcon(new ImageIcon(FrameRegistro.class.getResource(Messages.getString("FrameRegistro.20")))); //$NON-NLS-1$
		GridBagConstraints gbc_tic2 = new GridBagConstraints();
		gbc_tic2.insets = new Insets(0, 0, 5, 5);
		gbc_tic2.gridx = 3;
		gbc_tic2.gridy = 1;
		panel.add(tic2, gbc_tic2);
		
		JLabel lblContrasea = new JLabel(Messages.getString("FrameRegistro.21")); //$NON-NLS-1$
		lblContrasea.setFont(new Font(Messages.getString("FrameRegistro.22"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 5;
		gbc_lblContrasea.gridy = 1;
		panel.add(lblContrasea, gbc_lblContrasea);
		
		password = new JPasswordField();
		password.setBorder(new TitledBorder(null, Messages.getString("FrameRegistro.23"), TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop)); //$NON-NLS-1$
		password.setBackground(SystemColor.scrollbar);
		password.setFont(new Font(Messages.getString("FrameRegistro.24"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.gridwidth = 2;
		gbc_password.insets = new Insets(0, 0, 5, 5);
		gbc_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_password.gridx = 6;
		gbc_password.gridy = 1;
		panel.add(password, gbc_password);
		
		JLabel lblrepite = new JLabel(Messages.getString("FrameRegistro.25")); //$NON-NLS-1$
		lblrepite.setFont(new Font(Messages.getString("FrameRegistro.26"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblrepite = new GridBagConstraints();
		gbc_lblrepite.gridwidth = 2;
		gbc_lblrepite.insets = new Insets(0, 0, 5, 5);
		gbc_lblrepite.gridx = 4;
		gbc_lblrepite.gridy = 2;
		panel.add(lblrepite, gbc_lblrepite);
		
		passwordRepite = new JPasswordField();
		passwordRepite.setBorder(new TitledBorder(null, Messages.getString("FrameRegistro.27"), TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop)); //$NON-NLS-1$
		passwordRepite.setBackground(SystemColor.scrollbar);
		passwordRepite.setFont(new Font(Messages.getString("FrameRegistro.28"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_passwordRepite = new GridBagConstraints();
		gbc_passwordRepite.gridwidth = 2;
		gbc_passwordRepite.insets = new Insets(0, 0, 5, 5);
		gbc_passwordRepite.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordRepite.gridx = 6;
		gbc_passwordRepite.gridy = 2;
		panel.add(passwordRepite, gbc_passwordRepite);
		
		tic = new JLabel(Messages.getString("FrameRegistro.29")); //$NON-NLS-1$
		tic.setVisible(false);
		tic.setIcon(new ImageIcon(FrameRegistro.class.getResource(Messages.getString("FrameRegistro.30")))); //$NON-NLS-1$
		GridBagConstraints gbc_tic = new GridBagConstraints();
		gbc_tic.insets = new Insets(0, 0, 5, 0);
		gbc_tic.gridx = 8;
		gbc_tic.gridy = 2;
		panel.add(tic, gbc_tic);
		
		JLabel label_2 = new JLabel(Messages.getString("FrameRegistro.31")); //$NON-NLS-1$
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 5;
		gbc_label_2.gridy = 4;
		panel.add(label_2, gbc_label_2);
		
		JLabel lblNombre = new JLabel(Messages.getString("FrameRegistro.32")); //$NON-NLS-1$
		lblNombre.setFont(new Font(Messages.getString("FrameRegistro.33"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 5;
		panel.add(lblNombre, gbc_lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBorder(new TitledBorder(UIManager.getBorder(Messages.getString("FrameRegistro.34")), Messages.getString("FrameRegistro.35"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))); //$NON-NLS-1$ //$NON-NLS-2$
		textNombre.setBackground(SystemColor.scrollbar);
		textNombre.setFont(new Font(Messages.getString("FrameRegistro.36"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.insets = new Insets(0, 0, 0, 5);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 2;
		gbc_textNombre.gridy = 5;
		panel.add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel labelApellidos = new JLabel(Messages.getString("FrameRegistro.37")); //$NON-NLS-1$
		labelApellidos.setFont(new Font(Messages.getString("FrameRegistro.38"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_labelApellidos = new GridBagConstraints();
		gbc_labelApellidos.anchor = GridBagConstraints.EAST;
		gbc_labelApellidos.insets = new Insets(0, 0, 0, 5);
		gbc_labelApellidos.gridx = 5;
		gbc_labelApellidos.gridy = 5;
		panel.add(labelApellidos, gbc_labelApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setBorder(new TitledBorder(null, Messages.getString("FrameRegistro.39"), TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop)); //$NON-NLS-1$
		textApellidos.setBackground(SystemColor.scrollbar);
		textApellidos.setFont(new Font(Messages.getString("FrameRegistro.40"), Font.BOLD, 11)); //$NON-NLS-1$
		textApellidos.setText(Messages.getString("FrameRegistro.41")); //$NON-NLS-1$
		GridBagConstraints gbc_textApellidos = new GridBagConstraints();
		gbc_textApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellidos.anchor = GridBagConstraints.SOUTH;
		gbc_textApellidos.gridwidth = 2;
		gbc_textApellidos.insets = new Insets(0, 0, 0, 5);
		gbc_textApellidos.gridx = 6;
		gbc_textApellidos.gridy = 5;
		panel.add(textApellidos, gbc_textApellidos);
		textApellidos.setColumns(10);
		
		/*if(textcontraseña.getText().equals(textRepitePass.getText())&& (textcontraseña.getText().equals("")) ){
			label_2.setVisible(true);
		}*/
	}


	private class BtnCancelarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			FrameLogin login =new FrameLogin(usuarios);
			login.setVisible(true);
			dispose();
		}
		
	}
	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textUsuario.setText(Messages.getString("FrameRegistro.42"));; //$NON-NLS-1$
			passwordRepite.setText(Messages.getString("FrameRegistro.43")); //$NON-NLS-1$
			password.setText(Messages.getString("FrameRegistro.44")); //$NON-NLS-1$
			textNombre.setText(Messages.getString("FrameRegistro.45")); //$NON-NLS-1$
			textApellidos.setText(Messages.getString("FrameRegistro.46")); //$NON-NLS-1$
			tic.setVisible(false);
			tic2.setVisible(false);
		}
	}
	private class BtnRegistrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String usuario,pass,nombre,apell;

			if(textNombre.getText().equals(Messages.getString("FrameRegistro.47"))&& (textApellidos.getText().equals(Messages.getString("FrameRegistro.48")))){ //$NON-NLS-1$ //$NON-NLS-2$
				JOptionPane.showMessageDialog(contentPane,Messages.getString("FrameRegistro.49"), Messages.getString("FrameRegistro.50"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}else{
				usuario=textUsuario.getText();
				pass=password.getText();
				nombre=textNombre.getText();
				apell=textApellidos.getText();
				Doctor doctor = new Doctor(usuario,pass,nombre,apell);
				usuarios.add(doctor);
				JOptionPane.showMessageDialog(contentPane,Messages.getString("FrameRegistro.51")+doctor.getNombre()+Messages.getString("FrameRegistro.52")+doctor.getApellidos()+ Messages.getString("FrameRegistro.53") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						+ Messages.getString("FrameRegistro.54")); //$NON-NLS-1$
				dispose();
				FramePrincipal q = new FramePrincipal(doctor,usuarios);
				q.setVisible(true);
				dispose();
			}	
		}
	}
	private class BtnCheckActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			boolean usuario=false,pass=false;
			if(passwordRepite.getText().equals(password.getText())&& (!passwordRepite.getText().equals(Messages.getString("FrameRegistro.55"))) ){ //$NON-NLS-1$
				tic.setVisible(true);
				btnRegistrar.setEnabled(true);
				pass=true;
			}else{
				JOptionPane.showMessageDialog(contentPane,Messages.getString("FrameRegistro.56"), Messages.getString("FrameRegistro.57"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				password.setText(Messages.getString("FrameRegistro.58")); //$NON-NLS-1$
				passwordRepite.setText(Messages.getString("FrameRegistro.59")); //$NON-NLS-1$
				tic.setVisible(false);
				
			}
			
			/*for(int i=0;i<usuarios.size();i++){
				if(textUsuario.getText().equals(usuarios.get(i).getUsuario())|| (textUsuario.getText().equals(""))){
					tic2.setVisible(false);
					JOptionPane.showMessageDialog(contentPane,"Nombre de Usuario no disponible. Inténtelo de nuevo.", "Inane error", JOptionPane.ERROR_MESSAGE);
					textUsuario.setText("");
					break;
				}else{
					usuario=true;
					tic2.setVisible(true);
			
				}
			}*/
			
			if(usuario==true && pass==true ){
				btnRegistrar.setEnabled(true);
			}	
		}
	}
}
