package servlet; 
 
import java.util.ArrayList; 
import java.util.HashMap; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import entity.ChatMessage; 
import entity.ChatUser; 
 
public class ChatServlet extends HttpServlet { 
   
  private static final long serialVersionUID = 1L; 
   
  // ����� ������� ������������� 
  protected HashMap<String, ChatUser> activeUsers; 
  // ������ ��������� ���� 
  protected ArrayList<ChatMessage> messages; 
 
  @SuppressWarnings("unchecked") 
  public void init() throws ServletException { 
    // ������� �������������� �� HttpServlet ������ init() 
    super.init(); 
    // ������� �� ��������� ����� ������������� � ������ ��������� 
    activeUsers = (HashMap<String, ChatUser>) getServletContext().getAttribute("activeUsers"); 
    messages = (ArrayList<ChatMessage>) getServletContext().getAttribute("messages"); 
    // ���� ����� ������������� �� ���������� ... 

    if (activeUsers==null) { 
      // ������� ����� ����� 
      activeUsers = new HashMap<String, ChatUser>(); 
      // ��������� �� � �������� ��������,  
// ����� ������ �������� ����� �� ���� ��������� 
      getServletContext().setAttribute("activeUsers", activeUsers);       
    } 
    // ���� ������ ��������� �� ��������� ... 
    if (messages==null) { 
      // ������� ����� ������ 
      messages = new ArrayList<ChatMessage>(100); 
      // ��������� ��� � �������� ��������,  
// ����� ������ �������� ����� �� ���� ������� 
      getServletContext().setAttribute("messages", messages); 
    } 
  }         
} 
