package presentacion;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import dominio.Consulta;
import dominio.Especialista;
import dominio.LeerDatos;
import dominio.Paciente;
import dominio.Doctor;

import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.text.SimpleDateFormat;
import java.util.*;
import org.edisoncor.gui.varios.ClockFace;
import org.edisoncor.gui.varios.BarraTitle;
import org.edisoncor.gui.util.BloomViewer;
import org.edisoncor.gui.util.ColorUtilities;


public class PanelPrincipal extends JPanel {
	private JButton btnNCrearConsulta;
	private JButton btnCrearPaciente;
	private JButton btnProfesional;
	private JButton btnBorrar;
	private JButton btnCerrar;
	private ArrayList<Doctor> usuarios;
	private ArrayList<Paciente> pacientes;
	private ArrayList<Especialista> especialistas;
	private ArrayList<Consulta> consultas;
	private Doctor doctor;
	private String hora,min; 
	
	

	
	public PanelPrincipal(Doctor doctor,ArrayList<Doctor> usuarios) {
		this.doctor=doctor;
		this.usuarios=usuarios;
		pacientes=doctor.getPacientes();
		especialistas=doctor.getEspecialistas();
		consultas=doctor.getConsultas();
		setBackground(SystemColor.text);
		
		GridBagLayout gbl_panelInicio = new GridBagLayout();
		gbl_panelInicio.columnWidths = new int[]{32, 216, 200, 200, 19, 0};
		gbl_panelInicio.rowHeights = new int[]{49, 0, 42, 37, 0, 304, 0, 304, 0, 0};
		gbl_panelInicio.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelInicio.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_panelInicio);
		
		JLabel lblPanelPrincipal = new JLabel(Messages.getString("PanelPrincipal.0")); //$NON-NLS-1$
		lblPanelPrincipal.setFont(new Font(Messages.getString("PanelPrincipal.1"), Font.BOLD, 18)); //$NON-NLS-1$
		GridBagConstraints gbc_lblPanelPrincipal = new GridBagConstraints();
		gbc_lblPanelPrincipal.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPanelPrincipal.insets = new Insets(0, 0, 5, 5);
		gbc_lblPanelPrincipal.gridx = 1;
		gbc_lblPanelPrincipal.gridy = 0;
		add(lblPanelPrincipal, gbc_lblPanelPrincipal);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel(Messages.getString("PanelPrincipal.2")+doctor.getNombre()+Messages.getString("PanelPrincipal.3")+doctor.getApellidos()); //$NON-NLS-1$ //$NON-NLS-2$
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		ClockFace clockFace = new ClockFace();
		clockFace.setRomano(false);
		clockFace.setBackground(SystemColor.menu);
		clockFace.setBounds(82, 11, 117, 113);
		panel.add(clockFace);
		
		JLabel lblNewLabel = new JLabel(Messages.getString("PanelPrincipal.4")); //$NON-NLS-1$
		lblNewLabel.setFont(new Font(Messages.getString("PanelPrincipal.5"), Font.BOLD, 14)); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panelControles = new JPanel();
		panelControles.setBorder(null);
		panelControles.setBackground(SystemColor.text);
		GridBagConstraints gbc_panelControles = new GridBagConstraints();
		gbc_panelControles.gridwidth = 3;
		gbc_panelControles.gridheight = 3;
		gbc_panelControles.insets = new Insets(0, 0, 5, 5);
		gbc_panelControles.fill = GridBagConstraints.BOTH;
		gbc_panelControles.gridx = 1;
		gbc_panelControles.gridy = 5;
		add(panelControles, gbc_panelControles);
		panelControles.setLayout(new GridLayout(2, 3,15, 15));
		
		btnCrearPaciente = new JButton(Messages.getString("PanelPrincipal.6")); //$NON-NLS-1$
		btnCrearPaciente.addActionListener(new BtnCrearPacienteActionListener());
		btnCrearPaciente.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCrearPaciente.setIcon(new ImageIcon(PanelPrincipal.class.getResource(Messages.getString("PanelPrincipal.7")))); //$NON-NLS-1$
		btnCrearPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearPaciente.setFont(new Font(Messages.getString("PanelPrincipal.8"), Font.BOLD, 11)); //$NON-NLS-1$
		btnCrearPaciente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnCrearPaciente.setToolTipText(Messages.getString("PanelPrincipal.9")); //$NON-NLS-1$
		panelControles.add(btnCrearPaciente);
		
		btnBorrar = new JButton(Messages.getString("PanelPrincipal.10")); //$NON-NLS-1$
		btnBorrar.addActionListener(new BtnBorrarActionListener());
		btnBorrar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnBorrar.setIcon(new ImageIcon(PanelPrincipal.class.getResource(Messages.getString("PanelPrincipal.11")))); //$NON-NLS-1$
		btnBorrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBorrar.setFont(new Font(Messages.getString("PanelPrincipal.12"), Font.BOLD, 11)); //$NON-NLS-1$
		btnBorrar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnBorrar.setToolTipText(Messages.getString("PanelPrincipal.13")); //$NON-NLS-1$
		panelControles.add(btnBorrar);
		
		JButton btnBuscar = new JButton(Messages.getString("PanelPrincipal.14")); //$NON-NLS-1$
		btnBuscar.setToolTipText(Messages.getString("PanelPrincipal.15")); //$NON-NLS-1$
		btnBuscar.addActionListener(new BtnBuscarActionListener());
		btnBuscar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnBuscar.setIcon(new ImageIcon(PanelPrincipal.class.getResource(Messages.getString("PanelPrincipal.16")))); //$NON-NLS-1$
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setFont(new Font(Messages.getString("PanelPrincipal.17"), Font.BOLD, 11)); //$NON-NLS-1$
		btnBuscar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelControles.add(btnBuscar);
		
		/*Boton btnNewButton_3 = new Boton("Puta ahí",Color.BLUE, Color.RED,30,30);
		panelControles.add(btnNewButton_3);*/
		
		btnProfesional = new JButton(Messages.getString("PanelPrincipal.18")); //$NON-NLS-1$
		btnProfesional.setToolTipText(Messages.getString("PanelPrincipal.19")); //$NON-NLS-1$
		btnProfesional.addActionListener(new BtnProfesionalActionListener());
		btnProfesional.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnProfesional.setIcon(new ImageIcon(PanelPrincipal.class.getResource(Messages.getString("PanelPrincipal.20")))); //$NON-NLS-1$
		btnProfesional.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProfesional.setFont(new Font(Messages.getString("PanelPrincipal.21"), Font.BOLD, 11)); //$NON-NLS-1$
		btnProfesional.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelControles.add(btnProfesional);
		
		btnCerrar = new JButton(Messages.getString("PanelPrincipal.22")); //$NON-NLS-1$
		btnCerrar.setToolTipText(Messages.getString("PanelPrincipal.23")); //$NON-NLS-1$
		btnCerrar.setIcon(new ImageIcon(PanelPrincipal.class.getResource(Messages.getString("PanelPrincipal.24")))); //$NON-NLS-1$
		btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrar.setFont(new Font(Messages.getString("PanelPrincipal.25"), Font.BOLD, 11)); //$NON-NLS-1$
		btnCerrar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnCerrar.addActionListener(new BtnCerrarActionListener());
		
		btnNCrearConsulta = new JButton(Messages.getString("PanelPrincipal.26")); //$NON-NLS-1$
		btnNCrearConsulta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNCrearConsulta.addActionListener(new BtnNCrearConsultaActionListener());
		btnNCrearConsulta.setIcon(new ImageIcon(PanelPrincipal.class.getResource(Messages.getString("PanelPrincipal.27")))); //$NON-NLS-1$
		btnNCrearConsulta.setToolTipText(Messages.getString("PanelPrincipal.28")); //$NON-NLS-1$
		btnNCrearConsulta.setFont(new Font(Messages.getString("PanelPrincipal.29"), Font.BOLD, 11)); //$NON-NLS-1$
		btnNCrearConsulta.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelControles.add(btnNCrearConsulta);
		panelControles.add(btnCerrar);
	}
	public String fecha(){
		Date fecha=new Date();
		SimpleDateFormat formatofecha = new SimpleDateFormat(Messages.getString("PanelPrincipal.30")); //$NON-NLS-1$
		return formatofecha.format(fecha);
	}
	public void hora(){
		Calendar cal=new GregorianCalendar();
		Date horaActual= new Date(); 
		cal.setTime(horaActual);
		hora=cal.get(Calendar.HOUR_OF_DAY)>9?Messages.getString("PanelPrincipal.31")+cal.get(Calendar.HOUR_OF_DAY):Messages.getString("PanelPrincipal.32")+ cal.get(Calendar.HOUR_OF_DAY); //$NON-NLS-1$ //$NON-NLS-2$
		min=cal.get(Calendar.MINUTE)>9?Messages.getString("PanelPrincipal.33")+cal.get(Calendar.MINUTE):Messages.getString("PanelPrincipal.34")+cal.get(Calendar.MINUTE); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	
	void cerrarFrame(){  //Metodo que cierra el Frame que contiene a este Panel
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
		frame.dispose();
	}
	
	
	private class BtnCerrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(JOptionPane.showConfirmDialog(new JFrame(), Messages.getString("PanelPrincipal.35"), Messages.getString("PanelPrincipal.36"), //$NON-NLS-1$ //$NON-NLS-2$
					JOptionPane.OK_CANCEL_OPTION )==JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(new JFrame(), Messages.getString("PanelPrincipal.37"), Messages.getString("PanelPrincipal.38"), JOptionPane.PLAIN_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				cerrarFrame();
				FrameLogin login = new FrameLogin(usuarios);
				login.setVisible(true);
			
			}
		}
	}
	private class BtnCrearPacienteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AñadirPaciente a=new AñadirPaciente(pacientes);
			a.setVisible(true);
		}
	}
	private class BtnProfesionalActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ConsultaEsp esp =new ConsultaEsp(especialistas);
			esp.setVisible(true);
		}
	}
	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			BorrarPaciente borrar= new BorrarPaciente(pacientes);
			borrar.setVisible(true);
		}
	}
	private class BtnNCrearConsultaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AnadirConsulta consulta =new AnadirConsulta(doctor);
			consulta.setVisible(true);
		}
	}
	private class BtnBuscarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			BuscarPaciente pac = new BuscarPaciente(usuarios);
			pac.setVisible(true);
		}
	}
}
