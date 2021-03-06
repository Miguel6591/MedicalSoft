package dominio;

public class Consulta {
	private Paciente paciente;
	private String horaCita, motivo,dia;
	
	public Consulta(Paciente paciente,String dia, String horaCita, String motivo) {
		this.paciente = paciente;
		this.horaCita = horaCita;
		this.motivo = motivo;
		this.dia=dia;
	}
	
	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getHoraCita() {
		return horaCita;
	}
	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
}
