package com.employeedata.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.employeedata.pojo.EmpPojo;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmpDao {
	private JdbcTemplate template;
	public void setTemplate(JdbcTemplate template)
	{
		this.template = template;
	}
	public int insert(EmpPojo emp)
	{
		String qry = EmpDatabaseQuery.savedata;
		return template.update(qry,emp.getName(),emp.getEmail(),emp.getCompany(),emp.getSalary(),emp.getDesignation(),emp.getId());
	}
	public int update(EmpPojo emp)
	{
		String qry = "update registrationform set name='"+emp.getName()+"', email='"+emp.getEmail()+"',company='"+emp.getCompany()+"',salary='"+emp.getSalary()+"',designation='"+emp.getDesignation()+"' where id='"+emp.getId()+"'";    
		return template.update(qry);
	}
	public int delete(int id)
	{
		String qry = "delete from registrationform where id = "+id+"";
		return template.update(qry);
	}
	public List<EmpPojo> getEmployees(){    
		return template.query(EmpDatabaseQuery.alldata,new RowMapper<EmpPojo>(){    
			public EmpPojo mapRow(ResultSet rs, int row) throws SQLException {    
				EmpPojo e=new EmpPojo(); 
				e.setName(rs.getString(1));
				e.setEmail(rs.getString(2));
				e.setCompany(rs.getString(3));
				e.setSalary(rs.getString(4));
				e.setDesignation(rs.getString(5));
				e.setId(rs.getInt(6));
				return e;    
			}    
		}); 
	}
	public EmpPojo empDetailById(int id)
	{
		String qry = EmpDatabaseQuery.editdata;
		return template.queryForObject(qry, new Object[]{id},new BeanPropertyRowMapper <EmpPojo>(EmpPojo.class));
	}

	public List<EmpPojo> empSearch(String freetext)
	{
		String qry = "select * from registrationform where name like '%"+freetext+"%' or email like '%"+freetext+"%' or company like '%"+freetext+"%' or salary like '%"+freetext+"%' or designation like '%"+freetext+"%' or id like '%"+freetext+"%'";
		return template.query(qry,new RowMapper<EmpPojo>(){    
			public EmpPojo mapRow(ResultSet rs, int row) throws SQLException {    
				EmpPojo e=new EmpPojo(); 
				e.setName(rs.getString(1));
				e.setEmail(rs.getString(2));
				e.setCompany(rs.getString(3));
				e.setSalary(rs.getString(4));
				e.setDesignation(rs.getString(5));
				e.setId(rs.getInt(6));
				return e;       
			}
		}); 
	}
}
