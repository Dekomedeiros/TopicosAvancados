package transportadora.dao.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import transportadora.Motorista;

public class MotoristaDao {
	
	public LinkedList<Motorista> lerBancoMotoristas(){
		LinkedList<Motorista> motoristas = new LinkedList<>();
		PreparedStatement ps = null;
		
		try {
			String sql = "SELECT * FROM MOTORISTA";
			
			ps = SingletonConnection.getConnection().prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			
			Motorista motorista = null;
			while(rs.next()) {
				motorista = new Motorista();
				motorista.setCnh(rs.getString("cnh"));
				motorista.setDataNascimento(rs.getDate("dataNascimento"));
				motorista.setDisponivel(rs.getBoolean("disponivel"));
				motorista.setEndereco(rs.getString("enderecoMotorista"));
				motorista.setIdMotorista(rs.getInt("idMotorista"));
				motorista.setNome(rs.getString("nomeMotorista"));
				motorista.setTipoCNH(rs.getString("tipoCNH"));
				
				motoristas.add(motorista);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return motoristas;
	}
	
	
	public void inserirMotoristaBanco(Motorista motorista){
		LinkedList<Motorista> motoristas = new LinkedList<>();
		PreparedStatement ps = null;
		
		try {
			String sql = " INSERT INTO MOTORISTA (nomeMotorista, dataNascimento, cnh, tipoCnh, enderecoMotorista,disponivel) "
					+ "VALUES (?, ?, ?, ?, ?,?)";
			
			ps = SingletonConnection.getConnection().prepareStatement(sql);
			
			ps.setString(1, motorista.getNome());
			ps.setDate(2, new java.sql.Date(motorista.getDataNascimento().getTime()));
			ps.setString(3, motorista.getCnh());
			ps.setString(4, motorista.getTipoCNH());
			ps.setString(5, motorista.getEndereco());
			ps.setBoolean(6, motorista.isDisponivel());
			
			ps.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
