package software.jevera.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.jevera.dao.jpa.UserRepository;
import software.jevera.domain.User;
import software.jevera.domain.dto.UserDto;
import software.jevera.exceptions.BusinessException;
import software.jevera.exceptions.EncryptRuntime;
import software.jevera.exceptions.Uncorrect;


import java.math.BigInteger;
import java.security.MessageDigest;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserDto userDto) {
        if (userRepository.findUserByLogin(userDto.getLogin()).isPresent()) {
            throw new BusinessException("Login already used");
        }

        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPasswordHash(encryptPassword(userDto.getPassword()));
        return userRepository.save(user);
    }

    private static String encryptPassword(String password) {

        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes(UTF_8));
            return new BigInteger(1, crypt.digest()).toString(16);
        } catch (Exception e) {
            throw new EncryptRuntime(e.getMessage());
        }

    }

    public User login(UserDto userDto) {
        return userRepository.findUserByLogin(userDto.getLogin())
                .filter(user -> checkPassword(userDto, user))
                .orElseThrow(Uncorrect::new);
    }

    private boolean checkPassword(UserDto userDto, User user) {
        String encryptPassword = encryptPassword(userDto.getPassword());
        return encryptPassword.equals(user.getPasswordHash());
    }

}
