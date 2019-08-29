package com.restaurant.controller;

import com.restaurant.entity.Account;
import org.apache.bval.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.restaurant.service.IAccountService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = {"*", "null"})
@Controller
public class AccountController {
    @Autowired
    private IAccountService IAccountServiceImpl;

    @RequestMapping("/login.action")
    public String login( Model model,@Validate Account account,BindingResult br){


        if(br.hasErrors()){
            //有错误
            FieldError uerror = br.getFieldError("accountname");
            FieldError perror = br.getFieldError("accounpwd");
            System.out.println(uerror);
            System.out.println(perror);
            return "login2.jsp";
       }else{
            Account account2 = IAccountServiceImpl.login(account.getAccountname(), account.getAccountpwd());
            if(account2 == null){
                model.addAttribute("msg", "用户名或者密码错误");
                return "login2.jsp";
            }else{
                //没有错误
                return "index.jsp";
            }
       }
    }
}
