using System;
using System.Collections.Generic;
using System.Text;

namespace MyShop.Entities
{
    public class Book : IItem
    {
        public ItemId ItemId => default(ItemId);
        public string ean => default(string);
        public double Weight => default(double);
    }
}
