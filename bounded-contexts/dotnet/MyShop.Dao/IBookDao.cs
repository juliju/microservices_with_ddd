using System;

namespace MyShop.Dao
{
    public interface IBookDao
    {
        Book find(ItemId itemId);
    }
}
