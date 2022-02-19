package com.di1shuai.hugegraph.controller;

import com.baidu.hugegraph.driver.GremlinManager;
import com.baidu.hugegraph.driver.HugeClient;
import com.baidu.hugegraph.structure.gremlin.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author shea
 * @since 2022/2/19
 */
@RestController
@RequestMapping("/r")
public class RelationshipDataController {

    @Autowired
    HugeClient hugeClient;


    @GetMapping("/path")
    public ResultSet  path(){
        GremlinManager gremlin = hugeClient.gremlin();
        ResultSet resultSet = gremlin.gremlin("g.V().outE().path()").execute();
        return resultSet;
    }



}
