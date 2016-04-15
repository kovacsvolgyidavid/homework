package xyz.codingmentor.training.services;

import xyz.codingmentor.training.dtos.UserDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@Singleton
@Startup
public class UserManagmentService {

    private final Map<String, UserDTO> users = new HashMap<>();

    @PostConstruct
    private void addUsersBeforeLaunch() {
        UserDTO admin;
        admin = new UserDTO("admin", "admin", "David",
                "Kovacsvolgyi", LocalDate.of(1990, 9, 5), LocalDate.now(), true);
        UserDTO defaultUser = new UserDTO("user", "user", "Gergo",
                "Somfai", LocalDate.of(1991, 10, 5), LocalDate.now(), false);

        users.put(admin.getUsername(), admin);
        users.put(defaultUser.getUsername(), defaultUser);
    }

    public UserDTO addUser(UserDTO user) {
        if (users.containsKey(user.getUsername())) {
            throw new IllegalArgumentException("We already have a user with this username");
        }
        user.setRegistrationDate(LocalDate.now());
        users.put(user.getUsername(), user);
        return user;
    }

    public UserDTO removeUser(UserDTO user) {
        if (!users.containsKey(user.getUsername())) {

            throw new IllegalArgumentException("We don't have this user");

        }

        return users.remove(user.getUsername());
    }

    public UserDTO editUser(UserDTO newUser, UserDTO oldUser) {
        if (!oldUser.getUsername().equals(newUser.getUsername())) {
            throw new IllegalArgumentException("You try to manipulate wrong user");
        } else if (users.replace(oldUser.getUsername(), oldUser, newUser)) {
            return oldUser;

        } else {
            throw new IllegalArgumentException("UserEntry ERROR: oldUser is not the same we had before with this username");

        }

    }

    public UserDTO getUser(String username) {
        if (!users.containsKey(username)) {
            throw new IllegalArgumentException("There is no user with this name");
        }
        return users.get(username);

    }

    public List<UserDTO> getUsers() {
        List<UserDTO> usersRET = new ArrayList<>();
        for (String username : users.keySet()) {
            usersRET.add(users.get(username));

        }
        return usersRET;
    }

    public UserDTO getUser(UserDTO user) {
        return getUser(user.getUsername());
    }

}
