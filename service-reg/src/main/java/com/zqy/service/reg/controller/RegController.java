package com.zqy.service.reg.controller;

import com.zqy.commons.base.AbstractBaseController;
import com.zqy.commons.domain.Account;
import com.zqy.commons.mapper.AccountMapper;
import com.zqy.commons.service.AccountService;
import com.zqy.commons.utils.AbstractBaseResult;
import com.zqy.commons.utils.BaseResultFactory;
import com.zqy.commons.validator.BeanValidator;
import com.zqy.service.reg.controller.service.Regsercvice;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ZQY
 * @Date: 2020/5/27 14:17
 * @Version: 1.0
 * @Description:
 **/
@RestController
@RequestMapping(value = "reg")
public class RegController extends AbstractBaseController<Account> {
    @Autowired
    private AccountService accountService;

//    @Autowired
//    private Regsercvice regsercvice;

    /**
     * 注册验证格式
     *
     * @param account
     * @return
     */
    @PostMapping(value = "")
    public AbstractBaseResult reg(Account account) {
        String message = BeanValidator.validator(account);
        if (StringUtils.isNotBlank(message)) {
            return error(message, null);
        }
        // 验证用户名是否重复
        if (!accountService.unique("username", account.getUserName())) {
            return error("用户名重复，请重试", null);
        }

        // 验证邮箱是否重复
        if (!accountService.unique("email", account.getEmail())) {
            return error("邮箱重复，请重试", null);
        }

        // 注册用户
        account.setPassword(DigestUtils.md5DigestAsHex(account.getPassword().getBytes()));
        Account user = accountService.save(account);
        if (user != null) {
//            regsercvice.sendEmail(account);
            response.setStatus(HttpStatus.CREATED.value());
            return success(request.getRequestURI(), user);
        }

        // 注册失败
        return error("注册失败，请重试", null);
    }
}
