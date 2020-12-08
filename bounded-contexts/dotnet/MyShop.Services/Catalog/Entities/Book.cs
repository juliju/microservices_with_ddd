using MyShop.Entities;

namespace MyShop.Catalog.Entities
{
    public class Book : Product
    {
        public ItemId ItemId => default(ItemId);
        public string ean => default(string);
    }
}
