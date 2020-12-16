package com.sap.cap.bookstore.handlers;

import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.ServiceName;

import org.springframework.stereotype.Component;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CdsService;

import com.sap.cds.services.persistence.PersistenceService;

import cds.gen.sap.capire.bookstore.Books;

import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.On;

@Component
@ServiceName("BooksService")
public class BooksService implements EventHandler {

    @Autowired
    PersistenceService db;

    @On(event = CdsService.EVENT_READ, entity = "BooksService.Books")
    public void onRead(CdsReadEventContext context) {
        // context.setResult(null);
    }

    @After(event ={ CdsService.EVENT_READ }, entity = "BooksService.Books")
    public void getMaintenanceOrderList(List<Books> items) {
        for(Books item : items){
            
            Integer stock = 1233;
            // CqnSelect selByOrderNum = Select.from(Books_.class).where(c -> c.orderNo().eq(orderNum));
            // Books Order =  db.run(selByOrderNum).single(Books.class);
            item.setStock(stock);
        
        }
    }
}