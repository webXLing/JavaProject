package com.xl.missyou.service;


import com.xl.missyou.model.GridCategory;
import com.xl.missyou.repository.GridCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridCategoryService {

    @Autowired
   private GridCategoryRepository gridCategoryRepository;

   public List<GridCategory> getAll(){
       return gridCategoryRepository.findAll();
   }
}
