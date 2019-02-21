package com.itheima.controller;

import com.itheima.domain.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/test")
    public String test() {
        System.out.println("我是Test");
        return "itemDetail";
    }

    @RequestMapping("/findDetail")
    public String findDetail(Model model){

        System.out.println("我被执行了！");

        Items byId = itemsService.findById(1);

        model.addAttribute("item" , byId);
        return "itemDetail";

    }
}
