package practicas.practica2;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class SolicitudVacaciones {
 
    private final Date inicio;
 
    private final Date fin;
 
    @SerializedName("d")
    private final int totalDias;
 
    public SolicitudVacaciones(Date inicio, Date fin, int totalDias) {
        this.inicio = inicio;
        this.fin = fin;
        this.totalDias = totalDias;
    }

	public Date getInicio() {
		return inicio;
	}

	public Date getFin() {
		return fin;
	}

	public int getTotalDias() {
		return totalDias;
	}

	@Override
	public String toString() {
		return "SolicitudVacaciones [inicio=" + inicio + ", fin=" + fin + ", totalDias=" + totalDias + "]";
	}
	
	
}