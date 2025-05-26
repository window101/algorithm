package exe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public static User versusUser(String userId) {
        User user = null;
        String sql = "SELECT * FROM User WHERE userId = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserid(rs.getString("userId"));
                user.setNickname(rs.getString("nickname"));
                user.setPoints(rs.getInt("points"));
                user.setProfileimage(rs.getString("profileimage"));
                user.setProfilecolor(rs.getString("profilecolor"));
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
