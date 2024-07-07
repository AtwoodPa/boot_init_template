package com.pp.boot.mapper.demo;

import com.pp.boot.model.entity.demo.InventoryApplication;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author panpan
 */
@Mapper
public interface InventoryMapper {
    
    void insertApplication(InventoryApplication application);

    InventoryApplication selectApplicationById(Long id);

    void updateApplication(InventoryApplication application);
}
