package membership;

import java.sql.DriverManager;
import java.sql.Connection;

public class DBConn {
	private static Connection dbConn;	

	//Connection : 인터페이스

	//dbConn을 담을 수 있는 Connection 생성

		

		public static Connection getConnection(){	//get : 이미 올라가 있으니 가져다 쓰기만 할 때는 보통 get을 사용

			

			if(dbConn==null){

				

				try {

					String url = "jdbc:oracle:thin:@localhost:1521:xe";		



	    // XE : 오라클 expression 버전

					// jdbc로 oracle에 thin(type4)형식으로 LOCALHOST에 접속을 하겠다.  

	    // ▶ 노트북으로 연결시 LOCALHOST

					// 그 중 오라클이 사용하는 포트는 1521번. 연결하는 DB는 XE

					

					String user = "madang";

					String password = "madang";

					

					Class.forName("oracle.jdbc.driver.OracleDriver");

					//Driver를 로딩

					//더 빠른 접속이 가능하다
					
					dbConn = DriverManager.getConnection(url, user, password);	

					//연결된거를 dbConn에 넣어놓음

					

				} catch (Exception e) {

					System.out.println(e.toString());

				}

			}

			return dbConn;

		}

		

		//DB는 연결을 하면 항상 끊어주는 작업을 해야한다

		public static void close(){

			

			if(dbConn!=null){

				try {

					if(!dbConn.isClosed()){

						dbConn.close();

					}

				} catch (Exception e) {

					System.out.println(e.toString());

				}

			}
			//연결을 끊어주면 그 안에 쓰레기 값이 남아 두번째 연결을 할때는 Adapter에러가 발생, 접속이 안된다

			//★항상 연결을 끊으면 dbConn을 null로 초기화 해야함

			dbConn=null;
		}

	}


