package com.itheima.mapper;

import com.itheima.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {

    @SelectKey(
            statement = "select orders_seq.nextval from dual",
            keyProperty = "id",
            before = true,
            resultType = Long.class
    )
    @Insert("insert into orders(id,orderNum,orderTime,peopleCount,orderDesc,payType,orderStatus,productId) values(#{id},#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{product.id})")
    int add(Orders order);

    @Results(
            value = {
                    @Result(column = "id", property = "id"),
                    @Result(column = "productname", property = "product.productName"),
                    @Result(column = "departuretime", property = "product.departureTime")
            }
    )
    @Select("select o.*, p.productName, p.departureTime from orders o, product p where o.productId=p.id")
    List<Orders> list();

    @Update("select * from orders where id=#{id}")
    int getOrder(Long id);

    @Update("update orders set orderNum=#{orderNum},orderTime=#{orderTime},peopleCount=#{peopleCount},orderDesc=#{orderDesc},payType=#{payType},orderStatus=#{orderStatus},productId=#{product.id} where id=#{id}")
    int update(Orders order);

    @Delete("delete from orders where id=#{id}")
    int delete(Long id);
}
