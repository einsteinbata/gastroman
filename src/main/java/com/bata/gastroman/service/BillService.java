package com.bata.gastroman.service;

import com.bata.gastroman.entity.Bill;
import com.bata.gastroman.entity.Order;
import com.bata.gastroman.exceptions.BillCreationException;
import com.bata.gastroman.exceptions.BillOperationException;
import com.bata.gastroman.exceptions.UnavailableTableException;

import java.math.BigDecimal;
import java.util.List;

public interface BillService {
    public Bill startBill(int table) throws BillCreationException, UnavailableTableException;
    public Bill getBill(Long billId) throws BillOperationException;
    public Bill addToBill(Long billId, Order order) throws BillOperationException;
    public Bill removeFromBill(Long billId, Long orderId) throws BillOperationException;
    public BigDecimal getTotal(Bill bill);
    public Bill closeBill(Long billId) throws BillOperationException;
    public List<Bill> getAllOpenBills() throws BillOperationException;
}
