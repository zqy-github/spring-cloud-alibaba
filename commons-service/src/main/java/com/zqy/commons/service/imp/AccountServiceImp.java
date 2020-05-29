package com.zqy.commons.service.imp;

import com.zqy.commons.domain.Account;
import com.zqy.commons.mapper.AccountMapper;
import com.zqy.commons.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @Author: ZQY
 * @Date: 2020/5/28 15:41
 * @Version: 1.0
 * @Description:
 **/
@Service
public class AccountServiceImp extends BaseCrudServiceImpl<Account, AccountMapper> implements AccountService {
}
