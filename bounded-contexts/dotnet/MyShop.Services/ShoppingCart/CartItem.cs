using MyShop.Entities;
using System;
using System.Collections.Generic;
using System.Text;

namespace MyShop.Services.ShoppingCart
{
    public class CartItem
    {
        public CartItem(ItemId itemId, int quantity)
        {
            cartItemId = itemId.toCartItem();
            Quantity = quantity;
        }

        public CartItemId cartItemId { get; }
        public int Quantity { get; }
    }
}
