package software.jevera.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import software.jevera.domain.User;
import software.jevera.domain.dto.UserDto;
import software.jevera.service.UserService;

import javax.servlet.http.HttpSession;

@RestController("/api/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession httpSession;

    @PostMapping("/register")
    public User register(UserDto userDto){

        return userService.registerUser(userDto);

    }

    @PostMapping("/login")
    public User login(UserDto userDto){
        User user = userService.login(userDto);
        httpSession.setAttribute("user", user);
        return userService.login(userDto);

    }


}
