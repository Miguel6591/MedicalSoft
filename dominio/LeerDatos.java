package dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;



public class LeerDatos {

	private ArrayList<Paciente> pacientes ;
	private ArrayList<Doctor> doctores  ;
	private ArrayList<Especialista> especialistas;
	private ArrayList<Consulta> consultas;
	private Scanner teclado;
	private File f1;
	
	public LeerDatos(ArrayList<Paciente> pacientes,ArrayList<Doctor> doctores,ArrayList<Especialista> especialistas,ArrayList<Consulta> consultas){
		this.doctores=doctores;
		this.especialistas=especialistas;
		this.pacientes=pacientes;
		this.consultas=consultas;
		leerPacientes();
		leerEspecialistas();
		leerConsultas();
		leerDoctores();

		
		
	}
	
	
	
	void leerPacientes(){
		try{
			f1=new File(Messages.getString("LeerDatos.0")); //$NON-NLS-1$
			teclado= new Scanner(f1).useDelimiter(Messages.getString("LeerDatos.1")); //$NON-NLS-1$
		}catch(FileNotFoundException e){
			 e.printStackTrace();
		}
		
		while(teclado.hasNext()){
			String id =teclado.next();
			String nombre=teclado.next();
			String apellidos=teclado.next();
			String nacionalidad=teclado.next();
			String direccion=teclado.next();
			String municipio=teclado.next();
			String cp=teclado.next();
			String alergias=teclado.next();
			String medicacion=teclado.next();
			String dni=teclado.next();
			String fecha=teclado.next();
			String historia=teclado.next();
			String sexo=teclado.next();
			String historial=teclado.next();
			String pruebas=teclado.next();
			Paciente paciente = new Paciente(id,nombre,apellidos,nacionalidad,direccion,municipio,cp,alergias,medicacion,dni,fecha,historia,sexo,historial,pruebas);
			pacientes.add(paciente);
					
		}
		teclado.close();
		
	}

	void leerDoctores(){
		try{
			f1=new File(Messages.getString("LeerDatos.2")); //$NON-NLS-1$
			teclado= new Scanner(f1);
		}catch(FileNotFoundException e){
			 e.printStackTrace();
		}
		
		while(teclado.hasNext()){
			String usuario=teclado.next();
			String contraseña=teclado.next();	
			String nombre=teclado.next();
			String apellidos=teclado.next();
			String dni=teclado.next();
			int colegiado=teclado.nextInt();
			int tlf=teclado.nextInt();
			int movil=teclado.nextInt();
			String direccion=teclado.next();
			int ext=teclado.nextInt();
			String localidad=teclado.next();
			String email=teclado.next();
			int cp=teclado.nextInt();
			String eCivil=teclado.next();
			String provincia=teclado.next();
			Doctor doctor= new Doctor(usuario,contraseña,nombre,apellidos,dni,colegiado,tlf,movil,direccion,ext, localidad, email ,cp, eCivil ,provincia,pacientes,consultas,especialistas);
			doctores.add(doctor);
		}
		teclado.close();
	}
	
	void leerEspecialistas(){
		try{
			f1=new File(Messages.getString("LeerDatos.3")); //$NON-NLS-1$
			teclado= new Scanner(f1).useDelimiter(Messages.getString("LeerDatos.4")); //$NON-NLS-1$
		}catch(FileNotFoundException e){
			 e.printStackTrace();
		}
		
		while(teclado.hasNext()){
			String id=teclado.next();
			String nombre=teclado.next();
			String apellidos=teclado.next();
			String dni=teclado.next();
			String tlf=teclado.next();
			String movil=teclado.next();
			String email=teclado.next();
			String direccion=teclado.next();
			String localidad=teclado.next();
			String provincia=teclado.next();
			String especialidad=teclado.next();
			String titulacion=teclado.next();
			String entra=teclado.next();
			String sale=teclado.next();
			String clinica=teclado.next();
			String dirClinica=teclado.next();
			String tlfClinica=teclado.next();
			String colegiado=teclado.next();
			String expe=teclado.next();
			Especialista especialista=new Especialista(id, nombre, apellidos, dni, tlf, movil, email,direccion, localidad, provincia, especialidad,  titulacion, entra, sale, clinica, dirClinica, tlfClinica, colegiado, expe);
			especialistas.add(especialista);
		}
		teclado.close();
	}
	
	void leerConsultas(){
		try{
			f1=new File(Messages.getString("LeerDatos.5")); //$NON-NLS-1$
			teclado= new Scanner(f1).useDelimiter(Messages.getString("LeerDatos.6")); //$NON-NLS-1$
		}catch(FileNotFoundException e){
			 e.printStackTrace();
		}
		
		while(teclado.hasNext()){
			String dia=teclado.next();
			String hora=teclado.next();
			int id=teclado.nextInt();
			String motivo=teclado.next();
			Consulta consulta=new Consulta(pacientes.get(id-1),dia,hora,motivo);
			consultas.add(consulta);
		}
		teclado.close();
	}
	
	
	
	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}


	public ArrayList<Doctor> getDoctores() {
		return doctores;
	}


	public ArrayList<Especialista> getEspecialistas() {
		return especialistas;
	}


	public ArrayList<Consulta> getConsultas() {
		return consultas;
	}





}
