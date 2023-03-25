package cn.itcast.hotel;

import cn.itcast.hotel.constant.RequestConstant;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.engine.Engine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author Jmd
 * @create 2023-03-2023/3/24-20:03
 * @Description：
 */
public class RestClientTests {

    private RestHighLevelClient client;

    @BeforeEach
    public void Init(){
        RestHighLevelClient highLevelClient = new RestHighLevelClient(RestClient.builder(HttpHost.create("http://192.168.153.128:9200")));
        client = highLevelClient;
    }

    @Test
    public void testCreate() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("hotel");
        createIndexRequest.source(RequestConstant.index, XContentType.JSON);
        client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
    }

    @Test
    public void testDelete() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("hotel");
        client.indices().delete(deleteIndexRequest,RequestOptions.DEFAULT);
    }

    @Test
    public void testExists() throws IOException {
        GetIndexRequest hotel = new GetIndexRequest("hotel");
        boolean exists = client.indices().exists(hotel,RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    @AfterEach
    public void tearDown() throws IOException {
        client.close();
    }
}
