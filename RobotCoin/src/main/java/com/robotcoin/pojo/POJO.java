package com.robotcoin.pojo;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.robotcoin.jdbc.Inflector;
import com.robotcoin.jdbc.OrderType;


/**
 * 基础实体
 * @author tngou@tngou.net
 *
 */
@Component
public class POJO implements Serializable{
	private final static Logger log = LoggerFactory.getLogger(POJO.class);
	protected final static transient char OBJ_COUNT_CACHE_KEY = '#';
	private static final long serialVersionUID = 1L;
	@Value("${spring.datasource.druid.dbname}")
	protected String DABASE;
	private String __this_table_name;//对应的数据库表名
	private long id;
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	@Autowired
	private JdbcTemplate jdbcTemplate;


	
	

	

	
	/**
	 * 插入对象到数据库表中
	 * @return
	 */
	public long save() {
		if(getId() > 0)
			_insertObject(this);
		else
			setId(_insertObject(this));
		return getId();
	}
	
	
	/**
	 * 根据id主键删除对象
	 * @return
	 */
	public boolean delete() {
		boolean dr = jdbcTemplate.update("DELETE FROM " + tableName() + " WHERE id=?", getId()) == 1;

		return dr;
	}
	public boolean delete(long id) {
		boolean dr = jdbcTemplate.update("DELETE FROM " + tableName() + " WHERE id=?", id) == 1;
		return dr;
	}

	public boolean delete(String filter) {
		boolean dr = jdbcTemplate.update("DELETE FROM " + tableName() + " WHERE "+filter) == 1;
		return dr;
	}
	
	/**
	 * 分页列出所有对象
	 * @param page
	 * @param size
	 * @return
	 */
	public List<? extends POJO> list() {
		String sql = "SELECT * FROM " + tableName() + " ORDER BY id DESC";	
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(getClass()));
	}
	
	public List<? extends POJO> list(String type, OrderType orderType) {
		String sql = "SELECT * FROM " + tableName() + " ORDER BY "+type+" "+orderType.toString();
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(getClass()));
	}
	
	public List<? extends POJO> list(String filter, String type, OrderType orderType) {
		String sql = "SELECT * FROM " + tableName() + " WHERE " + filter + " ORDER BY "+type+" "+orderType.toString();
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(getClass()));
	}
	
	
	
	public List<? extends POJO> list(int page, int size) {
		String sql = "SELECT * FROM " + tableName() + " ORDER BY id DESC";
        if(page < 0 || size < 0)
            throw new IllegalArgumentException("Illegal parameter of 'page' or 'count', Must be positive.");
        int from = (page - 1) * size;
        size = (size > 0) ? size : Integer.MAX_VALUE;
		return jdbcTemplate.query(sql + " LIMIT ?,?",new Object[]{from,size}, new BeanPropertyRowMapper(getClass()));

	}
	
	public List<? extends POJO> list(int page, int size,String order,OrderType orderType) {
		String sql = "SELECT * FROM " + tableName() + " ORDER BY id DESC";
        if(page < 0 || size < 0)
            throw new IllegalArgumentException("Illegal parameter of 'page' or 'count', Must be positive.");
        int from = (page - 1) * size;
        size = (size > 0) ? size : Integer.MAX_VALUE;
		return jdbcTemplate.query(sql + " LIMIT ?,?",new Object[]{from,size}, new BeanPropertyRowMapper(getClass()));
	}
	public List<? extends POJO> list(String filter, int page, int size) {
		String sql = "SELECT * FROM " + tableName() + " WHERE " + filter + " ORDER BY id DESC";
        if(page < 0 || size < 0)
            throw new IllegalArgumentException("Illegal parameter of 'page' or 'count', Must be positive.");
        int from = (page - 1) * size;
        size = (size > 0) ? size : Integer.MAX_VALUE;
		return jdbcTemplate.query(sql + " LIMIT ?,?",new Object[]{from,size},new BeanPropertyRowMapper( getClass()));
	}
	
	
	
	public List<? extends POJO> list(String filter, int page, int size,String type,OrderType orderType) {
		String sql = "SELECT * FROM " + tableName() + " WHERE " + filter + " ORDER BY "+type+" "+orderType.toString();
        if(page < 0 || size < 0)
            throw new IllegalArgumentException("Illegal parameter of 'page' or 'count', Must be positive.");
        int from = (page - 1) * size;
        size = (size > 0) ? size : Integer.MAX_VALUE;
		return jdbcTemplate.query(sql + " LIMIT ?,?",new Object[]{from,size}, new BeanPropertyRowMapper(getClass()));
	}
	public List<? extends POJO>  list(Map<String, Object> map) 
	{
		String sql="SELECT * FROM  "+ tableName() + " where ";
		 Set<String> sets = map.keySet();
		 int i = 0;
		  for (String string : sets) 
			  {
				  i++;
				 sql=sql+string+" = ?";
				 if (sets.size() > i) 
				 	{
					 sql=sql+" and ";
				 	}
				 else {
						sql=sql+ " ORDER BY id DESC";
					}
			  }
		return jdbcTemplate.query( sql, map.values().toArray(),new BeanPropertyRowMapper(getClass()));
		
	}
	
	
	public List<? extends POJO>  list(Map<String, Object> map,String order,OrderType orderType) 
	{
		String sql="SELECT * FROM  "+ tableName() + " where ";
		Set<String> sets = map.keySet();
		int i = 0;
		for (String string : sets) 
		  {
			  i++;
			 sql=sql+string+" = ?";
			 if (sets.size() > i) 
			 	{
				 sql=sql+" and ";
			 	}
			 else {
					sql=sql+ " ORDER BY "+order+" "+orderType.toString();
				}
		  }
	  return jdbcTemplate.query( sql, map.values().toArray(),new BeanPropertyRowMapper(getClass()));
		
	}
	
	
	
	public long update() 
	{
		if(getId()>0)
		{
			_updateObject(this);
		}
		return getId();
		
	}
	public int update(Map<String, Object> map,Long id) 
	{
		String sql="UPDATE "+ tableName() + " SET ";
		 Set<String> sets = map.keySet();
		 int i = 0;
		  for (String string : sets) 
		  {
			  i++;
			 sql=sql+string+" =?";
			 if (sets.size() > i) 
			 	{
				 sql=sql+" , ";
			 	}
		  }
		  sql=sql+"  WHERE id = ?";
		
		  Object[] params = ArrayUtils.add(map.values().toArray(), id);
		  
		return jdbcTemplate.update(sql, params);
		
	}
	
	/**
	 * 统计此对象的总记录数
	 * @return
	 */
	public int totalCount() {
		
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM " + tableName(), Integer.class);
	}
	public int totalCount(String filter) {
		return  jdbcTemplate.queryForObject("SELECT COUNT(*) FROM " + tableName() + " WHERE " + filter, Integer.class);
	}
	
	
	
	/**
	 * 根据主键读取对象详细资料，根据预设方法自动判别是否需要缓存
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends POJO> T get(long id) {
		if(id <= 0) return null;
		String sql = "SELECT * FROM " + tableName() + " WHERE id = ?  LIMIT 1";	
		return 	(T) jdbcTemplate.queryForObject(sql,new Object[]{id} ,new BeanPropertyRowMapper(getClass()));
	}
	
	public <T extends POJO> T get(String filter) {
		if(StringUtils.isBlank(filter)) return null;
		String sql = "SELECT * FROM " + tableName() + " WHERE "+filter +"  LIMIT 1";
		return 	(T) jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper(getClass()));
	}
	
	@SuppressWarnings("unchecked")
	public <T extends POJO> T get(Map<String, Object> map) 
	{
		String sql="SELECT * FROM "+ tableName() + " where ";
	 Set<String> sets = map.keySet();
	 int i = 0;
	  for (String string : sets) 
	  {
		  i++;
		 sql=sql+string+" =?";
		 if (sets.size() > i) 
		 	{
			 sql=sql+" and ";
		 	}
	  }
	  
		return (T)jdbcTemplate.queryForObject( sql +"   LIMIT 1",  map.values().toArray(),new BeanPropertyRowMapper(getClass()));
		
	}
	
	public List<? extends POJO> batchGet(List<Long> ids) {
		if(ids==null || ids.size()==0)
			return null;
		StringBuilder sql = new StringBuilder("SELECT * FROM " + tableName() + " WHERE id IN (");
		for(int i=1;i<=ids.size();i++) {
			sql.append('?');
			if(i < ids.size())
				sql.append(',');
		}
		sql.append(')');
		List<? extends POJO> beans = jdbcTemplate.queryForList( sql.toString(), ids.toArray(new Object[ids.size()]),getClass());
		return beans;
	}
	
	

	
	/**
	 * 返回默认的对象对应的表名
	 * @return
	 */
	protected String tableName() {
		if(__this_table_name == null)
			__this_table_name = DABASE+"_" + Inflector.getInstance().tableize(getClass());
		return __this_table_name;
	}
	
	   /**
     * 返回对象对应的缓存区域名
     * @return
     */
 public String cacheRegion() 
 { 
	 return this.getClass().getSimpleName();
}

 
 
 // protected boolean isAutoLoadUser() { return false; }
//	protected long getAutoLoadUser() { return 0L; }
 
 /**
	 * 插入对象
	 * @param obj
	 * @return 返回插入对象的主键
	 */
	
	private  long _insertObject(POJO obj) {		
		Map<String, String> pojo_bean = obj.listInsertableFields();		
		String[] fields = pojo_bean.keySet().toArray(new String[pojo_bean.size()]);
//		Object[] values = new String[fields.length];
//		for (int i = 0; i < fields.length; i++) {
//			values[i]=pojo_bean.get(fields[i]);
//		}
		StringBuilder sql = new StringBuilder("INSERT INTO ") ;
		sql.append("`"+obj.tableName()+"`");
		sql.append('(');
		for(int i=0;i<fields.length;i++){
			if(i > 0) sql.append(',');
			sql.append("`"+fields[i]+"`");
		}
		sql.append(") VALUES(");
		for(int i=0;i<fields.length;i++){
			if(i > 0) sql.append(',');
			sql.append('?');
		}
		sql.append(')');
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn=jdbcTemplate.getDataSource().getConnection();
			ps = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);		
			for(int i=0;i<fields.length;i++){
				ps.setObject(i+1, pojo_bean.get(fields[i]));
			}
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			return rs.next()?rs.getLong(1):-1;
		}catch(SQLException e){
			e.printStackTrace();
			log.error("保存数据失败！");
			return -1;
		}finally{
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (ps != null && !ps.isClosed()) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			sql = null;
			fields = null;
			pojo_bean = null;
		}
	}
 
	/**
	 * 更新
	 * @param obj
	 * @return
	 */
	private  long _updateObject(POJO obj) {		
		Map<String, String> pojo_bean = obj.listInsertableFields();		
		String[] fields = pojo_bean.keySet().toArray(new String[pojo_bean.size()]);
		StringBuilder sql = new StringBuilder("UPDATE ") ;
		sql.append("`"+obj.tableName()+"`");
		sql.append(" SET ");
		
		for(int i=0;i<fields.length;i++){
			if(i > 0) sql.append(',');
			sql.append("`"+fields[i]+"`");
			sql.append("=?");
		}
		
		sql.append(" WHERE id = ? ");
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn =null;
		try{
			conn=jdbcTemplate.getDataSource().getConnection();
			ps = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);		
			for(int i=0;i<fields.length;i++){
				ps.setObject(i+1, pojo_bean.get(fields[i]));
			}
			ps.setObject(fields.length+1, obj.getId());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			return rs.next()?rs.getLong(1):-1;
		}catch(SQLException e){
			e.printStackTrace();
			log.error("更新数据失败！");
			return -1;
		}finally{
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (ps != null && !ps.isClosed()) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			sql = null;
			fields = null;
			pojo_bean = null;
		}
	}

 /**
	 * 列出要插入到数据库的域集合，子类可以覆盖此方法
	 * @return
	 */
	protected Map<String,String> listInsertableFields() {
		try {
			Map<String, String> props = BeanUtils.describe(this);
			
			//if(getId() <= 0)
				props.remove("id");
			props.remove("class");
			Object[] keys = props.keySet().toArray();	
		    for (Object key : keys) {
		    	if(props.get(key)==null)
		    		props.remove(key);
			}
			return props ;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Exception when Fetching fields of " + this);
		}
	}
 
 @Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		//不同的子类尽管ID是相同也是不相等的
		if(!getClass().equals(obj.getClass()))
			return false;
		POJO wb = (POJO) obj;
		return wb.getId() == getId();
	}
 
 
 

  
 
 	@Override
	public String toString() {
 		Map<String, String> pojo_bean = this.listInsertableFields();	
 		
 		String s ="";
		
		Set<Entry<String, String>> sets = pojo_bean.entrySet();
		for (Entry<String, String> entry : sets) {
			s=s+entry.getKey()+":"+entry.getValue()+"\n";
		}	
		s=s+"**************************************";
		return s;
		
	}
 


}
