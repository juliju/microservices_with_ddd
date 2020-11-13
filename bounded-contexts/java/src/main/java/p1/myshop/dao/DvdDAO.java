package p1.myshop.dao;

import p1.myshop.entities.Dvd;
import p1.myshop.entities.ItemId;

public interface DvdDAO {
    Dvd find(ItemId itemId);
}
