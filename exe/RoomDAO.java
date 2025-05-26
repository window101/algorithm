package exe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    private Connection conn;
    private PreparedStatement pstmt;

    public List<Room> getAllRooms() { // 방리스트 출력
        List<Room> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection(); 
            String sql = "SELECT * FROM Room WHERE status = 'ready'"; 
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("roomId"));
                room.setUserId(rs.getString("userId"));
                room.setRoomName(rs.getString("roomName"));
                room.setRoomExplain(rs.getString("roomExplain"));
                room.setStatus(rs.getString("status"));
                list.add(room);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int insertRoom(Room room) { // main.html에서 방만들기 시 실행
    int roomId = -1;

    String sql = "INSERT INTO Room (userId, roomName, roomExplain, status) VALUES (?, ?, ?, ?)";

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

      pstmt.setString(1, room.getUserId());
      pstmt.setString(2, room.getRoomName());
      pstmt.setString(3, room.getRoomExplain());
      pstmt.setString(4, room.getStatus());

      int result = pstmt.executeUpdate(); // insert함 -> 행의 수를 반환(보통 1)

      if (result > 0) {
        ResultSet rs = pstmt.getGeneratedKeys(); // db에서 생성된 roomId 값을 받아오기 위한 옵션
        if (rs.next()) { // ResultSet은 처음에 첫번째 행의 전 을 가리키기 때문에 rs.next() 해서 첫번째 행으로 이동해야함
          roomId = rs.getInt(1);  // AUTO_INCREMENT된 roomId 가져오기(첫번째 칼럼값)
        }
        rs.close();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return roomId;
  }

  public static Room getRoomById(int roomId) { // roomId로 방 정보 가져오기 (game.jsp 에서 사용함)
    Room room = null;
    String sql = "SELECT * FROM Room WHERE roomId = ?";

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

      pstmt.setInt(1, roomId);
      ResultSet rs = pstmt.executeQuery();

      if (rs.next()) {
        room = new Room();
        room.setRoomId(rs.getInt("roomId")); // 이건 ResultSet에서 값을 꺼내는 방식이다. 컬럼이 순서대로라면 rs.getInt(1)
        room.setUserId(rs.getString("userId")); // rs.getString(2)
        room.setRoomName(rs.getString("roomName")); // rs.getString(3) 해도 같음
        room.setRoomExplain(rs.getString("roomExplain"));
        room.setStatus(rs.getString("status"));
      }

      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return room;
  }




}
