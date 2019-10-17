package dao;

import model.Language;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class UserDao {

    private List<Language> users = Arrays.asList(
            new Language(0, "KOTLIN"),
            new Language(1, "JAVA"),
            new Language(2, "JAVASCRIPT"),
            new Language(3, "NODE")
    );

    private static UserDao userDao = null;

    private UserDao() {
    }

    public static UserDao instance() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public Optional<Language> getUserById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findAny();
    }

    public List<Language> getAllUsernames() {
        return users;
    }
}
