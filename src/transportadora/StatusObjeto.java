package transportadora;

public enum StatusObjeto {
	PENDENTE("P"),ENTREGUE("E"),NOVO("N");
	
	private String status;
	public String getStatus() {
		return status;
	}
	private StatusObjeto(String status) {
		this.status = status;
	}
	
}
