package org.hameister.bulk.generator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hameister on 27.12.17.
 */
@Repository
public interface ItemBulkImporterRepository extends CrudRepository<Item, String> {
}