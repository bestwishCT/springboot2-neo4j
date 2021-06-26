package org.jackzeng.controller;

import lombok.extern.slf4j.Slf4j;
import org.jackzeng.domain.node.CompanyEntryNode;
import org.jackzeng.service.CompanyEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "companyEntry")
@Slf4j
public class CompanyEntryController {

    @Autowired
    private CompanyEntryService companyEntryService;

    /**
     * 获取公司词条
     *
     * @return
     */
    @GetMapping(value = "getAll")
    public String getAll() {
        log.info("getAll->companyEntry");
        try {
            List<CompanyEntryNode> all = companyEntryService.getAll();
            CompanyEntryNode one=companyEntryService.findById("24afa970-e127-4386-b1a5-b611a41e560f");
            System.out.printf("=====");
        } catch (Exception e) {
            log.error("getAll error:{}", e);
        }
        return "hello neo4j";
    }

    /**
     * 新增节点
     * @param companyEntryNode
     * @return
     */
    @PostMapping(value = "save")
    public String save(@RequestBody CompanyEntryNode companyEntryNode) {
        log.info("save->companyEntryNode{}", companyEntryNode);
        try {
            companyEntryService.modifyCompanyEntry(companyEntryNode);
        } catch (Exception e) {
            log.error("save error:{}", e);
        }
        return "save successful";
    }
}
