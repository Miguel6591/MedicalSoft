package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import dominio.*;
import dominio.Doctor;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.ImageIcon;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;


public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelCardLayout;
	private PanelPrincipal panelInicio;
	private ArrayList<Doctor> usuarios= new ArrayList<Doctor>();
	
	private JMenuBar menuBar;
	private JPanel paneLateral;
	private JPanel panelEspecialistas;
	private JPanel panelAyuda;
	private PanelPacientes panelPacientes;
	private PanelConsultas panelConsultas;
	Doctor doctor;
	private JLabel lblFoto;
	private JMenuItem mntmSalir;
	private JMenuItem mntmCerrarSesin;
	private JRadioButton rdbtnEspaol;
	private JRadioButton rdbtnIngls;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	public FramePrincipal(Doctor doctor, ArrayList<Doctor> usuarios) {
		addWindowListener(new ThisWindowListener());
		this.doctor=doctor;
		this.usuarios=usuarios;
		setBackground(SystemColor.text);
		setTitle(Messages.getString("FramePrincipal.0")); //$NON-NLS-1$
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FramePrincipal.class.getResource(Messages.getString("FramePrincipal.1")))); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 681);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelCardLayout = new JPanel();
		panelCardLayout.setBorder(null);
		panelCardLayout.setBackground(SystemColor.text);
		contentPane.add(panelCardLayout, BorderLayout.CENTER);
		panelCardLayout.setLayout(new CardLayout(0, 0));
		
		panelInicio = new PanelPrincipal(doctor,usuarios);
		panelCardLayout.add(panelInicio, Messages.getString("FramePrincipal.2")); //$NON-NLS-1$
		
		panelEspecialistas = new PanelEspecialista(doctor.getEspecialistas());
		panelCardLayout.add(panelEspecialistas, Messages.getString("FramePrincipal.3")); //$NON-NLS-1$
		
		panelAyuda = new JPanel();
		panelCardLayout.add(panelAyuda, Messages.getString("FramePrincipal.4")); //$NON-NLS-1$
		
		panelPacientes = new PanelPacientes(doctor.getPacientes());
		panelPacientes.setBorder(new TitledBorder(UIManager.getBorder(Messages.getString("FramePrincipal.5")), Messages.getString("FramePrincipal.6"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255))); //$NON-NLS-1$ //$NON-NLS-2$
		panelCardLayout.add(panelPacientes, Messages.getString("FramePrincipal.7")); //$NON-NLS-1$
			
		panelConsultas = new PanelConsultas(doctor);
		panelCardLayout.add(panelConsultas, Messages.getString("FramePrincipal.8")); //$NON-NLS-1$
		
		PanelPerfil panelPerfil = new PanelPerfil(doctor,usuarios);
		panelCardLayout.add(panelPerfil, Messages.getString("FramePrincipal.9")); //$NON-NLS-1$
		
		menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		menuBar.setBorder(new TitledBorder(null, Messages.getString("FramePrincipal.10"), TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK)); //$NON-NLS-1$
		menuBar.setBackground(Color.WHITE);
		menuBar.setFont(new Font(Messages.getString("FramePrincipal.11"), Font.BOLD, 14)); //$NON-NLS-1$
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnArchivo = new JMenu(Messages.getString("FramePrincipal.12")); //$NON-NLS-1$
		mnArchivo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnArchivo.setFont(new Font(Messages.getString("FramePrincipal.13"), Font.BOLD, 12)); //$NON-NLS-1$
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem(Messages.getString("HIJADEPUTA")); //$NON-NLS-1$
		mntmSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmSalir.setFont(new Font(Messages.getString("FramePrincipal.15"), Font.BOLD, 10)); //$NON-NLS-1$
		mntmSalir.addActionListener(new MntmCerrarSesionActionListener());
		
		mntmCerrarSesin = new JMenuItem(Messages.getString("FramePrincipal.16")); //$NON-NLS-1$
		mntmCerrarSesin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmCerrarSesin.setFont(new Font(Messages.getString("FramePrincipal.17"), Font.BOLD, 10)); //$NON-NLS-1$
		mntmCerrarSesin.addActionListener(new MntmCerrarSesinActionListener());
		mnArchivo.add(mntmCerrarSesin);
		
		JSeparator separator_2 = new JSeparator();
		mnArchivo.add(separator_2);
		mnArchivo.add(mntmSalir);
		
		JMenu mnArchivo_1 = new JMenu(Messages.getString("FramePrincipal.18")); //$NON-NLS-1$
		mnArchivo_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnArchivo_1.setFont(new Font(Messages.getString("FramePrincipal.19"), Font.BOLD, 12)); //$NON-NLS-1$
		menuBar.add(mnArchivo_1);
		
		JMenuItem mntmImprimir_1 = new JMenuItem(Messages.getString("FramePrincipal.20")); //$NON-NLS-1$
		mntmImprimir_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmImprimir_1.setFont(new Font(Messages.getString("FramePrincipal.21"), Font.BOLD, 10)); //$NON-NLS-1$
		mnArchivo_1.add(mntmImprimir_1);
		
		JSeparator separator_3 = new JSeparator();
		mnArchivo_1.add(separator_3);
		
		JMenu mnAyuda = new JMenu(Messages.getString("FramePrincipal.22")); //$NON-NLS-1$
		mnAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAyuda.setFont(new Font(Messages.getString("FramePrincipal.23"), Font.BOLD, 12)); //$NON-NLS-1$
		menuBar.add(mnAyuda);
		
		JSeparator separator_1 = new JSeparator();
		mnAyuda.add(separator_1);
		
		JMenuItem mntmManualDeUsuario = new JMenuItem(Messages.getString("FramePrincipal.24")); //$NON-NLS-1$
		mntmManualDeUsuario.addActionListener(new MntmManualDeUsuarioActionListener());
		
		JMenu mnIdioma = new JMenu(Messages.getString("FramePrincipal.mnIdioma.text")); //$NON-NLS-1$
		mnIdioma.setFont(new Font("Verdana", Font.BOLD, 10));
		mnAyuda.add(mnIdioma);
		
		rdbtnEspaol = new JRadioButton(Messages.getString("FramePrincipal.rdbtnEspaol.text")); //$NON-NLS-1$
		buttonGroup.add(rdbtnEspaol);
		mnIdioma.add(rdbtnEspaol);
		
		rdbtnIngls = new JRadioButton(Messages.getString("FramePrincipal.rdbtnIngls.text")); //$NON-NLS-1$
		rdbtnIngls.addActionListener(new RdbtnInglsActionListener());
		
		buttonGroup.add(rdbtnIngls);
		mnIdioma.add(rdbtnIngls);
		mntmManualDeUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmManualDeUsuario.setFont(new Font(Messages.getString("FramePrincipal.25"), Font.BOLD, 10)); //$NON-NLS-1$
		mnAyuda.add(mntmManualDeUsuario);
		
		JSeparator separator = new JSeparator();
		mnAyuda.add(separator);
		
		JMenuItem mntmAcerca = new JMenuItem(Messages.getString("FramePrincipal.26")); //$NON-NLS-1$
		mntmAcerca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmAcerca.setFont(new Font(Messages.getString("FramePrincipal.27"), Font.BOLD, 10)); //$NON-NLS-1$
		mntmAcerca.addActionListener(new MntmAcercaActionListener());
		mnAyuda.add(mntmAcerca);
		
		paneLateral = new JPanel();
		paneLateral.setBackground(SystemColor.text);
		contentPane.add(paneLateral, BorderLayout.WEST);
		GridBagLayout gbl_paneLateral = new GridBagLayout();
		gbl_paneLateral.columnWidths = new int[]{209, 12, 0};
		gbl_paneLateral.rowHeights = new int[]{161, 45, 45, 45, 45, 45, 0, 0, 0, 0};
		gbl_paneLateral.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_paneLateral.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		paneLateral.setLayout(gbl_paneLateral);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, Messages.getString("FramePrincipal.28"), TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop)); //$NON-NLS-1$
		scrollPane.setBackground(SystemColor.text);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		paneLateral.add(scrollPane, gbc_scrollPane);
		
		lblFoto = new JLabel(Messages.getString("FramePrincipal.29")); //$NON-NLS-1$
		lblFoto.setBackground(SystemColor.text);
		lblFoto.setIcon(doctor.getImage());
		scrollPane.setViewportView(lblFoto);
		
		JButton btnAtras = new JButton(Messages.getString("FramePrincipal.30")); //$NON-NLS-1$
		btnAtras.setHorizontalAlignment(SwingConstants.RIGHT);
		btnAtras.setIcon(new ImageIcon(FramePrincipal.class.getResource(Messages.getString("FramePrincipal.31")))); //$NON-NLS-1$
		btnAtras.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setBorder(null);
		btnAtras.setFont(new Font(Messages.getString("FramePrincipal.32"), Font.BOLD, 13)); //$NON-NLS-1$
		GridBagConstraints gbc_btnAtras = new GridBagConstraints();
		gbc_btnAtras.fill = GridBagConstraints.BOTH;
		gbc_btnAtras.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtras.gridx = 0;
		gbc_btnAtras.gridy = 1;
		paneLateral.add(btnAtras, gbc_btnAtras);
		btnAtras.addActionListener(new BtnAtrasActionListener());
		
		JButton btnConsultas = new JButton(Messages.getString("FramePrincipal.33")); //$NON-NLS-1$
		btnConsultas.setHorizontalTextPosition(SwingConstants.LEADING);
		btnConsultas.setHorizontalAlignment(SwingConstants.RIGHT);
		btnConsultas.setIcon(new ImageIcon(FramePrincipal.class.getResource(Messages.getString("FramePrincipal.34")))); //$NON-NLS-1$
		btnConsultas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultas.setBorder(null);
		btnConsultas.addActionListener(new BtnConsultasActionListener());
		
		JButton btnPerfil = new JButton(Messages.getString("FramePrincipal.35")); //$NON-NLS-1$
		btnPerfil.addActionListener(new BtnPerfilActionListener());
		btnPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
		btnPerfil.setHorizontalTextPosition(SwingConstants.LEADING);
		btnPerfil.setIcon(new ImageIcon(FramePrincipal.class.getResource(Messages.getString("FramePrincipal.36")))); //$NON-NLS-1$
		btnPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPerfil.setBorder(null);
		btnPerfil.setFont(new Font(Messages.getString("FramePrincipal.37"), Font.BOLD, 13)); //$NON-NLS-1$
		GridBagConstraints gbc_btnPerfil = new GridBagConstraints();
		gbc_btnPerfil.fill = GridBagConstraints.BOTH;
		gbc_btnPerfil.insets = new Insets(0, 0, 5, 5);
		gbc_btnPerfil.gridx = 0;
		gbc_btnPerfil.gridy = 2;
		paneLateral.add(btnPerfil, gbc_btnPerfil);
		
		JButton btnPacientes = new JButton(Messages.getString("FramePrincipal.38")); //$NON-NLS-1$
		btnPacientes.setHorizontalAlignment(SwingConstants.RIGHT);
		btnPacientes.setHorizontalTextPosition(SwingConstants.LEADING);
		btnPacientes.setIcon(new ImageIcon(FramePrincipal.class.getResource(Messages.getString("FramePrincipal.39")))); //$NON-NLS-1$
		btnPacientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPacientes.setBorder(null);
		btnPacientes.setFont(new Font(Messages.getString("FramePrincipal.40"), Font.BOLD, 13)); //$NON-NLS-1$
		GridBagConstraints gbc_btnPacientes = new GridBagConstraints();
		gbc_btnPacientes.fill = GridBagConstraints.BOTH;
		gbc_btnPacientes.insets = new Insets(0, 0, 5, 5);
		gbc_btnPacientes.gridx = 0;
		gbc_btnPacientes.gridy = 3;
		paneLateral.add(btnPacientes, gbc_btnPacientes);
		btnPacientes.addActionListener(new BtnPanelActionListener());
		btnConsultas.setFont(new Font(Messages.getString("FramePrincipal.41"), Font.BOLD, 13)); //$NON-NLS-1$
		GridBagConstraints gbc_btnConsultas = new GridBagConstraints();
		gbc_btnConsultas.fill = GridBagConstraints.BOTH;
		gbc_btnConsultas.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultas.gridx = 0;
		gbc_btnConsultas.gridy = 4;
		paneLateral.add(btnConsultas, gbc_btnConsultas);
		JButton btnEspecialistas = new JButton(Messages.getString("FramePrincipal.42")); //$NON-NLS-1$
		btnEspecialistas.setHorizontalAlignment(SwingConstants.RIGHT);
		btnEspecialistas.setHorizontalTextPosition(SwingConstants.LEADING);
		btnEspecialistas.setIcon(new ImageIcon(FramePrincipal.class.getResource(Messages.getString("FramePrincipal.43")))); //$NON-NLS-1$
		btnEspecialistas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEspecialistas.setBorder(null);
		btnEspecialistas.setFont(new Font(Messages.getString("FramePrincipal.44"), Font.BOLD, 13)); //$NON-NLS-1$
		GridBagConstraints gbc_btnEspecialistas = new GridBagConstraints();
		gbc_btnEspecialistas.fill = GridBagConstraints.BOTH;
		gbc_btnEspecialistas.insets = new Insets(0, 0, 5, 5);
		gbc_btnEspecialistas.gridx = 0;
		gbc_btnEspecialistas.gridy = 5;
		paneLateral.add(btnEspecialistas, gbc_btnEspecialistas);
		btnEspecialistas.addActionListener(new BtnEspecialistaActionListener());
		
		JCalendar calendar = new JCalendar();
		calendar.setFont(new Font(Messages.getString("FramePrincipal.45"), Font.BOLD, 9)); //$NON-NLS-1$
		calendar.setTodayButtonText(Messages.getString("FramePrincipal.46")); //$NON-NLS-1$
		calendar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		calendar.getDayChooser().getDayPanel().setFont(new Font(Messages.getString("FramePrincipal.47"), Font.BOLD, 11)); //$NON-NLS-1$
		calendar.getDayChooser().getDayPanel().setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		calendar.setWeekdayForeground(Color.BLACK);
		calendar.setTodayButtonVisible(true);
		calendar.setDecorationBackgroundColor(Color.LIGHT_GRAY);
		calendar.setBackground(SystemColor.text);
		calendar.getDayChooser().getDayPanel().setBackground(SystemColor.text);
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.gridheight = 2;
		gbc_calendar.insets = new Insets(0, 0, 0, 5);
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.gridx = 0;
		gbc_calendar.gridy = 7;
		paneLateral.add(calendar, gbc_calendar);
	}
	
	public void setImagen(ImageIcon image){
		lblFoto.setIcon(image);
	}
	
		
	private class BtnPanelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			CardLayout cl = (CardLayout)(panelCardLayout.getLayout());
			cl.show(panelCardLayout, Messages.getString("FramePrincipal.48")); //$NON-NLS-1$

		}
	}
	private class BtnEspecialistaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			CardLayout cl = (CardLayout)(panelCardLayout.getLayout());
			cl.show(panelCardLayout, Messages.getString("FramePrincipal.49")); //$NON-NLS-1$
			
		}
	}
	private class BtnAtrasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			CardLayout cl = (CardLayout)(panelCardLayout.getLayout());
			cl.show(panelCardLayout, Messages.getString("FramePrincipal.50")); //$NON-NLS-1$
			
		}
	}

	private class BtnConsultasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			CardLayout cl = (CardLayout)(panelCardLayout.getLayout());
			cl.show(panelCardLayout, Messages.getString("FramePrincipal.51")); //$NON-NLS-1$
		}
		
	}
	private class BtnPerfilActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			CardLayout cl = (CardLayout)(panelCardLayout.getLayout());
			cl.show(panelCardLayout, Messages.getString("FramePrincipal.52")); //$NON-NLS-1$
		}
	}
	private class MntmCerrarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(JOptionPane.showConfirmDialog(new JFrame(), Messages.getString("FramePrincipal.53"), Messages.getString("FramePrincipal.54"), //$NON-NLS-1$ //$NON-NLS-2$
						JOptionPane.OK_CANCEL_OPTION )==JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(new JFrame(), Messages.getString("FramePrincipal.55"), Messages.getString("FramePrincipal.56"), JOptionPane.PLAIN_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				System.exit(0);
			}
		}
	}
	private class MntmAcercaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			FrameAcercaDe frame = new FrameAcercaDe();
			frame.setVisible(true);
		}
	}
	private class MntmCerrarSesinActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(JOptionPane.showConfirmDialog(new JFrame(), Messages.getString("FramePrincipal.57"), Messages.getString("FramePrincipal.58"), //$NON-NLS-1$ //$NON-NLS-2$
					JOptionPane.OK_CANCEL_OPTION )==JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(new JFrame(), Messages.getString("FramePrincipal.59"), Messages.getString("FramePrincipal.60"), JOptionPane.PLAIN_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				dispose();
				FrameLogin login = new FrameLogin(usuarios);
				login.setVisible(true);
			
			}
		}
	}
	private class MntmManualDeUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFrameManual frame= new JFrameManual();
			frame.setVisible(true);
			
		}
	}
	private class RdbtnInglsActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (rdbtnIngls.isSelected())
				Messages.setIdioma("inglés");
			    BorrarPaciente bp = new BorrarPaciente(null);
			    bp.setVisible(true);
				
			
		}
	}
	
	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosed(WindowEvent arg0) {
			if(JOptionPane.showConfirmDialog(new JFrame(), "Estás seguro que deseas salir de la aplicación", "",
					JOptionPane.OK_CANCEL_OPTION )==JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(new JFrame(), "Gracias por utilizar la aplicación", "Cerrar aplicación", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		}
	}
	
	
	
}