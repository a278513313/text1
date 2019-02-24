package com.itheima.mapper;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.sun.glass.ui.Size;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {

    @Select("select * from product")
    List<Product> list();

    @SelectKey(
            statement = "select product_seq.nextval from dual",
            keyProperty = "id",
            before = true,
            resultType = Integer.class
    )
    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    int add(Product product);

    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    int update(Product product);

    @Select("select * from product where id=#{id}")
    Product getProduct(Integer id);

    @Delete("delete from product where id=#{id}")
    int delete(Integer id);
}
