using MyShop.Entities;

namespace MyShop.Catalog.Entities
{
    public class Dvd : Product
    {
        public ItemId ItemId => default(ItemId);
        public string ean => default(string);
        public double Weight => default(double);
    }
}
