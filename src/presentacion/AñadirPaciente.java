package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dominio.Paciente;

import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Cursor;

public class AñadirPaciente extends JFrame {

	private JPanel contentPane; 
	private JButton btnCancelar;
	private JLabel lblNombre;
	private JTextField textNombre;
	private JLabel lblApellidos;
	private JTextField textApellidos;
	private JLabel lblDni;
	private JTextField textDNI;
	private JLabel lblNewLabel;
	private JTextField textFecha;
	private JLabel lblNacionalidad;
	private JTextField textNacion;
	private JLabel lblDireccin;
	private JTextField textDireccion;
	private JLabel lblMunicipio;
	private JTextField textMunicipio;
	private JLabel lblCodigoPostal;
	private JTextField textCP;
	private JLabel lblGnero;
	private JRadioButton rdbtnF;
	private JRadioButton rdbtnM;
	private JLabel lblNPaciente;
	private JButton btnAñadir;
	private JButton btnLimpiar;
	private JTextField textNumero;
	ArrayList<Paciente> pacientes;

	public AñadirPaciente(ArrayList<Paciente> pacientes) {
		this.pacientes=pacientes;
		setType(Type.POPUP);
		setResizable(false);
		setTitle(Messages.getString("AñadirPaciente.0")); //$NON-NLS-1$
		setIconImage(Toolkit.getDefaultToolkit().getImage(AñadirPaciente.class.getResource(Messages.getString("AñadirPaciente.1")))); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 723, 378);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(10, 10, 0, 0));
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new TitledBorder(UIManager.getBorder(Messages.getString("AñadirPaciente.2")), Messages.getString("AñadirPaciente.3"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))); //$NON-NLS-1$ //$NON-NLS-2$
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		panelBotones.setPreferredSize(new Dimension(10, 35));
		panelBotones.setBackground(SystemColor.menu);
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		btnCancelar = new JButton(Messages.getString("AñadirPaciente.4")); //$NON-NLS-1$
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(229, 5, 89, 25);
		btnCancelar.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.5"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		btnCancelar.addActionListener(new BtnCancelarActionListener());
		panelBotones.setLayout(null);
		btnCancelar.setFont(new Font(Messages.getString("AñadirPaciente.6"), Font.BOLD, 11)); //$NON-NLS-1$
		panelBotones.add(btnCancelar);
		
		btnLimpiar = new JButton(Messages.getString("AñadirPaciente.7")); //$NON-NLS-1$
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setBounds(323, 5, 81, 25);
		btnLimpiar.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.8"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		btnLimpiar.addActionListener(new BtnLimpiarActionListener());
		btnLimpiar.setFont(new Font(Messages.getString("AñadirPaciente.9"), Font.BOLD, 11)); //$NON-NLS-1$
		panelBotones.add(btnLimpiar);
		
		btnAñadir = new JButton(Messages.getString("AñadirPaciente.10")); //$NON-NLS-1$
		btnAñadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAñadir.setBounds(409, 5, 75, 25);
		btnAñadir.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.11"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		btnAñadir.addActionListener(new BtnAñadirActionListener());
		btnAñadir.setFont(new Font(Messages.getString("AñadirPaciente.12"), Font.BOLD, 11)); //$NON-NLS-1$
		panelBotones.add(btnAñadir);
		panelBotones.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.13"), TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK)); //$NON-NLS-1$
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblNombre = new JLabel(Messages.getString("AñadirPaciente.14")); //$NON-NLS-1$
		lblNombre.setBounds(34, 45, 55, 36);
		lblNombre.setFont(new Font(Messages.getString("AñadirPaciente.15"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(99, 52, 129, 29);
		textNombre.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.16"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textNombre.setBackground(SystemColor.scrollbar);
		textNombre.setFont(new Font(Messages.getString("AñadirPaciente.17"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		lblApellidos = new JLabel(Messages.getString("AñadirPaciente.18")); //$NON-NLS-1$
		lblApellidos.setBounds(262, 45, 64, 36);
		lblApellidos.setFont(new Font(Messages.getString("AñadirPaciente.19"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(336, 52, 151, 29);
		textApellidos.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.20"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textApellidos.setBackground(SystemColor.scrollbar);
		textApellidos.setFont(new Font(Messages.getString("AñadirPaciente.21"), Font.BOLD, 11)); //$NON-NLS-1$
		textApellidos.setColumns(10);
		panel.add(textApellidos);
		
		lblDni = new JLabel(Messages.getString("AñadirPaciente.22")); //$NON-NLS-1$
		lblDni.setBounds(534, 45, 28, 36);
		lblDni.setFont(new Font(Messages.getString("AñadirPaciente.23"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblDni);
		
		textDNI = new JTextField();
		textDNI.setBounds(572, 52, 120, 29);
		textDNI.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.24"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textDNI.setBackground(SystemColor.scrollbar);
		textDNI.setFont(new Font(Messages.getString("AñadirPaciente.25"), Font.BOLD, 11)); //$NON-NLS-1$
		textDNI.setColumns(10);
		panel.add(textDNI);
		
		lblNewLabel = new JLabel(Messages.getString("AñadirPaciente.26")); //$NON-NLS-1$
		lblNewLabel.setBounds(29, 116, 120, 36);
		lblNewLabel.setFont(new Font(Messages.getString("AñadirPaciente.27"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblNewLabel);
		
		textFecha = new JTextField();
		textFecha.setBounds(155, 123, 73, 29);
		textFecha.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.28"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textFecha.setBackground(SystemColor.scrollbar);
		textFecha.setFont(new Font(Messages.getString("AñadirPaciente.29"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(textFecha);
		textFecha.setColumns(10);
		
		lblNacionalidad = new JLabel(Messages.getString("AñadirPaciente.30")); //$NON-NLS-1$
		lblNacionalidad.setBounds(238, 116, 88, 36);
		lblNacionalidad.setFont(new Font(Messages.getString("AñadirPaciente.31"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblNacionalidad);
		
		textNacion = new JTextField();
		textNacion.setBounds(336, 123, 151, 29);
		textNacion.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.32"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textNacion.setBackground(SystemColor.scrollbar);
		textNacion.setFont(new Font(Messages.getString("AñadirPaciente.33"), Font.BOLD, 11)); //$NON-NLS-1$
		textNacion.setColumns(10);
		panel.add(textNacion);
		
		lblDireccin = new JLabel(Messages.getString("AñadirPaciente.34")); //$NON-NLS-1$
		lblDireccin.setBounds(497, 116, 65, 36);
		lblDireccin.setFont(new Font(Messages.getString("AñadirPaciente.35"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblDireccin);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(572, 123, 120, 29);
		textDireccion.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.36"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textDireccion.setBackground(SystemColor.scrollbar);
		textDireccion.setFont(new Font(Messages.getString("AñadirPaciente.37"), Font.BOLD, 11)); //$NON-NLS-1$
		textDireccion.setColumns(10);
		panel.add(textDireccion);
		
		lblMunicipio = new JLabel(Messages.getString("AñadirPaciente.38")); //$NON-NLS-1$
		lblMunicipio.setBounds(34, 190, 65, 37);
		lblMunicipio.setFont(new Font(Messages.getString("AñadirPaciente.39"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblMunicipio);
		
		textMunicipio = new JTextField();
		textMunicipio.setBounds(109, 194, 119, 31);
		textMunicipio.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.40"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textMunicipio.setBackground(SystemColor.scrollbar);
		textMunicipio.setFont(new Font(Messages.getString("AñadirPaciente.41"), Font.BOLD, 11)); //$NON-NLS-1$
		textMunicipio.setColumns(10);
		panel.add(textMunicipio);
		
		lblCodigoPostal = new JLabel(Messages.getString("AñadirPaciente.42")); //$NON-NLS-1$
		lblCodigoPostal.setBounds(238, 188, 92, 37);
		lblCodigoPostal.setFont(new Font(Messages.getString("AñadirPaciente.43"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblCodigoPostal);
		
		textCP = new JTextField();
		textCP.setBounds(336, 194, 151, 31);
		textCP.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.44"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textCP.setBackground(SystemColor.scrollbar);
		textCP.setFont(new Font(Messages.getString("AñadirPaciente.45"), Font.BOLD, 11)); //$NON-NLS-1$
		textCP.setColumns(10);
		panel.add(textCP);
		
		lblGnero = new JLabel(Messages.getString("AñadirPaciente.46")); //$NON-NLS-1$
		lblGnero.setBounds(511, 190, 51, 37);
		lblGnero.setFont(new Font(Messages.getString("AñadirPaciente.47"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblGnero);
		
		rdbtnF = new JRadioButton(Messages.getString("AñadirPaciente.48")); //$NON-NLS-1$
		rdbtnF.addActionListener(new RdbtnFActionListener());
		rdbtnF.setBounds(572, 196, 33, 25);
		rdbtnF.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.49"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		rdbtnF.setBackground(SystemColor.scrollbar);
		rdbtnF.setFont(new Font(Messages.getString("AñadirPaciente.50"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(rdbtnF);
		
		rdbtnM = new JRadioButton(Messages.getString("AñadirPaciente.51")); //$NON-NLS-1$
		rdbtnM.addActionListener(new RdbtnMActionListener());
		rdbtnM.setBounds(615, 196, 35, 25);
		rdbtnM.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.52"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		rdbtnM.setBackground(SystemColor.scrollbar);
		rdbtnM.setFont(new Font(Messages.getString("AñadirPaciente.53"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(rdbtnM);
		
		if(rdbtnM.isSelected()){
			rdbtnF.setSelected(false);
		}
		
		lblNPaciente = new JLabel(Messages.getString("AñadirPaciente.54")); //$NON-NLS-1$
		lblNPaciente.setBounds(81, 260, 73, 36);
		lblNPaciente.setFont(new Font(Messages.getString("AñadirPaciente.55"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblNPaciente);
		
		textNumero = new JTextField();
		textNumero.setEditable(false);
		textNumero.setText(Messages.getString("AñadirPaciente.56")+(pacientes.size()+1)); //$NON-NLS-1$
		textNumero.setBounds(159, 266, 69, 30);
		textNumero.setBorder(new TitledBorder(null, Messages.getString("AñadirPaciente.57"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textNumero.setBackground(SystemColor.scrollbar);
		textNumero.setFont(new Font(Messages.getString("AñadirPaciente.58"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(textNumero);
		textNumero.setColumns(10);
		
	}
	
	public void limpiar(){
		textNombre.setText(Messages.getString("AñadirPaciente.59")); //$NON-NLS-1$
		textApellidos.setText(Messages.getString("AñadirPaciente.60")); //$NON-NLS-1$
		textDNI.setText(Messages.getString("AñadirPaciente.61")); //$NON-NLS-1$
		textFecha.setText(Messages.getString("AñadirPaciente.62")); //$NON-NLS-1$
		textNacion.setText(Messages.getString("AñadirPaciente.63")); //$NON-NLS-1$
		textDireccion.setText(Messages.getString("AñadirPaciente.64")); //$NON-NLS-1$
		textMunicipio.setText(Messages.getString("AñadirPaciente.65")); //$NON-NLS-1$
		textCP.setText(Messages.getString("AñadirPaciente.66")); //$NON-NLS-1$
		textNumero.setText(Messages.getString("AñadirPaciente.67")+(pacientes.size()+1)); //$NON-NLS-1$
		rdbtnF.setSelected(false);
		rdbtnM.setSelected(false);
	}

	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			limpiar();
		}
	}
	private class BtnCancelarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	private class BtnAñadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombre=textNombre.getText();
			String apellidos=textApellidos.getText();
			String DNI= textDNI.getText();
			String fecha= textFecha.getText();
			String nacion = textNacion.getText();
			String direccion = textDireccion.getText();
			String municipio= textMunicipio.getText();
			String cp = textCP.getText();
			String npaciente= textNumero.getText();
			String sexo;
			if(nombre.equals(Messages.getString("AñadirPaciente.68"))){ //$NON-NLS-1$
				JOptionPane.showMessageDialog(new JFrame(), Messages.getString("AñadirPaciente.69"), //$NON-NLS-1$
						Messages.getString("AñadirPaciente.70"),JOptionPane.PLAIN_MESSAGE ); //$NON-NLS-1$
			}else{
				if(rdbtnF.isSelected()){
					sexo=Messages.getString("AñadirPaciente.71"); //$NON-NLS-1$
				}else{
					sexo=Messages.getString("AñadirPaciente.72"); //$NON-NLS-1$
				}
				Paciente paciente = new Paciente(npaciente,nombre,apellidos,nacion,direccion,municipio,cp ,DNI,fecha,sexo);
				if(JOptionPane.showConfirmDialog(new JFrame (), Messages.getString("AñadirPaciente.73"), Messages.getString("AñadirPaciente.74"),  //$NON-NLS-1$ //$NON-NLS-2$
						JOptionPane.OK_CANCEL_OPTION)==JOptionPane.YES_OPTION){
					pacientes.add(paciente);
					JOptionPane.showMessageDialog(new JFrame (), Messages.getString("AñadirPaciente.75")); //$NON-NLS-1$
					limpiar();
				}
				
			}
		}
	}
	private class RdbtnFActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnF.isSelected()){
				rdbtnM.setSelected(false);
			}
		}
	}
	private class RdbtnMActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(rdbtnM.isSelected()){
				rdbtnF.setSelected(false);
			}
		}
	}
	
}
