package com.pitaka.www.pitakaController;

import com.pitaka.www.model.User;
import com.pitaka.www.service.UserService;
import com.pitaka.www.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("v1/user/")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(value = "login" ,method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResultUtil login(User user) {
       User dbUser = userService.findByUsername(user.getUsername());
       if(dbUser == null){
           return new ResultUtil(500,"用户不存在！");
       }
       if(!dbUser.getPassword().equals(user.getPassword()) ){
           return new ResultUtil(403,"密码错误！");
       }
       Map<String,Object> map = new HashMap<>();
        dbUser.setPassword(null);
        map.put("token","123456789" );
        map.put("expirationTime",System.currentTimeMillis()+30*60);
        map.put("user",dbUser);
        return new ResultUtil().success(map);
    }

    public void test(){
        System.out.println("test...");
        System.out.println("test for brawforever");
        System.out.println("test conflict");
    }




}
