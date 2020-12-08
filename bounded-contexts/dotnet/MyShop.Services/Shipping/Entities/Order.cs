using MyShop.Services.ShoppingCart;
using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;

namespace MyShop.Services.Shipping
{
    public class Order
    {
        public Order(IEnumerable<OrderLine> items)
        {
            Items = items;
        }

        private IEnumerable<OrderLine> Items { get; }

        public IEnumerable<OrderLine> GetItems() => Items;
    }
}
