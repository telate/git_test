package com.itcast.controller;

import com.itcast.domian.Account1;
import com.itcast.service.AccountService;
import com.itcast.service.impl.ImplAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户web
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private ImplAccountService implAccountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有的账户信息");
        List<Account1> list = implAccountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    /**
     * 保存
     * @param
     * @return
     */
    @RequestMapping("/save")
    public void save(Account1 account1, HttpServletRequest request, HttpServletResponse response) throws IOException {
    implAccountService.saveAccount(account1);
    response.sendRedirect(request.getContextPath()+"/user/findAll");
    return;
    }
}
