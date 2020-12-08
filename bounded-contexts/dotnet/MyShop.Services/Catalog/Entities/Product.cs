using System;
using System.Collections.Generic;
using System.Text;

namespace MyShop.Catalog.Entities
{
    public class Product
    {
        public string ean => default(string);
        public string DescriptionLong;
        public string Title;
    }
}
