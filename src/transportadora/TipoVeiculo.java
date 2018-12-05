package transportadora;

public enum TipoVeiculo {
	VAN("V") {
		public int getQtdMaximaTransporte() {
			return 1;
		}
		
		public boolean isCnhValida(String tipoCnh) {
			if(tipoCnh.equalsIgnoreCase("C") || tipoCnh.equalsIgnoreCase("B") ) {
				return true;
			}
			return false;
		}
	}, CARRETA("C"){
		public int getQtdMaximaTransporte() {
			return 10;
		}
		
		public boolean isCnhValida(String tipoCnh) {
			if(tipoCnh.equalsIgnoreCase("C") || tipoCnh.equalsIgnoreCase("B")) {
				return true;
			}
			return false;
		}
	}, BAU("B") {
		public int getQtdMaximaTransporte() {
			return 3;
		}
		
		public boolean isCnhValida(String tipoCnh) {
			if(tipoCnh.equalsIgnoreCase("C")) {
				return true;
			}
			
			return false;
			
			/*
			 *  Pode ser substituido por um if ternario, EM TODOS OS IF, ou seja:
			 * 
			 *  return tipoCnh.equalsIgnoreCase("C");
			 *  
			 *  OU
			 *  
			 *  return tipoCnh.equalsIgnoreCase("C") || tipoCnh.equalsIgnoreCase("B");
			 * 
			 * */
		}
	};
	
	private String tipoVeiculo;
	
	private TipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo =tipoVeiculo;
	}
	
	public abstract int getQtdMaximaTransporte();
	public abstract boolean isCnhValida(String tipoCnh);

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}
}
