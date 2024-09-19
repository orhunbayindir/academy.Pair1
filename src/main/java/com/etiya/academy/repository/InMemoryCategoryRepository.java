//package com.etiya.academy.repository;
//
//import com.etiya.academy.entity.Category;
//import com.etiya.academy.entity.Product;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class InMemoryCategoryRepository  implements CategoryRepository{
//    List<Category> categories = new ArrayList<>();
//    int id=0;
//    @Override
//    public List<Category> getAll() {
//        return categories;
//    }
//
//    @Override
//    public Category add(Category category) {
//        id++;
//        category.setId(id);
//        categories.add(category);
//        return category;
//    }
//
//    @Override
//    public void delete(int id) {
//        for(Category nCategory:categories){
//            if (nCategory.getId()==id){
//                categories.remove(nCategory);
//                break;
//            }
//        }
//
//    }
//
//    @Override
//    public Category update(Category category, int id) {
//        for(Category nCategory:categories){
//            if (nCategory.getId()==id){
//                nCategory.setName(category.getName());
//                return nCategory;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Category getById(int id) {
//        for(Category category:categories){
//            if (category.getId()==id){
//                return category;
//            }
//        }
//        return null;
//    }
//}
