package org.hameister.bulk.generator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by hameister on 27.12.17.
 */
@RestController
public class ItemController {

    private ItemService itemService;


    public ItemController(ItemService itemService) {
        Assert.notNull(itemService, "Service must not be null");
        this.itemService = itemService;
    }

    @GetMapping(value = "/items")
    public ResponseEntity<List<Item>> getItems() {
        return new ResponseEntity<List<Item>>(itemService.getItems(), HttpStatus.OK);
    }

    @GetMapping(value = "/generator")
    public ResponseEntity<List<Item>> importWithBulkService() {
        System.out.println("====> Generator Bulk import");
        return new ResponseEntity<>(itemService.bulkImport(createItemsWithoutId()), HttpStatus.CREATED);
    }
    private List<Item> createItemsWithoutId() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        List<Item> itemPersistables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Item itemPersistable = new Item();
            itemPersistable.setLocation("Board");
            itemPersistable.setDescription("Item " + i + "IT:" + date);
            itemPersistables.add(itemPersistable);
        }
        return itemPersistables;
    }
}
