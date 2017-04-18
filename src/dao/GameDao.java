package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import beans.Game;

@SuppressWarnings("deprecation")
public class GameDao {

	public static final String GAME_TABLE = "GAME";
	public static final String GAME_TITLE = "pk_title";
	public static final String GAME_CONSOLE = "fk_console";
	public static final String GAME_PRICE = "price";

	public static void insert(Game game) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Transaction transaction = null;
		Session session = sessionFactory.openSession();

		try {
			transaction = session.beginTransaction();
			session.save(game);
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}

		sessionFactory.close();
	}

	@SuppressWarnings("unchecked")
	public static List<Game> findAll() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		// List personnes = null;
		List<Game> dataBaseGames = new ArrayList<Game>();
		
		dataBaseGames = session.createCriteria(Game.class).list();
		
		session.close();
		sessionFactory.close();
		return dataBaseGames;
	}

	public static List<Game> findAllSQL() {

		List<Game> dataBaseGames = new ArrayList<Game>();
		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();
			// or Class.forName(com.mysql.jdbc.Driver.class.getName());

			String requeteSQL = "SELECT " + GAME_TITLE + "," + GAME_CONSOLE + "," + GAME_PRICE + " FROM " + GAME_TABLE;
			PreparedStatement ps = connection.prepareStatement(requeteSQL);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				dataBaseGames.add(new Game(resultSet.getString(GAME_TITLE), resultSet.getString(GAME_CONSOLE),
						resultSet.getDouble(GAME_PRICE)));
			}
			resultSet.close();
			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dataBaseGames;
	}

	public static Game findSQL(String name) {
		Game game = null;

		Connection connection = null;
		try {
			connection = ConnexionBDD.getInstance().getConnection();
			String requeteSQL = "SELECT " + GAME_TITLE + "," + GAME_CONSOLE + "," + GAME_PRICE + " FROM " + GAME_TABLE
					+ " WHERE " + GAME_TITLE + "=?";
			PreparedStatement ps = connection.prepareStatement(requeteSQL);
			ps.setString(1, name);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				game = new Game(resultSet.getString(GAME_TITLE), resultSet.getString(GAME_CONSOLE),
						resultSet.getDouble(GAME_PRICE));
			}
			resultSet.close();
			ConnexionBDD.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return game;
	}

}