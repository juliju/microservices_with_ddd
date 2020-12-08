using MyShop.Entities;
using System;

namespace MyShop.Services
{
    public interface ICatalogService
    {
        public IItem LoadItem(ItemId itemId);
    }
}
