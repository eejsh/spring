package aopmaster;

//database insert, delete, update, select 
public interface aop_service {

	public abstract void setdao(aop_dao dao);
	public abstract void register() throws Exception;
	public abstract void modify() throws Exception;
	public String insertdb(String data) throws Exception;
	
	public String deletedb(String idx) throws Exception;
	
	
}
