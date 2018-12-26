package dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.Doctor;
import presentacion.FrameLogin;
public class Aplicación {
	private static ArrayList<Doctor> usuarios= new ArrayList<Doctor>();
	private static ArrayList<Paciente> pacientes=new ArrayList<Paciente>();
	private static ArrayList<Especialista> especialistas=new ArrayList<Especialista>();
	private static ArrayList<Consulta> consultas=new ArrayList<Consulta>();
	
	
	public static void main(String[] args) {
		
		LeerDatos leer= new LeerDatos(pacientes,usuarios,especialistas,consultas);
		FrameLogin login=new FrameLogin(usuarios);
		login.setVisible(true);
		
	}
	
	

}
