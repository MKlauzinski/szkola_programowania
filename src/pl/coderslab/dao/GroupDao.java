package pl.coderslab.dao;

import pl.coderslab.model.Group;
import pl.coderslab.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class GroupDao {

    private static final String CREATE_QUERY = "INSERT INTO user_group (name) VALUES (?)";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM user_group WHERE id = ?";
    private static final String UPADET_QUERY = "UPDATE user_group SET name = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM user_group WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM user_group";

    public Group create(Group group) {
        try (Connection conn = DBUtil.createConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_QUERY);
            statement.setString(1, group.getName());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                group.setId(rs.getInt(1));
            }
            return group;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Group read(int id) {
        try (Connection conn = DBUtil.createConnection()) {
             PreparedStatement statement = conn.prepareStatement(READ_BY_ID_QUERY);
             statement.setInt(1, id);
             ResultSet rs = statement.executeQuery();
             if (rs.next()) {
                 Group group = new Group();
                 group.setId(rs.getInt("id"));
                 group.setName(rs.getString("name"));
                 return group;
             }
             return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void update(Group group) {
        try (Connection conn = DBUtil.createConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPADET_QUERY);
            statement.setString(1, group.getName());
            statement.setInt(2, group.getId());
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

    public Group[] findAll() {
        try (Connection conn = DBUtil.createConnection()) {
            Group[] groups = new Group[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setId(rs.getInt("id"));
                group.setName(rs.getString("name"));
                addToArray(group, groups);
            }
            return groups;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private Group[] addToArray(Group group, Group[] groups) {
        Group[] tmp = Arrays.copyOf(groups, groups.length+1);
        tmp[groups.length] = group;
        return tmp;
    }
}
