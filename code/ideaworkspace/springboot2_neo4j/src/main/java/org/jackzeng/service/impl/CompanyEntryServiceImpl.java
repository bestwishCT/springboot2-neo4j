package org.jackzeng.service.impl;


import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.jackzeng.domain.node.CompanyEntryNode;
import org.jackzeng.repository.CompanyEntryRepository;
import org.jackzeng.service.CompanyEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class CompanyEntryServiceImpl implements CompanyEntryService {

    @Autowired
    private CompanyEntryRepository companyEntryRepository;
    /**
     * 获取所有数据
     *
     * @return
     */
    @Override
    public List<CompanyEntryNode> getAll() {
        Iterable<CompanyEntryNode> all = companyEntryRepository.findAll();
        List<CompanyEntryNode> companyEntryNodes = Lists.newArrayList(all);
        return companyEntryNodes;
    }

    /**
     * 修改
     *
     * @param companyEntryNode
     */
    @Override
    public void modifyCompanyEntry(CompanyEntryNode companyEntryNode) {
        if(StringUtils.isEmpty(companyEntryNode.getUuid())){
            companyEntryNode.setUuid(UUID.randomUUID().toString());
        }
        companyEntryRepository.save(companyEntryNode);
    }

    /**
     * 删除
     *
     * @param companyId
     */
    @Override
    public void deleteById(String companyId) {
        companyEntryRepository.deleteById(companyId);
    }

    /**
     * 查询
     *
     * @param companyId
     * @return
     */
    @Override
    public CompanyEntryNode findById(String companyId) {
        Optional<CompanyEntryNode> byId = companyEntryRepository.findById(companyId);
        if (byId.isPresent()) {
            return byId.get();
        }
        return new CompanyEntryNode();
    }
}
