package com.pp.boot.mapper;

import com.pp.boot.domain.wms.InventoryApplication;
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
