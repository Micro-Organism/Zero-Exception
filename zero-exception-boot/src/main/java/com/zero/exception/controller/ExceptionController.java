package com.zero.exception.controller;

import com.zero.exception.common.exception.BizException;
import com.zero.exception.common.model.SystemUserModel;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExceptionController {

    @PostMapping("/user")
    public boolean insert(@RequestBody SystemUserModel systemUserModel) {
        System.out.println("add...");
        if (systemUserModel.getName() == null) {
            throw new BizException("-1", "username is empty！");
        }
        return true;
    }

    @PutMapping("/user")
    public boolean update(@RequestBody SystemUserModel systemUserModel) {
        System.out.println("update...");
        //mock NullException
        String str = null;
        str.equals("111");
        return true;
    }

    @DeleteMapping("/user")
    public boolean delete(@RequestBody SystemUserModel systemUserModel) {
        System.out.println("delete...");
        //mock Exception
        Integer.parseInt("abc123");
        return true;
    }

}