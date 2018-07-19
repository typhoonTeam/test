package typhoon.merchant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import typhoon.merchant.dao.RegisterInfoDao;
import typhoon.merchant.pojo.RegisterInfo;
import typhoon.merchant.pojo.User;
import typhoon.merchant.util.DBUtil;

public class RegisterInfoDaoImpl implements RegisterInfoDao{
	String sql = null;

	public int addRegisterInfo(RegisterInfo RegisterInfo) {
		int num = 0;
		sql = "INSERT INTO registerinfo(shop_id,credit_code,id_card,picture,phone,shop_name,address,comments,corporate_name) VALUES (?,?,?,?,?,?,?,?,?)";
//		System.out.println(sql);
		ResultSet rs = null;
		PreparedStatement pStatement = null;
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, RegisterInfo.getShopId());
			pStatement.setString(2, RegisterInfo.getCreditCode());
			pStatement.setString(3, RegisterInfo.getIdCard());
			pStatement.setString(4, RegisterInfo.getPicture());
			pStatement.setString(5, RegisterInfo.getPhone());
			pStatement.setString(6, RegisterInfo.getShopName());
			pStatement.setString(7, RegisterInfo.getAddress());
			pStatement.setString(8, RegisterInfo.getComments());
			pStatement.setString(9, RegisterInfo.getCorporateName());
			num = pStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(con, pStatement, rs);
		}
		return num;
	}
	public RegisterInfo findRegisterInfoByShopId(String shopId) {

		RegisterInfo registerInfo = null;
		ResultSet rs = null;
		PreparedStatement pStatement = null;
		sql = "select * from registerinfo where shop_id=?";
		Connection con = DBUtil.getConnection();
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, shopId);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				registerInfo= new RegisterInfo(rs.getString("shop_id"), rs.getString("credit_code"), rs.getString("id_Card"), rs.getString("corporate_Name"), rs.getString("picture"), rs.getString("phone"), rs.getString("shop_Name"), rs.getString("address"), rs.getString("comments"));
			System.out.println(registerInfo.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con, pStatement, rs);
		}
		return registerInfo;
	}
	
}
