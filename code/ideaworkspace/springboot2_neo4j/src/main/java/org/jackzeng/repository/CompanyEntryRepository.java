package org.jackzeng.repository;
/**
 * dao层和我们mybatis很像 定义一个类 继承 Neo4jRepository<T,E>,
 * 这里的E就是你的主键id的类型；Neo4jRepository<T,E> 这里默认有很多实现对neo4j的操作，比如save,delete,find等，大家自行查看
 *
 * 接口里我们定义了一个existsByCompanyId的方法注解是@Query；
 * 里边内容就涉及到Cypher语法,我们在后续文章中详细讲解，这里就只需要理解根据companyId查询CompanyEntry的名字
 */

import org.jackzeng.domain.node.CompanyEntryNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyEntryRepository extends Neo4jRepository<CompanyEntryNode, String> {
    /**
     * 根据公司id判断 公司是否已经存在
     *
     * @param companyId
     * @return
     */
    @Query("match(n:CompanyEntry{companyId:{companyId}}) return n.name")
    String existsByCompanyId(String companyId);

}