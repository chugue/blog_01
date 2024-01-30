package shop.mtcoding.blog.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private final UserRepository userRepository;
    private final HttpSession session;

    public UserController(UserRepository userRepository, HttpSession session) {
        this.userRepository = userRepository;
        this.session = session;
    }

    @PostMapping("/login")
    public String login(UserRequest.LoginDTO requestDTO) {
        if (requestDTO.getUsername().length() < 3) {
            return "error/400";
        }
        User user = userRepository.findByUsernameAndPassword(requestDTO);

        if (user == null) {
            return "error/401";
        } else {
            session.setAttribute("sessionUser", user);
            return "redirect:/";
        }
    }


    @PostMapping("/join")
    public String join(UserRequest.JoinDTO requestDTO) {
        System.out.println(requestDTO);

        if (requestDTO.getUsername().length() < 3) {
            System.out.println("안되나??");
            return "error/400";
        } else if (requestDTO.getPassword().length() > 40) {
            return "error/400";
        } else {
            userRepository.save(requestDTO);
            return "redirect:/loginForm";
        }
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
