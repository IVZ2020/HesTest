package test.hes.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.hes.demo.entity.Role;
import test.hes.demo.entity.Status;
import test.hes.demo.entity.UserAccount;
import test.hes.demo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DateService dateService;

    public void createUser (UserAccount user) {
        user.setRole(Role.USER);
        user.setSt(Status.ACTIVE);
        user.setCreatedAt(dateService.getCurrentDate());
        userRepository.save(user);
    }

    public List<UserAccount> getAll () {
        return userRepository.findAll();
    }

    public UserAccount getUserById (long id) {
        return userRepository.getById(id);
    }

    public void updateUserById (long id, UserAccount editableUser) {
        UserAccount userById = userRepository.getById(id);
        userById.setFirstName(editableUser.getFirstName());
        userById.setLastName(editableUser.getLastName());
        userById.setUsername(editableUser.getUsername());
        userById.setPassword(editableUser.getPassword());
        userById.setRole(editableUser.getRole());
        userById.setSt(editableUser.getSt());
        userRepository.save(userById);
    }
}
