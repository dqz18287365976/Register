package tedu.cs_mall.controller;

//import org.apache.catalina.User;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tedu.cs_mall.mapper.UserMapper;
import tedu.entity.Users;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserConttroller {
    @Autowired
    UserMapper mapper;

    @RequestMapping("/register")
    public int register(@RequestBody Users users){
        Users reg= (Users) mapper.selectByName(users.getUsername());
        if (reg==null){
            mapper.addUser(users);
            return 2;
        }else {
            return 1;
        }
    }

    @RequestMapping("/login")
    public int login(@RequestBody Users users, HttpSession session){
        System.out.println(users.getUsername()+","+users.getPassword());
        Users u = mapper.selectByName(users.getUsername());

        if (u == null){
            return 1;
        }else{
            if (users.getPassword().equals(u.getPassword())){
                session.setAttribute( "u",u);
                return 2;
            }else{
                return 3;
            }
        }
        }

}
