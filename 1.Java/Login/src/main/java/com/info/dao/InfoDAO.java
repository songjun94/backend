package com.info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.info.model.Info;
import com.info.utils.DBUtils;

// 'D'ata 'A'ccess 'O'bject, DB 접근을 담당하는 클래스
public class InfoDAO {

	private Info info;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;

	// 전체 Todo 조회 (try-catch, Java 7 이전 방식)
	public List<Info> findAll() {
		// SELECT Query
		final String selectQuery = "SELECT * FROM info";
		List<Info> infos = new ArrayList<>();

		try {
			// Java와 MySQL의 연결 통로(Connection) 생성, DB 커넥션 연결
			connection = DBUtils.getConnection();
			// 통로를 통해 SQL을 전달할 객체 Statement 생성, DB로의 Query 전달 객체
			statement = connection.createStatement();
			// 실제 Query 전달 및 수행(진행시켜)
			resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()) {
				Long info_number = resultSet.getLong("info_number");
				String name = resultSet.getString("name");
				Long age = resultSet.getLong("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				String phone = resultSet.getString("phone");
				String id = resultSet.getString("id");
				Long password = resultSet.getLong("password");
				boolean isCompleted = resultSet.getBoolean("is_completed");

				info = new Info(info_number, name, age, gender, address, phone, id, password, isCompleted);
				infos.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제, 마지막으로 생성된 순서부터 거꾸로 해제
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return infos;
	}

	public Info findByInfo_number(Long info_number) {
		// SELECT Query
		final String selectQuery = "SELECT * FROM info WHERE info_number = ?";

		// Java & MySQL 연결을 위한 Connection 생성
		try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement(connection, selectQuery, info_number);
				ResultSet resultSet = preparedStatement.executeQuery();) {
//			try()에서 () 내부에 작성할 수 있는 객체 혹은 인터페이스는 Autocloseable 인터페이스를 상속받은 것만 가능하다. 

			// 결과값(ResultSet) 맵핑
			while (resultSet.next()) {

				info = new Info.Builder(resultSet.getLong("info_number")).name(resultSet.getString("name"))
						.age(resultSet.getLong("age"))
						.gender(resultSet.getString("gender"))
						.address(resultSet.getString("address"))
						.phone(resultSet.getString("phone"))
						.id(resultSet.getString("id"))
						.password(resultSet.getLong("password"))
						.isCompleted(resultSet.getBoolean("is_completed"))
						.build();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	private PreparedStatement createPreparedStatement(Connection connection, String sql, Long info_number) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, info_number);
		return preparedStatement;
	}

	//Info 등록(INSERT)
	public int save(Info newInfo) {
		String insertQuery = "INSERT INTO info (name, age, gender, address, phone, id, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int affectedRows = 0;
		
		try(Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = createPreparedStatement(connection, insertQuery, newInfo);)
		{
			affectedRows = preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return affectedRows;
	}
	private PreparedStatement createPreparedStatement(Connection connection, String sql, Info info) throws SQLException {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, info.getName());
		preparedStatement.setLong(2, info.getAge());
		preparedStatement.setString(3, info.getGender());
		preparedStatement.setString(4, info.getAddress());
		preparedStatement.setString(5, info.getPhone());
		preparedStatement.setString(6, info.getId());
		preparedStatement.setLong(7, info.getPassword());
		
		return preparedStatement;
	}
//	public int updateById(Long todoNumber, Info newTodo) {
//        // String updateQuery = "UPDATE todo SET title = ?, description = ?, due_date =
//        String updateQuery = "UPDATE todo SET title = ?, description = ?, due_date = ?, is_completed = ? WHERE id = ?";
//        int affectedRows = 0;
//        try (Connection connection = DBUtils.getConnection();
//                PreparedStatement preparedStatement = createPreparedStatement(connection, updateQuery, todoNumber,
//                        newTodo);) {
//            affectedRows = preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return affectedRows;
//    }
//
//    private PreparedStatement createPreparedStatement(Connection connection, String sql, Long id, Info todo)
//            throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, todo.getTitle());
//        preparedStatement.setString(2, todo.getDescription());
//        preparedStatement.setString(3, todo.getDueDate().toString());
//        preparedStatement.setBoolean(4, todo.getIsCompleted());
//        preparedStatement.setLong(5, id);
//        return preparedStatement;
//    }
//
//    public int deleteById(Long todoNumber) {
//        String deleteQuery = "DELETE FROM todo WHERE id = ?";
//        int affectedRows = 0;
//        try (Connection connection = DBUtils.getConnection();
//                PreparedStatement preparedStatement = createPreparedStatement(connection, deleteQuery, todoNumber)) {
//            affectedRows = preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return affectedRows;
//    }
}
