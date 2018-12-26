package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;

import dominio.Doctor;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JFormattedTextField.AbstractFormatter;

import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PanelPerfil extends JPanel {
	private JTextField textNombre;
	private JLabel lblFoto;
	private Doctor doctor;
	private JFormattedTextField ftextTelefono;
	private JFormattedTextField ftextDNI;
	private ImageIcon image=null;
	private JTextField textApellidos;
	private JTextField textUsuario;
	private JTextField textPass;
	private JTextField textColegiado;
	private JTextField textDireccion;
	private JFormattedTextField ftextMovil;
	private JFormattedTextField ftextTlfConsulta;
	private JTextField textEmail;
	private JTextField textLocalidad;
	private JTextField textCP;
	private JTextField textProvincia;
	private JTextField textECivil;
	private ArrayList<Doctor> usuarios;
	/**
	 * Create the panel.
	 */
	public PanelPerfil(Doctor doctor, ArrayList<Doctor> usuarios) {
		this.doctor=doctor;
		this.usuarios=usuarios;
		setBorder(null);
		setBackground(SystemColor.text);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(SystemColor.text);
		add(panel, BorderLayout.NORTH);
		
		JLabel lblMiPerfil = new JLabel(Messages.getString("PanelPerfil.0")); //$NON-NLS-1$
		lblMiPerfil.setFont(new Font(Messages.getString("PanelPerfil.1"), Font.BOLD, 16)); //$NON-NLS-1$
		lblMiPerfil.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblMiPerfil);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		panel_1.setBorder(null);
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{29, 105, 105, 91, 92, 45, 0, 84, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{29, 40, 32, 31, 31, 29, 31, 36, 37, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label_1 = new JLabel(Messages.getString("PanelPerfil.2")); //$NON-NLS-1$
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 0;
		panel_1.add(label_1, gbc_label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, Messages.getString("PanelPerfil.3"), TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop)); //$NON-NLS-1$
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 9;
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		
		lblFoto = new JLabel(Messages.getString("PanelPerfil.4")); //$NON-NLS-1$
		panel_2.add(lblFoto);
		lblFoto.setIcon(doctor.getImage());
		
		JLabel label_2 = new JLabel(Messages.getString("PanelPerfil.5")); //$NON-NLS-1$
		label_2.setFont(new Font(Messages.getString("PanelPerfil.6"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 1;
		panel_1.add(label_2, gbc_label_2);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font(Messages.getString("PanelPerfil.7"), Font.PLAIN, 11)); //$NON-NLS-1$
		textNombre.setText(doctor.getNombre());
		textNombre.setBackground(SystemColor.scrollbar);
		textNombre.setColumns(10);
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.gridwidth = 2;
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.gridx = 4;
		gbc_textNombre.gridy = 1;
		panel_1.add(textNombre, gbc_textNombre);
		
		JLabel lblNombreDeUsuario = new JLabel(Messages.getString("PanelPerfil.8")); //$NON-NLS-1$
		lblNombreDeUsuario.setFont(new Font(Messages.getString("PanelPerfil.9"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombreDeUsuario = new GridBagConstraints();
		gbc_lblNombreDeUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDeUsuario.gridwidth = 2;
		gbc_lblNombreDeUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeUsuario.gridx = 7;
		gbc_lblNombreDeUsuario.gridy = 1;
		panel_1.add(lblNombreDeUsuario, gbc_lblNombreDeUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font(Messages.getString("PanelPerfil.10"), Font.PLAIN, 11)); //$NON-NLS-1$
		textUsuario.setBackground(SystemColor.scrollbar);
		textUsuario.setText(doctor.getUsuario());
		GridBagConstraints gbc_textUsuario = new GridBagConstraints();
		gbc_textUsuario.gridwidth = 4;
		gbc_textUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsuario.gridx = 9;
		gbc_textUsuario.gridy = 1;
		panel_1.add(textUsuario, gbc_textUsuario);
		textUsuario.setColumns(10);
		
		JLabel label_3 = new JLabel(Messages.getString("PanelPerfil.11")); //$NON-NLS-1$
		label_3.setFont(new Font(Messages.getString("PanelPerfil.12"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 2;
		panel_1.add(label_3, gbc_label_3);
		
		textApellidos = new JTextField();
		textApellidos.setFont(new Font(Messages.getString("PanelPerfil.13"), Font.PLAIN, 11)); //$NON-NLS-1$
		textApellidos.setText(doctor.getApellidos());
		textApellidos.setBackground(SystemColor.scrollbar);
		GridBagConstraints gbc_textApellidos = new GridBagConstraints();
		gbc_textApellidos.gridwidth = 2;
		gbc_textApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_textApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textApellidos.gridx = 4;
		gbc_textApellidos.gridy = 2;
		panel_1.add(textApellidos, gbc_textApellidos);
		textApellidos.setColumns(10);
		
		JLabel lblContrasea = new JLabel(Messages.getString("PanelPerfil.14")); //$NON-NLS-1$
		lblContrasea.setFont(new Font(Messages.getString("PanelPerfil.15"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.gridwidth = 2;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 7;
		gbc_lblContrasea.gridy = 2;
		panel_1.add(lblContrasea, gbc_lblContrasea);
		
		textPass = new JTextField();
		textPass.setFont(new Font(Messages.getString("PanelPerfil.16"), Font.PLAIN, 11)); //$NON-NLS-1$
		textPass.setBackground(SystemColor.scrollbar);
		textPass.setText(Messages.getString("PanelPerfil.17")+doctor.getContraseña()); //$NON-NLS-1$
		GridBagConstraints gbc_textPass = new GridBagConstraints();
		gbc_textPass.gridwidth = 4;
		gbc_textPass.insets = new Insets(0, 0, 5, 5);
		gbc_textPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPass.gridx = 9;
		gbc_textPass.gridy = 2;
		panel_1.add(textPass, gbc_textPass);
		textPass.setColumns(10);
		
		JLabel label_4 = new JLabel(Messages.getString("PanelPerfil.18")); //$NON-NLS-1$
		label_4.setFont(new Font(Messages.getString("PanelPerfil.19"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 3;
		panel_1.add(label_4, gbc_label_4);
		
		//ftextDNI = new JFormattedTextField((AbstractFormatter) null);
		MaskFormatter formatoDNI;
		try {
			formatoDNI = new MaskFormatter(Messages.getString("PanelPerfil.20")); //$NON-NLS-1$
			formatoDNI.setPlaceholderCharacter('_');
			ftextDNI = new JFormattedTextField(formatoDNI);
			ftextDNI.setFont(new Font(Messages.getString("PanelPerfil.21"), Font.PLAIN, 11)); //$NON-NLS-1$
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ftextDNI.setBackground(SystemColor.scrollbar);
		ftextDNI.setText(doctor.getDni());
		GridBagConstraints gbc_ftextDNI = new GridBagConstraints();
		gbc_ftextDNI.gridwidth = 3;
		gbc_ftextDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftextDNI.insets = new Insets(0, 0, 5, 5);
		gbc_ftextDNI.gridx = 4;
		gbc_ftextDNI.gridy = 3;
		panel_1.add(ftextDNI, gbc_ftextDNI);
		
		JLabel lblNColegiado = new JLabel(Messages.getString("PanelPerfil.22")); //$NON-NLS-1$
		lblNColegiado.setFont(new Font(Messages.getString("PanelPerfil.23"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblNColegiado = new GridBagConstraints();
		gbc_lblNColegiado.anchor = GridBagConstraints.EAST;
		gbc_lblNColegiado.gridwidth = 2;
		gbc_lblNColegiado.insets = new Insets(0, 0, 5, 5);
		gbc_lblNColegiado.gridx = 7;
		gbc_lblNColegiado.gridy = 3;
		panel_1.add(lblNColegiado, gbc_lblNColegiado);
		
		textColegiado = new JTextField();
		textColegiado.setFont(new Font(Messages.getString("PanelPerfil.24"), Font.PLAIN, 11)); //$NON-NLS-1$
		textColegiado.setBackground(SystemColor.scrollbar);
		textColegiado.setText(Messages.getString("PanelPerfil.25")+doctor.getColegiado()); //$NON-NLS-1$
		textColegiado.setColumns(10);
		GridBagConstraints gbc_textColegiado = new GridBagConstraints();
		gbc_textColegiado.gridwidth = 4;
		gbc_textColegiado.insets = new Insets(0, 0, 5, 5);
		gbc_textColegiado.fill = GridBagConstraints.HORIZONTAL;
		gbc_textColegiado.gridx = 9;
		gbc_textColegiado.gridy = 3;
		panel_1.add(textColegiado, gbc_textColegiado);
		
		JLabel label_5 = new JLabel(Messages.getString("PanelPerfil.26")); //$NON-NLS-1$
		label_5.setFont(new Font(Messages.getString("PanelPerfil.27"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.NORTHEAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 3;
		gbc_label_5.gridy = 4;
		panel_1.add(label_5, gbc_label_5);
		
		//ftextTelefono = new JFormattedTextField((AbstractFormatter) null);
		MaskFormatter formatoTlf;
		try {
			formatoTlf = new MaskFormatter(Messages.getString("PanelPerfil.28")); //$NON-NLS-1$
			formatoTlf.setPlaceholderCharacter('_');
			ftextTelefono = new JFormattedTextField(formatoTlf);
			ftextTelefono.setFont(new Font(Messages.getString("PanelPerfil.29"), Font.PLAIN, 11)); //$NON-NLS-1$
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ftextTelefono.setBackground(SystemColor.scrollbar);
		ftextTelefono.setText(Messages.getString("PanelPerfil.30")+doctor.getTlf()); //$NON-NLS-1$
		GridBagConstraints gbc_ftextTelefono = new GridBagConstraints();
		gbc_ftextTelefono.gridwidth = 3;
		gbc_ftextTelefono.anchor = GridBagConstraints.NORTH;
		gbc_ftextTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftextTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_ftextTelefono.gridx = 4;
		gbc_ftextTelefono.gridy = 4;
		panel_1.add(ftextTelefono, gbc_ftextTelefono);
		
		JLabel lblMvil = new JLabel(Messages.getString("PanelPerfil.31")); //$NON-NLS-1$
		lblMvil.setFont(new Font(Messages.getString("PanelPerfil.32"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblMvil = new GridBagConstraints();
		gbc_lblMvil.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblMvil.gridwidth = 2;
		gbc_lblMvil.insets = new Insets(0, 0, 5, 5);
		gbc_lblMvil.gridx = 7;
		gbc_lblMvil.gridy = 4;
		panel_1.add(lblMvil, gbc_lblMvil);
		
		//ftextMovil = new JFormattedTextField((javax.swing.JFormattedTextField$AbstractFormatter) null);
		MaskFormatter formatoMovil;
		try {
			formatoMovil = new MaskFormatter(Messages.getString("PanelPerfil.33")); //$NON-NLS-1$
			formatoMovil.setPlaceholderCharacter('_');
			ftextMovil = new JFormattedTextField(formatoMovil);
			ftextMovil.setFont(new Font(Messages.getString("PanelPerfil.34"), Font.PLAIN, 11)); //$NON-NLS-1$
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ftextMovil.setText(Messages.getString("PanelPerfil.35")+doctor.getMovil()); //$NON-NLS-1$
		ftextMovil.setFont(new Font(Messages.getString("PanelPerfil.36"), Font.BOLD, 11)); //$NON-NLS-1$
		ftextMovil.setBackground(SystemColor.scrollbar);
		GridBagConstraints gbc_ftextMovil = new GridBagConstraints();
		gbc_ftextMovil.anchor = GridBagConstraints.NORTH;
		gbc_ftextMovil.gridwidth = 4;
		gbc_ftextMovil.insets = new Insets(0, 0, 5, 5);
		gbc_ftextMovil.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftextMovil.gridx = 9;
		gbc_ftextMovil.gridy = 4;
		panel_1.add(ftextMovil, gbc_ftextMovil);
		
		JLabel lblDireccin = new JLabel(Messages.getString("PanelPerfil.37")); //$NON-NLS-1$
		lblDireccin.setFont(new Font(Messages.getString("PanelPerfil.38"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblDireccin = new GridBagConstraints();
		gbc_lblDireccin.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDireccin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccin.gridx = 3;
		gbc_lblDireccin.gridy = 5;
		panel_1.add(lblDireccin, gbc_lblDireccin);
		
		textDireccion = new JTextField();
		textDireccion.setBackground(SystemColor.scrollbar);
		textDireccion.setFont(new Font(Messages.getString("PanelPerfil.39"), Font.PLAIN, 11)); //$NON-NLS-1$
		textDireccion.setText(doctor.getDireccion());
		GridBagConstraints gbc_textDireccion = new GridBagConstraints();
		gbc_textDireccion.anchor = GridBagConstraints.NORTH;
		gbc_textDireccion.gridwidth = 3;
		gbc_textDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_textDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDireccion.gridx = 4;
		gbc_textDireccion.gridy = 5;
		panel_1.add(textDireccion, gbc_textDireccion);
		textDireccion.setColumns(10);
		
		JLabel lblTelfonoConsulta = new JLabel(Messages.getString("PanelPerfil.40")); //$NON-NLS-1$
		lblTelfonoConsulta.setFont(new Font(Messages.getString("PanelPerfil.41"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblTelfonoConsulta = new GridBagConstraints();
		gbc_lblTelfonoConsulta.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTelfonoConsulta.gridwidth = 2;
		gbc_lblTelfonoConsulta.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelfonoConsulta.gridx = 7;
		gbc_lblTelfonoConsulta.gridy = 5;
		panel_1.add(lblTelfonoConsulta, gbc_lblTelfonoConsulta);
		MaskFormatter formatoEx;
		try {
			formatoEx = new MaskFormatter(Messages.getString("PanelPerfil.42")); //$NON-NLS-1$
			formatoEx.setPlaceholderCharacter('_');
			ftextTlfConsulta = new JFormattedTextField(formatoEx);
			ftextTlfConsulta.setFont(new Font(Messages.getString("PanelPerfil.43"), Font.PLAIN, 11)); //$NON-NLS-1$
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ftextTlfConsulta.setText(Messages.getString("PanelPerfil.44")+doctor.getExt()); //$NON-NLS-1$
		ftextTlfConsulta.setFont(new Font(Messages.getString("PanelPerfil.45"), Font.BOLD, 11)); //$NON-NLS-1$
		ftextTlfConsulta.setBackground(SystemColor.scrollbar);
		GridBagConstraints gbc_ftextTlfConsulta = new GridBagConstraints();
		gbc_ftextTlfConsulta.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftextTlfConsulta.anchor = GridBagConstraints.NORTH;
		gbc_ftextTlfConsulta.gridwidth = 3;
		gbc_ftextTlfConsulta.insets = new Insets(0, 0, 5, 5);
		gbc_ftextTlfConsulta.gridx = 9;
		gbc_ftextTlfConsulta.gridy = 5;
		panel_1.add(ftextTlfConsulta, gbc_ftextTlfConsulta);
		
		JButton button_3 = new JButton(Messages.getString("PanelPerfil.46")); //$NON-NLS-1$
		button_3.addActionListener(new Button_3ActionListener());
		
		JButton btnImagen = new JButton(Messages.getString("PanelPerfil.47")); //$NON-NLS-1$
		btnImagen.setFont(new Font(Messages.getString("PanelPerfil.48"), Font.BOLD, 11)); //$NON-NLS-1$
		btnImagen.addActionListener(new BtnImagenActionListener());
		
		JLabel lblLocalidad = new JLabel(Messages.getString("PanelPerfil.49")); //$NON-NLS-1$
		lblLocalidad.setFont(new Font(Messages.getString("PanelPerfil.50"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblLocalidad = new GridBagConstraints();
		gbc_lblLocalidad.anchor = GridBagConstraints.EAST;
		gbc_lblLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocalidad.gridx = 3;
		gbc_lblLocalidad.gridy = 6;
		panel_1.add(lblLocalidad, gbc_lblLocalidad);
		
		textLocalidad = new JTextField();
		textLocalidad.setFont(new Font(Messages.getString("PanelPerfil.51"), Font.PLAIN, 11)); //$NON-NLS-1$
		textLocalidad.setBackground(SystemColor.scrollbar);
		GridBagConstraints gbc_textLocalidad = new GridBagConstraints();
		textLocalidad.setText(doctor.getLocalidad());
		gbc_textLocalidad.gridwidth = 3;
		gbc_textLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_textLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLocalidad.gridx = 4;
		gbc_textLocalidad.gridy = 6;
		panel_1.add(textLocalidad, gbc_textLocalidad);
		textLocalidad.setColumns(10);
		
		JLabel lblEmail = new JLabel(Messages.getString("PanelPerfil.52")); //$NON-NLS-1$
		lblEmail.setFont(new Font(Messages.getString("PanelPerfil.53"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.gridwidth = 2;
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 7;
		gbc_lblEmail.gridy = 6;
		panel_1.add(lblEmail, gbc_lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font(Messages.getString("PanelPerfil.54"), Font.PLAIN, 11)); //$NON-NLS-1$
		textEmail.setBackground(SystemColor.scrollbar);
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		textEmail.setText(doctor.getEmail());
		gbc_textEmail.gridwidth = 5;
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 9;
		gbc_textEmail.gridy = 6;
		panel_1.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);
		
		JLabel lblCp = new JLabel(Messages.getString("PanelPerfil.55")); //$NON-NLS-1$
		lblCp.setFont(new Font(Messages.getString("PanelPerfil.56"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblCp = new GridBagConstraints();
		gbc_lblCp.anchor = GridBagConstraints.EAST;
		gbc_lblCp.insets = new Insets(0, 0, 5, 5);
		gbc_lblCp.gridx = 3;
		gbc_lblCp.gridy = 7;
		panel_1.add(lblCp, gbc_lblCp);
		
		textCP = new JTextField();
		textCP.setFont(new Font(Messages.getString("PanelPerfil.57"), Font.PLAIN, 11)); //$NON-NLS-1$
		textCP.setBackground(SystemColor.scrollbar);
		GridBagConstraints gbc_textCP = new GridBagConstraints();
		textCP.setText(Messages.getString("PanelPerfil.58")+doctor.getCp()); //$NON-NLS-1$
		gbc_textCP.gridwidth = 2;
		gbc_textCP.insets = new Insets(0, 0, 5, 5);
		gbc_textCP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCP.gridx = 4;
		gbc_textCP.gridy = 7;
		panel_1.add(textCP, gbc_textCP);
		textCP.setColumns(10);
		
		JLabel lblEstadoCivil = new JLabel(Messages.getString("PanelPerfil.59")); //$NON-NLS-1$
		lblEstadoCivil.setFont(new Font(Messages.getString("PanelPerfil.60"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblEstadoCivil = new GridBagConstraints();
		gbc_lblEstadoCivil.anchor = GridBagConstraints.EAST;
		gbc_lblEstadoCivil.gridwidth = 2;
		gbc_lblEstadoCivil.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstadoCivil.gridx = 7;
		gbc_lblEstadoCivil.gridy = 7;
		panel_1.add(lblEstadoCivil, gbc_lblEstadoCivil);
		
		textECivil = new JTextField();
		textECivil.setFont(new Font(Messages.getString("PanelPerfil.61"), Font.PLAIN, 11)); //$NON-NLS-1$
		textECivil.setBackground(SystemColor.scrollbar);
		GridBagConstraints gbc_textECivil = new GridBagConstraints();
		textECivil.setText(doctor.geteCivil());
		gbc_textECivil.gridwidth = 3;
		gbc_textECivil.insets = new Insets(0, 0, 5, 5);
		gbc_textECivil.fill = GridBagConstraints.HORIZONTAL;
		gbc_textECivil.gridx = 9;
		gbc_textECivil.gridy = 7;
		panel_1.add(textECivil, gbc_textECivil);
		textECivil.setColumns(10);
		
		JLabel lblProvincia = new JLabel(Messages.getString("PanelPerfil.62")); //$NON-NLS-1$
		lblProvincia.setFont(new Font(Messages.getString("PanelPerfil.63"), Font.BOLD, 11)); //$NON-NLS-1$
		GridBagConstraints gbc_lblProvincia = new GridBagConstraints();
		gbc_lblProvincia.anchor = GridBagConstraints.EAST;
		gbc_lblProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvincia.gridx = 3;
		gbc_lblProvincia.gridy = 8;
		panel_1.add(lblProvincia, gbc_lblProvincia);
		
		textProvincia = new JTextField();
		textProvincia.setFont(new Font(Messages.getString("PanelPerfil.64"), Font.PLAIN, 11)); //$NON-NLS-1$
		textProvincia.setBackground(SystemColor.scrollbar);
		GridBagConstraints gbc_textProvincia = new GridBagConstraints();
		textProvincia.setText(doctor.getProvincia());
		gbc_textProvincia.gridwidth = 3;
		gbc_textProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_textProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_textProvincia.gridx = 4;
		gbc_textProvincia.gridy = 8;
		panel_1.add(textProvincia, gbc_textProvincia);
		textProvincia.setColumns(10);
		GridBagConstraints gbc_btnImagen = new GridBagConstraints();
		gbc_btnImagen.gridwidth = 2;
		gbc_btnImagen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImagen.insets = new Insets(0, 0, 5, 5);
		gbc_btnImagen.gridx = 1;
		gbc_btnImagen.gridy = 10;
		panel_1.add(btnImagen, gbc_btnImagen);
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.anchor = GridBagConstraints.SOUTH;
		gbc_button_3.gridwidth = 6;
		gbc_button_3.gridx = 11;
		gbc_button_3.gridy = 13;
		panel_1.add(button_3, gbc_button_3);

	}
	void Actualizar(){  //Metodo que cierra el Frame que contiene a este Panel
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
		frame.dispose();
		FramePrincipal frame1=new FramePrincipal(doctor,usuarios);
		frame1.setVisible(true);
	}

	private class BtnImagenActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fcAbrir = new JFileChooser();
			FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter(Messages.getString("PanelPerfil.65"),Messages.getString("PanelPerfil.66"), Messages.getString("PanelPerfil.67")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			fcAbrir.setFileFilter(filtroImagen);
			int valorDevuelto = fcAbrir.showOpenDialog(new PanelPerfil(doctor,usuarios));
			//Recoger el nombre del fichero seleccionado por el usuario
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				image= new ImageIcon(file.getAbsolutePath());
				Image imagen= image.getImage();
				image= new ImageIcon( imagen.getScaledInstance(205, 180, Image.SCALE_DEFAULT));
				lblFoto.setIcon(image);
			}	
		}
	}
	private class Button_3ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int respuesta= JOptionPane.showConfirmDialog(new PanelPerfil(doctor,usuarios), Messages.getString("PanelPerfil.68"), Messages.getString("PanelPerfil.69"), JOptionPane.OK_CANCEL_OPTION); //$NON-NLS-1$ //$NON-NLS-2$
			if(respuesta==0){
				if(image==null){
					
				}else{
					doctor.setImage(image);
				}
				doctor.setNombre(textNombre.getText());
				doctor.setApellidos(textApellidos.getText());
				doctor.setDni(ftextDNI.getText());
				doctor.setColegiado(Integer.parseInt(textColegiado.getText()));
				doctor.setUsuario(textUsuario.getText());
				doctor.setContraseña(textPass.getText());
				doctor.setTlf(Integer.parseInt(ftextTelefono.getText()));
				doctor.setMovil(Integer.parseInt(ftextMovil.getText()));
				doctor.setDireccion(textDireccion.getText());
				doctor.setExt(Integer.parseInt(ftextTlfConsulta.getText()));
				doctor.setLocalidad(textLocalidad.getText());
				doctor.setEmail(textEmail.getText());
				doctor.setCp(Integer.parseInt(textCP.getText()));
				doctor.seteCivil(textECivil.getText());
				doctor.setProvincia(textProvincia.getText());
				Actualizar();
			}
			
		}
	}
}
