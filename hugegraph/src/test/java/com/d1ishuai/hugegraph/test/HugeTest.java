package com.d1ishuai.hugegraph.test;

import com.baidu.hugegraph.driver.GraphManager;
import com.baidu.hugegraph.driver.GremlinManager;
import com.baidu.hugegraph.driver.HugeClient;
import com.baidu.hugegraph.driver.SchemaManager;
import com.baidu.hugegraph.structure.constant.T;
import com.baidu.hugegraph.structure.graph.Edge;
import com.baidu.hugegraph.structure.graph.Path;
import com.baidu.hugegraph.structure.graph.Vertex;
import com.baidu.hugegraph.structure.gremlin.Result;
import com.baidu.hugegraph.structure.gremlin.ResultSet;
import com.baidu.hugegraph.structure.schema.VertexLabel;
import com.di1shuai.hugegraph.HugegraphApplication;
import com.di1shuai.hugegraph.domain.RelationshipData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author shea
 * @since 2022/2/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HugegraphApplication.class)
public class HugeTest {

    @Autowired
    HugeClient hugeClient;


    /**
     * 属性
     */
    @Test
    public void propertyTest() {
        SchemaManager schema = hugeClient.schema();
        schema.propertyKey("uid").asText().ifNotExist().create();
        schema.propertyKey("name").asText().ifNotExist().create();
        schema.propertyKey("phone").asText().ifNotExist().create();
        schema.propertyKey("type").asText().ifNotExist().create();
        schema.propertyKey("businessTime").asDate().ifNotExist().create();
        schema.propertyKey("ctime").asDate().ifNotExist().create();
        schema.propertyKey("businessRelationship").asText().ifNotExist().create();
    }

    /**
     * 顶点
     */
    @Test
    public void vertexTest() {
        SchemaManager schema = hugeClient.schema();

        schema.vertexLabel("person")
                .properties("uid","name", "phone", "type")
                .primaryKeys("uid")
                .ifNotExist()
                .create();
    }

    /**
     * 索引
     */
    @Test
    public void indexTest() {
        SchemaManager schema = hugeClient.schema();
        schema.indexLabel("personByCity")
                .onV("person")
                .by("city")
                .secondary()
                .ifNotExist()
                .create();

        schema.indexLabel("personByAgeAndCity")
                .onV("person")
                .by("age", "city")
                .secondary()
                .ifNotExist()
                .create();

        schema.indexLabel("softwareByPrice")
                .onV("software")
                .by("price")
                .range()
                .ifNotExist()
                .create();
    }

    /**
     * 边
     */
    @Test
    public void edgeTest() {
        SchemaManager schema = hugeClient.schema();

        schema.edgeLabel("relationship")
                .sourceLabel("person")
                .targetLabel("person")
                .properties("businessRelationship","ctime", "businessTime")
                .ifNotExist()
                .create();
    }


    /**
     * 添加顶点数据与边数据并查询
     */
    @Test
    public void addVEtest(){
        GraphManager graph = hugeClient.graph();
        RelationshipData relationshipData = new RelationshipData()
                .setPerson1Id("1")
                .setPerson1Name("小王")
                .setPerson1Phone("133")
                .setPerson1Type("客户")
                .setPerson2Id("2")
                .setPerson2Name("小张")
                .setPerson2Phone("188")
                .setPerson2Type("员工")
                .setCtime(new Date())
                .setBusinessTime(new Date())
                .setRelationship("夫妻");


        Vertex p1 = graph.addVertex(T.label, "person",
                "uid", relationshipData.getPerson1Id(),
                "name", relationshipData.getPerson1Name(),
                "phone", relationshipData.getPerson1Phone(),
                "type", relationshipData.getPerson1Type());
        Vertex p2 = graph.addVertex(T.label, "person",
                "uid", relationshipData.getPerson2Id(),
                "name", relationshipData.getPerson2Name(),
                "phone", relationshipData.getPerson2Phone(),
                "type", relationshipData.getPerson2Type());
        p1.addEdge("relationship", p2,
                "businessRelationship",relationshipData.getRelationship(),
                "ctime", relationshipData.getCtime(),
                "businessTime", relationshipData.getBusinessTime());
    }

    /**
     * 查询
     */
    @Test
    public void queryTest(){
        GremlinManager gremlin = hugeClient.gremlin();
        ResultSet resultSet = gremlin.gremlin("g.V().outE().path()").execute();
        Iterator<Result> results = resultSet.iterator();
        results.forEachRemaining(result -> {
            System.out.println(result.getObject().getClass());
            Object object = result.getObject();
            if (object instanceof Vertex) {
                System.out.println(((Vertex) object).id());
            } else if (object instanceof Edge) {
                System.out.println(((Edge) object).id());
            } else if (object instanceof Path) {
                List<Object> elements = ((Path) object).objects();
                elements.forEach(element -> {
                    System.out.println(element.getClass());
                    System.out.println(element);
                });
            } else {
                System.out.println(object);
            }
        });
    }

}
