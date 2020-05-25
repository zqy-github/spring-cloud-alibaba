package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: ZQY
 * @Date: 2020/5/25 15:12
 * @Version: 1.0
 * @Description: 特别注意，该接口不能被扫描到，否则会出错
 **/
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
