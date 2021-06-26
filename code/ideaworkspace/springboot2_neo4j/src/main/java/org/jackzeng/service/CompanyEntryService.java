package org.jackzeng.service;

/**
 * service层我们开始定义查询和保存接口
 */

import org.jackzeng.domain.node.CompanyEntryNode;

import java.util.List;

public interface CompanyEntryService {
    /**
     * 获取所有数据
     *
     * @return
     */
    List<CompanyEntryNode> getAll();

    /**
     * 修改
     * @param companyEntryNode
     */
    void modifyCompanyEntry(CompanyEntryNode companyEntryNode);

    /**
     * 删除
     * @param companyId
     */
    void deleteById(String companyId);

    /**
     * 查询
     * @param companyId
     * @return
     */
    CompanyEntryNode findById(String companyId);
}
