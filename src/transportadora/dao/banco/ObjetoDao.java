package transportadora.dao.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;

import transportadora.Objeto;
import transportadora.StatusObjeto;

public class ObjetoDao {
	
	public LinkedList<Objeto> lerBancoObjetos(){
		LinkedList<Objeto> objetos = new LinkedList<>();
		PreparedStatement ps = null;
		
		try {
			String sql = "SELECT * FROM OBJETO";
			
			ps = SingletonConnection.getConnection().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			
			Objeto objeto = null;
			while(rs.next()) {
				objeto = new Objeto();
				objeto.setIdObjeto(rs.getInt("idObjeto"));
				objeto.setDataCadastro(rs.getDate("dataCadastro"));
				objeto.setDataDeposito(rs.getDate("dataDeposito"));
				objeto.setEnderecoDestinatario(rs.getString("enderecoDestinatario"));
				objeto.setNomeDestinatario(rs.getString("nomeDestinatario"));
				objeto.setEnderecoRemetente(rs.getString("enderecoRemetente"));
				objeto.setNomeRemetente(rs.getString("nomeRemetente"));
				objeto.setDataEntrega(rs.getDate("dataEntrega"));
				
				objeto.setIdLocalizador(rs.getString("idLocalizador"));
				objeto.setPeso(rs.getDouble("peso"));
				
				String status = rs.getString("status");
				
				if(status.equals(StatusObjeto.ENTREGUE.getStatus())) {
					objeto.setStatus(StatusObjeto.ENTREGUE);
				}if(status.equals(StatusObjeto.NOVO.getStatus())) {
					objeto.setStatus(StatusObjeto.NOVO);
				}if(status.equals(StatusObjeto.PENDENTE.getStatus())) {
					objeto.setStatus(StatusObjeto.PENDENTE);
				}
				
				objetos.add(objeto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return objetos;
	}
	
	
	public void inserirObjetoBanco(Objeto objeto){
		LinkedList<Objeto> objetos = new LinkedList<>();
		PreparedStatement ps = null;
		
		try {
			String sql = "INSERT INTO objeto (dataCadastro, status, peso, idLocalizador, nomeRemetente, enderecoRemetente, dataDeposito, nomeDestinatario, enderecoDestinatario) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			ps = SingletonConnection.getConnection().prepareStatement(sql);
			
			ps.setDate(1, new java.sql.Date(objeto.getDataCadastro().getTime()));
			ps.setString(2, objeto.getStatus().getStatus());
			ps.setDouble(3, objeto.getPeso());
			ps.setString(4, objeto.getIdLocalizador());
			ps.setString(5, objeto.getNomeRemetente());
			ps.setString(6, objeto.getEnderecoRemetente());
			if(objeto.getDataDeposito() == null) {
				objeto.setDataDeposito(new Date());
			}
			ps.setDate(7, new java.sql.Date(objeto.getDataDeposito().getTime()));
			ps.setString(8, objeto.getNomeDestinatario());
			ps.setString(9, objeto.getEnderecoDestinatario());
			
			System.out.println(ps.toString());
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
