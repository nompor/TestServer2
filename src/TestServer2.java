

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServer2 extends HttpServlet {

	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		try {
			process(arg0,arg1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		try {
			process(arg0,arg1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("========リクエスト処理の開始========");

		System.out.println("========受信パラメータ========");
		Map<String, String[]> map = req.getParameterMap();
		for ( Map.Entry<String, String[]> e : map.entrySet() ) {
			System.out.println(e.getKey()+"="+Arrays.toString(e.getValue()));
		}
		System.out.println("========受信パラメータ========");

		String path = req.getRequestURI();
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		System.out.println("========レスポンスデータ作成========");
		if (path.endsWith("zugo")) {
			String html = "<html><body><div>ずごー！</div></body></html>";
			out.println(html);
			System.out.println(html);
		} else {
			String html = "<html><body><div style='background-color:red;'>不明なぺーじ</div></body></html>";
			out.println(html);
			System.out.println(html);
		}
		System.out.println("========レスポンスデータ作成========");
		System.out.println("========リクエスト処理の終了========");
	}
}
