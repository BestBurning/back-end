package com.di1shuai.hugegraph.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author shea
 * @since 2022/2/19
 */
@Data
@Accessors(chain = true)
public class RelationshipData {

    private String person1Id;
    private String person1Name;
    private String person1Phone;
    private String person1Type;
    private String person2Id;
    private String person2Name;
    private String person2Phone;
    private String person2Type;

    private String relationship;
    private Date ctime;
    private Date businessTime;

}
