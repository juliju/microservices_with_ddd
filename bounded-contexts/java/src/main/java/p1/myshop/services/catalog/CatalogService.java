package p1.myshop.services.catalog;

import p1.myshop.dao.BookDAO;
import p1.myshop.dao.DvdDAO;
import p1.myshop.entities.Item;
import p1.myshop.entities.ItemId;

public class CatalogService {
    private BookDAO bookDao;
    private DvdDAO dvdDao;

    public Item loadItem(ItemId itemId) {
        Item item1 = bookDao.find(itemId);
        Item item2 = dvdDao.find(itemId);

        if (item1 == null) {
            return item2;
        }

        return item1;
    }
}
