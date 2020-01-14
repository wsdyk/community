package top.wsdyk.community.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.wsdyk.community.dto.QuestionDTO;
import top.wsdyk.community.mapper.QuestionMapper;
import top.wsdyk.community.mapper.UserMapper;
import top.wsdyk.community.model.Question;
import top.wsdyk.community.model.User;
import top.wsdyk.community.service.QuestionService;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper usermapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model){
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length!=0) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    User user = usermapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        List<QuestionDTO> questionDTOList = questionService.list();
        model.addAttribute("questionDTO",questionDTOList);
        return "index";
    }
}
