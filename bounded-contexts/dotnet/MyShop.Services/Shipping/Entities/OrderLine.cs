using MyShop.Services.ShoppingCart;
using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;

namespace MyShop.Services.Shipping
{
    public class OrderLine
    {
        public OrderLine(ItemId itemId, int quantity)
        {
            cartItemId = itemId.toCartItem();
            Quantity = quantity;
        }

        public OrderLineId orderLineId { get; }//mettre un id ici
        public int Quantity { get; }
    }
}
