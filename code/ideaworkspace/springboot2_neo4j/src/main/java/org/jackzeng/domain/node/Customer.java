package org.jackzeng.domain.node;

import org.jackzeng.domain.BaseNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xijin.zeng created on 2018/6/8
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Customer extends BaseNode {
    private String name;
}
