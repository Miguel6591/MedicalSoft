package presentacion;
import dominio.Consulta;
import dominio.Doctor;
import dominio.Paciente;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import javax.swing.event.ListSelectionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;
import java.awt.Cursor;

public class AnadirConsulta extends JFrame {

	private JPanel contentPane; 
	private JList<Paciente> list;
	private ArrayList<Paciente> pacientes;
	private ArrayList<Consulta> consultas;
	private JFormattedTextField texthora;
	private JDateChooser textdia;
	private JTextArea textMotivo;


	public AnadirConsulta(Doctor doctor) {
		pacientes=doctor.getPacientes();
		consultas=doctor.getConsultas();
		setResizable(false);
		setTitle(Messages.getString("AnadirConsulta.0")); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(150, 2));
		contentPane.add(scrollPane, BorderLayout.WEST);
		
		list = new JList<Paciente>();
		list.setBorder(new TitledBorder(null, Messages.getString("AnadirConsulta.1"), TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK)); //$NON-NLS-1$
		scrollPane.setViewportView(list);
		actualizarDatos();
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDa = new JLabel(Messages.getString("AnadirConsulta.2")); //$NON-NLS-1$
		lblDa.setFont(new Font(Messages.getString("AnadirConsulta.3"), Font.BOLD, 11)); //$NON-NLS-1$
		lblDa.setBounds(32, 38, 46, 14);
		panel.add(lblDa);
		
		JLabel lblHora = new JLabel(Messages.getString("AnadirConsulta.4")); //$NON-NLS-1$
		lblHora.setFont(new Font(Messages.getString("AnadirConsulta.5"), Font.BOLD, 11)); //$NON-NLS-1$
		lblHora.setBounds(32, 80, 46, 14);
		panel.add(lblHora);
		
		textMotivo = new JTextArea();
		textMotivo.setFont(new Font(Messages.getString("AnadirConsulta.6"), Font.BOLD, 13)); //$NON-NLS-1$
		textMotivo.setBorder(new TitledBorder(UIManager.getBorder(Messages.getString("AnadirConsulta.7")), Messages.getString("AnadirConsulta.8"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))); //$NON-NLS-1$ //$NON-NLS-2$
		textMotivo.setBackground(SystemColor.scrollbar);
		textMotivo.setBounds(10, 119, 264, 98);
		panel.add(textMotivo);
		
		textdia = new JDateChooser();
		textdia.getCalendarButton().setBackground(SystemColor.scrollbar);
		textdia.setBackground(SystemColor.scrollbar);
		textdia.setBounds(88, 38, 95, 20);
		panel.add(textdia);
		
		//formattedTextField = new JFormattedTextField();
		MaskFormatter formatohora;
		try {
			formatohora = new MaskFormatter(Messages.getString("AnadirConsulta.9")); //$NON-NLS-1$
			formatohora.setPlaceholderCharacter('-');
			texthora = new JFormattedTextField(formatohora);
			texthora.setFont(new Font(Messages.getString("AnadirConsulta.10"), Font.BOLD, 11)); //$NON-NLS-1$
			texthora.setBackground(SystemColor.scrollbar);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		texthora.setBorder(new TitledBorder(null, Messages.getString("AnadirConsulta.11"), TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.infoText)); //$NON-NLS-1$
		texthora.setBackground(SystemColor.scrollbar);
		texthora.setBounds(88, 78, 95, 20);
		panel.add(texthora);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnCancelar = new JButton(Messages.getString("AnadirConsulta.12")); //$NON-NLS-1$
		btnCancelar.setFont(new Font(Messages.getString("AnadirConsulta.13"), Font.BOLD, 11)); //$NON-NLS-1$
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.addActionListener(new BtnCancelarActionListener());
		panel_1.add(btnCancelar);
		
		JButton btnCrearConsuta = new JButton(Messages.getString("AnadirConsulta.14")); //$NON-NLS-1$
		btnCrearConsuta.setFont(new Font(Messages.getString("AnadirConsulta.15"), Font.BOLD, 11)); //$NON-NLS-1$
		btnCrearConsuta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCrearConsuta.addActionListener(new BtnCrearConsutaActionListener());
		panel_1.add(btnCrearConsuta);
	}
	private class BtnCancelarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	
	public void actualizarDatos(){
		DefaultListModel modelo = new DefaultListModel();
		for(int i=0;i<pacientes.size();i++){
			modelo.addElement(pacientes.get(i).getApellidos()+Messages.getString("AnadirConsulta.16")+pacientes.get(i).getNombre()); //$NON-NLS-1$
		}
		list.setModel(modelo);
	}

	public void limpiar(){
		textdia.setDateFormatString(Messages.getString("AnadirConsulta.17")); //$NON-NLS-1$
		texthora.setText(Messages.getString("AnadirConsulta.18")); //$NON-NLS-1$
		textMotivo.setText(Messages.getString("AnadirConsulta.19")); //$NON-NLS-1$
		list.setSelectedIndex(-1);
	}
	private class BtnCrearConsutaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int i=list.getSelectedIndex();
			if(i==-1||texthora.getText().equals(Messages.getString("AnadirConsulta.20"))||textdia.getDate()==null){ //$NON-NLS-1$
				JOptionPane.showMessageDialog(new JFrame(), Messages.getString("AnadirConsulta.21"), //$NON-NLS-1$
						Messages.getString("AnadirConsulta.22"),JOptionPane.PLAIN_MESSAGE ); //$NON-NLS-1$
			}else{
				if(JOptionPane.showConfirmDialog(new JFrame (), Messages.getString("AnadirConsulta.23"), Messages.getString("AnadirConsulta.24"),  //$NON-NLS-1$ //$NON-NLS-2$
						JOptionPane.OK_CANCEL_OPTION)==JOptionPane.YES_OPTION){
					String date=textdia.getDate().toString();
					String[]arrayDate= date.split(Messages.getString("AnadirConsulta.25")); //$NON-NLS-1$
					String dia=arrayDate[2]+Messages.getString("AnadirConsulta.26")+arrayDate[1]+Messages.getString("AnadirConsulta.27")+arrayDate[5]; //$NON-NLS-1$ //$NON-NLS-2$
					String hora=texthora.getText();
					Paciente paciente=pacientes.get(i);
					String motivo=textMotivo.getText();
					Consulta consulta=new Consulta(paciente,dia,hora,motivo);
					consultas.add(consulta);
					JOptionPane.showMessageDialog(new JFrame(), Messages.getString("AnadirConsulta.28"), //$NON-NLS-1$
							Messages.getString("AnadirConsulta.29"),JOptionPane.PLAIN_MESSAGE ); //$NON-NLS-1$
					
				}
			}
		}
	}
}
