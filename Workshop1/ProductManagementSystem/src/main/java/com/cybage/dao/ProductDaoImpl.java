package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.Product;

public class ProductDaoImpl implements ProductDao {
	
	private static Connection con;
	
	private static PreparedStatement pinsst,psel,pdelById,pgetById;
	static {
		
		try {
			con=JDBCUtility.getMyConnection();
			pinsst=con.prepareStatement("insert into product (name,price)values(?,?)");				
			psel=con.prepareStatement("select * from product");
			pdelById=con.prepareStatement("delete from product where id=?");
			pgetById=con.prepareStatement("select * from product where id=?");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	public int save(Product p) {
		try {			
			pinsst.setString(1, p.getName());
			pinsst.setDouble(2, p.getPrice());
			return pinsst.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return 0;
	}
	
	public List<Product> findAll() {
		List<Product> plist=new ArrayList<>();
		try {
			ResultSet rs=psel.executeQuery();
			while(rs.next()) {
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				plist.add(p);
			}
			return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteById(int id) {
		try {
			pdelById.setInt(1, id);
			int n=pdelById.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public Product findById(int id) {
		try {
			pgetById.setInt(1,id);
			ResultSet rs=pgetById.executeQuery();
			if(rs.next()) {
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				return p;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnection() {
		JDBCUtility.closeMyConnection();
		
	}

}
