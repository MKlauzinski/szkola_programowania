package pl.coderslab.dao;

public class SolutionDao {

    private static final String CREATE_QUERY = "INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES (?, ?, ?, ?, ?)";
    private static final String READ_BY_ID_QUERY = "SELECT * FROM solution WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE solution SET created = ?, updated = ?, description = ?, exercise_id = ?, users_id = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM solution WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM solution";

    
}
