package p1.myshop.catalog.services;

import p1.myshop.catalog.dao.BookDAO;
import p1.myshop.catalog.dao.DvdDAO;
import p1.myshop.catalog.entities.Item;
import p1.myshop.shoppingcart.entities.ItemId;

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
