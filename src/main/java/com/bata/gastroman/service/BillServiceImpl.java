package com.bata.gastroman.service;

import com.bata.gastroman.constants.BillState;
import com.bata.gastroman.entity.Bill;
import com.bata.gastroman.entity.Order;
import com.bata.gastroman.exceptions.BillCreationException;
import com.bata.gastroman.exceptions.BillOperationException;
import com.bata.gastroman.exceptions.UnavailableTableException;
import com.bata.gastroman.repository.bill.BillRepository;
import lombok.AllArgsConstructor;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@AllArgsConstructor
public class BillServiceImpl implements BillService {

    private BillRepository billRepository;

    @Override
    public Bill startBill(int table) throws BillCreationException, UnavailableTableException {
        Bill newBill;
        List<Bill> openBills;

        try{
//            openBills = billRepository.getAllOpenBills();
            openBills = billRepository.findAll();

            for(Bill openBill : openBills){
                if(openBill.getTable() == table){
                    throw new UnavailableTableException(table);
                }
            }

            try{
                newBill = new Bill();
                newBill.setTable(table);
                newBill.setOpeningDate(new Date());
                newBill.setState(BillState.OPEN.name());

//                billRepository.saveBill(newBill);
                newBill = billRepository.save(newBill);
            } catch (HibernateException erro){
                System.err.println(erro.getMessage());
                throw new BillCreationException(erro);
            }

        } catch (UnavailableTableException erro) {
            System.out.println(erro);
            throw erro;
        } catch (BillCreationException erro) {
            System.out.println(erro);
            throw erro;
        }

        return newBill;
    }

    @Override
    public Bill getBill(Long billId) throws BillOperationException {
        Bill bill;

        try {
//            bill = billRepository.getBill(billId);
            Optional<Bill> billOpt = billRepository.findById(billId);
            if(!billOpt.isPresent()) throw new BillOperationException("Bill [" + billId + "] not found.");
            bill = billOpt.get();
        } catch (HibernateException erro) {
            System.out.println(erro);
            throw new BillOperationException(erro);
        }

        return bill;
    }

    @Override
    public Bill addToBill(Long billId, Order order) throws BillOperationException {
        Bill bill;
        try {

            bill = billRepository.findById(billId).orElse(null);

            if(Objects.isNull(bill)) throw new BillOperationException("Bill [" + billId + "] was not found.");

// TODO uncomment           if(bill.getOrders() == null) bill.setOrders(new ArrayList<>());

//            bill.getOrders().add(new Gson().toJson(order));
            bill.getOrders().add(order);


            bill = billRepository.save(bill);

        } catch (HibernateException erro){
            System.out.println(erro);
            throw new BillOperationException(erro);
        }
        return bill;
    }

    @Override
    public Bill removeFromBill(Long billId, Long orderId) throws BillOperationException {
        Bill bill;
        try {

            bill = billRepository.findById(billId).orElse(null);

            if(Objects.isNull(bill)) throw new BillOperationException("Bill [" + billId + "] was not found.");

//            for(String orderJson : bill.getOrders()){
            for(Order order : bill.getOrders()){
//                Order order = new Gson().fromJson(orderJson, Order.class);

                if(order.getOrderId() == orderId){
                    bill.getOrders().remove(order);
                    System.out.println("Order removed from bill [" + billId + "]");
                }
            }

            bill = billRepository.save(bill);

        } catch (HibernateException erro){
            System.out.println(erro);
            throw new BillOperationException(erro);
        }
        return bill;
    }

    @Override
    public Bill closeBill(Long billId) throws BillOperationException {
        Bill bill;
        BigDecimal billTotal;

        try {
            System.out.println("Getting Bill [" + billId + "]");

            bill = billRepository.findById(billId).orElse(null);

            if(Objects.isNull(bill)) throw new BillOperationException("Bill [" + billId + "] was not found.");

            bill.setTotal(getTotal(bill));
            bill.setState(BillState.CLOSED.name());

            bill = billRepository.save(bill);

        } catch (HibernateException erro) {
            System.out.println(erro);
            throw new BillOperationException(erro);
        }
        return bill;
    }

    @Override
    public BigDecimal getTotal(Bill bill){
        BigDecimal totalAmount = BigDecimal.ZERO;

//        for(String orderJson : bill.getOrders()){
        for(Order order : bill.getOrders()){

//            Order order = new Gson().fromJson(orderJson, Order.class);

//  TODO UNCOMMENT          BigDecimal unitPrice = order.getMenuItem().getUnitPrice();
            int quantity = order.getQuantity();

//  TODO UNCOMMENT          BigDecimal itemTotalAmount = unitPrice.multiply(new BigDecimal(quantity));
//            totalAmount = totalAmount.add(itemTotalAmount);
        }

        return totalAmount;
    }

    @Override
    public List<Bill> getAllOpenBills() throws BillOperationException {
        List<Bill> openBills;

        try{
            openBills = billRepository.findAll();
        } catch (HibernateException erro) {
            System.out.println(erro);
            throw new BillOperationException(erro);
        }

        return openBills;
    }

}
