package pl.coderslab.dao;

import pl.coderslab.model.UserGroup;
import pl.coderslab.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class UserGroupDao {

    private static final String CREATE_QUERY = "INSERT INTO user_group (name) VALUES (?)";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM user_group WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE user_group SET name = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM user_group WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM user_group";

    public UserGroup create(UserGroup userGroup) {
        try (Connection conn = DBUtil.createConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY);
            statement.setString(1, userGroup.getName());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                userGroup.setId(rs.getInt(1));
            }
            return userGroup;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public UserGroup read(int id) {
        try (Connection conn = DBUtil.createConnection()) {
             PreparedStatement statement = conn.prepareStatement(READ_BY_ID_QUERY);
             statement.setInt(1, id);
             ResultSet rs = statement.executeQuery();
             if (rs.next()) {
                 UserGroup userGroup = new UserGroup();
                 userGroup.setId(rs.getInt("id"));
                 userGroup.setName(rs.getString("name"));
                 return userGroup;
             }
             return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void update(UserGroup userGroup) {
        try (Connection conn = DBUtil.createConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_QUERY);
            statement.setString(1, userGroup.getName());
            statement.setInt(2, userGroup.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = DBUtil.createConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public UserGroup[] findAll() {
        try (Connection conn = DBUtil.createConnection()) {
            UserGroup[] userGroups = new UserGroup[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                UserGroup userGroup = new UserGroup();
                userGroup.setId(rs.getInt("id"));
                userGroup.setName(rs.getString("name"));
                addToArray(userGroup, userGroups);
            }
            return userGroups;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private UserGroup[] addToArray(UserGroup userGroup, UserGroup[] userGroups) {
        UserGroup[] tmp = Arrays.copyOf(userGroups, userGroups.length+1);
        tmp[userGroups.length] = userGroup;
        return tmp;
    }
}
