package exe;

// main.html에서 방이름, 방소개 입력 후 만들기 버튼 클릭했을때
// Room 테이블에 Insert하고 세션에 user 저장 (방을 만든 유저)

// html에서 <form action="createRoom" method="post">
// <input type ="text" name="roomName" placeholder="방 이름입력">
// <input type = "text" name="roomExplain" placeholder="방 소개입력">
// ... <button type="submit" >만들기</button>

@WebServlet("/createRoom")
public class RoomCreateServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String roomName = request.getParameter("roomName"); 
    String roomExplain = request.getParameter("roomExplain");
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
      response.sendRedirect("login.jsp");
      return;
    }


    Room room = new Room();
    room.setRoomName(roomName);
    room.setRoomExplain(roomExplain);
    room.setUserId(user.getUserid());
    room.setStatus("ready");

    int roomId = RoomDAO.insertRoom(room); // DB에 저장 후 roomId 반환 (즉, 방을 생성한 후 roomid를 game.jsp에 같이 보냄)

    if (roomId != -1) {
      response.sendRedirect("game.jsp?roomId=" + roomId);
    } else {
      response.getWriter().write("<script>alert('방 생성 실패'); history.back();</script>");
    }
  }
}

// main.html의 방목록 출력
@WebServlet("/roomList")
public class RoomListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        RoomDAO dao = new RoomDAO();
        List<Room> roomList = dao.getAllRooms();

        request.setAttribute("roomList", roomList);
        request.getRequestDispatcher("roomList.jsp").forward(request, response);
    }
}