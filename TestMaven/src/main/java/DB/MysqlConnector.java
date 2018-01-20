package DB;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MysqlConnector {
	
	public void connect(){
		String mysqlConfUrl = "mysql-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(mysqlConfUrl);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession= sqlSessionFactory.openSession();
//		Object object = sqlSession.selectOne("selectAllCity");
		List list = sqlSession.selectList("selectAllCity");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		
		sqlSession.close();
	}
	
	public static void main( String[] args ){
		MysqlConnector mysqlConnector = new MysqlConnector();
		mysqlConnector.connect();
	}
}
