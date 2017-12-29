package org.hameister.bulk.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by hameister on 27.12.17.
 */
@Service
public class ItemService {
    private ItemBulkImporterRepository itemBulkImporterRepository;

    @Autowired
    public ItemService(ItemBulkImporterRepository itemBulkImporterRepository) {
        Assert.notNull(itemBulkImporterRepository, "Repo must not be null");
        this.itemBulkImporterRepository = itemBulkImporterRepository;
    }

    public List<Item> getItems() {
        return StreamSupport.stream(itemBulkImporterRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Item> bulkImport(List<Item> itemPersistables) {
        return StreamSupport.stream(itemBulkImporterRepository.save(itemPersistables).spliterator(), false)
                .collect(Collectors.toList());
    }
}
