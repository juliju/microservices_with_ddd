using System;
using System.Collections.Generic;
using System.Text;

namespace MyShop.Dao
{
    public interface IDvdDao
    {
        Dvd find(ItemId itemId);
    }
}
