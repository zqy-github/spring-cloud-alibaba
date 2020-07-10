package com.yuoumall.push.center.service.imp;

import com.yuoumall.push.center.entity.bo.FI029.HeadReceipt;
import com.yuoumall.push.center.entity.bo.FI029.ItemReceipt;
import com.yuoumall.push.center.entity.bo.FI029.Receipt;
import com.yuoumall.push.center.entity.bto.FI029.FI029SCREQ;
import com.yuoumall.push.center.entity.bto.FI029.RqHttpReceipt;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yuoumall.push.center.mapper.ReceiptMapper;
import com.yuoumall.push.center.service.ReceiptService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZQY
 * @Date 2020/7/10
 * @Version 1.0
 * @Description 
 */
@Service
public class ReceiptServiceImpl implements ReceiptService{

    @Resource
    private ReceiptMapper receiptMapper;

    @Override
    public List<FI029SCREQ> selectFormatReceiptByStatusNo() {
        List<Receipt> receiptList = receiptMapper.selectFormatReceiptByStatusNo();
        List<FI029SCREQ> returnList = new ArrayList<>();
        if (receiptList.size() > 0) {
            receiptList.forEach(item -> {
                RqHttpReceipt receipt = new RqHttpReceipt();

                HeadReceipt headReceipt = new HeadReceipt();
                BeanUtils.copyProperties(item, headReceipt);
                receipt.setHead(headReceipt);

                List<ItemReceipt> itemReceiptList = new ArrayList<>();
                ItemReceipt itemReceipt = new ItemReceipt();
                BeanUtils.copyProperties(item, itemReceipt);
                itemReceiptList.add(itemReceipt);
                receipt.setItem(itemReceiptList);

                FI029SCREQ screq = new FI029SCREQ();
                screq.setDT_FI029_SC_REQ(receipt);

                returnList.add(screq);
            });
        }
        return returnList;
    }

    @Override
    public void updateReceiptStatusYes(Long id) {
        receiptMapper.updateReceiptStatusYes(id);
    }
}
