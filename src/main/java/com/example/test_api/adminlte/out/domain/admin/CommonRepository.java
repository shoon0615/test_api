package com.example.test_api.adminlte.out.domain.admin;

import com.example.test_api.util.domain.CommonD;
import com.example.test_api.util.domain.MasterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CommonRepository extends JpaRepository<CommonD, MasterId> {

    @Query(value = "select m.code_name, d.value as label, d.code as value "
            + "from tb_common_code_m m "
            + "inner join tb_common_code_d d on m.master_id = d.master_id and d.usedyn = 'Y' "
            + "where m.code_name in ('Sales Stage', 'Currency', 'Service')", nativeQuery = true)
    List<Map<String, Object>> findAllCommon();

}
