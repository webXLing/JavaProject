package com.xl.missyou.service;

import com.xl.missyou.model.Category;
import com.xl.missyou.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Map<Integer, List<Category>> getAll(){
        List<Category> isRoots = categoryRepository.findAllByIsRootOrderByIndexAsc(true);
        List<Category> isSubs = categoryRepository.findAllByIsRootOrderByIndexAsc(false);
        HashMap<Integer, List<Category>> integerListHashMap = new HashMap<>();
        integerListHashMap.put(1,isRoots);
        integerListHashMap.put(2,isSubs);
        return integerListHashMap;
    }
}
