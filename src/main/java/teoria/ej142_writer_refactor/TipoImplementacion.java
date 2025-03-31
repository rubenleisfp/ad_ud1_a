package teoria.ej142_writer_refactor;

public enum TipoImplementacion {
	PRINT_WRITER("P"),BUFFERED_WRITER("B");

	private String clave;
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	TipoImplementacion(String clave) {
		this.clave = clave;
	}
	
	public static TipoImplementacion findByClave(String clave){
	    for(TipoImplementacion v : values()){
	        if( v.getClave().equals(clave)){
	            return v;
	        }
	    }
	    return null;
	}
}
