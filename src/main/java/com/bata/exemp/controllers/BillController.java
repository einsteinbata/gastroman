package com.bata.exemp.controllers;

import com.bata.exemp.entity.Bill;
import com.bata.exemp.entity.Order;
import com.bata.exemp.exceptions.BillCreationException;
import com.bata.exemp.exceptions.BillOperationException;
import com.bata.exemp.exceptions.UnavailableTableException;
import com.bata.exemp.service.BillService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/bill")
public class BillController {

    private BillService billService;

    @GetMapping(value = "/start")
    public ResponseEntity<Bill> startBill(@RequestParam(value = "table") int table){
        Bill bill;

        try {
            bill = billService.startBill(table);

        } catch (BillCreationException erro) {
            bill = new Bill();
            return new ResponseEntity<>(bill, erro.getStatus());

        } catch (UnavailableTableException erro) {
            bill = new Bill();
            return new ResponseEntity<>(bill, erro.getStatus());
        }

        return ResponseEntity.ok().body(bill);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Bill> addOrder(@RequestBody Order order, @PathParam(value = "billId") Long billId){
        Bill bill;

        try{
            bill = billService.addToBill(billId, order);
        } catch (BillOperationException erro) {
            System.out.println(erro);
            bill = new Bill();
            return new ResponseEntity<>(bill, erro.getStatus());
        }

        return ResponseEntity.ok(bill);
    }

    @GetMapping(value = "/remove")
    public ResponseEntity<Bill> removeOrderFromBill(@RequestParam(value = "billId") Long billId, @RequestParam(value = "orderId") Long orderId) {
        Bill bill;

        try{
            bill = billService.removeFromBill(billId, orderId);
        } catch (BillOperationException erro) {
            bill = new Bill();
            return new ResponseEntity<>(bill, erro.getStatus());
        }

        return ResponseEntity.ok(bill);
    }

    @GetMapping("/get")
    public ResponseEntity<Bill> getBill(@RequestParam(value = "billId") Long billId){
        Bill bill;
        try {
            bill = billService.getBill(billId);
        } catch (BillOperationException erro) {
            bill = new Bill();
            return new ResponseEntity<>(bill, erro.getStatus());
        }

        return ResponseEntity.ok().body(bill);
    }

    @GetMapping("/close")
    public ResponseEntity<Bill> closeBill(@RequestParam(value = "billId") Long billId){
        Bill bill;

        try{
            bill = billService.closeBill(billId);
        } catch (BillOperationException erro) {
            bill = new Bill();
            return new ResponseEntity<>(bill, erro.getStatus());
        }

        return ResponseEntity.ok().body(bill);
    }

    @GetMapping("/getAllOpen")
    public ResponseEntity<List<Bill>> getAllOpenBills(){
        List<Bill> openBills;

        try{
            openBills = billService.getAllOpenBills();
        } catch (BillOperationException erro) {
            openBills = new ArrayList<>();
            return new ResponseEntity<>(openBills, erro.getStatus());
        }

        return ResponseEntity.ok().body(openBills);
    }

}
