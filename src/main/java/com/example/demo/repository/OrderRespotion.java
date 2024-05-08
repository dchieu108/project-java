package com.example.demo.repository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Orders;
import com.example.demo.projection.IOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRespotion extends JpaRepository<Orders,Integer> {
    @Query(value = "SELECT DISTINCT\n" +
            "    o.ID AS orderid,\n" +
            "    o.IDORDERS AS ordernumber,\n" +
            "    o.ORDERS_DATE AS orderdate,\n" +
            "    o.TOTAL_MONEY AS totalmoney,\n" +
            "    o.NAME_RECIVER AS namereceiver,\n" +
            "    o.ADDRESS AS shippingaddress,\n" +
            "    o.STATUS AS status,\n" +
            "    o.PHONE AS shippingphone,\n" +
            "    o.NOTES AS ordernotes, " +
            "    pm.NAME AS paymentmethodname,\n" +
            "    tm.NAME AS transportmethodname,\n" +
            "    tm.PRICE AS transportmethodprice\n" +
            "FROM\n" +
            "    orders o\n" +
            "        JOIN\n" +
            "    orders_details od ON o.ID = od.IDORD\n" +
            "        JOIN\n" +
            "    product p ON od.IDPRODUCT = p.ID\n" +
            "        JOIN\n" +
            "    orders_payment op ON o.ID = op.IDORD\n" +
            "        JOIN\n" +
            "    payment_method pm ON op.IDPAYMENT = pm.ID\n" +
            "        JOIN\n" +
            "    orders_transport ot ON o.ID = ot.IDORD\n" +
            "        JOIN\n" +
            "    transport_method tm ON ot.IDTRANSPORT = tm.ID\n" +
            "WHERE\n" +
            "    o.ID = :orderId", nativeQuery = true)
    List<IOrders> findOrdersById(@Param("orderId") Integer orderId);
    @Query(value = "SELECT\n" +
            "    p.NAME AS productname,\n" +
            "    p.IMAGE AS productimage,\n" +
            "    p.PRICE AS productprice\n" +
            "FROM\n" +
            "    orders o\n" +
            "        JOIN\n" +
            "    orders_details od ON o.ID = od.IDORD\n" +
            "        JOIN\n" +
            "    product p ON od.IDPRODUCT = p.ID\n" +
            "WHERE\n" +
            "    o.ID = :orderId",nativeQuery = true)
    List<IOrders> findOrdersDetailsById(@Param("orderId") Integer orderId);

}
