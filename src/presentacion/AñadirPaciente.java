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

public class A�adirPaciente extends JFrame {

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
	private JButton btnA�adir;
	private JButton btnLimpiar;
	private JTextField textNumero;
	ArrayList<Paciente> pacientes;

	public A�adirPaciente(ArrayList<Paciente> pacientes) {
		this.pacientes=pacientes;
		setType(Type.POPUP);
		setResizable(false);
		setTitle(Messages.getString("A�adirPaciente.0")); //$NON-NLS-1$
		setIconImage(Toolkit.getDefaultToolkit().getImage(A�adirPaciente.class.getResource(Messages.getString("A�adirPaciente.1")))); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 723, 378);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(10, 10, 0, 0));
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new TitledBorder(UIManager.getBorder(Messages.getString("A�adirPaciente.2")), Messages.getString("A�adirPaciente.3"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))); //$NON-NLS-1$ //$NON-NLS-2$
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		panelBotones.setPreferredSize(new Dimension(10, 35));
		panelBotones.setBackground(SystemColor.menu);
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		btnCancelar = new JButton(Messages.getString("A�adirPaciente.4")); //$NON-NLS-1$
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(229, 5, 89, 25);
		btnCancelar.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.5"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		btnCancelar.addActionListener(new BtnCancelarActionListener());
		panelBotones.setLayout(null);
		btnCancelar.setFont(new Font(Messages.getString("A�adirPaciente.6"), Font.BOLD, 11)); //$NON-NLS-1$
		panelBotones.add(btnCancelar);
		
		btnLimpiar = new JButton(Messages.getString("A�adirPaciente.7")); //$NON-NLS-1$
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setBounds(323, 5, 81, 25);
		btnLimpiar.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.8"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		btnLimpiar.addActionListener(new BtnLimpiarActionListener());
		btnLimpiar.setFont(new Font(Messages.getString("A�adirPaciente.9"), Font.BOLD, 11)); //$NON-NLS-1$
		panelBotones.add(btnLimpiar);
		
		btnA�adir = new JButton(Messages.getString("A�adirPaciente.10")); //$NON-NLS-1$
		btnA�adir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnA�adir.setBounds(409, 5, 75, 25);
		btnA�adir.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.11"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		btnA�adir.addActionListener(new BtnA�adirActionListener());
		btnA�adir.setFont(new Font(Messages.getString("A�adirPaciente.12"), Font.BOLD, 11)); //$NON-NLS-1$
		panelBotones.add(btnA�adir);
		panelBotones.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.13"), TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK)); //$NON-NLS-1$
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblNombre = new JLabel(Messages.getString("A�adirPaciente.14")); //$NON-NLS-1$
		lblNombre.setBounds(34, 45, 55, 36);
		lblNombre.setFont(new Font(Messages.getString("A�adirPaciente.15"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(99, 52, 129, 29);
		textNombre.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.16"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textNombre.setBackground(SystemColor.scrollbar);
		textNombre.setFont(new Font(Messages.getString("A�adirPaciente.17"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		lblApellidos = new JLabel(Messages.getString("A�adirPaciente.18")); //$NON-NLS-1$
		lblApellidos.setBounds(262, 45, 64, 36);
		lblApellidos.setFont(new Font(Messages.getString("A�adirPaciente.19"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(336, 52, 151, 29);
		textApellidos.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.20"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textApellidos.setBackground(SystemColor.scrollbar);
		textApellidos.setFont(new Font(Messages.getString("A�adirPaciente.21"), Font.BOLD, 11)); //$NON-NLS-1$
		textApellidos.setColumns(10);
		panel.add(textApellidos);
		
		lblDni = new JLabel(Messages.getString("A�adirPaciente.22")); //$NON-NLS-1$
		lblDni.setBounds(534, 45, 28, 36);
		lblDni.setFont(new Font(Messages.getString("A�adirPaciente.23"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblDni);
		
		textDNI = new JTextField();
		textDNI.setBounds(572, 52, 120, 29);
		textDNI.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.24"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textDNI.setBackground(SystemColor.scrollbar);
		textDNI.setFont(new Font(Messages.getString("A�adirPaciente.25"), Font.BOLD, 11)); //$NON-NLS-1$
		textDNI.setColumns(10);
		panel.add(textDNI);
		
		lblNewLabel = new JLabel(Messages.getString("A�adirPaciente.26")); //$NON-NLS-1$
		lblNewLabel.setBounds(29, 116, 120, 36);
		lblNewLabel.setFont(new Font(Messages.getString("A�adirPaciente.27"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblNewLabel);
		
		textFecha = new JTextField();
		textFecha.setBounds(155, 123, 73, 29);
		textFecha.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.28"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textFecha.setBackground(SystemColor.scrollbar);
		textFecha.setFont(new Font(Messages.getString("A�adirPaciente.29"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(textFecha);
		textFecha.setColumns(10);
		
		lblNacionalidad = new JLabel(Messages.getString("A�adirPaciente.30")); //$NON-NLS-1$
		lblNacionalidad.setBounds(238, 116, 88, 36);
		lblNacionalidad.setFont(new Font(Messages.getString("A�adirPaciente.31"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblNacionalidad);
		
		textNacion = new JTextField();
		textNacion.setBounds(336, 123, 151, 29);
		textNacion.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.32"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textNacion.setBackground(SystemColor.scrollbar);
		textNacion.setFont(new Font(Messages.getString("A�adirPaciente.33"), Font.BOLD, 11)); //$NON-NLS-1$
		textNacion.setColumns(10);
		panel.add(textNacion);
		
		lblDireccin = new JLabel(Messages.getString("A�adirPaciente.34")); //$NON-NLS-1$
		lblDireccin.setBounds(497, 116, 65, 36);
		lblDireccin.setFont(new Font(Messages.getString("A�adirPaciente.35"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblDireccin);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(572, 123, 120, 29);
		textDireccion.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.36"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textDireccion.setBackground(SystemColor.scrollbar);
		textDireccion.setFont(new Font(Messages.getString("A�adirPaciente.37"), Font.BOLD, 11)); //$NON-NLS-1$
		textDireccion.setColumns(10);
		panel.add(textDireccion);
		
		lblMunicipio = new JLabel(Messages.getString("A�adirPaciente.38")); //$NON-NLS-1$
		lblMunicipio.setBounds(34, 190, 65, 37);
		lblMunicipio.setFont(new Font(Messages.getString("A�adirPaciente.39"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblMunicipio);
		
		textMunicipio = new JTextField();
		textMunicipio.setBounds(109, 194, 119, 31);
		textMunicipio.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.40"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textMunicipio.setBackground(SystemColor.scrollbar);
		textMunicipio.setFont(new Font(Messages.getString("A�adirPaciente.41"), Font.BOLD, 11)); //$NON-NLS-1$
		textMunicipio.setColumns(10);
		panel.add(textMunicipio);
		
		lblCodigoPostal = new JLabel(Messages.getString("A�adirPaciente.42")); //$NON-NLS-1$
		lblCodigoPostal.setBounds(238, 188, 92, 37);
		lblCodigoPostal.setFont(new Font(Messages.getString("A�adirPaciente.43"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblCodigoPostal);
		
		textCP = new JTextField();
		textCP.setBounds(336, 194, 151, 31);
		textCP.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.44"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textCP.setBackground(SystemColor.scrollbar);
		textCP.setFont(new Font(Messages.getString("A�adirPaciente.45"), Font.BOLD, 11)); //$NON-NLS-1$
		textCP.setColumns(10);
		panel.add(textCP);
		
		lblGnero = new JLabel(Messages.getString("A�adirPaciente.46")); //$NON-NLS-1$
		lblGnero.setBounds(511, 190, 51, 37);
		lblGnero.setFont(new Font(Messages.getString("A�adirPaciente.47"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblGnero);
		
		rdbtnF = new JRadioButton(Messages.getString("A�adirPaciente.48")); //$NON-NLS-1$
		rdbtnF.addActionListener(new RdbtnFActionListener());
		rdbtnF.setBounds(572, 196, 33, 25);
		rdbtnF.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.49"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		rdbtnF.setBackground(SystemColor.scrollbar);
		rdbtnF.setFont(new Font(Messages.getString("A�adirPaciente.50"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(rdbtnF);
		
		rdbtnM = new JRadioButton(Messages.getString("A�adirPaciente.51")); //$NON-NLS-1$
		rdbtnM.addActionListener(new RdbtnMActionListener());
		rdbtnM.setBounds(615, 196, 35, 25);
		rdbtnM.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.52"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		rdbtnM.setBackground(SystemColor.scrollbar);
		rdbtnM.setFont(new Font(Messages.getString("A�adirPaciente.53"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(rdbtnM);
		
		if(rdbtnM.isSelected()){
			rdbtnF.setSelected(false);
		}
		
		lblNPaciente = new JLabel(Messages.getString("A�adirPaciente.54")); //$NON-NLS-1$
		lblNPaciente.setBounds(81, 260, 73, 36);
		lblNPaciente.setFont(new Font(Messages.getString("A�adirPaciente.55"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(lblNPaciente);
		
		textNumero = new JTextField();
		textNumero.setEditable(false);
		textNumero.setText(Messages.getString("A�adirPaciente.56")+(pacientes.size()+1)); //$NON-NLS-1$
		textNumero.setBounds(159, 266, 69, 30);
		textNumero.setBorder(new TitledBorder(null, Messages.getString("A�adirPaciente.57"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		textNumero.setBackground(SystemColor.scrollbar);
		textNumero.setFont(new Font(Messages.getString("A�adirPaciente.58"), Font.BOLD, 11)); //$NON-NLS-1$
		panel.add(textNumero);
		textNumero.setColumns(10);
		
	}
	
	public void limpiar(){
		textNombre.setText(Messages.getString("A�adirPaciente.59")); //$NON-NLS-1$
		textApellidos.setText(Messages.getString("A�adirPaciente.60")); //$NON-NLS-1$
		textDNI.setText(Messages.getString("A�adirPaciente.61")); //$NON-NLS-1$
		textFecha.setText(Messages.getString("A�adirPaciente.62")); //$NON-NLS-1$
		textNacion.setText(Messages.getString("A�adirPaciente.63")); //$NON-NLS-1$
		textDireccion.setText(Messages.getString("A�adirPaciente.64")); //$NON-NLS-1$
		textMunicipio.setText(Messages.getString("A�adirPaciente.65")); //$NON-NLS-1$
		textCP.setText(Messages.getString("A�adirPaciente.66")); //$NON-NLS-1$
		textNumero.setText(Messages.getString("A�adirPaciente.67")+(pacientes.size()+1)); //$NON-NLS-1$
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
	private class BtnA�adirActionListener implements ActionListener {
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
			if(nombre.equals(Messages.getString("A�adirPaciente.68"))){ //$NON-NLS-1$
				JOptionPane.showMessageDialog(new JFrame(), Messages.getString("A�adirPaciente.69"), //$NON-NLS-1$
						Messages.getString("A�adirPaciente.70"),JOptionPane.PLAIN_MESSAGE ); //$NON-NLS-1$
			}else{
				if(rdbtnF.isSelected()){
					sexo=Messages.getString("A�adirPaciente.71"); //$NON-NLS-1$
				}else{
					sexo=Messages.getString("A�adirPaciente.72"); //$NON-NLS-1$
				}
				Paciente paciente = new Paciente(npaciente,nombre,apellidos,nacion,direccion,municipio,cp ,DNI,fecha,sexo);
				if(JOptionPane.showConfirmDialog(new JFrame (), Messages.getString("A�adirPaciente.73"), Messages.getString("A�adirPaciente.74"),  //$NON-NLS-1$ //$NON-NLS-2$
						JOptionPane.OK_CANCEL_OPTION)==JOptionPane.YES_OPTION){
					pacientes.add(paciente);
					JOptionPane.showMessageDialog(new JFrame (), Messages.getString("A�adirPaciente.75")); //$NON-NLS-1$
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
